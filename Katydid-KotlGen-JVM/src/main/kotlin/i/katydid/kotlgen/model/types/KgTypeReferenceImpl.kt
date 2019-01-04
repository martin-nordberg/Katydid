//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.kotlgen.model.types

import o.katydid.kotlgen.model.core.KgOrigin
import o.katydid.kotlgen.model.core.KgOriginUnspecified
import o.katydid.kotlgen.model.types.KgTypeReference

//---------------------------------------------------------------------------------------------------------------------

internal class KgTypeReferenceImpl(
    override var name: String,
    override var origin: KgOrigin = KgOriginUnspecified
) : KgTypeReference {

    override var nameOrigin
        get() = origin
        set(value) {
            origin = value
        }

    override val text: String
        get() = name

}

//---------------------------------------------------------------------------------------------------------------------
