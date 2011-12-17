package org.bookmark.helper;

public class NumberCore {

    public static double parseDouble(final String input) {
        return input.length() > 0 ? Double.parseDouble(input) : 0;
    }

    public static int parseInt(final String input) {
        return input.length() > 0 ? Integer.parseInt(input) : 0;
    }
}
