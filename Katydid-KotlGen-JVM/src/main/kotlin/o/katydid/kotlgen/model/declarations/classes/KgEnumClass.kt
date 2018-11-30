//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

@file:Suppress("FunctionName")

package o.katydid.kotlgen.model.declarations.classes

import o.katydid.kotlgen.model.core.names.KgNamed
import o.katydid.kotlgen.model.declarations.properties.KgEnumEntry

//---------------------------------------------------------------------------------------------------------------------

interface KgEnumClass
    : KgAbstractStructure, KgNamed {

    fun `enum entry`(itsName: String, build: KgEnumEntry.() -> Unit = {}): KgEnumEntry

    operator fun invoke(revise: KgEnumClass.() -> Unit) =
        this.revise()

}

//---------------------------------------------------------------------------------------------------------------------
