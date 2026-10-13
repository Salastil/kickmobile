package com.mux.stats.sdk.core.trackers;

import com.mux.stats.sdk.core.events.IEventDispatcher;
import com.mux.stats.sdk.core.events.ViewMetricEvent;
import com.mux.stats.sdk.core.events.playback.PlaybackEvent;
import com.mux.stats.sdk.core.events.playback.SeekingEvent;
import com.mux.stats.sdk.core.model.ViewData;
import org.json.JSONException;

/* JADX INFO: loaded from: classes8.dex */
public class SeekingTracker extends BaseTracker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f264a;
    private boolean b;
    private int c;
    private long d;
    private long e;

    public SeekingTracker(IEventDispatcher iEventDispatcher) {
        super(iEventDispatcher);
        this.f264a = 0L;
        this.b = false;
        this.c = 0;
        this.d = 0L;
        this.e = 0L;
    }

    @Override // com.mux.stats.sdk.core.trackers.BaseTracker
    protected void handlePlaybackEvent(PlaybackEvent playbackEvent) throws JSONException {
        String type = playbackEvent.getType();
        type.hashCode();
        switch (type) {
            case "seeked":
                Long viewerTime = playbackEvent.getViewData().getViewerTime();
                if (this.f264a > 0) {
                    this.c++;
                    long jLongValue = viewerTime.longValue() - this.f264a;
                    this.d += jLongValue;
                    if (jLongValue > this.e) {
                        this.e = jLongValue;
                    }
                    ViewData viewData = new ViewData();
                    viewData.setViewSeekCount(Integer.valueOf(this.c));
                    viewData.setViewSeekDuration(Long.valueOf(this.d));
                    viewData.setViewMaxSeekTime(Long.valueOf(this.e));
                    dispatch(new ViewMetricEvent(viewData));
                }
                this.b = false;
                this.f264a = 0L;
                break;
            case "viewend":
                this.b = false;
                break;
            case "viewinit":
                this.f264a = 0L;
                this.b = false;
                this.c = 0;
                this.d = 0L;
                this.e = 0L;
                break;
            case "seeking":
                Long viewerTime2 = playbackEvent.getViewData().getViewerTime();
                if (!this.b) {
                    this.b = true;
                    SeekingEvent seekingEvent = new SeekingEvent(playbackEvent.getPlayerData());
                    seekingEvent.setIsSuppressed(false);
                    seekingEvent.setViewData(playbackEvent.getViewData());
                    dispatch(seekingEvent);
                }
                this.f264a = viewerTime2.longValue();
                break;
        }
    }
}
