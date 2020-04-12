package ca.six.demo.utest2.biz.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ca.six.demo.utest2.R
import ca.six.demo.utest2.core.IListener
import ca.six.demo.utest2.core.MyObservable
import ca.six.demo.utest2.core.Worker
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(R.layout.activity_main), IListener {
    val observable = MyObservable(this)
    lateinit var worker: Worker

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        worker = Worker()

        tvMain.text = "MainActivity"
        btnMain.text = "work"
        btnMain.setOnClickListener {
            println("szw 111")
            tvMain.text = worker.workSync(23)
            println("szw 222")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        observable.removeListener()
    }

    override fun onObservableChange() {
    }
}
