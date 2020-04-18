package ca.six.demo.utest2.temp

class WhenThenReturn {
    var obj = BeMocked1()
    var id = 0

    fun work() {
        id = obj.foo()
    }
}

open class BeMocked1 {
    open fun foo(): Int {
        println("szw B foo()")
        return bar()
    }

    fun bar(): Int {
        println("szw B bar")
        return 30
    }
}

