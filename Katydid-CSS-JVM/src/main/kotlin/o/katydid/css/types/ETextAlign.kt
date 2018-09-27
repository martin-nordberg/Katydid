//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.types

/** Enumeration of options for the 'text-align' property. */
@Suppress("EnumEntryName")
enum class ETextAlign(
    private val css: String
) {

    /** Inline-level content is aligned to the start edge of the line box. */
    start("start"),

    /** Inline-level content is aligned to the end edge of the line box. */
    end("end"),

    /** Inline-level content is aligned to the line left edge of the line box. (In vertical writing modes, this will
     * be either the physical top or bottom, depending on text-orientation.) [CSS3-WRITING-MODES] */
    left("left"),

    /**
     * Inline-level content is aligned to the line right edge of the line box. (In vertical writing modes, this will
     * be either the physical top or bottom, depending on text-orientation.) [CSS3-WRITING-MODES]
     */
    right("right"),

    /** Inline-level content is centered within the line box. */
    center("center"),

    /**
     * Text is justified according to the method specified by the text-justify property, in order to exactly fill
     * the line box. Unless otherwise specified by text-align-last, the last line before a forced break or the end
     * of the block is start-aligned.
     */
    justify("justify"),

    /** Sets both text-align-all and text-align-last to justify, forcing the last line to justify as well. */
    justifyAll("justify-all"),

    /**
     * This value behaves the same as inherit (computes to its parent’s computed value) except that an inherited
     * value of start or end is interpreted against the parent’s (or the initial containing block’s, if there is no
     * parent) direction value and results in a computed value of either left or right. When specified on the
     * text-align shorthand, sets both text-align-all and text-align-last to match-parent.
     */
    matchParent("match-parent");

    ////

    /** @return the CSS attribute text for this text align option. */
    override fun toString() =
        css

    ////

    companion object {

        fun fromString(option: String?) =
            when (option) {
                null           -> null
                "center"       -> center
                "end"          -> end
                "justify"      -> justify
                "justify-all"  -> justifyAll
                "left"         -> left
                "match-parent" -> matchParent
                "right"        -> right
                "start"        -> start
                else           -> throw IllegalArgumentException("Unknown text align option: '$option'.")
            }

    }

}
