package com.datadog.trace.core.util;

import androidx.collection.SieveCacheKt;
import androidx.media3.common.C;
import com.datadog.trace.api.time.SystemTimeSource;
import com.datadog.trace.api.time.TimeSource;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes6.dex */
public class SimpleRateLimiter {
    private final int capacity;
    private final AtomicLong secondsAndCount;
    private final long startNanos;
    private final TimeSource timeSource;

    private static long combineSecondsAndCount(int i, int i2) {
        return ((long) i2) | (((long) (i & Integer.MAX_VALUE)) << 32);
    }

    private static int getStoredCount(long j) {
        return (int) (j & SieveCacheKt.NodeLinkMask);
    }

    private static int getStoredSeconds(long j) {
        return (int) (j >> 32);
    }

    public SimpleRateLimiter(int i) {
        this(i, SystemTimeSource.INSTANCE);
    }

    protected SimpleRateLimiter(int i, TimeSource timeSource) {
        this.timeSource = timeSource;
        this.startNanos = timeSource.getNanoTicks();
        this.capacity = Math.max(1, i);
        this.secondsAndCount = new AtomicLong(0L);
    }

    public boolean tryAcquire() {
        long j;
        long jCombineSecondsAndCount;
        int nanoTicks = 0;
        boolean z = true;
        do {
            j = this.secondsAndCount.get();
            if (z) {
                TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                nanoTicks = (int) ((this.timeSource.getNanoTicks() - this.startNanos) / C.NANOS_PER_SECOND);
                z = false;
            }
            int storedSeconds = getStoredSeconds(j);
            int storedCount = getStoredCount(j);
            int i = nanoTicks - storedSeconds;
            if (i <= 0) {
                int i2 = storedCount + 1;
                if (i2 > this.capacity || i2 < 0) {
                    return false;
                }
                jCombineSecondsAndCount = combineSecondsAndCount(storedSeconds, i2);
                if (i < 0) {
                    z = true;
                }
            } else {
                jCombineSecondsAndCount = combineSecondsAndCount(nanoTicks, 1);
            }
        } while (!this.secondsAndCount.compareAndSet(j, jCombineSecondsAndCount));
        return true;
    }

    public int getCapacity() {
        return this.capacity;
    }
}
