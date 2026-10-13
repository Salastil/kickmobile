package com.mux.stats.sdk.core.trackers;

import com.mux.stats.sdk.core.events.IEvent;
import com.mux.stats.sdk.core.events.IEventDispatcher;
import com.mux.stats.sdk.core.events.playback.HeartbeatEvent;
import com.mux.stats.sdk.core.events.playback.InternalHeartbeatEndEvent;
import com.mux.stats.sdk.core.events.playback.InternalHeartbeatEvent;
import com.mux.stats.sdk.core.events.playback.PlaybackEvent;
import com.mux.stats.sdk.core.events.playback.ViewInitEvent;
import com.mux.stats.sdk.core.util.CurrentTime;

/* JADX INFO: loaded from: classes8.dex */
public class ExternalHeartbeatTracker extends BaseTracker implements ITimeTracker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f256a;
    private CurrentTime b;
    private boolean c;

    public ExternalHeartbeatTracker(IEventDispatcher iEventDispatcher) {
        super(iEventDispatcher);
        this.f256a = 0L;
        this.c = false;
        this.b = new CurrentTime();
    }

    @Override // com.mux.stats.sdk.core.trackers.BaseTracker, com.mux.stats.sdk.core.events.IEventListener
    public void handle(IEvent iEvent) {
        if (iEvent.isTrackable()) {
            this.f256a = now();
            return;
        }
        if (iEvent.isPlayback()) {
            if (InternalHeartbeatEvent.TYPE.equals(iEvent.getType())) {
                if (!this.c) {
                    this.f256a = 0L;
                }
                this.c = true;
            } else if (InternalHeartbeatEndEvent.TYPE.equals(iEvent.getType())) {
                this.c = false;
            } else if (ViewInitEvent.TYPE.equals(iEvent.getType())) {
                this.c = false;
                this.f256a = 0L;
            }
            if (this.c) {
                long j = this.f256a;
                if (j <= 0 || j + 10000 >= now()) {
                    return;
                }
                this.f256a = now();
                dispatch(new HeartbeatEvent(((PlaybackEvent) iEvent).getPlayerData()));
            }
        }
    }

    @Override // com.mux.stats.sdk.core.trackers.ITimeTracker
    public long now() {
        return this.b.now();
    }

    public void setCurrentTime(CurrentTime currentTime) {
        this.b = currentTime;
    }
}
