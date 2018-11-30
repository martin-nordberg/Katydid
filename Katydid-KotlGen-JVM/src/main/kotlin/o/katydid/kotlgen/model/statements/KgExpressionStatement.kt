//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.kotlgen.model.statements

import o.katydid.kotlgen.model.expressions.KgExpression

//---------------------------------------------------------------------------------------------------------------------

interface KgExpressionStatement
    : KgStatement {

    val expression: KgExpression

    ////

}

//---------------------------------------------------------------------------------------------------------------------

