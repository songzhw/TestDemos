package ca.six.demo.utest2.utils

import android.app.Activity
import android.content.Intent

inline fun <reified T : Activity> Activity.nav() {
    startActivity(Intent(this, T::class.java))
}