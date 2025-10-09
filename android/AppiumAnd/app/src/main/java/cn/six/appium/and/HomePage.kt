package cn.six.appium.and

import android.os.Bundle
import cn.six.appium.and.core.BasePage

// 有多个页, 有img, 有button, 有editText, 有drawer,
// 有recyclerView (查找某item; 要滑动才能找到某item),
class HomePage : BasePage() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.af_home)

    }
}