//
// (C) Copyright 2017-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.vdom.builders

import i.katydid.vdom.builders.miscellaneous.KatydidOptGroupContentBuilderImpl
import i.katydid.vdom.builders.miscellaneous.KatydidSelectContentBuilderImpl
import i.katydid.vdom.elements.KatydidHtmlElementImpl
import i.katydid.vdom.elements.edits.KatydidDel
import i.katydid.vdom.elements.edits.KatydidIns
import i.katydid.vdom.elements.embedded.KatydidArea
import i.katydid.vdom.elements.embedded.KatydidMap
import i.katydid.vdom.elements.forms.*
import i.katydid.vdom.elements.scripting.KatydidCanvas
import i.katydid.vdom.elements.text.*
import o.katydid.vdom.builders.KatydidAttributesContentBuilder
import o.katydid.vdom.builders.KatydidPhrasingContentBuilder
import o.katydid.vdom.builders.miscellaneous.KatydidOptGroupContentBuilder
import o.katydid.vdom.builders.miscellaneous.KatydidSelectContentBuilder
import o.katydid.vdom.builders.miscellaneous.KatydidTextContentBuilder
import o.katydid.vdom.types.*
import x.katydid.vdom.types.KatyDateTime
import x.katydid.vdom.types.KatyTime

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual DOM builder for the case of HTML "phrasing content".
 *
 * @constructor Constructs a new phrasing content builder for the given [element].
 * @param itsElement the element whose content is being built.
 * @param itsContentRestrictions restrictions on content enforced at run time.
 * @param itsDispatchMessages dispatcher of event handling results for when we want event handling to be reactive or Elm-like.
 */
@Suppress("unused")
internal open class KatydidPhrasingContentBuilderImpl<Msg>(
    itsElement: KatydidHtmlElementImpl<Msg>,
    itsContentRestrictions: KatydidContentRestrictions,
    itsDispatchMessages: (messages: Iterable<Msg>) -> Unit
) : KatydidEmbeddedContentBuilderImpl<Msg>(itsElement, itsContentRestrictions, itsDispatchMessages),
    KatydidPhrasingContentBuilder<Msg> {

    override fun a(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        download: String?,
        hidden: Boolean?,
        href: String?,
        hreflang: String?,
        lang: String?,
        rel: Iterable<EAnchorHtmlLinkType>?,
        rev: Iterable<EAnchorHtmlLinkType>?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        target: String?,
        title: String?,
        translate: Boolean?,
        type: String?,
        contentType: PhrasingContent,
        defineContent: KatydidPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidA(this, selector, key, accesskey, contenteditable, dir, download, hidden, href, hreflang, lang,
                rel, rev, spellcheck, style, tabindex, target, title, translate, type, defineContent)
        )
    }

    override fun abbr(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        hidden: Boolean?,
        lang: String?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        defineContent: KatydidPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidAbbr(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
                tabindex, title, translate, defineContent)
        )
    }

    override fun area(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        alt: String?,
        contenteditable: Boolean?,
        coords: String?,
        dir: EDirection?,
        download: String?,
        hidden: Boolean?,
        href: String?,
        hreflang: String?,
        lang: String?,
        referrerpolicy: EReferrerPolicy?,
        rel: EAnchorHtmlLinkType?,
        spellcheck: Boolean?,
        shape: EAreaShape?,
        style: String?,
        tabindex: Int?,
        target: String?,
        title: String?,
        translate: Boolean?,
        type: String?,
        defineAttributes: KatydidAttributesContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidArea(this, selector, key, accesskey, alt, contenteditable, coords, dir, download,
                hidden, href, hreflang, lang, referrerpolicy, rel, spellcheck, shape, style, tabindex, target,
                title, translate, type, defineAttributes)
        )
    }

    override fun b(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        hidden: Boolean?,
        lang: String?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        defineContent: KatydidPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidB(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
                tabindex, title, translate, defineContent)
        )
    }

    override fun bdi(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection,
        hidden: Boolean?,
        lang: String?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        defineContent: KatydidPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidBdi(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
                tabindex, title, translate, defineContent)
        )
    }

    override fun bdo(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection,
        hidden: Boolean?,
        lang: String?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        defineContent: KatydidPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidBdo(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
                tabindex, title, translate, defineContent)
        )
    }

    override fun br(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        hidden: Boolean?,
        lang: String?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        defineAttributes: KatydidAttributesContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidBr(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
                tabindex, title, translate, defineAttributes)

        )
    }

    override fun button(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        autofocus: Boolean?,
        contenteditable: Boolean?,
        dir: EDirection?,
        disabled: Boolean?,
        form: String?,
        formaction: String?,
        formenctype: EFormEncodingType?,
        formmethod: EFormSubmissionMethod?,
        formnovalidate: Boolean?,
        formtarget: String?,
        hidden: Boolean?,
        lang: String?,
        name: String?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        type: EButtonType?,
        value: String?,
        defineContent: KatydidPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidButton(this, selector, key, accesskey, autofocus, contenteditable, dir, disabled, form, formaction,
                formenctype, formmethod, formnovalidate, formtarget, hidden, lang,
                name, spellcheck, style, tabindex, title, translate, type, value, defineContent)
        )
    }

    override fun canvas(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        height: Int?,
        hidden: Boolean?,
        lang: String?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        width: Int?,
        contentType: PhrasingContent,
        defineContent: KatydidPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidCanvas(this, selector, key, accesskey, contenteditable, dir, height,
                hidden, lang, spellcheck, style, tabindex, title, translate, width, defineContent)
        )
    }

    override fun cite(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        hidden: Boolean?,
        lang: String?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        defineContent: KatydidPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidCite(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
                tabindex, title, translate, defineContent)
        )
    }

    override fun code(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        hidden: Boolean?,
        lang: String?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        defineContent: KatydidPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidCode(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
                tabindex, title, translate, defineContent)
        )
    }

    override fun data(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        hidden: Boolean?,
        lang: String?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        value: String,
        defineContent: KatydidPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidData(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
                tabindex, title, translate, value, defineContent)
        )
    }

    override fun datalist(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        hidden: Boolean?,
        lang: String?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        defineContent: KatydidOptGroupContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidDataList(this, selector, key, accesskey, contenteditable, dir,
                hidden, lang, spellcheck, style,
                tabindex, title, translate, defineContent)
        )
    }

    override fun datalist(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        hidden: Boolean?,
        lang: String?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        contentType: PhrasingContent,
        defineContent: KatydidPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidDataList(this, selector, key, accesskey, contenteditable, dir,
                hidden, lang, spellcheck, style,
                tabindex, title, translate, contentType, defineContent)
        )
    }

    override fun del(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        cite: String?,
        contenteditable: Boolean?,
        datetime: KatyDateTime?,
        dir: EDirection?,
        hidden: Boolean?,
        lang: String?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        defineContent: KatydidPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidDel(this, selector, key, accesskey, cite, contenteditable, datetime, dir, hidden,
                lang, spellcheck, style, tabindex, title, translate, defineContent)
        )
    }

    override fun dfn(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        hidden: Boolean?,
        lang: String?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        defineContent: KatydidPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidDfn(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
                tabindex, title, translate, defineContent)
        )
    }

    override fun em(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        hidden: Boolean?,
        lang: String?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        defineContent: KatydidPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidEm(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
                tabindex, title, translate, defineContent)
        )
    }

    override fun i(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        hidden: Boolean?,
        lang: String?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        defineContent: KatydidPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidI(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
                tabindex, title, translate, defineContent)
        )
    }

    override fun inputButton(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        disabled: Boolean?,
        form: String?,
        hidden: Boolean?,
        lang: String?,
        name: String?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        value: String?,
        defineAttributes: KatydidAttributesContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidInputButton(this, selector, key, accesskey, contenteditable, dir, disabled, form, hidden, lang,
                name, spellcheck, style, tabindex, title, translate, value, defineAttributes)
        )
    }

    override fun inputCheckbox(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        autofocus: Boolean?,
        checked: Boolean?,
        contenteditable: Boolean?,
        dir: EDirection?,
        disabled: Boolean?,
        form: String?,
        hidden: Boolean?,
        lang: String?,
        name: String?,
        required: Boolean?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        value: String?,
        defineAttributes: KatydidAttributesContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidInputCheckbox(this, selector, key, accesskey, autofocus, checked, contenteditable, dir,
                disabled, form, hidden, lang, name, required,
                spellcheck, style, tabindex, title, translate,
                value, defineAttributes)
        )
    }

    override fun inputColor(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        autocomplete: String?,
        autofocus: Boolean?,
        contenteditable: Boolean?,
        dir: EDirection?,
        disabled: Boolean?,
        form: String?,
        hidden: Boolean?,
        lang: String?,
        list: String?,
        name: String?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        value: String?,
        defineAttributes: KatydidAttributesContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidInputColor(this, selector, key, accesskey, autocomplete, autofocus, contenteditable, dir,
                disabled, form, hidden, lang, list, name,
                spellcheck, style, tabindex, title, translate,
                value, defineAttributes)
        )
    }

    override fun inputDate(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        autocomplete: String?,
        autofocus: Boolean?,
        contenteditable: Boolean?,
        dir: EDirection?,
        disabled: Boolean?,
        form: String?,
        hidden: Boolean?,
        lang: String?,
        list: String?,
        max: String?,
        min: String?,
        name: String?,
        readonly: Boolean?,
        required: Boolean?,
        spellcheck: Boolean?,
        step: String?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        value: String?,
        defineAttributes: KatydidAttributesContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidInputDate(this, selector, key, accesskey, autocomplete, autofocus, contenteditable, dir,
                disabled, form, hidden, lang, list, max, min, name,
                readonly, required, spellcheck, step, style, tabindex, title, translate,
                value, defineAttributes)
        )
    }

    override fun inputDateTimeLocal(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        autocomplete: String?,
        autofocus: Boolean?,
        contenteditable: Boolean?,
        dir: EDirection?,
        disabled: Boolean?,
        form: String?,
        hidden: Boolean?,
        lang: String?,
        list: String?,
        max: String?,
        min: String?,
        name: String?,
        readonly: Boolean?,
        required: Boolean?,
        spellcheck: Boolean?,
        step: String?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        value: String?,
        defineAttributes: KatydidAttributesContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidInputDateTimeLocal(this, selector, key, accesskey, autocomplete, autofocus, contenteditable, dir,
                disabled, form, hidden, lang, list, max, min, name,
                readonly, required, spellcheck, step, style, tabindex, title, translate,
                value, defineAttributes)
        )
    }

    override fun inputEmail(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        autocomplete: String?,
        autofocus: Boolean?,
        contenteditable: Boolean?,
        dir: EDirection?,
        disabled: Boolean?,
        form: String?,
        hidden: Boolean?,
        lang: String?,
        list: String?,
        maxlength: Int?,
        minlength: Int?,
        multiple: Boolean?,
        name: String?,
        pattern: String?,
        placeholder: String?,
        readonly: Boolean?,
        required: Boolean?,
        size: Int?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        value: String?,
        defineAttributes: KatydidAttributesContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidInputEmail(this, selector, key, accesskey, autocomplete, autofocus, contenteditable, dir,
                disabled, form, hidden, lang, list, maxlength, minlength, multiple, name, pattern,
                placeholder, readonly, required, size, spellcheck, style, tabindex, title, translate,
                value, defineAttributes)
        )
    }

    override fun inputFile(
        selector: String?,
        key: Any?,
        accept: String?,
        accesskey: Char?,
        autofocus: Boolean?,
        contenteditable: Boolean?,
        dir: EDirection?,
        disabled: Boolean?,
        form: String?,
        hidden: Boolean?,
        lang: String?,
        multiple: Boolean?,
        name: String?,
        required: Boolean?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        value: String?,
        defineAttributes: KatydidAttributesContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidInputFile(this, selector, key, accept, accesskey, autofocus, contenteditable, dir, disabled,
                form, hidden, lang, multiple, name, required, spellcheck, style, tabindex, title,
                translate,
                value, defineAttributes)
        )
    }

    override fun inputHidden(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        disabled: Boolean?,
        form: String?,
        hidden: Boolean?,
        lang: String?,
        name: String?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        value: String?,
        defineAttributes: KatydidAttributesContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidInputHidden(this, selector, key, accesskey, contenteditable, dir, disabled, form, hidden, lang,
                name, spellcheck, style, tabindex, title, translate, value, defineAttributes)
        )
    }

    override fun inputImageButton(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        alt: String?,
        contenteditable: Boolean?,
        dir: EDirection?,
        disabled: Boolean?,
        form: String?,
        formaction: String?,
        formenctype: EFormEncodingType?,
        formmethod: EFormSubmissionMethod?,
        formnovalidate: Boolean?,
        formtarget: String?,
        height: Int?,
        hidden: Boolean?,
        lang: String?,
        name: String?,
        spellcheck: Boolean?,
        src: String,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        width: Int?,
        defineAttributes: KatydidAttributesContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidInputImageButton(this, selector, key, accesskey, alt, contenteditable, dir, disabled, form,
                formaction,
                formenctype, formmethod, formnovalidate, formtarget, height, hidden, lang,
                name, spellcheck, src, style, tabindex, title, translate, width,
                defineAttributes)
        )
    }

    override fun inputMonth(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        autocomplete: String?,
        autofocus: Boolean?,
        contenteditable: Boolean?,
        dir: EDirection?,
        disabled: Boolean?,
        form: String?,
        hidden: Boolean?,
        lang: String?,
        list: String?,
        max: String?,
        min: String?,
        name: String?,
        readonly: Boolean?,
        required: Boolean?,
        spellcheck: Boolean?,
        step: String?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        value: String?,
        defineAttributes: KatydidAttributesContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidInputMonth(this, selector, key, accesskey, autocomplete, autofocus, contenteditable, dir,
                disabled, form, hidden, lang, list, max, min, name,
                readonly, required, spellcheck, step, style, tabindex, title, translate,
                value, defineAttributes)
        )
    }

    override fun inputNumber(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        autocomplete: String?,
        autofocus: Boolean?,
        contenteditable: Boolean?,
        dir: EDirection?,
        disabled: Boolean?,
        form: String?,
        hidden: Boolean?,
        lang: String?,
        list: String?,
        max: Double?,
        min: Double?,
        name: String?,
        placeholder: String?,
        readonly: Boolean?,
        required: Boolean?,
        spellcheck: Boolean?,
        step: Double?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        value: Double?,
        defineAttributes: KatydidAttributesContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidInputNumber(this, selector, key, accesskey, autocomplete, autofocus, contenteditable, dir,
                disabled, form, hidden, lang, list, max, min, name, placeholder,
                readonly, required, spellcheck, step, style, tabindex, title, translate,
                value, defineAttributes)
        )

    }

    override fun inputNumber(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        autocomplete: String?,
        autofocus: Boolean?,
        contenteditable: Boolean?,
        dir: EDirection?,
        disabled: Boolean?,
        form: String?,
        hidden: Boolean?,
        lang: String?,
        list: String?,
        max: Int?,
        min: Int?,
        name: String?,
        placeholder: String?,
        readonly: Boolean?,
        required: Boolean?,
        spellcheck: Boolean?,
        step: Int?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        value: Int?,
        defineAttributes: KatydidAttributesContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidInputNumber(this, selector, key, accesskey, autocomplete, autofocus, contenteditable, dir,
                disabled, form, hidden, lang, list, max, min, name, placeholder,
                readonly, required, spellcheck, step, style, tabindex, title, translate,
                value, defineAttributes)
        )

    }

    override fun inputPassword(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        autocomplete: String?,
        autofocus: Boolean?,
        contenteditable: Boolean?,
        dir: EDirection?,
        disabled: Boolean?,
        form: String?,
        hidden: Boolean?,
        lang: String?,
        maxlength: Int?,
        minlength: Int?,
        name: String?,
        pattern: String?,
        placeholder: String?,
        readonly: Boolean?,
        required: Boolean?,
        size: Int?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        value: String?,
        defineAttributes: KatydidAttributesContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidInputPassword(this, selector, key, accesskey, autocomplete, autofocus, contenteditable, dir,
                disabled, form, hidden, lang, maxlength, minlength, name, pattern,
                placeholder, readonly, required, size, spellcheck, style, tabindex, title, translate,
                value, defineAttributes)
        )
    }

    override fun inputRadioButton(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        autofocus: Boolean?,
        checked: Boolean?,
        contenteditable: Boolean?,
        dir: EDirection?,
        disabled: Boolean?,
        form: String?,
        hidden: Boolean?,
        lang: String?,
        name: String?,
        required: Boolean?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        value: String?,
        defineAttributes: KatydidAttributesContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidInputRadioButton(this, selector, key, accesskey, autofocus, checked, contenteditable, dir,
                disabled, form, hidden, lang, name, required,
                spellcheck, style, tabindex, title, translate,
                value, defineAttributes)
        )
    }

    override fun <T : Number> inputRange(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        autocomplete: String?,
        autofocus: Boolean?,
        contenteditable: Boolean?,
        dir: EDirection?,
        disabled: Boolean?,
        form: String?,
        hidden: Boolean?,
        lang: String?,
        list: String?,
        max: T?,
        min: T?,
        name: String?,
        spellcheck: Boolean?,
        step: String?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        value: T?,
        defineAttributes: KatydidAttributesContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidInputRange(this, selector, key, accesskey, autocomplete, autofocus, contenteditable, dir,
                disabled, form, hidden, lang, list, max, min, name,
                spellcheck, step, style, tabindex, title, translate,
                value, defineAttributes)
        )
    }

    override fun inputResetButton(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        disabled: Boolean?,
        form: String?,
        hidden: Boolean?,
        lang: String?,
        name: String?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        value: String?,
        defineAttributes: KatydidAttributesContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidInputResetButton(this, selector, key, accesskey, contenteditable, dir, disabled, form, hidden, lang,
                name, spellcheck, style, tabindex, title, translate, value, defineAttributes)
        )
    }

    override fun inputSearch(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        autocomplete: String?,
        autofocus: Boolean?,
        contenteditable: Boolean?,
        dir: EDirection?,
        dirname: String?,
        disabled: Boolean?,
        form: String?,
        hidden: Boolean?,
        lang: String?,
        list: String?,
        maxlength: Int?,
        minlength: Int?,
        name: String?,
        pattern: String?,
        placeholder: String?,
        readonly: Boolean?,
        required: Boolean?,
        size: Int?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        value: String?,
        defineAttributes: KatydidAttributesContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidInputSearch(this, selector, key, accesskey, autocomplete, autofocus, contenteditable, dir, dirname,
                disabled, form, hidden, lang, list, maxlength, minlength, name, pattern,
                placeholder, readonly, required, size, spellcheck, style, tabindex, title, translate,
                value, defineAttributes)
        )
    }

    override fun inputSubmitButton(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        disabled: Boolean?,
        form: String?,
        formaction: String?,
        formenctype: EFormEncodingType?,
        formmethod: EFormSubmissionMethod?,
        formnovalidate: Boolean?,
        formtarget: String?,
        hidden: Boolean?,
        lang: String?,
        name: String?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        value: String?,
        defineAttributes: KatydidAttributesContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidInputSubmitButton(this, selector, key, accesskey, contenteditable, dir, disabled, form, formaction,
                formenctype, formmethod, formnovalidate, formtarget, hidden, lang,
                name, spellcheck, style, tabindex, title, translate, value, defineAttributes)
        )
    }

    override fun inputTelephone(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        autocomplete: String?,
        autofocus: Boolean?,
        contenteditable: Boolean?,
        dir: EDirection?,
        disabled: Boolean?,
        form: String?,
        hidden: Boolean?,
        lang: String?,
        list: String?,
        maxlength: Int?,
        minlength: Int?,
        name: String?,
        pattern: String?,
        placeholder: String?,
        readonly: Boolean?,
        required: Boolean?,
        size: Int?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        value: String?,
        defineAttributes: KatydidAttributesContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidInputTelephone(this, selector, key, accesskey, autocomplete, autofocus, contenteditable, dir,
                disabled, form, hidden, lang, list, maxlength, minlength, name, pattern,
                placeholder, readonly, required, size, spellcheck, style, tabindex, title, translate,
                value, defineAttributes)
        )
    }

    override fun inputText(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        autocomplete: String?,
        autofocus: Boolean?,
        contenteditable: Boolean?,
        dir: EDirection?,
        dirname: String?,
        disabled: Boolean?,
        form: String?,
        hidden: Boolean?,
        lang: String?,
        list: String?,
        maxlength: Int?,
        minlength: Int?,
        name: String?,
        pattern: String?,
        placeholder: String?,
        readonly: Boolean?,
        required: Boolean?,
        size: Int?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        value: String?,
        defineAttributes: KatydidAttributesContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidInputText(this, selector, key, accesskey, autocomplete, autofocus, contenteditable, dir, dirname,
                disabled, form, hidden, lang, list, maxlength, minlength, name, pattern,
                placeholder, readonly, required, size, spellcheck, style, tabindex, title, translate,
                value, defineAttributes)
        )
    }

    override fun inputTime(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        autocomplete: String?,
        autofocus: Boolean?,
        contenteditable: Boolean?,
        dir: EDirection?,
        disabled: Boolean?,
        form: String?,
        hidden: Boolean?,
        lang: String?,
        list: String?,
        max: String?,
        min: String?,
        name: String?,
        readonly: Boolean?,
        required: Boolean?,
        spellcheck: Boolean?,
        step: String?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        value: KatyTime?,
        defineAttributes: KatydidAttributesContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidInputTime(this, selector, key, accesskey, autocomplete, autofocus, contenteditable, dir,
                disabled, form, hidden, lang, list, max, min, name,
                readonly, required, spellcheck, step, style, tabindex, title, translate,
                value, defineAttributes)
        )
    }

    override fun inputUrl(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        autocomplete: String?,
        autofocus: Boolean?,
        contenteditable: Boolean?,
        dir: EDirection?,
        disabled: Boolean?,
        form: String?,
        hidden: Boolean?,
        lang: String?,
        list: String?,
        maxlength: Int?,
        minlength: Int?,
        name: String?,
        pattern: String?,
        placeholder: String?,
        readonly: Boolean?,
        required: Boolean?,
        size: Int?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        value: String?,
        defineAttributes: KatydidAttributesContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidInputUrl(this, selector, key, accesskey, autocomplete, autofocus, contenteditable, dir,
                disabled, form, hidden, lang, list, maxlength, minlength, name, pattern,
                placeholder, readonly, required, size, spellcheck, style, tabindex, title, translate,
                value, defineAttributes)
        )
    }

    override fun inputWeek(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        autocomplete: String?,
        autofocus: Boolean?,
        contenteditable: Boolean?,
        dir: EDirection?,
        disabled: Boolean?,
        form: String?,
        hidden: Boolean?,
        lang: String?,
        list: String?,
        max: String?,
        min: String?,
        name: String?,
        readonly: Boolean?,
        required: Boolean?,
        spellcheck: Boolean?,
        step: String?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        value: String?,
        defineAttributes: KatydidAttributesContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidInputWeek(this, selector, key, accesskey, autocomplete, autofocus, contenteditable, dir,
                disabled, form, hidden, lang, list, max, min, name,
                readonly, required, spellcheck, step, style, tabindex, title, translate,
                value, defineAttributes)
        )
    }

    override fun ins(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        cite: String?,
        contenteditable: Boolean?,
        datetime: KatyDateTime?,
        dir: EDirection?,
        hidden: Boolean?,
        lang: String?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        defineContent: KatydidPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidIns(this, selector, key, accesskey, cite, contenteditable, datetime, dir, hidden,
                lang, spellcheck, style, tabindex, title, translate, defineContent)
        )
    }

    override fun kbd(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        hidden: Boolean?,
        lang: String?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        defineContent: KatydidPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidKbd(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
                tabindex, title, translate, defineContent)
        )
    }

    override fun label(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        `for`: String?,
        hidden: Boolean?,
        lang: String?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        defineContent: KatydidPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidLabel(this, selector, key, accesskey, contenteditable, dir, `for`, hidden, lang, spellcheck,
                style, tabindex, title, translate, defineContent)
        )
    }

    override fun map(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        hidden: Boolean?,
        lang: String?,
        name: String?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        defineContent: KatydidPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidMap(this, selector, key, accesskey, contenteditable, dir, hidden, lang, name,
                spellcheck, style, tabindex, title, translate, defineContent)
        )
    }

    override fun mark(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        hidden: Boolean?,
        lang: String?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        defineContent: KatydidPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidMark(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
                tabindex, title, translate, defineContent)
        )
    }

    override fun meter(
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
    ) {
        element.addChildNode(
            KatydidMeter(this, selector, key, accesskey, contenteditable, dir, hidden, high, lang,
                low, max, min, optimum, spellcheck, style, tabindex, title, translate, value, defineContent)
        )
    }

    override fun meter(
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
    ) {
        element.addChildNode(
            KatydidMeter(this, selector, key, accesskey, contenteditable, dir, hidden, high, lang,
                low, max, min, optimum, spellcheck, style, tabindex, title, translate, value, defineContent)
        )
    }

    /**
     * Creates a new option group builder for the given child [element] that has the same restrictions
     * as this builder.
     */
    fun optGroupContent(element: KatydidDataList<Msg>): KatydidOptGroupContentBuilder<Msg> {
        return KatydidOptGroupContentBuilderImpl(element, contentRestrictions, dispatchMessages)
    }

    override fun output(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        disabled: Boolean?,
        `for`: String?,
        form: String?,
        hidden: Boolean?,
        lang: String?,
        name: String?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        defineContent: KatydidPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidOutput(this, selector, key, accesskey, contenteditable, dir, disabled, `for`, form,
                hidden, lang, name, spellcheck, style, tabindex, title, translate, defineContent)
        )
    }

    override fun progress(
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
    ) {
        element.addChildNode(
            KatydidProgress(this, selector, key, accesskey, contenteditable, dir, hidden, lang, max,
                spellcheck, style, tabindex, title, translate, value, defineContent)
        )
    }

    override fun progress(
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
    ) {
        element.addChildNode(
            KatydidProgress(this, selector, key, accesskey, contenteditable, dir, hidden, lang, max,
                spellcheck, style, tabindex, title, translate, value, defineContent)
        )
    }

    override fun q(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        hidden: Boolean?,
        lang: String?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        defineContent: KatydidPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidQ(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
                tabindex, title, translate, defineContent)
        )
    }

    override fun s(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        hidden: Boolean?,
        lang: String?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        defineContent: KatydidPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidS(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
                tabindex, title, translate, defineContent)
        )
    }

    override fun samp(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        hidden: Boolean?,
        lang: String?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        defineContent: KatydidPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidSamp(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
                tabindex, title, translate, defineContent)
        )
    }

    override fun select(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        autocomplete: String?,
        autofocus: Boolean?,
        contenteditable: Boolean?,
        dir: EDirection?,
        disabled: Boolean?,
        form: String?,
        hidden: Boolean?,
        lang: String?,
        multiple: Boolean?,
        name: String?,
        required: Boolean?,
        size: Int?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        value: String?,
        defineContent: KatydidSelectContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidSelect(this, selector, key, accesskey, autocomplete, autofocus, contenteditable, dir, disabled, form,
                hidden, lang, multiple, name, required, size, spellcheck, style,
                tabindex, title, translate, value, defineContent)
        )
    }

    /**
     * Creates a new select builder for the given child [element] that has the same restrictions
     * as this builder.
     */
    fun selectContent(element: KatydidSelect<Msg>): KatydidSelectContentBuilder<Msg> {
        return KatydidSelectContentBuilderImpl(element, contentRestrictions, dispatchMessages)
    }

    override fun small(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        hidden: Boolean?,
        lang: String?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        defineContent: KatydidPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidSmall(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
                tabindex, title, translate, defineContent)
        )
    }

    override fun span(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        hidden: Boolean?,
        lang: String?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        defineContent: KatydidPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidSpan(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
                tabindex, title, translate, defineContent)
        )
    }

    override fun strong(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        hidden: Boolean?,
        lang: String?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        defineContent: KatydidPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidStrong(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
                tabindex, title, translate, defineContent)
        )
    }

    override fun sub(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        hidden: Boolean?,
        lang: String?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        defineContent: KatydidPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidSub(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
                tabindex, title, translate, defineContent)
        )
    }

    override fun sup(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        hidden: Boolean?,
        lang: String?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        defineContent: KatydidPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidSup(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
                tabindex, title, translate, defineContent)
        )
    }

    override fun text(
        nodeValue: String,
        key: Any?
    ) {
        element.addChildNode(KatydidText(nodeValue, key))
    }

    override fun textarea(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        autocomplete: String?,
        autofocus: Boolean?,
        cols: Int?,
        contenteditable: Boolean?,
        dir: EDirection?,
        dirname: String?,
        disabled: Boolean?,
        form: String?,
        hidden: Boolean?,
        lang: String?,
        maxlength: Int?,
        minlength: Int?,
        name: String?,
        placeholder: String?,
        readonly: Boolean?,
        required: Boolean?,
        rows: Int?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        wrap: EWrapType?,
        defineContent: KatydidTextContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidTextArea(this, selector, key, accesskey, autocomplete, autofocus, cols, contenteditable, dir,
                dirname,
                disabled, form, hidden, lang, maxlength, minlength, name,
                placeholder, readonly, required, rows, spellcheck, style, tabindex, title, translate,
                wrap, defineContent)
        )
    }

    override fun time(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        hidden: Boolean?,
        lang: String?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        defineContent: KatydidTextContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidTime(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
                tabindex, title, translate, defineContent)
        )
    }

    override fun time(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        datetime: KatyDateTime,
        dir: EDirection?,
        hidden: Boolean?,
        lang: String?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        defineContent: KatydidPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidTime(this, selector, key, accesskey, contenteditable, datetime, dir, hidden, lang,
                spellcheck, style, tabindex, title, translate, defineContent)
        )
    }

    override fun u(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        hidden: Boolean?,
        lang: String?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        defineContent: KatydidPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidU(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
                tabindex, title, translate, defineContent)
        )
    }

    override fun `var`(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        hidden: Boolean?,
        lang: String?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        defineContent: KatydidPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidVar(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
                tabindex, title, translate, defineContent)
        )
    }

    override fun wbr(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        hidden: Boolean?,
        lang: String?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        defineAttributes: KatydidAttributesContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidBr(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
                tabindex, title, translate, defineAttributes)

        )
    }

    /**
     * Creates a new content builder for the given child [element] that has the same restrictions
     * as this builder plus no anchor element or interactive content allowed.
     */
    fun withAnchorInteractiveContentNotAllowed(
        element: KatydidHtmlElementImpl<Msg>
    ): KatydidPhrasingContentBuilderImpl<Msg> {
        return KatydidPhrasingContentBuilderImpl(
            element,
            contentRestrictions.withAnchorInteractiveContentNotAllowed(),
            dispatchMessages
        )
    }

    /**
     * Creates a new content builder for the given child [element] that has the same restrictions
     * as this builder plus no anchor element or interactive content allowed.
     */
    fun withAreaAllowed(
        element: KatydidMap<Msg>
    ): KatydidPhrasingContentBuilderImpl<Msg> {
        return KatydidPhrasingContentBuilderImpl(
            element,
            contentRestrictions.withAreaAllowed(),
            dispatchMessages
        )
    }

    /**
     * Creates a new content builder for the given child [element] that has the same restrictions
     * as this builder plus no dfn element allowed.
     */
    fun withDfnNotAllowed(element: KatydidHtmlElementImpl<Msg>): KatydidPhrasingContentBuilderImpl<Msg> {
        return KatydidPhrasingContentBuilderImpl(
            element,
            contentRestrictions.withDfnNotAllowed(),
            dispatchMessages
        )
    }

    /**
     * Creates a new content builder for the given child [element] that has the same restrictions
     * as this builder plus no interactive content allowed.
     */
    open fun withInteractiveContentNotAllowed(
        element: KatydidHtmlElementImpl<Msg>
    ): KatydidPhrasingContentBuilderImpl<Msg> {
        return KatydidPhrasingContentBuilderImpl(
            element,
            contentRestrictions.withInteractiveContentNotAllowed(),
            dispatchMessages
        )
    }

    /**
     * Creates a new content builder for the given child [element] that has the same restrictions
     * as this builder plus no label element allowed.
     */
    fun withLabelNotAllowed(element: KatydidHtmlElementImpl<Msg>): KatydidPhrasingContentBuilderImpl<Msg> {
        return KatydidPhrasingContentBuilderImpl(
            element,
            contentRestrictions.withLabelNotAllowed(),
            dispatchMessages
        )
    }

    /**
     * Creates a new content builder for the given child [element] that has the same restrictions
     * as this builder plus no meter element allowed.
     */
    fun withMeterNotAllowed(element: KatydidHtmlElementImpl<Msg>): KatydidPhrasingContentBuilderImpl<Msg> {
        return KatydidPhrasingContentBuilderImpl(
            element,
            contentRestrictions.withMeterNotAllowed(),
            dispatchMessages
        )
    }

    /**
     * Creates a new content builder for the given child [element] that has the same restrictions
     * as this builder.
     */
    override fun withNoAddedRestrictions(
        element: KatydidHtmlElementImpl<Msg>
    ): KatydidPhrasingContentBuilderImpl<Msg> {
        return KatydidPhrasingContentBuilderImpl(
            element,
            contentRestrictions,
            dispatchMessages
        )
    }

    /**
     * Creates a new content builder for the given child [element] that has the same restrictions
     * as this builder plus no progress element allowed.
     */
    fun withProgressNotAllowed(element: KatydidHtmlElementImpl<Msg>): KatydidPhrasingContentBuilderImpl<Msg> {
        return KatydidPhrasingContentBuilderImpl(
            element,
            contentRestrictions.withProgressNotAllowed(),
            dispatchMessages
        )
    }

}

//---------------------------------------------------------------------------------------------------------------------

