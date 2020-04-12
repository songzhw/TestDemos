package ca.six.demo.utest2.core

open class Worker {
    fun workSync(id: Int): String {
        return "work.$id"
    }

    fun workAsync(id: Int): String {
        // TODO coroutine
        return ""
    }

}