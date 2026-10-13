package com.mux.stats.sdk.core.trackers;

import com.mux.stats.sdk.core.events.IEventDispatcher;
import com.mux.stats.sdk.core.events.ViewMetricEvent;
import com.mux.stats.sdk.core.events.playback.PlaybackEvent;
import com.mux.stats.sdk.core.events.playback.RebufferEndEvent;
import com.mux.stats.sdk.core.model.ViewData;
import org.json.JSONException;

/* JADX INFO: loaded from: classes8.dex */
public class RebufferTracker extends BaseAdTracker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f262a;
    private int b;
    private double c;
    private long d;
    private double e;
    private double f;
    private Long g;

    public RebufferTracker(IEventDispatcher iEventDispatcher) {
        super(iEventDispatcher);
        this.f262a = false;
        this.b = 0;
        this.c = 0.0d;
        this.d = 0L;
        this.e = 0.0d;
        this.f = 0.0d;
        this.g = 0L;
    }

    private void a(PlaybackEvent playbackEvent) throws JSONException {
        ViewData viewData = new ViewData();
        Long viewerTime = playbackEvent.getViewData().getViewerTime();
        viewerTime.longValue();
        if (viewerTime != null && this.g != null && viewerTime.longValue() - this.g.longValue() > 0 && this.f262a) {
            this.d += viewerTime.longValue() - this.g.longValue();
            this.g = viewerTime;
        }
        viewData.setViewRebufferCount(Integer.valueOf(this.b));
        viewData.setViewRebufferDuration(Long.valueOf(this.d));
        if (playbackEvent.getViewData().getViewWatchTime() != null && playbackEvent.getViewData().getViewWatchTime().longValue() > 0) {
            double d = this.b;
            double d2 = this.c;
            double d3 = d / d2;
            this.e = d3;
            this.f = this.d / d2;
            viewData.setViewRebufferFrequency(Double.valueOf(d3));
            viewData.setViewRebufferPercentage(Double.valueOf(this.f));
        }
        dispatch(new ViewMetricEvent(viewData));
    }

    @Override // com.mux.stats.sdk.core.trackers.BaseAdTracker, com.mux.stats.sdk.core.trackers.BaseTracker
    protected void handlePlaybackEvent(PlaybackEvent playbackEvent) throws JSONException {
        String type = playbackEvent.getType();
        if (playbackEvent.getViewData() != null && playbackEvent.getViewData().getViewWatchTime() != null) {
            this.c = playbackEvent.getViewData().getViewWatchTime().longValue();
        }
        type.hashCode();
        switch (type) {
            case "rebufferend":
                a(playbackEvent);
                this.f262a = false;
                break;
            case "internalheartbeat":
            case "internalheartbeatend":
                a(playbackEvent);
                break;
            case "rebufferstart":
                if (!this.f262a) {
                    this.f262a = true;
                    this.b++;
                    if (playbackEvent.getViewData().getViewerTime() != null) {
                        Long viewerTime = playbackEvent.getViewData().getViewerTime();
                        viewerTime.longValue();
                        this.g = viewerTime;
                    }
                    a(playbackEvent);
                    break;
                }
                break;
            case "viewinit":
                this.f262a = false;
                this.b = 0;
                this.c = 0.0d;
                this.d = 0L;
                this.e = 0.0d;
                this.f = 0.0d;
                this.g = 0L;
                break;
            case "seeking":
                if (this.f262a) {
                    dispatch(new RebufferEndEvent(playbackEvent.getPlayerData()));
                    break;
                }
                break;
        }
    }
}
