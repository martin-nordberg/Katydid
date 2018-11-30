////
//// (C) Copyright 2018 Martin E. Nordberg III
//// Apache 2.0 License
////
//
//package experiments
//
//import org.jetbrains.kotlin.cli.jvm.compiler.EnvironmentConfigFiles
//import org.jetbrains.kotlin.cli.jvm.compiler.KotlinCoreEnvironment
//import org.jetbrains.kotlin.com.intellij.openapi.util.Disposer
//import org.jetbrains.kotlin.com.intellij.psi.PsiErrorElement
//import org.jetbrains.kotlin.com.intellij.psi.PsiManager
//import org.jetbrains.kotlin.com.intellij.testFramework.LightVirtualFile
//import org.jetbrains.kotlin.config.CompilerConfiguration
//import org.jetbrains.kotlin.idea.KotlinFileType
//import org.jetbrains.kotlin.parsing.KotlinParser
//import org.jetbrains.kotlin.psi.KtFile
//import org.jetbrains.kotlin.psi.psiUtil.collectDescendantsOfType
//import org.junit.jupiter.api.Test
//import kotlin.test.assertEquals
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
//    fun `A simple enum class parses`() {
//
//        val code = """
//                    |
//                    |package example.pkg1
//                    |
//                    |import sample.pkg1
//                    |import sample.pkg2
//                    |import sample.pkg3
//                    |
//                    |internal enum class ESample {
//                    |    A,
//                    |    B;
//                    |}
//                    |
//                    |""".trimMargin()
//
//        val proj =
//            KotlinCoreEnvironment.createForProduction(
//                Disposer.newDisposable(),
//                CompilerConfiguration(),
//                EnvironmentConfigFiles.JVM_CONFIG_FILES
//            ).project
//
//        val file =
//            PsiManager.getInstance(proj).findFile(LightVirtualFile("temp.kt", KotlinFileType.INSTANCE, code)) as KtFile
//
//        assertEquals(3, file.importDirectives.size)
//
//        val imp = file.importDirectives[0]
//
//    }
//
//    @Test
//    fun `A simple enum class parses simply`() {
//
//        val code = """
//                    |
//                    |package example.pkg1
//                    |
//                    |import sample.pkg1
//                    |import sample.pkg2
//                    |import sample.pkg3
//                    |
//                    |internal enum class ESample {
//                    |    A,
//                    |    B;
//                    |}
//                    |
//                    |""".trimMargin()
//
//        val proj =
//            KotlinCoreEnvironment.createForProduction(
//                Disposer.newDisposable(),
//                CompilerConfiguration(),
//                EnvironmentConfigFiles.JVM_CONFIG_FILES
//            ).project
//
//        val parser = KotlinParser(proj);
//
//
////
////        val file =
////            PsiManager.getInstance(proj).findFile(LightVirtualFile("temp.kt", KotlinFileType.INSTANCE, code)) as KtFile
////
////        assertEquals(3, file.importDirectives.size)
////
////        val imp = file.importDirectives[0]
//
//    }
//
//    @Test
//    fun `Parsing broken code gives error messages`() {
//
//        val code = """
//                    |
//                    |package example.pkg1
//                    |
//                    |import sample.pkg1
//                    |import sample.pkg2 += 3
//                    |import sample.pkg3
//                    |
//                    |internal enum class ESample -> go {
//                    |    A,
//                    |    B;
//                    |}
//                    |
//                    |""".trimMargin()
//
//        val proj =
//            KotlinCoreEnvironment.createForProduction(
//                Disposer.newDisposable(),
//                CompilerConfiguration(),
//                EnvironmentConfigFiles.JVM_CONFIG_FILES
//            ).project
//
//        val file =
//            PsiManager.getInstance(proj).findFile(LightVirtualFile("temp.kt", KotlinFileType.INSTANCE, code)) as KtFile
//
//        val errors = file.collectDescendantsOfType<PsiErrorElement>()
//
//        for(error in errors) {
//
//            val offset = error.textOffset
//            val line = offsetToLineNumber(code, offset)
//
//            print(error.containingFile.name)
//            print(": (")
//            print( "${line.first},${line.second}): ")
//            println(error.errorDescription)
//        }
//
//        assertEquals(10, errors.size)
//
//    }
//
//    private fun offsetToLineNumber(text: CharSequence, offset: Int): Pair<Int,Int> {
//        var curCol = 1
//        var curLine = 1
//        var curOffset = 0
//
//        while (curOffset < offset) {
//
//            if (curOffset == text.length) {
//                return -1 to -1
//            }
//
//            val c = text[curOffset]
//            if (c == '\n') {
//                curLine += 1
//                curCol = 1
//            }
//
//            curOffset += 1
//            curCol += 1
//
//        }
//
//        return curLine to curCol
//    }
//
//}
//
////---------------------------------------------------------------------------------------------------------------------
//
