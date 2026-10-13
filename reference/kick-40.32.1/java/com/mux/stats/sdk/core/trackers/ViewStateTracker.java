package com.mux.stats.sdk.core.trackers;

import com.mux.stats.sdk.core.events.IEventDispatcher;
import com.mux.stats.sdk.core.events.playback.PlaybackEvent;
import com.mux.stats.sdk.core.events.playback.ViewStartEvent;

/* JADX INFO: loaded from: classes8.dex */
public class ViewStateTracker extends BaseTracker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f266a;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unexpected branching in enum static init block */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f267a = 1;
        public static final int b = 2;
        public static final int c = 3;
    }

    public ViewStateTracker(IEventDispatcher iEventDispatcher) {
        super(iEventDispatcher);
        this.f266a = a.f267a;
    }

    @Override // com.mux.stats.sdk.core.trackers.BaseTracker
    protected void handlePlaybackEvent(PlaybackEvent playbackEvent) {
        String type = playbackEvent.getType();
        type.hashCode();
        switch (type) {
            case "play":
            case "adbreakstart":
                if (this.f266a == a.b) {
                    this.f266a = a.c;
                    dispatch(new ViewStartEvent(playbackEvent.getPlayerData()));
                    break;
                }
                break;
            case "viewinit":
                this.f266a = a.b;
                break;
        }
    }
}
