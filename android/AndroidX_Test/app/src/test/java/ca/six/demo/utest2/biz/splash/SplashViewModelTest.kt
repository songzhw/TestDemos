package ca.six.demo.utest2.biz.splash

import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import org.junit.Test


class SplashViewModelTest {
    private val testDispatcher = TestCoroutineDispatcher()

    @Test
    fun testStart() = runBlocking {
        val vm = SplashViewModel(testDispatcher)
        vm.start()
    }
}
