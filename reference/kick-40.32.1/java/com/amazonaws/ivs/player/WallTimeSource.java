package com.amazonaws.ivs.player;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: Sync.java */
/* JADX INFO: loaded from: classes5.dex */
class WallTimeSource {
    static final long DEFAULT_DELAY_MS = 15;
    private long currentPlayhead;
    private final ScheduledExecutorService scheduler;
    private final SyncSource syncSource;
    private float playbackRate = 1.0f;
    private Date last = new Date();

    WallTimeSource(SyncSource syncSource, long j) {
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1);
        this.scheduler = scheduledExecutorServiceNewScheduledThreadPool;
        this.syncSource = syncSource;
        this.currentPlayhead = j / 1000;
        scheduledExecutorServiceNewScheduledThreadPool.schedule(new WallTimeSource$$ExternalSyntheticLambda0(this), DEFAULT_DELAY_MS, TimeUnit.MILLISECONDS);
    }

    public void setPlaybackRate(float f) {
        this.playbackRate = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void taskFired() {
        Date date = new Date();
        long time = this.last.getTime();
        long j = DEFAULT_DELAY_MS;
        long time2 = (time + DEFAULT_DELAY_MS) - date.getTime();
        if (time2 >= 0) {
            j = time2;
        }
        long time3 = date.getTime() - this.last.getTime();
        this.last = date;
        this.currentPlayhead += (long) (time3 * this.playbackRate);
        this.scheduler.schedule(new WallTimeSource$$ExternalSyntheticLambda0(this), j, TimeUnit.MILLISECONDS);
        this.syncSource.notifyTargetTimeChanged(this.currentPlayhead * 1000);
    }

    public void release() {
        this.scheduler.shutdownNow();
    }
}
