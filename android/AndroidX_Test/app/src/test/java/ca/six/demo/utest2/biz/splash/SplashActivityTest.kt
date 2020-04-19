package ca.six.demo.utest2.biz.splash

import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SplashActivityTest {
    lateinit var scenario: ActivityScenario<SplashActivity>

    @Before
    fun setup() {
        scenario = ActivityScenario.launch(SplashActivity::class.java)
    }

    @After
    fun clean() {
        scenario.close()
    }

    @Test
    fun testActivity() {

    }
}