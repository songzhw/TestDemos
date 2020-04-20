package ca.six.demo.utest2.biz.items

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ca.six.demo.utest2.R

class ItemsActivity : AppCompatActivity(R.layout.activity_items) {
    lateinit var vm: ItemsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm = ViewModelProvider(this).get(ItemsViewModel::class.java)
    }
}

class ItemsViewModel : ViewModel() {

}