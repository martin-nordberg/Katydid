//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.kotlgen.model.declarations.classes

import o.katydid.kotlgen.model.declarations.classes.KgMemberDeclaring
import o.katydid.kotlgen.model.declarations.properties.KgEnumEntry

//---------------------------------------------------------------------------------------------------------------------

internal interface KgEnumMemberDeclaring
    : KgMemberDeclaring {

    fun `enum entry`(itsName: String, build: KgEnumEntry.() -> Unit): KgEnumEntry

}

//---------------------------------------------------------------------------------------------------------------------
