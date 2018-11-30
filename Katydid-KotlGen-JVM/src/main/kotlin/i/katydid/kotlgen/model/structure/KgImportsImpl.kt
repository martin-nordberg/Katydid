//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.kotlgen.model.structure

import o.katydid.kotlgen.model.core.names.KgQualifiedName
import o.katydid.kotlgen.model.structure.KgImport
import o.katydid.kotlgen.model.structure.KgImporting

//---------------------------------------------------------------------------------------------------------------------

internal class KgImportsImpl
    : KgImporting {

    override val imports: MutableList<KgImportImpl> = mutableListOf()

    ////

    override fun `import`(itsQualifiedName: String, build: KgImport.() -> Unit): KgImportImpl =
        `import`(KgQualifiedName(itsQualifiedName), build)

    override fun import(itsQualifiedName: KgQualifiedName, build: KgImport.() -> Unit): KgImportImpl {

        var result = imports.find { it.qualifiedName == itsQualifiedName }

        if (result == null) {
            result = KgImportImpl(itsQualifiedName)
            imports.add(result)
        }

        result.build()

        return result

    }


}

//---------------------------------------------------------------------------------------------------------------------
