package com.mux.stats.sdk.core.events.playback;

import com.mux.stats.sdk.core.events.BaseEvent;
import com.mux.stats.sdk.core.model.AdData;
import com.mux.stats.sdk.core.model.BandwidthMetricData;
import com.mux.stats.sdk.core.model.PlayerData;
import com.mux.stats.sdk.core.model.VideoData;
import com.mux.stats.sdk.core.model.ViewData;
import com.mux.stats.sdk.core.model.ViewerData;

/* JADX INFO: loaded from: classes8.dex */
public class PlaybackEvent extends BaseEvent implements IPlaybackEvent {
    protected AdData adData;
    protected BandwidthMetricData bandwidthMetricData;
    protected boolean isSuppressed = false;
    protected PlayerData playerData;
    protected VideoData videoData;
    protected ViewData viewData;
    protected ViewerData viewerData;

    public PlaybackEvent(PlayerData playerData) {
        this.playerData = playerData;
    }

    @Override // com.mux.stats.sdk.core.events.playback.IPlaybackEvent
    public AdData getAdData() {
        return this.adData;
    }

    @Override // com.mux.stats.sdk.core.events.playback.IPlaybackEvent
    public BandwidthMetricData getBandwidthMetricData() {
        return this.bandwidthMetricData;
    }

    @Override // com.mux.stats.sdk.core.events.BaseEvent, com.mux.stats.sdk.core.events.IEvent
    public String getDebugString() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        StringBuilder sb = new StringBuilder("PlaybackEvent: ");
        String str6 = "";
        if (this.playerData != null) {
            str = "\n  " + this.playerData.getDebugString();
        } else {
            str = "";
        }
        sb.append(str);
        if (this.viewData != null) {
            str2 = "\n  " + this.viewData.getDebugString();
        } else {
            str2 = "";
        }
        sb.append(str2);
        if (this.videoData != null) {
            str3 = "\n  " + this.videoData.getDebugString();
        } else {
            str3 = "";
        }
        sb.append(str3);
        if (this.viewerData != null) {
            str4 = "\n  " + this.viewerData.getDebugString();
        } else {
            str4 = "";
        }
        sb.append(str4);
        if (this.adData != null) {
            str5 = "\n  " + this.adData.getDebugString();
        } else {
            str5 = "";
        }
        sb.append(str5);
        if (this.bandwidthMetricData != null) {
            str6 = "\n  " + this.bandwidthMetricData.getDebugString();
        }
        sb.append(str6);
        return sb.toString();
    }

    @Override // com.mux.stats.sdk.core.events.playback.IPlaybackEvent
    public PlayerData getPlayerData() {
        return this.playerData;
    }

    @Override // com.mux.stats.sdk.core.events.playback.IPlaybackEvent
    public VideoData getVideoData() {
        return this.videoData;
    }

    @Override // com.mux.stats.sdk.core.events.playback.IPlaybackEvent
    public ViewData getViewData() {
        return this.viewData;
    }

    @Override // com.mux.stats.sdk.core.events.playback.IPlaybackEvent
    public ViewerData getViewerData() {
        return this.viewerData;
    }

    public boolean isAd() {
        return false;
    }

    @Override // com.mux.stats.sdk.core.events.BaseEvent, com.mux.stats.sdk.core.events.IEvent
    public boolean isPlayback() {
        return true;
    }

    @Override // com.mux.stats.sdk.core.events.playback.IPlaybackEvent
    public boolean isSuppressed() {
        return this.isSuppressed;
    }

    @Override // com.mux.stats.sdk.core.events.playback.IPlaybackEvent
    public void setAdData(AdData adData) {
        this.adData = adData;
    }

    @Override // com.mux.stats.sdk.core.events.playback.IPlaybackEvent
    public void setBandwidthMetricData(BandwidthMetricData bandwidthMetricData) {
        this.bandwidthMetricData = bandwidthMetricData;
    }

    @Override // com.mux.stats.sdk.core.events.playback.IPlaybackEvent
    public void setVideoData(VideoData videoData) {
        this.videoData = videoData;
    }

    @Override // com.mux.stats.sdk.core.events.playback.IPlaybackEvent
    public void setViewData(ViewData viewData) {
        this.viewData = viewData;
    }

    @Override // com.mux.stats.sdk.core.events.playback.IPlaybackEvent
    public void setViewerData(ViewerData viewerData) {
        this.viewerData = viewerData;
    }
}
