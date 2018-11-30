//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.kotlgen.codegen

import i.katydid.kotlgen.codegen.KotlinCodeGeneratorImpl
import o.katydid.kotlgen.model.KgSourceRoot
import o.katydid.kotlgen.model.structure.KgSourceFile
import java.io.PrintWriter

//---------------------------------------------------------------------------------------------------------------------

interface KotlinCodeGenerator {

    fun generateKotlinFile(file: KgSourceFile)

}

//---------------------------------------------------------------------------------------------------------------------

fun makeKotlinCodeGenerator(sourceRoot: KgSourceRoot, code: PrintWriter): KotlinCodeGenerator =
    KotlinCodeGeneratorImpl(sourceRoot, code)

//---------------------------------------------------------------------------------------------------------------------
