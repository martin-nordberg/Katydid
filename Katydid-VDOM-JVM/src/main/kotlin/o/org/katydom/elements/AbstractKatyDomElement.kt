//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.org.katydom.elements

//---------------------------------------------------------------------------------------------------------------------

/**
 * Abstract class representing a KatyDom virtual element. Corresponds to DOM Element.
 * @param Msg the type of message returned by events from this element when an Elm-like architecture is in use.
 */
interface AbstractKatyDomElement<Msg> : AbstractKatyDomNode<Msg>

//---------------------------------------------------------------------------------------------------------------------
