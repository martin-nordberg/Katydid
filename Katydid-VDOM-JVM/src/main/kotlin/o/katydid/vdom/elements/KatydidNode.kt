//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.vdom.elements

//---------------------------------------------------------------------------------------------------------------------

/**
 * Topmost base interface for Katydid virtual DOM elements. Corresponds to DOM Node.
 * @param Msg the type of message returned by events from this element when an Elm-like architecture is in use.
 */
interface KatydidNode<Msg> {

    /** The key for this node. If none provided, uses the node name. */
    val key: Any

    /** The name of this node (usually the HTML tag name, otherwise a pseudo tag name like "#text"). */
    val nodeName: String

    /** The first and only child node in this node. (Exception if there is none or more than one.) */
    val soleChildNode: KatydidNode<Msg>

}

//---------------------------------------------------------------------------------------------------------------------
