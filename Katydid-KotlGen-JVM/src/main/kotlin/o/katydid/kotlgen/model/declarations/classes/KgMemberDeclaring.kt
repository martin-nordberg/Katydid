//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

@file:Suppress("FunctionName")

package o.katydid.kotlgen.model.declarations.classes

import o.katydid.kotlgen.model.declarations.KgNonlocalDeclaring
import o.katydid.kotlgen.model.declarations.functions.KgAnonymousInitializer
import o.katydid.kotlgen.model.declarations.functions.KgInfixMemberFunction
import o.katydid.kotlgen.model.declarations.functions.KgOperatorMemberFunction
import o.katydid.kotlgen.model.declarations.functions.KgSecondaryConstructor
import o.katydid.kotlgen.model.declarations.objects.KgCompanionObject

//---------------------------------------------------------------------------------------------------------------------

interface KgMemberDeclaring
    : KgNonlocalDeclaring {

    val members
        get() = declarations

    ////

    fun `companion object`(
        itsName: String? = null,
        build: KgCompanionObject.() -> Unit
    ): KgCompanionObject

    fun `constructor`(
        itsName: String? = null,
        build: KgSecondaryConstructor.() -> Unit
    ): KgSecondaryConstructor

    fun `infix fun`(
        itsName: String,
        build: KgInfixMemberFunction.() -> Unit
    ): KgInfixMemberFunction

    fun `init`(
        build: KgAnonymousInitializer.() -> Unit
    ): KgAnonymousInitializer

    fun `operator fun`(
        itsName: String,
        build: KgOperatorMemberFunction.() -> Unit
    ): KgOperatorMemberFunction

}

//---------------------------------------------------------------------------------------------------------------------

@Suppress("unused")
private fun kgMemberDeclaring(element: KgMemberDeclaring) {

    element.apply {

        `companion object` {

            `private`

//            `fun`( "doStuff", ... ) {
//                ...
//            }

        }

    }
}

//---------------------------------------------------------------------------------------------------------------------
