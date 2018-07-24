//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package /*jvm*/x.org.katydom.dom

//---------------------------------------------------------------------------------------------------------------------

/**
 * Interface to a text node for testing or server-side templating.
 */
interface Text : Node {

    /** The text string content within the node. */
    var data: String

}

//---------------------------------------------------------------------------------------------------------------------

