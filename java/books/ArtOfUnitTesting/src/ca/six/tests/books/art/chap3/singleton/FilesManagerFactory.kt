package ca.six.tests.books.art.chap3.singleton;

import ca.six.tests.books.art.chap3.FilesManager;

object FilesManagerFactory {
    fun create(): FilesManager {
        return FilesManager()
    }
}
