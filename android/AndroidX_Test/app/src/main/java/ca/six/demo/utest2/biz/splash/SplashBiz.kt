package ca.six.demo.utest2.biz.splash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import ca.six.demo.utest2.R
import ca.six.demo.utest2.core.http.HttpEngine

class SplashActivity : AppCompatActivity(R.layout.activity_splash) {
    lateinit var vm: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        HttpEngine.splash()
    }
}

class SplashViewModel : ViewModel() {
    fun start(){

    }
}