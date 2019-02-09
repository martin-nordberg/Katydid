//
// (C) Copyright 2017-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.vdom.types

//---------------------------------------------------------------------------------------------------------------------

sealed class ContentType

object EmbeddedContent : ContentType()

object FlowContent : ContentType()

object PhrasingContent: ContentType()

//---------------------------------------------------------------------------------------------------------------------


