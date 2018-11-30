//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.kotlgen.model.statements

import o.katydid.kotlgen.model.annotations.KgAnnotated
import o.katydid.kotlgen.model.core.KgCodeElement
import o.katydid.kotlgen.model.core.KgComposite
import o.katydid.kotlgen.model.core.documentation.KgDocumented
import o.katydid.kotlgen.model.structure.KgImporting

//---------------------------------------------------------------------------------------------------------------------

interface KgStatement
    : KgCodeElement, KgDocumented, KgAnnotated, KgComposite, KgImporting {

    ////

}

//---------------------------------------------------------------------------------------------------------------------

