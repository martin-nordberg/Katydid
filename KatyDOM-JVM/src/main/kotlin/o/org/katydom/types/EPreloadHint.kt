//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.org.katydom.types

//---------------------------------------------------------------------------------------------------------------------

/**
 * Enumeration of allowed values for a CORS setting attribute.
 * See https://www.w3.org/TR/html5/infrastructure.html#cors-settings-attribute.
 */
enum class EPreloadHint {

    /** The "auto" attribute value. */
    AUTO,

    /** The "metadata" attribute value. */
    METADATA,

    /** The "none" attribute value. */
    NONE;

    /** @return the HTML attribute text for this direction. */
    fun toHtmlString(): String {
        return when (this) {
            AUTO     -> "auto"
            METADATA -> "metadata"
            NONE     -> "none"
        }
    }

}

//---------------------------------------------------------------------------------------------------------------------

