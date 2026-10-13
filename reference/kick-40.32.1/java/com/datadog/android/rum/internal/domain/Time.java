package com.datadog.android.rum.internal.domain;

import com.datadog.android.internal.time.TimeProvider;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Time.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0080\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/datadog/android/rum/internal/domain/Time;", "", "timestamp", "", "nanoTime", "(JJ)V", "getNanoTime", "()J", "getTimestamp", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class Time {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long nanoTime;
    private final long timestamp;

    public static /* synthetic */ Time copy$default(Time time, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = time.timestamp;
        }
        if ((i & 2) != 0) {
            j2 = time.nanoTime;
        }
        return time.copy(j, j2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getNanoTime() {
        return this.nanoTime;
    }

    public final Time copy(long timestamp, long nanoTime) {
        return new Time(timestamp, nanoTime);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Time)) {
            return false;
        }
        Time time = (Time) other;
        return this.timestamp == time.timestamp && this.nanoTime == time.nanoTime;
    }

    public int hashCode() {
        return (Long.hashCode(this.timestamp) * 31) + Long.hashCode(this.nanoTime);
    }

    public String toString() {
        return "Time(timestamp=" + this.timestamp + ", nanoTime=" + this.nanoTime + ")";
    }

    public Time(long j, long j2) {
        this.timestamp = j;
        this.nanoTime = j2;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final long getNanoTime() {
        return this.nanoTime;
    }

    /* JADX INFO: compiled from: Time.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b¨\u0006\f"}, d2 = {"Lcom/datadog/android/rum/internal/domain/Time$Companion;", "", "()V", "fromNanoTime", "Lcom/datadog/android/rum/internal/domain/Time;", "nanoTime", "", "timeProvider", "Lcom/datadog/android/internal/time/TimeProvider;", "fromTimestampMillis", "timestamp", "now", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Time now(TimeProvider timeProvider) {
            Intrinsics.checkNotNullParameter(timeProvider, "timeProvider");
            return new Time(timeProvider.getDeviceTimestampMillis(), timeProvider.getDeviceElapsedTimeNanos());
        }

        public final Time fromTimestampMillis(long timestamp, TimeProvider timeProvider) {
            Intrinsics.checkNotNullParameter(timeProvider, "timeProvider");
            Time timeNow = now(timeProvider);
            return new Time(timestamp, timeNow.getNanoTime() + TimeUnit.MILLISECONDS.toNanos(timestamp - timeNow.getTimestamp()));
        }

        public final Time fromNanoTime(long nanoTime, TimeProvider timeProvider) {
            Intrinsics.checkNotNullParameter(timeProvider, "timeProvider");
            Time timeNow = now(timeProvider);
            long nanoTime2 = nanoTime - timeNow.getNanoTime();
            long timestamp = timeNow.getTimestamp();
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            return new Time(timestamp + (nanoTime2 / 1000000), nanoTime);
        }
    }
}
