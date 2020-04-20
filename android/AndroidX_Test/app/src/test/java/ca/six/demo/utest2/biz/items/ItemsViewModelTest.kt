package ca.six.demo.utest2.biz.items

import ca.six.demo.utest2.core.data.ItemsData
import ca.six.demo.utest2.core.http.HttpEngineWithIO
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito

class ItemsViewModelTest {

    @Test
    fun callHome_shouldGetMotto() = runBlocking {
        val expected = ItemsData("""{continue:false, items:[{id:"",name:"","img":""}]}""")
        val mockHttp = Mockito.mock(HttpEngineWithIO::class.java)
        Mockito.`when`(mockHttp.items()).thenReturn(expected)

        val vm = ItemsViewModel()
        vm.http = mockHttp
        val result = vm.start()

        assertEquals(1, result.size)
    }

}