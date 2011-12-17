package org.bookmark.helper;

import java.sql.Timestamp;

public class DateCore {

    public static String getTimeStamp(final java.util.Date date) {
        return new Timestamp(date.getTime()).toString();
    }

    public static String getCurrentTimeStamp() {
        return DateCore.getTimeStamp(new java.util.Date());
    }
}
