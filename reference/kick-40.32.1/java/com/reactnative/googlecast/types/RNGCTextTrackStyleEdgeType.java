package com.reactnative.googlecast.types;

/* JADX INFO: loaded from: classes8.dex */
public class RNGCTextTrackStyleEdgeType {
    public static int fromJson(String str) {
        str.hashCode();
        switch (str) {
            case "outline":
                return 1;
            case "raised":
                return 3;
            case "depressed":
                return 4;
            case "none":
                return 0;
            case "dropShadow":
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
            return "outline";
        }
        if (i == 2) {
            return "dropShadow";
        }
        if (i == 3) {
            return "raised";
        }
        if (i != 4) {
            return null;
        }
        return "depressed";
    }
}
