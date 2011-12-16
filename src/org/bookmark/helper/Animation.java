package org.bookmark.helper;

import java.lang.reflect.Method;

import android.app.Activity;

public class Animation {
    public static void setActivityAnimation(final Activity activity, final int in, final int out) {
        try {
            final Method method = Activity.class.getMethod("overridePendingTransition",
                    new Class[] { int.class, int.class });
            method.invoke(activity, in, out);
        } catch (final Exception e) {
            // Can't change animation, so do nothing
        }
    }
}
