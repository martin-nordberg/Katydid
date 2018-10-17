//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.css.stylesheets

import o.katydid.css.styles.builders.KatydidStyleBuilderDsl
import o.katydid.css.stylesheets.KatydidPlaceholderRule

//---------------------------------------------------------------------------------------------------------------------

/**
 * Class representing one style rule (selectors plus style properties) in a larger style sheet.
 */
@KatydidStyleBuilderDsl
internal class KatydidPlaceholderRuleImpl(
    itsParent: KatydidCompositeCssRuleImpl,
    itsName: String
) : KatydidAbstractStyleRuleImpl(itsParent), KatydidPlaceholderRule {

    /** The placeholders extended by this placeholder. */
    private val myExtendedPlaceholders = mutableListOf<KatydidPlaceholderRuleImpl>()

    ////

    override val name = itsName

    ////

    init {
        require(name.matches(Regex("%[a-zA-Z-_]+"))) { "Invalid placeholder name: '$name'." }
    }

    ////

    override fun afterAddSelectors(addedSelectors: Collection<String>) {

        for (placeholder in myExtendedPlaceholders) {
            placeholder.addSelectors(addedSelectors)
        }

    }

    override fun copy(parentOfCopy: KatydidCompositeCssRuleImpl): KatydidPlaceholderRuleImpl {

        val result = KatydidPlaceholderRuleImpl(parentOfCopy, name)

        result.addSelectors(selectors)
        result.include(this)

        result.addNestedRules(nestedRules.map { b -> b.copy(result) })

        return result

    }

    override fun extend(vararg placeholderNames: String) {

        require(properties.isEmpty()) { "Use of extend() must occur at the beginning of a placeholder rule." }

        for (placeholderName in placeholderNames) {
            val placeholder = parent.findPlaceholder(placeholderName)
                ?: throw IllegalArgumentException("Unknown placeholder rule to be extended: '$placeholderName'.")

            myExtendedPlaceholders.add(placeholder)
        }

    }

}

//---------------------------------------------------------------------------------------------------------------------

