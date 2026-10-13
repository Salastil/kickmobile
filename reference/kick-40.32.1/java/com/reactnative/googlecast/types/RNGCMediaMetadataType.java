package com.reactnative.googlecast.types;

/* JADX INFO: loaded from: classes7.dex */
public class RNGCMediaMetadataType {
    public static int fromJson(String str) {
        str.hashCode();
        switch (str) {
            case "tvShow":
                return 2;
            case "musicTrack":
                return 3;
            case "generic":
                return 0;
            case "movie":
                return 1;
            case "photo":
                return 4;
            default:
                return 100;
        }
    }

    public static String toJson(int i) {
        if (i == 0) {
            return "generic";
        }
        if (i == 1) {
            return "movie";
        }
        if (i == 2) {
            return "tvShow";
        }
        if (i == 3) {
            return "musicTrack";
        }
        if (i != 4) {
            return null;
        }
        return "photo";
    }
}
