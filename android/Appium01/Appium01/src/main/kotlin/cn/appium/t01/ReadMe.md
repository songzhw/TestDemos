# Hello World
```kt
// Android
val options = UiAutomator2Options()
    .setUdid("emulator-5554") // UDID: 设备级别的唯一标识符;  这个id由`adb devices`中可得知设备id是什么, 却要运行测试到这个设备上
    .setApp("Downloads/apk/one.apk") // Appium Server说了, appium home path是~, 所以这里就不用写全路径了
val driver = AndroidDriver(URI("http://127.0.0.1:4723").toURL(), options)

// Universal写法
val options = BaseOptions()
    .setPlatformName("Android")
    .setAutomationName("UiAutomator2")
    .amend("udid", "emulator-5554") // UDID: 设备级别的唯一标识符;  这个id由`adb devices`中可得知设备id是什么, 却要运行测试到这个设备上
    .amend("app", "Downloads/apk/one.apk") // Appium Server说了, appium home path是~, 所以这里就不用写全路径了
val driver = AppiumDriver(URI("http://127.0.0.1:4723").toURL(), options)
```

1). UiAutomator2Options中的`setUdid(), setApp()`, 看其源码就知道, 它其实就是调用的: 
```kt
amend("udid", value)
amend("app", value)
```
而已. 所以我们在通用写未能里就可以这样定敢.

备注: 其实BaseOptions的setPlatformName(), setAutomationName(), 也是调用了amend而已:
```kt
amend("platformName", platform);
amend("automationName", automationName);
```

2). 可选值
* platformName: "Android", "iOS"
* automationName: "UiAutomator2", "XCUITest"
  (XCUI是指 XCode UI的意思, 所以"XCUITest"其实是指XCode UI Test的意思)

3). 选用合适的Driver 
* Android平台使用了AndroidDriver;
* 而通用写法则是使用了 AppiumDriver, 果然成功了. 

=> 原因嘛, 其实就是因为AndroidDriver自己没做任何事, 就是用了super()的CF, 而这个super, 正是AppiumDriver:
所以, 这样一来就可以直接使用AppiumDriver了. 

```java
public class AndroidDriver extends AppiumDriver implements xxx {
    public AndroidDriver(URL remoteAddress, Capabilities capabilities) {
        super(remoteAddress, ensurePlatformName(capabilities, ANDROID_PLATFORM));
    }
```