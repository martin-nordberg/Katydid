//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.vdom.types

//---------------------------------------------------------------------------------------------------------------------

/**
 * Enumeration of allowed values for a referrer policy attribute.
 * See https://www.w3.org/TR/referrer-policy/.
 */
@Suppress("EnumEntryName")
enum class EReferrerPolicy(
    private val html: String
) {

    /** The "no-referrer" attribute value. */
    noReferrer("no-referrer"),

    /** The "no-referrer-when-downgrade" attribute value. */
    noReferrerWhenDowngrade("no-referrer-when-downgrade"),

    /** The "origin" attribute value. */
    origin("origin"),

    /** The "origin-when-cross-origin" attribute value. */
    originWhenCrossOrigin("origin-when-cross-origin"),

    /** The "same-origin" attribute value. */
    sameOrigin("same-origin"),

    /** The "strict-origin" attribute value. */
    strictOrigin("strict-origin"),

    /** The "strict-origin-when-cross-origin" attribute value. */
    strictOriginWhenCrossOrigin("strict-origin-when-cross-origin"),

    /** The "unsafe_url" attribute value. */
    unsafeUrl("unsafe-url");

    ////

    /** @return the HTML attribute text for this direction. */
    fun toHtmlString() =
        html

}

//---------------------------------------------------------------------------------------------------------------------



