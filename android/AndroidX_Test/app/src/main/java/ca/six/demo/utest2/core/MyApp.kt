package ca.six.demo.utest2.core

import android.app.Application

class MyApp : Application() {
    var id = "2020"

    override fun onCreate() {
        super.onCreate()
        println("szw Application")
    }

    fun changeId() {
        id = "1998"
    }

}