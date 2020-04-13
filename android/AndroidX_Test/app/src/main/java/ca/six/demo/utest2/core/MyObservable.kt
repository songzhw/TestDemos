package ca.six.demo.utest2.core

interface IListener {
    fun onObservableChange()
}

open class MyObservable(var listener: IListener?) {
    open fun removeListener() {
        this.listener = null
    }
    open fun empty(){}
}