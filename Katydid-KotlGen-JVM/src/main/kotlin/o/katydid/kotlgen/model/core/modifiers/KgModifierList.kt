//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.kotlgen.model.core.modifiers

//---------------------------------------------------------------------------------------------------------------------

class KgModifierList {

    private val myModifiers = mutableListOf<KgModifier>()

    ////

    fun add(modifier: KgModifier) =
        myModifiers.add(modifier)

    fun add(modifiers: KgModifierList) {
        myModifiers.addAll(modifiers.myModifiers)
    }

    fun contains(keyword: KgModifierKeyword): Boolean =
        myModifiers.find { it.keyword == keyword } != null

    operator fun plusAssign(modifier: KgModifier) {
        myModifiers.add(modifier)
    }

    override fun toString(): String =
        myModifiers.joinToString(" ") { it.toString() }

}

//---------------------------------------------------------------------------------------------------------------------

