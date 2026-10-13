package com.datadog.android.rum.internal.domain.event;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ResourceTiming.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001Bi\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003Jm\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020*HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000f¨\u0006+"}, d2 = {"Lcom/datadog/android/rum/internal/domain/event/ResourceTiming;", "", "dnsStart", "", "dnsDuration", "connectStart", "connectDuration", "sslStart", "sslDuration", "firstByteStart", "firstByteDuration", "downloadStart", "downloadDuration", "(JJJJJJJJJJ)V", "getConnectDuration", "()J", "getConnectStart", "getDnsDuration", "getDnsStart", "getDownloadDuration", "getDownloadStart", "getFirstByteDuration", "getFirstByteStart", "getSslDuration", "getSslStart", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ResourceTiming {
    private final long connectDuration;
    private final long connectStart;
    private final long dnsDuration;
    private final long dnsStart;
    private final long downloadDuration;
    private final long downloadStart;
    private final long firstByteDuration;
    private final long firstByteStart;
    private final long sslDuration;
    private final long sslStart;

    public ResourceTiming() {
        this(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 1023, null);
    }

    public static /* synthetic */ ResourceTiming copy$default(ResourceTiming resourceTiming, long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, int i, Object obj) {
        long j11;
        long j12;
        long j13 = (i & 1) != 0 ? resourceTiming.dnsStart : j;
        long j14 = (i & 2) != 0 ? resourceTiming.dnsDuration : j2;
        long j15 = (i & 4) != 0 ? resourceTiming.connectStart : j3;
        long j16 = (i & 8) != 0 ? resourceTiming.connectDuration : j4;
        long j17 = (i & 16) != 0 ? resourceTiming.sslStart : j5;
        long j18 = (i & 32) != 0 ? resourceTiming.sslDuration : j6;
        long j19 = (i & 64) != 0 ? resourceTiming.firstByteStart : j7;
        long j20 = j13;
        long j21 = (i & 128) != 0 ? resourceTiming.firstByteDuration : j8;
        long j22 = (i & 256) != 0 ? resourceTiming.downloadStart : j9;
        if ((i & 512) != 0) {
            j12 = j22;
            j11 = resourceTiming.downloadDuration;
        } else {
            j11 = j10;
            j12 = j22;
        }
        return resourceTiming.copy(j20, j14, j15, j16, j17, j18, j19, j21, j12, j11);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getDnsStart() {
        return this.dnsStart;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final long getDownloadDuration() {
        return this.downloadDuration;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getDnsDuration() {
        return this.dnsDuration;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getConnectStart() {
        return this.connectStart;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getConnectDuration() {
        return this.connectDuration;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getSslStart() {
        return this.sslStart;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final long getSslDuration() {
        return this.sslDuration;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final long getFirstByteStart() {
        return this.firstByteStart;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final long getFirstByteDuration() {
        return this.firstByteDuration;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final long getDownloadStart() {
        return this.downloadStart;
    }

    public final ResourceTiming copy(long dnsStart, long dnsDuration, long connectStart, long connectDuration, long sslStart, long sslDuration, long firstByteStart, long firstByteDuration, long downloadStart, long downloadDuration) {
        return new ResourceTiming(dnsStart, dnsDuration, connectStart, connectDuration, sslStart, sslDuration, firstByteStart, firstByteDuration, downloadStart, downloadDuration);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ResourceTiming)) {
            return false;
        }
        ResourceTiming resourceTiming = (ResourceTiming) other;
        return this.dnsStart == resourceTiming.dnsStart && this.dnsDuration == resourceTiming.dnsDuration && this.connectStart == resourceTiming.connectStart && this.connectDuration == resourceTiming.connectDuration && this.sslStart == resourceTiming.sslStart && this.sslDuration == resourceTiming.sslDuration && this.firstByteStart == resourceTiming.firstByteStart && this.firstByteDuration == resourceTiming.firstByteDuration && this.downloadStart == resourceTiming.downloadStart && this.downloadDuration == resourceTiming.downloadDuration;
    }

    public int hashCode() {
        return (((((((((((((((((Long.hashCode(this.dnsStart) * 31) + Long.hashCode(this.dnsDuration)) * 31) + Long.hashCode(this.connectStart)) * 31) + Long.hashCode(this.connectDuration)) * 31) + Long.hashCode(this.sslStart)) * 31) + Long.hashCode(this.sslDuration)) * 31) + Long.hashCode(this.firstByteStart)) * 31) + Long.hashCode(this.firstByteDuration)) * 31) + Long.hashCode(this.downloadStart)) * 31) + Long.hashCode(this.downloadDuration);
    }

    public String toString() {
        return "ResourceTiming(dnsStart=" + this.dnsStart + ", dnsDuration=" + this.dnsDuration + ", connectStart=" + this.connectStart + ", connectDuration=" + this.connectDuration + ", sslStart=" + this.sslStart + ", sslDuration=" + this.sslDuration + ", firstByteStart=" + this.firstByteStart + ", firstByteDuration=" + this.firstByteDuration + ", downloadStart=" + this.downloadStart + ", downloadDuration=" + this.downloadDuration + ")";
    }

    public ResourceTiming(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10) {
        this.dnsStart = j;
        this.dnsDuration = j2;
        this.connectStart = j3;
        this.connectDuration = j4;
        this.sslStart = j5;
        this.sslDuration = j6;
        this.firstByteStart = j7;
        this.firstByteDuration = j8;
        this.downloadStart = j9;
        this.downloadDuration = j10;
    }

    public /* synthetic */ ResourceTiming(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? 0L : j2, (i & 4) != 0 ? 0L : j3, (i & 8) != 0 ? 0L : j4, (i & 16) != 0 ? 0L : j5, (i & 32) != 0 ? 0L : j6, (i & 64) != 0 ? 0L : j7, (i & 128) != 0 ? 0L : j8, (i & 256) != 0 ? 0L : j9, (i & 512) != 0 ? 0L : j10);
    }

    public final long getDnsStart() {
        return this.dnsStart;
    }

    public final long getDnsDuration() {
        return this.dnsDuration;
    }

    public final long getConnectStart() {
        return this.connectStart;
    }

    public final long getConnectDuration() {
        return this.connectDuration;
    }

    public final long getSslStart() {
        return this.sslStart;
    }

    public final long getSslDuration() {
        return this.sslDuration;
    }

    public final long getFirstByteStart() {
        return this.firstByteStart;
    }

    public final long getFirstByteDuration() {
        return this.firstByteDuration;
    }

    public final long getDownloadStart() {
        return this.downloadStart;
    }

    public final long getDownloadDuration() {
        return this.downloadDuration;
    }
}
