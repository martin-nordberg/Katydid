
//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.events.types

//---------------------------------------------------------------------------------------------------------------------

interface KatydidMouseEvent : KatydidUiEvent {

    val altKey : Boolean

    val button : Short

    val buttons: Short

    val clientX: Int

    val clientY : Int

    val ctrlKey : Boolean

    val metaKey: Boolean

    val offsetX: Double

    val offsetY : Double

    val pageX: Double

    val pageY : Double

//    DOMEventTarget relatedTarget

    val screenX: Int

    val screenY : Int

    val shiftKey : Boolean

    ////

    fun getModifierState(key:String) : Boolean

}

//---------------------------------------------------------------------------------------------------------------------

