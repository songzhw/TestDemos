package ca.six.demo.utest2.biz.splash

import android.os.Looper.getMainLooper
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Shadows.shadowOf

@ExperimentalCoroutinesApi
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