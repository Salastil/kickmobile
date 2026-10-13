package com.mux.stats.sdk.core.trackers;

import com.mux.stats.sdk.core.events.IEventDispatcher;
import com.mux.stats.sdk.core.events.playback.CdnChangeEvent;
import com.mux.stats.sdk.core.events.playback.PlaybackEvent;
import com.mux.stats.sdk.core.events.playback.RequestCanceled;
import com.mux.stats.sdk.core.events.playback.RequestFailed;
import com.mux.stats.sdk.core.events.playback.ViewInitEvent;
import com.mux.stats.sdk.core.model.BandwidthMetricData;
import com.mux.stats.sdk.core.model.VideoData;
import com.mux.stats.sdk.core.util.Util;
import io.ktor.http.LinkHeader;
import org.json.JSONException;

/* JADX INFO: loaded from: classes8.dex */
public class CdnTracker extends BaseTracker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f253a;
    private String b;
    private long c;

    public CdnTracker(IEventDispatcher iEventDispatcher) {
        super(iEventDispatcher);
    }

    @Override // com.mux.stats.sdk.core.trackers.BaseTracker
    public void handlePlaybackEvent(PlaybackEvent playbackEvent) throws JSONException {
        String videoCdn;
        String type = playbackEvent.getType();
        type.hashCode();
        if (type.equals(ViewInitEvent.TYPE)) {
            this.f253a = null;
            this.b = null;
            this.c = 0L;
            return;
        }
        if (type.equals(CdnChangeEvent.TYPE)) {
            String videoCdn2 = playbackEvent.getVideoData() != null ? playbackEvent.getVideoData().getVideoCdn() : null;
            if (videoCdn2 != null && videoCdn2.equalsIgnoreCase(this.b)) {
                if (playbackEvent.getVideoData().getVideoPreviousCdn() == null) {
                    String str = this.f253a;
                    playbackEvent.getVideoData().setVideoPreviousCdn(str != null ? str : "");
                    return;
                }
                return;
            }
            if (playbackEvent.getVideoData().getVideoPreviousCdn() == null || playbackEvent.getVideoData().getVideoPreviousCdn().isEmpty()) {
                String str2 = this.b;
                playbackEvent.getVideoData().setVideoPreviousCdn(str2 != null ? str2 : "");
            }
            this.f253a = this.b;
            this.b = videoCdn2;
            return;
        }
        if (playbackEvent.getType().equals(RequestFailed.TYPE) || playbackEvent.getType().equals(RequestCanceled.TYPE)) {
            return;
        }
        BandwidthMetricData bandwidthMetricData = playbackEvent.getBandwidthMetricData();
        if (bandwidthMetricData == null || bandwidthMetricData.getRequestType() == null || !Util.oneOf(bandwidthMetricData.getRequestType(), LinkHeader.Parameters.Media, "video") || bandwidthMetricData.getRequestResponseHeaders() == null || !bandwidthMetricData.getRequestResponseHeaders().containsKey("x-cdn")) {
            videoCdn = playbackEvent.getVideoData() != null ? playbackEvent.getVideoData().getVideoCdn() : null;
        } else {
            videoCdn = bandwidthMetricData.getRequestResponseHeaders().get("x-cdn");
        }
        BandwidthMetricData bandwidthMetricData2 = playbackEvent.getBandwidthMetricData();
        Long requestStart = bandwidthMetricData2 != null ? bandwidthMetricData2.getRequestStart() : null;
        if (requestStart == null || requestStart.longValue() == 0) {
            requestStart = playbackEvent.getViewData() != null ? playbackEvent.getViewData().getViewerTime() : 0L;
        }
        long jLongValue = requestStart != null ? requestStart.longValue() : 0L;
        if (videoCdn == null || videoCdn.equalsIgnoreCase(this.b) || this.c > jLongValue) {
            return;
        }
        this.c = jLongValue;
        CdnChangeEvent cdnChangeEvent = new CdnChangeEvent(playbackEvent.getPlayerData());
        VideoData videoData = new VideoData();
        videoData.setVideoCdn(videoCdn);
        videoData.setVideoPreviousCdn(this.b);
        cdnChangeEvent.setVideoData(videoData);
        dispatch(cdnChangeEvent);
    }
}
