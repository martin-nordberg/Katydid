//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.styles.builders

import o.katydid.css.styles.Style

//---------------------------------------------------------------------------------------------------------------------

fun Style.orphans(value: Int) {
    require(value > 0) { "CSS orphans property must be greater than zero." }
    setProperty("orphans", "$value")
}

//---------------------------------------------------------------------------------------------------------------------

fun Style.widows(value: Int) {
    require(value > 0) { "CSS widows property must be greater than zero." }
    setProperty("widows", "$value")
}

//---------------------------------------------------------------------------------------------------------------------
