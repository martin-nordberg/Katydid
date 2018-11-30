//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

@file:Suppress("FunctionName")

package o.katydid.kotlgen.model.annotations

//---------------------------------------------------------------------------------------------------------------------

interface KgAnnotated {

    val annotations: List<KgAnnotation>

    ////

    fun `@`(
        itsQualifiedName: String,
        // TODO: parameters ...
        build: KgAnnotation.() -> Unit
    ): KgAnnotation

}

//---------------------------------------------------------------------------------------------------------------------

