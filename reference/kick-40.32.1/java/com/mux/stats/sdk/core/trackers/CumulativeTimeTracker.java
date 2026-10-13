package com.mux.stats.sdk.core.trackers;

import com.mux.stats.sdk.core.events.IEventDispatcher;
import com.mux.stats.sdk.core.events.ViewMetricEvent;
import com.mux.stats.sdk.core.events.playback.AdPlayingEvent;
import com.mux.stats.sdk.core.events.playback.PlaybackEvent;
import com.mux.stats.sdk.core.events.playback.ViewEndEvent;
import com.mux.stats.sdk.core.events.playback.ViewInitEvent;
import com.mux.stats.sdk.core.model.AdData;
import com.mux.stats.sdk.core.model.ViewData;
import com.mux.stats.sdk.core.util.CurrentTime;
import com.mux.stats.sdk.core.util.MuxLogger;
import com.mux.stats.sdk.core.util.Util;
import java.util.concurrent.Callable;
import org.json.JSONException;

/* JADX INFO: loaded from: classes8.dex */
public class CumulativeTimeTracker extends BaseTracker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CurrentTime f254a;
    private long b;
    private boolean c;
    private boolean d;
    private long e;
    private long f;

    public CumulativeTimeTracker(IEventDispatcher iEventDispatcher) {
        this(iEventDispatcher, new CurrentTime());
    }

    public CumulativeTimeTracker(IEventDispatcher iEventDispatcher, CurrentTime currentTime) {
        super(iEventDispatcher);
        this.b = -1L;
        this.c = false;
        this.d = false;
        this.e = 0L;
        this.f = 0L;
        this.f254a = currentTime;
    }

    @Override // com.mux.stats.sdk.core.trackers.BaseTracker
    public void handlePlaybackEvent(PlaybackEvent playbackEvent) throws JSONException {
        boolean z;
        String type = playbackEvent.getType();
        long jNow = this.f254a.now();
        if (ViewInitEvent.TYPE.equals(type)) {
            this.b = -1L;
            this.c = false;
            this.d = false;
            this.f = 0L;
            this.e = 0L;
            ViewData viewData = new ViewData();
            viewData.setViewPlayingTimeMsCumulative(0L);
            dispatch(new ViewMetricEvent(viewData));
        }
        Boolean playerIsPaused = playbackEvent.getPlayerData().getPlayerIsPaused();
        boolean zEquals = AdPlayingEvent.TYPE.equals(type);
        type.hashCode();
        switch (type) {
            case "rebufferend":
            case "seeked":
                if (playerIsPaused == null || playerIsPaused.booleanValue()) {
                    z = false;
                    break;
                }
            case "adplaying":
            case "playing":
                z = true;
                break;
            default:
                z = false;
                break;
        }
        if (zEquals) {
            this.c = true;
            this.b = jNow;
        }
        if (z) {
            this.d = true;
            this.b = jNow;
        }
        if (this.d) {
            this.f += jNow - this.b;
            ViewData viewData2 = new ViewData();
            viewData2.setViewPlayingTimeMsCumulative(Long.valueOf(this.f));
            dispatch(new ViewMetricEvent(viewData2));
        }
        if (this.c) {
            this.e += jNow - this.b;
        }
        if (this.e > 0) {
            AdData adData = (AdData) Util.lazyGet(playbackEvent.getAdData(), new Callable() { // from class: com.mux.stats.sdk.core.trackers.CumulativeTimeTracker$$ExternalSyntheticLambda0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return new AdData();
                }
            });
            adData.setAdPlayingTimeMsCumulative(Long.valueOf(this.e));
            playbackEvent.setAdData(adData);
        }
        this.b = this.f254a.now();
        type.hashCode();
        switch (type) {
            case "adended":
            case "adpause":
            case "rebufferstart":
            case "ended":
            case "pause":
            case "viewend":
            case "adbreakstart":
            case "seeking":
                this.c = false;
                this.d = false;
                this.b = -1L;
                break;
        }
        if (ViewEndEvent.TYPE.equals(type)) {
            MuxLogger.d("CumulativeTimeTracker", "Ending View: Total Ad Time: " + this.e);
            MuxLogger.d("CumulativeTimeTracker", "Ending View: Total Cumulative Time: " + this.f);
        }
    }
}
