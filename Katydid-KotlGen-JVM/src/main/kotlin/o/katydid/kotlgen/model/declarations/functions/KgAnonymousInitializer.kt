//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.kotlgen.model.declarations.functions

import o.katydid.kotlgen.model.declarations.KgDeclaration

//---------------------------------------------------------------------------------------------------------------------

interface KgAnonymousInitializer
    : KgDeclaration {

    operator fun invoke(revise: KgAnonymousInitializer.() -> Unit) =
        this.revise()

}

//---------------------------------------------------------------------------------------------------------------------

