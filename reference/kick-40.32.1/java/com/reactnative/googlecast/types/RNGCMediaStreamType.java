package com.reactnative.googlecast.types;

/* JADX INFO: loaded from: classes8.dex */
public class RNGCMediaStreamType {
    public static int fromJson(String str) {
        str.hashCode();
        switch (str) {
            case "buffered":
                return 1;
            case "live":
                return 2;
            case "none":
                return 0;
            default:
                return -1;
        }
    }

    public static String toJson(int i) {
        if (i == 0) {
            return "none";
        }
        if (i == 1) {
            return "buffered";
        }
        if (i != 2) {
            return null;
        }
        return "live";
    }
}
