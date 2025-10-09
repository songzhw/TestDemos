package cn.appium.t01.ext

import io.appium.java_client.AppiumBy
import org.openqa.selenium.By

// 跨平台（Android/iOS）精确查找元素。
fun textMatch(textValue: String): By {
    // 使用 XPath 查找所有元素中 text 属性等于给定值的元素
    return AppiumBy.xpath("//*[@text='$textValue']")
}

// 跨平台（Android/iOS）模糊查找元素。
fun textContains(partialText: String): By {
    // XPath: `//*[contains(@text, '部分文本')]`
    // 注意：在 iOS 上，Appium 会尝试将 `@text` 映射到 `@label` 或 `@value`
    return AppiumBy.xpath("//*[contains(@text, '$partialText')]")
}