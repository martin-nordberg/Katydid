//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.measurements

import x.katydid.css.infrastructure.makeDecimalString

//---------------------------------------------------------------------------------------------------------------------

class Percentage(
    val amount: Float
) {

    val isNotNegative
        get() = amount >= 0

    ////

    override fun equals(other: Any?): Boolean {
        if (other is Percentage) {
            return amount == other.amount
        }
        return false
    }

    override fun hashCode(): Int {
        return amount.hashCode()
    }

    override fun toString(): String =
        if (amount == 0f) "0" else "${makeDecimalString(amount)}%"

    operator fun unaryMinus() =
        Percentage(-amount)

}

//---------------------------------------------------------------------------------------------------------------------

fun percentage(s: String): Percentage {

    if (s.takeLast(1) == "%") {
        return Percentage(s.dropLast(1).toFloat())
    }

    throw IllegalArgumentException("Not a valid percentage: \"$s\".")

}

//---------------------------------------------------------------------------------------------------------------------

fun percentage(value: Any): Percentage =
    when (value) {
        is String     -> percentage(value)
        is Percentage -> value
        else          -> throw IllegalArgumentException(
            "Cannot create Percentage from '${value}'.")
    }

//---------------------------------------------------------------------------------------------------------------------

val Number.percent
    get() = Percentage(this.toFloat())

//---------------------------------------------------------------------------------------------------------------------

