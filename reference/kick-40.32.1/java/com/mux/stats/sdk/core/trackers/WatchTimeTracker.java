package com.mux.stats.sdk.core.trackers;

import com.mux.stats.sdk.core.events.IEventDispatcher;
import com.mux.stats.sdk.core.events.ViewMetricEvent;
import com.mux.stats.sdk.core.events.playback.InternalHeartbeatEndEvent;
import com.mux.stats.sdk.core.events.playback.InternalHeartbeatEvent;
import com.mux.stats.sdk.core.events.playback.PlaybackEvent;
import com.mux.stats.sdk.core.events.playback.ViewInitEvent;
import com.mux.stats.sdk.core.model.ViewData;
import org.json.JSONException;

/* JADX INFO: loaded from: classes8.dex */
public class WatchTimeTracker extends BaseTracker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f269a;
    private long b;

    public WatchTimeTracker(IEventDispatcher iEventDispatcher) throws JSONException {
        super(iEventDispatcher);
        this.f269a = 0L;
        this.b = 0L;
        ViewData viewData = new ViewData();
        viewData.setViewWatchTime(0L);
        dispatch(new ViewMetricEvent(viewData));
    }

    private void a(long j) throws JSONException {
        long j2 = this.f269a;
        if (j2 > 0) {
            this.b += j - j2;
            ViewData viewData = new ViewData();
            viewData.setViewWatchTime(Long.valueOf(this.b));
            dispatch(new ViewMetricEvent(viewData));
        }
    }

    @Override // com.mux.stats.sdk.core.trackers.BaseTracker
    protected void handlePlaybackEvent(PlaybackEvent playbackEvent) throws JSONException {
        String type = playbackEvent.getType();
        if (InternalHeartbeatEvent.TYPE.equals(type)) {
            long jLongValue = playbackEvent.getViewData().getViewerTime().longValue();
            a(jLongValue);
            this.f269a = jLongValue;
        } else if (InternalHeartbeatEndEvent.TYPE.equals(type)) {
            a(playbackEvent.getViewData().getViewerTime().longValue());
            this.f269a = 0L;
        } else if (ViewInitEvent.TYPE.equals(type)) {
            this.f269a = 0L;
            this.b = 0L;
        }
    }
}
