//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.types

/** Enumeration of options for the 'float' property. */
@Suppress("EnumEntryName")
enum class EFloat(
    private val css: String
) {

    /**
     * The element generates a block box that is floated to the left. Content flows on the right side of the box,
     * starting at the top (subject to the 'clear' property).
     */
    left("left"),

    /**
     * Similar to 'left', except the box is floated to the right, and content flows on the left side of the box,
     * starting at the top.
     */
    right("right"),

    /** The box is not floated. */
    none("none"),

    /**
     * The element generates a box that is floated to the line-start outer edge of the float reference. Content flows
     * on the line-end side of the box.
     */
    inlineStart("inline-start"),

    /**
     * The element generates a box that is floated to the line-end outer edge of the float reference. Content flows
     * on the line-start side of the box.
     */
    inlineEnd("inline-end"),

    /**
     * If the float reference is a line box, block-start behaves like inline-start.
     * If the float reference is not a line box, the element generates a box that is floated to the block-start and
     * line-start outer edges of the float reference.
     */
    blockStart("block-start"),

    /**
     * If the float reference is a line box, block-end behaves like inline-end.
     * If the float reference is not a line box, the element generates a box that is floated to the block-end and
     * line-start outer edges of the float reference.
     */
    blockEnd("block-end"),

    /**
     * Behave like block-start or inline-start depending on the float containing block’s direction and writing-mode.
     */
    top("top"),

    /** Behave like block-end or inline-end depending on the float containing block’s direction and writing-mode. */
    bottom("bottom"),

    /** same as snap-block(2em, near) */
    snapBlock("snap-block"),

    /** same as snap-inline(2em, near) */
    snapInline("snap-inline");

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
                "bottom"       -> bottom
                "inline-end"   -> inlineEnd
                "inline-start" -> inlineStart
                "left"         -> left
                "none"         -> none
                "right"        -> right
                "snap-block"   -> snapBlock
                "snap-inline"  -> snapInline
                "top"          -> top
                else           -> throw IllegalArgumentException("Unknown float option: '$option'.")
            }

    }

}
