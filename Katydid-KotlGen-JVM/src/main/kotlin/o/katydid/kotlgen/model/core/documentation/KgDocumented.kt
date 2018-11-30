//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

@file:Suppress("RemoveRedundantBackticks")

package o.katydid.kotlgen.model.core.documentation

//---------------------------------------------------------------------------------------------------------------------

/**
 * Indicates that a code element has a documentation attribute.
 */
interface KgDocumented {

    /** The documentation of this element. */
    var documentation: String?

    ////

    /** Sets or expands the documentation of this element. */
    fun `doc`(itsDocumentation: String) {
        if (documentation == null) {
            documentation = itsDocumentation
        }
        else {
            documentation += itsDocumentation
        }
    }

    /** Short hand: sets or extends the documentation of this element. */
    operator fun String.unaryPlus() {
        `doc`(this)
    }

}

//---------------------------------------------------------------------------------------------------------------------


@Suppress("unused")
private fun kgDocumentedExample(element: KgDocumented) {

    element.apply {
        +"This is a really great"
        +"example."
    }

    element.apply {
        `doc`(
            "Here is the documentation."
        )
    }

}
