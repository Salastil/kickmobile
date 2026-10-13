package com.mux.stats.sdk.core.events;

/* JADX INFO: loaded from: classes8.dex */
public interface IEventListener {
    void flush();

    int getId();

    void handle(IEvent iEvent);

    void setId(int i);
}
