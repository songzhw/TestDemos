package ca.six.demo.utest2

import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import ca.six.demo.utest2.biz.items.ItemsActivity
import org.junit.After
import org.junit.Before
import org.junit.runner.RunWith

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


}