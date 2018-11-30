//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.kotlgen.model.core.modifiers

import o.katydid.kotlgen.model.core.modifiers.KgModified
import o.katydid.kotlgen.model.core.modifiers.KgModifier
import o.katydid.kotlgen.model.core.modifiers.KgModifierList

//---------------------------------------------------------------------------------------------------------------------

internal class KgModifiersImpl
    : KgModified {

    @Suppress("unused")
    private fun Boolean.ignore() = Unit

    override val `abstract`: Unit
        get() = modifiers.add(KgModifier("abstract")).ignore()

    override val actual: Unit
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    override val annotation: Unit
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    override val const: Unit
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    override val crossinline: Unit
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    override val data: Unit
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    override val enum: Unit
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    override val expected: Unit
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    override val external: Unit
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    override val final: Unit
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    override val `in`: Unit
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    override val infix: Unit
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    override val inline: Unit
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    override val internal: Unit
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    override val lateinit: Unit
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    override val modifiers: KgModifierList = KgModifierList()

    override val noinline: Unit
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    override val open: Unit
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    override val operator: Unit
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    override val out: Unit
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    override val override: Unit
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    override val private: Unit
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    override val protected: Unit
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    override val public: Unit
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    override val reified: Unit
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    override val sealed: Unit
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    override val suspend: Unit
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    override val tailrec: Unit
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    override val vararg: Unit
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    override fun mergeModifiers(moreModifiers: KgModifierList) =
        modifiers.add(moreModifiers)

}

//---------------------------------------------------------------------------------------------------------------------
