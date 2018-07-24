//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.org.katydom.types

//---------------------------------------------------------------------------------------------------------------------

/**
 * Enumeration of allowed values for an iframe's sandbox attribute.
 */
enum class ESandboxOptions {

    /** The "allow-forms" attribute value. */
    ALLOW_FORMS,

    /** The "allow-pointer-lock" attribute value. */
    ALLOW_POINTER_LOCK,

    /** The "allow-popups" attribute value. */
    ALLOW_POPUPS,

    /** The "origin-when-cross-origin" attribute value. */
    ALLOW_PRESENTATION,

    /** The "allow-same-origin" attribute value. */
    ALLOW_SAME_ORIGIN,

    /** The "allow-scripts" attribute value. */
    ALLOW_SCRIPTS,

    /** The "allow-top-navigation" attribute value. */
    ALLOW_TOP_NAVIGATION;

    /** @return the HTML attribute text for this direction. */
    fun toHtmlString(): String {
        return when (this) {
            ALLOW_FORMS          -> "allow-forms"
            ALLOW_POINTER_LOCK   -> "allow-pointer-lock"
            ALLOW_POPUPS         -> "allow-popups"
            ALLOW_PRESENTATION   -> "allow-presentation"
            ALLOW_SAME_ORIGIN    -> "allow-same-origin"
            ALLOW_SCRIPTS        -> "allow-scripts"
            ALLOW_TOP_NAVIGATION -> "allow-top-navigation"
        }
    }

}

//---------------------------------------------------------------------------------------------------------------------



