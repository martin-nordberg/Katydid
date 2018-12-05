//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.kotlgen.parsing

import i.katydid.kotlgen.parsing.EKotlinTokenType.IDENTIFIER
import java.io.Reader

//---------------------------------------------------------------------------------------------------------------------

internal class KotlinExpectedTokenBufferImpl(
    code: Reader
) : KotlinExpectedTokenBuffer,
    KotlinTokenBuffer by KotlinTokenBufferImpl(KotlinLexer(code)) {

    override fun expected(description: String): Nothing =
        throw IllegalArgumentException("Expected $description.")

    override fun expected(vararg tokenTypes: EKotlinTokenType): Nothing {

        if (tokenTypes.size == 1) {
            throw IllegalArgumentException("Expected ${tokenTypes[0].text}.")
        }

        val tokenText = tokenTypes.joinToString(", ") { t -> t.text }
        throw IllegalArgumentException("Expected one of { $tokenText }.")

    }

    override fun expected(description: String, vararg tokenTypes: EKotlinTokenType): Nothing {

        if (tokenTypes.size == 1) {
            throw IllegalArgumentException("Expected $description - ${tokenTypes[0].text}.")
        }

        val tokenText = tokenTypes.joinToString(", ") { t -> t.text }
        throw IllegalArgumentException("Expected $description - one of { $tokenText }.")

    }

    override fun read(tokenType: EKotlinTokenType): KotlinToken {

        if (!hasLookAhead(tokenType)) {
            expected(tokenType)
        }

        return read()

    }

    override fun readOneOf(vararg tokenTypes: EKotlinTokenType): KotlinToken {

        for (tokenType in tokenTypes) {
            if (hasLookAhead(tokenType)) {
                return read()
            }
        }

        expected(*tokenTypes)

    }

    override fun readIdentifier(): KotlinToken {

        if (!hasLookAheadIdentifier()) {
            expected(IDENTIFIER)
        }

        return read()

    }

}

//---------------------------------------------------------------------------------------------------------------------

