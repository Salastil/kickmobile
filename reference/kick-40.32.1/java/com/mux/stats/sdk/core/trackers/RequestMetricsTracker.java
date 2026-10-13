package com.mux.stats.sdk.core.trackers;

import com.mux.stats.sdk.core.events.IEventDispatcher;
import com.mux.stats.sdk.core.events.playback.PlaybackEvent;
import com.mux.stats.sdk.core.events.playback.RequestCanceled;
import com.mux.stats.sdk.core.events.playback.RequestCompleted;
import com.mux.stats.sdk.core.events.playback.RequestFailed;
import com.mux.stats.sdk.core.events.playback.ViewStartEvent;
import com.mux.stats.sdk.core.model.BandwidthMetricData;
import com.mux.stats.sdk.core.model.ViewData;
import org.json.JSONException;

/* JADX INFO: loaded from: classes8.dex */
public class RequestMetricsTracker extends BaseTracker {
    protected long requestCanceledCount;
    protected long requestCompletedCount;
    protected long requestCount;
    protected long requestFailedCount;
    protected long totalBytes;
    protected double totalLatency;
    protected long totalLoadTime;

    public RequestMetricsTracker(IEventDispatcher iEventDispatcher) {
        super(iEventDispatcher);
        this.requestCount = 0L;
        this.requestCompletedCount = 0L;
        this.requestCanceledCount = 0L;
        this.requestFailedCount = 0L;
        this.totalBytes = 0L;
        this.totalLoadTime = 0L;
        this.totalLatency = 0.0d;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.mux.stats.sdk.core.trackers.BaseTracker
    protected void handlePlaybackEvent(PlaybackEvent playbackEvent) throws JSONException {
        String type = playbackEvent.getType();
        type.hashCode();
        byte b = -1;
        switch (type.hashCode()) {
            case -1893763032:
                if (type.equals(RequestCanceled.TYPE)) {
                    b = 0;
                }
                break;
            case -1554552611:
                if (type.equals(ViewStartEvent.TYPE)) {
                    b = 1;
                }
                break;
            case -456624996:
                if (type.equals(RequestCompleted.TYPE)) {
                    b = 2;
                }
                break;
            case 1929584524:
                if (type.equals(RequestFailed.TYPE)) {
                    b = 3;
                }
                break;
        }
        switch (b) {
            case 0:
                RequestCanceled requestCanceled = (RequestCanceled) playbackEvent;
                this.requestCount++;
                this.requestCanceledCount++;
                ViewData viewData = requestCanceled.getViewData();
                viewData.setViewRequestCount(Long.valueOf(this.requestCount));
                viewData.setViewRequestCanceledCount(Long.valueOf(this.requestCanceledCount));
                requestCanceled.setViewData(viewData);
                break;
            case 1:
                this.requestCount = 0L;
                this.requestCompletedCount = 0L;
                this.requestCanceledCount = 0L;
                this.requestFailedCount = 0L;
                this.totalBytes = 0L;
                this.totalLoadTime = 0L;
                this.totalLatency = 0.0d;
                break;
            case 2:
                RequestCompleted requestCompleted = (RequestCompleted) playbackEvent;
                this.requestCount++;
                BandwidthMetricData bandwidthMetricData = requestCompleted.getBandwidthMetricData();
                if (bandwidthMetricData != null) {
                    long jLongValue = (bandwidthMetricData == null || bandwidthMetricData.getRequestStart() == null) ? 0L : bandwidthMetricData.getRequestResponseStart().longValue() - bandwidthMetricData.getRequestStart().longValue();
                    long jLongValue2 = (bandwidthMetricData.getRequestResponseEnd() == null || bandwidthMetricData.getRequestResponseStart() == null) ? 0L : bandwidthMetricData.getRequestResponseEnd().longValue() - bandwidthMetricData.getRequestResponseStart().longValue();
                    if (jLongValue2 > 0 && bandwidthMetricData.getRequestBytesLoaded() != null && bandwidthMetricData.getRequestBytesLoaded().longValue() > 0) {
                        long jLongValue3 = (bandwidthMetricData.getRequestBytesLoaded().longValue() / jLongValue2) * 8000;
                        this.requestCompletedCount++;
                        this.totalBytes += bandwidthMetricData.getRequestBytesLoaded().longValue();
                        this.totalLoadTime += jLongValue2;
                        ViewData viewData2 = requestCompleted.getViewData();
                        viewData2.setViewMinRequestThroughput(Long.valueOf(Math.min(viewData2.getViewMinRequestThroughput() == null ? Long.MAX_VALUE : viewData2.getViewMinRequestThroughput().longValue(), jLongValue3)));
                        viewData2.setViewAverageRequestThroughput(Long.valueOf((long) ((this.totalBytes / this.totalLoadTime) * 8000.0d)));
                        viewData2.setViewRequestCount(Long.valueOf(this.requestCount));
                        if (jLongValue > 0) {
                            double d = jLongValue;
                            this.totalLatency += d;
                            viewData2.setViewMaxRequestLatency(Double.valueOf(Math.max(viewData2.getViewMaxRequestLatency() != null ? viewData2.getViewMaxRequestLatency().doubleValue() : 0.0d, d)));
                            viewData2.setViewAverageRequestLatency(Double.valueOf(this.totalLatency / this.requestCompletedCount));
                        }
                        requestCompleted.setViewData(viewData2);
                        break;
                    }
                }
                break;
            case 3:
                RequestFailed requestFailed = (RequestFailed) playbackEvent;
                this.requestCount++;
                this.requestFailedCount++;
                ViewData viewData3 = requestFailed.getViewData();
                viewData3.setViewRequestCount(Long.valueOf(this.requestCount));
                viewData3.setViewRequestFailedCount(Long.valueOf(this.requestFailedCount));
                requestFailed.setViewData(viewData3);
                break;
        }
    }
}
