package com.mux.stats.sdk.core.events;

import java.util.Collections;
import java.util.Set;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes8.dex */
public class BaseEvent implements IEvent {
    public static final String TYPE = "BaseEvent";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Set<String> f232a = Collections.EMPTY_SET;

    @Override // com.mux.stats.sdk.core.events.IEvent
    public String getDebugString() {
        return "type: " + getType() + "\nisTrackable: false\nisPlayback: false\nisData: false\nisError: false\nisViewMetrics: false\nisDebug: false";
    }

    @Override // com.mux.stats.sdk.core.events.IEvent
    @Nonnull
    public Set<String> getRequiredProperties() {
        return f232a;
    }

    @Override // com.mux.stats.sdk.core.events.IEvent
    public String getType() {
        return TYPE;
    }

    @Override // com.mux.stats.sdk.core.events.IEvent
    public boolean isData() {
        return false;
    }

    @Override // com.mux.stats.sdk.core.events.IEvent
    public boolean isDebug() {
        return false;
    }

    @Override // com.mux.stats.sdk.core.events.IEvent
    public boolean isError() {
        return false;
    }

    @Override // com.mux.stats.sdk.core.events.IEvent
    public boolean isPlayback() {
        return false;
    }

    @Override // com.mux.stats.sdk.core.events.IEvent
    public boolean isSessionData() {
        return false;
    }

    @Override // com.mux.stats.sdk.core.events.IEvent
    public boolean isTrackable() {
        return false;
    }

    @Override // com.mux.stats.sdk.core.events.IEvent
    public boolean isViewMetric() {
        return false;
    }
}
