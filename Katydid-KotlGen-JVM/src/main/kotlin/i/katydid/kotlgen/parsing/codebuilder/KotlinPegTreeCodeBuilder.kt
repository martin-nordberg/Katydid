//
// (C) Copyright 2019 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.kotlgen.parsing.codebuilder

import o.katydid.kotlgen.model.KgSourceRoot
import o.katydid.kotlgen.model.core.KgOrigin
import o.katydid.kotlgen.model.core.KgOriginOffsetStartAndEnd
import o.katydid.kotlgen.model.core.names.KgQualifiedName
import o.katydid.kotlgen.model.structure.KgImport
import o.katydid.kotlgen.model.structure.KgPackage
import o.katydid.kotlgen.model.structure.KgSourceFile
import org.parboiled.Node

//---------------------------------------------------------------------------------------------------------------------

class KotlinPegTreeCodeBuilder(
    private val code: String
) {

    fun buildKotlinFile(sourceRoot: KgSourceRoot, fileName: String, kotlinFileNode: Node<Any>): KgSourceFile {

        require(kotlinFileNode.labeled("KotlinFile"))

        lateinit var result: KgSourceFile

        for (child in kotlinFileNode.children) {

            when (child.label) {
                "PackageHeader" -> result = buildPackageHeader(sourceRoot, child).`source file`(fileName)
                "Imports"       -> buildImports(result, child)
            }

            // TODO: top level objects

        }

        return result

    }

    ////

    private fun buildImport(sourceFile: KgSourceFile, importNode: Node<Any>) {

        require(importNode.labeled("Import"))

        lateinit var imp: KgImport
        lateinit var keywordNode: Node<Any>

        for (child in importNode.children) {

            when (child.label) {
                "Keyword"       -> keywordNode = child
                "QualifiedName" -> imp = sourceFile.`import`(buildQualifiedName(child)) {
                    keywordOrigin = keywordNode.origin
                }
                "ImportAlias"   -> buildImportAlias(imp, child)
                "ImportAll"     -> imp.all = true
            }

        }

    }

    private fun buildImportAlias(imp: KgImport, importAliasNode: Node<Any>) {

        require(importAliasNode.labeled("ImportAlias"))

        for (child in importAliasNode.children) {

            if (child.label == "SimpleName") {
                imp.alias = child.text
                imp.aliasOrigin = child.origin
            }

        }

    }

    private fun buildImports(sourceFile: KgSourceFile, importsNode: Node<Any>) {

        require(importsNode.labeled("Imports"))

        for (child in importsNode.children) {
            buildImport(sourceFile, child)
        }

    }

    private fun buildPackageHeader(sourceRoot: KgSourceRoot, packageHeaderNode: Node<Any>): KgPackage {

        require(packageHeaderNode.labeled("PackageHeader"))

        for (child in packageHeaderNode.children) {

            if (child.label == "QualifiedName") {
                val pkgQualifiedName = buildQualifiedName(child)
                return sourceRoot.`package`(pkgQualifiedName.toPath())
            }

        }

        throw IllegalStateException("Missing package qualified name.")

    }

    private fun buildQualifiedName(qualifiedNameNode: Node<Any>): KgQualifiedName {

        require(qualifiedNameNode.labeled("QualifiedName"))

        var result: KgQualifiedName? = null

        check(qualifiedNameNode.children.isNotEmpty())

        for (child in qualifiedNameNode.children) {
            check(child.label == "SimpleName")
            result = KgQualifiedName(result, child.text, child.origin)
        }

        return result!!
    }

    ////

    /**
     * Tests whether a node has label equal to [expectedLabel].
     */
    private fun Node<Any>.labeled(expectedLabel: String): Boolean {
        return this.label == expectedLabel
    }

    /**
     * Computes the origin of a node from its starting and ending indexes.
     */
    private val Node<Any>.origin: KgOrigin
        get() {
            return KgOriginOffsetStartAndEnd(this.startIndex, this.endIndex)
        }

    /**
     * Computes the text of a node as the corresponding substring of the input code.
     */
    private val Node<Any>.text: String
        get() {
            return code.substring(this.startIndex, this.endIndex)
        }

}

//---------------------------------------------------------------------------------------------------------------------

