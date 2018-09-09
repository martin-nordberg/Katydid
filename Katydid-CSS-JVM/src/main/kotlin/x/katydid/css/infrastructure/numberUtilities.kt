//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package x.katydid.css.infrastructure


fun makeDecimalString( number: Float) : String {
    return String.format("%.3f", number).trimEnd('0').trimEnd('.')
}