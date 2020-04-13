package ca.six.demo.utest2

import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ActivityScenario.launch
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import ca.six.demo.utest2.biz.main.MainActivity
import org.junit.After
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    lateinit var scenario: ActivityScenario<MainActivity>

    @Before
    fun setup() {
        scenario = launch(MainActivity::class.java)
    }

    @After
    fun clean() {
        // ActivityScenario does not clean up device state and may leave the activity keep running after the test finishes
        // Calling close() in the test is highly recommended.
        scenario.close()
    }


    @Test
    fun testTextViewValue() {
        launch(MainActivity::class.java)

        onView(withId(R.id.tvMain))
            .check(matches(withText("MainActivity")))
    }

    @Test
    fun recreateActivity_inputTestShouldRetainedAfterThat() {
        val name = "songzhw"


        onView(withId(R.id.etMain))
            .perform(typeText(name))

        // destroy and recreate Activity
        scenario.recreate()

        onView(withId(R.id.etMain))
            .check(matches(withText(name)))
    }

    //TODO
    @Test
    fun recreateActivity_dataSaved() {
        // onSaveInstanceState()
    }

    @Rule
    val rule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun destroyActivity_listenerShouldBeUngreisted() {
        val actv = rule.activity
        assertNotNull(actv.observable.listener)
    }

    //TODO activity result
}