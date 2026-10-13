package com.reactnative.googlecast.types;

/* JADX INFO: loaded from: classes8.dex */
public class RNGCMediaTrackType {
    public static int fromJson(String str) {
        str.hashCode();
        switch (str) {
            case "text":
                return 1;
            case "audio":
                return 2;
            case "video":
                return 3;
            default:
                return 0;
        }
    }

    public static String toJson(int i) {
        if (i == 1) {
            return "text";
        }
        if (i == 2) {
            return "audio";
        }
        if (i != 3) {
            return null;
        }
        return "video";
    }
}
