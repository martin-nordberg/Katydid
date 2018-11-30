//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.kotlgen.model.annotations

import o.katydid.kotlgen.model.annotations.KgAnnotated
import o.katydid.kotlgen.model.annotations.KgAnnotation

//---------------------------------------------------------------------------------------------------------------------

internal class KgAnnotationsImpl
    : KgAnnotated {

    override val annotations: MutableList<KgAnnotation> = mutableListOf()

    ////

    override fun `@`(itsQualifiedName: String, build: KgAnnotation.() -> Unit): KgAnnotation {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}

//---------------------------------------------------------------------------------------------------------------------
