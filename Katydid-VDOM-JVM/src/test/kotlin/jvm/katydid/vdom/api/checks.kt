//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.vdom.api

import jvm.katydid.kdom.KDomDocument
import o.katydid.vdom.application.makeKatydidLifecycle
import o.katydid.vdom.elements.KatydidHtmlElement
import o.katydid.vdom.elements.KatydidNode
import kotlin.test.assertEquals
import kotlin.test.fail

//---------------------------------------------------------------------------------------------------------------------

/**
 * Builds the DOM for a given Katydid node and checks the HTML output against what's expected.
 */
internal fun <Msg> checkBuild(
    expectedHtml: String,
    vdomNode: KatydidNode<Msg>
) {

    val body = KDomDocument().createElement("body")
    val div = body.ownerDocument.createElement("div")

    body.appendChild(div)

    assertEquals(div, body.firstChild)

    val lifecycle = makeKatydidLifecycle<Msg>()

    if (vdomNode is KatydidHtmlElement) {
        lifecycle.build(div, vdomNode)
    }

    val actualHtml = body.firstChild!!.toHtmlString()

    var msg = ""
    if ( expectedHtml != actualHtml ) {
        msg = "Matched:\n"
        var i = 0
        while ( expectedHtml[i] == actualHtml[i] ) {
            msg += expectedHtml[i]
            i += 1
        }
        msg += "...\n"
    }

    assertEquals(expectedHtml, body.firstChild?.toHtmlString(), msg)

}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Builds the DOM for a given Katydid node and checks the HTML output against what's expected before and after a patch.
 */
internal fun <Msg> checkPatch(
    expectedHtml2: String,
    vdomNode2: KatydidNode<Msg>,
    expectedHtml1: String,
    vdomNode1: KatydidNode<Msg>
) {

    val body = KDomDocument().createElement("body")
    val div = body.ownerDocument.createElement("div")

    body.appendChild(div)

    assertEquals(div, body.firstChild)

    val lifecycle = makeKatydidLifecycle<Msg>()

    if (vdomNode1 is KatydidHtmlElement && vdomNode2 is KatydidHtmlElement) {
        lifecycle.build(div, vdomNode1)

        assertEquals(expectedHtml1, body.firstChild?.toHtmlString())

        lifecycle.patch(vdomNode1, vdomNode2)

        assertEquals(expectedHtml2, body.firstChild?.toHtmlString())
    }
    else {
        fail("Function checkPatch expects HTML elements.")
    }

}

//---------------------------------------------------------------------------------------------------------------------

