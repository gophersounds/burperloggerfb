package com.gophersounds.burperloggerfb

import com.gophersounds.burperloggerfb.DrawableMatcher
import com.gophersounds.burperloggerfb.EspressoTestsMatchers

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.ViewInteraction
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

//import android.support.test.rule.AndroidTestRule
import android.support.test.runner.AndroidJUnit4
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import com.gophersounds.burperloggerfb.EspressoTestsMatchers.withDrawable
import kotlinx.android.synthetic.main.activity_record.view.*
import org.hamcrest.CoreMatchers.*
import org.hamcrest.Matcher

@RunWith(AndroidJUnit4::class)
@LargeTest
class RecordActivityInstrumentedTest{

    @Rule
    @JvmField
    var mActivityRule: ActivityTestRule<RecordActivity> = ActivityTestRule(RecordActivity::class.java)

    @Test
    fun fullRecordingProcess() {
        //set up
        onView(withId(R.id.imgMicrophone)).check(matches((isDisplayed())))
        onView(withId(R.id.imgDelete)).check(matches(not(isDisplayed())))
        onView(withId(R.id.imgSave)).check(matches(not(isDisplayed())))
        onView(withId(R.id.imgMicrophone)).check(matches(withDrawable(R.drawable.ic_mic_black_24dp)))
        onView(withId(R.id.txtDate)).check(matches(not(isDisplayed())))
        onView(withId(R.id.rateBurp)).check(matches(not(isDisplayed())))

    }

    @Test
    fun startRecording(){
        onView(withId(R.id.imgMicrophone))
                .perform(click())
                .check(matches(withDrawable(R.drawable.ic_mic_none_black_24dp)))
    }

    @Test
    fun stopRecording(){
        onView(withId(R.id.imgMicrophone))
                .perform(click())
                .check(matches(withDrawable(R.drawable.ic_play_circle_filled_black_24dp)))

        onView(withId(R.id.imgDelete))
                .check(matches(isDisplayed()))

        onView(withId(R.id.imgSave))
                .check(matches(isDisplayed()))

        onView(withId(R.id.txtDate))
                .check(matches(isDisplayed()))
    }
    /*
    @Test
    fun RecordButtonIsVisible(){
        onView(withId(R.id.imgMicrophone)).check(matches((isDisplayed())))
    }

    @Test
    fun DeleteButtonIsNotVisible(){
        onView(withId(R.id.imgDelete)).check(matches(not(isDisplayed())))
    }
    @Test
    fun SaveButtonIsNotVisible(){
        onView(withId(R.id.imgSave)).check(matches(not(isDisplayed())))
    }
    @Test
    fun RecordButtonIsMicrophone(){
        // use custom matcher -- see EspressoTestsMatchers and DrawableMatcher
        onView(withId(R.id.imgMicrophone)).check(matches(withDrawable(R.drawable.ic_mic_black_24dp)))

    }

    @Test
    fun RecordingStarted(){

        onView(withId(R.id.imgMicrophone)).perform(click())
        if (mActivityRule.activity.isRecording) {
            onView(withId(R.id.imgMicrophone)).check(matches(withDrawable(R.drawable.ic_mic_none_black_24dp)))
        }
    }

    @Test
    fun StopRecordingChangeButtons(){

        onView(withId(R.id.imgMicrophone))
                .perform(click())
                .check(matches(withDrawable((R.drawable.ic_play_circle_filled_black_24dp))))

        onView(withId(R.id.imgDelete))
                .check(matches(isDisplayed()))

        onView(withId(R.id.imgSave))
                .check(matches(isDisplayed()))


    }
`*/
}