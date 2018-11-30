//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.kotlgen.model.declarations

import o.katydid.kotlgen.model.core.KgCodeElement
import o.katydid.kotlgen.model.core.KgComposite
import o.katydid.kotlgen.model.core.KgOrigin
import o.katydid.kotlgen.model.core.documentation.KgDocumented
import o.katydid.kotlgen.model.structure.KgImporting

//---------------------------------------------------------------------------------------------------------------------

interface KgDeclaration
    : KgCodeElement, KgDocumented, KgComposite, KgImporting {

    var keywordOrigin: KgOrigin

}

//---------------------------------------------------------------------------------------------------------------------
