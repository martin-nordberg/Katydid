//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.measurements


//---------------------------------------------------------------------------------------------------------------------

@Suppress("unused")
enum class LengthUnit(
    private val css: String
) {

    CENTIMETER("cm"),

    FONT_SIZE_ELEMENT("em"),

    FONT_SIZE_ROOT_ELEMENT("rem"),

    INCH("in"),

    MILLIMETER("mm"),

    PICA("pc"),

    PIXEL("px"),

    POINT("pt"),

    QUARTER_MILLIMETER("Q"),

    VIEW_PORT_HEIGHT_01("vh"),

    VIEW_PORT_MAXIMUM_01("vmax"),

    VIEW_PORT_MINIMUM_01("vmin"),

    VIEW_PORT_WIDTH_01("vw"),

    X_HEIGHT("ex"),

    ZERO_WIDTH("ch");

    ////

    override fun toString() =
        css

    companion object {

        val ch = ZERO_WIDTH
        val cm = CENTIMETER
        val em = FONT_SIZE_ELEMENT
        val ex = X_HEIGHT
        val `in` = INCH
        val mm = MILLIMETER
        val pc = PICA
        val px = PIXEL
        val pt = POINT
        val Q = QUARTER_MILLIMETER
        val rem = FONT_SIZE_ROOT_ELEMENT
        val vh = VIEW_PORT_HEIGHT_01
        val vmin = VIEW_PORT_MINIMUM_01
        val vmax = VIEW_PORT_MAXIMUM_01
        val vw = VIEW_PORT_WIDTH_01

    }
}

//---------------------------------------------------------------------------------------------------------------------

