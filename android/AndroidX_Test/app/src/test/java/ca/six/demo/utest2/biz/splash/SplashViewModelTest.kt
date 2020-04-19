package ca.six.demo.utest2.biz.splash

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import ca.six.demo.utest2.core.http.HttpEngine
import ca.six.demo.utest2.utils.LiveDataTestUtil
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

@ExperimentalCoroutinesApi
class SplashViewModelTest {
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()
    private val testDispatcher = TestCoroutineDispatcher()

    @Test
    fun startSplash_shouldGetImageFromHttp() {
        val expected = "http://111.jpg"
        val mockHttp = mock(HttpEngine::class.java)
        `when`(mockHttp.splash()).thenReturn(expected)
        // doReturn(expected).`when`(mockHttp).splash()

        // val vm = SplashViewModel(testDispatcher)
        val vm = SplashViewModel()
        vm.http = mockHttp
        vm.start()

        val img = LiveDataTestUtil.getValue(vm.imageLive)
        assertEquals(expected, img)
    }

    @Test
    fun startSplash_shouldNavToNextPage() {
        val mockHttp = mock(HttpEngine::class.java)
        `when`(mockHttp.splash()).thenReturn("")

        val vm = SplashViewModel(testDispatcher)
        vm.http = mockHttp
        vm.start()

        val event = LiveDataTestUtil.getValue(vm.navigationEvent)
        assertNotNull(event)
    }
}
