package ca.six.demo.utest2

import androidx.test.core.app.ActivityScenario.launch
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import ca.six.demo.utest2.biz.main.MainActivity
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Test
    fun testTextViewValue() {
        launch(MainActivity::class.java)

        onView(withId(R.id.tvMain))
            .check(matches(withText("MainActivity")))
    }

    @Test
    fun recreateActivity_inputTestShouldRetainedAfterThat() {
        val name = "songzhw"
        val scenario = launch(MainActivity::class.java)

        onView(withId(R.id.etMain))
            .perform(typeText(name))

        // destroy and recreate Activity
        scenario.recreate()

        onView(withId(R.id.etMain))
            .check(matches(withText(name)))
    }
}