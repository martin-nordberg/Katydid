//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.kotlgen.model.declarations.properties

//---------------------------------------------------------------------------------------------------------------------

interface KgReadOnlyProperty
    : KgAbstractProperty {

    ////

    operator fun invoke(revise: KgReadOnlyProperty.() -> Unit) =
        this.revise()

}

//---------------------------------------------------------------------------------------------------------------------

