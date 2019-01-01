//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.kotlgen.model.core.names

import o.katydid.kotlgen.model.core.KgOrigin
import o.katydid.kotlgen.model.core.KgOriginGenerated

//---------------------------------------------------------------------------------------------------------------------

/** Interface indicating that a code element has a name. */
interface KgNamed {

    /** The name of this element. */
    var name: String

    /** The origin for the name of this element. */
    var nameOrigin: KgOrigin

    ////

}

//---------------------------------------------------------------------------------------------------------------------

@Suppress("unused")
private fun kgNamedExample(element: KgNamed) {

    element.apply {
        name = "MyName"
        nameOrigin = KgOriginGenerated
    }

}

//---------------------------------------------------------------------------------------------------------------------

