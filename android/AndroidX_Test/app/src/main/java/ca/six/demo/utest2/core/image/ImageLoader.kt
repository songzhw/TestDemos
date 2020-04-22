package ca.six.demo.utest2.core.image

import android.widget.ImageView
import com.squareup.picasso.Picasso

open class ImageLoader {
    open fun load(iv: ImageView?, url: String?) {
        Picasso.get().load(url).into(iv)
    }
}