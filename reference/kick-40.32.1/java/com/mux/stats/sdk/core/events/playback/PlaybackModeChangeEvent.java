package com.mux.stats.sdk.core.events.playback;

import com.google.common.collect.ImmutableSet;
import com.mux.stats.sdk.core.model.PlayerData;
import java.util.Set;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes8.dex */
public class PlaybackModeChangeEvent extends PlaybackEvent {
    public static final String TYPE = "playbackmodechange";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Set<String> f245a = ImmutableSet.of(PlayerData.PLAYER_PLAYBACK_MODE, PlayerData.PLAYER_PLAYBACK_MODE_DATA);

    public PlaybackModeChangeEvent(PlayerData playerData) {
        super(playerData);
    }

    @Override // com.mux.stats.sdk.core.events.BaseEvent, com.mux.stats.sdk.core.events.IEvent
    @Nonnull
    public Set<String> getRequiredProperties() {
        return f245a;
    }

    @Override // com.mux.stats.sdk.core.events.BaseEvent, com.mux.stats.sdk.core.events.IEvent
    public String getType() {
        return TYPE;
    }
}
