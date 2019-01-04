//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.kotlgen.model.structure

import i.katydid.kotlgen.model.declarations.KgNonlocalDeclarationsImpl
import i.katydid.kotlgen.model.declarations.KgTypeAliasImpl
import o.katydid.kotlgen.model.declarations.KgTypeAlias
import o.katydid.kotlgen.model.declarations.declarationByName
import o.katydid.kotlgen.model.structure.KgTopLevelDeclaring

//---------------------------------------------------------------------------------------------------------------------

internal open class KgTopLevelDeclarationsImpl
    : KgNonlocalDeclarationsImpl(), KgTopLevelDeclaring {

    override fun `typealias`(itsName: String, build: KgTypeAlias.() -> Unit): KgTypeAlias {

        var result = declarationByName<KgTypeAlias>(itsName)

        if (result == null) {
            result = KgTypeAliasImpl(itsName)
            declarations.add(result)
        }

        result.build()

        return result
    }

}

//---------------------------------------------------------------------------------------------------------------------
