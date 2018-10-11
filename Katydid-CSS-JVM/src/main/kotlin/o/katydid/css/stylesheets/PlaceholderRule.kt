//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.stylesheets

import o.katydid.css.styles.Style
import o.katydid.css.styles.builders.StyleBuilderDsl
import o.katydid.css.styles.makeStyle

//---------------------------------------------------------------------------------------------------------------------

/**
 * Class representing one style rule (selectors plus style properties) in a larger style sheet.
 */
@StyleBuilderDsl
class PlaceholderRule(
    parent: StyleBlock,
    val name: String,
    style: Style = makeStyle {}
) : AbstractStyleRule(parent, style) {

    /** The placeholders extended by this placeholder. */
    private val extendedPlaceholders = mutableListOf<PlaceholderRule>()

    ////

    init {
        require(name.matches(Regex("%[a-zA-Z-_]+"))) { "Invalid placeholder name: '$name'." }
    }

    ////

    override fun afterAddSelectors(addedSelectors: Collection<String>) {

        for (placeholder in extendedPlaceholders) {
            placeholder.addSelectors(addedSelectors)
        }

    }

    override fun copy(parentOfCopy: StyleBlock): PlaceholderRule {

        val result = PlaceholderRule(parentOfCopy, name)

        result.addSelectors(selectors)
        result.include(this)
        result.addNestedBlocks(nestedBlocks.map { b -> b.copy(result) })

        return result

    }

    override fun extend(vararg placeholderNames: String) {

        for (placeholderName in placeholderNames) {
            val placeholder = parent.findPlaceholder(placeholderName)
                ?: throw IllegalArgumentException("Unknown placeholder rule to be extended: '$placeholderName'.")

            extendedPlaceholders.add(placeholder)
        }

    }

}

//---------------------------------------------------------------------------------------------------------------------

