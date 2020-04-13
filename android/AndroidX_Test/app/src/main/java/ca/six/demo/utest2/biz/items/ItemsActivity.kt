package ca.six.demo.utest2.biz.items

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import ca.six.demo.utest2.R
import kotlinx.android.synthetic.main.activity_item_list.*
import kotlin.concurrent.thread

class ItemsActivity : AppCompatActivity(R.layout.activity_item_list) {
    val vm by viewModels<ItemsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        btnItems.setOnClickListener { vm.fetchName() }

        vm.nameLiveData.observe(this,
            Observer { value -> tvItems.text = value })
    }

}

open class ItemsViewModel(val saver: SavedStateHandle) : ViewModel() {
    private val key_name = "my_name"
    fun setName(name: String) = saver.set(key_name, name)
    fun getName() = saver.getLiveData<String>(key_name)

    val nameLiveData = MutableLiveData<String>()

    fun fetchName() {
        thread {
            Thread.sleep(2000)
            nameLiveData.postValue("szw")
        }.start()
    }

}