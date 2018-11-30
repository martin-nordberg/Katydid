//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.kotlgen.parsing

import i.katydid.kotlgen.parsing.KotlinParserImpl
import o.katydid.kotlgen.model.KgSourceRoot
import o.katydid.kotlgen.model.core.names.KgQualifiedName
import o.katydid.kotlgen.model.structure.KgSourceFile
import java.io.Reader

//---------------------------------------------------------------------------------------------------------------------

interface KotlinParser {

    fun parseKotlinFile(fileName: String): KgSourceFile

    fun parseQualifiedName(): KgQualifiedName

}

//---------------------------------------------------------------------------------------------------------------------

fun makeKotlinParser(sourceRoot: KgSourceRoot, code: Reader): KotlinParser =
    KotlinParserImpl(sourceRoot, code)

//---------------------------------------------------------------------------------------------------------------------

