//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.kotlgen.model.declarations.objects

import o.katydid.kotlgen.model.declarations.classes.KgAbstractStructure

//---------------------------------------------------------------------------------------------------------------------

interface KgCompanionObject
    : KgAbstractStructure {

    val name: String?

    ////

    operator fun invoke(revise: KgCompanionObject.() -> Unit) =
        this.revise()

}

//---------------------------------------------------------------------------------------------------------------------
