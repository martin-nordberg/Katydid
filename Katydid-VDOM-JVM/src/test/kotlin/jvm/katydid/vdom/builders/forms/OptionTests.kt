//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.vdom.builders.forms

import jvm.katydid.vdom.api.checkBuild
import o.katydid.vdom.application.katydid
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

@Suppress("RemoveRedundantBackticks")
class OptionTests {

    @Test
    fun `A select element with various options produces correct HTML`() {

        val vdomNode = katydid<Unit> {

            select("#combo") {

                optGroup(label = "Group Em") {
                    option(key = 1) { text("One") }
                    option(key = 2) { text("Two") }
                }

                option(key = 3, label = "Three", value = "3") {}

                option(key = 4, label = "Four") {
                    text("4")
                }

                option(key = 5) {
                    text("Five")
                }

            }

        }

        val html = """<select id="combo">
                     |  <optgroup label="Group Em">
                     |    <option>
                     |      One
                     |    </option>
                     |    <option>
                     |      Two
                     |    </option>
                     |  </optgroup>
                     |  <option label="Three" value="3"></option>
                     |  <option label="Four">
                     |    4
                     |  </option>
                     |  <option>
                     |    Five
                     |  </option>
                     |</select>""".trimMargin()

        checkBuild(html, vdomNode)

    }

    @Test
    fun `A datalist element with various options produces correct HTML`() {

        val vdomNode = katydid<Unit> {

            datalist {

                option(key = 3, label = "Three", value = "3") {}

                option(key = 4, label = "Four") {
                    text("4")
                }

                option(key = 5) {
                    text("Five")
                }

            }

        }

        val html = """<datalist>
                     |  <option label="Three" value="3"></option>
                     |  <option label="Four">
                     |    4
                     |  </option>
                     |  <option>
                     |    Five
                     |  </option>
                     |</datalist>""".trimMargin()

        checkBuild(html, vdomNode)

    }

    @Test
    fun `An option may not have blank label`() {

        assertThrows<IllegalArgumentException> {

            katydid<Unit> {

                datalist {

                    option(label = "") {
                        text("Nonsense")
                    }

                }

            }
        }

    }

}