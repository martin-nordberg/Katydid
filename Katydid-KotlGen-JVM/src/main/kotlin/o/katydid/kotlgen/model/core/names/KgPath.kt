//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.kotlgen.model.core.names

import o.katydid.kotlgen.model.core.KgOrigin
import o.katydid.kotlgen.model.core.KgOriginUnspecified

//---------------------------------------------------------------------------------------------------------------------

/**
 * Class representing a sequence of nested names.
 */
class KgPath {

    /**
     * Constructs a path from its outermost name [itsName] and [itsNameOrigin] along with a sub-path [itsRemainder]
     * that holds the rest of the path recursively.
     */
    constructor(
        itsName: String,
        itsNameOrigin: KgOrigin,
        itsRemainder: KgPath?
    ) {
        name = itsName
        nameOrigin = itsNameOrigin
        remainder = itsRemainder
    }

    /**
     * Constructs a path from a sequence of names [itsQualifiedName] separated by a given delimiter [separator].
     */
    constructor(
        itsQualifiedName: String,
        separator: Char = '.'
    ) {
        val names = itsQualifiedName.split(separator, limit = 2)
        name = names[0]
        nameOrigin = KgOriginUnspecified
        remainder = if (names.size == 1) null else KgPath(names[1], separator)
    }

    ////

    /** The outermost name of this path. */
    var name: String

    /** The origin of the outermost name of this path. */
    var nameOrigin: KgOrigin

    /** The sub-path containing the remainder of the path. */
    val remainder: KgPath?

    /** The full text of the path (all its names from outermost to innermost separated by "."). */
    val text
        get() = toString()

    ////

    /**
     * Tests whether this path is equal to the [other] path. Equality testing compares the sequence of names but
     * ignores their origins.
     */
    override fun equals(other: Any?): Boolean =
        this === other || (other is KgPath && name == other.name && remainder == other.remainder)

    /**
     * Computes a hashcode for the path from its names (ignoring its origins).
     */
    override fun hashCode() =
        name.hashCode() + remainder.hashCode()

    /**
     * Computes the full text of the path (all its names from outermost to innermost separated by ".").
     */
    override fun toString(): String =
        toString(".")

    /**
     * Computes the full text of the path (all its names from outermost to innermost separated by the given
     * [separator]).
     */
    fun toString(separator: String): String {

        if (remainder == null) {
            return name
        }

        return name + separator + remainder.toString(separator)

    }

}

//---------------------------------------------------------------------------------------------------------------------

