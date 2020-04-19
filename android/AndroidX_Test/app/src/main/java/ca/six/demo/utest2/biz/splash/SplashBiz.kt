package ca.six.demo.utest2.biz.splash

import android.database.sqlite.SQLiteBindOrColumnIndexOutOfRangeException
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.*
import ca.six.demo.utest2.R
import ca.six.demo.utest2.biz.main.MainActivity
import ca.six.demo.utest2.core.arch.Event
import ca.six.demo.utest2.core.http.HttpEngine
import ca.six.demo.utest2.utils.nav
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_splash.*
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {
    lateinit var vm: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        println("111")

        vm = ViewModelProvider(this).get(SplashViewModel::class.java)
        vm.start()
        println("222")

        vm.imageLive.observe(this,
            Observer { imgUrl -> Picasso.get().load(imgUrl).into(ivSplashBg); })

        vm.navigationEvent.observe(this,
            Observer { nav<MainActivity>(); this.finish(); })

        println("333")
    }
}

class SplashViewModel(val dispatcher: CoroutineDispatcher = Dispatchers.IO) : ViewModel() {
    val imageLive = MutableLiveData<String>()
    val navigationEvent = MutableLiveData<Event<Unit>>()
    var http = HttpEngine()

    fun start() {
        viewModelScope.launch(dispatcher) {
            val resp = http.splash()
            imageLive.postValue(resp)
            Thread.sleep(2000)
            navigationEvent.postValue(Event(Unit))
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