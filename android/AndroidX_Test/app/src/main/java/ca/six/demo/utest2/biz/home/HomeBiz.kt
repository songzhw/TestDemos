package ca.six.demo.utest2.biz.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import ca.six.demo.utest2.R
import ca.six.demo.utest2.core.http.HttpEngineWithIO
import kotlinx.coroutines.launch

class HomeActivity : AppCompatActivity(R.layout.activity_home) {
    lateinit var vm: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        vm = ViewModelProvider(this).get(HomeViewModel::class.java)

        lifecycleScope.launch {
            val motto = vm.home()
            println("szw motto = $motto")
        }
    }
}

class HomeViewModel : ViewModel() {

    suspend fun home(): String {
        val http = HttpEngineWithIO()
        val resp = http.home()
        return resp
    }

}