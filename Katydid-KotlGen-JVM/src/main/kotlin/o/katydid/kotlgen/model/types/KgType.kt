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

    /** True if the the type is "dynamic". */
    var isDynamic: Boolean

    /** True if the type is a function type. */
    var isFunction: Boolean

    /** True if the type is implicit (no code present). */
    var isInferred: Boolean

    /** True if the type allows null values (ends with "?"). */
    var isNullable: Boolean

    /** True if the type is wrapped with parentheses. */
    var isParenthesized: Boolean

    /**true if the type includes the suspend modifier. */
    var isSuspend: Boolean

    /** The receiver type for a static extension function type. */
    var receiverType: KgType?

    /** The return type for a function type. */
    var returnType: KgType?

    /** The code corresponding to the type (parsed when set). */
    var text: String

    /** Path to referenced type (usually one element; multiple elements if nested type). */
    val typeReferences: List<KgTypeReference>

    ////

    /**
     * Adds type reference [itsName] to a potentially nested list of type references.
     */
    fun addTypeReference( itsName: String, build: KgTypeReference.()->Unit = {} ) : KgTypeReference

    /**
     * Makes a deep copy of this type.
     */
    fun clone() : KgType

}

//---------------------------------------------------------------------------------------------------------------------

