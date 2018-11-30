//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.kotlgen.model.statements

import o.katydid.kotlgen.model.core.KgCodeElement
import o.katydid.kotlgen.model.core.KgComposite
import o.katydid.kotlgen.model.structure.KgImporting

//---------------------------------------------------------------------------------------------------------------------

interface KgBlock
    : KgCodeElement, KgComposite, KgImporting, KgLocalDeclaring {

    val statements: List<KgStatement>

    ////

}

//---------------------------------------------------------------------------------------------------------------------

