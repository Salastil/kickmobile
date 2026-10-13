package com.datadog.android.rum.internal.metric;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ViewInitializationMetricsState.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J0\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/datadog/android/rum/internal/metric/ViewInitializationMetricsState;", "", "initializationTime", "", "config", "Lcom/datadog/android/rum/internal/metric/ViewInitializationMetricsConfig;", "noValueReason", "Lcom/datadog/android/rum/internal/metric/NoValueReason;", "(Ljava/lang/Long;Lcom/datadog/android/rum/internal/metric/ViewInitializationMetricsConfig;Lcom/datadog/android/rum/internal/metric/NoValueReason;)V", "getConfig", "()Lcom/datadog/android/rum/internal/metric/ViewInitializationMetricsConfig;", "getInitializationTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getNoValueReason", "()Lcom/datadog/android/rum/internal/metric/NoValueReason;", "component1", "component2", "component3", "copy", "(Ljava/lang/Long;Lcom/datadog/android/rum/internal/metric/ViewInitializationMetricsConfig;Lcom/datadog/android/rum/internal/metric/NoValueReason;)Lcom/datadog/android/rum/internal/metric/ViewInitializationMetricsState;", "equals", "", "other", "hashCode", "", "toString", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ViewInitializationMetricsState {
    private final ViewInitializationMetricsConfig config;
    private final Long initializationTime;
    private final NoValueReason noValueReason;

    public static /* synthetic */ ViewInitializationMetricsState copy$default(ViewInitializationMetricsState viewInitializationMetricsState, Long l, ViewInitializationMetricsConfig viewInitializationMetricsConfig, NoValueReason noValueReason, int i, Object obj) {
        if ((i & 1) != 0) {
            l = viewInitializationMetricsState.initializationTime;
        }
        if ((i & 2) != 0) {
            viewInitializationMetricsConfig = viewInitializationMetricsState.config;
        }
        if ((i & 4) != 0) {
            noValueReason = viewInitializationMetricsState.noValueReason;
        }
        return viewInitializationMetricsState.copy(l, viewInitializationMetricsConfig, noValueReason);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Long getInitializationTime() {
        return this.initializationTime;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ViewInitializationMetricsConfig getConfig() {
        return this.config;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final NoValueReason getNoValueReason() {
        return this.noValueReason;
    }

    public final ViewInitializationMetricsState copy(Long initializationTime, ViewInitializationMetricsConfig config, NoValueReason noValueReason) {
        Intrinsics.checkNotNullParameter(config, "config");
        return new ViewInitializationMetricsState(initializationTime, config, noValueReason);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ViewInitializationMetricsState)) {
            return false;
        }
        ViewInitializationMetricsState viewInitializationMetricsState = (ViewInitializationMetricsState) other;
        return Intrinsics.areEqual(this.initializationTime, viewInitializationMetricsState.initializationTime) && this.config == viewInitializationMetricsState.config && Intrinsics.areEqual(this.noValueReason, viewInitializationMetricsState.noValueReason);
    }

    public int hashCode() {
        Long l = this.initializationTime;
        int iHashCode = (((l == null ? 0 : l.hashCode()) * 31) + this.config.hashCode()) * 31;
        NoValueReason noValueReason = this.noValueReason;
        return iHashCode + (noValueReason != null ? noValueReason.hashCode() : 0);
    }

    public String toString() {
        return "ViewInitializationMetricsState(initializationTime=" + this.initializationTime + ", config=" + this.config + ", noValueReason=" + this.noValueReason + ")";
    }

    public ViewInitializationMetricsState(Long l, ViewInitializationMetricsConfig config, NoValueReason noValueReason) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.initializationTime = l;
        this.config = config;
        this.noValueReason = noValueReason;
    }

    public final Long getInitializationTime() {
        return this.initializationTime;
    }

    public final ViewInitializationMetricsConfig getConfig() {
        return this.config;
    }

    public final NoValueReason getNoValueReason() {
        return this.noValueReason;
    }
}
