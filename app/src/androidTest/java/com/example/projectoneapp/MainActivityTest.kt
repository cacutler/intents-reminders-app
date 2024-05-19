package com.example.projectoneapp
import androidx.test.core.app.ActivityScenario.launch
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    private lateinit var scenario: ActivityScenario<MainActivity>
    @Before
    fun setUp() {
        scenario = launch(MainActivity::class.java)
    }
    @Test
    fun showsDefaultReminderOnLaunch() {
        onView(withId(R.id.reminder_text_view)).check(matches(withText("Default Reminder")))
    }
    @Test
    fun goesToActivityView() {
        onView(withId(R.id.add_button)).perform(click())
        onView(withId(R.id.save_button)).check(matches(withText(R.string.save_button)))
    }
    @After
    fun tearDown() {
        scenario.close()
    }
}