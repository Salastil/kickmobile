package com.mux.stats.sdk.core.trackers;

import com.mux.stats.sdk.core.events.IEventDispatcher;
import com.mux.stats.sdk.core.events.ViewMetricEvent;
import com.mux.stats.sdk.core.events.playback.AdBreakStartEvent;
import com.mux.stats.sdk.core.events.playback.PauseEvent;
import com.mux.stats.sdk.core.events.playback.PlaybackEvent;
import com.mux.stats.sdk.core.events.playback.PlayingEvent;
import com.mux.stats.sdk.core.events.playback.RebufferStartEvent;
import com.mux.stats.sdk.core.events.playback.SeekingEvent;
import com.mux.stats.sdk.core.events.playback.TimeUpdateEvent;
import com.mux.stats.sdk.core.events.playback.ViewEndEvent;
import com.mux.stats.sdk.core.events.playback.ViewInitEvent;
import com.mux.stats.sdk.core.model.PlayerData;
import com.mux.stats.sdk.core.model.VideoData;
import com.mux.stats.sdk.core.model.ViewData;
import java.util.HashSet;
import org.json.JSONException;

/* JADX INFO: loaded from: classes8.dex */
public class ScalingTracker extends BaseAdTracker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Long f263a;
    private Integer b;
    private Integer c;
    private Integer d;
    private Integer e;
    private final HashSet<String> f;
    private final HashSet<String> g;
    private long h;
    private double i;
    private double j;
    private double k;
    private double l;

    public ScalingTracker(IEventDispatcher iEventDispatcher) {
        super(iEventDispatcher);
        this.h = 0L;
        this.i = 0.0d;
        this.j = 0.0d;
        this.k = 0.0d;
        this.l = 0.0d;
        HashSet<String> hashSet = new HashSet<>();
        this.f = hashSet;
        hashSet.add(PauseEvent.TYPE);
        hashSet.add(RebufferStartEvent.TYPE);
        hashSet.add(SeekingEvent.TYPE);
        hashSet.add(AdBreakStartEvent.TYPE);
        hashSet.add(TimeUpdateEvent.TYPE);
        hashSet.add(ViewEndEvent.TYPE);
        hashSet.add("error");
        HashSet<String> hashSet2 = new HashSet<>();
        this.g = hashSet2;
        hashSet2.add(PlayingEvent.TYPE);
        hashSet2.add(TimeUpdateEvent.TYPE);
    }

    @Override // com.mux.stats.sdk.core.trackers.BaseAdTracker, com.mux.stats.sdk.core.trackers.BaseTracker
    protected void handlePlaybackEvent(PlaybackEvent playbackEvent) throws JSONException {
        Long playerPlayheadTime;
        Integer num;
        if (ViewInitEvent.TYPE.equals(playbackEvent.getType())) {
            this.f263a = null;
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = null;
            this.h = 0L;
            this.i = 0.0d;
            this.j = 0.0d;
            this.k = 0.0d;
            this.l = 0.0d;
        }
        super.handlePlaybackEvent(playbackEvent);
        if (this.f.contains(playbackEvent.getType()) && (playerPlayheadTime = playbackEvent.getPlayerData().getPlayerPlayheadTime()) != null) {
            long jLongValue = playerPlayheadTime.longValue();
            if (!this.isAdBreak && this.f263a != null && (num = this.b) != null && this.c != null && this.d != null && this.e != null && num.intValue() > 0 && this.c.intValue() > 0 && this.d.intValue() > 0 && this.e.intValue() > 0) {
                long jLongValue2 = jLongValue - this.f263a.longValue();
                if (jLongValue2 >= 0) {
                    double dMin = Math.min(((double) this.b.intValue()) / ((double) this.d.intValue()), ((double) this.c.intValue()) / ((double) this.e.intValue()));
                    double dMax = Math.max(0.0d, dMin - 1.0d);
                    double dMax2 = Math.max(0.0d, 1.0d - dMin);
                    this.i = Math.max(this.i, dMax);
                    this.j = Math.max(this.j, dMax2);
                    this.h += jLongValue2;
                    double d = jLongValue2;
                    this.k += dMax * d;
                    this.l += dMax2 * d;
                    ViewData viewData = new ViewData();
                    viewData.setViewMaxUpscalePercentage(Double.valueOf(this.i));
                    viewData.setViewMaxDownscalePercentage(Double.valueOf(this.j));
                    viewData.setViewTotalContentPlaybackTime(Long.valueOf(this.h));
                    viewData.setViewTotalUpscaling(Double.valueOf(this.k));
                    viewData.setViewTotalDownscaling(Double.valueOf(this.l));
                    dispatch(new ViewMetricEvent(viewData));
                }
            }
            this.f263a = null;
        }
        if (this.g.contains(playbackEvent.getType())) {
            PlayerData playerData = playbackEvent.getPlayerData();
            this.f263a = playerData.getPlayerPlayheadTime();
            this.b = playerData.getPlayerWidth();
            this.c = playerData.getPlayerHeight();
            VideoData videoData = playbackEvent.getVideoData();
            this.d = videoData.getVideoSourceWidth();
            this.e = videoData.getVideoSourceHeight();
        }
    }
}
