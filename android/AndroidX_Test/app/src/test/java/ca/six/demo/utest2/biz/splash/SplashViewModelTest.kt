package ca.six.demo.utest2.biz.splash

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import ca.six.demo.utest2.utils.LiveDataTestUtil
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class SplashViewModelTest {
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()
    private val testDispatcher = TestCoroutineDispatcher()

    @Test
    fun testStart() = runBlocking {
        val vm = SplashViewModel(testDispatcher)
        vm.start()

        val img = LiveDataTestUtil.getValue(vm.imageLive)
        assertEquals("https://twgreatdaily.com/images/elastic/5Pb/5Pbb4WwBJleJMoPMq0hU.jpg", img)
    }
}
