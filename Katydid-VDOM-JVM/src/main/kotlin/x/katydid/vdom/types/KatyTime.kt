//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package /*jvm*/x.katydid.vdom.types

import java.time.OffsetTime

//---------------------------------------------------------------------------------------------------------------------

/** Katydid time on JVM is Java's OffsetTime. */
typealias KatyTime = OffsetTime

//---------------------------------------------------------------------------------------------------------------------

/**
 * Converts a time input [time] to a string output formatted as an HTML time.
 */
fun formatHtmlTime(time: KatyTime): String {
    return time.toString()
}

//---------------------------------------------------------------------------------------------------------------------
