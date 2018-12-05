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
    : KgCodeElement, KgAnnotated, KgComposite, KgImporting {

    var isSuspend: Boolean

    var text: String

    var typeRef: KgTypeReference

    ////


}

//---------------------------------------------------------------------------------------------------------------------

