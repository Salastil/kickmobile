package com.lyft.kronos;

import androidx.camera.core.RetryPolicy;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.time.DurationKt;

/* JADX INFO: compiled from: DefaultParam.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/lyft/kronos/DefaultParam;", "", "()V", "CACHE_EXPIRATION_MS", "", "getCACHE_EXPIRATION_MS", "()J", "MAX_NTP_RESPONSE_TIME_MS", "getMAX_NTP_RESPONSE_TIME_MS", "MIN_WAIT_TIME_BETWEEN_SYNC_MS", "getMIN_WAIT_TIME_BETWEEN_SYNC_MS", "NTP_HOSTS", "", "", "getNTP_HOSTS", "()Ljava/util/List;", "TIMEOUT_MS", "getTIMEOUT_MS", "kronos-java"}, k = 1, mv = {1, 4, 0})
public final class DefaultParam {
    private static final long CACHE_EXPIRATION_MS;
    private static final long MAX_NTP_RESPONSE_TIME_MS;
    private static final long MIN_WAIT_TIME_BETWEEN_SYNC_MS;
    private static final long TIMEOUT_MS;
    public static final DefaultParam INSTANCE = new DefaultParam();
    private static final List<String> NTP_HOSTS = CollectionsKt.listOf((Object[]) new String[]{"0.pool.ntp.org", "1.pool.ntp.org", "2.pool.ntp.org", "3.pool.ntp.org"});

    static {
        TimeUnit timeUnit = TimeUnit.MINUTES;
        CACHE_EXPIRATION_MS = DurationKt.MILLIS_IN_MINUTE;
        TimeUnit timeUnit2 = TimeUnit.MINUTES;
        MIN_WAIT_TIME_BETWEEN_SYNC_MS = DurationKt.MILLIS_IN_MINUTE;
        TimeUnit timeUnit3 = TimeUnit.SECONDS;
        TIMEOUT_MS = RetryPolicy.DEFAULT_RETRY_TIMEOUT_IN_MILLIS;
        TimeUnit timeUnit4 = TimeUnit.SECONDS;
        MAX_NTP_RESPONSE_TIME_MS = 5000L;
    }

    private DefaultParam() {
    }

    public final List<String> getNTP_HOSTS() {
        return NTP_HOSTS;
    }

    public final long getCACHE_EXPIRATION_MS() {
        return CACHE_EXPIRATION_MS;
    }

    public final long getMIN_WAIT_TIME_BETWEEN_SYNC_MS() {
        return MIN_WAIT_TIME_BETWEEN_SYNC_MS;
    }

    public final long getTIMEOUT_MS() {
        return TIMEOUT_MS;
    }

    public final long getMAX_NTP_RESPONSE_TIME_MS() {
        return MAX_NTP_RESPONSE_TIME_MS;
    }
}
