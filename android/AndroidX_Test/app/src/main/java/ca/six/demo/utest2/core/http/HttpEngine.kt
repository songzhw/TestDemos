package ca.six.demo.utest2.core.http

import ca.six.demo.utest2.core.data.SplashData
import okhttp3.OkHttpClient
import okhttp3.Request

open class HttpEngine {
    val http = OkHttpClient()

    fun splash(): String {
        println("SZW ME = $this")
        val resp = request("5e9891f73500006100c483db")
        println("szw value = $resp")
        val data = SplashData(resp)
        return data.image
    }

    fun login(): String {
        return request("5e988dde3500003900c483b7")
    }

    fun request(urlSuffix: String): String {
//        val url = "http://www.mocky.io/v2/$urlSuffix"
//        val request = Request.Builder().url(url).build()
//        val call = http.newCall(request)
//        val response = call.execute()
//        return response.body?.string() ?: ""
        return "{'img':'abc'}"
    }
}

