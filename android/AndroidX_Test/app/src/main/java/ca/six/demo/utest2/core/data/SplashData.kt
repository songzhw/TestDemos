package ca.six.demo.utest2.core.data

import org.json.JSONObject

class SplashData(val src: String) {
    val image: String
        get() {
            val json = JSONObject(src)
            return json.optString("img")
        }
}

class HomeData(val src: String) {
    val motto: String
        get() {
            val json = JSONObject(src)
            return json.optString("motto")
        }
}