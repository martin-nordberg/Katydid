//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.styles.builders

import o.katydid.css.styles.KatydidStyle
import o.katydid.css.types.EContent

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.content(value: EContent) =
    setProperty("content", "$value")

fun KatydidStyle.content(value: String) =
    setStringProperty("content", value)

//---------------------------------------------------------------------------------------------------------------------
