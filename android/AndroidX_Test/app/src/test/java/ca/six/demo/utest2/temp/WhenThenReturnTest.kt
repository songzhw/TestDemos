package ca.six.demo.utest2.temp

import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class WhenThenReturnTest {
    @Test
    fun testWhenThenReturn1() {
        var mocked = mock(BeMocked1::class.java)
        `when`(mocked.foo()).thenReturn(333)

        val obj = WhenThenReturn()
        obj.work()

        assertEquals(333, obj.id)

    }
}