package ca.six.demo.utest2.biz.splash

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import ca.six.demo.utest2.R
import ca.six.demo.utest2.biz.home.HomeActivity
import ca.six.demo.utest2.utils.nav
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_splash.*


@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    lateinit var vm: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        vm = ViewModelProvider(this).get(SplashViewModel::class.java)
        vm.start()

        vm.imageLive.observe(this,
            Observer { imgUrl -> Picasso.get().load(imgUrl).into(ivSplashBg) })

        vm.navigationEvent.observe(this,
            Observer { nav<HomeActivity>(); this.finish(); })
    }

}
