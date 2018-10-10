//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.styles.builders

import o.katydid.css.styles.Style
import o.katydid.css.types.ECursor

//---------------------------------------------------------------------------------------------------------------------

fun Style.cursor(value: ECursor) =
    setProperty("cursor", "$value")

//---------------------------------------------------------------------------------------------------------------------
