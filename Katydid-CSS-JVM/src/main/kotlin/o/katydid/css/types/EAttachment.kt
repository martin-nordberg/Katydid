//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.types

//---------------------------------------------------------------------------------------------------------------------

/**
 * Enumeration of options for the CSS 'background-attachment' property.
 */
@Suppress("EnumEntryName")
enum class EAttachment(
    private val css: String
) {

    /**
     * The background is fixed with regard to the viewport. In paged media where there is no viewport, a fixed
     * background is fixed with respect to the page box and therefore replicated on every page. Note that there is
     * only one viewport per view. Even if an element has a scrolling mechanism (see the overflow property [CSS2]),
     * a fixed background doesn’t move with the element.
     */
    fixed("fixed"),

    /**
     * The background is fixed with regard to the element’s contents: if the element has a scrolling mechanism, the
     * background scrolls with the element’s contents, and the background painting area and background positioning
     * area are relative to the scrollable area of the element rather than to the border framing them. Because the
     * scrollable area does not include the border area, for scrollable elements the border-box value of
     * background-clip may be treated the same as padding-box.
     */
    local("local"),

    /**
     * The background is fixed with regard to the element itself and does not scroll with its contents. (It is
     * effectively attached to the element’s border.)
     */
    scroll("scroll");

    /** @return the CSS attribute text for this background attachment option. */
    override fun toString() =
        css

    ////

    companion object {

        fun fromString(option: String?) =
            when (option) {
                null     -> null
                "fixed"  -> fixed
                "local"  -> local
                "scroll" -> scroll
                else     -> throw IllegalArgumentException("Unknown background attachment option: '$option'.")
            }

    }

}

//---------------------------------------------------------------------------------------------------------------------

