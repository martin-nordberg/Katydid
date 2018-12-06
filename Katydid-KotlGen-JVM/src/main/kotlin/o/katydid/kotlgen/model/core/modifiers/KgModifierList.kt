//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.kotlgen.model.core.modifiers

import o.katydid.kotlgen.model.core.KgOrigin
import o.katydid.kotlgen.model.core.KgOriginUnspecified
import o.katydid.kotlgen.model.core.modifiers.KgModifierKeyword.*

//---------------------------------------------------------------------------------------------------------------------

class KgModifierList {

    private val myModifiers = mutableMapOf<KgModifierKeyword, KgModifier>()

    ////

    val keywords
        get() = myModifiers.keys.sortedBy { it.ordinal }

    ////

    fun add(modifier: KgModifier) {
        myModifiers.put(modifier.keyword, modifier)
    }

    fun add(keyword: KgModifierKeyword) {
        myModifiers.put(keyword, KgModifier(keyword,KgOriginUnspecified))
    }

    fun add(modifiers: KgModifierList) {
        for (modifier in modifiers.myModifiers.values) {
            add(modifier)
        }
    }

    fun contains(keyword: KgModifierKeyword): Boolean =
        myModifiers.get(keyword) != null

    fun getOrigin(keyword: KgModifierKeyword): KgOrigin {
        val modifier = myModifiers.get(keyword)
        require(modifier != null) { "Keyword ${keyword.name} not in the list." }
        return modifier.origin
    }

    operator fun plusAssign(modifier: KgModifier) {
        add(modifier)
    }

    override fun toString(): String {

        val result = mutableListOf<String>()

        when {
            contains(`actual`) -> result.add("actual")
            contains(`expect`) -> result.add("expect")
        }

        when {
            contains(`public`)    -> result.add("public")
            contains(`protected`) -> result.add("protected")
            contains(`internal`)  -> result.add("internal")
            contains(`private`)   -> result.add("private")
        }

        when {
            contains(`open`)     -> result.add("open")
            contains(`final`)    -> result.add("final")
            contains(`abstract`) -> result.add("abstract")
            contains(`const`)    -> result.add("const")
        }

        when {
            contains(`enum`)       -> result.add("enum")
            contains(`data`)       -> result.add("data")
            contains(`annotation`) -> result.add("annotation")
            contains(`sealed`)     -> result.add("sealed")
            contains(`inner`)      -> result.add("inner")

            contains(`override`)   -> result.add("override")
        }

        when {
            contains(`inline`)      -> result.add("inline")
            contains(`noinline`)    -> result.add("noinline")
            contains(`crossinline`) -> result.add("crossinline")
            contains(`external`)    -> result.add("external")
        }

        when {
            contains(`infix`) -> result.add("infix")
        }

        when {
            contains(`operator`) -> result.add("operator")
        }

        when {
            contains(`reified`) -> result.add("reified")
        }

        when {
            contains(`lateinit`) -> result.add("lateinit")
            contains(`suspend`)  -> result.add("suspend")
        }

        when {
            contains(`tailrec`) -> result.add("tailrec")
        }

        when {
            contains(`vararg`) -> result.add("vararg")
        }

        when {
            contains(`in`)  -> result.add("in")
            contains(`out`) -> result.add("out")
        }

        return result.joinToString(" ")

    }

}

//---------------------------------------------------------------------------------------------------------------------

