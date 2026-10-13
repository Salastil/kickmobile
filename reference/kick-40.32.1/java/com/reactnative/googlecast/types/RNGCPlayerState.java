package com.reactnative.googlecast.types;

import com.mux.stats.sdk.core.events.playback.PlayingEvent;

/* JADX INFO: loaded from: classes8.dex */
public class RNGCPlayerState {
    public static int fromJson(String str) {
        switch (str.hashCode()) {
            case -995321554:
                return str.equals("paused") ? 3 : 0;
            case -493563858:
                return str.equals(PlayingEvent.TYPE) ? 2 : 0;
            case 3227604:
                return str.equals("idle") ? 1 : 0;
            case 61512610:
                return str.equals("buffering") ? 4 : 0;
            case 336650556:
                str.equals("loading");
                return 0;
            default:
                return 0;
        }
    }

    public static String toJson(int i) {
        if (i == 1) {
            return "idle";
        }
        if (i == 2) {
            return PlayingEvent.TYPE;
        }
        if (i == 3) {
            return "paused";
        }
        if (i != 4) {
            return null;
        }
        return "buffering";
    }
}
