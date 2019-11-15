package ca.six.tests.books.art

import org.junit.Assert.*
import org.junit.Test


class AdderTest {
    @Test
    fun sum_byDefault_returnZero() {
        val result = adder().sum()
        assertEquals(0, result)
    }

    private fun adder(): Adder {
        return Adder()
    }
}