//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.org.katydom.types

//---------------------------------------------------------------------------------------------------------------------

/**
 * Enumeration of allowed values for the kind attribute of a track element.
 */
enum class ETrackKind {

    /** The "captions" attribute value. */
    CAPTIONS,

    /** The "chapters" attribute value. */
    CHAPTERS,

    /** The "descriptions" attribute value. */
    DESCRIPTIONS,

    /** The "metadata" attribute value. */
    METADATA,

    /** The "subtitles" attribute value. */
    SUBTITLES;

    /** @return the HTML attribute text for this direction. */
    fun toHtmlString(): String {
        return when (this) {
            CAPTIONS     -> "captions"
            CHAPTERS     -> "chapters"
            DESCRIPTIONS -> "descriptions"
            METADATA     -> "metadata"
            SUBTITLES    -> "subtitles"
        }
    }

}

//---------------------------------------------------------------------------------------------------------------------

