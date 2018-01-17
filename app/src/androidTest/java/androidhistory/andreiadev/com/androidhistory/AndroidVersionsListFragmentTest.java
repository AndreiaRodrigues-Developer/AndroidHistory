package androidhistory.andreiadev.com.androidhistory;

import android.content.Intent;
import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidhistory.andreiadev.com.androidhistory.utils.TestUtilMatchers;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class AndroidVersionsListFragmentTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class, true, false);

    @Before
    public void setUp() {
        // Launch the target Activity
        mActivityTestRule.launchActivity(new Intent(Intent.ACTION_MAIN));
    }

    @Test
    public void versionsListing_ShouldShowListOfVersions() {

        ViewInteraction gridView = onView(withId(R.id.gv_android_versions));
        //Checks if the grid with the versions list is displayed
        gridView.check(matches(isDisplayed()));

        //Checks if the grid displays all the versions
        gridView.check(matches(TestUtilMatchers.withListSize(13)));

    }
}