//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.org.katydom.types

//---------------------------------------------------------------------------------------------------------------------

/**
 * Enumeration of allowed values for a referrer policy attribute.
 * See https://www.w3.org/TR/referrer-policy/.
 */
enum class EReferrerPolicy {

    /** The "no-referrer" attribute value. */
    NO_REFERRER,

    /** The "no-referrer-when-downgrade" attribute value. */
    NO_REFERRER_WHEN_DOWNGRADE,

    /** The "origin" attribute value. */
    ORIGIN,

    /** The "origin-when-cross-origin" attribute value. */
    ORIGIN_WHEN_CROSS_ORIGIN,

    /** The "same-origin" attribute value. */
    SAME_ORIGIN,

    /** The "strict-origin" attribute value. */
    STRICT_ORIGIN,

    /** The "strict-origin-when-cross-origin" attribute value. */
    STRICT_ORIGIN_WHEN_CROSS_ORIGIN,

    /** The "unsafe_url" attribute value. */
    UNSAFE_URL;

    /** @return the HTML attribute text for this direction. */
    fun toHtmlString(): String {
        return when (this) {
            NO_REFERRER                     -> "no-referrer"
            NO_REFERRER_WHEN_DOWNGRADE      -> "no-referrer-when-downgrade"
            ORIGIN                          -> "origin"
            ORIGIN_WHEN_CROSS_ORIGIN        -> "origin-when-cross-origin"
            SAME_ORIGIN                     -> "same-origin"
            STRICT_ORIGIN                   -> "strict-origin"
            STRICT_ORIGIN_WHEN_CROSS_ORIGIN -> "strict-origin-when-cross-origin"
            UNSAFE_URL                      -> "unsafe-url"
        }
    }

}

//---------------------------------------------------------------------------------------------------------------------



