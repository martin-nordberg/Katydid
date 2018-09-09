//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package x.katydid.css.infrastructure


fun makeDecimalString( number: Float) : String {
    val n = number.asDynamic().toFixed(3)
    return n.trimEnd('0').trimEnd('.')
}
