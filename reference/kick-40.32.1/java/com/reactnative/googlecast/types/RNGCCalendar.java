package com.reactnative.googlecast.types;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* JADX INFO: loaded from: classes7.dex */
public class RNGCCalendar {
    private static final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    public static Calendar fromJson(String str) {
        if (str == null) {
            return null;
        }
        try {
            Calendar calendar = Calendar.getInstance();
            Date date = formatter.parse(str);
            if (date == null) {
                return null;
            }
            calendar.setTime(date);
            return calendar;
        } catch (ParseException unused) {
            return null;
        }
    }

    public static String toJson(Calendar calendar) {
        if (calendar == null) {
            return null;
        }
        return formatter.format(calendar.getTime());
    }
}
