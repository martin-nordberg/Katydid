//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.kotlgen.model.declarations

import o.katydid.kotlgen.model.declarations.KgDeclaration
import o.katydid.kotlgen.model.declarations.KgDeclaring
import o.katydid.kotlgen.model.declarations.classes.KgClass
import o.katydid.kotlgen.model.declarations.classes.KgDataClass
import o.katydid.kotlgen.model.declarations.functions.KgExtensionFunction
import o.katydid.kotlgen.model.declarations.functions.KgFunction
import o.katydid.kotlgen.model.declarations.functions.KgInfixExtensionFunction
import o.katydid.kotlgen.model.declarations.functions.KgOperatorExtensionFunction
import o.katydid.kotlgen.model.declarations.properties.KgAbstractProperty
import o.katydid.kotlgen.model.declarations.properties.KgReadOnlyProperty
import o.katydid.kotlgen.model.types.KgType

//---------------------------------------------------------------------------------------------------------------------

internal abstract class KgDeclarationsImpl
    : KgDeclaring {

    override val declarations: MutableList<KgDeclaration> = mutableListOf()

    ////

    override fun `class`(itsName: String, build: KgClass.() -> Unit): KgClass {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun `data class`(itsName: String, build: KgDataClass.() -> Unit): KgDataClass {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun `ext fun`(itsReceiverType: KgType, itsName: String, build: KgExtensionFunction.() -> Unit): KgExtensionFunction {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun `fun`(itsName: String, build: KgFunction.() -> Unit): KgFunction {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun `infix ext fun`(itsReceiverType: KgType, itsName: String, build: KgInfixExtensionFunction.() -> Unit): KgInfixExtensionFunction {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun `operator ext fun`(itsReceiverType: KgType, itsName: String, build: KgOperatorExtensionFunction.() -> Unit): KgOperatorExtensionFunction {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun `val`(itsName: String, build: KgAbstractProperty.() -> Unit): KgReadOnlyProperty {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun `var`(itsName: String, build: KgAbstractProperty.() -> Unit): KgAbstractProperty {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}

//---------------------------------------------------------------------------------------------------------------------
