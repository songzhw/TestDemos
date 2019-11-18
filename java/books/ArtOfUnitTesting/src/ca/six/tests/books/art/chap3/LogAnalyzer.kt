package ca.six.tests.books.art.chap3

import java.io.File

class FilesManager {
    fun isValid(fileName: String?): Boolean {
        require(!(fileName == null || fileName == "")) {
            "fileName has to be provided. Now it's empty"
        }

        val file = File(fileName)
        return file.exists()
    }
}

class LogAnalyzer {
    fun isValidLogName(fileName: String): Boolean {
        val isExist = FilesManager().isValid(fileName)
        return isExist and fileName.endsWith(".slf")
    }
}