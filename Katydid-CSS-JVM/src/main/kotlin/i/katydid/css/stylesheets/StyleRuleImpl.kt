//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.css.stylesheets

import o.katydid.css.styles.builders.StyleBuilderDsl
import o.katydid.css.stylesheets.PlaceholderRule
import o.katydid.css.stylesheets.StyleRule

//---------------------------------------------------------------------------------------------------------------------

/**
 * Class representing one style rule (selectors plus style properties) in a larger style sheet.
 */
@StyleBuilderDsl
internal class StyleRuleImpl(
    itsParent: CompositeCssRuleImpl
) : AbstractStyleRuleImpl(itsParent), StyleRule {

    override fun copy(parentOfCopy: CompositeCssRuleImpl): StyleRuleImpl {

        val result = StyleRuleImpl(parentOfCopy)

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

    override fun placeholder(name: String, build: PlaceholderRule.() -> Unit) {

        require(findPlaceholder(name) == null) { "Duplicate placeholder name not allowed: '$this'." }

        // Create the new placeholder rule.
        val result = PlaceholderRuleImpl(this, name)

        // Nest the new placeholder in this style sheet.
        this.addNestedRule(result)

        // Build its style.
        result.build()

    }

}

//---------------------------------------------------------------------------------------------------------------------

