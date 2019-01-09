//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.kotlgen.model.core

//---------------------------------------------------------------------------------------------------------------------

/**
 * Sealed class representing the possibilities for where a code element or one of its attributes originated.
 */
sealed class KgOrigin

//---------------------------------------------------------------------------------------------------------------------

/**
 * The origin of a code element or attribute is unknown or uninteresting.
 */
object KgOriginUnspecified
    : KgOrigin()

//---------------------------------------------------------------------------------------------------------------------

/**
 * A code element or attribute was code-generated.
 */
object KgOriginGenerated
    : KgOrigin()

//---------------------------------------------------------------------------------------------------------------------

/**
 * The origin of a code element is specified as an offset in a string of text.
 */
data class KgOriginOffset(
    val codeOffset: Int
) : KgOrigin()

//---------------------------------------------------------------------------------------------------------------------

/**
 * The origin of a code element is specified as an offset in a string of text.
 */
data class KgOriginOffsetStartAndEnd(
    val codeOffsetStart: Int,
    val codeOffsetEnd: Int
) : KgOrigin()

//---------------------------------------------------------------------------------------------------------------------

/**
 * The origin of a code element is specified as an offset in a string of text plus the length of text representing
 * the element.
 */
data class KgOriginOffsetAndSize(
    val codeOffset: Int,
    val size: Int
) : KgOrigin()

//---------------------------------------------------------------------------------------------------------------------

/**
 * The origin of a code element is represented as the line and column numbers (both one-based) for the element
 * in a line-terminator delimited string of text.
 */
data class KgOriginLineAndColumn(
    val line: Int,
    val column: Int
) : KgOrigin()

//---------------------------------------------------------------------------------------------------------------------

/**
 * The origin of a code element is represented as the line and column numbers (both one-based) for the element
 * in a line-terminator delimited string of text together with the length of text representing the element.
 */
data class KgOriginLineColumnAndSize(
    val line: Int,
    val column: Int,
    val size: Int
) : KgOrigin()

//---------------------------------------------------------------------------------------------------------------------

