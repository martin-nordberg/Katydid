//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

@file:Suppress("RemoveRedundantBackticks")

package o.katydid.kotlgen.model.core.modifiers

//---------------------------------------------------------------------------------------------------------------------

/**
 * Interface to a code element that is modified. Covers all possible modifiers, but note that not all modifiers
 * apply to all concrete code elements.
 */
interface KgModified {

    val `abstract`: Unit

    val `actual`: Unit

    val `annotation`: Unit

    val `const`: Unit

    val `crossinline`: Unit

    val `data`: Unit

    val `enum`: Unit

    val `expect`: Unit

    val `external`: Unit

    val `final`: Unit

    val `in`: Unit

    val `infix`: Unit

    val `inline`: Unit

    val `internal`: Unit

    val `lateinit`: Unit

    val modifiers: KgModifierList

    val `noinline`: Unit

    val `open`: Unit

    val `operator`: Unit

    val `out`: Unit

    val `override`: Unit

    val `private`: Unit

    val `protected`: Unit

    val `public`: Unit

    val `reified`: Unit

    val `sealed`: Unit

    val `suspend`: Unit

    val `tailrec`: Unit

    val `vararg`: Unit

    ////

    fun mergeModifiers(moreModifiers: KgModifierList)

}

//---------------------------------------------------------------------------------------------------------------------

@Suppress("unused")
fun kgModifiedExample(m: KgModified) {
    m.apply {
        `private`; `tailrec`
    }
}

//---------------------------------------------------------------------------------------------------------------------

