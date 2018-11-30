//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.kotlgen.model

import i.katydid.kotlgen.model.KgSourceRootImpl
import o.katydid.kotlgen.model.core.names.KgPath
import o.katydid.kotlgen.model.structure.KgPackage
import java.io.File

//---------------------------------------------------------------------------------------------------------------------

interface KgSourceRoot {

    val folder: File

    val packages: List<KgPackage>

    ////

    fun `package`(itsQualifiedName: String, build: KgPackage.() -> Unit = {}): KgPackage

    fun `package`(itsQualifiedName: KgPath, build: KgPackage.() -> Unit = {}): KgPackage

}

//---------------------------------------------------------------------------------------------------------------------

fun makeSourceRoot(folder: File): KgSourceRoot =
    KgSourceRootImpl(folder)

//---------------------------------------------------------------------------------------------------------------------

