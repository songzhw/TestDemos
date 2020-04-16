package ca.six.demo.utest2.core.http

import okhttp3.OkHttpClient
import okhttp3.Request

object HttpEngine {
    val http = OkHttpClient()

    fun splash(){
        request("5e9891f73500006100c483db")
    }

    fun login() {
        request("5e988dde3500003900c483b7")
    }

    private fun request(urlSuffix: String): String {
        val url = "http://www.mocky.io/v2/$urlSuffix"
        val request = Request.Builder().url(url).build()
        val call = http.newCall(request)
        val response = call.execute()
        return response.body?.string() ?: ""
    }
}

