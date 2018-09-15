//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.vdom.types

//---------------------------------------------------------------------------------------------------------------------

/**
 * Enumeration of allowed values for an iframe's sandbox attribute.
 */
@Suppress("EnumEntryName")
enum class ESandboxOption(
    private val html: String
) {

    /** The "allow-forms" attribute value. */
    allowForms("allow-forms"),

    /** The "allow-pointer-lock" attribute value. */
    allowPointerLock("allow-pointer-lock"),

    /** The "allow-popups" attribute value. */
    allowPopups("allow-popups"),

    /** The "allow-presentation" attribute value. */
    allowPresentation("allow-presentation"),

    /** The "allow-same-origin" attribute value. */
    allowSameOrigin("allow-same-origin"),

    /** The "allow-scripts" attribute value. */
    allowScripts("allow-scripts"),

    /** The "allow-top-navigation" attribute value. */
    allowTopNavigation("allow-top-navigation");

    ////

    /** @return the HTML attribute text for this direction. */
    fun toHtmlString() =
        html

}

//---------------------------------------------------------------------------------------------------------------------



