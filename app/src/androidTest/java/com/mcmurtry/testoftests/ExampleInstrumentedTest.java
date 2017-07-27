package com.mcmurtry.testoftests;

import android.graphics.Color;
import android.support.test.espresso.matcher.BoundedMatcher;
import android.support.test.internal.util.Checks;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.widget.Button;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void testButtonMakesItYellow()
    {
        onView(withId(R.id.helloText))
                .check(matches(withTextColor(Color.BLACK)));

        onView(withId(R.id.helloButton))
                .perform(click());

        onView(withId(R.id.helloText))
                .check(matches(withTextColor(Color.YELLOW)));
    }

    private static Matcher<View> withTextColor(final int color) {
        Checks.checkNotNull(color);

        return new BoundedMatcher<View, Button>(Button.class) {
            @Override
            public boolean matchesSafely(Button button) {
                return color == button.getCurrentTextColor();
            }
            @Override
            public void describeTo(Description description) {
                description.appendText("wrong text color ");
            }
        };
    }
}
