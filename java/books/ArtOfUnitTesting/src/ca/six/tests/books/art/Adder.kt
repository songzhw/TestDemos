package ca.six.tests.books.art

class Adder {
    private var sum = 0

    fun add(num: Int) {
        sum += num
    }

    // 求和, 并置0
    fun sum(): Int {
        val ret = sum
        sum = 0
        return ret
    }
}