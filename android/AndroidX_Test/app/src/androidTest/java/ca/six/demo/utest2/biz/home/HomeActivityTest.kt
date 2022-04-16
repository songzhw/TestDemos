package ca.six.demo.utest2.biz.home


import android.content.Intent
import android.net.Uri
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.rules.activityScenarioRule //来自"androidx.test.ext:junit-ktx:1.1.3"
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.After
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class HomeActivityTest {
    @get:Rule
    val rule = activityScenarioRule<HomeActivity>()

    @Test fun foo(){
        println("szw thread = ${Thread.currentThread().name}")
        onView(withText("sp@home"))
            .check(matches(isDisplayed()))
    }
}

// 证明 Espresso能测试 SharedPreference的!
