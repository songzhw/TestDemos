package ca.six.demo.utest2.biz.splash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ca.six.demo.utest2.R
import ca.six.demo.utest2.core.http.HttpEngine

class SplashActivity: AppCompatActivity(R.layout.activity_splash) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        HttpEngine.splash()
    }
}