package ca.six.demo.utest2.biz.splash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import ca.six.demo.utest2.R
import ca.six.demo.utest2.core.http.HttpEngine
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity(R.layout.activity_splash) {
    lateinit var vm: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        vm = ViewModelProvider(this).get(SplashViewModel::class.java)
        vm.start()
    }
}

class SplashViewModel : ViewModel() {
    fun start() {
        viewModelScope.launch(Dispatchers.IO) {
            val resp = HttpEngine.splash()
            println("szw resp = $resp")
        }
    }
}