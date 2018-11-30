////
//// (C) Copyright 2018 Martin E. Nordberg III
//// Apache 2.0 License
////
//
//package org.jetbrains.kotlin.parsing
//
//import org.jetbrains.kotlin.KtNodeTypes
//import org.jetbrains.kotlin.cli.jvm.compiler.EnvironmentConfigFiles
//import org.jetbrains.kotlin.cli.jvm.compiler.KotlinCoreEnvironment
//import org.jetbrains.kotlin.com.intellij.core.CoreASTFactory
//import org.jetbrains.kotlin.com.intellij.lang.ASTNode
//import org.jetbrains.kotlin.com.intellij.lang.PsiBuilderFactory
//import org.jetbrains.kotlin.com.intellij.lexer.Lexer
//import org.jetbrains.kotlin.com.intellij.openapi.util.Disposer
//import org.jetbrains.kotlin.com.intellij.psi.PsiManager
//import org.jetbrains.kotlin.com.intellij.psi.impl.source.tree.CompositeElement
//import org.jetbrains.kotlin.com.intellij.testFramework.LightVirtualFile
//import org.jetbrains.kotlin.config.CompilerConfiguration
//import org.jetbrains.kotlin.idea.KotlinFileType
//import org.jetbrains.kotlin.idea.KotlinLanguage
//import org.jetbrains.kotlin.psi.KtExpressionCodeFragment
//import org.jetbrains.kotlin.psi.KtFile
//import org.junit.jupiter.api.Test
//import kotlin.test.assertEquals
//import kotlin.test.assertNotNull
//
//
////---------------------------------------------------------------------------------------------------------------------
//
//// From: https://github.com/cretz/kastree
//
//class KotlinCompilerTests {
//
//    init {
//        // To hide annoying warning on Windows
//        System.setProperty("idea.use.native.fs.for.win", "false")
//    }
//
//    @Test
//    fun `A simple enum class parses with embeddable parser`() {
//
//        val code = """
//                    |
//                    |package example.pkg1
//                    |
//                    |import sample.pkg1
//                    |import sample.pkg2 as two
//                    |import sample.pkg3
//                    |
//                    |internal enum class ESample {
//                    |    A,
//                    |    B;
//                    |}
//                    |
//                    |""".trimMargin()
//
//        val project =
//            KotlinCoreEnvironment.createForProduction(
//                Disposer.newDisposable(),
//                CompilerConfiguration(),
//                EnvironmentConfigFiles.JVM_CONFIG_FILES
//            ).project
//
//        val vFile = LightVirtualFile("temp.kt", KotlinFileType.INSTANCE, code)
//
//        val viewProvider = PsiManager.getInstance(project).findViewProvider(vFile)!!
//        val psiFile = KtFile(viewProvider,false)
//
////        val languageForParser = KotlinLanguage.INSTANCE
////        val elementType = KtNodeTypes.KT_FILE
////
////        val chameleon: ASTNode = CoreASTFactory().createLazy(elementType,code)
////        chameleon as CompositeElement
////        chameleon.psi = psiFile
////
////        val psiBuilder =
////            PsiBuilderFactory.getInstance().createBuilder(project, chameleon, null as Lexer?, languageForParser, chameleon.getChars())
////
////
////        val parser =
////            (LanguageParserDefinitions.INSTANCE.forLanguage(languageForParser) as ParserDefinition).createParser(project) as KotlinParser
////
////        val x1 = parser.parse(elementType,psiBuilder,psiFile)
////
////        assertNotNull(x1)
////
////
////        val ktParsing = KotlinParsing.createForTopLevel(SemanticWhitespaceAwarePsiBuilderImpl(psiBuilder))
////
////        ktParsing.parseFile()
////
////        val x : ASTNode = psiBuilder.getTreeBuilt()
////
////        assertNotNull(x)
//
//        assertEquals( "example.pkg1", psiFile.packageDirective?.qualifiedName)
//
//        assertEquals(3, psiFile.importDirectives.size)
//        assertEquals( "sample.pkg1", psiFile.importDirectives[0].importedReference?.text)
//        assertEquals( "sample.pkg2", psiFile.importDirectives[1].importedReference?.text)
//        assertEquals( "two", psiFile.importDirectives[1].aliasName)
//        assertEquals( "sample.pkg3", psiFile.importDirectives[2].importedReference?.text)
//
//        assertEquals(1, psiFile.declarations.size)
//        assertEquals("ESample",psiFile.declarations[0].name)
//
//    }
//
//    @Test
//    fun `An expression parses with embeddable parser`() {
//
//        val code = """
//                    |
//                    |x + y * 3
//                    |
//                    |""".trimMargin()
//
//        val project =
//            KotlinCoreEnvironment.createForProduction(
//                Disposer.newDisposable(),
//                CompilerConfiguration(),
//                EnvironmentConfigFiles.JVM_CONFIG_FILES
//            ).project
//
//        val psiExpr = KtExpressionCodeFragment(project,"sample",code,null,null)
//
//        val languageForParser = KotlinLanguage.INSTANCE
//        val elementType = KtNodeTypes.EXPRESSION_CODE_FRAGMENT
//
//        val chameleon: ASTNode = CoreASTFactory().createLazy(elementType,code)
//        chameleon as CompositeElement
//        chameleon.psi = psiExpr
//
//        val psiBuilder =
//            PsiBuilderFactory.getInstance().createBuilder(project, chameleon, null as Lexer?, languageForParser, chameleon.getChars())
//
//        val ktParsing = KotlinParsing.createForTopLevel(SemanticWhitespaceAwarePsiBuilderImpl(psiBuilder))
//
//        ktParsing.parseExpressionCodeFragment()
//
//        val x : ASTNode = psiBuilder.getTreeBuilt()
//
//        assertNotNull(x)
//
//        val p = x.psi
//
//        assertEquals(code,p.text)
//
//    }
//
//    @Test
//    fun `A code block parses with embeddable parser`() {
//
//        val code = """
//                    |
//                    |  val q = x + y * 3
//                    |  val r: Int = 7
//                    |  println(q*r)
//                    |
//                    |""".trimMargin()
//
//        val project =
//            KotlinCoreEnvironment.createForProduction(
//                Disposer.newDisposable(),
//                CompilerConfiguration(),
//                EnvironmentConfigFiles.JVM_CONFIG_FILES
//            ).project
//
//        val psiExpr = KtExpressionCodeFragment(project,"sample",code,null,null)
//
//        val languageForParser = KotlinLanguage.INSTANCE
//        val elementType = KtNodeTypes.BLOCK_CODE_FRAGMENT
//
//        val chameleon: ASTNode = CoreASTFactory().createLazy(elementType,code)
//        chameleon as CompositeElement
//        chameleon.psi = psiExpr
//
//        val psiBuilder =
//            PsiBuilderFactory.getInstance().createBuilder(project, chameleon, null as Lexer?, languageForParser, chameleon.getChars())
//
//        val ktParsing = KotlinParsing.createForTopLevel(SemanticWhitespaceAwarePsiBuilderImpl(psiBuilder))
//
//        ktParsing.parseBlockCodeFragment()
//
//        val x : ASTNode = psiBuilder.getTreeBuilt()
//
//        assertNotNull(x)
//
//        val p = x.psi
//
//        assertEquals(code,p.text)
//
//    }
//
//}
//
////---------------------------------------------------------------------------------------------------------------------
//
