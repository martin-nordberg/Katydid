//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package /*jvm*/x.katydid.vdom.types

import java.time.OffsetDateTime

//---------------------------------------------------------------------------------------------------------------------

/** Katydid date/time on JVM is Java's OffsetDateTime. */
typealias KatyDateTime = OffsetDateTime

//---------------------------------------------------------------------------------------------------------------------

/**
 * Converts a date/time input [datetime] to a string output formatted as an HTML date/time.
 * Includes the time even if 0:00.
 */
fun formatHtmlDateTime(datetime: KatyDateTime): String {
    return datetime.toString()
}

//---------------------------------------------------------------------------------------------------------------------
