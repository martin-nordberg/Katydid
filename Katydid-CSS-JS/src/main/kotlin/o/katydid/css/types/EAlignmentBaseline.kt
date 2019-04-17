//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.types

/** Enumeration of options for the 'alignment-baseline' or 'vertical-align' property. */
@Suppress("EnumEntryName")
enum class EAlignmentBaseline(
    private val css: String
) {

    /**
     * Use the dominant baseline choice of the parent. Match the box’s corresponding baseline to that of its
     * parent.
     */
    baseline("baseline"),

    /** Match the bottom of the box to the bottom of the parent’s content area. */
    textBottom("text-bottom"),

    /** Match the box’s alphabetic baseline to that of its parent. */
    alphabetic("alphabetic"),

    /** Match the box’s ideographic character face under-side baseline to that of its parent. */
    ideographic("ideographic"),

    /**
     * Align the vertical midpoint of the box with the baseline of the parent box plus half the x-height of the
     * parent.
     */
    middle("middle"),

    /** Match the box’s central baseline to the central baseline of its parent. */
    central("central"),

    /** Match the box’s mathematical baseline to that of its parent. */
    mathematical("mathematical"),

    /** Match the top of the box to the top of the parent’s content area. */
    textTop("text-top"),

    /** Align the top of the aligned subtree with the top of the line box. */
    top("top"),

    /** Align the center of the aligned subtree with the center of the line box. */
    center("center"),

    /** Align the bottom of the aligned subtree with the bottom of the line box. */
    bottom("bottom");

    ////

    /** @return the CSS attribute text for this alignment-baseline option. */
    override fun toString() =
        css

    ////

    companion object {

        fun fromString(option: String?) =
            when (option) {
                null           -> null
                "alphabetic"   -> alphabetic
                "baseline"     -> baseline
                "bottom"       -> bottom
                "center"       -> center
                "central"      -> central
                "ideographic"  -> ideographic
                "mathematical" -> mathematical
                "middle"       -> middle
                "text-bottom"  -> textBottom
                "text-top"     -> textTop
                "top"          -> top
                else           -> throw IllegalArgumentException("Unknown alignment-baseline option: '$option'.")
            }

    }

}
