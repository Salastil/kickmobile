package com.mux.stats.sdk.core;

import com.mux.stats.sdk.core.events.EventBus;
import com.mux.stats.sdk.core.events.IEvent;
import com.mux.stats.sdk.core.events.SessionDataEvent;
import com.mux.stats.sdk.core.events.TrackableEvent;
import com.mux.stats.sdk.core.events.ViewMetricEvent;
import com.mux.stats.sdk.core.events.data.DataEvent;
import com.mux.stats.sdk.core.events.playback.AdBreakEndEvent;
import com.mux.stats.sdk.core.events.playback.AdEndedEvent;
import com.mux.stats.sdk.core.events.playback.IPlaybackEvent;
import com.mux.stats.sdk.core.events.playback.ViewInitEvent;
import com.mux.stats.sdk.core.model.AdData;
import com.mux.stats.sdk.core.model.CustomData;
import com.mux.stats.sdk.core.model.CustomerVideoData;
import com.mux.stats.sdk.core.model.CustomerViewData;
import com.mux.stats.sdk.core.model.CustomerViewerData;
import com.mux.stats.sdk.core.model.VideoData;
import com.mux.stats.sdk.core.model.ViewData;
import com.mux.stats.sdk.core.model.ViewerData;
import com.mux.stats.sdk.core.trackers.AdTracker;
import com.mux.stats.sdk.core.trackers.CdnTracker;
import com.mux.stats.sdk.core.trackers.CumulativeTimeTracker;
import com.mux.stats.sdk.core.trackers.ExternalEventTracker;
import com.mux.stats.sdk.core.trackers.ExternalHeartbeatTracker;
import com.mux.stats.sdk.core.trackers.InternalHeartbeatTracker;
import com.mux.stats.sdk.core.trackers.LongResumeTracker;
import com.mux.stats.sdk.core.trackers.PlaybackTimeTracker;
import com.mux.stats.sdk.core.trackers.PlayheadRangeTracker;
import com.mux.stats.sdk.core.trackers.RebufferTracker;
import com.mux.stats.sdk.core.trackers.RequestMetricsTracker;
import com.mux.stats.sdk.core.trackers.ScalingTracker;
import com.mux.stats.sdk.core.trackers.SeekingTracker;
import com.mux.stats.sdk.core.trackers.TimeToFirstFrameTracker;
import com.mux.stats.sdk.core.trackers.ViewStateTracker;
import com.mux.stats.sdk.core.trackers.ViewerTimeTracker;
import com.mux.stats.sdk.core.trackers.WatchTimeTracker;
import com.mux.stats.sdk.core.util.UUID;
import com.mux.stats.sdk.core.util.Util;
import org.json.JSONException;

/* JADX INFO: loaded from: classes8.dex */
public class CoreView extends EventBus {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ViewData f228a;
    private VideoData b;
    private ViewerData c;
    private CustomerVideoData d;
    private CustomerViewData e;
    private CustomerViewerData f;
    private AdData g;
    private int i;
    private CustomData h = new CustomData();
    private boolean j = false;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(CustomData customData) {
        this.h.update(customData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(CustomerVideoData customerVideoData) {
        this.d.update(customerVideoData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(CustomerViewData customerViewData) {
        this.e.update(customerViewData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(CustomerViewerData customerViewerData) {
        this.f.update(customerViewerData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(VideoData videoData) {
        this.b.update(videoData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(ViewData viewData) {
        this.f228a.update(viewData);
    }

    @Override // com.mux.stats.sdk.core.events.EventBus, com.mux.stats.sdk.core.events.IEventDispatcher
    public void dispatch(IEvent iEvent) throws JSONException {
        if (iEvent.isTrackable()) {
            TrackableEvent trackableEvent = (TrackableEvent) iEvent;
            this.f228a.update(trackableEvent.getViewData());
            ViewData viewData = this.f228a;
            int i = this.i + 1;
            this.i = i;
            viewData.setViewSequenceNumber(Integer.valueOf(i));
            trackableEvent.setViewData(this.f228a);
            trackableEvent.setVideoData(this.b);
            trackableEvent.setViewerData(this.c);
            trackableEvent.setCustomerVideoData(this.d);
            trackableEvent.setCustomerViewData(this.e);
            trackableEvent.setCustomerViewerData(this.f);
            trackableEvent.setCustomData(this.h);
            trackableEvent.setAdData(this.g);
            if (Util.oneOf(trackableEvent.getEventType(), AdBreakEndEvent.TYPE, AdEndedEvent.TYPE)) {
                this.g.clear();
            }
        } else if (iEvent.isPlayback()) {
            IPlaybackEvent iPlaybackEvent = (IPlaybackEvent) iEvent;
            if (iPlaybackEvent.getType().equals(ViewInitEvent.TYPE)) {
                ViewData viewData2 = new ViewData();
                this.f228a = viewData2;
                viewData2.setViewId(UUID.generateUUID());
                this.b = new VideoData();
                this.c = new ViewerData();
                this.d = new CustomerVideoData();
                this.e = new CustomerViewData();
                this.f = new CustomerViewerData();
                this.g = new AdData();
                this.i = 0;
                if (!this.j) {
                    addListener(new LongResumeTracker(this));
                    addListener(new ViewerTimeTracker(this));
                    addListener(new ScalingTracker(this));
                    addListener(new SeekingTracker(this));
                    addListener(new InternalHeartbeatTracker(this));
                    addListener(new PlaybackTimeTracker(this));
                    addListener(new PlayheadRangeTracker(this));
                    addListener(new WatchTimeTracker(this));
                    addListener(new TimeToFirstFrameTracker(this));
                    addListener(new RebufferTracker(this));
                    addListener(new ViewStateTracker(this));
                    addListener(new RequestMetricsTracker(this));
                    addListener(new AdTracker(this));
                    addListener(new CumulativeTimeTracker(this));
                    addListener(new CdnTracker(this));
                    addListener(new ExternalEventTracker(this));
                    addListener(new ExternalHeartbeatTracker(this));
                    this.j = true;
                }
            }
            if (iPlaybackEvent.getViewData() != null) {
                this.f228a.update(iPlaybackEvent.getViewData());
            }
            if (iPlaybackEvent.getAdData() != null) {
                this.g.update(iPlaybackEvent.getAdData());
            }
            if (iPlaybackEvent.getVideoData() != null) {
                this.b.update(iPlaybackEvent.getVideoData());
            }
            if (iPlaybackEvent.getViewerData() != null) {
                this.c.update(iPlaybackEvent.getViewerData());
            }
            if (this.d != null && iPlaybackEvent.getVideoData() != null && iPlaybackEvent.getVideoData().getVideoCdn() != null) {
                this.d.setVideoCdn(iPlaybackEvent.getVideoData().getVideoCdn());
            }
            iPlaybackEvent.setViewData(this.f228a);
            iPlaybackEvent.setAdData(this.g);
            iPlaybackEvent.setVideoData(this.b);
            iPlaybackEvent.setViewerData(this.c);
        }
        if (iEvent.isViewMetric()) {
            this.f228a.update(((ViewMetricEvent) iEvent).getViewData());
            return;
        }
        if (iEvent.isSessionData()) {
            SessionDataEvent sessionDataEvent = (SessionDataEvent) iEvent;
            Util.let(sessionDataEvent.getViewData(), new Util.Consumer() { // from class: com.mux.stats.sdk.core.CoreView$$ExternalSyntheticLambda0
                @Override // com.mux.stats.sdk.core.util.Util.Consumer
                public final void apply(Object obj) {
                    this.f$0.a((ViewData) obj);
                }
            });
            Util.let(sessionDataEvent.getVideoData(), new Util.Consumer() { // from class: com.mux.stats.sdk.core.CoreView$$ExternalSyntheticLambda1
                @Override // com.mux.stats.sdk.core.util.Util.Consumer
                public final void apply(Object obj) {
                    this.f$0.a((VideoData) obj);
                }
            });
            Util.let(sessionDataEvent.getCustomerVideoData(), new Util.Consumer() { // from class: com.mux.stats.sdk.core.CoreView$$ExternalSyntheticLambda2
                @Override // com.mux.stats.sdk.core.util.Util.Consumer
                public final void apply(Object obj) {
                    this.f$0.a((CustomerVideoData) obj);
                }
            });
            Util.let(sessionDataEvent.getCustomerViewData(), new Util.Consumer() { // from class: com.mux.stats.sdk.core.CoreView$$ExternalSyntheticLambda3
                @Override // com.mux.stats.sdk.core.util.Util.Consumer
                public final void apply(Object obj) {
                    this.f$0.a((CustomerViewData) obj);
                }
            });
            Util.let(sessionDataEvent.getCustomerViewerData(), new Util.Consumer() { // from class: com.mux.stats.sdk.core.CoreView$$ExternalSyntheticLambda4
                @Override // com.mux.stats.sdk.core.util.Util.Consumer
                public final void apply(Object obj) {
                    this.f$0.a((CustomerViewerData) obj);
                }
            });
            Util.let(sessionDataEvent.getCustomData(), new Util.Consumer() { // from class: com.mux.stats.sdk.core.CoreView$$ExternalSyntheticLambda5
                @Override // com.mux.stats.sdk.core.util.Util.Consumer
                public final void apply(Object obj) {
                    this.f$0.a((CustomData) obj);
                }
            });
            return;
        }
        if (!iEvent.isData()) {
            super.dispatch(iEvent);
            return;
        }
        DataEvent dataEvent = (DataEvent) iEvent;
        VideoData videoData = this.b;
        if (videoData == null || this.d == null) {
            return;
        }
        videoData.update(dataEvent.getVideoData());
        this.d.update(dataEvent.getCustomerVideoData());
        this.e.update(dataEvent.getCustomerViewData());
        this.f.update(dataEvent.getCustomerViewerData());
        this.h.update(dataEvent.getCustomData());
    }

    public CustomData getCustomData() {
        return this.h;
    }

    public CustomerVideoData getCustomerVideoData() {
        return this.d;
    }

    public CustomerViewData getCustomerViewData() {
        return this.e;
    }

    public CustomerViewerData getCustomerViewerData() {
        return this.f;
    }

    public VideoData getVideoData() {
        return this.b;
    }

    public ViewData getViewData() {
        return this.f228a;
    }

    public ViewerData getViewerData() {
        return this.c;
    }
}
