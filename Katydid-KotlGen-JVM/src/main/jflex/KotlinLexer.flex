
package i.katydid.kotlgen.parsing;

import static i.katydid.kotlgen.parsing.EKotlinTokenType.*;

%%

%type KotlinToken
%public
%class KotlinLexer
%unicode
%line
%column

%{
  private StringBuffer stringLiteral = new StringBuffer();
  private StringBuffer stringValue = new StringBuffer();

  private KotlinToken token(EKotlinTokenType type) {
    return new KotlinToken(type, type.getText(), yyline, yycolumn, null, 0);
  }
  private KotlinToken token(EKotlinTokenType type, String text) {
    return new KotlinToken(type, text, yyline, yycolumn, null, 0);
  }
  private KotlinToken token(EKotlinTokenType type, String text, int channel) {
    return new KotlinToken(type, text, yyline, yycolumn, null, channel);
  }
  private KotlinToken token(EKotlinTokenType type, String text, Object value) {
    return new KotlinToken(type, text, yyline, yycolumn, value, 0);
  }
  private KotlinToken token(EKotlinTokenType type, String text, Object value, int channel) {
    return new KotlinToken(type, text, yyline, yycolumn, value, channel);
  }

  private long parseLong(int start, int end, int radix) {
    long result = 0;
    long digit;

    for (int i = start; i < end; i++) {
      char ch = yycharat(i);

      if ( ch == '_' ) {
        continue;
      }

      digit  = Character.digit( yycharat(i), radix );
      result *= radix;
      result += digit;
    }

    return result;
  }
%}

  /* White Space */

  LineTerminator          = \r|\n|\r\n

  InputCharacter          = [^\r\n]

  WhiteSpace              = {LineTerminator} | [ \t\f]

  /* Comments */

  Comment                 = {TraditionalComment} | {EndOfLineComment} | {DocumentationComment}

  TraditionalComment      = "/*" [^*] ~"*/" | "/*" "*"+ "/"

  EndOfLineComment        = "//" {InputCharacter}* {LineTerminator}?

  DocumentationComment    = "/**" {CommentContent} "*"+ "/"

  CommentContent          = ( [^*] | \*+ [^/*] )*

  /* Identifiers */

  Identifier              = [:jletter:] [:jletterdigit:]*

  BackTickIdentifier      = "`" [^`\r\n]+ "`"

  /* Integer Literals */

  Digit                   = [0-9]

  DecimalLiteral          = {Digit}
                          | ( {Digit} ({Digit} | "_")* {Digit} )

  DecimalLongLiteral      = {DecimalLiteral} "L"

  HexDigit                = [0-9a-fA-F]

  HexadecimalLiteral      = ( "0" ("x"|"X") {HexDigit} )
                          | ( "0" ("x"|"X") {HexDigit} ({HexDigit} | "_")* {HexDigit} )

  HexadecimalLongLiteral  = {HexadecimalLiteral} "L"

  BinaryDigit             = "0" | "1"

  BinaryLiteral           = ( "0" ("b"|"B") {BinaryDigit} )
                          | ( "0" ("b"|"B") {BinaryDigit} ({BinaryDigit} | "_")* {BinaryDigit} )

  BinaryLongLiteral       = {BinaryLiteral} "L"

  /* Floating Point Literals */

  FloatLiteral  = ({FLit1}|{FLit2}|{FLit3}) {Exponent}? [fF]

  DoubleLiteral = ({FLit1}|{FLit2}|{FLit3}) {Exponent}?

  FLit1    = [0-9]+ \. [0-9]*

  FLit2    = \. [0-9]+

  FLit3    = [0-9]+

  Exponent = [eE] [+-]? [0-9]+

  /* String and Character Literals */

  StringCharacter = [^\r\n\"\\]

  SingleCharacter = [^\r\n\'\\]


%state STRINGLITERAL, CHARLITERAL


%%


<YYINITIAL> {

  /* See https://kotlinlang.org/docs/reference/keyword-reference.html */

  /* Hard Keywords */
  "as"                           { return token(AS); }
  "as?"                          { return token(AS_Q); }
  "break"                        { return token(BREAK); }
  "class"                        { return token(CLASS); }
  "continue"                     { return token(CONTINUE); }
  "do"                           { return token(DO); }
  "else"                         { return token(ELSE); }
  "false"                        { return token(FALSE); }
  "for"                          { return token(FOR); }
  "fun"                          { return token(FUN); }
  "if"                           { return token(IF); }
  "in"                           { return token(IN); }
  "!in"                          { return token(NOT_IN); }
  "interface"                    { return token(INTERFACE); }
  "is"                           { return token(IS); }
  "!is"                          { return token(NOT_IS); }
  "null"                         { return token(NULL); }
  "object"                       { return token(OBJECT); }
  "package"                      { return token(PACKAGE); }
  "return"                       { return token(RETURN); }
  "super"                        { return token(SUPER); }
  "this"                         { return token(THIS); }
  "throw"                        { return token(THROW); }
  "true"                         { return token(TRUE); }
  "try"                          { return token(TRY); }
  "typealias"                    { return token(TYPEALIAS); }
  "val"                          { return token(VAL); }
  "var"                          { return token(VAR); }
  "when"                         { return token(WHEN); }
  "while"                        { return token(WHILE); }

  /* Soft Keywords */
  "by"                           { return token(BY); }
  "catch"                        { return token(CATCH); }
  "constructor"                  { return token(CONSTRUCTOR); }
  "delegate"                     { return token(DELEGATE); }
  "dynamic"                      { return token(DYNAMIC); }
  "field"                        { return token(FIELD); }
  "file"                         { return token(FILE); }
  "finally"                      { return token(FINALLY); }
  "get"                          { return token(GET); }
  "import"                       { return token(IMPORT); }
  "init"                         { return token(INIT); }
  "param"                        { return token(PARAM); }
  "property"                     { return token(PROPERTY); }
  "receiver"                     { return token(RECEIVER); }
  "set"                          { return token(SET); }
  "setparam"                     { return token(SETPARAM); }
  "where"                        { return token(WHERE); }

  /* Modifier Keywords */
  "actual"                       { return token(ACTUAL); }
  "abstract"                     { return token(ABSTRACT); }
  "annotation"                   { return token(ANNOTATION); }
  "companion"                    { return token(COMPANION); }
  "const"                        { return token(CONST); }
  "crossinline"                  { return token(CROSSINLINE); }
  "data"                         { return token(DATA); }
  "enum"                         { return token(ENUM); }
  "expect"                       { return token(EXPECT); }
  "external"                     { return token(EXTERNAL); }
  "final"                        { return token(FINAL); }
  "infix"                        { return token(INFIX); }
  "inline"                       { return token(INLINE); }
  "inner"                        { return token(INNER); }
  "internal"                     { return token(INTERNAL); }
  "lateinit"                     { return token(LATEINIT); }
  "noinline"                     { return token(NOINLINE); }
  "open"                         { return token(OPEN); }
  "operator"                     { return token(OPERATOR); }
  "out"                          { return token(OUT); }
  "override"                     { return token(OVERRIDE); }
  "private"                      { return token(PRIVATE); }
  "protected"                    { return token(PROTECTED); }
  "public"                       { return token(PUBLIC); }
  "reified"                      { return token(REIFIED); }
  "sealed"                       { return token(SEALED); }
  "suspend"                      { return token(SUSPEND); }
  "tailrec"                      { return token(TAILREC); }
  "vararg"                       { return token(VARARG); }

  /* Special Identifiers */
  "it"                           { return token(IT); }

  /** Operators and Special Symbols */
  "&&"                           { return token(AND); }
  "->"                           { return token(ARROW); }
  "@"                            { return token(AT); }
  ":"                            { return token(COLON); }
  "::"                           { return token(COLON_COLON); }
  "$"                            { return token(DOLLAR); }
  ".."                           { return token(DOT_DOT); }
  "="                            { return token(EQ); }
  "=="                           { return token(EQ_EQ); }
  "==="                          { return token(EQ_EQ_EQ); }
  ">"                            { return token(GT); }
  ">="                           { return token(GT_EQ); }
  "["                            { return token(LBRACKET); }
  "<"                            { return token(LT); }
  "<="                           { return token(LT_EQ); }
  "-"                            { return token(MINUS); }
  "-="                           { return token(MINUS_EQ); }
  "--"                           { return token(MINUS_MINUS); }
  "!"                            { return token(NOT); }
  "!="                           { return token(NOT_EQ); }
  "!=="                          { return token(NOT_EQ_EQ); }
  "!!"                           { return token(NOT_NOT); }
  "||"                           { return token(OR); }
  "%"                            { return token(PERCENT); }
  "%="                           { return token(PERCENT_EQ); }
  "+"                            { return token(PLUS); }
  "+="                           { return token(PLUS_EQ); }
  "++"                           { return token(PLUS_PLUS); }
  "?"                            { return token(QUESTION); }
  "?."                           { return token(QUESTION_DOT); }
  "?:"                           { return token(QUESTION_COLON); }
  "]"                            { return token(RBRACKET); }
  ";"                            { return token(SEMICOLON); }
  "/"                            { return token(SLASH); }
  "/="                           { return token(SLASH_EQ); }
  "*"                            { return token(STAR); }
  "*="                           { return token(STAR_EQ); }
  "_"                            { return token(UNDERSCORE); }

  /** Punctuation */
  ","                            { return token(COMMA); }
  "."                            { return token(DOT); }
  "{"                            { return token(LBRACE); }
  "("                            { return token(LPAREN); }
  "}"                            { return token(RBRACE); }
  ")"                            { return token(RPAREN); }

  /* Identifiers */
  {Identifier}                   { return token(IDENTIFIER, yytext()); }
  {BackTickIdentifier}           { return token(IDENTIFIER, yytext()); }

  /* String Literal */
  \"                             { yybegin(STRINGLITERAL);
                                   stringLiteral.setLength(0);
                                   stringValue.setLength(0); }

  /* Character Literal */
  \'                             { yybegin(CHARLITERAL); }

  /* Integer Literals */

  /* This is matched together with the minus, because the number is too big to
     be represented by a positive integer. */
  "-2147483648"                  { return token(INTEGER_LITERAL, yytext(), Integer.MIN_VALUE); }

  {DecimalLiteral}               { return token(INTEGER_LITERAL, yytext(), (int) parseLong(2, yylength(), 10)); }
  {DecimalLongLiteral}           { return token(INTEGER_LITERAL, yytext(), parseLong(2, yylength()-1, 10)); }

  {HexadecimalLiteral}           { return token(INTEGER_LITERAL, yytext(), (int) parseLong(2, yylength(), 16)); }
  {HexadecimalLongLiteral}       { return token(INTEGER_LITERAL, yytext(), parseLong(2, yylength()-1, 16)); }

  {BinaryLiteral}                { return token(INTEGER_LITERAL, yytext(), (int) parseLong(0, yylength(), 2)); }
  {BinaryLongLiteral}            { return token(INTEGER_LITERAL, yytext(), parseLong(0, yylength()-1, 2)); }

  /* Floating Point Literals */

  {FloatLiteral}                 { return token(FLOATING_POINT_LITERAL, yytext(), Float.valueOf(yytext().substring(0,yylength()-1))); }

  {DoubleLiteral}                { return token(FLOATING_POINT_LITERAL, yytext(), Double.valueOf(yytext())); }
  {DoubleLiteral}[dD]            { return token(FLOATING_POINT_LITERAL, yytext(), Double.valueOf(yytext().substring(0,yylength()-1))); }

  /* Comments */
  {Comment}                      { /* TODO: second channel? */ }

  /* Whitespace */
  {WhiteSpace}                   { /* ignore */ }

}

<STRINGLITERAL> {

  \"                             { yybegin(YYINITIAL);
                                   stringLiteral.append( '"' );
                                   return token(STRING_LITERAL, stringLiteral.toString(), stringValue.toString()); }

  {StringCharacter}+             { stringLiteral.append( yytext() );
                                   stringValue.append( yytext() ); }

  \\t                            { stringLiteral.append( yytext() );
                                   stringValue.append('\t'); }

  \\n                            { stringLiteral.append( yytext() );
                                   stringValue.append('\n'); }

  \\r                            { stringLiteral.append( yytext() );
                                   stringValue.append('\r'); }

  \\\"                           { stringLiteral.append( yytext() );
                                   stringValue.append('\"'); }

  \\                             { stringLiteral.append( yytext() );
                                   stringValue.append('\\'); }

}

<CHARLITERAL> {

  {SingleCharacter}\'            { yybegin(YYINITIAL);
                                   return token(CHARACTER_LITERAL, "'" + yytext(), yytext().charAt(0)); }

  /* Escape Sequences */
  "\\b"\'                        { yybegin(YYINITIAL);
                                   return token(CHARACTER_LITERAL, "'\\b'", '\b'); }

  "\\t"\'                        { yybegin(YYINITIAL);
                                   return token(CHARACTER_LITERAL, "'\\t'", '\t');}

  "\\n"\'                        { yybegin(YYINITIAL);
                                   return token(CHARACTER_LITERAL, "'\\n'", '\n');}

  "\\r"\'                        { yybegin(YYINITIAL);
                                   return token(CHARACTER_LITERAL, "'\\r'", '\r');}

  "\\\""\'                       { yybegin(YYINITIAL);
                                   return token(CHARACTER_LITERAL, "'\\\"'", '\"');}

  "\\'"\'                        { yybegin(YYINITIAL);
                                   return token(CHARACTER_LITERAL, "'\\''", '\'');}

  "\\\\"\'                       { yybegin(YYINITIAL);
                                   return token(CHARACTER_LITERAL, "'\\\\'", '\\'); }

  \\[0-3]?[0-7]?[0-7]\'          { yybegin(YYINITIAL);
                                   int val = Integer.parseInt(yytext().substring(1,yylength()-1),8);
			                       return token(CHARACTER_LITERAL, "'" + yytext(), (char)val); }

  /* Error Cases */

  \\.                            { throw new RuntimeException("Illegal escape sequence \""+yytext()+"\""); }

  {LineTerminator}               { throw new RuntimeException("Unterminated character literal at end of line"); }

}

/* Error Fallback */
[^]                              { throw new Error("Illegal character <" + yytext() + ">"); }