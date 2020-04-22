package ca.six.demo.utest2.biz.itemdetail

import android.content.Intent
import androidx.test.core.app.ActivityScenario.launch
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import ca.six.demo.utest2.R
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ItemDetailsActivityTest {

    @Test
    fun test() {
        val it =
            Intent(ApplicationProvider.getApplicationContext(), ItemDetailsActivity::class.java)
        it.putExtra("name", "computer")
        val scenario = launch<ItemDetailsActivity>(it)

        Espresso.onView(ViewMatchers.withId(R.id.tvItemDetail))
            .check(ViewAssertions.matches(ViewMatchers.withText("MainActivity")))


        scenario.close()
    }

}