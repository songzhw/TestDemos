package ca.six.demo.utest2.biz.items

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import ca.six.demo.utest2.R
import ca.six.demo.utest2.core.http.HttpEngineWithIO
import kotlinx.coroutines.launch

class ItemsActivity : AppCompatActivity(R.layout.activity_items) {
    lateinit var vm: ItemsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm = ViewModelProvider(this).get(ItemsViewModel::class.java)

        lifecycleScope.launch {
            vm.start()
        }
    }
}

class ItemsViewModel : ViewModel() {
    var http = HttpEngineWithIO()

    suspend fun start() {
        val items = http.items()
        println("szw $items")
    }
}