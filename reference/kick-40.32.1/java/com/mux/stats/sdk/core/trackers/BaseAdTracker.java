package com.mux.stats.sdk.core.trackers;

import com.mux.stats.sdk.core.events.IEventDispatcher;
import com.mux.stats.sdk.core.events.playback.PlaybackEvent;

/* JADX INFO: loaded from: classes8.dex */
public class BaseAdTracker extends BaseTracker {
    protected boolean isAdBreak;

    public BaseAdTracker(IEventDispatcher iEventDispatcher) {
        super(iEventDispatcher);
        this.isAdBreak = false;
    }

    @Override // com.mux.stats.sdk.core.trackers.BaseTracker
    protected void handlePlaybackEvent(PlaybackEvent playbackEvent) {
        String type = playbackEvent.getType();
        type.hashCode();
        switch (type) {
            case "playing":
            case "play":
            case "viewend":
            case "viewinit":
            case "seeking":
                this.isAdBreak = false;
                break;
            case "adbreakstart":
                this.isAdBreak = true;
                break;
        }
    }
}
