package ca.six.demo.utest2.biz.items

import androidx.lifecycle.ViewModel
import ca.six.demo.utest2.core.data.ItemData
import ca.six.demo.utest2.core.http.HttpEngineWithIO

class ItemsViewModel : ViewModel() {
    var http = HttpEngineWithIO()

    suspend fun start(): ArrayList<ItemData> {
        val items = http.items()
        return items.items
    }
}