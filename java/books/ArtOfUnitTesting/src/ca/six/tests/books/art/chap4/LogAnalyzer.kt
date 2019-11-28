package ca.six.tests.books.art.chap4

open class Email {
    fun sendEmail(msg: String) {    }
}

open class WebService {
    open fun logError(error: String) {    }
}


class LogAnalyzer(val service: WebService, val email: Email) {

    fun isValidLogName(fileName: String): Boolean {
        if (fileName.length < 4) {
            try {
                service.logError("filename too short: $fileName")
            } catch (e: Exception) {
                email.sendEmail(e.message ?: "")
            }
        }
        return fileName.endsWith(".log")
    }

}