//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.kotlgen.model.core

//---------------------------------------------------------------------------------------------------------------------

/** Most abstract interface to any code element. */
interface KgCodeElement {

    /** The origin of this code element from parsing or code generation. */
    var origin: KgOrigin

}

//---------------------------------------------------------------------------------------------------------------------

