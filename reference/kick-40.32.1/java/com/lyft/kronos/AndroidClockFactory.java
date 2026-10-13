package com.lyft.kronos;

import android.content.Context;
import android.content.SharedPreferences;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.datadog.android.rum.timeseries.TimeseriesConfiguration;
import com.lyft.kronos.internal.AndroidSystemClock;
import com.lyft.kronos.internal.SharedPreferenceSyncResponseCache;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: compiled from: AndroidClockFactory.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007JT\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u000fH\u0007¨\u0006\u0013"}, d2 = {"Lcom/lyft/kronos/AndroidClockFactory;", "", "()V", "createDeviceClock", "Lcom/lyft/kronos/Clock;", "createKronosClock", "Lcom/lyft/kronos/KronosClock;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "syncListener", "Lcom/lyft/kronos/SyncListener;", "ntpHosts", "", "", "requestTimeoutMs", "", "minWaitTimeBetweenSyncMs", "cacheExpirationMs", "maxNtpResponseTimeMs", "kronos-android_release"}, k = 1, mv = {1, 4, 0})
public final class AndroidClockFactory {
    public static final AndroidClockFactory INSTANCE = new AndroidClockFactory();

    @JvmStatic
    public static final KronosClock createKronosClock(Context context) {
        return createKronosClock$default(context, null, null, 0L, 0L, 0L, 0L, WebSocketProtocol.PAYLOAD_SHORT, null);
    }

    @JvmStatic
    public static final KronosClock createKronosClock(Context context, SyncListener syncListener) {
        return createKronosClock$default(context, syncListener, null, 0L, 0L, 0L, 0L, 124, null);
    }

    @JvmStatic
    public static final KronosClock createKronosClock(Context context, SyncListener syncListener, List<String> list) {
        return createKronosClock$default(context, syncListener, list, 0L, 0L, 0L, 0L, TimeseriesConfiguration.DEFAULT_BUFFER_SIZE, null);
    }

    @JvmStatic
    public static final KronosClock createKronosClock(Context context, SyncListener syncListener, List<String> list, long j) {
        return createKronosClock$default(context, syncListener, list, j, 0L, 0L, 0L, 112, null);
    }

    @JvmStatic
    public static final KronosClock createKronosClock(Context context, SyncListener syncListener, List<String> list, long j, long j2) {
        return createKronosClock$default(context, syncListener, list, j, j2, 0L, 0L, 96, null);
    }

    @JvmStatic
    public static final KronosClock createKronosClock(Context context, SyncListener syncListener, List<String> list, long j, long j2, long j3) {
        return createKronosClock$default(context, syncListener, list, j, j2, j3, 0L, 64, null);
    }

    private AndroidClockFactory() {
    }

    @JvmStatic
    public static final Clock createDeviceClock() {
        return new AndroidSystemClock();
    }

    public static /* synthetic */ KronosClock createKronosClock$default(Context context, SyncListener syncListener, List list, long j, long j2, long j3, long j4, int i, Object obj) {
        if ((i & 2) != 0) {
            syncListener = null;
        }
        if ((i & 4) != 0) {
            list = DefaultParam.INSTANCE.getNTP_HOSTS();
        }
        if ((i & 8) != 0) {
            j = DefaultParam.INSTANCE.getTIMEOUT_MS();
        }
        return createKronosClock(context, syncListener, list, j, (i & 16) != 0 ? DefaultParam.INSTANCE.getMIN_WAIT_TIME_BETWEEN_SYNC_MS() : j2, (i & 32) != 0 ? DefaultParam.INSTANCE.getCACHE_EXPIRATION_MS() : j3, (i & 64) != 0 ? DefaultParam.INSTANCE.getMAX_NTP_RESPONSE_TIME_MS() : j4);
    }

    @JvmStatic
    public static final KronosClock createKronosClock(Context context, SyncListener syncListener, List<String> ntpHosts, long requestTimeoutMs, long minWaitTimeBetweenSyncMs, long cacheExpirationMs, long maxNtpResponseTimeMs) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(ntpHosts, "ntpHosts");
        Clock clockCreateDeviceClock = createDeviceClock();
        SharedPreferences sharedPreferences = context.getSharedPreferences(SharedPreferenceSyncResponseCache.SHARED_PREFERENCES_NAME, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…ME, Context.MODE_PRIVATE)");
        return ClockFactory.createKronosClock(clockCreateDeviceClock, new SharedPreferenceSyncResponseCache(sharedPreferences), syncListener, ntpHosts, requestTimeoutMs, minWaitTimeBetweenSyncMs, cacheExpirationMs, maxNtpResponseTimeMs);
    }
}
