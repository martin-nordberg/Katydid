//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.kotlgen.model.structure

import o.katydid.kotlgen.model.core.KgOrigin
import o.katydid.kotlgen.model.core.KgOriginUnspecified
import o.katydid.kotlgen.model.core.names.KgPath
import o.katydid.kotlgen.model.core.names.KgQualifiedName
import o.katydid.kotlgen.model.structure.KgPackage
import o.katydid.kotlgen.model.structure.KgSourceFile

//---------------------------------------------------------------------------------------------------------------------

internal class KgPackageImpl(
    parentQualifiedName: KgQualifiedName?,
    override var name: String,
    override var origin: KgOrigin = KgOriginUnspecified
) : KgPackage {

    private val myPackages = mutableMapOf<String, KgPackageImpl>()

    private val mySourceFiles = mutableMapOf<String, KgSourceFileImpl>()

    ////

    override var nameOrigin: KgOrigin = KgOriginUnspecified

    override val packages: List<KgPackageImpl>
        get() = myPackages.values.sortedBy { p -> p.name }

    override val qualifiedName = KgQualifiedName(parentQualifiedName, name, KgOriginUnspecified)

    override val sourceFiles: List<KgSourceFileImpl>
        get() = mySourceFiles.values.sortedBy { f -> f.name }

    ////

    override fun `package`(itsQualifiedName: String, build: KgPackage.() -> Unit): KgPackageImpl =
        `package`(KgPath(itsQualifiedName), build)

    override fun `package`(itsQualifiedName: KgPath, build: KgPackage.() -> Unit): KgPackageImpl {

        var result = myPackages[itsQualifiedName.name]

        if (result == null) {
            result = KgPackageImpl(qualifiedName, itsQualifiedName.name)
            myPackages[itsQualifiedName.name] = result
        }

        if (itsQualifiedName.remainder != null) {
            result = result.`package`(itsQualifiedName.remainder)
        }

        result.build()

        return result

    }

    override fun `source file`(itsFileName: String, build: KgSourceFile.() -> Unit): KgSourceFileImpl {

        var result = mySourceFiles[itsFileName]

        if (result == null) {
            result = KgSourceFileImpl(qualifiedName, itsFileName)
            mySourceFiles[itsFileName] = result
        }

        result.build()

        return result

    }

}

//---------------------------------------------------------------------------------------------------------------------
