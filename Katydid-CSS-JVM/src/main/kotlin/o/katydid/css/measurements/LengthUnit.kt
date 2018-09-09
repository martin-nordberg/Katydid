//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.measurements


//---------------------------------------------------------------------------------------------------------------------

@Suppress("unused")
enum class LengthUnit {

    CENTIMETER,

    FONT_SIZE_ELEMENT,

    FONT_SIZE_ROOT_ELEMENT,

    INCH,

    MILLIMETER,

    PICA,

    PIXEL,

    POINT,

    QUARTER_MILLIMETER,

    VIEW_PORT_HEIGHT_01,

    VIEW_PORT_MAXIMUM_01,

    VIEW_PORT_MINIMUM_01,

    VIEW_PORT_WIDTH_01,

    X_HEIGHT,

    ZERO_WIDTH;

    ////

	override fun toString() =
		when (this) {
            CENTIMETER             -> "cm"
            FONT_SIZE_ELEMENT      -> "em"
            FONT_SIZE_ROOT_ELEMENT -> "rem"
            INCH                   -> "in"
            MILLIMETER             -> "mm"
            PICA                   -> "pc"
            PIXEL                  -> "px"
            POINT                  -> "pt"
            QUARTER_MILLIMETER     -> "Q"
            VIEW_PORT_HEIGHT_01    -> "vh"
            VIEW_PORT_MAXIMUM_01   -> "vmax"
            VIEW_PORT_MINIMUM_01   -> "vmin"
            VIEW_PORT_WIDTH_01     -> "vw"
            X_HEIGHT               -> "ex"
            ZERO_WIDTH             -> "ch"
        }

    companion object {

        val CH = ZERO_WIDTH
        val CM = CENTIMETER
        val EM = FONT_SIZE_ELEMENT
        val EX = X_HEIGHT
        val IN = INCH
        val MM = MILLIMETER
        val PC = PICA
        val PX = PIXEL
        val PT = POINT
        val Q = QUARTER_MILLIMETER
        val REM = FONT_SIZE_ROOT_ELEMENT
        val VH = VIEW_PORT_HEIGHT_01
        val VMIN = VIEW_PORT_MINIMUM_01
        val VMAX = VIEW_PORT_MAXIMUM_01
        val VW = VIEW_PORT_WIDTH_01

    }
}

//---------------------------------------------------------------------------------------------------------------------

