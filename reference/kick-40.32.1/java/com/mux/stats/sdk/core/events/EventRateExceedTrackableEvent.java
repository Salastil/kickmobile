package com.mux.stats.sdk.core.events;

/* JADX INFO: loaded from: classes8.dex */
public class EventRateExceedTrackableEvent extends TrackableEvent {
    public static final String TYPE = "eventrateexceeded";

    public EventRateExceedTrackableEvent(TrackableEvent trackableEvent) {
        super(TYPE);
        getQuery().update(trackableEvent.getQuery());
    }
}
