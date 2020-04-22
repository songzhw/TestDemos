package ca.six.demo.utest2.biz.itemdetail

import android.content.Intent
import android.widget.ImageView
import androidx.test.core.app.ActivityScenario.launch
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import ca.six.demo.utest2.R
import ca.six.demo.utest2.core.image.ImageLoader
import com.squareup.picasso.Picasso
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.any
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mockito.doNothing
import org.mockito.Mockito.mock

@Ignore
@RunWith(AndroidJUnit4::class)
class ItemDetailsActivityTest {

    @Test
    fun test() {
        val it =
            Intent(ApplicationProvider.getApplicationContext(), ItemDetailsActivity::class.java)
        it.putExtra("name", "computer")
        val scenario = launch<ItemDetailsActivity>(it)

        //TODO this is still to late to inject the mockedImageLoader
//        val mockImageLoader = mock(ImageLoader::class.java)
//        doNothing().`when`(mockImageLoader.load(any(ImageView::class.java), anyString()))
//        scenario.onActivity { actv -> actv.imageLoader = mockImageLoader }


        onView(withId(R.id.tvItemDetail))
            .check(matches(withText("computer")))

        scenario.close()
    }

}