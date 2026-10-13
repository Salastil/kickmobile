package com.mux.stats.sdk.core.trackers;

import com.google.common.base.Ascii;
import com.mux.stats.sdk.core.events.IEventDispatcher;
import com.mux.stats.sdk.core.events.playback.AdBreakEndEvent;
import com.mux.stats.sdk.core.events.playback.AdBreakStartEvent;
import com.mux.stats.sdk.core.events.playback.AdPlayEvent;
import com.mux.stats.sdk.core.events.playback.AdPlayingEvent;
import com.mux.stats.sdk.core.events.playback.EndedEvent;
import com.mux.stats.sdk.core.events.playback.PlaybackEvent;
import com.mux.stats.sdk.core.events.playback.PlayingEvent;
import com.mux.stats.sdk.core.events.playback.RebufferEndEvent;
import com.mux.stats.sdk.core.events.playback.SeekedEvent;
import com.mux.stats.sdk.core.events.playback.SeekingEvent;
import com.mux.stats.sdk.core.events.playback.TimeUpdateEvent;
import com.mux.stats.sdk.core.events.playback.ViewEndEvent;
import com.mux.stats.sdk.core.events.playback.ViewInitEvent;
import com.mux.stats.sdk.core.model.VideoData;
import com.mux.stats.sdk.core.util.MuxLogger;
import com.mux.stats.sdk.core.util.Util;
import io.ktor.sse.ServerSentEventKt;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes8.dex */
public class PlayheadRangeTracker extends BaseTracker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<a> f260a;
    private Long b;
    private Long c;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f261a;
        private final long b;

        public a(long j, long j2) {
            this.f261a = j;
            this.b = j2;
        }

        public final long a() {
            return this.f261a;
        }

        public final long b() {
            return this.b;
        }

        public final String toString() {
            return String.format("[%d-%d]", Long.valueOf(this.f261a), Long.valueOf(this.b));
        }
    }

    public PlayheadRangeTracker(IEventDispatcher iEventDispatcher) {
        super(iEventDispatcher);
        this.f260a = new ArrayList();
        this.b = null;
        this.c = null;
    }

    private static JSONArray a(List<a> list) {
        try {
            JSONArray jSONArray = new JSONArray();
            for (a aVar : list) {
                jSONArray.put(aVar.a() + ServerSentEventKt.COLON + aVar.b());
            }
            return jSONArray;
        } catch (JSONException e) {
            MuxLogger.d("PlayheadRangeTracker", "Error serializing playback ranges: " + e.getMessage());
            return null;
        }
    }

    private void a(long j) {
        if (this.b == null) {
            this.b = Long.valueOf(j);
            this.c = Long.valueOf(j);
            MuxLogger.d("PlayheadRangeTracker", "Started playback range at " + j);
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.mux.stats.sdk.core.trackers.BaseTracker
    protected void handlePlaybackEvent(PlaybackEvent playbackEvent) throws JSONException {
        StringBuilder sb;
        Long playerPlayheadTime = playbackEvent.getPlayerData().getPlayerPlayheadTime();
        if (playerPlayheadTime == null) {
            return;
        }
        String type = playbackEvent.getType();
        type.hashCode();
        byte b = -1;
        switch (type.hashCode()) {
            case -1535613269:
                if (type.equals(AdPlayingEvent.TYPE)) {
                    b = 0;
                }
                break;
            case -1422144041:
                if (type.equals(AdPlayEvent.TYPE)) {
                    b = 1;
                }
                break;
            case -1300510776:
                if (type.equals(RebufferEndEvent.TYPE)) {
                    b = 2;
                }
                break;
            case -906224361:
                if (type.equals(SeekedEvent.TYPE)) {
                    b = 3;
                }
                break;
            case -493563858:
                if (type.equals(PlayingEvent.TYPE)) {
                    b = 4;
                }
                break;
            case 96651962:
                if (type.equals(EndedEvent.TYPE)) {
                    b = 5;
                }
                break;
            case 454234134:
                if (type.equals(ViewEndEvent.TYPE)) {
                    b = 6;
                }
                break;
            case 1196475701:
                if (type.equals(ViewInitEvent.TYPE)) {
                    b = 7;
                }
                break;
            case 1651552038:
                if (type.equals(AdBreakStartEvent.TYPE)) {
                    b = 8;
                }
                break;
            case 1762557398:
                if (type.equals(TimeUpdateEvent.TYPE)) {
                    b = 9;
                }
                break;
            case 1971820138:
                if (type.equals(SeekingEvent.TYPE)) {
                    b = 10;
                }
                break;
            case 2133546143:
                if (type.equals(AdBreakEndEvent.TYPE)) {
                    b = Ascii.VT;
                }
                break;
        }
        switch (b) {
            case 0:
            case 1:
            case 5:
            case 6:
            case 8:
            case 10:
                Long l = this.c;
                if (l != null) {
                    long jLongValue = l.longValue();
                    if (this.b != null) {
                        a aVar = new a(this.b.longValue(), jLongValue);
                        if (aVar.a() < aVar.b()) {
                            this.f260a.add(aVar);
                            sb = new StringBuilder("Ended playback range: ");
                        } else {
                            sb = new StringBuilder("ignored invalid range: ");
                        }
                        sb.append(aVar);
                        MuxLogger.d("PlayheadRangeTracker", sb.toString());
                        this.b = null;
                    }
                    JSONArray jSONArrayA = a(this.f260a);
                    if (jSONArrayA != null) {
                        VideoData videoData = (VideoData) Util.lazyGet(playbackEvent.getVideoData(), new Callable() { // from class: com.mux.stats.sdk.core.trackers.PlayheadRangeTracker$$ExternalSyntheticLambda0
                            @Override // java.util.concurrent.Callable
                            public final Object call() {
                                return new VideoData();
                            }
                        });
                        videoData.setVideoPlaybackRange(jSONArrayA);
                        playbackEvent.setVideoData(videoData);
                        MuxLogger.d("PlayheadRangeTracker", "Set playback ranges on event: " + jSONArrayA);
                    }
                }
                break;
            case 2:
            case 3:
            case 11:
                if (Boolean.FALSE.equals(playbackEvent.getPlayerData().getPlayerIsPaused())) {
                    a(playerPlayheadTime.longValue());
                }
                break;
            case 4:
                a(playerPlayheadTime.longValue());
                break;
            case 7:
                this.b = null;
                this.c = null;
                this.f260a.clear();
                MuxLogger.d("PlayheadRangeTracker", "Reset playhead ranges for new view");
                break;
            case 9:
                if (this.b != null) {
                    if (this.c == null || playerPlayheadTime.longValue() > this.c.longValue()) {
                        this.c = playerPlayheadTime;
                    }
                }
                break;
        }
    }
}
