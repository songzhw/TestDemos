package ca.six.demo.utest2.biz.splash

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.*
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@Ignore
@RunWith(AndroidJUnit4::class)
class SplashActivityTest {
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()
    lateinit var scenario: ActivityScenario<SplashActivity>

    @Before
    fun setup() {
        // 会走完onCreate->onStart->onResume
        scenario = ActivityScenario.launch(SplashActivity::class.java)
    }

    @After
    fun clean() {
        scenario.close()
    }

    @Test
    fun testActivity() {
    }
}

/*
1. 难点1
mock并注入我们的mockPresenter后, 就可以调用presenter的方法
但ViewModel的 LiveData 要在onCreate()中注册, 这样即使替换了vm, 这个vm.livedata.observer()还是用的老vm

(==> 方法不是没有, 就是把vm.liveData.observer()放到一个额外方法里, 比如说listen(). 然后onCreate()中调用listen().
到了测试里, 就mock并注入mockVm后, 再在测试中拖动调用actv.listen(), 就行了)

2. 难点2
Picasso这些库也会有问题, 比如说我就碰到过个Error:
Exception in thread "DefaultDispatcher-worker-1 @coroutine#1" java.lang.IllegalStateException: context == null
	at com.squareup.picasso.Picasso.get(Picasso.java:681)

(这个暂时无解, 只好说暂时不走Activity的单元测试. 要测试就走Espresso的集成测试吧)
 */