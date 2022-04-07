package ca.six.demo.utest2.core.router

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ca.six.demo.utest2.R
import kotlinx.android.synthetic.main.activity_main.*

class DeepLinkActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onReceiveDeepLink()
    }

    // DeepLinkActivity.launchMode是SingleTask, 即自带了singleTop属性
    // 栈顶为DeepLinkActivity, 要再走DeepLink, 那不应该有2个DeepLinkActivity的!
    // 备注: LaunchMode是不需要affinity也能工作的, 所以DeepLinkActivity没有affnity也能调用到这
    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        onReceiveDeepLink()
    }

    private fun onReceiveDeepLink() {
        val uri = intent.data
        tvMain.text = uri.toString()
    }

}