package se.magictechnology.mytesting


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityCheckUITest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun mainActivityCheckUITest() {

        val calc_et = onView(withId(R.id.calcET))
        val calc_tv = onView(withId(R.id.calcTV))
        val calc_btn = onView(withId(R.id.calcBTN))

        calc_et.perform(replaceText("45"))
        calc_et.perform(closeSoftKeyboard())

        calc_btn.perform(click())

        calc_tv.check(ViewAssertions.matches(withText("Ojämn")))

        calc_et.perform(replaceText("4"))
        calc_et.perform(closeSoftKeyboard())

        calc_btn.perform(click())

        calc_tv.check(ViewAssertions.matches(withText("Jämn")))

        calc_et.perform(replaceText("Hej"))
        calc_et.perform(closeSoftKeyboard())

        calc_btn.perform(click())

        calc_tv.check(ViewAssertions.matches(withText("FEL")))

        /*
        val appCompatEditText = onView(
            allOf(
                withId(R.id.calcET),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatEditText.perform(replaceText("45"), closeSoftKeyboard())

        val materialButton = onView(
            allOf(
                withId(R.id.calcBTN), withText("Calc"),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        materialButton.perform(click())

        val appCompatEditText2 = onView(
            allOf(
                withId(R.id.calcET), withText("45"),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatEditText2.perform(click())

        val appCompatEditText3 = onView(
            allOf(
                withId(R.id.calcET), withText("45"),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatEditText3.perform(replaceText("45a"))

        val appCompatEditText4 = onView(
            allOf(
                withId(R.id.calcET), withText("45a"),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatEditText4.perform(closeSoftKeyboard())

        val materialButton2 = onView(
            allOf(
                withId(R.id.calcBTN), withText("Calc"),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        materialButton2.perform(click())

         */
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
