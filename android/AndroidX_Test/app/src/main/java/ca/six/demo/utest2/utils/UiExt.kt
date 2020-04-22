package ca.six.demo.utest2.utils

import android.app.Activity
import android.content.Intent

inline fun <reified T : Activity> Activity.nav() {
    startActivity(Intent(this, T::class.java))
}

inline fun <reified T : Activity> Activity.nav(arg: Map<String, Any>) {
    val it = Intent(this, T::class.java)
    for ((key, value) in arg) {
        if (value is Int || value is String) {
            it.putExtra(key, value)
        }
    }
    startActivity(it)
}