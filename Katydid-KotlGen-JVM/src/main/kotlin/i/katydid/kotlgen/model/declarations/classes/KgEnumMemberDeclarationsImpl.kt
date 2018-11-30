//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.kotlgen.model.declarations.classes

import i.katydid.kotlgen.model.declarations.properties.KgEnumEntryImpl
import o.katydid.kotlgen.model.declarations.declarationByName
import o.katydid.kotlgen.model.declarations.properties.KgEnumEntry

//---------------------------------------------------------------------------------------------------------------------

internal class KgEnumMemberDeclarationsImpl()
    : KgMemberDeclarationsImpl(), KgEnumMemberDeclaring {

    override fun `enum entry`(itsName: String, build: KgEnumEntry.() -> Unit): KgEnumEntryImpl {

        var result = declarationByName<KgEnumEntryImpl>(itsName)

        if (result == null) {
            result = KgEnumEntryImpl(itsName)
            declarations.add(result)
        }

        result.build()

        return result

    }

}

//---------------------------------------------------------------------------------------------------------------------
