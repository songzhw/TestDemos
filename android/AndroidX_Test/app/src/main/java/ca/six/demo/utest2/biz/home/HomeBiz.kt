package ca.six.demo.utest2.biz.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ca.six.demo.utest2.R
import ca.six.demo.utest2.core.http.HttpEngine
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeActivity : AppCompatActivity(R.layout.activity_home) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}

class HomeViewModel : ViewModel() {

    fun home() {
        viewModelScope.launch(Dispatchers.IO) {
            val http = HttpEngine()
            val resp = http.home()
            return resp
        }

    }

}