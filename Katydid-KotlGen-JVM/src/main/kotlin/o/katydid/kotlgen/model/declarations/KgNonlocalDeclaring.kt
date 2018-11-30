//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

@file:Suppress("RemoveRedundantBackticks", "FunctionName")

package o.katydid.kotlgen.model.declarations

import o.katydid.kotlgen.model.declarations.classes.KgAnnotationClass
import o.katydid.kotlgen.model.declarations.classes.KgEnumClass
import o.katydid.kotlgen.model.declarations.classes.KgInterface
import o.katydid.kotlgen.model.declarations.objects.KgObject

//---------------------------------------------------------------------------------------------------------------------

interface KgNonlocalDeclaring
    : KgDeclaring {

    ////

    fun `annotation class`(
        itsName: String,
        build: KgAnnotationClass.() -> Unit
    ): KgAnnotationClass

    fun `enum class`(
        itsName: String,
        build: KgEnumClass.() -> Unit
    ): KgEnumClass

    fun `interface`(
        itsName: String,
        build: KgInterface.() -> Unit
    ): KgInterface

    fun `object`(
        itsName: String,
        build: KgObject.() -> Unit
    ): KgObject

}

//---------------------------------------------------------------------------------------------------------------------

