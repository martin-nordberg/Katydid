//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.types

/** Enumeration of options for the 'text-justify' property. */
@Suppress("EnumEntryName")
enum class ETextJustify(
    private val css: String
) {

    /**
     * The UA determines the justification algorithm to follow, based on a balance between performance and adequate
     * presentation quality. Since justification rules vary by writing system and language, UAs should, where possible,
     * use a justification algorithm appropriate to the text.
     */
    auto("auto"),

    /**
     * Justification is disabled: there are no justification opportunities within the text. No extra space is inserted.
     */
    none("none"),

    /**
     * Justification adjusts spacing at word separators only (effectively varying the used word-spacing on the line).
     * This behavior is typical for languages that separate words using spaces, like English or Korean. Extra space
     * is equally distributed mainly to spaces.
     */
    interWord("inter-word"),

    /**
     * Justification adjusts spacing between each pair of adjacent typographic character units (effectively varying
     * the used letter-spacing on the line). This value is sometimes used in East Asian systems such as Japanese.
     */
    interCharacter("inter-character");

    ////

    /** @return the CSS attribute text for this text justify option. */
    override fun toString() =
        css

    ////

    companion object {

        fun fromString(option: String?) =
            when (option) {
                null              -> null
                "auto"            -> auto
                "none"            -> none
                "inter-word"      -> interWord
                "inter-character" -> interCharacter
                else              -> throw IllegalArgumentException("Unknown text justify option: '$option'.")
            }

    }

}
