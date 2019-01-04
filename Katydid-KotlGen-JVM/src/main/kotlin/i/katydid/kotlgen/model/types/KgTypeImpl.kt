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

    private var amDynamic = false

    private var amFunction = false

    private val myTypeReferences = mutableListOf<KgTypeReference>()

    ////

    override val childElements: Iterable<KgCodeElement>
        get() {
            val result = mutableListOf<KgCodeElement>()
            result.addAll(annotations)
            result.addAll(imports)
            return result
        }

    override var isDynamic: Boolean
        get() = amDynamic
        set(value) {
            isInferred = value
            amDynamic = value
        }

    override var isFunction: Boolean
        get() = amFunction
        set(value) {
            amFunction = value
            if ( value ) {
                amDynamic = false
                myTypeReferences.clear()
                receiverType = KgTypeImpl()
                returnType = KgTypeImpl()
            }
            else {
                receiverType = null
                returnType = null
            }
        }

    override var isInferred: Boolean
        get() = !amDynamic && !amFunction && myTypeReferences.isEmpty()
        set(value) {
            if ( value ) {
                amDynamic = false
                amFunction = false
                myTypeReferences.clear()
                isNullable = false
                isParenthesized = false
                isSuspend = false
                receiverType = null
                returnType = null
            }
        }

    override var isNullable: Boolean = false

    override var isParenthesized: Boolean = false

    override var isSuspend: Boolean = false

    override var origin: KgOrigin = KgOriginUnspecified

    override var receiverType : KgType? = null

    override var returnType : KgType? = null

    override var text: String
        get() {

            if ( amDynamic ) {
                return "dynamic"
            }

            if ( amFunction ) {
                TODO( "not yet implemented" )
            }

            var result = myTypeReferences.map{ it.text }.joinToString(".")

            if ( isNullable ) {
                result += "?"
            }

            if ( isParenthesized ) {
                result = "(" + result + ")"
            }

            return result

        }

        set(value) {
            TODO("not implemented: parse the text")
        }

    override val typeReferences: List<KgTypeReference>
        get() = myTypeReferences

    ////

    override fun addTypeReference(itsName: String, build: KgTypeReference.() -> Unit): KgTypeReference {

        val result = KgTypeReferenceImpl(itsName)

        myTypeReferences.add(result)

        result.build()

        return result

    }

    override fun toString(): String {
        return text
    }


}

//---------------------------------------------------------------------------------------------------------------------
