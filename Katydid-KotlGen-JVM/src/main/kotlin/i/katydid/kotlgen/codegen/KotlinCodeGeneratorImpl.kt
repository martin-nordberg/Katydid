//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.kotlgen.codegen

import o.katydid.kotlgen.codegen.KotlinCodeGenerator
import o.katydid.kotlgen.model.KgSourceRoot
import o.katydid.kotlgen.model.declarations.classes.KgEnumClass
import o.katydid.kotlgen.model.declarations.declarationsOfType
import o.katydid.kotlgen.model.declarations.properties.KgEnumEntry
import o.katydid.kotlgen.model.structure.KgImport
import o.katydid.kotlgen.model.structure.KgSourceFile
import java.io.PrintWriter

//---------------------------------------------------------------------------------------------------------------------

internal class KotlinCodeGeneratorImpl(
    private val sourceRoot: KgSourceRoot,
    private val code: PrintWriter
) : KotlinCodeGenerator,
    CodeWriter by CodeWriterImpl(code) {

    private fun generateEnumClass(enumClass: KgEnumClass) {

        println("${enumClass.modifiers} class ${enumClass.name} {")

        indented {

            val enumEntries = enumClass.declarationsOfType<KgEnumEntry>()

            for (entry in enumEntries) {

                print(entry.name)

                if (entry == enumEntries.last()) {
                    println(";")
                }
                else {
                    println(",")
                }

            }

        }

        println("}")
        println()

    }

    private fun generateImport(imp: KgImport) {

        print("import ${imp.qualifiedName}")

        when {
            imp.all           -> println(".*")
            imp.alias != null -> println(" as ${imp.alias}")
            else              -> println()
        }

    }

    override fun generateKotlinFile(file: KgSourceFile) {

        println()
        println("package ${file.packageQualifiedName}")
        println()

        for (imp in file.imports) {
            generateImport(imp)
        }

        if (file.imports.isNotEmpty()) {
            println()
        }

        for (obj in file.declarations) {
            when (obj) {
                is KgEnumClass -> generateEnumClass(obj)
                // TODO: many other branches
            }
        }

    }

}

//---------------------------------------------------------------------------------------------------------------------

