//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.kotlgen.parsing

import i.katydid.kotlgen.parsing.EKotlinTokenType.*
import o.katydid.kotlgen.model.KgSourceRoot
import o.katydid.kotlgen.model.core.KgOrigin
import o.katydid.kotlgen.model.core.KgOriginLineColumnAndSize
import o.katydid.kotlgen.model.core.modifiers.KgModifier
import o.katydid.kotlgen.model.core.modifiers.KgModifierKeyword
import o.katydid.kotlgen.model.core.modifiers.KgModifierList
import o.katydid.kotlgen.model.core.names.KgQualifiedName
import o.katydid.kotlgen.model.declarations.classes.KgEnumClass
import o.katydid.kotlgen.model.structure.KgPackage
import o.katydid.kotlgen.model.structure.KgSourceFile
import o.katydid.kotlgen.parsing.KotlinParser
import java.io.Reader

//---------------------------------------------------------------------------------------------------------------------

internal class KotlinParserImpl(
    private val sourceRoot: KgSourceRoot,
    code: Reader
) : KotlinParser,
    KotlinTokenBuffer by KotlinTokenBufferImpl(KotlinLexer(code)) {

    data class NameWithOrigin(
        val text: String,
        val origin: KgOrigin
    )

    private fun expected(description: String): Nothing =
        throw IllegalArgumentException("Expected $description.")

    private fun expected(vararg tokenTypes: EKotlinTokenType): Nothing {

        if (tokenTypes.size == 1) {
            throw IllegalArgumentException("Expected ${tokenTypes[0].text}.")
        }

        val tokenText = tokenTypes.joinToString(", ") { t -> t.text }
        throw IllegalArgumentException("Expected one of { $tokenText }.")

    }

    private fun expected(description: String, vararg tokenTypes: EKotlinTokenType): Nothing {

        if (tokenTypes.size == 1) {
            throw IllegalArgumentException("Expected $description - ${tokenTypes[0].text}.")
        }

        val tokenText = tokenTypes.joinToString(", ") { t -> t.text }
        throw IllegalArgumentException("Expected $description - one of { $tokenText }.")

    }

    private fun convertOrigin(origin: KotlinTokenOrigin): KgOriginLineColumnAndSize =
        KgOriginLineColumnAndSize(origin.line, origin.column, origin.length)

    private fun read(tokenType: EKotlinTokenType): KotlinToken {

        if (!hasLookAhead(tokenType)) {
            expected(tokenType)
        }

        return read()!!

    }

    private fun readIdentifier(): KotlinToken {

        if (!hasLookAheadIdentifier()) {
            expected(IDENTIFIER)
        }

        return read()!!

    }

    ////

    /**
     * class (used by memberDeclaration, declaration, topLevelObject)
     *   : modifiers ("class" | "interface") SimpleName
     *   typeParameters?
     *   primaryConstructor?
     *   (":" annotations delegationSpecifier{","})?
     *   typeConstraints
     *   (classBody? | enumClassBody)
     *   ;
     */
    private fun parseClass(srcFile: KgSourceFile, modifiers: KgModifierList) {

        // "class"
        val keywOrigin = read()!!.origin

        val className = parseSimpleName()

        // TODO: typeParameters
        // TODO: primaryConstructor
        // TODO: delegationSpecifiers
        // TODO: type constraints

        if (modifiers.contains(KgModifierKeyword.`enum`)) {

            val enumClass = srcFile.`enum class`(className.text) {
                nameOrigin = className.origin
                keywordOrigin = convertOrigin(keywOrigin)

                mergeModifiers(modifiers)
            }

            parseEnumClassBody(enumClass)

        }

    }

    /**
     * enumClassBody (used by class)
     *   : "{" enumEntries (";" members)? "}"
     *   ;
     */
    private fun parseEnumClassBody(enumClass: KgEnumClass) {

        read(LBRACE)

        parseEnumEntries(enumClass)

        if (consumeWhen(SEMICOLON)) {
            parseMembers(enumClass)
        }

        read(RBRACE)

    }

    /**
     * enumEntries (used by enumClassBody)
     *   : (enumEntry{","} ","? ";"?)?
     *   ;
     */
    private fun parseEnumEntries(enumClass: KgEnumClass) {

        while (!hasLookAhead(SEMICOLON) && !hasLookAhead(RBRACE)) {
            parseEnumEntry(enumClass)
        }

    }

    /**
     * enumEntry (used by enumEntries)
     *   : modifiers SimpleName valueArguments? classBody?
     *   ;
     */
    private fun parseEnumEntry(enumClass: KgEnumClass) {

        val modifiers = parseModifiers()

        val name = parseSimpleName()

        // TODO: value arguments

        // TODO: class body

        consumeWhen(COMMA)

        enumClass.`enum entry`(name.text) {
            nameOrigin = name.origin
        }

    }

    /**
     * import (used by preamble)
     *   : "import" SimpleName{"."} ("." "*" | "as" SimpleName)? SEMI?
     *   ;
     */
    private fun parseImports(sourceFile: KgSourceFile) {

        while (consumeWhen(IMPORT)) {

            val keywOrigin = lookAhead(0)!!.origin

            val imp = sourceFile.`import`(parseQualifiedName()) {
                keywordOrigin = convertOrigin(keywOrigin)
            }

            if (consumeWhen(DOT, STAR)) {
                imp.all = true
            }
            else if (consumeWhen(AS)) {
                val aliasName = parseSimpleName()
                imp.alias = aliasName.text
                imp.aliasOrigin = aliasName.origin
            }

            parseSemicolonOrNewLine()

        }

    }

    private fun parseInterface(srcFile: KgSourceFile, modifiers: KgModifierList) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /**
     * kotlinFile
     *   : preamble topLevelObject*
     *   ;
     */
    override fun parseKotlinFile(fileName: String): KgSourceFile {

        val result = parsePreamble(fileName)

        while (hasLookAhead()) {
            parseTopLevelObject(result)
        }

        return result

    }

    private fun parseMembers(enumClass: KgEnumClass) {
        // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun parseModifiers(): KgModifierList {

        val result = KgModifierList()

        fun readModifier(keyword: KgModifierKeyword) =
            KgModifier(keyword, convertOrigin(read()!!.origin))

        while (true) {
            when (lookAhead(1)?.type) {
                // TODO: annotations
                ABSTRACT    -> result.add(readModifier(KgModifierKeyword.`abstract`))
                ANNOTATION  -> result.add(readModifier(KgModifierKeyword.`annotation`))
                CONST       -> result.add(readModifier(KgModifierKeyword.`const`))
                CROSSINLINE -> result.add(readModifier(KgModifierKeyword.`crossinline`))
                DATA        -> result.add(readModifier(KgModifierKeyword.`data`))
                ENUM        -> result.add(readModifier(KgModifierKeyword.`enum`))
                EXTERNAL    -> result.add(readModifier(KgModifierKeyword.`external`))
                FINAL       -> result.add(readModifier(KgModifierKeyword.`final`))
                IN          -> result.add(readModifier(KgModifierKeyword.`in`))
                INFIX       -> result.add(readModifier(KgModifierKeyword.`infix`))
                INLINE      -> result.add(readModifier(KgModifierKeyword.`inline`))
                INTERNAL    -> result.add(readModifier(KgModifierKeyword.`internal`))
                LATEINIT    -> result.add(readModifier(KgModifierKeyword.`lateinit`))
                NOINLINE    -> result.add(readModifier(KgModifierKeyword.`noinline`))
                OPEN        -> result.add(readModifier(KgModifierKeyword.`open`))
                OPERATOR    -> result.add(readModifier(KgModifierKeyword.`operator`))
                OUT         -> result.add(readModifier(KgModifierKeyword.`out`))
                OVERRIDE    -> result.add(readModifier(KgModifierKeyword.`override`))
                PRIVATE     -> result.add(readModifier(KgModifierKeyword.`private`))
                PROTECTED   -> result.add(readModifier(KgModifierKeyword.`protected`))
                PUBLIC      -> result.add(readModifier(KgModifierKeyword.`public`))
                REIFIED     -> result.add(readModifier(KgModifierKeyword.`reified`))
                SEALED      -> result.add(readModifier(KgModifierKeyword.`sealed`))
                SUSPEND     -> result.add(readModifier(KgModifierKeyword.`suspend`))
                TAILREC     -> result.add(readModifier(KgModifierKeyword.`tailrec`))
                VARARG      -> result.add(readModifier(KgModifierKeyword.`vararg`))
                else        -> return result
            }
        }

    }

    private fun parseObject(srcFile: KgSourceFile, modifiers: KgModifierList) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /**
     * packageHeader (used by preamble)
     *   : modifiers "package" SimpleName{"."} SEMI?
     *   ;
     */
    private fun parsePackageHeader(): KgPackage {

        // TODO: modifiers

        if (consumeWhen(PACKAGE)) {
            val pkgQualifiedName = parseQualifiedName()
            parseSemicolonOrNewLine()
            return sourceRoot.`package`(pkgQualifiedName.toPath())
        }

        // TODO return sourceRoot.rootPackage
        expected("package header")

    }

    /**
     * preamble (used by script, kotlinFile)
     *   : fileAnnotations? packageHeader? import*
     *   ;
     */
    private fun parsePreamble(fileName: String): KgSourceFile {

        // TODO: fileAnnotations()

        val pkg = parsePackageHeader()

        val result = pkg.`source file`(fileName)

        parseImports(result)

        return result

    }

    /**
     * SimpleName{"."}
     */
    override fun parseQualifiedName(): KgQualifiedName {

        var name = parseSimpleName()
        var result = KgQualifiedName(null, name.text, name.origin)

        while (hasLookAheadIdentifier(2) && consumeWhen(DOT)) {
            name = parseSimpleName()
            result = KgQualifiedName(result, name.text, name.origin)
        }

        return result

    }

    private fun parseSemicolonOrNewLine() {

        if (!consumeWhen(SEMICOLON) && !hasLookAheadOnNewLine()) {
            expected("semicolon or new line")
        }

    }

    private fun parseSimpleName(): NameWithOrigin {
        // TODO: or soft keyword
        val nameToken = readIdentifier()
        return NameWithOrigin(nameToken.text, convertOrigin(nameToken.origin))
    }

    /**
     * topLevelObject (used by kotlinFile)
     *   : class
     *   : object
     *   : function
     *   : property
     *   : typeAlias
     *   ;
     */
    private fun parseTopLevelObject(srcFile: KgSourceFile) {

        val modifiers = parseModifiers()

        when (lookAhead(1)?.type) {
            CLASS     -> parseClass(srcFile, modifiers)
            INTERFACE -> parseInterface(srcFile, modifiers)
            OBJECT    -> parseObject(srcFile, modifiers)
            VAL       -> parseProperty(srcFile, modifiers)
            VAR       -> parseProperty(srcFile, modifiers)
            TYPEALIAS -> parseTypeAlias(srcFile, modifiers)
            else      -> expected("top level object", CLASS, INTERFACE, OBJECT, VAL, VAR, TYPEALIAS)
        }

    }

    private fun parseTypeAlias(srcFile: KgSourceFile, modifiers: KgModifierList) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /**
     * property (used by memberDeclaration, declaration, topLevelObject)
     *   : modifiers ("val" | "var")
     *   typeParameters?
     *   (type ".")?
     *   (multipleVariableDeclarations | variableDeclarationEntry)
     *   typeConstraints
     *   ("by" | "=" expression SEMI?)?
     *   (getter? setter? | setter? getter?) SEMI?
     *   ;
     */
    private fun parseProperty(srcFile: KgSourceFile, modifiers: KgModifierList) { //: KtProperty {

        // "val"
        val keyword = read()!!

        // TODO: typeParameters
        // TODO: (type ".")?

        val propertyName = parseSimpleName()

//        val result = if ( keyword.type == VAL ) {
//            srcFile.`val`(propertyName){}
//        }
//        else {
//            srcFile.`var`(propertyName){}
//        }
//
//        result {
//            keywordOrigin = keyword.origin
//            add(modifiers)
//        }

        if (consumeWhen(COLON)) {
            // TODO: parseType()
        }

        // TODO: by/= expression

        // TODO: getter/setter

        parseSemicolonOrNewLine()

//        return result

    }

}

//---------------------------------------------------------------------------------------------------------------------

