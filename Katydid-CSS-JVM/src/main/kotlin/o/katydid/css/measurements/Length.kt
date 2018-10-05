//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.measurements

import x.katydid.css.infrastructure.makeDecimalString

//---------------------------------------------------------------------------------------------------------------------

class Length(
    val length: Float,
    val unit: LengthUnit
) {

    val isNotNegative
        get() = length >= 0

    ////

    override fun equals(other: Any?): Boolean {
        if (other is Length) {
            return length == other.length && unit == other.unit
        }
        return false
    }

    operator fun unaryMinus() =
        Length(-length, unit)

    override fun hashCode(): Int {
        var result = length.hashCode()
        result = 31 * result + unit.hashCode()
        return result
    }

    override fun toString(): String =
        if (length == 0f) "0" else "${makeDecimalString(length)}$unit"

}

//---------------------------------------------------------------------------------------------------------------------

fun length(s: String): Length {

    var unit = s.takeLast(4)

    when (unit) {
        "vmax" -> return Length(s.dropLast(4).toFloat(), LengthUnit.VIEW_PORT_MAXIMUM_01)
        "vmin" -> return Length(s.dropLast(4).toFloat(), LengthUnit.VIEW_PORT_MINIMUM_01)
    }

    unit = s.takeLast(3)

    when (unit) {
        "rem" -> return Length(s.dropLast(3).toFloat(), LengthUnit.FONT_SIZE_ROOT_ELEMENT)
    }

    unit = s.takeLast(2)

    when (unit) {
        "px" -> return Length(s.dropLast(2).toFloat(), LengthUnit.PIXEL)
        "pt" -> return Length(s.dropLast(2).toFloat(), LengthUnit.POINT)
        "em" -> return Length(s.dropLast(2).toFloat(), LengthUnit.FONT_SIZE_ELEMENT)

        "ch" -> return Length(s.dropLast(2).toFloat(), LengthUnit.ZERO_WIDTH)
        "cm" -> return Length(s.dropLast(2).toFloat(), LengthUnit.CENTIMETER)
        "ex" -> return Length(s.dropLast(2).toFloat(), LengthUnit.X_HEIGHT)
        "in" -> return Length(s.dropLast(2).toFloat(), LengthUnit.INCH)
        "mm" -> return Length(s.dropLast(2).toFloat(), LengthUnit.MILLIMETER)
        "pc" -> return Length(s.dropLast(2).toFloat(), LengthUnit.PICA)
        "vh" -> return Length(s.dropLast(2).toFloat(), LengthUnit.VIEW_PORT_HEIGHT_01)
        "vw" -> return Length(s.dropLast(2).toFloat(), LengthUnit.VIEW_PORT_WIDTH_01)
    }

    unit = s.takeLast(1)

    when (unit) {
        "Q" -> return Length(s.dropLast(1).toFloat(), LengthUnit.QUARTER_MILLIMETER)
    }

    return Length(s.toFloat(), LengthUnit.PIXEL)

}

//---------------------------------------------------------------------------------------------------------------------

fun length(value: Any): Length =
    when (value) {
        is Number -> Length(value.toFloat(), LengthUnit.PIXEL)
        is String -> length(value)
        is Length -> value
        else      -> throw IllegalArgumentException(
            "Cannot create Length from '$value'.")
    }

//---------------------------------------------------------------------------------------------------------------------

val Number.ch
    get() = Length(this.toFloat(), LengthUnit.ZERO_WIDTH)

val Number.cm
    get() = Length(this.toFloat(), LengthUnit.CENTIMETER)

val Number.em
    get() = Length(this.toFloat(), LengthUnit.FONT_SIZE_ELEMENT)

val Number.ex
    get() = Length(this.toFloat(), LengthUnit.X_HEIGHT)

val Number.inch
    get() = Length(this.toFloat(), LengthUnit.INCH)

val Number.mm
    get() = Length(this.toFloat(), LengthUnit.MILLIMETER)

val Number.pc
    get() = Length(this.toFloat(), LengthUnit.PICA)

val Number.pt
    get() = Length(this.toFloat(), LengthUnit.POINT)

val Number.px
    get() = Length(this.toFloat(), LengthUnit.PIXEL)

val Number.Q
    get() = Length(this.toFloat(), LengthUnit.QUARTER_MILLIMETER)

val Number.rem
    get() = Length(this.toFloat(), LengthUnit.FONT_SIZE_ROOT_ELEMENT)

val Number.vh
    get() = Length(this.toFloat(), LengthUnit.VIEW_PORT_HEIGHT_01)

val Number.vmax
    get() = Length(this.toFloat(), LengthUnit.VIEW_PORT_MAXIMUM_01)

val Number.vmin
    get() = Length(this.toFloat(), LengthUnit.VIEW_PORT_MINIMUM_01)

val Number.vw
    get() = Length(this.toFloat(), LengthUnit.VIEW_PORT_WIDTH_01)

//---------------------------------------------------------------------------------------------------------------------

