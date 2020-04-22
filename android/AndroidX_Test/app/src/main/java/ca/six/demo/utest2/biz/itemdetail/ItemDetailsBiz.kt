package ca.six.demo.utest2.biz.itemdetail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import ca.six.demo.utest2.R
import ca.six.demo.utest2.core.image.ImageLoader
import kotlinx.android.synthetic.main.activity_item_detail.*

class ItemDetailsActivity : AppCompatActivity(R.layout.activity_item_detail) {
    lateinit var imageLoader: ImageLoader

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val name = intent.getStringExtra("name")
        val image = intent.getStringExtra("img")

        tvItemDetail.text = name
        imageLoader = ImageLoader()
        println("szw il = $imageLoader")
        imageLoader.load(ivItemDetail, image)

    }
}

class ItemDetailViewModel : ViewModel() {
    fun start() {

    }
}