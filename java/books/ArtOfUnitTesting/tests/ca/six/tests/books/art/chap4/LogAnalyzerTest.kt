package ca.six.tests.books.art.chap4

import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.any
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
    fun test() {
        `when`(mockWeb.logError(any(String::class.java))).thenThrow(Exception("hello"))
        val target = LogAnalyzer(mockWeb, mockEmail)
        target.isValidLogName(".ac")
        verify(mockEmail).sendEmail("xxx")
    }
}