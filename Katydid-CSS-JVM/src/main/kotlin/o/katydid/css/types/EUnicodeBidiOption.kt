//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.types

/** Enumeration of options for the 'unicode-bidi' property. */
@Suppress("EnumEntryName")
enum class EUnicodeBidiOption(
    private val css: String
) {

    /** The element does not open an additional level of embedding with respect to the bidirectional algorithm. For
     * inline elements, implicit reordering works across element boundaries. */
    normal("normal"),

    /** If the element is inline, this value opens an additional level of embedding with respect to the bidirectional
     * algorithm. The direction of this embedding level is given by the 'direction' property. Inside the element,
     * reordering is done implicitly. This corresponds to adding a LRE (U+202A; for 'direction: ltr') or RLE (U+202B;
     * for 'direction: rtl') at the start of the element and a PDF (U+202C) at the end of the element. */
    embed("embed"),

    /** For inline elements this creates an override. For block container elements this creates an override for
     * inline-level descendants not within another block container element. This means that inside the element,
     * reordering is strictly in sequence according to the 'direction' property; the implicit part of the
     * bidirectional algorithm is ignored. This corresponds to adding a LRO (U+202D; for 'direction: ltr') or
     * RLO (U+202E; for 'direction: rtl') at the start of the element or at the start of each anonymous child block
     * box, if any, and a PDF (U+202C) at the end of the element. */
    bidiOverride("bidi-override");

    ////

    /** @return the CSS attribute text for this unicode-bidi option. */
    override fun toString() =
        css

    ////

    companion object {

        fun fromString(option: String?) =
            when (option) {
                null            -> null
                "normal"        -> normal
                "embed"         -> embed
                "bidi-override" -> bidiOverride
                else            -> throw IllegalArgumentException("Unknown unicode-bidi option: '$option'.")
            }

    }

}
