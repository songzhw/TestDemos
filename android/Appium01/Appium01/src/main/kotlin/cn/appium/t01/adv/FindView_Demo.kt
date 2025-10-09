package cn.appium.t01.adv

import io.appium.java_client.AppiumBy
import io.appium.java_client.AppiumDriver
import io.appium.java_client.remote.options.BaseOptions
import java.net.URI

fun main() {
    val options = BaseOptions()
        .setPlatformName("Android")
        .setAutomationName("UiAutomator2")
        .amend("udid", "emulator-5554") // UDID: 设备级别的唯一标识符;  这个id由`adb devices`中可得知设备id是什么, 却要运行测试到这个设备上
        .amend("app", "Downloads/apk/one.apk") // Appium Server说了, appium home path是~, 所以这里就不用写全路径了
    val driver = AppiumDriver(URI("http://127.0.0.1:4723").toURL(), options)
    //println("pageSource = ${driver.pageSource}") //用xml来描述整个页面的view hierarchy

    // 1. AppiumBy.className("包名.类名"): 会找到第一个匹配的view
    val firstTitle = driver.findElement(AppiumBy.className("android.widget.TextView")) //用className, 得全路径(包名+类包)

    // 2. 查找文本
        // 2.1 精确匹配文本

        // 2.2 模糊匹配文本

    // 3. 查找图片

    // 4. 查找ID

    // 5. 查找RecyclerView不在屏幕上的元素


    driver.quit()
    //el.click();  AppiumBy.xpath("...")
}