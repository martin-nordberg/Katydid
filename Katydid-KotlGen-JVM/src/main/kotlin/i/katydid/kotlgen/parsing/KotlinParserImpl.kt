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
     *     typeParameters?
     *     primaryConstructor?
     *     (":" annotations delegationSpecifier{","})?
     *     typeConstraints
     *     (classBody? | enumClassBody)
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

            mergeModifiers(modifiers)
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
            result.add(KgModifier(keyword, convertOrigin(read())))

        while (true) {
            when (lookAhead(1)?.type) {
                // TODO: annotations
                ABSTRACT    -> readModifier(KgModifierKeyword.`abstract`)
                ACTUAL      -> readModifier(KgModifierKeyword.`actual`)
                ANNOTATION  -> readModifier(KgModifierKeyword.`annotation`)
                CONST       -> readModifier(KgModifierKeyword.`const`)
                CROSSINLINE -> readModifier(KgModifierKeyword.`crossinline`)
                DATA        -> readModifier(KgModifierKeyword.`data`)
                ENUM        -> readModifier(KgModifierKeyword.`enum`)
                EXPECT      -> readModifier(KgModifierKeyword.`expect`)
                EXTERNAL    -> readModifier(KgModifierKeyword.`external`)
                FINAL       -> readModifier(KgModifierKeyword.`final`)
                IN          -> readModifier(KgModifierKeyword.`in`)
                INFIX       -> readModifier(KgModifierKeyword.`infix`)
                INLINE      -> readModifier(KgModifierKeyword.`inline`)
                INTERNAL    -> readModifier(KgModifierKeyword.`internal`)
                LATEINIT    -> readModifier(KgModifierKeyword.`lateinit`)
                NOINLINE    -> readModifier(KgModifierKeyword.`noinline`)
                OPEN        -> readModifier(KgModifierKeyword.`open`)
                OPERATOR    -> readModifier(KgModifierKeyword.`operator`)
                OUT         -> readModifier(KgModifierKeyword.`out`)
                OVERRIDE    -> readModifier(KgModifierKeyword.`override`)
                PRIVATE     -> readModifier(KgModifierKeyword.`private`)
                PROTECTED   -> readModifier(KgModifierKeyword.`protected`)
                PUBLIC      -> readModifier(KgModifierKeyword.`public`)
                REIFIED     -> readModifier(KgModifierKeyword.`reified`)
                SEALED      -> readModifier(KgModifierKeyword.`sealed`)
                SUSPEND     -> readModifier(KgModifierKeyword.`suspend`)
                TAILREC     -> readModifier(KgModifierKeyword.`tailrec`)
                VARARG      -> readModifier(KgModifierKeyword.`vararg`)
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

    /**
     * typeAlias (used by memberDeclaration, declaration, topLevelObject)
     *   : modifiers "typealias" SimpleName typeParameters? "=" type
     *   ;
     */
    private fun parseTypeAlias(parent: KgTopLevelDeclaring, modifiers: KgModifierList) {

        // "typealias"
        val keyword = read(TYPEALIAS)

        val aliasName = parseSimpleName()

        val typeAlias = parent.`typealias`(aliasName.text) {
            keywordOrigin = convertOrigin(keyword)
            nameOrigin = aliasName.origin
            mergeModifiers(modifiers)
        }

        // TODO: type parameters

        read(EQ)

        parseType(typeAlias)

        parseSemicolonOrNewLine()

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
    private fun parseProperty(parent: KgDeclaring, modifiers: KgModifierList) {

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

        if (consumeWhen(DYNAMIC)) {
            type.isDynamic = true
            return
        }

        // TODO: parenthesis - parenthesized or function type

        // parse a simple user type ...
        var name = parseSimpleName()
        type.addTypeReference(name.text) {
            origin = name.origin
        }
        // TODO: type parameters

        while (hasLookAheadIdentifier(2) && consumeWhen(DOT)) {
            name = parseSimpleName()
            type.addTypeReference(name.text) {
                origin = name.origin
            }
            // TODO: type parameters
        }


        if (consumeWhen(QUESTION)) {
            type.isNullable = true
        }

    }

}

//---------------------------------------------------------------------------------------------------------------------

