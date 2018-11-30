////
//// (C) Copyright 2018 Martin E. Nordberg III
//// Apache 2.0 License
////
//
//package i.katydid.kotlgen.parsing_jetbrains
//
//import o.katydid.kotlgen.model.KgSourceRoot
//import o.katydid.kotlgen.model.core.KgOriginOffsetAndSize
//import o.katydid.kotlgen.model.core.modifiers.KgModifier
//import o.katydid.kotlgen.model.core.modifiers.KgModifierKeyword
//import o.katydid.kotlgen.model.core.modifiers.KgModifierList
//import o.katydid.kotlgen.model.core.names.KgQualifiedName
//import o.katydid.kotlgen.model.declarations.KgDeclaring
//import o.katydid.kotlgen.model.declarations.KgNonlocalDeclaring
//import o.katydid.kotlgen.model.declarations.classes.KgEnumClass
//import o.katydid.kotlgen.model.structure.KgSourceFile
//import o.katydid.kotlgen.parsing.KotlinParser
//import org.jetbrains.kotlin.cli.jvm.compiler.EnvironmentConfigFiles
//import org.jetbrains.kotlin.cli.jvm.compiler.KotlinCoreEnvironment
//import org.jetbrains.kotlin.com.intellij.openapi.util.Disposer
//import org.jetbrains.kotlin.com.intellij.psi.PsiManager
//import org.jetbrains.kotlin.com.intellij.psi.PsiWhiteSpace
//import org.jetbrains.kotlin.com.intellij.testFramework.LightVirtualFile
//import org.jetbrains.kotlin.config.CompilerConfiguration
//import org.jetbrains.kotlin.idea.KotlinFileType
//import org.jetbrains.kotlin.psi.*
//import org.jetbrains.kotlin.psi.psiUtil.children
//
////---------------------------------------------------------------------------------------------------------------------
//
//internal class KotlinParserImpl(
//    private val sourceRoot: KgSourceRoot,
//    private val code: String
//) : KotlinParser {
//
//    init {
//        // Avoid an annoying warning on Windows.
//        System.setProperty("idea.use.native.fs.for.win", "false")
//    }
//
//    ////
//
//    /**
//     * Parses a Kotlin code file using the embeddable Kotlin compiler and then converting its AST to KotlGen
//     * model classes.
//     */
//    override fun parseKotlinFile(fileName: String): KgSourceFile {
//
//        // Configure the embeddable compiler.
//        val project =
//            KotlinCoreEnvironment.createForProduction(
//                Disposer.newDisposable(),
//                CompilerConfiguration(),
//                EnvironmentConfigFiles.JVM_CONFIG_FILES
//            ).project
//
//        // Wrap the code in a virtual file for JetBrains style parsing.
//        val virtualFile = LightVirtualFile("$fileName.kt", KotlinFileType.INSTANCE, code)
//
//        // Perform the parse, yielding a source file as the root of an AST.
//        val file = PsiManager.getInstance(project).findFile(virtualFile) as KtFile
//
//        // TODO: look for errors and quit early
//
//        // TODO: Read the file annotations.
//
//        // Transform the package directive.
//        val pkg = sourceRoot.`package`(file.packageDirective?.qualifiedName ?: "")
//
//        // Transform the rest of the source file.
//        return pkg.`source file`(fileName) {
//
//            // TODO: Set the file annotations.
//
//            // Transform each import directive
//            for (imp in file.importDirectives) {
//                this.transformImport(imp)
//            }
//
//            // Transform each top level declaration
//            for (declaration in file.declarations) {
//                this.transformDeclaration(declaration)
//            }
//
//        }
//
//    }
//
//    override fun parseQualifiedName(): KgQualifiedName {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//    ////
//
//    private fun KgDeclaring.transformClass(declaration: KtClass) {
//
//        // modifiers
//        val parsedModifiers = transformModifiers(declaration)
//
//        // TODO: annotations
//
//        if (parsedModifiers.contains(KgModifierKeyword.enum) && this is KgNonlocalDeclaring) {
//
//            this.`enum class`(declaration.name ?: "Error: Missing name") {
//
//                modifiers.add(parsedModifiers)
//
//                for (member in declaration.declarations) {
//                    transformDeclaration(member)
//                }
//
//            }
//
//        }
//
//        // TODO: other class kinds
//
//    }
//
//    private fun KgDeclaring.transformDeclaration(declaration: KtDeclaration) {
//
//        when (declaration) {
//            is KtEnumEntry -> (this as KgEnumClass).transformEnumEntry(declaration)
//            is KtClass     -> transformClass(declaration)
//            // TODO ...
//            else           -> throw UnsupportedOperationException("Error: Unknown/unfinished declaration type.")
//        }
//
//    }
//
//    private fun KgEnumClass.transformEnumEntry(declaration: KtEnumEntry) {
//
//        // modifiers
//        val parsedModifiers = transformModifiers(declaration)
//
//        // TODO: annotations
//
//        this.`enum entry`(declaration.name ?: "Error: Missing name") {
//            modifiers.add(parsedModifiers)
//        }
//
//    }
//
//    private fun KgSourceFile.transformImport(imp: KtImportDirective) {
//
//        `import`(imp.importedFqName?.asString() ?: "Error: Missing import path") {
//            all = imp.isAllUnder
//            alias = imp.aliasName
//        }
//
//    }
//
//    private fun transformModifiers(element: KtModifierListOwner): KgModifierList {
//
//        val result = KgModifierList()
//
//        val modifiers = element.modifierList?.node?.children() ?: return result
//
//        for (node in modifiers) {
//            when (node.psi) {
//                is KtAnnotationEntry -> Unit
//                is KtAnnotation      -> Unit
//                is PsiWhiteSpace     -> Unit
//                else                 -> {
//                    result.add(KgModifier(node.text, KgOriginOffsetAndSize(node.startOffset, node.textLength)))
//                }
//            }
//        }
//
//        return result
//
//    }
//
//}
//
////---------------------------------------------------------------------------------------------------------------------
//
