//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.kotlgen.model.structure

import o.katydid.kotlgen.model.core.KgCodeElement
import o.katydid.kotlgen.model.core.names.KgNamed
import o.katydid.kotlgen.model.core.names.KgPath
import o.katydid.kotlgen.model.core.names.KgQualifiedName

//---------------------------------------------------------------------------------------------------------------------

interface KgPackage
    : KgCodeElement, KgNamed {

    val packages: List<KgPackage>

    val qualifiedName: KgQualifiedName

    val sourceFiles: List<KgSourceFile>

    ////

    operator fun invoke(revise: KgPackage.() -> Unit) =
        this.revise()

    fun `package`(itsQualifiedName: String, build: KgPackage.() -> Unit = {}): KgPackage

    fun `package`(itsQualifiedName: KgPath, build: KgPackage.() -> Unit = {}): KgPackage

    fun `source file`(itsFileName: String, build: KgSourceFile.() -> Unit = {}): KgSourceFile

}

//---------------------------------------------------------------------------------------------------------------------

