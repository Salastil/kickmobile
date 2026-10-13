package com.reactnative.googlecast.types;

import com.mux.stats.sdk.core.events.playback.PauseEvent;
import com.mux.stats.sdk.core.events.playback.PlayEvent;

/* JADX INFO: loaded from: classes7.dex */
public class RNGCMediaResumeState {
    public static int fromJson(String str) {
        str.hashCode();
        if (str.equals(PlayEvent.TYPE)) {
            return 1;
        }
        return !str.equals(PauseEvent.TYPE) ? 0 : 2;
    }
}
