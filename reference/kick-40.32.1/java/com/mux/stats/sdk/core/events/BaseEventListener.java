package com.mux.stats.sdk.core.events;

/* JADX INFO: loaded from: classes8.dex */
public class BaseEventListener implements IEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f233a;

    @Override // com.mux.stats.sdk.core.events.IEventListener
    public void flush() {
    }

    @Override // com.mux.stats.sdk.core.events.IEventListener
    public int getId() {
        return this.f233a;
    }

    @Override // com.mux.stats.sdk.core.events.IEventListener
    public void handle(IEvent iEvent) {
    }

    @Override // com.mux.stats.sdk.core.events.IEventListener
    public void setId(int i) {
        this.f233a = i;
    }
}
