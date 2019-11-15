package ca.six.tests.books.art

import org.junit.Assert.*
import org.junit.Test


class AdderTest {
    @Test
    fun sum_byDefault_returnZero() {
        val result = adder().sum()
        assertEquals(0, result)
    }

    @Test
    fun add_WhenCalled_changeSum() {
        val obj = adder()
        obj.add(10)
        obj.add(3)
        assertEquals(13, obj.sum())
    }

    private fun adder(): Adder {
        return Adder()
    }
}