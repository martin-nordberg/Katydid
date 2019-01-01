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
import o.katydid.kotlgen.model.declarations.KgDeclaring
import o.katydid.kotlgen.model.declarations.KgNonlocalDeclaring
import o.katydid.kotlgen.model.declarations.classes.KgEnumClass
import o.katydid.kotlgen.model.declarations.classes.KgMemberDeclaring
import o.katydid.kotlgen.model.declarations.properties.KgAbstractProperty
import o.katydid.kotlgen.model.structure.KgImporting
import o.katydid.kotlgen.model.structure.KgPackage
import o.katydid.kotlgen.model.structure.KgSourceFile
import o.katydid.kotlgen.model.structure.KgTopLevelDeclaring
import o.katydid.kotlgen.model.types.KgType
import o.katydid.kotlgen.model.types.KgTyped
import o.katydid.kotlgen.parsing.KotlinParser
import java.io.Reader

//---------------------------------------------------------------------------------------------------------------------

internal class KotlinParserImpl(
    code: Reader
) : KotlinParser,
    KotlinExpectedTokenBuffer by KotlinExpectedTokenBufferImpl(code) {

    private data class NameWithOrigin(
        val text: String,
        val origin: KgOrigin
    )

    private fun convertOrigin(token: KotlinToken): KgOriginLineColumnAndSize =
        KgOriginLineColumnAndSize(token.line, token.column, token.length)

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
    private fun parseClass(parent: KgNonlocalDeclaring, modifiers: KgModifierList) {

        // "class"
        val keyword = read(CLASS)

        val className = parseSimpleName()

        // TODO: typeParameters
        // TODO: primaryConstructor
        // TODO: delegationSpecifiers
        // TODO: type constraints

        if (modifiers.contains(KgModifierKeyword.`enum`)) {

            val enumClass = parent.`enum class`(className.text) {
                nameOrigin = className.origin
                keywordOrigin = convertOrigin(keyword)

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
     * class (used by memberDeclaration, declaration, topLevelObject)
     *   : modifiers ("class" | "interface") SimpleName
     *   typeParameters?
     *   primaryConstructor?
     *   (":" annotations delegationSpecifier{","})?
     *   typeConstraints
     *   (classBody? | enumClassBody)
     *   ;
     */
    private fun parseFunction(parent: KgDeclaring, modifiers: KgModifierList) {

        // "fun"
        val keyword = read(FUN)

        val functionName = parseSimpleName()

        // TODO: typeParameters

        val function = parent.`fun`(functionName.text) {
            nameOrigin = functionName.origin
            keywordOrigin = convertOrigin(keyword)

            mergeModifiers(modifiers)
        }

        // TODO ...

    }

    /**
     * import (used by preamble)
     *   : "import" SimpleName{"."} ("." "*" | "as" SimpleName)? SEMI?
     *   ;
     */
    private fun parseImports(sourceFile: KgImporting) {

        while (consumeWhen(IMPORT)) {

            val keyword = lookAhead(0)!!

            val imp = sourceFile.`import`(parseQualifiedName()) {
                keywordOrigin = convertOrigin(keyword)
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

    private fun parseInterface(parent: KgNonlocalDeclaring, modifiers: KgModifierList) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /**
     * kotlinFile
     *   : preamble topLevelObject*
     *   ;
     */
    override fun parseKotlinFile(sourceRoot: KgSourceRoot, fileName: String): KgSourceFile {

        val result = parsePreamble(sourceRoot, fileName)

        while (hasLookAhead()) {
            parseTopLevelObject(result)
        }

        return result

    }

    private fun parseMembers(clazz: KgMemberDeclaring) {
        // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun parseModifiers(): KgModifierList {

        val result = KgModifierList()

        fun readModifier(keyword: KgModifierKeyword) =
            KgModifier(keyword, convertOrigin(read()))

        while (true) {
            when (lookAhead(1)?.type) {
                // TODO: annotations
                ABSTRACT    -> result.add(readModifier(KgModifierKeyword.`abstract`))
                ACTUAL      -> result.add(readModifier(KgModifierKeyword.`actual`))
                ANNOTATION  -> result.add(readModifier(KgModifierKeyword.`annotation`))
                CONST       -> result.add(readModifier(KgModifierKeyword.`const`))
                CROSSINLINE -> result.add(readModifier(KgModifierKeyword.`crossinline`))
                DATA        -> result.add(readModifier(KgModifierKeyword.`data`))
                ENUM        -> result.add(readModifier(KgModifierKeyword.`enum`))
                EXPECT      -> result.add(readModifier(KgModifierKeyword.`expect`))
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

    private fun parseObject(parent: KgNonlocalDeclaring, modifiers: KgModifierList) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /**
     * packageHeader (used by preamble)
     *   : modifiers "package" SimpleName{"."} SEMI?
     *   ;
     */
    private fun parsePackageHeader(sourceRoot: KgSourceRoot): KgPackage {

        // TODO: modifiers ??

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
    private fun parsePreamble(sourceRoot: KgSourceRoot, fileName: String): KgSourceFile {

        // TODO: fileAnnotations()

        val pkg = parsePackageHeader(sourceRoot)

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
        val nameToken = readIdentifier()
        return NameWithOrigin(nameToken.text, convertOrigin(nameToken))
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
    private fun parseTopLevelObject(parent: KgTopLevelDeclaring) {

        val modifiers = parseModifiers()

        when (lookAhead(1)?.type) {
            CLASS     -> parseClass(parent, modifiers)
            INTERFACE -> parseInterface(parent, modifiers)
            OBJECT    -> parseObject(parent, modifiers)
            FUN       -> parseFunction(parent, modifiers)
            VAL, VAR  -> parseProperty(parent, modifiers)
            TYPEALIAS -> parseTypeAlias(parent, modifiers)
            else      -> expected("top level object", CLASS, INTERFACE, OBJECT, VAL, VAR, TYPEALIAS)
        }

    }

    private fun parseTypeAlias(parent: KgTopLevelDeclaring, modifiers: KgModifierList) {
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
    private fun parseProperty(parent: KgDeclaring, modifiers: KgModifierList): KgAbstractProperty {

        // "val" or "var"
        val keyword = readOneOf(VAL, VAR)

        // TODO: typeParameters
        // TODO: (type ".")?

        val propertyName = parseSimpleName()

        val result = if (keyword.type == VAL) {
            parent.`val`(propertyName.text) {}
        }
        else {
            parent.`var`(propertyName.text) {}
        }

        result.apply {
            keywordOrigin = convertOrigin(keyword)
            nameOrigin = propertyName.origin
            mergeModifiers(modifiers)
        }

        if (consumeWhen(COLON)) {
            parseType(result)
        }

        // TODO: by/= expression

        // TODO: getter/setter

        parseSemicolonOrNewLine()

        return result

    }

    /**
     * type
     *   : typeModifiers typeReference
     *   ;
     */
    private fun parseType(parent: KgTyped) {
        parseTypeModifiers(parent.type)
        parseTypeReference(parent.type)
    }

    /**
     * typeModifiers (used by type)
     *   : (suspendModifier | annotations)*
     *   ;
     */
    private fun parseTypeModifiers(type: KgType) {
        // TODO: annotations
        type.isSuspend = consumeWhen(SUSPEND)
    }

    /**
     * typeReference (used by typeReference, nullableType, type)
     *   : "(" typeReference ")"
     *   : functionType
     *       : (type ".")? "(" parameter{","}? ")" "->" type
     *       ;
     *   : userType
     *       : simpleUserType{"."}
     *       ;
     *   : nullableType
     *       : typeReference "?"
     *       ;
     *   : "dynamic"
     *   ;
     */
    private fun parseTypeReference(type: KgType) {

        if ( consumeWhen(DYNAMIC)) {
            type.isDynamic = true
            return
        }

        // TODO: parenthesis - parenthesized or function type

        // TODO

    }

}

//---------------------------------------------------------------------------------------------------------------------

