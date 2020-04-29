package ca.six.demo.utest2.biz.itemdetail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import ca.six.demo.utest2.utils.LiveDataTestUtil
import ca.six.demo.utest2.utils.MainCoroutineRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class ItemDetailViewModelTest {
    @get:Rule var instantExecutorRule = InstantTaskExecutorRule()
    @get:Rule var mainCoroutineRule = MainCoroutineRule()

    @Test
    fun test() {
        val vm = ItemDetailViewModel()
        vm.start()

        val event = LiveDataTestUtil.getValue(vm.textLive)
        assertEquals("hello", event)
    }
}