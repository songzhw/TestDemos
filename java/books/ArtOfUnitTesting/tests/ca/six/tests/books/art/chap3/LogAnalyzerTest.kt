package ca.six.tests.books.art.chap3

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations

class LogAnalyzerTest {

//    @Mock
//    lateinit var mock: FilesManager
//
//    @Before
//    fun initTests() {
//        MockitoAnnotations.initMocks(this)
//    }

    @Test
    fun isValidLogName_nameSupportedExtension_returnTrue() {
        val fileName = "one.txt"
        val mock = mock(FilesManager::class.java)
        `when`(mock.isValid(fileName)).thenReturn(false)

        val target = LogAnalyzer(mock)
        val ret = target.isValidLogName(fileName)

        assertFalse(ret)

    }
}