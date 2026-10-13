package com.mux.stats.sdk.core.trackers;

import com.mux.stats.sdk.core.events.IEventDispatcher;
import com.mux.stats.sdk.core.events.ViewMetricEvent;
import com.mux.stats.sdk.core.events.playback.AdEvent;
import com.mux.stats.sdk.core.events.playback.InternalHeartbeatEndEvent;
import com.mux.stats.sdk.core.events.playback.InternalHeartbeatEvent;
import com.mux.stats.sdk.core.events.playback.PlaybackEvent;
import com.mux.stats.sdk.core.events.playback.SeekedEvent;
import com.mux.stats.sdk.core.events.playback.SeekingEvent;
import com.mux.stats.sdk.core.events.playback.ViewInitEvent;
import com.mux.stats.sdk.core.model.ViewData;
import com.mux.stats.sdk.core.util.CurrentTime;
import com.mux.stats.sdk.core.util.MuxLogger;
import org.json.JSONException;

/* JADX INFO: loaded from: classes8.dex */
public class PlaybackTimeTracker extends BaseTracker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f259a;
    private long b;
    private long c;
    private long d;
    private final CurrentTime e;
    private boolean f;

    public PlaybackTimeTracker(IEventDispatcher iEventDispatcher) {
        super(iEventDispatcher);
        this.f259a = -1L;
        this.b = 0L;
        this.c = -1L;
        this.d = -1L;
        this.e = new CurrentTime();
    }

    public PlaybackTimeTracker(IEventDispatcher iEventDispatcher, CurrentTime currentTime) {
        super(iEventDispatcher);
        this.f259a = -1L;
        this.b = 0L;
        this.c = -1L;
        this.d = -1L;
        this.e = currentTime;
    }

    private void a(long j) throws JSONException {
        long jNow = this.e.now();
        boolean z = this.f;
        long j2 = z ? jNow - this.d : j - this.f259a;
        long j3 = this.f259a;
        if ((j3 >= 0 && j > j3) || z) {
            if (j2 <= 1000) {
                this.b += j2;
                ViewData viewData = new ViewData();
                viewData.setViewContentPlaybackTime(Long.valueOf(this.b));
                long j4 = this.c;
                if (j4 > -1) {
                    viewData.setViewMaxPlayheadPosition(Long.valueOf(j4));
                }
                dispatch(new ViewMetricEvent(viewData));
            } else {
                MuxLogger.d("PlaybackTimeTracker", "Playhead position jump of over 1 seconds detected.");
            }
        }
        this.d = jNow;
        this.f259a = j;
    }

    @Override // com.mux.stats.sdk.core.trackers.BaseTracker
    protected void handlePlaybackEvent(PlaybackEvent playbackEvent) throws JSONException {
        Long playerPlayheadTime = playbackEvent.getPlayerData().getPlayerPlayheadTime();
        if (playerPlayheadTime == null) {
            return;
        }
        String type = playbackEvent.getType();
        if (playerPlayheadTime.longValue() > this.c) {
            this.c = playerPlayheadTime.longValue();
        }
        if (playbackEvent.isAd()) {
            String type2 = ((AdEvent) playbackEvent).getType();
            type2.hashCode();
            switch (type2) {
                case "adplaying":
                    this.f = true;
                    break;
                case "adplay":
                case "adended":
                case "adpause":
                case "adbreakstart":
                case "adbreakend":
                    this.f = false;
                    this.d = 0L;
                    break;
            }
        }
        if (InternalHeartbeatEvent.TYPE.equals(type)) {
            a(playerPlayheadTime.longValue());
            return;
        }
        if (InternalHeartbeatEndEvent.TYPE.equals(type) || SeekingEvent.TYPE.equals(type)) {
            a(playerPlayheadTime.longValue());
            this.f259a = -1L;
            this.d = -1L;
        } else {
            if (SeekedEvent.TYPE.equals(type)) {
                this.f259a = playerPlayheadTime.longValue();
                return;
            }
            if (ViewInitEvent.TYPE.equals(type)) {
                this.f259a = -1L;
                this.b = 0L;
                this.c = -1L;
                this.d = -1L;
                this.f = false;
            }
        }
    }
}
