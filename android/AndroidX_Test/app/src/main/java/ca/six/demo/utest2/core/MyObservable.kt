package ca.six.demo.utest2.core

interface IListener {
    fun onObservableChange()
}

class MyObservable(var listener: IListener?) {
    fun removeListener() {
        this.listener = null
    }
}