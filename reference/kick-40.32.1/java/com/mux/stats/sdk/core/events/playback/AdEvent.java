package com.mux.stats.sdk.core.events.playback;

import com.mux.stats.sdk.core.model.AdData;
import com.mux.stats.sdk.core.model.PlayerData;

/* JADX INFO: loaded from: classes8.dex */
public abstract class AdEvent extends PlaybackEvent {
    public AdEvent(PlayerData playerData) {
        super(playerData);
    }

    public AdEvent(PlayerData playerData, AdData adData) {
        super(playerData);
        setAdData(adData);
    }

    @Override // com.mux.stats.sdk.core.events.playback.PlaybackEvent
    public boolean isAd() {
        return true;
    }
}
