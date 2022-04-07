package ca.six.demo.utest2.core.router

import android.content.Intent
import android.net.Uri
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class DeepLinkActivityTest {
    @get:Rule val activityRule = ActivityTestRule(DeepLinkActivity::class.java)

    @Test fun testItemsDeeplink_itemsPageShouldShow(){
        val it = getIntent("six://items")
        activityRule.launchActivity(it)

        onView(withText("Items"))
            .check(matches(isDisplayed()))
        //+------>AppCompatTextView{id=-1, text=Items, visibility=VISIBLE, width=143, height=76, has-focus=false, has-focusable=false, has-window-focus=true, is-clickable=false, is-enabled=true, is-focused=false, is-focusable=false, is-layout-requested=false, is-selected=false, layout-params=androidx.appcompat.widget.Toolbar$LayoutParams@88c44cc, tag=null, root-is-layout-requested=false, has-input-connection=false, x=45.0, y=41.0,  input-type=0, ime-target=false, has-links=false}
    }

    @Test fun testDetailssDeeplink_detailsPageShouldShow(){
        val it = getIntent("six://detail")
        activityRule.launchActivity(it)

        onView(withText("Details"))
            .check(matches(isDisplayed()))
    }

    @Test fun testDetailsDeeplink_detailsPageShouldShowApple_whenNameIsApple(){
        val it = getIntent(""" six://detail?name="apple" """)
        activityRule.launchActivity(it)

        onView(withText("apple"))
            .check(matches(isDisplayed()))
    }

    private fun getIntent(uriString: String) = Intent(Intent.ACTION_VIEW, Uri.parse(uriString))
}