//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.vdom.elements.forms

import i.katydid.vdom.builders.KatydidPhrasingContentBuilderImpl
import i.katydid.vdom.elements.KatydidHtmlElementImpl
import o.katydid.vdom.builders.KatydidPhrasingContentBuilder
import o.katydid.vdom.types.EDirection

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual node for a progress element.
 */
internal class KatydidProgress<Msg> : KatydidHtmlElementImpl<Msg> {

    constructor(
        phrasingContent: KatydidPhrasingContentBuilderImpl<Msg>,
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        hidden: Boolean?,
        lang: String?,
        max: Double?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        value: Double?,
        defineContent: KatydidPhrasingContentBuilder<Msg>.() -> Unit
    ) : super(selector, key, accesskey, contenteditable, dir,
              hidden, lang, spellcheck, style, tabindex, title, translate) {

        phrasingContent.contentRestrictions.confirmProgressAllowed()

        val maximum = max ?: 1.0

        require(maximum > 0) { "Progress max must be greater than zero." }
        if (value != null) {
            require(0 <= value) { "Progress value is smaller than zero." }
            require(value <= maximum) { "Progress value is greater than maximum." }
        }

        setNumberAttribute("max", max)
        setNumberAttribute("value", value)

        phrasingContent.withProgressNotAllowed(this).defineContent()
        this.freeze()
    }

    constructor(
        phrasingContent: KatydidPhrasingContentBuilderImpl<Msg>,
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        hidden: Boolean?,
        lang: String?,
        max: Int,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        value: Int?,
        defineContent: KatydidPhrasingContentBuilder<Msg>.() -> Unit
    ) : super(selector, key, accesskey, contenteditable, dir,
              hidden, lang, spellcheck, style, tabindex, title, translate) {

        phrasingContent.contentRestrictions.confirmProgressAllowed()

        require(max > 0) { "Progress max must be greater than zero." }
        if (value != null) {
            require(0 <= value) { "Progress value is smaller than zero." }
            require(value <= max) { "Progress value is greater than maximum." }
        }

        setNumberAttribute("max", max)
        setNumberAttribute("value", value)

        phrasingContent.withProgressNotAllowed(this).defineContent()
        this.freeze()
    }

    ////

    override val nodeName = "PROGRESS"

}

//---------------------------------------------------------------------------------------------------------------------

