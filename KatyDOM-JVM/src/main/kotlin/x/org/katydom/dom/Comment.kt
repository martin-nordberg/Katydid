//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package /*jvm*/x.org.katydom.dom

//---------------------------------------------------------------------------------------------------------------------

/**
 * Interface to an HTML comment element (for testing or server-side generation).
 */
interface Comment : Node {

    /** The text insde the comment. */
    var data: String

}

//---------------------------------------------------------------------------------------------------------------------

