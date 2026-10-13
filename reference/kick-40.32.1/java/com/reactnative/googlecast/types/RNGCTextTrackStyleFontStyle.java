package com.reactnative.googlecast.types;

/* JADX INFO: loaded from: classes8.dex */
public class RNGCTextTrackStyleFontStyle {
    public static int fromJson(String str) {
        str.hashCode();
        switch (str) {
            case "italic":
                return 2;
            case "normal":
                return 0;
            case "boldItalic":
                return 3;
            case "bold":
                return 1;
            default:
                return -1;
        }
    }

    public static String toJson(int i) {
        if (i == 0) {
            return "normal";
        }
        if (i == 1) {
            return "bold";
        }
        if (i == 2) {
            return "italic";
        }
        if (i != 3) {
            return null;
        }
        return "boldItalic";
    }
}
