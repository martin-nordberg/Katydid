//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.types

/** Enumeration of options for the 'unicode-bidi' property. */
@Suppress("EnumEntryName")
enum class EUnicodeBidi(
    private val css: String
) {

    /**
     * The box does not open an additional level of embedding with respect to the bidirectional algorithm. For inline
     * boxes, implicit reordering works across box boundaries.
     */
    normal("normal"),

    /**
     * If the box is inline, this value creates a directional embedding by opening an additional level of embedding
     * with respect to the bidirectional algorithm. The direction of this embedding level is given by the direction
     * property. Inside the box, reordering is done implicitly. This value has no effect on boxes that are not
     * inline.
     */
    embed("embed"),

    /**
     * On an inline box, this bidi-isolates its contents. This is similar to a directional embedding (and increases
     * the embedding level accordingly) except that each sequence of inline-level boxes uninterrupted by any block
     * boundary or forced paragraph break is treated as an isolated sequence:
     *  o the content within the sequence is ordered as if inside an independent paragraph with the base
     *    directionality specified by the box’s direction property.
     *  o for the purpose of bidi resolution in its containing bidi paragraph, the sequence is treated as
     *    if it were a single Object Replacement Character (U+FFFC).
     * In effect, neither is the content inside the box bidi-affected by the content surrounding the box, nor is the
     * content surrounding the box bidi-affected by the content or specified directionality of the box. However,
     * forced paragraph breaks within the box still create a corresponding break in the containing paragraph.
     * This value has no effect on boxes that are not inline.
     */
    isolate("isolate"),

    /**
     * This value puts the box’s immediate inline content in a directional override. For an inline, this means that
     * the box acts like a directional embedding in the bidirectional algorithm, except that reordering within it is
     * strictly in sequence according to the direction property; the implicit part of the bidirectional algorithm is
     * ignored. For a block container, the override is applied to an anonymous inline box that surrounds all of its
     * content.
     */
    bidiOverride("bidi-override"),

    /**
     * This combines the isolation behavior of isolate with the directional override behavior of bidi-override:
     * to surrounding content, it is equivalent to isolate, but within the box content is ordered as if bidi-override
     * were specified. It effectively nests a directional override inside an isolated sequence.
     */
    isolateOverride("isolate-override"),

    /**
     * This value behaves as isolate except that for the purposes of the Unicode bidirectional algorithm, the base
     * directionality of each of the box’s bidi paragraphs (if a block container) or isolated sequences (if an inline)
     * is determined by following the heuristic in rules P2 and P3 of the Unicode bidirectional algorithm (rather than
     * by using the direction property of the box).
     */
    plaintext("plaintext");

    ////

    /** @return the CSS attribute text for this unicode-bidi option. */
    override fun toString() =
        css

    ////

    companion object {

        fun fromString(option: String?) =
            when (option) {
                null              -> null
                "bidi-override"   -> bidiOverride
                "embed"           -> embed
                "isolate"         -> isolate
                "isolateOverride" -> isolateOverride
                "normal"          -> normal
                "plaintext"       -> plaintext
                else              -> throw IllegalArgumentException("Unknown unicode-bidi option: '$option'.")
            }

    }

}
