//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.kotlgen.model.expressions

//---------------------------------------------------------------------------------------------------------------------

interface KgNameExpression
    : KgExpression {

    val name: String

    ////

    operator fun invoke(revise: KgNameExpression.() -> Unit) =
        this.revise()

}

//---------------------------------------------------------------------------------------------------------------------

