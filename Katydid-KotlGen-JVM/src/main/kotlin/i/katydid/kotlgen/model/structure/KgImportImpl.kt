//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.kotlgen.model.structure

import o.katydid.kotlgen.model.core.KgOrigin
import o.katydid.kotlgen.model.core.KgOriginUnspecified
import o.katydid.kotlgen.model.core.names.KgQualifiedName
import o.katydid.kotlgen.model.structure.KgImport

//---------------------------------------------------------------------------------------------------------------------

internal class KgImportImpl(
    override var qualifiedName: KgQualifiedName,
    override var origin: KgOrigin = KgOriginUnspecified
) : KgImport {

    override var alias: String? = null

    override var aliasOrigin: KgOrigin = KgOriginUnspecified

    override var all: Boolean = false

    override var keywordOrigin: KgOrigin = KgOriginUnspecified

}

//---------------------------------------------------------------------------------------------------------------------
