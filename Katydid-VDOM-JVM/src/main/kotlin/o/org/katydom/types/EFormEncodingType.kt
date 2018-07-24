//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.org.katydom.types

//---------------------------------------------------------------------------------------------------------------------

/**
 * Enumeration of allowed values for the enctype attribute for a form element.
 * See https://www.w3.org/TR/html51/sec-forms.html#element-attrdef-submitbuttonelements-formenctype.
 */
enum class EFormEncodingType {

    /** Encoding type "multipart/form-data". */
    MULTIPART_FORM_DATA,

    /** Encoding type "text/plain". */
    TEXT_PLAIN,

    /** Encoding type "application/x-www-form-urlencoded". */
    WWW_FORM_URL_ENCODED;

    /** @return the corresponding HTML attribute value for this encoding type. */
    fun toHtmlString(): String {
        return when (this) {
            MULTIPART_FORM_DATA  -> "multipart/form-data"
            TEXT_PLAIN           -> "text/plain"
            WWW_FORM_URL_ENCODED -> "application/x-www-form-urlencoded"
        }
    }

}

//---------------------------------------------------------------------------------------------------------------------

