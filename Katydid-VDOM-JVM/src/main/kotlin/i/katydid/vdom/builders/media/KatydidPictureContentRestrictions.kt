//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.vdom.builders.media

//---------------------------------------------------------------------------------------------------------------------

/**
 * Set of restrictions on media content.
 */
internal class KatydidPictureContentRestrictions(
    itsSourceAllowed: Boolean = true
) {

    private var imgAllowed = true

    private var sourceAllowed = itsSourceAllowed

    private var sourceElementSeen = false

    ////

    /**
     * Confirms that an `<img>` element is allowed. Also disallows a second `<img>` or any more `<source>`
     * elements after this call.
     * @throws IllegalStateException if `<img>` is not allowed.
     */
    fun confirmImgAllowedThenDisallow() {
        check(imgAllowed) { "Element type <img> not allowed here" }
        sourceAllowed = false
        imgAllowed = false
    }

    /**
     * Confirms that a `<source>` element is allowed.
     * @throws IllegalStateException if `<source>` is not allowed.
     */
    fun confirmSourceAllowed() {
        check(sourceAllowed) { "Element type <source> not allowed here" }
        sourceElementSeen = true
    }

    /**
     * Confirms that the img element can do without a src attribute.
     */
    fun confirmSourceElementSeen() {
        check(
            sourceElementSeen) { "Img element must have src attribute or parent picture element must have <source> elements." }
    }

}

//---------------------------------------------------------------------------------------------------------------------

