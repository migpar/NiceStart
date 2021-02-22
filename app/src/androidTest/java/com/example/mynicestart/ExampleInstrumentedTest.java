package com.example.mynicestart;

import android.content.Context;

import androidx.test.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertEquals;



import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    /**
     * PARA ANDROIDX
     *
     * @Rule
     *
     * public ActivityScenarioRule<LoginActivity> activityRule =
     *
     *         new ActivityScenarioRule<>(LoginActivity.class);
     */
    @Rule
    public ActivityTestRule mActivityRule = new ActivityTestRule<>(
            LoginActivity.class);

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.mynicestart",
                appContext.getPackageName());
    }

    @Test
    public void activityLaunch() {
        onView(withId(R.id.buttonLogin)).perform(click());
        //onView(withId(R.id.text_header)).check(matches(isDisplayed()));
    }

    @Test
    public void activityLaunch2() {
        onView(withId(R.id.buttonRegister)).perform(click());
        //onView(withId(R.id.text_header)).check(matches(isDisplayed()));
    }

    @Test
    public void textInputOutput() {
        onView(withId(R.id.passwd)).perform(
                typeText("1234567"));
        onView(withId(R.id.nickname)).perform(
                typeText("This is a test."));
        onView(withId(R.id.buttonLogin)).perform(click());
       // onView(withId(R.id.text_message)).check(
         //       matches(withText("This is a test.")));
    }
}