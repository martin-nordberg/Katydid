//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.vdom.builders.tables

//---------------------------------------------------------------------------------------------------------------------

/**
 * Set of restrictions on table content. Enforces the sub-elements of a `<table>` to occur in the correct order.
 */
internal class KatydidTableContentRestrictions {

    private var captionAllowed = true

    private var colgroupAllowed = true

    private var tbodyAllowed = true

    private var tfootAllowed = true

    private var theadAllowed = true

    private var trAllowed = true

    ////

    /**
     * Confirms that a `<caption>` element is allowed then disallows any additional ones.
     * @throws IllegalStateException if `<caption>` is not allowed.
     */
    fun confirmCaptionAllowed() {
        check(captionAllowed) { "Element type <caption> not allowed here" }
        captionAllowed = false
    }

    /**
     * Confirms that a `<colgroup>` element is allowed. Also disallows a `<caption>` after this call.
     * @throws IllegalStateException if `<colgroup>` is not allowed.
     */
    fun confirmColGroupAllowed() {
        check(colgroupAllowed) { "Element type <colgroup> not allowed here" }
        captionAllowed = false
    }

    /**
     * Confirms that a `<tbody>` element is allowed. Also disallows a `<caption>`, `<colgroup>`, `<tr>`, or `<thead>`
     * after this call.
     * @throws IllegalStateException if `<tbody>` is not allowed.
     */
    fun confirmTBodyAllowed() {
        check(tbodyAllowed) { "Element type <tbody> not allowed here" }
        captionAllowed = false
        colgroupAllowed = false
        theadAllowed = false
        trAllowed = false
    }

    /**
     * Confirms that a `<tfoot>` element is allowed. Also disallows anything else after this call.
     * @throws IllegalStateException if `<tfoot>` is not allowed.
     */
    fun confirmTFootAllowed() {
        check(tbodyAllowed) { "Element type <tfoot> not allowed here" }
        captionAllowed = false
        colgroupAllowed = false
        tbodyAllowed = false
        tfootAllowed = false
        theadAllowed = false
        trAllowed = false
    }

    /**
     * Confirms that a `<thead>` element is allowed. Also disallows a `<caption>` or `<colgroup>` after this call.
     * @throws IllegalStateException if `<thead>` is not allowed.
     */
    fun confirmTHeadAllowed() {
        check(theadAllowed) { "Element type <thead> not allowed here" }
        captionAllowed = false
        colgroupAllowed = false
    }

    /**
     * Confirms that a `<tr>` element is allowed. Also disallows a `<caption>`, `<colgroup>`, `<tbody>`, or `<thead>`
     * after this call.
     * @throws IllegalStateException if `<tr>` is not allowed.
     */
    fun confirmTrAllowed() {
        check(trAllowed) { "Element type <tr> not allowed here" }
        captionAllowed = false
        colgroupAllowed = false
        tbodyAllowed = false
        theadAllowed = false
    }

}

//---------------------------------------------------------------------------------------------------------------------

