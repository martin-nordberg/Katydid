//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.kotlgen.filesystem

import i.katydid.kotlgen.filesystem.InMemorySourceFolder

//---------------------------------------------------------------------------------------------------------------------

interface SourceFolder {

    val files: Iterable<SourceFile>

    val folders: Iterable<SourceFolder>

    val name: String

    ////

    fun addFile(name: String): SourceFile

}

//---------------------------------------------------------------------------------------------------------------------

fun makeInMemoryFolder(name: String): SourceFolder =
    InMemorySourceFolder(name)

//---------------------------------------------------------------------------------------------------------------------

