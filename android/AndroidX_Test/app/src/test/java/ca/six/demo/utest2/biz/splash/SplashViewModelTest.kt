package ca.six.demo.utest2.biz.splash

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import ca.six.demo.utest2.core.http.HttpEngine
import ca.six.demo.utest2.utils.LiveDataTestUtil
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import org.junit.Rule
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.ArgumentMatchers.*
import org.mockito.Mockito.*

@ExperimentalCoroutinesApi
class SplashViewModelTest {
    @get:Rule var instantExecutorRule = InstantTaskExecutorRule()
    private val testDispatcher = TestCoroutineDispatcher()

    @Test
    fun testStart() = runBlocking {
        val expected = "http://111.jpg"
        val mockHttp = mock(HttpEngine::class.java)
        `when`(mockHttp.request(anyString())).thenReturn("")
//        `when`(mockHttp.splash()).thenReturn(expected)

        val vm = SplashViewModel(testDispatcher)
        vm.http = mockHttp
        vm.start()

        val img = LiveDataTestUtil.getValue(vm.imageLive)
        assertEquals(expected, img)
    }
}
