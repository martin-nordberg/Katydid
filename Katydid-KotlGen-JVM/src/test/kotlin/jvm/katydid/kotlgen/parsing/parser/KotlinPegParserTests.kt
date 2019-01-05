//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.kotlgen.parsing.parser

import i.katydid.kotlgen.parsing.parser.KotlinPegParser
import org.parboiled.Node
import org.parboiled.Parboiled
import org.parboiled.Rule
import org.parboiled.common.StringUtils
import org.parboiled.parserunners.ReportingParseRunner
import kotlin.test.assertEquals


//---------------------------------------------------------------------------------------------------------------------

abstract class KotlinPegParserTests {

    /**
     * Runs the parser rule [parserMethod] on given [input] and test for resulting [expectedSExpression].
     */
    protected fun checkParse(
        expectedSExpression: String,
        input: String,
        parserMethod: KotlinPegParser.() -> Rule
    ) {

        val parser = Parboiled.createParser(KotlinPegParser::class.java)

        val result = ReportingParseRunner<Any>(parser.parserMethod()).run(input)

        assertEquals(
            expectedSExpression,
            formatSExpression(input, result.parseTreeRoot),
            formatNodeTree(input, result.parseTreeRoot)
        )

    }

    /**
     * Converts a parse tree to an S-Expression.
     */
    private fun formatSExpression(input: String, node: Node<Any>) : String {

        val nodeLabel = node.label

        var result = "($nodeLabel"

        if ( node.children.isEmpty() ) {
            val nodeText = formatNodeText(input, node)
            result += " '$nodeText'"
        }
        else {
            for (child in node.children) {
                result += " "
                result += formatSExpression(input, child)
            }
        }
        result += ")"

        return result

    }

    /**
     * Computes the text of a node as the corresponding substring of the input.
     */
    private fun formatNodeText(input: String, node: Node<Any>): String {
        val endIndex = Math.min(node.endIndex,input.length)
        return StringUtils.escape(input.substring(node.startIndex, endIndex))
    }

    /**
     * Converts a parse tree to a human-friendly output format.
     */
    private fun formatNodeTree(input: String, node: Node<Any>, indent: Int = 0) : String {

        val nodeLabel = node.label
        val nodeText = formatNodeText(input, node)

        var result = ""
        if ( indent == 0 ) {
            result += "\n"
        }
        for (s in 0 until indent) {
            result += " "
        }
        result += "[$nodeLabel]"
        while ( result.length < 40 ) {
            result += " "
        }
        result += "'$nodeText' "
        while ( result.length < 70 ) {
            result += " "
        }
        result += "(${node.startIndex}..${node.endIndex})\n"

        for (child in node.children) {
            result += formatNodeTree(input, child, indent + 2)
        }

        return result

    }

}

//---------------------------------------------------------------------------------------------------------------------

