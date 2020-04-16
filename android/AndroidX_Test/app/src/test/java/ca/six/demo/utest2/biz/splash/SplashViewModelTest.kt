package ca.six.demo.utest2.biz.splash

import kotlinx.coroutines.runBlocking
import org.junit.Test


class SplashViewModelTest {
    @Test
    fun testStart() = runBlocking {
        val vm = SplashViewModel()
        vm.start()
    }
}
