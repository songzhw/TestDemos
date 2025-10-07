package cn.six.appium.and

import android.os.Bundle
import cn.six.appium.and.core.BasePage

class HomePage : BasePage() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.af_home)
    }
}