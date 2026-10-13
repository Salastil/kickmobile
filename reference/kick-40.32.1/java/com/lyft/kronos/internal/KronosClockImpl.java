package com.lyft.kronos.internal;

import com.facebook.react.bridge.BaseJavaModule;
import com.lyft.kronos.Clock;
import com.lyft.kronos.KronosClock;
import com.lyft.kronos.KronosTime;
import com.lyft.kronos.internal.ntp.SntpService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: KronosClockImpl.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000f\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/lyft/kronos/internal/KronosClockImpl;", "Lcom/lyft/kronos/KronosClock;", "ntpService", "Lcom/lyft/kronos/internal/ntp/SntpService;", "fallbackClock", "Lcom/lyft/kronos/Clock;", "(Lcom/lyft/kronos/internal/ntp/SntpService;Lcom/lyft/kronos/Clock;)V", "getCurrentNtpTimeMs", "", "()Ljava/lang/Long;", "getCurrentTime", "Lcom/lyft/kronos/KronosTime;", "getElapsedTimeMs", "shutdown", "", BaseJavaModule.METHOD_TYPE_SYNC, "", "syncInBackground", "kronos-java"}, k = 1, mv = {1, 4, 0})
public final class KronosClockImpl implements KronosClock {
    private final Clock fallbackClock;
    private final SntpService ntpService;

    public KronosClockImpl(SntpService ntpService, Clock fallbackClock) {
        Intrinsics.checkNotNullParameter(ntpService, "ntpService");
        Intrinsics.checkNotNullParameter(fallbackClock, "fallbackClock");
        this.ntpService = ntpService;
        this.fallbackClock = fallbackClock;
    }

    @Override // com.lyft.kronos.KronosClock, com.lyft.kronos.Clock
    public long getCurrentTimeMs() {
        return KronosClock.DefaultImpls.getCurrentTimeMs(this);
    }

    @Override // com.lyft.kronos.KronosClock
    public boolean sync() {
        return this.ntpService.sync();
    }

    @Override // com.lyft.kronos.KronosClock
    public void syncInBackground() {
        this.ntpService.syncInBackground();
    }

    @Override // com.lyft.kronos.KronosClock
    public void shutdown() {
        this.ntpService.shutdown();
    }

    @Override // com.lyft.kronos.Clock
    public long getElapsedTimeMs() {
        return this.fallbackClock.getElapsedTimeMs();
    }

    @Override // com.lyft.kronos.KronosClock
    public KronosTime getCurrentTime() {
        KronosTime kronosTimeCurrentTime = this.ntpService.currentTime();
        return kronosTimeCurrentTime != null ? kronosTimeCurrentTime : new KronosTime(this.fallbackClock.getCurrentTimeMs(), null);
    }

    @Override // com.lyft.kronos.KronosClock
    public Long getCurrentNtpTimeMs() {
        KronosTime kronosTimeCurrentTime = this.ntpService.currentTime();
        if (kronosTimeCurrentTime != null) {
            return Long.valueOf(kronosTimeCurrentTime.getPosixTimeMs());
        }
        return null;
    }
}
