//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.types

/** Enumeration of options for the 'overflow' property. */
@Suppress("EnumEntryName")
enum class EOverflow(
    private val css: String
) {

    /** This value indicates that content is not clipped, i.e., it may be rendered outside the block box. */
    visible("visible"),

    /**
     * This value indicates that the content is clipped and that no scrolling user interface should be provided
     * to view the content outside the clipping region.
     */
    hidden("hidden"),

    /**
     * Like hidden, this value indicates that the box’s content is clipped to its padding box and that no scrolling
     * user interface should be provided by the UA to view the content outside the clipping region. In addition,
     * unlike overflow: hidden which still allows programmatic scrolling, overflow: clip forbids scrolling entirely,
     * through any mechanism, and therefore the box is not a scroll container. Unlike hidden, this value does not
     * cause the element to establish a new formatting context.
     */
    clip("clip"),

    /**
     * This value indicates that the content is clipped and that if the user agent uses a scrolling mechanism that
     * is visible on the screen (such as a scroll bar or a panner), that mechanism should be displayed for a box
     * whether or not any of its content is clipped.
     */
    scroll("scroll"),

    /**
     * The behavior of the 'auto' value is user agent-dependent, but should cause a scrolling mechanism to be
     * provided for overflowing boxes.
     */
    auto("auto");

    ////

    /** @return the CSS attribute text for this overflow option. */
    override fun toString() =
        css

    ////

    companion object {

        fun fromString(option: String?) =
            when (option) {
                null      -> null
                "auto"    -> auto
                "clip"    -> clip
                "hidden"  -> hidden
                "scroll"  -> scroll
                "visible" -> visible
                else      -> throw IllegalArgumentException("Unknown overflow option: '$option'.")
            }

    }

}
