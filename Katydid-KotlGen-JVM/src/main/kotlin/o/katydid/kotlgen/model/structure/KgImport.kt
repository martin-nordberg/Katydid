//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.kotlgen.model.structure

import o.katydid.kotlgen.model.core.KgCodeElement
import o.katydid.kotlgen.model.core.KgOrigin
import o.katydid.kotlgen.model.core.names.KgQualifiedName

//---------------------------------------------------------------------------------------------------------------------

interface KgImport
    : KgCodeElement {

    var alias: String?

    var aliasOrigin: KgOrigin

    var all: Boolean

    var keywordOrigin: KgOrigin

    val qualifiedName: KgQualifiedName

    ////

    operator fun invoke(revise: KgImport.() -> Unit) =
        this.revise()

}

//---------------------------------------------------------------------------------------------------------------------
