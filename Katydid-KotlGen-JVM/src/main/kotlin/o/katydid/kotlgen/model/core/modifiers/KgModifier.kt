//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

@file:Suppress("RemoveRedundantBackticks", "EnumEntryName")

package o.katydid.kotlgen.model.core.modifiers

import o.katydid.kotlgen.model.core.KgCodeElement
import o.katydid.kotlgen.model.core.KgOrigin
import o.katydid.kotlgen.model.core.KgOriginUnspecified

//---------------------------------------------------------------------------------------------------------------------

/**
 * An enumeration of all possible modifier keywords. Note that they appear in the order appropriate for source
 * code output.
 */
enum class KgModifierKeyword {
    `actual`,
    `expect`,
    `public`,
    `protected`,
    `internal`,
    `private`,
    `open`,
    `final`,
    `abstract`,
    `const`,
    `enum`,
    `data`,
    `annotation`,
    `sealed`,
    `inner`,
    `override`,
    `inline`,
    `noinline`,
    `crossinline`,
    `external`,
    `infix`,
    `operator`,
    `reified`,
    `lateinit`,
    `suspend`,
    `tailrec`,
    `vararg`,
    `in`,
    `out`
}


//---------------------------------------------------------------------------------------------------------------------

/**
 * Class representing one code element modifier, consisting of its keyword and its origin.
 */
class KgModifier(
    val keyword: KgModifierKeyword,
    override var origin: KgOrigin
) : KgCodeElement {

    /**
     * Constructs a modifier from [itsKeyword] and [itsOrigin].
     */
    constructor(
        itsKeyword: String,
        itsOrigin: KgOrigin = KgOriginUnspecified
    ) : this(KgModifierKeyword.valueOf(itsKeyword), itsOrigin)

    ////

    /** The code equivalent to this modifier; the text of its keyword. */
    val text: String =
        keyword.toString()

    ////

    /**
     * Tests whether this modifier has the same keyword as another one (ignoring origin differences).
     */
    override fun equals(other: Any?): Boolean =
        other is KgModifier && keyword == other.keyword

    /**
     * Computes a hash code for this modifier from its keyword (ignoring its origin).
     */
    override fun hashCode(): Int =
        keyword.hashCode()

    /**
     * Computes the code equivalent to this modifier; the text of its keyword.
     */
    override fun toString(): String =
        text

}

//---------------------------------------------------------------------------------------------------------------------


