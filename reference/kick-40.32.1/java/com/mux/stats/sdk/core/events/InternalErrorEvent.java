package com.mux.stats.sdk.core.events;

/* JADX INFO: loaded from: classes8.dex */
public class InternalErrorEvent extends BaseEvent {
    public static final String TYPE = "internalerror";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f236a;
    private final int b;
    private final String c;

    public InternalErrorEvent(int i, String str) {
        this(i, str, null);
    }

    public InternalErrorEvent(int i, String str, String str2) {
        this.b = i;
        this.f236a = str;
        this.c = str2;
    }

    @Override // com.mux.stats.sdk.core.events.BaseEvent, com.mux.stats.sdk.core.events.IEvent
    public String getDebugString() {
        return "InternalErrorEvent: \n    errorMessage: " + this.f236a + "\n    errorCode: " + this.b + "\n    errorContext: " + this.c;
    }

    public int getErrorCode() {
        return this.b;
    }

    public String getErrorContext() {
        return this.c;
    }

    public String getErrorMessage() {
        return this.f236a;
    }

    @Override // com.mux.stats.sdk.core.events.BaseEvent, com.mux.stats.sdk.core.events.IEvent
    public String getType() {
        return TYPE;
    }

    @Override // com.mux.stats.sdk.core.events.BaseEvent, com.mux.stats.sdk.core.events.IEvent
    public boolean isError() {
        return true;
    }
}
