//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.types

/** Enumeration of options for the 'clear' property. */
@Suppress("EnumEntryName")
enum class EClear(
    private val css: String
) {

    /**
     * Requires that the top border edge of the box be below the bottom outer edge of any left-floating boxes that
     * resulted from elements earlier in the source document.
     */
    left("left"),

    /**
     * Requires that the top border edge of the box be below the bottom outer edge of any right-floating boxes
     * that resulted from elements earlier in the source document.
     */
    right("right"),

    /**
     * Requires that the top border edge of the box be below the bottom outer edge of any right-floating and
     * left-floating boxes that resulted from elements earlier in the source document.
     */
    both("both"),

    /** No constraint on the box's position with respect to floats. */
    none("none"),

    /**
     * If applied to an inline float, requires that the block-start outer edge of the box comes after the block-end
     * outer edge of any inline-start-floats with an inline-start-float-reference that resulted from elements earlier
     * in the source document.
     * If applied to a page float, the float reference in which the page float is placed will be seen as full when
     * determining whether it can host subsequent page floats that float in the inline-start direction.
     */
    inlineStart("inline-start"),

    /**
     * If applied to a block-level element or a float with a float-reference set to inline, requires that the
     * block-start outer edge of the box comes after the block-end outer edge of any inline-end-floats with an
     * inline-end-float-reference that resulted from elements earlier in the source document.
     * If applied to a page float, the float reference in which the page float is placed will be seen as full when
     * determining whether it can host subsequent page floats that float in the inline-end direction.
     */
    inlineEnd("inline-end"),

    /**
     * If applied to a block-level element or a float with a float-reference set to inline, behave like inline-start.
     * If applied to a page float, the float reference in which the page float is placed will be seen as full when
     * determining whether it can host subsequent page floats that float in the block-start direction.
     */
    blockStart("block-start"),

    /**
     * If applied to a block-level element or a float with a float-reference set to inline, behave like inline-end.
     * If applied to a page float, the float reference in which the page float is placed will be seen as full when
     * determining whether it can host subsequent page floats that float in the block-end direction.
     */
    blockEnd("block-end"),

    /**
     * Behave like block-start or inline-start depending on the float containing block’s direction and
     * writing-mode.
     */
    top("top"),

    /** Behave like block-end or inline-end depending on the float containing block’s direction and writing-mode. */
    bottom("bottom");

    ////

    /** @return the CSS attribute text for this clear option. */
    override fun toString() =
        css

    ////

    companion object {

        fun fromString(option: String?) =
            when (option) {
                null           -> null
                "block-end"    -> blockEnd
                "block-start"  -> blockStart
                "both"         -> both
                "bottom"       -> bottom
                "inline-end"   -> inlineEnd
                "inline-start" -> inlineStart
                "left"         -> left
                "none"         -> none
                "right"        -> right
                "top"          -> top
                else           -> throw IllegalArgumentException("Unknown clear option: '$option'.")
            }

    }

}
