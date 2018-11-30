//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.kotlgen.model.core.names

import o.katydid.kotlgen.model.core.KgOrigin
import o.katydid.kotlgen.model.core.KgOriginUnspecified

//---------------------------------------------------------------------------------------------------------------------

class KgQualifiedName {

    constructor(
        itsPrefix: KgQualifiedName?,
        itsName: String,
        itsNameOrigin: KgOrigin
    ) {
        prefix = itsPrefix
        name = itsName
        nameOrigin = itsNameOrigin
    }

    constructor(
        itsQualifiedName: String,
        separator: Char = '.'
    ) {

        val separatorIndex = itsQualifiedName.lastIndexOf(separator)

        if (separatorIndex >= 0) {
            prefix = KgQualifiedName(itsQualifiedName.substring(0, separatorIndex), separator)
            name = itsQualifiedName.substring(separatorIndex + 1)
        }
        else {
            prefix = null
            name = itsQualifiedName
        }

        nameOrigin = KgOriginUnspecified

    }

    ////

    val prefix: KgQualifiedName?

    var name: String

    var nameOrigin: KgOrigin

    val text
        get() = toString()

    ////

    override fun equals(other: Any?): Boolean =
        this === other || (other is KgQualifiedName && name == other.name && prefix == other.prefix)

    override fun hashCode() =
        prefix.hashCode() + name.hashCode()

    fun toPath(): KgPath {

        var result = KgPath(name, nameOrigin, null)
        var p = prefix

        while (p != null) {
            result = KgPath(p.name, p.nameOrigin, result)
            p = p.prefix
        }

        return result

    }

    override fun toString(): String {

        if (prefix == null) {
            return name
        }

        return prefix.toString() + "." + name

    }

}

//---------------------------------------------------------------------------------------------------------------------

