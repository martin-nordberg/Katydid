//
// (C) Copyright 2019 Martin E. Nordberg III
// Apache 2.0 License
//

package js.katydid.samples.wipcards.infrastructure

//---------------------------------------------------------------------------------------------------------------------

fun <T> List<T>.addIf(condition: Boolean, getElement: () ->T) : List<T> =
    if ( condition ) this + getElement()
    else this

//---------------------------------------------------------------------------------------------------------------------


