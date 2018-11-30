//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.kotlgen.model.declarations

//---------------------------------------------------------------------------------------------------------------------

//internal class KgDeclarationScopeImpl(
//    override val name: KgName,
//    override var origin: KgOrigin
//) : KgDeclarationScope {
//
//    private val myEnumConstants = mutableListOf<KgEnumEntryImpl>()
//
//    private val myEnumConstantsByName = mutableMapOf<KgName, KgEnumEntryImpl>()
//
//    private val myModifiers = KgModifierList()
//
//    ////
//
//    override var doc: String? = null
//
//    override val enumEntries: List<KgEnumEntry>
//        get() = myEnumConstants.toList()
//
//    override val modifiers: KgModifierList
//        get() = myModifiers
//
//    ////
//
//    override fun mergeModifiers(modifiers: KgModifierList) =
//        myModifiers.add(modifiers)
//
//    override fun `enum entry`(itsName: String, build: KgEnumEntry.() -> Unit): KgEnumEntry =
//        `enum entry`(KgName(itsName), build)
//
//    override fun `enum entry`(itsName: KgName, build: KgEnumEntry.() -> Unit): KgEnumEntry {
//
//        var result = myEnumConstantsByName[itsName]
//
//        if (result == null) {
//            result = KgEnumEntryImpl(itsName)
//            myEnumConstants.add(result)
//            myEnumConstantsByName[itsName] = result
//        }
//
//        result.build()
//
//        return result
//
//    }
//
//}

//---------------------------------------------------------------------------------------------------------------------
