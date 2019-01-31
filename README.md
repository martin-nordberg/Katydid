# Katydid
A virtual DOM for Kotlin. A statically typed HTML-generating DSL.

Overview
--------
Katydid is still in progress, but its aim is to work much like kotlinx.html but for the browser
with a virtual DOM. Katydid-VDOM includes an API that lets it participate in an Elm-like architecture,
or it can be used as part of any architecture needing a virtual DOM with a build/patch/patch/...
lifecycle.

Here is a hello-world Katydid application:

```kotlin
/**
 * Top-level component to build the virtual DOM for the Hello World application.
 */
val helloWorldView = katydid<Unit> {

    // This top level element replaces the "#app" div in helloworld.html.
    div("#hello-world-app") {

        // Elements can have in-line styles ...
        h1("#heading", style = "color:blue") {
            text("Hello World")
        }

        // ... or can reference CSS classes (see helloworld.html).
        span("#greeting.span-greeting") {
            text("Greetings from a Kotlin sample application.")
        }

    }

}

/**
 * Runs the Hello World application.
 */
@Suppress("UNUSED_PARAMETER")
fun helloWorldMain(args: Array<String>) {

    // Establish a Katydid lifecyle (Unit means no messages from user input).
    val lifecycle = makeKatydidLifecycle<Unit>()

    // Find the placeholder application element in helloworld.html.
    val appElement = document.getElementById("app")

    if (appElement != null) {
        // This is a minimal use of the Katydid lifecyle: build the virtual DOM and copy it to the real DOM just
        // once. See more advanced samples for the realistic scenario of updating the virtual and real DOMs in
        // response to user input.
        lifecycle.build(appElement, helloWorldView)
    }
    else {
        console.log("ERROR: Application element div#app not found.")
    }

    console.log("DONE")

}
```

The idea is that a view function generates the HTML of the bulk of a page using a Kotlin
builder-style DSL for HTML. With this DSL many HTML constraints are statically typed.
For example, it is not possible to create a `<tr>` element except inside a `<table>`, 
`<thead>`, or `<tbody>` element. Other constraints are beyond what can be done statically
so are enforced at run time. For example, declaring a `<form>` nested inside a `<form>`
will throw an exception.

So far this is much like kotlinx.html. The difference is that Katydid is aimed to support
a VDOM with event-driven updates to the HTML via patches between VDOM and real DOM.

In addition to its VDOM subsystem, Katydid includes the ability to generate CSS from 
Kotlin DSL code. That gives static typing for the styles and SASS-like nesting or extension
of styles. For example,
```kotlin
val css = makeStyleSheet(
    "nav" or "td" or "th" {
        fontSize(10.pt)
        fontStyle(EFontStyle.italic)

        "&.quirky" {

            maxWidth(45.px)

            "div" or "span" {
                color(green)
            }

        }

    }
).toString()
```
results in this CSS:
```css
nav,
td,
th {
    font-size: 10pt;
    font-style: italic;
}

nav.quirky,
td.quirky,
th.quirky {
    max-width: 45px;
}

nav.quirky div,
nav.quirky span,
td.quirky div,
td.quirky span,
th.quirky div,
th.quirky span {
    color: green;
}
```

Status
------
* Katydid-VDOM is pretty mature with a few specialized HTML elements to go.
* Katydid-CSS is much more a work in progress.
* Katydid Events (to be like React's synthetic events) is least developed.
* Integration among the subsystems and documentation are also very much TBD. 

Explore
-------
* Start with the Katydid samples here: 

    https://github.com/martin-nordberg/Katydid/tree/master/Katydid-Samples/src/main/kotlin/js/katydid/samples

* If the ideas strike an interest, stop back to watch the progress or contact me to help out.
