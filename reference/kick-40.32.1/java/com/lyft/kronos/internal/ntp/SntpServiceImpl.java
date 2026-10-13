package com.lyft.kronos.internal.ntp;

import androidx.window.core.layout.WindowSizeClass;
import com.datadog.android.log.LogAttributes;
import com.facebook.react.bridge.BaseJavaModule;
import com.lyft.kronos.Clock;
import com.lyft.kronos.DefaultParam;
import com.lyft.kronos.KronosTime;
import com.lyft.kronos.SyncListener;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SntpService.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0001+B_\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000e¢\u0006\u0002\u0010\u0012J\n\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020%H\u0016J\b\u0010'\u001a\u00020(H\u0016J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\fH\u0002J\b\u0010*\u001a\u00020%H\u0016R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\n \u001a*\u0004\u0018\u00010\u00190\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u001c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001f\u001a\u0010\u0012\f\u0012\n \u001a*\u0004\u0018\u00010!0!0 X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/lyft/kronos/internal/ntp/SntpServiceImpl;", "Lcom/lyft/kronos/internal/ntp/SntpService;", "sntpClient", "Lcom/lyft/kronos/internal/ntp/SntpClient;", "deviceClock", "Lcom/lyft/kronos/Clock;", "responseCache", "Lcom/lyft/kronos/internal/ntp/SntpResponseCache;", "ntpSyncListener", "Lcom/lyft/kronos/SyncListener;", "ntpHosts", "", "", "requestTimeoutMs", "", "minWaitTimeBetweenSyncMs", "cacheExpirationMs", "maxNtpResponseTimeMs", "(Lcom/lyft/kronos/internal/ntp/SntpClient;Lcom/lyft/kronos/Clock;Lcom/lyft/kronos/internal/ntp/SntpResponseCache;Lcom/lyft/kronos/SyncListener;Ljava/util/List;JJJJ)V", "cacheSyncAge", "getCacheSyncAge", "()J", "cachedSyncTime", "Ljava/util/concurrent/atomic/AtomicLong;", "executor", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "response", "Lcom/lyft/kronos/internal/ntp/SntpClient$Response;", "getResponse", "()Lcom/lyft/kronos/internal/ntp/SntpClient$Response;", "state", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/lyft/kronos/internal/ntp/SntpServiceImpl$State;", "currentTime", "Lcom/lyft/kronos/KronosTime;", "ensureServiceIsRunning", "", "shutdown", BaseJavaModule.METHOD_TYPE_SYNC, "", LogAttributes.HOST, "syncInBackground", "State", "kronos-java"}, k = 1, mv = {1, 4, 0})
public final class SntpServiceImpl implements SntpService {
    private final long cacheExpirationMs;
    private final AtomicLong cachedSyncTime;
    private final Clock deviceClock;
    private final ExecutorService executor;
    private final long maxNtpResponseTimeMs;
    private final long minWaitTimeBetweenSyncMs;
    private final List<String> ntpHosts;
    private final SyncListener ntpSyncListener;
    private final long requestTimeoutMs;
    private final SntpResponseCache responseCache;
    private final SntpClient sntpClient;
    private final AtomicReference<State> state;

    /* JADX INFO: compiled from: SntpService.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/lyft/kronos/internal/ntp/SntpServiceImpl$State;", "", "(Ljava/lang/String;I)V", "IDLE", "SYNCING", "STOPPED", "kronos-java"}, k = 1, mv = {1, 4, 0})
    private enum State {
        IDLE,
        SYNCING,
        STOPPED
    }

    public SntpServiceImpl(SntpClient sntpClient, Clock clock, SntpResponseCache sntpResponseCache, SyncListener syncListener, List<String> list) {
        this(sntpClient, clock, sntpResponseCache, syncListener, list, 0L, 0L, 0L, 0L, WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND, null);
    }

    public SntpServiceImpl(SntpClient sntpClient, Clock clock, SntpResponseCache sntpResponseCache, SyncListener syncListener, List<String> list, long j) {
        this(sntpClient, clock, sntpResponseCache, syncListener, list, j, 0L, 0L, 0L, 448, null);
    }

    public SntpServiceImpl(SntpClient sntpClient, Clock clock, SntpResponseCache sntpResponseCache, SyncListener syncListener, List<String> list, long j, long j2) {
        this(sntpClient, clock, sntpResponseCache, syncListener, list, j, j2, 0L, 0L, 384, null);
    }

    public SntpServiceImpl(SntpClient sntpClient, Clock clock, SntpResponseCache sntpResponseCache, SyncListener syncListener, List<String> list, long j, long j2, long j3) {
        this(sntpClient, clock, sntpResponseCache, syncListener, list, j, j2, j3, 0L, 256, null);
    }

    public SntpServiceImpl(SntpClient sntpClient, Clock deviceClock, SntpResponseCache responseCache, SyncListener syncListener, List<String> ntpHosts, long j, long j2, long j3, long j4) {
        Intrinsics.checkNotNullParameter(sntpClient, "sntpClient");
        Intrinsics.checkNotNullParameter(deviceClock, "deviceClock");
        Intrinsics.checkNotNullParameter(responseCache, "responseCache");
        Intrinsics.checkNotNullParameter(ntpHosts, "ntpHosts");
        this.sntpClient = sntpClient;
        this.deviceClock = deviceClock;
        this.responseCache = responseCache;
        this.ntpSyncListener = syncListener;
        this.ntpHosts = ntpHosts;
        this.requestTimeoutMs = j;
        this.minWaitTimeBetweenSyncMs = j2;
        this.cacheExpirationMs = j3;
        this.maxNtpResponseTimeMs = j4;
        this.state = new AtomicReference<>(State.IDLE);
        this.cachedSyncTime = new AtomicLong(0L);
        this.executor = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.lyft.kronos.internal.ntp.SntpServiceImpl$executor$1
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return new Thread(runnable, "kronos-android");
            }
        });
    }

    @Override // com.lyft.kronos.internal.ntp.SntpService
    public long currentTimeMs() {
        return SntpService.DefaultImpls.currentTimeMs(this);
    }

    public /* synthetic */ SntpServiceImpl(SntpClient sntpClient, Clock clock, SntpResponseCache sntpResponseCache, SyncListener syncListener, List list, long j, long j2, long j3, long j4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(sntpClient, clock, sntpResponseCache, syncListener, list, (i & 32) != 0 ? DefaultParam.INSTANCE.getTIMEOUT_MS() : j, (i & 64) != 0 ? DefaultParam.INSTANCE.getMIN_WAIT_TIME_BETWEEN_SYNC_MS() : j2, (i & 128) != 0 ? DefaultParam.INSTANCE.getCACHE_EXPIRATION_MS() : j3, (i & 256) != 0 ? DefaultParam.INSTANCE.getMAX_NTP_RESPONSE_TIME_MS() : j4);
    }

    private final SntpClient.Response getResponse() {
        SntpClient.Response response = this.responseCache.get();
        if (this.state.get() != State.IDLE || response == null || response.isFromSameBoot()) {
            return response;
        }
        this.responseCache.clear();
        return null;
    }

    private final long getCacheSyncAge() {
        return this.deviceClock.getElapsedTimeMs() - this.cachedSyncTime.get();
    }

    @Override // com.lyft.kronos.internal.ntp.SntpService
    public KronosTime currentTime() {
        ensureServiceIsRunning();
        SntpClient.Response response = getResponse();
        if (response == null) {
            if (getCacheSyncAge() < this.minWaitTimeBetweenSyncMs) {
                return null;
            }
            syncInBackground();
            return null;
        }
        long responseAge = response.getResponseAge();
        if (responseAge >= this.cacheExpirationMs && getCacheSyncAge() >= this.minWaitTimeBetweenSyncMs) {
            syncInBackground();
        }
        return new KronosTime(response.getCurrentTimeMs(), Long.valueOf(responseAge));
    }

    @Override // com.lyft.kronos.internal.ntp.SntpService
    public void syncInBackground() {
        ensureServiceIsRunning();
        if (this.state.get() != State.SYNCING) {
            this.executor.submit(new Runnable() { // from class: com.lyft.kronos.internal.ntp.SntpServiceImpl.syncInBackground.1
                @Override // java.lang.Runnable
                public final void run() {
                    SntpServiceImpl.this.sync();
                }
            });
        }
    }

    @Override // com.lyft.kronos.internal.ntp.SntpService
    public void shutdown() {
        ensureServiceIsRunning();
        this.state.set(State.STOPPED);
        this.executor.shutdown();
    }

    @Override // com.lyft.kronos.internal.ntp.SntpService
    public boolean sync() {
        ensureServiceIsRunning();
        Iterator<String> it = this.ntpHosts.iterator();
        while (it.hasNext()) {
            if (sync(it.next())) {
                return true;
            }
        }
        return false;
    }

    private final void ensureServiceIsRunning() {
        if (this.state.get() == State.STOPPED) {
            throw new IllegalStateException("Service already shutdown");
        }
    }

    private final boolean sync(String host) {
        if (this.state.getAndSet(State.SYNCING) == State.SYNCING) {
            return false;
        }
        long elapsedTimeMs = this.deviceClock.getElapsedTimeMs();
        SyncListener syncListener = this.ntpSyncListener;
        if (syncListener != null) {
            syncListener.onStartSync(host);
        }
        try {
            SntpClient.Response response = this.sntpClient.requestTime(host, Long.valueOf(this.requestTimeoutMs));
            Intrinsics.checkNotNullExpressionValue(response, "response");
            if (response.getCurrentTimeMs() < 0) {
                throw new NTPSyncException("Invalid time " + response.getCurrentTimeMs() + " received from " + host);
            }
            long elapsedTimeMs2 = this.deviceClock.getElapsedTimeMs() - elapsedTimeMs;
            if (elapsedTimeMs2 > this.maxNtpResponseTimeMs) {
                throw new NTPSyncException("Ignoring response from " + host + " because the network latency (" + elapsedTimeMs2 + " ms) is longer than the required value (" + this.maxNtpResponseTimeMs + " ms");
            }
            this.responseCache.update(response);
            long offsetMs = response.getOffsetMs();
            SyncListener syncListener2 = this.ntpSyncListener;
            if (syncListener2 != null) {
                syncListener2.onSuccess(offsetMs, elapsedTimeMs2);
            }
            this.state.set(State.IDLE);
            this.cachedSyncTime.set(this.deviceClock.getElapsedTimeMs());
            return true;
        } catch (Throwable th) {
            try {
                SyncListener syncListener3 = this.ntpSyncListener;
                if (syncListener3 != null) {
                    syncListener3.onError(host, th);
                }
                return false;
            } finally {
                this.state.set(State.IDLE);
                this.cachedSyncTime.set(this.deviceClock.getElapsedTimeMs());
            }
        }
    }
}
