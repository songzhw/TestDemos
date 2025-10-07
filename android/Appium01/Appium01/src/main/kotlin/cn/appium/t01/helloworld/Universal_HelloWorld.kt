package cn.appium.t01.helloworld

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

    val el = driver.findElement(AppiumBy.className("android.widget.TextView")) //用className, 得全路径(包名+类包)
    println("tv = ${el.text}") //成功
    println("pageSource = ${driver.pageSource}") //用xml来描述整个页面的view hierarchy
    driver.quit()


    //el.click();  AppiumBy.xpath("...")
}