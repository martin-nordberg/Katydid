//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package /*js*/x.katydid.vdom.types

import kotlin.js.Date

//---------------------------------------------------------------------------------------------------------------------

/** KatyDom time is JS is Kotlin Date. */
typealias KatyTime = Date

//---------------------------------------------------------------------------------------------------------------------

/**
 * Converts a date/time input [datetime] to a string output formatted as an HTML date/time.
 * Includes the time even if 0:00.
 */
fun formatHtmlTime(time: KatyDateTime): String {
    return time.toISOString().split("T")[1]
}

//---------------------------------------------------------------------------------------------------------------------

