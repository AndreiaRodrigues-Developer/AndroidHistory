package androidhistory.andreiadev.com.androidhistory.utils;

import android.view.View;
import android.widget.GridView;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class TestUtilMatchers {

    /**
     * Returns a matcher that matches {@link GridView}s based on list size.
     *
     * @param size <a href="http://hamcrest.org/JavaHamcrest/javadoc/1.3/org/hamcrest/Matcher.html">
     *             <code>Matcher</code></a> of {@link Integer} with size to match
     */
    public static Matcher<View> withListSize(final int size) {
        return new TypeSafeMatcher<View>() {
            @Override
            public boolean matchesSafely(final View view) {
                return ((GridView) view).getCount() == size;
            }

            @Override
            public void describeTo(final Description description) {
                description.appendText("GridView should have " + size + " items");
            }
        };
    }


}
