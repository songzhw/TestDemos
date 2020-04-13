package ca.six.demo.utest2

import androidx.lifecycle.MutableLiveData
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import ca.six.demo.utest2.biz.items.ItemsActivity
import ca.six.demo.utest2.biz.items.ItemsViewModel
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

@RunWith(AndroidJUnit4::class)
class ItemsActivityTest {

    lateinit var scenario: ActivityScenario<ItemsActivity>

    @Before
    fun setup() {
        scenario = ActivityScenario.launch(ItemsActivity::class.java)
    }

    @After
    fun clean() {
        scenario.close()
    }

    @Test
    fun clickButton_tvShouldChange() {
        val vm = mock(ItemsViewModel::class.java)
        //val liveData = mock(MutableLiveData::class.java) //fail to use, due to generics
        val liveData = MutableLiveData<String>()
        `when`(vm.nameLiveData).thenReturn(liveData)

        onView(withId(R.id.tvItems))
            .check(matches(withText("ItemsActivity")))

        liveData.postValue("D200")

        onView(withId(R.id.tvItems))
            .check(matches(withText("D200")))
    }
}