package com.lrving.gudongfood.view;

import android.os.Bundle;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertEquals;

import com.R;
import com.jerome.gudongfood.view.UserLoginActivity;

import static org.junit.Assert.*;

/**
 * Created by Jerome on 2017/5/7.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class GoalActivityTest {
    @Rule
    public ActivityTestRule<GoalActivity> mActivityRule = new ActivityTestRule<>(
            GoalActivity.class);

    @Test
    public void onCreate() throws Exception {
        onView(withId(R.id.rb_bodybuilding)).perform(click());
        onView(withId(R.id.rb_reduceWeight)).perform(click());
        onView(withId(R.id.btn_goalOk)).perform(click());

    }

}