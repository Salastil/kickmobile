package com.reactnative.googlecast.types;

/* JADX INFO: loaded from: classes8.dex */
public class RNGCMediaQueueType {
    public static int fromJson(String str) {
        str.hashCode();
        switch (str) {
            case "podcastSeries":
                return 5;
            case "liveTv":
                return 8;
            case "album":
                return 1;
            case "movie":
                return 9;
            case "tvSeries":
                return 6;
            case "audioBook":
                return 3;
            case "radioStation":
                return 4;
            case "videoPlaylist":
                return 7;
            case "playlist":
                return 2;
            default:
                return 0;
        }
    }

    public static String toJson(int i) {
        switch (i) {
            case 1:
                return "album";
            case 2:
                return "playlist";
            case 3:
                return "audioBook";
            case 4:
                return "radioStation";
            case 5:
                return "podcastSeries";
            case 6:
                return "tvSeries";
            case 7:
                return "videoPlaylist";
            case 8:
                return "liveTv";
            case 9:
                return "movie";
            default:
                return null;
        }
    }
}
