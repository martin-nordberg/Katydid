//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.vdom.types

//---------------------------------------------------------------------------------------------------------------------

/**
 * Enumeration of allowed values for the enctype attribute for a form element.
 * See https://www.w3.org/TR/html51/sec-forms.html#element-attrdef-submitbuttonelements-formenctype.
 */
@Suppress("EnumEntryName")
enum class EFormEncodingType(
    private val html: String
) {

    /** Encoding type "multipart/form-data". */
    multipartFormData("multipart/form-data"),

    /** Encoding type "text/plain". */
    textPlain("text/plain"),

    /** Encoding type "application/x-www-form-urlencoded". */
    wwwFormUrlEncoded("application/x-www-form-urlencoded");

    ////

    /** @return the corresponding HTML attribute value for this encoding type. */
    fun toHtmlString() =
        html

}

//---------------------------------------------------------------------------------------------------------------------

