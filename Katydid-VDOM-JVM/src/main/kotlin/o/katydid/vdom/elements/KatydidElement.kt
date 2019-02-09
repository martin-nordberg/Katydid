//
// (C) Copyright 2017-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.vdom.elements

//---------------------------------------------------------------------------------------------------------------------

/**
 * Abstract class representing a Katydid virtual element. Corresponds to DOM Element.
 * @param Msg the type of message returned by events from this element when an Elm-like architecture is in use.
 */
interface KatydidElement<Msg> : KatydidNode<Msg>

//---------------------------------------------------------------------------------------------------------------------
