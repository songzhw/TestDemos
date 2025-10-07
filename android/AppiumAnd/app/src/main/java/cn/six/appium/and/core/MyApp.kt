package cn.six.appium.and.core

import android.app.Application
import io.reactivex.rxjava3.disposables.CompositeDisposable

class MyApp : Application()/*, ImageLoaderFactory*/ {
    protected val disposables: CompositeDisposable = CompositeDisposable()

    companion object {
        private lateinit var self: MyApp
        fun app(): MyApp = self
    }

    override fun onCreate() {
        super.onCreate()
        self = this

    }

    override fun onTerminate() {
        disposables.dispose()
        super.onTerminate()
    }

}
