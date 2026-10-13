package com.reactnative.googlecast.types;

/* JADX INFO: loaded from: classes8.dex */
public class RNGCMediaPlayerIdleReason {
    public static int fromJson(String str) {
        str.hashCode();
        switch (str) {
            case "interrupted":
                return 3;
            case "finished":
                return 1;
            case "error":
                return 4;
            case "cancelled":
                return 2;
            default:
                return 0;
        }
    }

    public static String toJson(int i) {
        if (i == 1) {
            return "finished";
        }
        if (i == 2) {
            return "cancelled";
        }
        if (i == 3) {
            return "interrupted";
        }
        if (i != 4) {
            return null;
        }
        return "error";
    }
}
