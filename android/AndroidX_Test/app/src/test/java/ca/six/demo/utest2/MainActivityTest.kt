package ca.six.demo.utest2

import android.app.Application
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Test
    fun testResource() {
        val app = getApplicationContext<Application>()
        val appName = app.getString(R.string.app_name)
        assertEquals("AndroidX_Test", appName)
    }

}