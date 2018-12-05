//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.kotlgen.parsing

//---------------------------------------------------------------------------------------------------------------------

internal class KotlinTokenBufferImpl(
    private val lexer: KotlinLexer
) : KotlinTokenBuffer {

    private var first = 0

    private var last = 0

    private val size = 1024

    private val tokens = arrayOfNulls<KotlinToken>(size)

    ////

    override fun consume(count: Int) {
        fill(count)
        first = (first + count) % size
    }

    override fun consumeWhen(vararg tokenTypes: EKotlinTokenType): Boolean {

        fill(tokenTypes.size)

        for (i in 0 until tokenTypes.size) {
            if (tokens[(first + i) % size]?.type != tokenTypes[i]) {
                return false
            }
        }

        consume(tokenTypes.size)
        return true

    }

    private fun fill(count: Int) {

        // require( count < size )

        while (last - first < count) {
            tokens[last] = lexer.yylex()
            last = (last + 1) % size
        }

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
        return tokens[(first + count - 1) % size]
    }

    override fun read(): KotlinToken {
        val result = lookAhead(1) ?: throw IllegalStateException("Unexpected end of input.")
        first = (first + 1) % size
        return result
    }

}

//---------------------------------------------------------------------------------------------------------------------

