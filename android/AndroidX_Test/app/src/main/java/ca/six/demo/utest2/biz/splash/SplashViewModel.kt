package ca.six.demo.utest2.biz.splash

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ca.six.demo.utest2.core.arch.Event
import ca.six.demo.utest2.core.http.HttpEngine
import ca.six.demo.utest2.core.test.EspressoIdlingResource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class SplashViewModel(val dispatcher: CoroutineDispatcher = Dispatchers.IO) : ViewModel() {
    val imageLive = MutableLiveData<String>()
    val navigationEvent = MutableLiveData<Event<Unit>>()
    var http = HttpEngine()

    fun start() {
        viewModelScope.launch(dispatcher) {
            EspressoIdlingResource.increment()
            val resp = http.splash()
            imageLive.postValue(resp)
            Thread.sleep(2000)
            navigationEvent.postValue(Event(Unit))
            EspressoIdlingResource.decrement()
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