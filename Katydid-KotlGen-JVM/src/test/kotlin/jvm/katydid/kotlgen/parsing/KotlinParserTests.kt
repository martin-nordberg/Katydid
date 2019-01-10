//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.kotlgen.parsing

import o.katydid.kotlgen.model.makeSourceRoot
import o.katydid.kotlgen.model.structure.KgSourceFile
import o.katydid.kotlgen.parsing.makeKotlinParser
import java.io.File
import kotlin.test.assertEquals


//---------------------------------------------------------------------------------------------------------------------

abstract class KotlinParserTests {

    protected fun parseKotlinFile(code: String): KgSourceFile {

        val parser = makeKotlinParser(code)

        val srcRoot = makeSourceRoot(File("."))
        val srcFile = parser.parseKotlinFile(srcRoot, "test")

        assertEquals("test", srcFile.name)

        return srcFile

    }

}

//---------------------------------------------------------------------------------------------------------------------

