//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.kotlgen.model.core.names

import o.katydid.kotlgen.model.core.KgOrigin
import o.katydid.kotlgen.model.core.KgOriginUnspecified

//---------------------------------------------------------------------------------------------------------------------

class KgPath {

    constructor(
        itsName: String,
        itsNameOrigin: KgOrigin,
        itsRemainder: KgPath?
    ) {
        name = itsName
        nameOrigin = itsNameOrigin
        remainder = itsRemainder
    }

    constructor(
        itsQualifiedName: String,
        separator: Char = '.'
    ) {
        val names = itsQualifiedName.split(separator, limit = 2)
        name = names[0]
        nameOrigin = KgOriginUnspecified
        remainder = if (names.size == 1) null else KgPath(names[1])
    }

    ////

    var name: String

    var nameOrigin: KgOrigin

    val remainder: KgPath?

    val text
        get() = toString()

    ////

    override fun equals(other: Any?): Boolean =
        this === other || (other is KgPath && name == other.name && remainder == other.remainder)

    override fun hashCode() =
        name.hashCode() + remainder.hashCode()

    override fun toString(): String =
        toString(".")

    fun toString(separator: String): String {

        if (remainder == null) {
            return name
        }

        return name + separator + remainder.toString()

    }

}

//---------------------------------------------------------------------------------------------------------------------

