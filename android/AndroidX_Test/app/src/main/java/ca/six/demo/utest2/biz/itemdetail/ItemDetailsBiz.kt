package ca.six.demo.utest2.biz.itemdetail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import ca.six.demo.utest2.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_item_detail.*

class ItemDetailsActivity : AppCompatActivity(R.layout.activity_item_detail) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val name = intent.getStringExtra("name")
        val image = intent.getStringExtra("img")
        tvItemDetail.text = name
//        Picasso.get().load(image).into(ivItemDetail)

    }
}

class ItemDetailViewModel : ViewModel() {
    fun start() {

    }
}