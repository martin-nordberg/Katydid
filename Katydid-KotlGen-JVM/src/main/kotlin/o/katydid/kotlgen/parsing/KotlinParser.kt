//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.kotlgen.parsing

import i.katydid.kotlgen.parsing.KotlinParserImpl
import i.katydid.kotlgen.parsing.KotlinParserImpl2
import o.katydid.kotlgen.model.KgSourceRoot
import o.katydid.kotlgen.model.core.names.KgQualifiedName
import o.katydid.kotlgen.model.structure.KgSourceFile
import java.io.Reader
import java.io.StringReader

//---------------------------------------------------------------------------------------------------------------------

interface KotlinParser {

    fun parseKotlinFile(sourceRoot: KgSourceRoot, fileName: String): KgSourceFile

    fun parseQualifiedName(): KgQualifiedName

}

//---------------------------------------------------------------------------------------------------------------------

fun makeKotlinParser(code: Reader): KotlinParser =
    KotlinParserImpl(code)

//---------------------------------------------------------------------------------------------------------------------

fun makeKotlinParser(code: String): KotlinParser =
    KotlinParserImpl(StringReader(code))

//---------------------------------------------------------------------------------------------------------------------

fun makeKotlinParser2(code: String): KotlinParser =
    KotlinParserImpl2(code)

//---------------------------------------------------------------------------------------------------------------------

