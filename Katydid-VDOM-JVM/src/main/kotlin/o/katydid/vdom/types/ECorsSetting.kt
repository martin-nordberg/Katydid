//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.vdom.types

//---------------------------------------------------------------------------------------------------------------------

/**
 * Enumeration of allowed values for a CORS setting attribute.
 * See https://www.w3.org/TR/html5/infrastructure.html#cors-settings-attribute.
 */
enum class ECorsSetting {

    /** The "anonymous" attribute value. */
    ANONYMOUS,

    /** The "use-credentials" attribute value. */
    USE_CREDENTIALS;

    /** @return the HTML attribute text for this direction. */
    fun toHtmlString() =
        when (this) {
            ANONYMOUS       -> "anonymous"
            USE_CREDENTIALS -> "use-credentials"
        }

}

//---------------------------------------------------------------------------------------------------------------------

