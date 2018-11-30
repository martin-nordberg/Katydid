//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.kotlgen.model.structure

import o.katydid.kotlgen.model.annotations.KgAnnotated
import o.katydid.kotlgen.model.core.KgCodeElement
import o.katydid.kotlgen.model.core.KgComposite
import o.katydid.kotlgen.model.core.documentation.KgDocumented
import o.katydid.kotlgen.model.core.names.KgNamed
import o.katydid.kotlgen.model.core.names.KgQualifiedName

//---------------------------------------------------------------------------------------------------------------------

interface KgSourceFile
    : KgCodeElement, KgDocumented, KgAnnotated, KgNamed, KgTopLevelDeclaring, KgComposite, KgImporting {

    val packageQualifiedName: KgQualifiedName

    val qualifiedName: KgQualifiedName

    ////

    operator fun invoke(revise: KgSourceFile.() -> Unit) =
        this.revise()

}

//---------------------------------------------------------------------------------------------------------------------

