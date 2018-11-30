//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.kotlgen.model.structure

import o.katydid.kotlgen.model.core.names.KgQualifiedName

//---------------------------------------------------------------------------------------------------------------------

interface KgImporting {

    val imports: List<KgImport>

    ////

    fun `import`(itsQualifiedName: String, build: KgImport.() -> Unit = {}): KgImport

    fun `import`(itsQualifiedName: KgQualifiedName, build: KgImport.() -> Unit = {}): KgImport

}

//---------------------------------------------------------------------------------------------------------------------
