package ca.six.tests.books.art.chap3

import java.io.File

open class FilesManager {
    open fun isValid(fileName: String?): Boolean {

        require(!(fileName == null || fileName == "")) {
            "fileName has to be provided. Now it's empty"
        }

        val file = File(fileName)
        return file.exists()
    }
}

class LogAnalyzer(val fileMgr: FilesManager) {
    fun isValidLogName(fileName: String): Boolean {
        val isExist = fileMgr.isValid(fileName)
        return isExist and fileName.endsWith(".slf")
    }
}