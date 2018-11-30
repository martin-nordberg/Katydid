//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.kotlgen.model.declarations.classes

import o.katydid.kotlgen.model.annotations.KgAnnotated
import o.katydid.kotlgen.model.core.modifiers.KgModified
import o.katydid.kotlgen.model.declarations.KgDeclaration

//---------------------------------------------------------------------------------------------------------------------

interface KgAbstractStructure
    : KgDeclaration, KgAnnotated, KgModified, KgMemberDeclaring {

    ////

}

//---------------------------------------------------------------------------------------------------------------------
