package ca.six.demo.utest2.utils

import android.app.Activity
import android.content.Intent
import android.view.View
import androidx.core.app.ActivityOptionsCompat
import ca.six.demo.utest2.biz.itemdetail.ItemDetailsActivity
import androidx.core.util.Pair

inline fun <reified T : Activity> Activity.nav() {
    startActivity(Intent(this, T::class.java))
}

inline fun <reified T : Activity> Activity.nav(arg: Map<String, Any>) {
    val it = getIntentWithArgs<T>(arg)
    startActivity(it)
}

inline fun <reified T: Activity> Activity.nav(arg: Map<String, Any>, vararg pairs: Pair<View, String>){
    val opt = ActivityOptionsCompat.makeSceneTransitionAnimation(this, *pairs)
    val it = getIntentWithArgs<T>(arg)
    startActivity(it, opt.toBundle())
}

inline fun <reified T: Activity>  Activity.getIntentWithArgs(arg: Map<String, Any>): Intent {
    val it = Intent(this, T::class.java)
    for ((key, value) in arg) {
        if (value is Int) it.putExtra(key, value)
        if (value is String) it.putExtra(key, value)
        if (value is Boolean) it.putExtra(key, value)
    }
    return it
}