package org.bookmark.helper;

public class ColorCore {

    public static String random() {
        String r = Integer.toHexString(Utils.random(255)).toUpperCase();
        String g = Integer.toHexString(Utils.random(255)).toUpperCase();
        String b = Integer.toHexString(Utils.random(255)).toUpperCase();

        r = r.length() < 2 ? "0" + r : r;
        g = g.length() < 2 ? "0" + g : g;
        b = b.length() < 2 ? "0" + b : b;

        return r + g + b;
    }
}
