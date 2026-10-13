package com.mux.stats.sdk.core.trackers;

import com.mux.stats.sdk.core.CoreView;
import com.mux.stats.sdk.core.events.data.DataEvent;
import com.mux.stats.sdk.core.events.playback.AdBreakStartEvent;
import com.mux.stats.sdk.core.events.playback.InternalHeartbeatEndEvent;
import com.mux.stats.sdk.core.events.playback.InternalHeartbeatEvent;
import com.mux.stats.sdk.core.events.playback.PlayEvent;
import com.mux.stats.sdk.core.events.playback.PlaybackEvent;
import com.mux.stats.sdk.core.events.playback.PlayingEvent;
import com.mux.stats.sdk.core.events.playback.ViewInitEvent;
import com.mux.stats.sdk.core.model.ViewData;
import com.mux.stats.sdk.core.util.CurrentTime;
import com.mux.stats.sdk.core.util.MuxLogger;
import java.util.concurrent.TimeUnit;
import kotlin.time.DurationKt;

/* JADX INFO: loaded from: classes8.dex */
public class LongResumeTracker extends BaseTracker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final long f258a;
    private final CurrentTime b;
    private final CoreView c;
    private long d;
    private boolean e;

    static {
        TimeUnit timeUnit = TimeUnit.HOURS;
        f258a = DurationKt.MILLIS_IN_HOUR;
    }

    public LongResumeTracker(CoreView coreView) {
        this(coreView, new CurrentTime());
    }

    private LongResumeTracker(CoreView coreView, CurrentTime currentTime) {
        super(coreView);
        this.b = currentTime;
        this.c = coreView;
        this.d = currentTime.now();
    }

    /* JADX WARN: Code duplicated, block: B:22:0x00cc  */
    @Override // com.mux.stats.sdk.core.trackers.BaseTracker
    protected void handlePlaybackEvent(PlaybackEvent playbackEvent) {
        long j;
        long j2;
        ViewData viewData;
        boolean z;
        String type = playbackEvent.getType();
        type.hashCode();
        if (!type.equals(InternalHeartbeatEvent.TYPE)) {
            z = type.equals(InternalHeartbeatEndEvent.TYPE) ? false : true;
            long jNow = this.b.now();
            j = jNow - this.d;
            j2 = f258a;
            if (j >= j2 && !playbackEvent.getType().equals(ViewInitEvent.TYPE)) {
                MuxLogger.d("LongResumeTracker", "Event handled after " + j2 + "ms. That's a new view");
                DataEvent dataEvent = new DataEvent();
                dataEvent.setVideoData(this.c.getVideoData());
                dataEvent.setCustomerVideoData(this.c.getCustomerVideoData());
                dataEvent.setCustomData(this.c.getCustomData());
                dataEvent.setCustomerViewData(this.c.getCustomerViewData());
                dispatch(new ViewInitEvent(playbackEvent.getPlayerData()));
                dispatch(dataEvent);
                viewData = this.c.getViewData();
                playbackEvent.setViewData(viewData);
                if (this.e && !PlayEvent.TYPE.equals(playbackEvent.getType()) && !AdBreakStartEvent.TYPE.equals(playbackEvent.getType())) {
                    PlayEvent playEvent = new PlayEvent(playbackEvent.getPlayerData());
                    playEvent.setViewData(viewData);
                    this.c.dispatch(playEvent);
                    if (!PlayingEvent.TYPE.equals(playbackEvent.getType())) {
                        PlayingEvent playingEvent = new PlayingEvent(playbackEvent.getPlayerData());
                        playingEvent.setViewData(viewData);
                        this.c.dispatch(playingEvent);
                    }
                }
            }
            this.d = jNow;
        }
        this.e = z;
        long jNow2 = this.b.now();
        j = jNow2 - this.d;
        j2 = f258a;
        if (j >= j2) {
            MuxLogger.d("LongResumeTracker", "Event handled after " + j2 + "ms. That's a new view");
            DataEvent dataEvent2 = new DataEvent();
            dataEvent2.setVideoData(this.c.getVideoData());
            dataEvent2.setCustomerVideoData(this.c.getCustomerVideoData());
            dataEvent2.setCustomData(this.c.getCustomData());
            dataEvent2.setCustomerViewData(this.c.getCustomerViewData());
            dispatch(new ViewInitEvent(playbackEvent.getPlayerData()));
            dispatch(dataEvent2);
            viewData = this.c.getViewData();
            playbackEvent.setViewData(viewData);
            if (this.e) {
                PlayEvent playEvent2 = new PlayEvent(playbackEvent.getPlayerData());
                playEvent2.setViewData(viewData);
                this.c.dispatch(playEvent2);
                if (!PlayingEvent.TYPE.equals(playbackEvent.getType())) {
                    PlayingEvent playingEvent2 = new PlayingEvent(playbackEvent.getPlayerData());
                    playingEvent2.setViewData(viewData);
                    this.c.dispatch(playingEvent2);
                }
            }
        }
        this.d = jNow2;
    }
}
