package ca.six.demo.utest2.biz.home

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import ca.six.demo.utest2.R
import ca.six.demo.utest2.biz.items.ItemsActivity
import ca.six.demo.utest2.core.http.HttpEngineWithIO
import ca.six.demo.utest2.utils.nav
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.coroutines.launch

class HomeActivity : AppCompatActivity(R.layout.activity_home) {
    lateinit var vm: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        vm = ViewModelProvider(this).get(HomeViewModel::class.java)

        val sp = getSharedPreferences("utest2", Context.MODE_PRIVATE)
        val spValue = sp.getString("spName", "<empty>")
        if(spValue != "<empty>") {
            with(sp.edit()) {
                putInt("spID", 23)
                putString("spName", "sp@home")
                apply()
            }
        }
        tvInfo.text = spValue


        lifecycleScope.launch {
            val motto = vm.home()
            tvMotto.text = motto
        }

        btnHomeNavItems.setOnClickListener {
            nav<ItemsActivity>()
        }
    }
}


class HomeViewModel : ViewModel() {
    var http: HttpEngineWithIO = HttpEngineWithIO()

    suspend fun home(): String {
        val resp = http.home()
        return resp
    }

}