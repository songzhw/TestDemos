package ca.six.demo.utest2.biz.itemdetail

import ca.six.demo.utest2.utils.LiveDataTestUtil
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class ItemDetailViewModelTest {
    @Test
    fun test() = runBlocking{
        val vm = ItemDetailViewModel()
        vm.start()

        val event = LiveDataTestUtil.getValue(vm.textLive)
        println(event)
    }
}