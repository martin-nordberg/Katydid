//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.kotlgen.model.types

import o.katydid.kotlgen.model.annotations.KgAnnotated
import o.katydid.kotlgen.model.core.KgCodeElement
import o.katydid.kotlgen.model.core.KgComposite
import o.katydid.kotlgen.model.structure.KgImporting

//---------------------------------------------------------------------------------------------------------------------

interface KgType
    : KgCodeElement, KgAnnotated, KgComposite, KgImporting /*, TODO: KgParameterized*/ {

    var isDynamic: Boolean

    var isFunction: Boolean

    val isInferred: Boolean

    var isNullable: Boolean

    var isParenthesized: Boolean

    var isSuspend: Boolean

    val receiverType: KgType

    val returnType: KgType

    var text: String

    val typeReferences: List<KgTypeReference>

    ////

    fun addTypeReference( itsName: String, build: KgTypeReference.()->Unit ) : KgTypeReference

}

//---------------------------------------------------------------------------------------------------------------------

