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

class KgModifier(
    val keyword: KgModifierKeyword,
    override var origin: KgOrigin
) : KgCodeElement {

    constructor(
        keyword: String,
        origin: KgOrigin = KgOriginUnspecified
    ) : this(KgModifierKeyword.valueOf(keyword), origin)

    val text: String =
        keyword.toString()

    override fun equals(other: Any?): Boolean =
        other is KgModifier && keyword == other.keyword

    override fun hashCode(): Int =
        keyword.hashCode()

    override fun toString(): String =
        text

}

//---------------------------------------------------------------------------------------------------------------------


