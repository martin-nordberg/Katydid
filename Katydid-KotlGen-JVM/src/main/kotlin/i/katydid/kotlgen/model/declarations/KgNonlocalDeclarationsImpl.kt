//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.kotlgen.model.declarations

import i.katydid.kotlgen.model.declarations.classes.KgEnumClassImpl
import o.katydid.kotlgen.model.declarations.KgNonlocalDeclaring
import o.katydid.kotlgen.model.declarations.classes.KgAnnotationClass
import o.katydid.kotlgen.model.declarations.classes.KgEnumClass
import o.katydid.kotlgen.model.declarations.classes.KgInterface
import o.katydid.kotlgen.model.declarations.declarationByName
import o.katydid.kotlgen.model.declarations.objects.KgObject

//---------------------------------------------------------------------------------------------------------------------

internal open class KgNonlocalDeclarationsImpl
    : KgDeclarationsImpl(), KgNonlocalDeclaring {

    override fun `annotation class`(itsName: String, build: KgAnnotationClass.() -> Unit): KgAnnotationClass {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun `enum class`(itsName: String, build: KgEnumClass.() -> Unit): KgEnumClassImpl {

        var result = declarationByName<KgEnumClassImpl>(itsName)

        if (result == null) {
            result = KgEnumClassImpl(itsName)
            declarations.add(result)
        }

        result.build()

        return result

    }

    override fun `interface`(itsName: String, build: KgInterface.() -> Unit): KgInterface {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun `object`(itsName: String, build: KgObject.() -> Unit): KgObject {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}

//---------------------------------------------------------------------------------------------------------------------
