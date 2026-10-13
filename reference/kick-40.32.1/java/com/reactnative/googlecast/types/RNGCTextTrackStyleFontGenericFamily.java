package com.reactnative.googlecast.types;

import androidx.media3.common.C;

/* JADX INFO: loaded from: classes8.dex */
public class RNGCTextTrackStyleFontGenericFamily {
    public static int fromJson(String str) {
        str.hashCode();
        switch (str) {
            case "smallCaps":
                return 6;
            case "monoSerif":
                return 3;
            case "casual":
                return 4;
            case "monoSansSerif":
                return 1;
            case "serif":
                return 2;
            case "cursive":
                return 5;
            case "sansSerif":
                return 0;
            default:
                return -1;
        }
    }

    public static String toJson(int i) {
        switch (i) {
            case 0:
                return "sansSerif";
            case 1:
                return "monoSansSerif";
            case 2:
                return C.SERIF_NAME;
            case 3:
                return "monoSerif";
            case 4:
                return "casual";
            case 5:
                return "cursive";
            case 6:
                return "smallCaps";
            default:
                return null;
        }
    }
}
