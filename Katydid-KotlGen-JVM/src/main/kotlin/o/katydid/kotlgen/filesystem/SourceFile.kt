//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.kotlgen.filesystem

import java.io.Reader
import java.io.Writer

//---------------------------------------------------------------------------------------------------------------------

interface SourceFile {

    val name: String

    fun getReader(): Reader

    fun getWriter(): Writer

}

//---------------------------------------------------------------------------------------------------------------------

