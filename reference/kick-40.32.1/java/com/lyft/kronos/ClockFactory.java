package com.lyft.kronos;

import com.lyft.kronos.internal.KronosClockImpl;
import com.lyft.kronos.internal.ntp.DatagramFactoryImpl;
import com.lyft.kronos.internal.ntp.DnsResolverImpl;
import com.lyft.kronos.internal.ntp.SntpClient;
import com.lyft.kronos.internal.ntp.SntpResponseCacheImpl;
import com.lyft.kronos.internal.ntp.SntpServiceImpl;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ClockFactory.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\\\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u000fH\u0007¨\u0006\u0013"}, d2 = {"Lcom/lyft/kronos/ClockFactory;", "", "()V", "createKronosClock", "Lcom/lyft/kronos/KronosClock;", "localClock", "Lcom/lyft/kronos/Clock;", "syncResponseCache", "Lcom/lyft/kronos/SyncResponseCache;", "syncListener", "Lcom/lyft/kronos/SyncListener;", "ntpHosts", "", "", "requestTimeoutMs", "", "minWaitTimeBetweenSyncMs", "cacheExpirationMs", "maxNtpResponseTimeMs", "kronos-java"}, k = 1, mv = {1, 4, 0})
public final class ClockFactory {
    public static final ClockFactory INSTANCE = new ClockFactory();

    @JvmStatic
    public static final KronosClock createKronosClock(Clock clock, SyncResponseCache syncResponseCache) {
        return createKronosClock$default(clock, syncResponseCache, null, null, 0L, 0L, 0L, 0L, 252, null);
    }

    @JvmStatic
    public static final KronosClock createKronosClock(Clock clock, SyncResponseCache syncResponseCache, SyncListener syncListener) {
        return createKronosClock$default(clock, syncResponseCache, syncListener, null, 0L, 0L, 0L, 0L, 248, null);
    }

    @JvmStatic
    public static final KronosClock createKronosClock(Clock clock, SyncResponseCache syncResponseCache, SyncListener syncListener, List<String> list) {
        return createKronosClock$default(clock, syncResponseCache, syncListener, list, 0L, 0L, 0L, 0L, 240, null);
    }

    @JvmStatic
    public static final KronosClock createKronosClock(Clock clock, SyncResponseCache syncResponseCache, SyncListener syncListener, List<String> list, long j) {
        return createKronosClock$default(clock, syncResponseCache, syncListener, list, j, 0L, 0L, 0L, 224, null);
    }

    @JvmStatic
    public static final KronosClock createKronosClock(Clock clock, SyncResponseCache syncResponseCache, SyncListener syncListener, List<String> list, long j, long j2) {
        return createKronosClock$default(clock, syncResponseCache, syncListener, list, j, j2, 0L, 0L, 192, null);
    }

    @JvmStatic
    public static final KronosClock createKronosClock(Clock clock, SyncResponseCache syncResponseCache, SyncListener syncListener, List<String> list, long j, long j2, long j3) {
        return createKronosClock$default(clock, syncResponseCache, syncListener, list, j, j2, j3, 0L, 128, null);
    }

    private ClockFactory() {
    }

    public static /* synthetic */ KronosClock createKronosClock$default(Clock clock, SyncResponseCache syncResponseCache, SyncListener syncListener, List list, long j, long j2, long j3, long j4, int i, Object obj) {
        SyncListener syncListener2;
        if ((i & 4) != 0) {
            syncListener2 = null;
        } else {
            syncListener2 = syncListener;
        }
        return createKronosClock(clock, syncResponseCache, syncListener2, (i & 8) != 0 ? DefaultParam.INSTANCE.getNTP_HOSTS() : list, (i & 16) != 0 ? DefaultParam.INSTANCE.getTIMEOUT_MS() : j, (i & 32) != 0 ? DefaultParam.INSTANCE.getMIN_WAIT_TIME_BETWEEN_SYNC_MS() : j2, (i & 64) != 0 ? DefaultParam.INSTANCE.getCACHE_EXPIRATION_MS() : j3, (i & 128) != 0 ? DefaultParam.INSTANCE.getMAX_NTP_RESPONSE_TIME_MS() : j4);
    }

    @JvmStatic
    public static final KronosClock createKronosClock(Clock localClock, SyncResponseCache syncResponseCache, SyncListener syncListener, List<String> ntpHosts, long requestTimeoutMs, long minWaitTimeBetweenSyncMs, long cacheExpirationMs, long maxNtpResponseTimeMs) {
        Intrinsics.checkNotNullParameter(localClock, "localClock");
        Intrinsics.checkNotNullParameter(syncResponseCache, "syncResponseCache");
        Intrinsics.checkNotNullParameter(ntpHosts, "ntpHosts");
        if (localClock instanceof KronosClock) {
            throw new IllegalArgumentException("Local clock should implement Clock instead of KronosClock");
        }
        return new KronosClockImpl(new SntpServiceImpl(new SntpClient(localClock, new DnsResolverImpl(), new DatagramFactoryImpl()), localClock, new SntpResponseCacheImpl(syncResponseCache, localClock), syncListener, ntpHosts, requestTimeoutMs, minWaitTimeBetweenSyncMs, cacheExpirationMs, maxNtpResponseTimeMs), localClock);
    }
}
