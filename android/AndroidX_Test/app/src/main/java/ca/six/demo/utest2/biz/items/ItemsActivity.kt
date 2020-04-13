package ca.six.demo.utest2.biz.items

import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import ca.six.demo.utest2.R

class ItemsActivity : AppCompatActivity(R.layout.activity_item_list) {
    val vm by viewModels<ItemsViewModel>()

}

class ItemsViewModel(val saver: SavedStateHandle) : ViewModel() {
    private val key_name = "my_name"

    fun setName(name: String) = saver.set(key_name, name)
    fun getName() = saver.getLiveData<String>(key_name)
}