package ca.six.demo.utest2

import androidx.test.core.app.ActivityScenario
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
        `when`(vm.fetchName()).thenReturn("2323")
    }
}