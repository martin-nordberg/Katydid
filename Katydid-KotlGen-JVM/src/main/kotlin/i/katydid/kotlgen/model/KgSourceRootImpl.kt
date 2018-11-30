//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.kotlgen.model

import i.katydid.kotlgen.model.structure.KgPackageImpl
import o.katydid.kotlgen.model.KgSourceRoot
import o.katydid.kotlgen.model.core.names.KgPath
import o.katydid.kotlgen.model.structure.KgPackage
import java.io.File

//---------------------------------------------------------------------------------------------------------------------

internal class KgSourceRootImpl(
    override var folder: File
) : KgSourceRoot {

    private val myPackages = mutableMapOf<String, KgPackageImpl>()

    ////

    override val packages: List<KgPackageImpl>
        get() = myPackages.values.sortedBy { p -> p.name }

    override fun `package`(itsQualifiedName: String, build: KgPackage.() -> Unit): KgPackageImpl =
        `package`(KgPath(itsQualifiedName), build)

    override fun `package`(itsQualifiedName: KgPath, build: KgPackage.() -> Unit): KgPackageImpl {

        var result = myPackages[itsQualifiedName.name]

        if (result == null) {
            result = KgPackageImpl(null, itsQualifiedName.name)
            myPackages[itsQualifiedName.name] = result
        }

        if (itsQualifiedName.remainder != null) {
            result = result.`package`(itsQualifiedName.remainder)
        }

        result.build()

        return result

    }

}

//---------------------------------------------------------------------------------------------------------------------
