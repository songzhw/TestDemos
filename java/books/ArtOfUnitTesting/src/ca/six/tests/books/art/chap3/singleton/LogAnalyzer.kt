package ca.six.tests.books.art.chap3.singleton


class LogAnalyzer() {
    fun isValidLogName(fileName: String): Boolean {
        val isExist = FilesManagerFactory.create().isValid(fileName)
        return isExist and fileName.endsWith(".slf")
    }
}