//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.kotlgen.model.declarations.properties

import i.katydid.kotlgen.model.annotations.KgAnnotationsImpl
import i.katydid.kotlgen.model.core.modifiers.KgModifiersImpl
import i.katydid.kotlgen.model.structure.KgImportsImpl
import i.katydid.kotlgen.model.types.KgTypeImpl
import o.katydid.kotlgen.model.annotations.KgAnnotated
import o.katydid.kotlgen.model.core.KgCodeElement
import o.katydid.kotlgen.model.core.KgOrigin
import o.katydid.kotlgen.model.core.KgOriginUnspecified
import o.katydid.kotlgen.model.core.modifiers.KgModified
import o.katydid.kotlgen.model.declarations.properties.KgReadOnlyProperty
import o.katydid.kotlgen.model.structure.KgImporting
import o.katydid.kotlgen.model.types.KgType

//---------------------------------------------------------------------------------------------------------------------

internal class KgReadOnlyPropertyImpl(
    override var name: String,
    override var origin: KgOrigin = KgOriginUnspecified
) : KgReadOnlyProperty,
    KgAnnotated by KgAnnotationsImpl(),
    KgModified by KgModifiersImpl(),
    KgImporting by KgImportsImpl() {

    override var documentation: String? = null

    override var keywordOrigin: KgOrigin = KgOriginUnspecified

    override var nameOrigin: KgOrigin = KgOriginUnspecified

    override val type: KgType = KgTypeImpl()

    ////

    override val childElements: Iterable<KgCodeElement>
        get() {
            val result = mutableListOf<KgCodeElement>()
            result.addAll(annotations)
            result.addAll(imports)
            result.add(type)
            // TODO: other pieces when defined
            return result
        }


}

//---------------------------------------------------------------------------------------------------------------------
