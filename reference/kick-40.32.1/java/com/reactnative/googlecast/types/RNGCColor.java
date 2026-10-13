package com.reactnative.googlecast.types;

import android.graphics.Color;

/* JADX INFO: loaded from: classes8.dex */
public class RNGCColor {
    public static int fromJson(String str) {
        if (str == null) {
            return 0;
        }
        try {
            if (str.startsWith("#")) {
                String strSubstring = str.substring(1, 7);
                return Color.parseColor("#" + str.substring(7) + strSubstring);
            }
            return Color.parseColor(str);
        } catch (IllegalArgumentException unused) {
            return 0;
        }
    }

    public static String toJson(int i) {
        if (i == 0) {
            return null;
        }
        String str = String.format("%08X", Integer.valueOf(i));
        String strSubstring = str.substring(0, 2);
        return "#" + str.substring(2) + strSubstring;
    }
}
