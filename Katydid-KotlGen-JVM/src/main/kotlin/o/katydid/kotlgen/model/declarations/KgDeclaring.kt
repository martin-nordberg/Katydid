//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

@file:Suppress("RemoveRedundantBackticks", "FunctionName")

package o.katydid.kotlgen.model.declarations

import o.katydid.kotlgen.model.core.names.KgNamed
import o.katydid.kotlgen.model.declarations.classes.KgClass
import o.katydid.kotlgen.model.declarations.classes.KgDataClass
import o.katydid.kotlgen.model.declarations.functions.KgExtensionFunction
import o.katydid.kotlgen.model.declarations.functions.KgFunction
import o.katydid.kotlgen.model.declarations.functions.KgInfixExtensionFunction
import o.katydid.kotlgen.model.declarations.functions.KgOperatorExtensionFunction
import o.katydid.kotlgen.model.declarations.properties.KgReadOnlyProperty
import o.katydid.kotlgen.model.declarations.properties.KgReadWriteProperty
import o.katydid.kotlgen.model.types.KgType

//---------------------------------------------------------------------------------------------------------------------

/**
 * Interface to a code element that declares other code entities.
 */
interface KgDeclaring {

    /* The declarations declared by this code element. */
    val declarations: Iterable<KgDeclaration>

    ////

    fun `class`(
        itsName: String,
        build: KgClass.() -> Unit
    ): KgClass

    fun `data class`(
        itsName: String,
        build: KgDataClass.() -> Unit
    ): KgDataClass

    fun `ext fun`(
        itsReceiverType: KgType,
        itsName: String,
        build: KgExtensionFunction.() -> Unit
    ): KgExtensionFunction

    fun `fun`(
        itsName: String,
        build: KgFunction.() -> Unit
    ): KgFunction

    fun `infix ext fun`(
        itsReceiverType: KgType,
        itsName: String,
        build: KgInfixExtensionFunction.() -> Unit
    ): KgInfixExtensionFunction

    fun `operator ext fun`(
        itsReceiverType: KgType,
        itsName: String,
        build: KgOperatorExtensionFunction.() -> Unit
    ): KgOperatorExtensionFunction

    fun `val`(
        itsName: String,
        build: KgReadOnlyProperty.() -> Unit
    ): KgReadOnlyProperty

    fun `var`(
        itsName: String,
        build: KgReadWriteProperty.() -> Unit
    ): KgReadWriteProperty

}

//---------------------------------------------------------------------------------------------------------------------

inline fun <reified T> KgDeclaring.declarationByName(name: String): T?
    where T : KgNamed, T : KgDeclaration =
    declarations.find { d -> d is T && d.name == name } as T?

//---------------------------------------------------------------------------------------------------------------------

inline fun <reified T : KgDeclaration> KgDeclaring.declarationsOfType(): List<T> {

    val result = mutableListOf<T>()

    for (declaration in declarations) {
        if (declaration is T) {
            result.add(declaration)
        }
    }

    return result

}

//---------------------------------------------------------------------------------------------------------------------

