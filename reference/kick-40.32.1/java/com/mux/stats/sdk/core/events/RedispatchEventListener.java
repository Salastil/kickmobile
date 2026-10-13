package com.mux.stats.sdk.core.events;

/* JADX INFO: loaded from: classes8.dex */
public class RedispatchEventListener extends BaseEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IEventDispatcher f237a;

    public RedispatchEventListener(IEventDispatcher iEventDispatcher) {
        this.f237a = iEventDispatcher;
    }

    @Override // com.mux.stats.sdk.core.events.BaseEventListener, com.mux.stats.sdk.core.events.IEventListener
    public void handle(IEvent iEvent) {
        if (iEvent.isPlayback()) {
            return;
        }
        this.f237a.dispatch(iEvent);
    }
}
