//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.kotlgen.filesystem

import o.katydid.kotlgen.filesystem.SourceFile
import o.katydid.kotlgen.filesystem.SourceFolder

//---------------------------------------------------------------------------------------------------------------------

internal class InMemorySourceFolder(
    override val name: String
) : SourceFolder {

    private val myFiles = mutableListOf<InMemorySourceFile>()

    private val myFolders = mutableListOf<InMemorySourceFolder>()

    ////

    override val files: Iterable<SourceFile>
        get() = myFiles.toList()

    override val folders: Iterable<SourceFolder>
        get() = myFolders.toList()

    override fun addFile(name: String): SourceFile {
        val result = InMemorySourceFile(name)
        myFiles.add(result)
        return result
    }

}

//---------------------------------------------------------------------------------------------------------------------

