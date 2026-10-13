package com.mux.stats.sdk.core.events.playback;

import com.mux.stats.sdk.core.model.PlayerData;

/* JADX INFO: loaded from: classes8.dex */
public class EndedEvent extends PlaybackEvent {
    public static final String TYPE = "ended";

    public EndedEvent(PlayerData playerData) {
        super(playerData);
    }

    @Override // com.mux.stats.sdk.core.events.BaseEvent, com.mux.stats.sdk.core.events.IEvent
    public String getType() {
        return TYPE;
    }
}
