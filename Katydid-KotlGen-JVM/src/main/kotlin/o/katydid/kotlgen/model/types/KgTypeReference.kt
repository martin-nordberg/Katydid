//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.kotlgen.model.types

import o.katydid.kotlgen.model.core.KgCodeElement
import o.katydid.kotlgen.model.core.names.KgNamed

//---------------------------------------------------------------------------------------------------------------------

interface KgTypeReference
    : KgCodeElement, KgNamed {

    val text: String

    // TODO: type parameters

}

//---------------------------------------------------------------------------------------------------------------------



