package ca.six.tests.books.art.chap3.singleton

import ca.six.tests.books.art.chap3.FilesManager
import org.junit.Assert.*
import org.junit.Ignore
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock


class LogAnalyzerTest {

    /*
org.mockito.exceptions.base.MockitoException:
Cannot mock/spy class ca.six.tests.books.art.chap3.singleton.FilesManagerFactory
Mockito cannot mock/spy because :
 - final class
     */

    @Ignore
    @Test
    fun isValidLogName_nameSupportedExtension_returnTrue() {
        val fileName = "one.slf"

        val fakeMgr = mock(FilesManager::class.java)
        `when`(fakeMgr.isValid(fileName)).thenReturn(true)

        val mock = mock(FilesManagerFactory::class.java)
        `when`(mock.create()).thenReturn(fakeMgr)

        val target = LogAnalyzer()
        val ret = target.isValidLogName(fileName)
        assertTrue(ret)
    }
}