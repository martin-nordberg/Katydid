//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.styles.builders

import o.katydid.css.styles.KatydidStyle

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.orphans(value: Int) {
    require(value > 0) { "CSS orphans property must be greater than zero." }
    setProperty("orphans", "$value")
}

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.widows(value: Int) {
    require(value > 0) { "CSS widows property must be greater than zero." }
    setProperty("widows", "$value")
}

//---------------------------------------------------------------------------------------------------------------------
