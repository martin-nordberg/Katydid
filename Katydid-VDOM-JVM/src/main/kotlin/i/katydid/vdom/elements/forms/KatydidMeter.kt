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
 * Virtual node for a meter element.
 */
internal class KatydidMeter<Msg> : KatydidHtmlElementImpl<Msg> {

    constructor(
        phrasingContent: KatydidPhrasingContentBuilderImpl<Msg>,
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        hidden: Boolean?,
        high: Double?,
        lang: String?,
        low: Double?,
        max: Double?,
        min: Double?,
        optimum: Double?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        value: Double,
        defineContent: KatydidPhrasingContentBuilder<Msg>.() -> Unit
    ) : super(selector, key, accesskey, contenteditable, dir,
              hidden, lang, spellcheck, style, tabindex, title, translate) {

        phrasingContent.contentRestrictions.confirmMeterAllowed()

        val maximum = max ?: 1.0
        val minimum = min ?: 0.0

        require(minimum < maximum) { "Meter max must be greater than min." }

        fun checkInRange(value: Double?, attributeName: String) {
            if (value != null) {
                require(minimum <= value) { "Meter $attributeName is smaller than minimum." }
                require(value <= maximum) { "Meter $attributeName is greater than maximum." }
            }
        }

        checkInRange(value, "value")
        checkInRange(low, "low")
        checkInRange(high, "high")
        checkInRange(optimum, "optimum")

        setNumberAttribute("high", high)
        setNumberAttribute("low", low)
        setNumberAttribute("max", max)
        setNumberAttribute("min", min)
        setNumberAttribute("optimum", optimum)
        setNumberAttribute("value", value)

        phrasingContent.withMeterNotAllowed(this).defineContent()
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
        high: Int?,
        lang: String?,
        low: Int?,
        max: Int,
        min: Int?,
        optimum: Int?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        value: Int,
        defineContent: KatydidPhrasingContentBuilder<Msg>.() -> Unit
    ) : super(selector, key, accesskey, contenteditable, dir,
              hidden, lang, spellcheck, style, tabindex, title, translate) {

        phrasingContent.contentRestrictions.confirmMeterAllowed()

        val minimum = min ?: 0

        require(minimum < max) { "Meter max must be greater than min." }

        fun checkInRange(value: Int?, attributeName: String) {
            if (value != null) {
                require(minimum <= value) { "Meter $attributeName is smaller than minimum." }
                require(value <= max) { "Meter $attributeName is greater than maximum." }
            }
        }

        checkInRange(value, "value")
        checkInRange(low, "low")
        checkInRange(high, "high")
        checkInRange(optimum, "optimum")

        setNumberAttribute("high", high)
        setNumberAttribute("low", low)
        setNumberAttribute("max", max)
        setNumberAttribute("min", min)
        setNumberAttribute("optimum", optimum)
        setNumberAttribute("value", value)

        phrasingContent.withMeterNotAllowed(this).defineContent()
        this.freeze()
    }

    ////

    override val nodeName = "METER"

}

//---------------------------------------------------------------------------------------------------------------------

