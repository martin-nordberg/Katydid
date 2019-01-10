//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.kotlgen.parsing

//---------------------------------------------------------------------------------------------------------------------

/**
 * Interface adding the ability to read or trigger errors for expected tokens.
 */
internal interface KotlinExpectedTokenBuffer : KotlinTokenBuffer {

    /**
     * Throws ane error indicating the expected [description] was not found in the input.
     */
    fun expected(description: String): Nothing

    /**
     * Throws an error indicating that any one of the given [tokenTypes] was expected.
     */
    fun expected(vararg tokenTypes: EKotlinTokenType): Nothing

    /**
     * Throws an error indicating that any one of the given [tokenTypes] was expected preceded by a [description]
     * of those token types.
     */
    fun expected(description: String, vararg tokenTypes: EKotlinTokenType): Nothing

    /**
     * Reads one token expected to be of the given [tokenType].
     */
    fun read(tokenType: EKotlinTokenType): KotlinToken

    /**
     * Reads one token expected to have one of the given [tokenTypes].
     */
    fun readOneOf(vararg tokenTypes: EKotlinTokenType): KotlinToken

    /**
     * Reads an identifier (any token whose token type has isPotentialIdentifier == true).
     */
    fun readIdentifier(): KotlinToken

}

//---------------------------------------------------------------------------------------------------------------------

