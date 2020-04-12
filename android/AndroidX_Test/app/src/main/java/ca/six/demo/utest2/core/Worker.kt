package ca.six.demo.utest2.core

open class Worker {
    open fun workSync(id: Int): String {
        return "work.$id"
    }

    fun workAsync(id: Int): String {
        // TODO coroutine
        return ""
    }

}