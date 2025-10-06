import io.appium.java_client.AppiumBy
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.options.UiAutomator2Options
import java.net.URI

fun main(args: Array<String>) {
    val options = UiAutomator2Options()
        .setUdid("emulator-5554") // UDID: 设备级别的唯一标识符;  这个id由`adb devices`中可得知设备id是什么, 却要运行测试到这个设备上
        .setApp("/Downloads/apk/one.apk")
    val driver = AndroidDriver(URI("http://127.0.0.1:4723").toURL(), options)

    val el = driver.findElement(AppiumBy.xpath("//TextView"))
    println("tv = ${el.text}")
    println("pageSource = ${driver.pageSource}")
    driver.quit()
}