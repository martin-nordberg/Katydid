//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.org.katydom.types

//---------------------------------------------------------------------------------------------------------------------

/**
 * Enumeration of allowed values for the rel or rev attribute of an <a> or <area> tag.
 * See https://www.w3.org/TR/html51/links.html#allowed-keywords-and-their-meanings.
 */
enum class EAnchorHtmlLinkType {

    /** Attribute value "alternate". */
    ALTERNATE,

    /** Attribute value "author". */
    AUTHOR,

    /** Attribute value "bookmark". */
    BOOKMARK,

    /** Attribute value "help". */
    HELP,

    /** Attribute value "license". */
    LICENSE,

    /** Attribute value "next". */
    NEXT,

    /** Attribute value "nofollow". */
    NOFOLLOW,

    /** Attribute value "noreferrer". */
    NOREFERRER,

    /** Attribute value "prev". */
    PREV,

    /** Attribute value "search". */
    SEARCH,

    /** Attribute value "tag". */
    TAG;

    /** @return the HTML attribute value of this anchor link type. */
    fun toHtmlString(): String {
        return when (this) {
            ALTERNATE  -> "alternate"
            AUTHOR     -> "author"
            BOOKMARK   -> "bookmark"
            HELP       -> "help"
            LICENSE    -> "license"
            NEXT       -> "next"
            NOFOLLOW   -> "nofollow"
            NOREFERRER -> "noreferrer"
            PREV       -> "prev"
            SEARCH     -> "search"
            TAG        -> "tag"
        }
    }

}

//---------------------------------------------------------------------------------------------------------------------

