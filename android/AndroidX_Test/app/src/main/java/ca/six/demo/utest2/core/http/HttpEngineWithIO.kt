package ca.six.demo.utest2.core.http

import ca.six.demo.utest2.core.data.HomeData
import ca.six.demo.utest2.core.data.ItemsData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request

open class HttpEngineWithIO {
    val http = OkHttpClient()

    open suspend fun home(): String = withContext(Dispatchers.IO) {
        val resp = request<HomeData>("5e9c819230000056000a7ea2") //使用了OKHttp来请求
        resp.motto
    }

    open suspend fun items(): ItemsData = withContext(Dispatchers.IO) {
        request<ItemsData>("5e9891063500007100c483d2")
    }

    private inline fun <reified T> request(urlSuffix: String): T {
        val url = "http://www.mocky.io/v2/$urlSuffix"
        val request = Request.Builder().url(url).build()
        val call = http.newCall(request)
        val response = call.execute()
        val responseString = response.body?.string() ?: ""
        return T::class.java.getDeclaredConstructor(String::class.java)
            .newInstance(responseString)

    }
}
