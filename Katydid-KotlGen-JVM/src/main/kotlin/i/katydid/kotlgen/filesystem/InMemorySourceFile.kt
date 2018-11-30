//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.kotlgen.filesystem

import o.katydid.kotlgen.filesystem.SourceFile
import java.io.Reader
import java.io.StringReader
import java.io.StringWriter
import java.io.Writer

//---------------------------------------------------------------------------------------------------------------------

internal class InMemorySourceFile(
    override val name: String
) : SourceFile {

    private var content: String = ""

    ////

    override fun getReader(): Reader =
        StringReader(content)

    override fun getWriter(): Writer =
        object : StringWriter() {
            override fun close() {
                content = this.toString()
            }
        }

}

//---------------------------------------------------------------------------------------------------------------------

