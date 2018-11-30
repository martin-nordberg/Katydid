//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.kotlgen.model.declarations

import o.katydid.kotlgen.model.annotations.KgAnnotated
import o.katydid.kotlgen.model.core.modifiers.KgModified
import o.katydid.kotlgen.model.core.names.KgNamed
import o.katydid.kotlgen.model.types.KgTyped
import o.katydid.kotlgen.model.types.generics.KgGeneric

//---------------------------------------------------------------------------------------------------------------------

interface KgTypeAlias
    : KgDeclaration, KgAnnotated, KgModified, KgNamed, KgTyped, KgGeneric {

    ////

    operator fun invoke(revise: KgTypeAlias.() -> Unit) =
        this.revise()

}

//---------------------------------------------------------------------------------------------------------------------

