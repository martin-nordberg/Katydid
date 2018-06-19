//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.org.katydom.internal.builders

import o.org.katydom.abstractnodes.KatyDomHtmlElement
import o.org.katydom.builders.KatyDomAttributesContentBuilder
import o.org.katydom.builders.KatyDomPhrasingContentBuilder
import o.org.katydom.builders.miscellaneous.KatyDomOptGroupContentBuilder
import o.org.katydom.builders.miscellaneous.KatyDomSelectContentBuilder
import o.org.katydom.builders.miscellaneous.KatyDomTextContentBuilder
import o.org.katydom.internal.builders.miscellaneous.KatyDomOptGroupContentBuilderImpl
import o.org.katydom.internal.builders.miscellaneous.KatyDomSelectContentBuilderImpl
import o.org.katydom.internal.concretenodes.edits.KatyDomDel
import o.org.katydom.internal.concretenodes.edits.KatyDomIns
import o.org.katydom.internal.concretenodes.forms.*
import o.org.katydom.internal.concretenodes.text.*
import o.org.katydom.types.*
import x.org.katydom.types.KatyDateTime
import x.org.katydom.types.KatyTime

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual DOM builder for the case of HTML "phrasing content".
 *
 * @constructor Constructs a new phrasing content builder for the given [element].
 * @param element the element whose content is being built.
 * @param contentRestrictions restrictions on content enforced at run time.
 * @param dispatchMessages dispatcher of event handling results for when we want event handling to be reactive or Elm-like.
 */
@Suppress("unused")
internal open class KatyDomPhrasingContentBuilderImpl<Msg>(
    element: KatyDomHtmlElement<Msg>,
    contentRestrictions: KatyDomContentRestrictions,
    dispatchMessages: (messages: Iterable<Msg>) -> Unit
) : KatyDomEmbeddedContentBuilderImpl<Msg>(element, contentRestrictions, dispatchMessages),
    KatyDomPhrasingContentBuilder<Msg> {

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
        defineContent: KatyDomPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomA(this, selector, key, accesskey, contenteditable, dir, download, hidden, href, hreflang, lang,
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
        defineContent: KatyDomPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomAbbr(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
                        tabindex, title, translate, defineContent)
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
        defineContent: KatyDomPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomB(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
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
        defineContent: KatyDomPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomBdi(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
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
        defineContent: KatyDomPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomBdo(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
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
        defineAttributes: KatyDomAttributesContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomBr(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
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
        defineContent: KatyDomPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomButton(this, selector, key, accesskey, autofocus, contenteditable, dir, disabled, form, formaction,
                          formenctype, formmethod, formnovalidate, formtarget, hidden, lang,
                          name, spellcheck, style, tabindex, title, translate, type, value, defineContent)
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
        defineContent: KatyDomPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomCite(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
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
        defineContent: KatyDomPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomCode(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
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
        defineContent: KatyDomPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomData(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
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
        defineContent: KatyDomOptGroupContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomDataList(this, selector, key, accesskey, contenteditable, dir,
                            hidden, lang, spellcheck, style,
                            tabindex, title, translate, defineContent)
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
        defineContent: KatyDomPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomDel(this, selector, key, accesskey, cite, contenteditable, datetime, dir, hidden,
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
        defineContent: KatyDomPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomDfn(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
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
        defineContent: KatyDomPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomEm(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
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
        defineContent: KatyDomPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomI(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
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
        defineAttributes: KatyDomAttributesContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomInputButton(this, selector, key, accesskey, contenteditable, dir, disabled, form, hidden, lang,
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
        defineAttributes: KatyDomAttributesContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomInputCheckbox(this, selector, key, accesskey, autofocus, checked, contenteditable, dir,
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
        defineAttributes: KatyDomAttributesContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomInputColor(this, selector, key, accesskey, autocomplete, autofocus, contenteditable, dir,
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
        defineAttributes: KatyDomAttributesContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomInputDate(this, selector, key, accesskey, autocomplete, autofocus, contenteditable, dir,
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
        defineAttributes: KatyDomAttributesContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomInputDateTimeLocal(this, selector, key, accesskey, autocomplete, autofocus, contenteditable, dir,
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
        defineAttributes: KatyDomAttributesContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomInputEmail(this, selector, key, accesskey, autocomplete, autofocus, contenteditable, dir,
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
        defineAttributes: KatyDomAttributesContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomInputFile(this, selector, key, accept, accesskey, autofocus, contenteditable, dir, disabled,
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
        defineAttributes: KatyDomAttributesContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomInputHidden(this, selector, key, accesskey, contenteditable, dir, disabled, form, hidden, lang,
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
        defineAttributes: KatyDomAttributesContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomInputImageButton(this, selector, key, accesskey, alt, contenteditable, dir, disabled, form,
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
        defineAttributes: KatyDomAttributesContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomInputMonth(this, selector, key, accesskey, autocomplete, autofocus, contenteditable, dir,
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
        defineAttributes: KatyDomAttributesContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomInputNumber(this, selector, key, accesskey, autocomplete, autofocus, contenteditable, dir,
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
        defineAttributes: KatyDomAttributesContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomInputNumber(this, selector, key, accesskey, autocomplete, autofocus, contenteditable, dir,
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
        defineAttributes: KatyDomAttributesContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomInputPassword(this, selector, key, accesskey, autocomplete, autofocus, contenteditable, dir,
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
        defineAttributes: KatyDomAttributesContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomInputRadioButton(this, selector, key, accesskey, autofocus, checked, contenteditable, dir,
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
        defineAttributes: KatyDomAttributesContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomInputRange(this, selector, key, accesskey, autocomplete, autofocus, contenteditable, dir,
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
        defineAttributes: KatyDomAttributesContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomInputResetButton(this, selector, key, accesskey, contenteditable, dir, disabled, form, hidden, lang,
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
        defineAttributes: KatyDomAttributesContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomInputSearch(this, selector, key, accesskey, autocomplete, autofocus, contenteditable, dir, dirname,
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
        defineAttributes: KatyDomAttributesContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomInputSubmitButton(this, selector, key, accesskey, contenteditable, dir, disabled, form, formaction,
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
        defineAttributes: KatyDomAttributesContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomInputTelephone(this, selector, key, accesskey, autocomplete, autofocus, contenteditable, dir,
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
        defineAttributes: KatyDomAttributesContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomInputText(this, selector, key, accesskey, autocomplete, autofocus, contenteditable, dir, dirname,
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
        defineAttributes: KatyDomAttributesContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomInputTime(this, selector, key, accesskey, autocomplete, autofocus, contenteditable, dir,
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
        defineAttributes: KatyDomAttributesContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomInputUrl(this, selector, key, accesskey, autocomplete, autofocus, contenteditable, dir,
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
        defineAttributes: KatyDomAttributesContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomInputWeek(this, selector, key, accesskey, autocomplete, autofocus, contenteditable, dir,
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
        defineContent: KatyDomPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomIns(this, selector, key, accesskey, cite, contenteditable, datetime, dir, hidden,
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
        defineContent: KatyDomPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomKbd(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
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
        defineContent: KatyDomPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomLabel(this, selector, key, accesskey, contenteditable, dir, `for`, hidden, lang, spellcheck,
                         style, tabindex, title, translate, defineContent)
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
        defineContent: KatyDomPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomMark(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
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
        defineContent: KatyDomPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomMeter(this, selector, key, accesskey, contenteditable, dir, hidden, high, lang,
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
        defineContent: KatyDomPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomMeter(this, selector, key, accesskey, contenteditable, dir, hidden, high, lang,
                         low, max, min, optimum, spellcheck, style, tabindex, title, translate, value, defineContent)
        )
    }

    /**
     * Creates a new option group builder for the given child [element] that has the same restrictions
     * as this builder.
     */
    fun optGroupContent(element: KatyDomDataList<Msg>): KatyDomOptGroupContentBuilder<Msg> {
        return KatyDomOptGroupContentBuilderImpl(element, contentRestrictions, dispatchMessages)
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
        defineContent: KatyDomPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomOutput(this, selector, key, accesskey, contenteditable, dir, disabled, `for`, form,
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
        defineContent: KatyDomPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomProgress(this, selector, key, accesskey, contenteditable, dir, hidden, lang, max,
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
        defineContent: KatyDomPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomProgress(this, selector, key, accesskey, contenteditable, dir, hidden, lang, max,
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
        defineContent: KatyDomPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomQ(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
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
        defineContent: KatyDomPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomS(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
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
        defineContent: KatyDomPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomSamp(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
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
        defineContent: KatyDomSelectContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomSelect(this, selector, key, accesskey, autocomplete, autofocus, contenteditable, dir, disabled, form,
                          hidden, lang, multiple, name, required, size, spellcheck, style,
                          tabindex, title, translate, value, defineContent)
        )
    }

    /**
     * Creates a new select builder for the given child [element] that has the same restrictions
     * as this builder.
     */
    fun selectContent(element: KatyDomSelect<Msg>): KatyDomSelectContentBuilder<Msg> {
        return KatyDomSelectContentBuilderImpl(element, contentRestrictions, dispatchMessages)
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
        defineContent: KatyDomPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomSmall(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
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
        defineContent: KatyDomPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomSpan(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
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
        defineContent: KatyDomPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomStrong(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
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
        defineContent: KatyDomPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomSub(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
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
        defineContent: KatyDomPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomSup(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
                       tabindex, title, translate, defineContent)
        )
    }

    override fun text(nodeValue: String) {
        element.addChildNode(KatyDomText(nodeValue))
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
        defineContent: KatyDomTextContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomTextArea(this, selector, key, accesskey, autocomplete, autofocus, cols, contenteditable, dir,
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
        defineContent: KatyDomTextContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomTime(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
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
        defineContent: KatyDomPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomTime(this, selector, key, accesskey, contenteditable, datetime, dir, hidden, lang,
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
        defineContent: KatyDomPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomU(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
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
        defineContent: KatyDomPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomVar(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
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
        defineAttributes: KatyDomAttributesContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomBr(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
                      tabindex, title, translate, defineAttributes)

        )
    }

    /**
     * Creates a new content builder for the given child [element] that has the same restrictions
     * as this builder plus no anchor element or interactive content allowed.
     */
    fun withAnchorInteractiveContentNotAllowed(
        element: KatyDomHtmlElement<Msg>): KatyDomPhrasingContentBuilderImpl<Msg> {
        return KatyDomPhrasingContentBuilderImpl(
            element,
            contentRestrictions.withAnchorInteractiveContentNotAllowed(),
            dispatchMessages
        )
    }

    /**
     * Creates a new content builder for the given child [element] that has the same restrictions
     * as this builder plus no dfn element allowed.
     */
    fun withDfnNotAllowed(element: KatyDomHtmlElement<Msg>): KatyDomPhrasingContentBuilderImpl<Msg> {
        return KatyDomPhrasingContentBuilderImpl(
            element,
            contentRestrictions.withDfnNotAllowed(),
            dispatchMessages
        )
    }

    /**
     * Creates a new content builder for the given child [element] that has the same restrictions
     * as this builder plus no interactive content allowed.
     */
    fun withInteractiveContentNotAllowed(
        element: KatyDomHtmlElement<Msg>): KatyDomPhrasingContentBuilderImpl<Msg> {
        return KatyDomPhrasingContentBuilderImpl(
            element,
            contentRestrictions.withInteractiveContentNotAllowed(),
            dispatchMessages
        )
    }

    /**
     * Creates a new content builder for the given child [element] that has the same restrictions
     * as this builder plus no label element allowed.
     */
    fun withLabelNotAllowed(element: KatyDomHtmlElement<Msg>): KatyDomPhrasingContentBuilderImpl<Msg> {
        return KatyDomPhrasingContentBuilderImpl(
            element,
            contentRestrictions.withLabelNotAllowed(),
            dispatchMessages
        )
    }

    /**
     * Creates a new content builder for the given child [element] that has the same restrictions
     * as this builder plus no meter element allowed.
     */
    fun withMeterNotAllowed(element: KatyDomHtmlElement<Msg>): KatyDomPhrasingContentBuilderImpl<Msg> {
        return KatyDomPhrasingContentBuilderImpl(
            element,
            contentRestrictions.withMeterNotAllowed(),
            dispatchMessages
        )
    }

    /**
     * Creates a new content builder for the given child [element] that has the same restrictions
     * as this builder.
     */
    open fun withNoAddedRestrictions(
        element: KatyDomHtmlElement<Msg>): KatyDomPhrasingContentBuilderImpl<Msg> {
        return KatyDomPhrasingContentBuilderImpl(
            element,
            contentRestrictions,
            dispatchMessages
        )
    }

    /**
     * Creates a new content builder for the given child [element] that has the same restrictions
     * as this builder plus no progress element allowed.
     */
    fun withProgressNotAllowed(element: KatyDomHtmlElement<Msg>): KatyDomPhrasingContentBuilderImpl<Msg> {
        return KatyDomPhrasingContentBuilderImpl(
            element,
            contentRestrictions.withProgressNotAllowed(),
            dispatchMessages
        )
    }

}

//---------------------------------------------------------------------------------------------------------------------

