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
    println("szww firstTitle = ${firstTitle.text}") //=> 风景

    // 2. 查找文本
        // 2.1 精确匹配文本

        // 2.2 模糊匹配文本

    // 3. 查找图片

    // 4. 查找ID

    // 5. 查找RecyclerView不在屏幕上的元素


    driver.quit()
    //el.click();  AppiumBy.xpath("...")
}

/*
整个页面(driver.pageSource)大致是这样的 (数据很长, 我精简了)
<flay resource-id="android:id/content">
    <ViewGroup resource-id="cn.six.appium.and:id/ctlayHome">
        <ImageButton resource-id="cn.six.appium.and:id/fabHome">
        <rv resource-id="cn.six.appium.and:id/rvHome">
            <llay resource-id="cn.six.appium.and:id/llayRoot">
                <iv resource-id="cn.six.appium.and:id/ivTitle2">
                <tv resource-id="cn.six.appium.and:id/tvTitle2">
            <rlay>
                <tv resource-id="cn.six.appium.and:id/tvInfo" text="apple">
                <iv resource-id="cn.six.appium.and:id/ivAdd">
                ...
            <rlay>
                <tv resource-id="cn.six.appium.and:id/tvInfo" text="banana">
                <iv resource-id="cn.six.appium.and:id/ivAdd">
                ...
            <rlay>
                <tv resource-id="cn.six.appium.and:id/tvInfo" text="cherry">
                <iv resource-id="cn.six.appium.and:id/ivAdd">
                ...

1). 页面根view明明是一个ctlay, 但只识别成了ViewGroup
2). rv本质也是一个ViewGroup, 它的每个item都做为view hierarchy tree的children附在rv上了
3). rv其实是有7个fruit的item的, 但是这里只显示了apple, banana, cherry
这是这三个才是打开页面后屏幕可见的Fruite. => 也就是说rv中不在屏幕上的item, 就不在driver.pageSource里了
 */