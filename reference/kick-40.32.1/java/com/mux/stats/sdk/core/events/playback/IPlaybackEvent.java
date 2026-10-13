package com.mux.stats.sdk.core.events.playback;

import com.mux.stats.sdk.core.events.IEvent;
import com.mux.stats.sdk.core.model.AdData;
import com.mux.stats.sdk.core.model.BandwidthMetricData;
import com.mux.stats.sdk.core.model.PlayerData;
import com.mux.stats.sdk.core.model.VideoData;
import com.mux.stats.sdk.core.model.ViewData;
import com.mux.stats.sdk.core.model.ViewerData;

/* JADX INFO: loaded from: classes8.dex */
public interface IPlaybackEvent extends IEvent {
    AdData getAdData();

    BandwidthMetricData getBandwidthMetricData();

    PlayerData getPlayerData();

    VideoData getVideoData();

    ViewData getViewData();

    ViewerData getViewerData();

    boolean isSuppressed();

    void setAdData(AdData adData);

    void setBandwidthMetricData(BandwidthMetricData bandwidthMetricData);

    void setVideoData(VideoData videoData);

    void setViewData(ViewData viewData);

    void setViewerData(ViewerData viewerData);
}
