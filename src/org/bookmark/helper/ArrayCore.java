package org.bookmark.helper;

import java.util.ArrayList;

public class ArrayCore {

    public static String implode(final ArrayList<Long> list, final String glue) {
        String data = "";
        final int size = list.size();

        if (size > 0) {
            data = "" + list.get(0).toString();

            if (size > 1) for (int i = 1; i < size; i++) {
                data += glue;
                data += list.get(i).toString();
            }
        }

        return data;
    }

    public static ArrayList<Long> explode(final String input) {
        final ArrayList<Long> list = new ArrayList<Long>();

        if (input.length() > 0) {
            final String[] elem = input.split(",");

            for (final String item : elem)
                list.add(Long.parseLong(item));
        }
        return list;
    }

}
