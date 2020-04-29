package ca.six.demo.utest2.biz.splash

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import ca.six.demo.utest2.R
import ca.six.demo.utest2.core.test.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class SplashTest {
    @get:Rule val activityRule = ActivityTestRule(SplashActivity::class.java)

    @Test fun testSplash_imageShouldDisplay() {
        onView(withId(R.id.ivSplashBg))
            .check(matches(isDisplayed()))
    }

    @Test fun testSplash_homePageShouldDisplay() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.countingIdlings)
        onView(withId(R.id.tvMotto))
            .check(matches(isDisplayed()))
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.countingIdlings)
    }
}