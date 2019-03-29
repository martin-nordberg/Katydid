//
// (C) Copyright 2019 Martin E. Nordberg III
// Apache 2.0 License
//

package js.katydid.samples.wipcards.boardname

import o.katydid.css.colors.lightseagreen
import o.katydid.css.measurements.px
import o.katydid.css.styles.builders.*
import o.katydid.css.stylesheets.KatydidStyleSheet
import o.katydid.css.types.EDisplay
import o.katydid.css.types.EFontWeight
import o.katydid.css.types.EPosition

//---------------------------------------------------------------------------------------------------------------------

internal const val cssClassName = "board-name"

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyleSheet.boardNameStyles() {

    /* DIALOG */
    "dialog.$cssClassName" {

        backgroundColor(lightseagreen)
        borderColor(lightseagreen)
        display(EDisplay.inlineTable)
        padding(2.px)
        position(EPosition.relative)

        "input" {
            borderColor(lightseagreen)
            fontSize(22.px)
            fontWeight(EFontWeight.bold)
        }

    }

    /* H1 */
    "h1.$cssClassName" {

        fontSize(25.px)
        margin(5.px, 0.px, 5.px, 5.px)

    }

}

//---------------------------------------------------------------------------------------------------------------------
