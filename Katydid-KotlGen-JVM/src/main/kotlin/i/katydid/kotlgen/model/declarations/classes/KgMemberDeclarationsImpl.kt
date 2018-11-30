//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.kotlgen.model.declarations.classes

import i.katydid.kotlgen.model.declarations.KgNonlocalDeclarationsImpl
import o.katydid.kotlgen.model.declarations.classes.KgMemberDeclaring
import o.katydid.kotlgen.model.declarations.functions.KgAnonymousInitializer
import o.katydid.kotlgen.model.declarations.functions.KgInfixMemberFunction
import o.katydid.kotlgen.model.declarations.functions.KgOperatorMemberFunction
import o.katydid.kotlgen.model.declarations.functions.KgSecondaryConstructor
import o.katydid.kotlgen.model.declarations.objects.KgCompanionObject
import o.katydid.kotlgen.model.types.KgType

//---------------------------------------------------------------------------------------------------------------------

internal open class KgMemberDeclarationsImpl
    : KgNonlocalDeclarationsImpl(), KgMemberDeclaring {

    override fun `companion object`(itsName: String?, build: KgCompanionObject.() -> Unit): KgCompanionObject {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun `constructor`(itsName: String?, build: KgSecondaryConstructor.() -> Unit): KgSecondaryConstructor {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun `infix fun`(itsName: String, itsType: KgType, build: KgInfixMemberFunction.() -> Unit): KgInfixMemberFunction {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun `init`(build: KgAnonymousInitializer.() -> Unit): KgAnonymousInitializer {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun `operator fun`(itsName: String, itsType: KgType, build: KgOperatorMemberFunction.() -> Unit): KgOperatorMemberFunction {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}

//---------------------------------------------------------------------------------------------------------------------
