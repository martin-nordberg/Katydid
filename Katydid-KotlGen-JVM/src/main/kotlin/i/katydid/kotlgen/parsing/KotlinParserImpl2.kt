//
// (C) Copyright 2019 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.kotlgen.parsing

import i.katydid.kotlgen.parsing.codebuilder.KotlinPegTreeCodeBuilder
import i.katydid.kotlgen.parsing.parser.KotlinPegParser
import o.katydid.kotlgen.model.KgSourceRoot
import o.katydid.kotlgen.model.core.names.KgQualifiedName
import o.katydid.kotlgen.model.structure.KgSourceFile
import o.katydid.kotlgen.parsing.KotlinParser
import org.parboiled.Parboiled
import org.parboiled.parserunners.ReportingParseRunner

//---------------------------------------------------------------------------------------------------------------------

internal class KotlinParserImpl2(
    private val code: String
) : KotlinParser {

    override fun parseQualifiedName(): KgQualifiedName {
        TODO("not yet implemented / no longer wanted")
    }

    override fun parseKotlinFile(sourceRoot: KgSourceRoot, fileName: String): KgSourceFile {

        val parser = Parboiled.createParser(KotlinPegParser::class.java)

        val kotlinFileNode = ReportingParseRunner<Any>(parser.KotlinFile()).run(code)

        return KotlinPegTreeCodeBuilder(code).buildKotlinFile(sourceRoot, fileName, kotlinFileNode.parseTreeRoot)

    }


}

//---------------------------------------------------------------------------------------------------------------------

