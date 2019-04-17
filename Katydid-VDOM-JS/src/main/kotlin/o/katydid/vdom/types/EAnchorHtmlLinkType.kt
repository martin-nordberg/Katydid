//
// (C) Copyright 2017-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.vdom.types

//---------------------------------------------------------------------------------------------------------------------

/**
 * Enumeration of allowed values for the rel or rev attribute of an <a> or <area> tag.
 * See https://www.w3.org/TR/html51/links.html#allowed-keywords-and-their-meanings.
 */
@Suppress("EnumEntryName")
enum class EAnchorHtmlLinkType(
    private val html: String
) {

    /** Attribute value "alternate". */
    alternate("alternate"),

    /** Attribute value "author". */
    author("author"),

    /** Attribute value "bookmark". */
    bookmark("bookmark"),

    /** Attribute value "help". */
    help("help"),

    /** Attribute value "license". */
    license("license"),

    /** Attribute value "next". */
    next("next"),

    /** Attribute value "nofollow". */
    nofollow("nofollow"),

    /** Attribute value "noreferrer". */
    noreferrer("noreferrer"),

    /** Attribute value "prev". */
    prev("prev"),

    /** Attribute value "search". */
    search("search"),

    /** Attribute value "tag". */
    tag("tag");

    ////

    /** @return the HTML attribute value of this anchor link type. */
    fun toHtmlString() =
        html

}

//---------------------------------------------------------------------------------------------------------------------


