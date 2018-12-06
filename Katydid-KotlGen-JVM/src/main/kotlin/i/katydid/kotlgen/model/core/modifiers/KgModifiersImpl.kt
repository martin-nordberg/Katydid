//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.kotlgen.model.core.modifiers

import o.katydid.kotlgen.model.core.modifiers.KgModified
import o.katydid.kotlgen.model.core.modifiers.KgModifierKeyword
import o.katydid.kotlgen.model.core.modifiers.KgModifierList

//---------------------------------------------------------------------------------------------------------------------

internal class KgModifiersImpl
    : KgModified {

    override val `abstract`: Unit
        get() = modifiers.add(KgModifierKeyword.`abstract`)

    override val `actual`: Unit
        get() = modifiers.add(KgModifierKeyword.`actual`)

    override val `annotation`: Unit
        get() = modifiers.add(KgModifierKeyword.`annotation`)

    override val `const`: Unit
        get() = modifiers.add(KgModifierKeyword.`const`)

    override val `crossinline`: Unit
        get() = modifiers.add(KgModifierKeyword.`crossinline`)

    override val `data`: Unit
        get() = modifiers.add(KgModifierKeyword.`data`)

    override val `enum`: Unit
        get() = modifiers.add(KgModifierKeyword.`enum`)

    override val `expect`: Unit
        get() = modifiers.add(KgModifierKeyword.`expect`)

    override val `external`: Unit
        get() = modifiers.add(KgModifierKeyword.`external`)

    override val `final`: Unit
        get() = modifiers.add(KgModifierKeyword.`final`)

    override val `in`: Unit
        get() = modifiers.add(KgModifierKeyword.`in`)

    override val `infix`: Unit
        get() = modifiers.add(KgModifierKeyword.`infix`)

    override val `inline`: Unit
        get() = modifiers.add(KgModifierKeyword.`inline`)

    override val `internal`: Unit
        get() = modifiers.add(KgModifierKeyword.`internal`)

    override val `lateinit`: Unit
        get() = modifiers.add(KgModifierKeyword.`lateinit`)

    override val modifiers: KgModifierList = KgModifierList()

    override val `noinline`: Unit
        get() = modifiers.add(KgModifierKeyword.`noinline`)

    override val `open`: Unit
        get() = modifiers.add(KgModifierKeyword.`open`)

    override val `operator`: Unit
        get() = modifiers.add(KgModifierKeyword.`operator`)

    override val `out`: Unit
        get() = modifiers.add(KgModifierKeyword.`out`)

    override val `override`: Unit
        get() = modifiers.add(KgModifierKeyword.`override`)

    override val `private`: Unit
        get() = modifiers.add(KgModifierKeyword.`private`)

    override val `protected`: Unit
        get() = modifiers.add(KgModifierKeyword.`protected`)

    override val `public`: Unit
        get() = modifiers.add(KgModifierKeyword.`public`)

    override val `reified`: Unit
        get() = modifiers.add(KgModifierKeyword.`reified`)

    override val `sealed`: Unit
        get() = modifiers.add(KgModifierKeyword.`sealed`)

    override val `suspend`: Unit
        get() = modifiers.add(KgModifierKeyword.`suspend`)

    override val `tailrec`: Unit
        get() = modifiers.add(KgModifierKeyword.`tailrec`)

    override val `vararg`: Unit
        get() = modifiers.add(KgModifierKeyword.`vararg`)


    override fun mergeModifiers(moreModifiers: KgModifierList) =
        modifiers.add(moreModifiers)

}

//---------------------------------------------------------------------------------------------------------------------
