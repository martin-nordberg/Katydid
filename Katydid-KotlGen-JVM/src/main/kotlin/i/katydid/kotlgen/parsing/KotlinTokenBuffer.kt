//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.kotlgen.parsing

//---------------------------------------------------------------------------------------------------------------------

/**
 * Interface defining utilities for a parser to consume tokens or look ahead in a token buffer.
 */
internal interface KotlinTokenBuffer {

    /**
     * Consumes the next [count] tokens from the buffer.
     */
    fun consume(count: Int = 1)

    /**
     * Consumes a sequence of token types if they have the given [tokenTypes].
     * @return true if tokens of the given types were consumed.
     */
    fun consumeWhen(vararg tokenTypes: EKotlinTokenType): Boolean

    /**
     * Tests whether there is still input to be consumed.
     * @return true if there are more tokens to consume.
     */
    fun hasLookAhead(): Boolean

    /**
     * Tests whether the next token to be consumed has the given [tokenType].
     * @return true if the next token has the given [tokenType].
     */
    fun hasLookAhead(tokenType: EKotlinTokenType): Boolean

    /**
     * Tests whether the token [count] steps ahead in the input has given [tokenType].
     * @return true if the token [count] steps away from being read has given [tokenType].
     */
    fun hasLookAhead(count: Int, tokenType: EKotlinTokenType): Boolean

    /**
     * Tests whether the next token is an identifier.
     * @return true if the next token in the input has token type with isPotentialIdentifier == true.
     */
    fun hasLookAheadIdentifier(): Boolean

    /**
     * Tests whether the token [count] steps ahead in the input is an identifier.
     * @return true if the token [count] steps ahead in the input has token type with isPotentialIdentifier == true.
     */
    fun hasLookAheadIdentifier(count: Int): Boolean

    /**
     * Tests whether the next token in the input falls on a new line of the original text versus the latest read token.
     * @return true if the next token falls on a new line.
     */
    fun hasLookAheadOnNewLine(): Boolean

    /**
     * Returns the token [count] steps ahead in the input without consuming it.
     * @return the token [count] steps ahead in the input.
     */
    fun lookAhead(count: Int): KotlinToken?

    /**
     * Reads one token from the input.
     * @return the token read.
     */
    fun read(): KotlinToken

}

//---------------------------------------------------------------------------------------------------------------------

