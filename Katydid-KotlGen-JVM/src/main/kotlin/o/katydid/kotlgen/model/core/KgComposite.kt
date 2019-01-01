//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.kotlgen.model.core

//---------------------------------------------------------------------------------------------------------------------

/* Interface to a code element that contains other code elements. */
interface KgComposite {

    /** The child elements of this composite element. */
    val childElements: Iterable<KgCodeElement>

}

//---------------------------------------------------------------------------------------------------------------------

