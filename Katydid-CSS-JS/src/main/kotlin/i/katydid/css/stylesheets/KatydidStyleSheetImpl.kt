//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.css.stylesheets

import o.katydid.css.styles.builders.KatydidStyleBuilderDsl
import o.katydid.css.stylesheets.*

//---------------------------------------------------------------------------------------------------------------------

/**
 * Represents a CSS style sheet with SASS-like provisions to build style rules from string selectors and
 * styles.
 */
@KatydidStyleBuilderDsl
internal class KatydidStyleSheetImpl
    : KatydidCompositeCssRuleImpl(), KatydidStyleSheet {

    override val fullSelectors: List<String> = emptyList()

    override val nestedRules: MutableList<KatydidCssRule> = mutableListOf()

    override val parent: KatydidCompositeCssRuleImpl
        get() = throw UnsupportedOperationException("A style sheet has no parent rule.")

    ////

    override fun charset(characterSet: String): KatydidCharSetAtRule {
        val result = KatydidCharSetAtRuleImpl(this, characterSet)
        this.nestedRules.add(result)
        return result
    }

    override fun copy(parentOfCopy: KatydidCompositeCssRuleImpl): KatydidStyleSheetImpl =
        throw UnsupportedOperationException("A style sheet cannot be copied inside another style rule.")

    override fun include(styleSheet: KatydidStyleSheet) {

        for (rule in styleSheet.nestedRules) {

            if (rule is KatydidAbstractStyleRule) {
                nestedRules.add(rule.copy(this))
            }
            else if (rule is KatydidCharSetAtRule && nestedRules.isEmpty()) {
                nestedRules.add(rule.copy(this))
            }
            else if (rule is KatydidMediaAtRule) {
                nestedRules.add(rule.copy(this))
            }

        }

    }

    override operator fun String.invoke(build: KatydidStyleRule.() -> Unit): KatydidStyleRule {

        // Create the new style rule.
        val result = KatydidStyleRuleImpl(this@KatydidStyleSheetImpl)

        // Add its selectors or placeholder selectors.
        result.prependSelectors(this)

        // Nest the new rule in this style sheet.
        this@KatydidStyleSheetImpl.nestedRules.add(result)

        // Build its style.
        result.build()

        return result

    }

    override fun media(condition: String, build: KatydidMediaAtRule.() -> Unit): KatydidMediaAtRule {
        val result = KatydidMediaAtRuleImpl(this, condition)
        this.nestedRules.add(result)
        result.build()
        return result
    }

    override infix fun String.or(that: String) =
        this + ", " + that

    override infix fun String.or(styleRule: KatydidStyleRule): KatydidStyleRule {

        (styleRule as KatydidStyleRuleImpl).prependSelectors(this)

        return styleRule

    }

    override fun placeholder(name: String, build: KatydidPlaceholderRule.() -> Unit): String {

        require(findPlaceholder(name) == null) { "Duplicate placeholder name not allowed: '$this'." }

        // Create the new placeholder rule.
        val result = KatydidPlaceholderRuleImpl(this, name)

        // Nest the new placeholder in this style sheet.
        this.nestedRules.add(result)

        // Build its style.
        result.build()

        return name

    }

    override fun toCssString(indent: Int): String {

        val result = StringBuilder("")

        for (rule in nestedRules) {
            result.append(rule.toCssString(indent))
        }

        return result.toString()

    }

    override fun toString(): String =
        toCssString()

}

//---------------------------------------------------------------------------------------------------------------------

