//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.styles.builders

import o.katydid.css.styles.KatydidStyle
import o.katydid.css.types.ECursor

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.cursor(value: ECursor) =
    setProperty("cursor", "$value")

//---------------------------------------------------------------------------------------------------------------------
