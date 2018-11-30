//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.kotlgen.model.expressions

//---------------------------------------------------------------------------------------------------------------------

interface KgDoWhileLoop
    : KgLoop {

    ////

    operator fun invoke(revise: KgDoWhileLoop.() -> Unit) =
        this.revise()

}

//---------------------------------------------------------------------------------------------------------------------

