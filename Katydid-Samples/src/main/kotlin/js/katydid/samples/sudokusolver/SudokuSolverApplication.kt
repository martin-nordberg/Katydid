//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package js.katydid.samples.sudokusolver

import js.katydid.css.buildStyleElement
import js.katydid.vdom.api.KatydidApplication
import js.katydid.vdom.api.runApplication
import o.katydid.css.colors.*
import o.katydid.css.measurements.px
import o.katydid.css.styles.builders.*
import o.katydid.css.stylesheets.makeStyleSheet
import o.katydid.css.types.*
import o.katydid.vdom.builders.KatydidFlowContentBuilder
import kotlin.browser.document

//---------------------------------------------------------------------------------------------------------------------

/**
 * Katydid application for solving Sudoku.
 */
class SudokuSolverApplication : KatydidApplication<SudokuSolverAppState, SudokuSolverMsg> {

    /**
     * Initializes the application state for the first time.
     */
    override fun initialize(): SudokuSolverAppState {
        return SudokuSolverAppState()
    }

    /**
     * Creates a new application state modified from given [applicationState] by the given [message].
     */
    override fun update(applicationState: SudokuSolverAppState, message: SudokuSolverMsg): SudokuSolverAppState =
        updateSudokuSolver(applicationState, message)

    /**
     * Constructs the Katydid virtual DOM tree for given input application state [applicationState].
     * @return a builder that builds the root of the application's virtual DOM tree for given application state.
     */
    override fun view(applicationState: SudokuSolverAppState): KatydidFlowContentBuilder<SudokuSolverMsg>.() -> Unit =
        viewSudokuSolver(applicationState)

}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Runs the Sudoku Solver application.
 */
@Suppress("UNUSED_PARAMETER")
fun sudokuSolverMain(args: Array<String>) {

    val css = makeSudokuStyleSheet()

    val cssElement = document.getElementById("appStyleElement")!!

    buildStyleElement(cssElement, css)

    runApplication(
        "app",
        SudokuSolverApplication()
    )

}

//---------------------------------------------------------------------------------------------------------------------

fun makeSudokuStyleSheet() =
    makeStyleSheet {

        /* BODY */
        "body" {
            fontFamily("Arial", "Helvetica Neue", "Helvetica", "sans-serif")
        }

        /* SECTION */
        "section" {

            display(EDisplay.inlineBlock)
            float(EFloat.left)

            "&#changes" {
                maxHeight(850.px)
                overflowY(EOverflow.scroll)
            }

            "&#settings" or "&#notes" {
                clear(EClear.both)
                marginTop(15.px)
                maxWidth(700.px)
            }

            "&#settings fieldset" {
                borderStyle(ELineStyle.none)
                margin(3.px, 3.px, 3.px, 3.px)
            }

        }

        /* TABLE */
        "table" {

            borderCollapse(EBorderCollapse.collapse)
            borderSpacing(0.px)
            padding(0.px)

            "&.board" {
                border(3.px, ELineStyle.solid, black)
            }

            "&.block" {

                border(2.px, ELineStyle.solid, black)

                "td.cell" {

                    border(1.px, ELineStyle.solid, black)
                    borderCollapse(EBorderCollapse.collapse)
                    borderSpacing(0.px)
                    fontSize(50.px)
                    height(66.px)
                    padding(3.px)
                    textAlign(ETextAlign.center)
                    width(66.px)

                    "&.guessed" {
                        color(blue)
                    }

                    "&.solved" {
                        color(green)
                    }

                    "&.guessed:hover" or "&.defined:hover" {
                        color(purple)
                        cursor(ECursor.pointer)
                        textDecoration(ETextDecorationLine.underline)
                    }

                    "&.unfillable" {
                        backgroundColor(pink)
                    }

                }

            }

            "&.candidates td" {

                fontSize(12.px)
                height(20.px)
                width(20.px)

                "&.candidate:hover" {
                    color(blue)
                    cursor(ECursor.pointer)
                    textDecoration(ETextDecorationLine.underline)
                }

            }

            "&.changes" {

                "tr:nth-child(even)" {
                    backgroundColor(Color.fromHex("#f2f2f2")!!)
                }

                "th.candidates-removed" or "td.candidates-removed" {
                    fontSize(15.px)
                    textAlign(ETextAlign.left)
                    verticalAlign(EAlignmentBaseline.top)
                    width(450.px)
                }

                "th.cell-value-set" or "td.cell-value-set" {
                    textAlign(ETextAlign.left)
                    verticalAlign(EAlignmentBaseline.top)
                    width(100.px)
                }

                "th.change-description" or "td.change-description" {
                    textAlign(ETextAlign.left)
                    verticalAlign(EAlignmentBaseline.top)
                    width(200.px)
                }

            }

        }

    }

//---------------------------------------------------------------------------------------------------------------------
