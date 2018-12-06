//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.kotlgen.model.types

import i.katydid.kotlgen.model.annotations.KgAnnotationsImpl
import i.katydid.kotlgen.model.structure.KgImportsImpl
import o.katydid.kotlgen.model.annotations.KgAnnotated
import o.katydid.kotlgen.model.core.KgCodeElement
import o.katydid.kotlgen.model.core.KgOrigin
import o.katydid.kotlgen.model.core.KgOriginUnspecified
import o.katydid.kotlgen.model.structure.KgImporting
import o.katydid.kotlgen.model.types.KgType
import o.katydid.kotlgen.model.types.KgTypeReference

//---------------------------------------------------------------------------------------------------------------------

internal class KgTypeImpl
    : KgType,
      KgAnnotated by KgAnnotationsImpl(),
      KgImporting by KgImportsImpl() {

    override val childElements: Iterable<KgCodeElement>
        get() {
            val result = mutableListOf<KgCodeElement>()
            result.addAll(annotations)
            result.addAll(imports)
            result.add(typeRef)
            return result
        }

    override var isSuspend: Boolean = false

    override var origin: KgOrigin = KgOriginUnspecified

    override var text: String
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
        set(value) {
            TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
        }

    override var typeRef: KgTypeReference
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
        set(value) {}

}

//---------------------------------------------------------------------------------------------------------------------
