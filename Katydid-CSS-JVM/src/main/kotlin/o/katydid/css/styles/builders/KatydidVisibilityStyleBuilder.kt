//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.styles.builders

import o.katydid.css.styles.KatydidStyle
import o.katydid.css.types.EVisibility

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.visibility(value: EVisibility) =
    setProperty("visibility", "$value")

//---------------------------------------------------------------------------------------------------------------------
