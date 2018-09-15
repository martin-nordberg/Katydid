//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.vdom.types

//---------------------------------------------------------------------------------------------------------------------

/**
 * Enumeration of allowed values for the kind attribute of a track element.
 */
@Suppress("EnumEntryName")
enum class ETrackKind(
    private val html: String
) {

    /** The "captions" attribute value. */
    captions("captions"),

    /** The "chapters" attribute value. */
    chapters("chapters"),

    /** The "descriptions" attribute value. */
    descriptions("descriptions"),

    /** The "metadata" attribute value. */
    metadata("metadata"),

    /** The "subtitles" attribute value. */
    subtitles("subtitles");

    ////

    /** @return the HTML attribute text for this direction. */
    fun toHtmlString() =
        html

}

//---------------------------------------------------------------------------------------------------------------------

