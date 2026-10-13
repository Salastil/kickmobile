package com.mux.stats.sdk.core.trackers;

import com.mux.stats.sdk.core.events.IEventDispatcher;
import com.mux.stats.sdk.core.events.TrackableEvent;
import com.mux.stats.sdk.core.events.playback.AdBreakEndEvent;
import com.mux.stats.sdk.core.events.playback.AdBreakStartEvent;
import com.mux.stats.sdk.core.events.playback.AdEndedEvent;
import com.mux.stats.sdk.core.events.playback.AdErrorEvent;
import com.mux.stats.sdk.core.events.playback.AdFirstQuartileEvent;
import com.mux.stats.sdk.core.events.playback.AdMidpointEvent;
import com.mux.stats.sdk.core.events.playback.AdPauseEvent;
import com.mux.stats.sdk.core.events.playback.AdPlayEvent;
import com.mux.stats.sdk.core.events.playback.AdPlayingEvent;
import com.mux.stats.sdk.core.events.playback.AdRequestEvent;
import com.mux.stats.sdk.core.events.playback.AdResponseEvent;
import com.mux.stats.sdk.core.events.playback.AdThirdQuartileEvent;
import com.mux.stats.sdk.core.events.playback.CdnChangeEvent;
import com.mux.stats.sdk.core.events.playback.EndedEvent;
import com.mux.stats.sdk.core.events.playback.HeartbeatEvent;
import com.mux.stats.sdk.core.events.playback.NetworkChangeEvent;
import com.mux.stats.sdk.core.events.playback.OrientationChangeEvent;
import com.mux.stats.sdk.core.events.playback.PageLoadStartEvent;
import com.mux.stats.sdk.core.events.playback.PauseEvent;
import com.mux.stats.sdk.core.events.playback.PlayEvent;
import com.mux.stats.sdk.core.events.playback.PlaybackEvent;
import com.mux.stats.sdk.core.events.playback.PlaybackModeChangeEvent;
import com.mux.stats.sdk.core.events.playback.PlayerReadyEvent;
import com.mux.stats.sdk.core.events.playback.PlayingEvent;
import com.mux.stats.sdk.core.events.playback.RebufferEndEvent;
import com.mux.stats.sdk.core.events.playback.RebufferStartEvent;
import com.mux.stats.sdk.core.events.playback.RenditionChangeEvent;
import com.mux.stats.sdk.core.events.playback.RequestCanceled;
import com.mux.stats.sdk.core.events.playback.RequestCompleted;
import com.mux.stats.sdk.core.events.playback.RequestFailed;
import com.mux.stats.sdk.core.events.playback.Sampling;
import com.mux.stats.sdk.core.events.playback.SeekedEvent;
import com.mux.stats.sdk.core.events.playback.SeekingEvent;
import com.mux.stats.sdk.core.events.playback.StalledEvent;
import com.mux.stats.sdk.core.events.playback.VideoChangeEvent;
import com.mux.stats.sdk.core.events.playback.ViewEndEvent;
import com.mux.stats.sdk.core.events.playback.ViewStartEvent;
import com.mux.stats.sdk.core.events.playback.WaitingEvent;
import java.util.HashSet;

/* JADX INFO: loaded from: classes8.dex */
public class ExternalEventTracker extends BaseTracker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HashSet<String> f255a;

    public ExternalEventTracker(IEventDispatcher iEventDispatcher) {
        super(iEventDispatcher);
        HashSet<String> hashSet = new HashSet<>();
        this.f255a = hashSet;
        hashSet.add(AdBreakEndEvent.TYPE);
        hashSet.add(AdBreakStartEvent.TYPE);
        hashSet.add(AdEndedEvent.TYPE);
        hashSet.add(AdErrorEvent.TYPE);
        hashSet.add(AdFirstQuartileEvent.TYPE);
        hashSet.add(AdMidpointEvent.TYPE);
        hashSet.add(AdPauseEvent.TYPE);
        hashSet.add(AdPlayEvent.TYPE);
        hashSet.add(AdPlayingEvent.TYPE);
        hashSet.add(AdRequestEvent.TYPE);
        hashSet.add(AdResponseEvent.TYPE);
        hashSet.add(AdThirdQuartileEvent.TYPE);
        hashSet.add(EndedEvent.TYPE);
        hashSet.add("error");
        hashSet.add(HeartbeatEvent.TYPE);
        hashSet.add(PageLoadStartEvent.TYPE);
        hashSet.add(PauseEvent.TYPE);
        hashSet.add(PlayEvent.TYPE);
        hashSet.add(PlayerReadyEvent.TYPE);
        hashSet.add(PlayingEvent.TYPE);
        hashSet.add(RebufferEndEvent.TYPE);
        hashSet.add(RebufferStartEvent.TYPE);
        hashSet.add(Sampling.TYPE);
        hashSet.add(SeekedEvent.TYPE);
        hashSet.add(SeekingEvent.TYPE);
        hashSet.add(StalledEvent.TYPE);
        hashSet.add(VideoChangeEvent.TYPE);
        hashSet.add(ViewEndEvent.TYPE);
        hashSet.add(ViewStartEvent.TYPE);
        hashSet.add(WaitingEvent.TYPE);
        hashSet.add(RenditionChangeEvent.TYPE);
        hashSet.add(NetworkChangeEvent.TYPE);
        hashSet.add(OrientationChangeEvent.TYPE);
        hashSet.add(RequestCompleted.TYPE);
        hashSet.add(RequestCanceled.TYPE);
        hashSet.add(RequestFailed.TYPE);
        hashSet.add(CdnChangeEvent.TYPE);
        hashSet.add(PlaybackModeChangeEvent.TYPE);
    }

    @Override // com.mux.stats.sdk.core.trackers.BaseTracker
    protected void handlePlaybackEvent(PlaybackEvent playbackEvent) {
        if (!this.f255a.contains(playbackEvent.getType()) || playbackEvent.isSuppressed()) {
            return;
        }
        TrackableEvent trackableEvent = new TrackableEvent(playbackEvent.getType(), playbackEvent.getRequiredProperties());
        if (playbackEvent.getBandwidthMetricData() != null) {
            trackableEvent.setBandwidthMetricData(playbackEvent.getBandwidthMetricData());
        }
        if (playbackEvent.getAdData() != null) {
            trackableEvent.setAdData(playbackEvent.getAdData());
        }
        dispatch(trackableEvent);
    }
}
