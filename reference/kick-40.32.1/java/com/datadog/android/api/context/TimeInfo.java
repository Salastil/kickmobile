package com.datadog.android.api.context;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: TimeInfo.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001a"}, d2 = {"Lcom/datadog/android/api/context/TimeInfo;", "", "deviceTimeNs", "", "serverTimeNs", "serverTimeOffsetNs", "serverTimeOffsetMs", "(JJJJ)V", "getDeviceTimeNs", "()J", "getServerTimeNs", "getServerTimeOffsetMs", "getServerTimeOffsetNs", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class TimeInfo {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final TimeInfo EMPTY = new TimeInfo(0, 0, 0, 0);
    private final long deviceTimeNs;
    private final long serverTimeNs;
    private final long serverTimeOffsetMs;
    private final long serverTimeOffsetNs;

    public static /* synthetic */ TimeInfo copy$default(TimeInfo timeInfo, long j, long j2, long j3, long j4, int i, Object obj) {
        if ((i & 1) != 0) {
            j = timeInfo.deviceTimeNs;
        }
        long j5 = j;
        if ((i & 2) != 0) {
            j2 = timeInfo.serverTimeNs;
        }
        long j6 = j2;
        if ((i & 4) != 0) {
            j3 = timeInfo.serverTimeOffsetNs;
        }
        return timeInfo.copy(j5, j6, j3, (i & 8) != 0 ? timeInfo.serverTimeOffsetMs : j4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getDeviceTimeNs() {
        return this.deviceTimeNs;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getServerTimeNs() {
        return this.serverTimeNs;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getServerTimeOffsetNs() {
        return this.serverTimeOffsetNs;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getServerTimeOffsetMs() {
        return this.serverTimeOffsetMs;
    }

    public final TimeInfo copy(long deviceTimeNs, long serverTimeNs, long serverTimeOffsetNs, long serverTimeOffsetMs) {
        return new TimeInfo(deviceTimeNs, serverTimeNs, serverTimeOffsetNs, serverTimeOffsetMs);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TimeInfo)) {
            return false;
        }
        TimeInfo timeInfo = (TimeInfo) other;
        return this.deviceTimeNs == timeInfo.deviceTimeNs && this.serverTimeNs == timeInfo.serverTimeNs && this.serverTimeOffsetNs == timeInfo.serverTimeOffsetNs && this.serverTimeOffsetMs == timeInfo.serverTimeOffsetMs;
    }

    public int hashCode() {
        return (((((Long.hashCode(this.deviceTimeNs) * 31) + Long.hashCode(this.serverTimeNs)) * 31) + Long.hashCode(this.serverTimeOffsetNs)) * 31) + Long.hashCode(this.serverTimeOffsetMs);
    }

    public String toString() {
        return "TimeInfo(deviceTimeNs=" + this.deviceTimeNs + ", serverTimeNs=" + this.serverTimeNs + ", serverTimeOffsetNs=" + this.serverTimeOffsetNs + ", serverTimeOffsetMs=" + this.serverTimeOffsetMs + ")";
    }

    public TimeInfo(long j, long j2, long j3, long j4) {
        this.deviceTimeNs = j;
        this.serverTimeNs = j2;
        this.serverTimeOffsetNs = j3;
        this.serverTimeOffsetMs = j4;
    }

    public final long getDeviceTimeNs() {
        return this.deviceTimeNs;
    }

    public final long getServerTimeNs() {
        return this.serverTimeNs;
    }

    public final long getServerTimeOffsetNs() {
        return this.serverTimeOffsetNs;
    }

    public final long getServerTimeOffsetMs() {
        return this.serverTimeOffsetMs;
    }

    /* JADX INFO: compiled from: TimeInfo.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/api/context/TimeInfo$Companion;", "", "()V", "EMPTY", "Lcom/datadog/android/api/context/TimeInfo;", "getEMPTY$dd_sdk_android_core_release", "()Lcom/datadog/android/api/context/TimeInfo;", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final TimeInfo getEMPTY$dd_sdk_android_core_release() {
            return TimeInfo.EMPTY;
        }
    }
}
