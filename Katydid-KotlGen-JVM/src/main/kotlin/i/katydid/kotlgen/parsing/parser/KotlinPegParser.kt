
//
// (C) Copyright 2019 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.kotlgen.parsing.parser


import org.parboiled.BaseParser
import org.parboiled.Rule
import org.parboiled.annotations.BuildParseTree


@Suppress("LeakingThis")
@BuildParseTree
open class KotlinPegParser : BaseParser<Any>() {

    /* Hard key words */
    private val AS = Keyword("as")
    private val AS_Q = Keyword("as?")
    private val BREAK = Keyword("break")
    private val CLASS = Keyword("class")
    private val CONTINUE = Keyword("continue")
    private val DO = Keyword("do")
    private val ELSE = Keyword("else")
    private val FALSE = Keyword("false")
    private val FOR = Keyword("for")
    private val FUN = Keyword("fun")
    private val IF = Keyword("if")
    private val IN = Keyword("in")
    private val NOT_IN = Keyword("!in")
    private val INTERFACE = Keyword("interface")
    private val IS = Keyword("is")
    private val NOT_IS = Keyword("!is")
    private val NULL = Keyword("null")
    private val OBJECT = Keyword("object")
    private val PACKAGE = Keyword("package")
    private val RETURN = Keyword("return")
    private val SUPER = Keyword("super")
    private val THIS = Keyword("this")
    private val THROW = Keyword("throw")
    private val TRUE = Keyword("true")
    private val TRY = Keyword("try")
    private val TYPEALIAS = Keyword("typealias")
    private val VAL = Keyword("val")
    private val VAR = Keyword("var")
    private val WHEN = Keyword("when")
    private val WHILE = Keyword("while")

    /* Soft Keywords */
    private val BY = Keyword("by")
    private val CATCH = Keyword("catch")
    private val CONSTRUCTOR = Keyword("constructor")
    private val DELEGATE = Keyword("delegate")
    private val DYNAMIC = Keyword("dynamic")
    private val FIELD = Keyword("field")
    private val FILE = Keyword("file")
    private val FINALLY = Keyword("finally")
    private val GET = Keyword("get")
    private val IMPORT = Keyword("import")
    private val INIT = Keyword("init")
    private val PARAM = Keyword("param")
    private val PROPERTY = Keyword("property")
    private val RECEIVER = Keyword("receiver")
    private val SET = Keyword("set")
    private val SETPARAM = Keyword("setparam")
    private val WHERE = Keyword("where")



    // Symbols
    private val DOT = String(".").label("Dot")
    private val STAR = Sequence("*", TestNot("=")).label("Star").suppressSubnodes()

    ////

    /**
     * kotlinFile
     *   : preamble topLevelObject*
     *   ;
     */
    open fun KotlinFile() =
        Sequence(
            WhiteSpace(),
            Preamble(),
            TopLevelObjects(),
            WhiteSpace(),
            EOI
        )

    open fun TopLevelObjects(): Rule? {
        return ZeroOrMore(
            TopLevelObject().skipNode()
        )
    }

    /**
     * preamble (used by script, kotlinFile)
     *   : fileAnnotations? packageHeader? import*
     *   ;
     */
    open fun Preamble() =
        Sequence(
            // TODO: file annotations
            Optional(
                PackageHeader()
            ).skipNode(),
            Imports()
        ).skipNode()

    open fun Imports() =
        ZeroOrMore(
            Import()
        )

//    fileAnnotations (used by preamble)
//    : fileAnnotation*
//    ;

//    fileAnnotation (used by fileAnnotations)
//    : "@" "file" ":" ("[" unescapedAnnotation+ "]" | unescapedAnnotation)
//    ;

    /**
     * packageHeader (used by preamble)
     *   : modifiers "package" SimpleName{"."} SEMI?
     *   ;
     */
    open fun PackageHeader() =
        Sequence(
            // TODO: modifiers
            PACKAGE,
            WhiteSpace(),
            QualifiedName(),
            SemicolonOrNewLine()
        )

    open fun QualifiedName(): Rule {
        return Sequence(
            SimpleName(),
            ZeroOrMore(
                Sequence(
                    WS(),
                    DOT.skipNode(),
                    WS(),
                    SimpleName()
                ).skipNode()
            ).skipNode()
        )
    }

    /**
     * import (used by preamble)
     *   : "import" SimpleName{"."} ("." "*" | "as" SimpleName)? SEMI?
     *   ;
     */
    open fun Import() =
        Sequence(
            IMPORT,
            WhiteSpace(),
            QualifiedName(),
            Optional(
                FirstOf(
                    ImportAll(),
                    ImportAlias()
                ).skipNode()
            ).skipNode(),
            SemicolonOrNewLine()
        )

    open fun ImportAll() =
        Sequence(
            WS(),
            DOT,
            WS(),
            STAR
        ).suppressSubnodes()

    open fun ImportAlias() =
        Sequence(
            WS(),
            AS,
            WS(),
            SimpleName()
        )

    /**
     * SimpleName (used by typeParameter, catchBlock, simpleUserType, atomicExpression, LabelName, packageHeader, class, object, infixFunctionCall, function, typeAlias, parameter, callableReference, variableDeclarationEntry, stringTemplateElement, enumEntry, setter, import, companionObject, valueArguments, unescapedAnnotation, typeConstraint)
     *   : <java identifier>
     *   : "`" <java identifier> "`"
     *   ;
     */
    open fun SimpleName() =
        FirstOf(
            Sequence(
                TestNot(AnyHardKeyword()),
                JavaLetter(),
                ZeroOrMore(JavaLetterOrDigit())
            ),
            Sequence(
                '`',
                OneOrMore(JavaLetterOrDigitOrSpace()),
                '`'
            )
        ).suppressSubnodes()

    /**
     * topLevelObject (used by kotlinFile)
     *   : class
     *   : object
     *   : function
     *   : property
     *   : typeAlias
     *   ;
     */
    open fun TopLevelObject() =
        Sequence(
            WhiteSpace(),
            FirstOf(
                Class(),
                Object(),
                Function(),
                Property(),
                TypeAlias()
            ).skipNode(),
            SemicolonOrNewLine()
        )

    open fun Class() =
        Sequence(
            CLASS,
            SimpleName()
            // TODO
        )

    open fun Function() =
        Sequence(
            FUN,
            SimpleName()
            // TODO
        )

    open fun Object() =
        Sequence(
            OBJECT,
            SimpleName()
            // TODO
        )

    open fun Property() =
        Sequence(
            VAL,
            WhiteSpace(),
            SimpleName()
            // TODO ...
        )

    open fun TypeAlias() =
        Sequence(
            TYPEALIAS,
            SimpleName()
            // TODO
        )

    open fun JavaLetter() =
        FirstOf(
            CharRange('a', 'z'),
            CharRange('A', 'Z'),
            '_',
            '$'
            // TODO: Unicode
        ).suppressNode()

    open fun JavaLetterOrDigit() =
        FirstOf(
            CharRange('a', 'z'),
            CharRange('A', 'Z'),
            CharRange('0', '9'),
            '_',
            '$'
            // TODO: Unicode
        ).suppressNode().memoMismatches()

    open fun JavaLetterOrDigitOrSpace() =
        FirstOf(
            CharRange('a', 'z'),
            CharRange('A', 'Z'),
            CharRange('0', '9'),
            '_',
            '$',
            ' '
        ).suppressNode().memoMismatches()

    open fun AnyHardKeyword() =
        Sequence(
            FirstOf(
                "as?",
                "as",
                "break",
                "class",
                "continue",
                "do",
                "else",
                "false",
                "for",
                "fun",
                "if",
                "interface",
                "in",
                "!in",
                "is",
                "!is",
                "null",
                "object",
                "package",
                "return",
                "super",
                "this",
                "throw",
                "true",
                "try",
                "typealias",
                "val",
                "var",
                "when",
                "while"
            ),
            TestNot(JavaLetterOrDigit())
        ).memoMismatches()

    open fun Keyword(keyword: String) =
        Sequence(
            keyword,
            TestNot(JavaLetterOrDigit())
        ).suppressSubnodes()

    open fun WS() =
        ZeroOrMore(
            AnyOf(" \t\r\n")
        ).suppressNode()

    open fun WhiteSpace() =
        ZeroOrMore(
            FirstOf(
                // whitespace
                OneOrMore(AnyOf(" \t\r\n")),

                // traditional comment
                Sequence("/*", ZeroOrMore(TestNot("*/"), BaseParser.ANY), "*/"),

                // end of line comment
                Sequence(
                    "//",
                    ZeroOrMore(TestNot(AnyOf("\r\n")), BaseParser.ANY),
                    FirstOf("\r\n", '\r', '\n', BaseParser.EOI)
                )
            )
        ).suppressNode()

    open fun SemicolonOrNewLine() =
        OneOrMore(
            AnyOf(";\r\n")
        ).suppressNode()

}

