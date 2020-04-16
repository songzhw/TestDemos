package ca.six.demo.utest2.biz.splash

import ca.six.demo.utest2.utils.CoroutineTestRule
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test


class SplashViewModelTest {
    @get:Rule
    val rule = CoroutineTestRule()

    @Test
    fun testStart() = runBlocking {
        val vm = SplashViewModel()
        vm.start()
    }
}
