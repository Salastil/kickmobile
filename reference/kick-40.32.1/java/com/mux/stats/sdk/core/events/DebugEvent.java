package com.mux.stats.sdk.core.events;

/* JADX INFO: loaded from: classes8.dex */
public class DebugEvent extends BaseEvent {
    public static final String TYPE = "DebugEvent";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f234a;

    public DebugEvent(String str) {
        this.f234a = str;
    }

    public String getData() {
        return this.f234a;
    }

    @Override // com.mux.stats.sdk.core.events.BaseEvent, com.mux.stats.sdk.core.events.IEvent
    public String getDebugString() {
        return "DebugEvent: \n  data: " + this.f234a + "\n  isDebug: true";
    }

    @Override // com.mux.stats.sdk.core.events.BaseEvent, com.mux.stats.sdk.core.events.IEvent
    public String getType() {
        return TYPE;
    }

    @Override // com.mux.stats.sdk.core.events.BaseEvent, com.mux.stats.sdk.core.events.IEvent
    public boolean isDebug() {
        return true;
    }
}
