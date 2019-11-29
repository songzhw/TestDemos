package ca.six.tests.books.art.chap4

import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*
import kotlin.test.assertEquals

class LogAnalyzerTest {
    lateinit var mockWeb: WebService
    lateinit var mockEmail: Email

    @Before
    fun initEach() {
        mockWeb = mock(WebService::class.java)
        mockEmail = mock(Email::class.java)
    }

    @Test
    fun isValidLogName_webServiceThrows_returnFalse() {
        `when`(mockWeb.logError(anyString())).thenThrow(RuntimeException("hello"))
        val target = LogAnalyzer4(mockWeb, mockEmail)
        val value = target.isValidLogName(".ac")
        assertEquals(false, value)
    }

    @Test
    fun isValidLogName_webServiceThrows_sendEmail() {
        `when`(mockWeb.logError(anyString())).thenThrow(RuntimeException("hello"))
        val target = LogAnalyzer4(mockWeb, mockEmail)
        target.isValidLogName(".ac");
        verify(mockEmail).bing()
    }

}