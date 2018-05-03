//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.org.katydom.api

import jvm.org.katydom.kdom.KDomDocument
import o.org.katydom.abstractnodes.KatyDomHtmlElement
import o.org.katydom.abstractnodes.KatyDomNode
import o.org.katydom.api.makeKatyDomLifecycle
import kotlin.test.assertEquals
import kotlin.test.fail

//---------------------------------------------------------------------------------------------------------------------

/**
 * Builds the DOM for a given KatyDOM node and checks the HTML output against what's expected.
 */
internal fun <Msg> checkBuild(expectedHtml: String, vdomNode: KatyDomNode<Msg>) {

    val body = KDomDocument().createElement("body")
    val div = body.ownerDocument.createElement("div")

    body.appendChild(div)

    assertEquals(div, body.firstChild)

    val lifecycle = makeKatyDomLifecycle<Msg>()

    if (vdomNode is KatyDomHtmlElement) {
        lifecycle.build(div, vdomNode)
    }

    assertEquals(expectedHtml, body.firstChild?.toHtmlString())

}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Builds the DOM for a given KatyDOM node and checks the HTML output against what's expected before and after a patch.
 */
internal fun <Msg> checkPatch(expectedHtml2: String, vdomNode2: KatyDomNode<Msg>, expectedHtml1: String,
                              vdomNode1: KatyDomNode<Msg>) {

    val body = KDomDocument().createElement("body")
    val div = body.ownerDocument.createElement("div")

    body.appendChild(div)

    assertEquals(div, body.firstChild)

    val lifecycle = makeKatyDomLifecycle<Msg>()

    if (vdomNode1 is KatyDomHtmlElement && vdomNode2 is KatyDomHtmlElement) {
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

