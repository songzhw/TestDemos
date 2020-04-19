package ca.six.demo.utest2

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ActivityScenario.launch
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import ca.six.demo.utest2.temp.RobolectricTestSrcActivity
import ca.six.demo.utest2.core.MyObservable
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

@RunWith(AndroidJUnit4::class)
class RobolectricTestSrcActivityTest {
    lateinit var scenario: ActivityScenario<RobolectricTestSrcActivity>

    @Before
    fun setup() {
        scenario = launch(RobolectricTestSrcActivity::class.java)
    }

    @After
    fun clean() {
        // ActivityScenario does not clean up device state and may leave the activity keep running after the test finishes
        // Calling close() in the test is highly recommended.
        scenario.close()
    }


    @Test
    fun testTextViewValue() {
        launch(RobolectricTestSrcActivity::class.java)

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


    @Test
    fun destroyActivity_listenerShouldBeUngreisted() {
        val observer = mock(MyObservable::class.java)
        val scenario = launch(RobolectricTestSrcActivity::class.java)
        // 初始时不为空
        scenario.onActivity { actv -> actv.observable = observer }

        scenario.moveToState(Lifecycle.State.DESTROYED)

        // verify(observer).empty() // fail. 这是期望的
        verify(observer).removeListener() //succ. 这也是期望的
    }

    // TODO activity result

    // TODO 传参数, 到本Actv/下一个Actv

    // TODO 测试onSaveInstanceState()
}