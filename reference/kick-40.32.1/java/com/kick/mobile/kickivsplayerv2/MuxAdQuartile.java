package com.kick.mobile.kickivsplayerv2;

import com.mux.stats.sdk.core.events.playback.AdEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MuxAnalyticsListener.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0014\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/kick/mobile/kickivsplayerv2/MuxAdQuartile;", "", "threshold", "", "marker", "", "event", "Lcom/mux/stats/sdk/core/events/playback/AdEvent;", "<init>", "(DILcom/mux/stats/sdk/core/events/playback/AdEvent;)V", "getThreshold", "()D", "getMarker", "()I", "getEvent", "()Lcom/mux/stats/sdk/core/events/playback/AdEvent;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "kick-ivs-player-v2_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
final /* data */ class MuxAdQuartile {
    private final AdEvent event;
    private final int marker;
    private final double threshold;

    public static /* synthetic */ MuxAdQuartile copy$default(MuxAdQuartile muxAdQuartile, double d, int i, AdEvent adEvent, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            d = muxAdQuartile.threshold;
        }
        if ((i2 & 2) != 0) {
            i = muxAdQuartile.marker;
        }
        if ((i2 & 4) != 0) {
            adEvent = muxAdQuartile.event;
        }
        return muxAdQuartile.copy(d, i, adEvent);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final double getThreshold() {
        return this.threshold;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getMarker() {
        return this.marker;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final AdEvent getEvent() {
        return this.event;
    }

    public final MuxAdQuartile copy(double threshold, int marker, AdEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return new MuxAdQuartile(threshold, marker, event);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MuxAdQuartile)) {
            return false;
        }
        MuxAdQuartile muxAdQuartile = (MuxAdQuartile) other;
        return Double.compare(this.threshold, muxAdQuartile.threshold) == 0 && this.marker == muxAdQuartile.marker && Intrinsics.areEqual(this.event, muxAdQuartile.event);
    }

    public int hashCode() {
        return (((Double.hashCode(this.threshold) * 31) + Integer.hashCode(this.marker)) * 31) + this.event.hashCode();
    }

    public String toString() {
        return "MuxAdQuartile(threshold=" + this.threshold + ", marker=" + this.marker + ", event=" + this.event + ")";
    }

    public MuxAdQuartile(double d, int i, AdEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.threshold = d;
        this.marker = i;
        this.event = event;
    }

    public final double getThreshold() {
        return this.threshold;
    }

    public final int getMarker() {
        return this.marker;
    }

    public final AdEvent getEvent() {
        return this.event;
    }
}
