//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.kotlgen.parsing

//---------------------------------------------------------------------------------------------------------------------

/**
 * Implementation of KotlinTokenBuffer using a ring buffer with fixed size.
 */
internal class KotlinTokenBufferImpl(
    private val lexer: KotlinLexer
) : KotlinTokenBuffer {

    /** The index of the first unread token in the ring buffer. */
    private var first = 0

    /** The number of unconsumed tokens in the ring buffer. */
    private var length = 0

    /** The size of the ring. */
    private var size = 2

    /** The ring buffer of tokens consumed and waiting to be consumed. */
    private var tokens = arrayOfNulls<KotlinToken>(size)

    ////

    /**
     * Reads tokens from the lexer into this buffer until there are at least [count] tokens of look-ahead and
     * one token of look-behind.
     */
    private fun fill(count: Int) {

        while (count > size - 1) {
            tokens += arrayOfNulls<KotlinToken>(size)
            size *= 2
        }

        while (length < count) {
            tokens[ringIndex(first + length)] = lexer.yylex()
            length += 1
        }

    }

    /**
     * Advances the indexes after consuming [count] tokens from the buffer.
     */
    private fun advance(count: Int) {
        first = ringIndex(first + count)
        length -= count
    }

    /**
     * Performs the modulo arithmetic needed to keep an [index] within the ring buffer range.
     */
    private fun ringIndex(index: Int) =
        index % size

    ////

    override fun consume(count: Int) {
        fill(count)
        advance(count)
    }

    override fun consumeWhen(vararg tokenTypes: EKotlinTokenType): Boolean {

        fill(tokenTypes.size)

        for (i in 0 until tokenTypes.size) {
            if (tokens[ringIndex(first + i)]?.type != tokenTypes[i]) {
                return false
            }
        }

        consume(tokenTypes.size)
        return true

    }

    override fun hasLookAhead() =
        lookAhead(1)?.type != null

    override fun hasLookAhead(tokenType: EKotlinTokenType) =
        tokenType == lookAhead(1)?.type

    override fun hasLookAhead(count: Int, tokenType: EKotlinTokenType) =
        tokenType == lookAhead(count)?.type

    override fun hasLookAheadIdentifier() =
        lookAhead(1)?.type?.isPotentialIdentifier ?: false

    override fun hasLookAheadIdentifier(count: Int) =
        lookAhead(count)?.type?.isPotentialIdentifier ?: false

    override fun hasLookAheadOnNewLine(): Boolean {
        val token0 = lookAhead(0) ?: return false
        val token1 = lookAhead(1) ?: return true
        return token1.line > token0.line
    }

    override fun lookAhead(count: Int): KotlinToken? {
        fill(count)
        return tokens[ringIndex(first + count + size - 1)]
    }

    override fun read(): KotlinToken {
        val result = lookAhead(1) ?: throw IllegalStateException("Unexpected end of input.")
        advance(1)
        return result
    }

}

//---------------------------------------------------------------------------------------------------------------------

