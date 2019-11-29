package ca.six.tests.books.art.chap4

open class Email {
    open fun sendEmail(msg: String) {}
    open fun bing() {}
}

open class WebService {
    open fun logError(error: String) {}
}


class LogAnalyzer4(private val service: WebService, private val email: Email) {

    fun isValidLogName(fileName: String): Boolean {
        if (fileName.length < 4) {
            try {
                service.logError("filename too short: $fileName")
            } catch (e: Exception) {
                email.sendEmail(e.message ?: "")
                return false
            }
        }
        return fileName.endsWith(".log")
    }

}