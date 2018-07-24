//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.vdom.builders.media

//---------------------------------------------------------------------------------------------------------------------

/**
 * Set of restrictions on media content.
 */
internal class KatyDomMediaContentRestrictions(
    private var sourceAllowed: Boolean = true
) {

    private var trackAllowed = true

    ////

    /**
     * Confirms that a `<source>` element is allowed.
     * @throws IllegalStateException if `<source>` is not allowed.
     */
    fun confirmSourceAllowed() {
        check(sourceAllowed) { "Element type <source> not allowed here" }
    }

    /**
     * Confirms that a `<track>` element is allowed. Also disallows a `<source>` after this call.
     * @throws IllegalStateException if `<track>` is not allowed.
     */
    fun confirmTrackAllowed() {
        check(trackAllowed) { "Element type <track> not allowed here" }
        sourceAllowed = false
    }

}

//---------------------------------------------------------------------------------------------------------------------

