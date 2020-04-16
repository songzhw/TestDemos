package ca.six.demo.utest2.biz.splash

import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.*
import ca.six.demo.utest2.R
import ca.six.demo.utest2.core.http.HttpEngine
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_splash.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {
    lateinit var vm: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        vm = ViewModelProvider(this).get(SplashViewModel::class.java)
        vm.start()

        vm.imageLive.observe(this,
            Observer { imgUrl -> Picasso.get().load(imgUrl).into(ivSplashBg); })
    }
}

class SplashViewModel : ViewModel() {
    val imageLive = MutableLiveData<String>()

    fun start() {
        viewModelScope.launch(Dispatchers.IO) {
            val resp = HttpEngine.splash()
            imageLive.postValue(resp)
        }
    }
}


/*
class MyViewModel : ViewModel() {

    fun launchDataLoad() {
        viewModelScope.launch {
            sortList()
            // Modify UI
        }
    }

    suspend fun sortList() = withContext(Dispatchers.Default) {
        // Heavy work
    }
}
 */