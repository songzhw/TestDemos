package ca.six.demo.utest2.core.router

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ca.six.demo.utest2.R

class DeepLinkActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val uri = intent.data
        println("szw got : $uri")
    }
}