package cn.six.appium.and.ext

import android.app.Activity
import android.content.Intent
import android.os.Bundle

inline fun <reified T : Activity> Activity.nav(data: Bundle? = null, flags : Int = -1) {
    val it = Intent(this, T::class.java)
    if(data != null) it.putExtras(data)
    if(flags != -1) it.addFlags(flags)
    startActivity(it)
}