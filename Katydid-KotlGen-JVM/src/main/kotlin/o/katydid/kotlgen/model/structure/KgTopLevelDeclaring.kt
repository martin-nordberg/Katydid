//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.kotlgen.model.structure

import o.katydid.kotlgen.model.declarations.KgNonlocalDeclaring
import o.katydid.kotlgen.model.declarations.KgTypeAlias

//---------------------------------------------------------------------------------------------------------------------

interface KgTopLevelDeclaring
    : KgNonlocalDeclaring {

    fun `typealias`(
        itsName: String,
        build: KgTypeAlias.() -> Unit
    ): KgTypeAlias

}

//---------------------------------------------------------------------------------------------------------------------

