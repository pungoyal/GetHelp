package com.getHelp.App;

import android.test.ActivityInstrumentationTestCase;

/**
 * This is a simple framework for a test of an Application.  See
 * {@link android.test.ApplicationTestCase ApplicationTestCase} for more information on
 * how to write and extend Application tests.
 * <p/>
 * To run this test, you can type:
 * adb shell am instrument -w \
 * -e class com.getHelp.App..HomeTest \
 * com.getHelp.App.tests/android.test.InstrumentationTestRunner
 */
public class HomeTest extends ActivityInstrumentationTestCase<Home> {
    public HomeTest() {
        super("com.getHelp.App", Home.class);
    }
}
