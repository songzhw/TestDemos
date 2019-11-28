package ca.six.tests.books.art.chap4

import org.junit.Test

class FakeEmail : Email()

class FakeWebService : WebService() {
    override fun logError(error: String) {
        if (!error.isEmpty()) {
            throw Exception(error)
        }
    }
}

class LogAnalyzerTest {
    @Test
    fun test() {
        val stubWebService = FakeWebService()
        val mockEmail = FakeEmail()
        val target = LogAnalyzer(stubWebService, mockEmail)
        target.isValidLogName(".ac")

    }
}