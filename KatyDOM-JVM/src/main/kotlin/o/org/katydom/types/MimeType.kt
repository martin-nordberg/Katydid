//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.org.katydom.types

class MimeType(
    val type: String,
    val subtype: String,
    val parameters: Map<String, String> = mapOf()
) {

    /** Converts this MIME type to its string equivalent. */
    override fun toString(): String {

        var result = "$type/$subtype"

        for ((key, value) in parameters) {
            result += "; $key=$value"
        }

        return result

    }

    companion object {

        /**
         * Parses a string into a MIME type.
         */
        fun fromString(mimeType: String): MimeType {

            val slashSplit = mimeType.split("/")

            require(slashSplit.size == 2) { "Expected one '/' in MIME type '$mimeType'." }

            val type = slashSplit[0]

            val semicolonSplit = slashSplit[1].split(";")

            val subtype = semicolonSplit[0]

            val parameters = mutableMapOf<String, String>()

            var i = 1

            while (i < semicolonSplit.size) {

                val equalsSplit = semicolonSplit[i].split("=")

                require(equalsSplit.size == 2) { "Expected one '=' in MIME type parameter '$mimeType'." }

                parameters[equalsSplit[0]] = equalsSplit[1]

                i += 1

            }

            return MimeType(type, subtype, parameters)

        }

    }

}
