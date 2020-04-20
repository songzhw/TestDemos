package ca.six.demo.utest2.core.http

import ca.six.demo.utest2.core.data.HomeData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request


open class HttpEngineWithIO {
    val http = OkHttpClient()

    open suspend fun home(): String = withContext(Dispatchers.IO) {
        val resp = request("5e9c819230000056000a7ea2") //使用了OKHttp来请求
        val data = HomeData(resp)
        data.motto
    }

    private fun request(urlSuffix: String): String {
        val url = "http://www.mocky.io/v2/$urlSuffix"
        val request = Request.Builder().url(url).build()
        val call = http.newCall(request)
        val response = call.execute()
        return response.body?.string() ?: ""
    }
}
