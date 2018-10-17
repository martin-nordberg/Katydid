//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.css.stylesheets

import o.katydid.css.styles.builders.KatydidStyleBuilderDsl
import o.katydid.css.stylesheets.KatydidPlaceholderRule
import o.katydid.css.stylesheets.KatydidStyleRule

//---------------------------------------------------------------------------------------------------------------------

/**
 * Class representing one style rule (selectors plus style properties) in a larger style sheet.
 */
@KatydidStyleBuilderDsl
internal class KatydidStyleRuleImpl(
    itsParent: KatydidCompositeCssRuleImpl
) : KatydidAbstractStyleRuleImpl(itsParent), KatydidStyleRule {

    override fun copy(parentOfCopy: KatydidCompositeCssRuleImpl): KatydidStyleRuleImpl {

        val result = KatydidStyleRuleImpl(parentOfCopy)

        result.addSelectors(selectors)
        result.include(this)
        result.addNestedRules(nestedRules.map { b -> b.copy(result) })

        return result

    }

    override fun extend(vararg placeholderNames: String) {

        require(properties.isEmpty()) { "Use of extend() must occur at the beginning of a placeholder rule." }
        require(nestedRules.isEmpty()) { "Use of extend() must occur at the beginning of a placeholder rule." }

        for (placeholderName in placeholderNames) {
            val placeholder = parent.findPlaceholder(placeholderName)
                ?: throw IllegalArgumentException("Unknown placeholder rule to be extended: '$placeholderName'.")

            placeholder.addSelectors(selectors)
        }

    }

    override fun placeholder(name: String, build: KatydidPlaceholderRule.() -> Unit) {

        require(findPlaceholder(name) == null) { "Duplicate placeholder name not allowed: '$this'." }

        // Create the new placeholder rule.
        val result = KatydidPlaceholderRuleImpl(this, name)

        // Nest the new placeholder in this style sheet.
        this.addNestedRule(result)

        // Build its style.
        result.build()

    }

}

//---------------------------------------------------------------------------------------------------------------------

