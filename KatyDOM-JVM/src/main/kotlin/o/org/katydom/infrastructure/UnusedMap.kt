//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.org.katydom.infrastructure

//---------------------------------------------------------------------------------------------------------------------

/**
 * Implementation of MutableMap<K,V> that throws an exception for every operation.
 */
internal class UnusedMap<K, V> : MutableMap<K, V> {

    override val entries: MutableSet<MutableMap.MutableEntry<K, V>>
        get() = throw UnsupportedOperationException("Attempted to use unused map.")

    override val keys: MutableSet<K>
        get() = throw UnsupportedOperationException("Attempted to use unused map.")

    override val size: Int
        get() = throw UnsupportedOperationException("Attempted to use unused map.")

    override val values: MutableCollection<V>
        get() = throw UnsupportedOperationException("Attempted to use unused map.")

    ////

    override fun clear() {
        throw UnsupportedOperationException("Attempted to use unused map.")
    }

    override fun containsKey(key: K): Boolean {
        throw UnsupportedOperationException("Attempted to use unused map.")
    }

    override fun containsValue(value: V): Boolean {
        throw UnsupportedOperationException("Attempted to use unused map.")
    }

    override fun get(key: K): V? {
        throw UnsupportedOperationException("Attempted to use unused map.")
    }

    override fun isEmpty(): Boolean {
        throw UnsupportedOperationException("Attempted to use unused map.")
    }

    override fun put(key: K, value: V): V? {
        throw UnsupportedOperationException("Attempted to use unused map.")
    }

    override fun putAll(from: Map<out K, V>) {
        throw UnsupportedOperationException("Attempted to use unused map.")
    }

    override fun remove(key: K): V? {
        throw UnsupportedOperationException("Attempted to use unused map.")
    }

}

//---------------------------------------------------------------------------------------------------------------------

