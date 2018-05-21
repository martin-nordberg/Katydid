//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package /*jvm*/x.org.katydom.types

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

/** KatyDom date/time on JVM is just Java Date. */
typealias KatyDomDateTime = Date

/**
 * Converts a date/time input [datetime] to a string output formatted as an HTML date/time.
 * Includes the time even if 0:00.
 */
fun formatHtmlDateTime( datetime : KatyDomDateTime) : String {

    val df: DateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ")

    return df.format(datetime)

}

