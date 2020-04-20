package ca.six.demo.utest2.biz.home

import ca.six.demo.utest2.core.http.HttpEngineWithIO
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class HomeViewModelTest {
    // 因为没有viewScope.launch, 直接连InstantTaskExecutorRule都不有需要了

    @Test
    fun callHome_shouldGetMotto() = runBlocking {
        val expected = "abcd1234"
        val mockHttp = mock(HttpEngineWithIO::class.java)
        `when`(mockHttp.home()).thenReturn(expected)

        val vm = HomeViewModel()
        vm.http = mockHttp
        val result = vm.home()

        assertEquals(expected, result)
    }
}