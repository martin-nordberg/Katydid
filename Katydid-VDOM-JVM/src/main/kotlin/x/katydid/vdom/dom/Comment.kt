//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package /*jvm*/x.katydid.vdom.dom

//---------------------------------------------------------------------------------------------------------------------

/**
 * Interface to an HTML comment element (for testing or server-side generation).
 */
interface Comment : Node {

    /** The text insde the comment. */
    var data: String

}

//---------------------------------------------------------------------------------------------------------------------

