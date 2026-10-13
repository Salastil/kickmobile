package com.reactnative.googlecast.types;

/* JADX INFO: loaded from: classes8.dex */
public class RNGCMediaTextTrackSubtype {
    public static int fromJson(String str) {
        str.hashCode();
        switch (str) {
            case "descriptions":
                return 3;
            case "metadata":
                return 5;
            case "captions":
                return 2;
            case "subtitles":
                return 1;
            case "chapters":
                return 4;
            default:
                return -1;
        }
    }

    public static String toJson(int i) {
        if (i == 1) {
            return "subtitles";
        }
        if (i == 2) {
            return "captions";
        }
        if (i == 3) {
            return "descriptions";
        }
        if (i == 4) {
            return "chapters";
        }
        if (i != 5) {
            return null;
        }
        return "metadata";
    }
}
