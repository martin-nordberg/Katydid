//
// (C) Copyright 2017-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.vdom.infrastructure

//---------------------------------------------------------------------------------------------------------------------

/**
 * Implementation of MutableSet<T> that throws an error for every operation.
 */
internal class UnusedSet<T> : MutableSet<T> {

    override val size: Int
        get() = throw UnsupportedOperationException("Attempted to use unused set.")

    ////

    override fun add(element: T): Boolean {
        throw UnsupportedOperationException("Attempted to use unused set.")
    }

    override fun addAll(elements: Collection<T>): Boolean {
        throw UnsupportedOperationException("Attempted to use unused set.")
    }

    override fun clear() {
        throw UnsupportedOperationException("Attempted to use unused set.")
    }

    override fun contains(element: T): Boolean {
        throw UnsupportedOperationException("Attempted to use unused set.")
    }

    override fun containsAll(elements: Collection<T>): Boolean {
        throw UnsupportedOperationException("Attempted to use unused set.")
    }

    override fun isEmpty(): Boolean {
        throw UnsupportedOperationException("Attempted to use unused set.")
    }

    override fun iterator(): MutableIterator<T> {
        throw UnsupportedOperationException("Attempted to use unused set.")
    }

    override fun remove(element: T): Boolean {
        throw UnsupportedOperationException("Attempted to use unused set.")
    }

    override fun removeAll(elements: Collection<T>): Boolean {
        throw UnsupportedOperationException("Attempted to use unused set.")
    }

    override fun retainAll(elements: Collection<T>): Boolean {
        throw UnsupportedOperationException("Attempted to use unused set.")
    }

}

//---------------------------------------------------------------------------------------------------------------------

