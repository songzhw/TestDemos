package ca.six.demo.utest2

import android.app.Application
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import ca.six.demo.utest2.core.MyApp
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MyAppTest {

    @Test
    fun testResource() {
        val app = ApplicationProvider.getApplicationContext<Application>()
        val appName = app.getString(R.string.app_name)
        assertEquals("AndroidX_Test", appName)
    }

    @Test
    fun checkIdInApp_equals2020() {
        val app = ApplicationProvider.getApplicationContext<MyApp>()
        assertEquals("2020", app.id)
    }

    @Test
    fun changeInApp_equals1998() {
        val app = ApplicationProvider.getApplicationContext<MyApp>()
        app.changeId()
        assertEquals("1998", app.id)
    }

}