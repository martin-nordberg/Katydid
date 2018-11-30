//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.kotlgen.parsing;

public enum EKotlinTokenType {

    /* Hard Keywords */
    AS("as"),
    AS_Q("as?"),
    BREAK("break"),
    CLASS("class"),
    CONTINUE("continue"),
    DO("do"),
    ELSE("else"),
    FALSE("false"),
    FOR("for"),
    FUN("fun"),
    IF("if"),
    IN("in"),
    NOT_IN("!in"),
    INTERFACE("interface"),
    IS("is"),
    NOT_IS("!is"),
    NULL("null"),
    OBJECT("object"),
    PACKAGE("package"),
    RETURN("return"),
    SUPER("super"),
    THIS("this"),
    THROW("throw"),
    TRUE("true"),
    TRY("try"),
    TYPEALIAS("typealias"),
    VAL("val"),
    VAR("var"),
    WHEN("when"),
    WHILE("while"),

    /* Soft Keywords */
    BY("by", true),
    CATCH("catch", true),
    CONSTRUCTOR("constructor", true),
    DELEGATE("delegate", true),
    DYNAMIC("dynamic", true),
    FIELD("field", true),
    FILE("file", true),
    FINALLY("finally", true),
    GET("get", true),
    IMPORT("import", true),
    INIT("init", true),
    PARAM("param", true),
    PROPERTY("property", true),
    RECEIVER("receiver", true),
    SET("set", true),
    SETPARAM("setparam", true),
    WHERE("where", true),

    /* Modifier Keywords */
    ACTUAL("actual", true),
    ABSTRACT("abstract", true),
    ANNOTATION("annotation", true),
    COMPANION("companion", true),
    CONST("const", true),
    CROSSINLINE("crossinline", true),
    DATA("data", true),
    ENUM("enum", true),
    EXPECT("expect", true),
    EXTERNAL("external", true),
    FINAL("final", true),
    INFIX("infix", true),
    INLINE("inline", true),
    INNER("inner", true),
    INTERNAL("internal", true),
    LATEINIT("lateinit", true),
    NOINLINE("noinline", true),
    OPEN("open", true),
    OPERATOR("operator", true),
    OUT("out", true),
    OVERRIDE("override", true),
    PRIVATE("private", true),
    PROTECTED("protected", true),
    PUBLIC("public", true),
    REIFIED("reified", true),
    SEALED("sealed", true),
    SUSPEND("suspend", true),
    TAILREC("tailrec", true),
    VARARG("vararg", true),

    /* Special Identifiers */
    IT("it", true),

    /* Operators and Special Symbols */
    AND("&&"),
    ARROW("->"),
    AT("@"),
    COLON(":"),
    COLON_COLON("::"),
    DOLLAR("$"),
    DOT_DOT(".."),
    EQ("="),
    EQ_EQ("=="),
    EQ_EQ_EQ("==="),
    GT(">"),
    GT_EQ(">="),
    LBRACKET("["),
    LT("<"),
    LT_EQ("<="),
    MINUS("-"),
    MINUS_EQ("-="),
    MINUS_MINUS("--"),
    NOT("!"),
    NOT_EQ("!="),
    NOT_EQ_EQ("!=="),
    NOT_NOT("!!"),
    OR("||"),
    PERCENT("%"),
    PERCENT_EQ("%="),
    PLUS("+"),
    PLUS_EQ("+="),
    PLUS_PLUS("++"),
    QUESTION("?"),
    QUESTION_DOT("?."),
    QUESTION_COLON("?:"),
    RBRACKET("]"),
    SEMICOLON(";"),
    SLASH("/"),
    SLASH_EQ("/="),
    STAR("*"),
    STAR_EQ("*="),
    UNDERSCORE("_"),

    /* Punctuation */
    COMMA(","),
    DOT("."),
    LBRACE("{"),
    LPAREN("("),
    RBRACE("}"),
    RPAREN(")"),

    /* Identifiers */
    IDENTIFIER("[identifier]", true),

    /* Literals */
    CHARACTER_LITERAL("[character literal]"),
    FLOATING_POINT_LITERAL("[floating point literal]"),
    INTEGER_LITERAL("[integer literal]"),
    STRING_LITERAL("[string literal]");

    ////

    EKotlinTokenType(String text) {
        this(text,false);
    }

    EKotlinTokenType(
        String text,
        boolean isPotentialIdentifier
    ) {
        this.text = text;
        this.isPotentialIdentifier = isPotentialIdentifier;
    }

    public String getText() {
        return this.text;
    }

    public boolean isPotentialIdentifier() {
        return isPotentialIdentifier;
    }

    private final boolean isPotentialIdentifier;

    private final String text;

}
