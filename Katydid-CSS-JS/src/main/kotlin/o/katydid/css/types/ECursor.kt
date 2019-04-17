//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.types

//---------------------------------------------------------------------------------------------------------------------

/**
 * Enumeration of the options for the 'cursor' property.
 */
@Suppress("EnumEntryName")
enum class ECursor(
    private val css: String
) {

    /**
     * The UA determines the cursor to display based on the current context, specifically: auto behaves as text over
     * selectable text or editable elements, and default otherwise.
     */
    auto("auto"),

    /** The platform-dependent default cursor. Often rendered as an arrow. */
    default("default"),

    /** No cursor is rendered for the element. */
    none("none"),

    /**
     * A context menu is available for the object under the cursor. Often rendered as an arrow with a small menu-like
     * graphic next to it.
     */
    contextMenu("context-menu"),

    /** Help is available for the object under the cursor. Often rendered as a question mark or a balloon. */
    help("help"),

    /** The cursor is a pointer that indicates a link. */
    pointer("pointer"),

    /**
     * A progress indicator. The program is performing some processing, but is different from wait in that the user
     * may still interact with the program. Often rendered as a spinning beach ball, or an arrow with a watch or
     * hourglass.
     */
    progress("progress"),

    /** Indicates that the program is busy and the user should wait. Often rendered as a watch or hourglass. */
    wait("wait"),

    /**
     * Indicates that a cell or set of cells may be selected. Often rendered as a thick plus-sign with a dot in
     * the middle.
     */
    cell("cell"),

    /**
     * A simple crosshair (e.g., short line segments resembling a "+" sign). Often used to indicate a two dimensional
     * bitmap selection mode.
     */
    crosshair("crosshair"),

    /**
     * Indicates text that may be selected. Often rendered as a vertical I-beam. User agents may automatically
     * display a horizontal I-beam/cursor (e.g. same as the vertical-text keyword) for vertical text, or for that
     * matter, any angle of I-beam/cursor for text that is rendered at any particular angle.
     */
    text("text"),

    /** Indicates vertical-text that may be selected. Often rendered as a horizontal I-beam. */
    verticalText("vertical-text"),

    /**
     * Indicates an alias of/shortcut to something is to be created. Often rendered as an arrow with a small curved
     * arrow next to it.
     */
    alias("alias"),

    /** Indicates something is to be copied. Often rendered as an arrow with a small plus sign next to it. */
    copy("copy"),

    /** Indicates something is to be moved. */
    move("move"),

    /**
     * Indicates that the dragged item cannot be dropped at the current cursor location. Often rendered as a hand or
     * pointer with a small circle with a line through it.
     */
    noDrop("no-drop"),

    /**
     * Indicates that the requested action will not be carried out. Often rendered as a circle with a line
     * through it.
     */
    notAlowed("not-allowed"),

    /**
     * Indicates that something can be grabbed (dragged to be moved). Often rendered as the backside of an
     * open hand.
     */
    grab("grab"),

    /**
     * Indicates that something is being grabbed (dragged to be moved). Often rendered as the backside of a hand with
     * fingers closed mostly out of view.
     */
    grabbing("grabbing"),

    /** Indicates that the right edge is to be moved. */
    eResize("e-resize"),

    /** Indicates that the top edge is to be moved. */
    nResize("n-resize"),

    /** Indicates that the top right corner is to be moved. */
    neResize("ne-resize"),

    /** Indicates that the top left corner is to be moved. */
    nwResize("nw-resize"),

    /** Indicates that the bottom edge is to be moved. */
    sResize("s-resize"),

    /** Indicates that the bottom right corner is to be moved. */
    seResize("se-resize"),

    /** Indicates that the bottom left corner is to be moved. */
    swResize("sw-resize"),

    /** Indicates that the left edge is to be moved. */
    wResize("w-resize"),

    /** Indicates a bidirectional resize cursor. */
    ewResize("ew-resize"),

    /** Indicates a bidirectional resize cursor. */
    nsResize("ns-resize"),

    /** Indicates a bidirectional resize cursor. */
    neswResize("nesw-resize"),

    /** Indicates a bidirectional resize cursor. */
    nwseResize("nwse-resize"),

    /**
     * Indicates that the item/column can be resized horizontally. Often rendered as arrows pointing left and right
     * with a vertical bar separating them.
     */
    colResize("col-resize"),

    /**
     * Indicates that the item/row can be resized vertically. Often rendered as arrows pointing up and down with a
     * horizontal bar separating them.
     */
    rowResize("row-resize"),

    /**
     * Indicates that the something can be scrolled in any direction. Often rendered as arrows pointing up, down,
     * left, and right with a dot in the middle.
     */
    allScroll("all-scroll"),

    /**
     * Indicates that something can be zoomed (magnified) in, and often rendered as a magnifying glass with a "+" in
     * the center of the glass.
     */
    zoomIn("zoom-in"),

    /**
     * Indicates that something can be zoomed out, and often rendered as a magnifying glass with a "-" in the center
     * of the glass.
     */
    zoomOut("zoom-out");

    ////

    /** @return the CSS attribute text for this cursor option. */
    override fun toString() =
        css

    ////

    companion object {

        fun fromString(option: String?) =
            when (option) {
                null            -> null
                "alias"         -> alias
                "all-scroll"    -> allScroll
                "auto"          -> auto
                "cell"          -> cell
                "col-resize"    -> colResize
                "context-menu"  -> contextMenu
                "copy"          -> copy
                "crosshair"     -> crosshair
                "default"       -> default
                "e-resize"      -> eResize
                "ew-resize"     -> ewResize
                "grab"          -> grab
                "grabbing"      -> grabbing
                "help"          -> help
                "move"          -> move
                "n-resize"      -> nResize
                "ne-resize"     -> neResize
                "nesw-resize"   -> neswResize
                "no-drop"       -> noDrop
                "none"          -> none
                "not-allowed"   -> notAlowed
                "ns-resize"     -> nsResize
                "nw-resize"     -> nwResize
                "nwse-resize"   -> nwseResize
                "pointer"       -> pointer
                "progress"      -> progress
                "row-resize"    -> rowResize
                "s-resize"      -> sResize
                "se-resize"     -> seResize
                "sw-resize"     -> swResize
                "text"          -> text
                "vertical-text" -> verticalText
                "w-resize"      -> wResize
                "wait"          -> wait
                "zoom-in"       -> zoomIn
                "zoom-out"      -> zoomOut
                else            -> throw IllegalArgumentException("Unknown cursor option: '$option'.")
            }

    }

}

//---------------------------------------------------------------------------------------------------------------------

