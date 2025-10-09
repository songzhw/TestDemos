package cn.six.appium.and

import android.os.Bundle
import cn.six.appium.and.biz.Cart
import cn.six.appium.and.core.BasePage
import cn.six.appium.and.databinding.AfDetailsBinding

// img, tv, edittext,
class DetailPage: BasePage() {
    private lateinit var vb: AfDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = AfDetailsBinding.inflate(layoutInflater)
        setContentView(vb.root)

        val title = intent.getStringExtra("title") ?: return
        val imageResId = intent.getIntExtra("img", 0)
        vb.tvName.text = title
        vb.ivProduct.setImageResource(imageResId)
        vb.etCount.setText(Cart.map.getOrDefault(title, 0).toString())
        vb.fabSave.setOnClickListener {
            val count = vb.etCount.text.toString().toInt()
            if(count > 0) {
                Cart.map[title] = count
            } else {
                Cart.map.remove(title)
            }
        }

    }
}