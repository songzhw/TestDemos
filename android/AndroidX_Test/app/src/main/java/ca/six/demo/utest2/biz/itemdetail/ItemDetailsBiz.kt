package ca.six.demo.utest2.biz.itemdetail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ca.six.demo.utest2.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_item_detail.*
import kotlinx.coroutines.launch

class ItemDetailsActivity : AppCompatActivity(R.layout.activity_item_detail) {
//    lateinit var imageLoader: ImageLoader

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val name = intent.getStringExtra("name")
        val image = intent.getStringExtra("img")

        tvItemDetail.text = name
//        imageLoader = ImageLoader()
//        imageLoader.load(ivItemDetail, image)
        Picasso.get().load(image).into(ivItemDetail)
    }
}

class ItemDetailViewModel : ViewModel() {
    val textLive = MutableLiveData<String>()

    fun start() {
        viewModelScope.launch {
            textLive.postValue("hello")
        }
    }
}