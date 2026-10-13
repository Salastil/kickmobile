package com.mux.stats.sdk.core.events.playback;

import com.mux.stats.sdk.core.model.PlayerData;

/* JADX INFO: loaded from: classes8.dex */
public class SeekingEvent extends PlaybackEvent {
    public static final String TYPE = "seeking";

    public SeekingEvent(PlayerData playerData) {
        super(playerData);
        this.isSuppressed = true;
    }

    @Override // com.mux.stats.sdk.core.events.BaseEvent, com.mux.stats.sdk.core.events.IEvent
    public String getType() {
        return TYPE;
    }

    public void setIsSuppressed(boolean z) {
        this.isSuppressed = z;
    }
}
