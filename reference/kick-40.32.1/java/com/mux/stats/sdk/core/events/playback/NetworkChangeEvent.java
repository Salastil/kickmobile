package com.mux.stats.sdk.core.events.playback;

import com.google.common.collect.ImmutableSet;
import com.mux.stats.sdk.core.model.PlayerData;
import com.mux.stats.sdk.core.model.ViewerData;
import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.json.JSONException;

/* JADX INFO: loaded from: classes8.dex */
public class NetworkChangeEvent extends PlaybackEvent {
    public static final String TYPE = "networkchange";

    public NetworkChangeEvent(PlayerData playerData) {
        super(playerData);
    }

    public NetworkChangeEvent(PlayerData playerData, @Nonnull String str) throws JSONException {
        super(playerData);
        ViewerData viewerData = new ViewerData();
        viewerData.setViewerConnectionType(str);
        setViewerData(viewerData);
    }

    public NetworkChangeEvent(PlayerData playerData, @Nonnull String str, @Nullable Boolean bool) throws JSONException {
        super(playerData);
        ViewerData viewerData = new ViewerData();
        viewerData.setViewerConnectionType(str);
        viewerData.setViewerConnectionLowDataMode(bool);
        setViewerData(viewerData);
    }

    @Override // com.mux.stats.sdk.core.events.BaseEvent, com.mux.stats.sdk.core.events.IEvent
    @Nonnull
    public Set<String> getRequiredProperties() {
        return ImmutableSet.of(ViewerData.VIEWER_CONNECTION_TYPE, ViewerData.VIEWER_CONNECTION_LOW_DATA_MODE);
    }

    @Override // com.mux.stats.sdk.core.events.BaseEvent, com.mux.stats.sdk.core.events.IEvent
    public String getType() {
        return TYPE;
    }
}
