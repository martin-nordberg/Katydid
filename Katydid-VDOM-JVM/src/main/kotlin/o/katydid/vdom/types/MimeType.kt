//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.vdom.types

/**
 * Structures a MIME type as a type and subtype with optional parameters.
 *
 * @constructor Constructs a MIME type with given [type] and [subtype] and optional [parameters].
 */
class MimeType(

    /** The main type of the MIME type. */
    val type: String,

    /** The secondary type of the MIME type. */
    val subtype: String,

    /** Optional key/value parameters for the MIME type. */
    val parameters: Map<String, String> = mapOf()

) {

    init {
        require(!type.isEmpty()) { "MIME type cannot be empty." }
        require(!subtype.isEmpty()) { "MIME subtype cannot be empty." }
    }

    ////

    /** Converts this MIME type to its string equivalent. */
    override fun toString(): String {

        var result = "$type/$subtype"

        for ((key, value) in parameters) {
            result += "; $key=$value"
        }

        return result

    }

    ////

    companion object {

        /**
         * Parses a string [mimeType] into a MIME type.
         */
        fun fromString(mimeType: String): MimeType {

            val slashSplit = mimeType.split("/")

            require(slashSplit.size == 2) { "Expected one '/' in MIME type '$mimeType'." }

            val type = slashSplit[0]

            require(!type.isEmpty()) { "Type cannot be empty in MIME type '$mimeType'." }

            val semicolonSplit = slashSplit[1].split(";")

            val subtype = semicolonSplit[0]

            require(!subtype.isEmpty()) { "Subtype cannot be empty in MIME type '$mimeType'." }

            val parameters = mutableMapOf<String, String>()

            for (i in 1 until semicolonSplit.size) {

                val equalsSplit = semicolonSplit[i].split("=")

                require(equalsSplit.size == 2) { "Expected one '=' in MIME type parameter '$mimeType'." }

                parameters[equalsSplit[0]] = equalsSplit[1]

            }

            return MimeType(type, subtype, parameters)

        }

    }

}
