//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.kotlgen.parsing

//---------------------------------------------------------------------------------------------------------------------

internal interface KotlinExpectedTokenBuffer : KotlinTokenBuffer {

    fun expected(description: String): Nothing

    fun expected(vararg tokenTypes: EKotlinTokenType): Nothing

    fun expected(description: String, vararg tokenTypes: EKotlinTokenType): Nothing

    fun read(tokenType: EKotlinTokenType): KotlinToken

    fun readOneOf(vararg tokenTypes: EKotlinTokenType): KotlinToken

    fun readIdentifier(): KotlinToken

}

//---------------------------------------------------------------------------------------------------------------------

