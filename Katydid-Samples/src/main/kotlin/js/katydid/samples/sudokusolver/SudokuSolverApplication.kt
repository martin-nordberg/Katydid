//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package js.katydid.samples.sudokusolver

import js.katydid.css.buildStyleElement
import js.katydid.vdom.api.KatydidApplication
import js.katydid.vdom.api.runApplication
import o.katydid.css.colors.*
import o.katydid.css.measurements.px
import o.katydid.vdom.builders.KatydidFlowContentBuilder
import o.katydid.css.stylesheets.styleSheet
import o.katydid.css.types.*
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

    val css = makeStyleSheet()

    val cssElement = document.getElementById("appStyleElement")!!

    buildStyleElement( cssElement, css )

    runApplication(
        "app",
        SudokuSolverApplication()
    )

}

//---------------------------------------------------------------------------------------------------------------------

fun makeStyleSheet() =
    styleSheet {

        /* BODY */
        "body" {
            fontFamily("Arial", "Helvetica Neue", "Helvetica", "sans-serif")
        }

        /* SECTION */
        "section" {
            display(EDisplayOption.inlineBlock)
            float(EFloatOption.left)
        }

        "section#changes" {
            maxHeight(850.px)
            overflowY(EOverflowOption.scroll)
        }

        "section#settings, section#notes" {
            clear(EClearOption.both)
            marginTop(15.px)
            maxWidth(700.px)
        }

        "section#settings fieldset" {
            borderStyle(EBorderStyleOption.none);
            margin(3.px, 3.px, 3.px, 3.px)
        }

        /* TABLE */
        "table" {
            borderCollapse(EBorderCollapseOption.collapse)
            borderSpacing(0.px)
            padding(0.px)
        }

        "table.board" {
            border(3.px, EBorderStyleOption.solid, black)
        }

        "table.block" {
            border(2.px, EBorderStyleOption.solid, black)
        }

        "table.block td.cell" {
            border(1.px, EBorderStyleOption.solid, black)
            borderCollapse(EBorderCollapseOption.collapse)
            borderSpacing(0.px)
            fontSize(50.px)
            height(66.px)
            padding(3.px)
            textAlign(ETextAlignOption.center)
            width(66.px)
        }

        "table.block td.cell.guessed" {
            color(blue)
        }

        "table.block td.cell.solved" {
            color(green)
        }

        "table.block td.cell.guessed:hover, table.block td.cell.defined:hover" {
            color(purple)
            cursor(ECursorOption.pointer)
            textDecoration(ETextDecorationOption.underline)
        }

        "table.block td.cell.unfillable" {
            backgroundColor(pink)
        }

        "table.candidates td" {
            fontSize(12.px)
            height(20.px)
            width(20.px)
        }

        "table.candidates td.candidate:hover" {
            color(blue)
            cursor(ECursorOption.pointer)
            textDecoration(ETextDecorationOption.underline)
        }

        "table.changes tr:nth-child(even)" {
            backgroundColor(Color.fromHex("#f2f2f2")!!)
        }

        "table.changes th.candidates-removed, table.changes td.candidates-removed" {
            fontSize(15.px)
            textAlign(ETextAlignOption.left)
            verticalAlign(EAlignmentBaselineOption.top)
            width(450.px)
        }

        "table.changes th.cell-value-set, table.changes td.cell-value-set" {
            textAlign(ETextAlignOption.left)
            verticalAlign(EAlignmentBaselineOption.top)
            width(100.px)
        }

        "table.changes th.change-description, table.changes td.change-description" {
            textAlign(ETextAlignOption.left)
            verticalAlign(EAlignmentBaselineOption.top)
            width(200.px)
        }

    }

//---------------------------------------------------------------------------------------------------------------------
