package ca.six.demo.utest2.core.test

import androidx.test.espresso.idling.CountingIdlingResource

object EspressoIdlingResource {
    @JvmField val countingIdlings = CountingIdlingResource("AndroidX_Test")

    fun increment() {
        countingIdlings.increment()
    }

    fun decrement() {
        countingIdlings.decrement()
    }
}
