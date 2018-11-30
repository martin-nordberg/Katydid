//
// (C) Copyright  Martin E. Nordberg III
// Apache . License
//

package jvm.katydid.kotlgen.parsing

import org.junit.jupiter.api.Test
import kotlin.test.assertNotNull

class SampleCodeTests {

    private fun checkParse(fileName: String) {

        val inStream = this::class.java.getResourceAsStream(fileName)

        assertNotNull(inStream, "Missing file: '$fileName'.")

        // TODO: parse and check for success

    }

    private fun checkParseError(fileName: String) {

        val inStream = this::class.java.getResourceAsStream(fileName)

        assertNotNull(inStream, "Missing file: '$fileName'.")

        // TODO: parse and check for failure

    }

    @Test
    fun `The parser parses valid sample files`() {

        val fileNames = listOf(
            "AnonymousInitializer.kt",
            "BabySteps.kt",
            "ByClauses.kt",
            "CallsInWhen.kt",
            "CallWithManyClosures.kt",
            "CollectionLiterals.kt",
            "CommentsBindingInLambda.kt",
            "CommentsBindingInStatementBlock.kt",
            "Constructors.kt",
            "destructuringInLambdas.kt",
            "DocCommentAfterFileAnnotations.kt",
            "DocCommentForFirstDeclaration.kt",
            "DocCommentOnPackageDirectiveLine.kt",
            "DocCommentsBinding.kt",
            "DoubleColonWhitespaces.kt",
            "DynamicReceiver.kt",
            "DynamicTypes.kt",
            "EmptyFile.kt",
            "EnumCommas.kt",
            "EnumEntrySemicolonInlineMember.kt",
            "EnumEntrySemicolonMember.kt",
            "EnumIn.kt",
            "EnumInline.kt",
            "EnumInlinePublic.kt",
            "Enums.kt",
            "EnumShortCommas.kt",
            "EnumShortWithOverload.kt",
            "EOLsInComments.kt",
            "EOLsOnRollback.kt",
            "ExtensionsWithQNReceiver.kt",
            "FloatingPointLiteral.kt",
            "FunctionCalls.kt",
            "FunctionLiterals.kt",
            "FunctionsWithoutName.kt",
            "FunctionTypes.kt",
            "IfWithPropery.kt",
            "Imports.kt",
            "ImportSoftKW.kt",
            "IncompleteFunctionLiteral.kt",
            "Inner.kt",
            "Interface.kt",
            "LineCommentAfterFileAnnotations.kt",
            "LineCommentForFirstDeclaration.kt",
            "LineCommentsInBlock.kt",
            "LocalDeclarations.kt",
            "LongPackageName.kt",
            "ModifierAsSelector.kt",
            "NamedClassObject.kt",
            "NestedComments.kt",
            "NewLinesValidOperations.kt",
            "NotIsAndNotIn.kt",
            "ObjectLiteralAsStatement.kt",
            "PropertyInvokes.kt",
            "QuotedIdentifiers.kt",
            "SemicolonAfterIf.kt",
            "SimpleClassMembers.kt",
            "SimpleExpressions.kt",
            "SimpleModifiers.kt",
            "SoftKeywords.kt",
            "SoftKeywordsInTypeArguments.kt",
            "TraitConstructor.kt",
            "TypeAlias.kt",
            "TypeConstraints.kt",
            "TypeModifiers.kt",
            "WhenWithSubjectVariable_SoftModifierName.kt"
        )

        for (fileName in fileNames) {
            checkParse("good/$fileName")
        }

    }

    @Test
    fun `The parser parses valid Katydid files`() {

        val fileNames = listOf(
            "KatydidElement.kt",
            "KatydidHtmlElement.kt",
            "KatydidNode.kt",
            "KatydidElementImpl.kt",
            "KatydidHtmlElementImpl.kt",
            "KatydidNodeImpl.kt"
        )

        for (fileName in fileNames) {
            checkParse("good/katydid/$fileName")
        }

    }

    @Test
    fun `The parser finds errors in invalid sample files`() {

        val fileNames = listOf(
            "AbsentInnerType.kt",
            "BabySteps_ERR.kt",
            "BackslashInString.kt",
            "BlockCommentAtBeginningOfFile1.kt",
            "BlockCommentAtBeginningOfFile2.kt",
            "BlockCommentAtBeginningOfFile3.kt",
            "BlockCommentAtBeginningOfFile4.kt",
            "BlockCommentUnmatchedClosing_ERR.kt",
            "CollectionLiterals_ERR.kt",
            "CommentsBinding.kt",
            "ControlStructures.kt",
            "DefaultKeyword.kt",
            "destructuringInLambdas_ERR.kt",
            "DoubleColon.kt",
            "DoubleColon_ERR.kt",
            "DuplicateAccessor.kt",
            "DynamicSoftKeyword.kt",
            "EmptyName.kt",
            "EnumEntryCommaAnnotatedMember.kt",
            "EnumEntryCommaInlineMember.kt",
            "EnumEntryCommaMember.kt",
            "EnumEntryCommaPublicMember.kt",
            "EnumEntrySpaceInlineMember.kt",
            "EnumEntrySpaceMember.kt",
            "EnumEntryTwoCommas.kt",
            "EnumMissingName.kt",
            "EnumOldConstructorSyntax.kt",
            "EnumWithAnnotationKeyword.kt",
            "Expressions_ERR.kt",
            "FileStart_ERR.kt",
            "ForWithMultiDecl.kt",
            "FunctionExpressions.kt",
            "FunctionExpressions_ERR.kt",
            "FunctionLiterals_ERR.kt",
            "FunctionNoParameterList.kt",
            "Functions.kt",
            "FunctionsWithoutName_ERR.kt",
            "Functions_ERR.kt",
            "FunctionTypes_ERR.kt",
            "HangOnLonelyModifier.kt",
            "Imports_ERR.kt",
            "IntegerLiteral.kt",
            "InterfaceWithEnumKeyword.kt",
            "Labels.kt",
            "MultiVariableDeclarations.kt",
            "namelessObjectAsEnumMember.kt",
            "NewlinesInParentheses.kt",
            "NonTypeBeforeDotInBaseClass.kt",
            "ParameterNameMising.kt",
            "ParameterType.kt",
            "ParameterType_ERR.kt",
            "Precedence.kt",
            "PrimaryConstructorModifiers_ERR.kt",
            "Properties.kt",
            "PropertiesFollowedByInitializers.kt",
            "Properties_ERR.kt",
            "Reserved.kt",
            "semicolonBetweenDeclarations.kt",
            "SimpleClassMembers_ERR.kt",
            "StringTemplates.kt",
            "Super.kt",
            "TripleDot.kt",
            "TryRecovery.kt",
            "TypealiasIsKeyword.kt",
            "TypeAlias_ERR.kt",
            "TypeExpressionAmbiguities_ERR.kt",
            "TypeModifiersParenthesized.kt",
            "TypeModifiers_ERR.kt",
            "TypeParametersBeforeName.kt",
            "UnsignedLiteral.kt",
            "When.kt",
            "WhenWithSubjectVariable.kt",
            "WhenWithSubjectVariable_ERR.kt",
            "When_ERR.kt"

        )

        for (fileName in fileNames) {
            checkParseError("bad/$fileName")
        }

    }

}
