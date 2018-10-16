//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.css.stylesheets

import o.katydid.css.styles.builders.StyleBuilderDsl
import o.katydid.css.stylesheets.*

//---------------------------------------------------------------------------------------------------------------------

/**
 * Represents a CSS style sheet with SASS-like provisions to build style rules from string selectors and
 * styles.
 */
@StyleBuilderDsl
internal class StyleSheetImpl
    : CompositeCssRuleImpl(), StyleSheet {

    override val fullSelectors: List<String> = emptyList()

    override val nestedRules: MutableList<CssRule> = mutableListOf()

    override val parent: CompositeCssRuleImpl
        get() = throw UnsupportedOperationException("A style sheet has no parent rule.")

    ////

    override fun charset(characterSet: String): CharSetAtRule {
        val result = CharSetAtRuleImpl(this, characterSet)
        this.nestedRules.add(result)
        return result
    }

    override fun copy(parentOfCopy: CompositeCssRuleImpl): StyleSheetImpl =
        throw UnsupportedOperationException("A style sheet cannot be copied inside another style rule.")

    override fun include(styleSheet: StyleSheet) {

        for (rule in styleSheet.nestedRules) {

            if (rule is AbstractStyleRule) {
                nestedRules.add(rule.copy(this))
            }
            else if (rule is CharSetAtRule && nestedRules.isEmpty()) {
                nestedRules.add(rule.copy(this))
            }
            else if (rule is MediaAtRule) {
                nestedRules.add(rule.copy(this))
            }

        }

    }

    override operator fun String.invoke(build: StyleRule.() -> Unit): StyleRule {

        // Create the new style rule.
        val result = StyleRuleImpl(this@StyleSheetImpl)

        // Add its selectors or placeholder selectors.
        result.prependSelectors(this)

        // Nest the new rule in this style sheet.
        this@StyleSheetImpl.nestedRules.add(result)

        // Build its style.
        result.build()

        return result

    }

    override fun media(condition: String, build: MediaAtRule.() -> Unit): MediaAtRule {
        val result = MediaAtRuleImpl(this, condition)
        this.nestedRules.add(result)
        result.build()
        return result
    }

    override infix fun String.or(that: String) =
        this + ", " + that

    override infix fun String.or(styleRule: StyleRule): StyleRule {

        (styleRule as StyleRuleImpl).prependSelectors(this)

        return styleRule

    }

    override fun placeholder(name: String, build: PlaceholderRule.() -> Unit): String {

        require(findPlaceholder(name) == null) { "Duplicate placeholder name not allowed: '$this'." }

        // Create the new placeholder rule.
        val result = PlaceholderRuleImpl(this, name)

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

