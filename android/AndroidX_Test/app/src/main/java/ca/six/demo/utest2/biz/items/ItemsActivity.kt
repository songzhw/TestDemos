package ca.six.demo.utest2.biz.items

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.*
import ca.six.demo.utest2.R
import kotlinx.android.synthetic.main.activity_item_list.*
import kotlin.concurrent.thread

class ItemsActivity : AppCompatActivity(R.layout.activity_item_list) {
    //val vm by viewModels<ItemsViewModel>()
    lateinit var vm: ItemsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        vm = ViewModelProvider(this).get(ItemsViewModel::class.java)

        btnItems.setOnClickListener { vm.fetchName() }

        vm.nameLiveData.observe(this, Observer { value ->
            println("szw here here")
            tvItems.text = value
        })
    }

}

//open class ItemsViewModel(val saver: SavedStateHandle) : ViewModel() {
open class ItemsViewModel : ViewModel() {
//    private val key_name = "my_name"
//    fun setName(name: String) = saver.set(key_name, name)
//    fun getName() = saver.getLiveData<String>(key_name)

    open val nameLiveData = MutableLiveData<String>()

    fun fetchName() {
        thread {
            Thread.sleep(2000)
            nameLiveData.postValue("szw")
        }.start()
    }

}