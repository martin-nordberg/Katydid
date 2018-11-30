//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.kotlgen.model.declarations.functions

//---------------------------------------------------------------------------------------------------------------------

interface KgInfixMemberFunction
    : KgAbstractFunction {

    ////

    operator fun invoke(revise: KgInfixMemberFunction.() -> Unit) =
        this.revise()

}

//---------------------------------------------------------------------------------------------------------------------

