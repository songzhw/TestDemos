package ca.six.demo.utest2

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import ca.six.demo.utest2.biz.main.MainActivity
import ca.six.demo.utest2.core.Worker
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers
import org.mockito.ArgumentMatchers.any
import org.mockito.Mockito.*

@RunWith(AndroidJUnit4::class)
class MainActivityLogicTest {
    lateinit var scenario: ActivityScenario<MainActivity>

    @Before
    fun setup() {
        scenario = ActivityScenario.launch(MainActivity::class.java)
    }

    @After
    fun clean() {
        scenario.close()
    }

    @Test
    fun clickButton_textChangeText() {
        onView(withId(R.id.tvMain))
            .check(matches(withText("MainActivity")))

        onView(withId(R.id.btnMain))
            .perform(click())
        onView(withId(R.id.tvMain))
            .check(matches(withText("work.23")))
    }

    @Test
    fun clickButton_callWorker() {
        val worker = mock(Worker::class.java)
        `when`(worker.workSync(23)).thenReturn("mock000")
        scenario.onActivity { actv -> actv.worker = worker }

        onView(withId(R.id.btnMain))
            .perform(click())

        onView(withId(R.id.tvMain))
            .check(matches(withText("work.23")))
    }

}