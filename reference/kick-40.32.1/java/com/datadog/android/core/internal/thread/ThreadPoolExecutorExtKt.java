package com.datadog.android.core.internal.thread;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.internal.time.TimeProvider;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: ThreadPoolExecutorExt.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0002\u001a\u00020\u0003*\u00020\u0004H\u0000\u001a$\u0010\u0005\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"MAX_SLEEP_DURATION_IN_MS", "", "isIdle", "", "Ljava/util/concurrent/ThreadPoolExecutor;", "waitToIdle", "timeoutInMs", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "timeProvider", "Lcom/datadog/android/internal/time/TimeProvider;", "dd-sdk-android-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ThreadPoolExecutorExtKt {
    public static final long MAX_SLEEP_DURATION_IN_MS = 10;

    public static final boolean waitToIdle(ThreadPoolExecutor threadPoolExecutor, long j, InternalLogger internalLogger, TimeProvider timeProvider) {
        Intrinsics.checkNotNullParameter(threadPoolExecutor, "<this>");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        Intrinsics.checkNotNullParameter(timeProvider, "timeProvider");
        long deviceElapsedTimeNanos = timeProvider.getDeviceElapsedTimeNanos();
        long nanos = TimeUnit.MILLISECONDS.toNanos(j);
        long jCoerceIn = RangesKt.coerceIn(j, 0L, 10L);
        while (!isIdle(threadPoolExecutor)) {
            boolean zSleepSafe = ThreadExtKt.sleepSafe(jCoerceIn, internalLogger);
            if (timeProvider.getDeviceElapsedTimeNanos() - deviceElapsedTimeNanos >= nanos || zSleepSafe) {
                return isIdle(threadPoolExecutor);
            }
        }
        return true;
    }

    public static final boolean isIdle(ThreadPoolExecutor threadPoolExecutor) {
        Intrinsics.checkNotNullParameter(threadPoolExecutor, "<this>");
        return threadPoolExecutor.getTaskCount() - threadPoolExecutor.getCompletedTaskCount() <= 0;
    }
}
