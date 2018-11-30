//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.kotlgen.model.declarations.objects

import o.katydid.kotlgen.model.core.names.KgNamed
import o.katydid.kotlgen.model.declarations.classes.KgAbstractStructure

//---------------------------------------------------------------------------------------------------------------------

interface KgObject
    : KgAbstractStructure, KgNamed {

    ////

    operator fun invoke(revise: KgObject.() -> Unit) =
        this.revise()

}

//---------------------------------------------------------------------------------------------------------------------
