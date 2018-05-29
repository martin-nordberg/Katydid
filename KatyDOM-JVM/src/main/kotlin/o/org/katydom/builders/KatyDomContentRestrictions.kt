//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.org.katydom.builders

//---------------------------------------------------------------------------------------------------------------------

/**
 * Set of restrictions on content. E.g. a header cannot contain a header or footer; a form cannot be nested.
 */
class KatyDomContentRestrictions(
    private val anchorAllowed: Boolean,
    private var figCaptionProhibited: Boolean,
    private val footerAllowed: Boolean,
    private val formAllowed: Boolean,
    private val headerAllowed: Boolean,
    private val interactiveContentAllowed: Boolean,
    private val labelAllowed: Boolean,
    private var legendProhibited: Boolean,
    private val mainAllowed: Boolean,
    private val meterAllowed: Boolean,
    private val progressAllowed: Boolean,
    private val tableAllowed: Boolean
) {

    /**
     * Constructs a new content restriction object with default starting point for the restrictions.
     */
    constructor()
        : this(
        true,
        true,
        true,
        true,
        true,
        true,
        true,
        true,
        true,
        true,
        true,
        true
    )

    /**
     * Clones a given [original] content restriction object with the opportunity to override specific restrictions
     * to make the result more restricted than the original.
     */
    constructor(
        original: KatyDomContentRestrictions,
        anchorAllowed: Boolean = true,
        figCaptionProhibited: Boolean = true,
        footerAllowed: Boolean = true,
        formAllowed: Boolean = true,
        headerAllowed: Boolean = true,
        interactiveContentAllowed: Boolean = true,
        labelAllowed: Boolean = true,
        legendProhibited: Boolean = false,
        mainAllowed: Boolean = true,
        meterAllowed: Boolean = true,
        progressAllowed: Boolean = true,
        tableAllowed: Boolean = true
    ) : this(
        original.anchorAllowed && anchorAllowed,
        original.figCaptionProhibited && figCaptionProhibited,
        original.footerAllowed && footerAllowed,
        original.formAllowed && formAllowed,
        original.headerAllowed && headerAllowed,
        original.interactiveContentAllowed && interactiveContentAllowed,
        original.labelAllowed && labelAllowed,
        original.legendProhibited && legendProhibited,
        original.mainAllowed && mainAllowed,
        original.meterAllowed && meterAllowed,
        original.progressAllowed && progressAllowed,
        original.tableAllowed && tableAllowed
    )

    ////

    /**
     * Confirms that an `<a>` element is allowed.
     * @throws IllegalStateException if `<a>` is not allowed.
     */
    fun confirmAnchorAllowed() {
        check(anchorAllowed) { "Element type <a> not allowed here" }
    }

    /**
     * Confirms that a `<figcaption>` element is allowed. As a side effect disallows additional `<figcaption>` elements
     * after this one. I.e. enforces at most one `<figcaption>` per `<figure>`.
     * @throws IllegalStateException if `<figcaption>` is not allowed.
     */
    fun confirmFigCaptionAllowedThenDisallow() {
        check(!figCaptionProhibited) { "Element type <figcaption> not allowed here." }
        figCaptionProhibited = true
    }

    /**
     * Checks that a `<footer>` element is allowed in the content.
     * @throws IllegalStateException if `<footer>` is not allowed.
     */
    fun confirmFooterAllowed() {
        check(footerAllowed) { "Element type <footer> not allowed here." }
    }

    /**
     * Checks that a `<form>` element is allowed in the content, i.e. it would not be nested inside another `<form>`.
     * @throws IllegalStateException if `<form>` is not allowed.
     */
    fun confirmFormAllowed() {
        check(formAllowed) { "Element type <form> not allowed here. (Form elements cannot be nested.)" }
    }

    /**
     * Checks that a `<header>` element is allowed in the content.
     * @throws IllegalStateException if `<header>` is not allowed.
     */
    fun confirmHeaderAllowed() {
        check(headerAllowed) { "Element type <header> not allowed here." }
    }

    /**
     * Checks that interactive content is allowed in the content.
     * @throws IllegalStateException if interactive content is not allowed.
     */
    fun confirmInteractiveContentAllowed() {
        check(interactiveContentAllowed) { "Interactive content not allowed here." }
    }

    /**
     * Checks that a `<label>` element is allowed in the content.
     * @throws IllegalStateException if `<label>` is not allowed.
     */
    fun confirmLabelAllowed() {
        check(labelAllowed) { "Element type <label> not allowed here." }
    }

    /**
     * Confirms that a `<legend>` element is allowed, i.e. the content is inside a `<fieldset>` element. As a side
     * effect disallows additional `<legend>` elements after this one. I.e. enforces at most one `<legend>` per
     * `<fieldset>`.
     * @throws IllegalStateException if `<legend>` is not allowed.
     */
    fun confirmLegendAllowedThenDisallow() {
        check(!legendProhibited) { "Element type <legend> not allowed here." }
        legendProhibited = true
    }

    /**
     * Checks that a `<main>` element is allowed in the content.
     * @throws IllegalStateException if `<main>` is not allowed.
     */
    fun confirmMainAllowed() {
        check(mainAllowed) { "Element type <main> not allowed here." }
    }

    /**
     * Checks that a `<meter>` element is allowed in the content.
     * @throws IllegalStateException if `<meter>` is not allowed.
     */
    fun confirmMeterAllowed() {
        check(meterAllowed) { "Element type <meter> not allowed here." }
    }

    /**
     * Checks that a `<progress>` element is allowed in the content.
     * @throws IllegalStateException if `<progress>` is not allowed.
     */
    fun confirmProgressAllowed() {
        check(progressAllowed) { "Element type <progress> not allowed here." }
    }

    /**
     * Checks that a `<table>` element is allowed in the content.
     * @throws IllegalStateException if `<table>` is not allowed.
     */
    fun confirmTableAllowed() {
        check(tableAllowed) { "Element type <table> not allowed here." }
    }

    /**
     * Clones this content restriction object but with `<a>` elements and interactive content disallowed.
     */
    fun withAnchorInteractiveContentNotAllowed(): KatyDomContentRestrictions {
        return KatyDomContentRestrictions(
            this,
            anchorAllowed = false,
            interactiveContentAllowed = false
        )
    }

    /**
     * Clones this content restriction object but with `<figcaption>` elements no longer prohibited (i.e. inside
     * a `<figure>` element.
     */
    fun withFigCaptionAllowed(): KatyDomContentRestrictions {
        return KatyDomContentRestrictions(
            this,
            figCaptionProhibited = false
        )
    }

    /**
     * Clones this content restriction object but with `<footer>`, `<header>`, and `<main>` elements disallowed.
     */
    fun withFooterHeaderMainNotAllowed(): KatyDomContentRestrictions {
        return KatyDomContentRestrictions(
            this,
            footerAllowed = false,
            headerAllowed = false,
            mainAllowed = false
        )
    }

    /**
     * Clones this content restriction object but with `<form>` elements disallowed. (A `<form>` element cannot
     * be nested.)
     */
    fun withFormNotAllowed(): KatyDomContentRestrictions {
        return KatyDomContentRestrictions(this, formAllowed = false)
    }

    /**
     * Clones this content restriction object but with interactive content disallowed.
     */
    fun withInteractiveContentNotAllowed(): KatyDomContentRestrictions {
        return KatyDomContentRestrictions(
            this,
            interactiveContentAllowed = false
        )
    }

    /**
     * Clones this content restriction object but with `<label>` elements disallowed. (A `<label>` element cannot
     * be nested.)
     */
    fun withLabelNotAllowed(): KatyDomContentRestrictions {
        return KatyDomContentRestrictions(this, labelAllowed = false)
    }

    /**
     * Clones this content restriction object but with `<legend>` elements no longer prohibited. (A single `<legend>`
     * element can appear inside a `<fieldset>` element).
     */
    fun withLegendAllowed(): KatyDomContentRestrictions {
        return KatyDomContentRestrictions(this, legendProhibited = false)
    }

    /**
     * Clones this content restriction object but with `<main>` elements disallowed.
     */
    fun withMainNotAllowed(): KatyDomContentRestrictions {
        return KatyDomContentRestrictions(this, mainAllowed = false)
    }

    /**
     * Clones this content restriction object but with `<meter>` elements disallowed.
     */
    fun withMeterNotAllowed(): KatyDomContentRestrictions {
        return KatyDomContentRestrictions(this, meterAllowed = false)
    }

    /**
     * Clones this content restriction object but with `<progress>` elements disallowed.
     */
    fun withProgressNotAllowed(): KatyDomContentRestrictions {
        return KatyDomContentRestrictions(this, progressAllowed = false)
    }

    /**
     * Clones this content restriction object but with `<table>` elements disallowed.
     */
    fun withTableNotAllowed(): KatyDomContentRestrictions {
        return KatyDomContentRestrictions(this, tableAllowed = false)
    }

}

//---------------------------------------------------------------------------------------------------------------------

