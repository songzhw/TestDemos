package ca.six.demo.utest2.core.router

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ca.six.demo.utest2.R
import ca.six.demo.utest2.biz.itemdetail.ItemDetailsActivity
import ca.six.demo.utest2.biz.items.ItemsActivity
import ca.six.demo.utest2.utils.nav

class DeepLinkActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onReceiveDeepLink(intent)
    }

    // DeepLinkActivity.launchMode是SingleTask, 即自带了singleTop属性
    // 栈顶为DeepLinkActivity, 要再走DeepLink, 那不应该有2个DeepLinkActivity的!
    // 备注: LaunchMode是不需要affinity也能工作的, 所以DeepLinkActivity没有affnity也能调用到这
    override fun onNewIntent(arg: Intent) {
        super.onNewIntent(arg)
        onReceiveDeepLink(arg)
    }

    // 加上一个参数, 免得此页没有关闭时, 再来一个此页, "intent"的值仍是上一次的intent, 而不是onNewInrtent(it2)中的it2
    private fun onReceiveDeepLink(intention: Intent) {
        val uri = intention.data
        val host = uri?.host ?: ""
        println("szw host = $host")

        // ./testDeepLink.sh "six://items"
        if ("items".equals(host, true)) {
            nav<ItemsActivity>()
        }

        // ./testDeepLink.sh "six://detail?name=apple"
        else if ("detail".equals(host, true)) {
            val query = uri?.getQueryParameter("name") ?: "<empty>"
            nav<ItemDetailsActivity>(mapOf("name" to query))
        }

        // no matter what, this page need to be closed
        this.finish()
    }

}