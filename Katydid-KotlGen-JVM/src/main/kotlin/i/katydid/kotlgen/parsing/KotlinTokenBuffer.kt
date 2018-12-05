//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.kotlgen.parsing

//---------------------------------------------------------------------------------------------------------------------

internal interface KotlinTokenBuffer {

    fun consume(count: Int = 1)

    fun consumeWhen(vararg tokenTypes: EKotlinTokenType): Boolean

    fun hasLookAhead(): Boolean

    fun hasLookAhead(tokenType: EKotlinTokenType): Boolean

    fun hasLookAhead(count: Int, tokenType: EKotlinTokenType): Boolean

    fun hasLookAheadIdentifier(): Boolean

    fun hasLookAheadIdentifier(count: Int): Boolean

    fun hasLookAheadOnNewLine(): Boolean

    fun lookAhead(count: Int): KotlinToken?

    fun read(): KotlinToken

}

//---------------------------------------------------------------------------------------------------------------------

