package ca.six.tests.books.art.chap4

import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*

class LogAnalyzerTest {
    lateinit var mockWeb: WebService
    lateinit var mockEmail: Email

    @Before
    fun initEach() {
        mockWeb = mock(WebService::class.java)
        mockEmail = mock(Email::class.java)
    }

    @Test
    fun isValidLogName_webServiceThrows_sendEmail() {
        `when`(mockWeb.logError(anyString())).thenThrow(RuntimeException("hello"))
        val target = LogAnalyzer(mockWeb, mockEmail)
        val value = target.isValidLogName(".ac")
        verify(mockWeb).bang()
    }
}