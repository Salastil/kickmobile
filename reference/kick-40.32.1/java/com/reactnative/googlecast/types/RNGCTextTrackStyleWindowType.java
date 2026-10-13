package com.reactnative.googlecast.types;

/* JADX INFO: loaded from: classes8.dex */
public class RNGCTextTrackStyleWindowType {
    public static int fromJson(String str) {
        str.hashCode();
        switch (str) {
            case "normal":
                return 1;
            case "none":
                return 0;
            case "rounded":
                return 2;
            default:
                return -1;
        }
    }

    public static String toJson(int i) {
        if (i == 0) {
            return "none";
        }
        if (i == 1) {
            return "normal";
        }
        if (i != 2) {
            return null;
        }
        return "rounded";
    }
}
