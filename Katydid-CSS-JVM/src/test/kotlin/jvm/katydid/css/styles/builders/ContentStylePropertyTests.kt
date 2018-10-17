//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.css.styles.builders

import o.katydid.css.styles.KatydidStyle
import o.katydid.css.styles.builders.content
import o.katydid.css.styles.makeStyle
import o.katydid.css.types.EContent.*
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

//---------------------------------------------------------------------------------------------------------------------

@Suppress("RemoveRedundantBackticks")
class ContentStylePropertyTests {

    private fun checkStyle(
        expectedCss: String,
        build: KatydidStyle.() -> Unit
    ) {
        assertEquals(expectedCss, makeStyle(build).toString())
    }

    @Test
    fun `Content style properties convert to correct CSS`() {

        checkStyle("content: close-quote;") { content(closeQuote) }
        checkStyle("content: no-close-quote;") { content(noCloseQuote) }
        checkStyle("content: no-open-quote;") { content(noOpenQuote) }
        checkStyle("content: none;") { content(none) }
        checkStyle("content: normal;") { content(normal) }
        checkStyle("content: open-quote;") { content(openQuote) }
        checkStyle("content: \"a \\\"quoted\\\" string\";") { content("a \"quoted\" string") }
        checkStyle("content: url(\"http://somewhere\");") { content(url("http://somewhere")) }
        checkStyle("content: attr(data-content);") { content(attr("data-content")) }

    }

}

//---------------------------------------------------------------------------------------------------------------------

