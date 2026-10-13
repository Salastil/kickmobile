package com.datadog.android.rum.internal.startup;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RumTTIDInfo.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/datadog/android/rum/internal/startup/RumTTIDInfo;", "", RumAppStartupTelemetryReporterImpl.KEY_SCENARIO, "Lcom/datadog/android/rum/internal/startup/RumStartupScenario;", "durationNs", "", "wasForwarded", "", "(Lcom/datadog/android/rum/internal/startup/RumStartupScenario;JZ)V", "getDurationNs", "()J", "getScenario", "()Lcom/datadog/android/rum/internal/startup/RumStartupScenario;", "getWasForwarded", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class RumTTIDInfo {
    private final long durationNs;
    private final RumStartupScenario scenario;
    private final boolean wasForwarded;

    public static /* synthetic */ RumTTIDInfo copy$default(RumTTIDInfo rumTTIDInfo, RumStartupScenario rumStartupScenario, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            rumStartupScenario = rumTTIDInfo.scenario;
        }
        if ((i & 2) != 0) {
            j = rumTTIDInfo.durationNs;
        }
        if ((i & 4) != 0) {
            z = rumTTIDInfo.wasForwarded;
        }
        return rumTTIDInfo.copy(rumStartupScenario, j, z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final RumStartupScenario getScenario() {
        return this.scenario;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getDurationNs() {
        return this.durationNs;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getWasForwarded() {
        return this.wasForwarded;
    }

    public final RumTTIDInfo copy(RumStartupScenario scenario, long durationNs, boolean wasForwarded) {
        Intrinsics.checkNotNullParameter(scenario, "scenario");
        return new RumTTIDInfo(scenario, durationNs, wasForwarded);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RumTTIDInfo)) {
            return false;
        }
        RumTTIDInfo rumTTIDInfo = (RumTTIDInfo) other;
        return Intrinsics.areEqual(this.scenario, rumTTIDInfo.scenario) && this.durationNs == rumTTIDInfo.durationNs && this.wasForwarded == rumTTIDInfo.wasForwarded;
    }

    public int hashCode() {
        return (((this.scenario.hashCode() * 31) + Long.hashCode(this.durationNs)) * 31) + Boolean.hashCode(this.wasForwarded);
    }

    public String toString() {
        return "RumTTIDInfo(scenario=" + this.scenario + ", durationNs=" + this.durationNs + ", wasForwarded=" + this.wasForwarded + ")";
    }

    public RumTTIDInfo(RumStartupScenario scenario, long j, boolean z) {
        Intrinsics.checkNotNullParameter(scenario, "scenario");
        this.scenario = scenario;
        this.durationNs = j;
        this.wasForwarded = z;
    }

    public /* synthetic */ RumTTIDInfo(RumStartupScenario rumStartupScenario, long j, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(rumStartupScenario, j, (i & 4) != 0 ? false : z);
    }

    public final RumStartupScenario getScenario() {
        return this.scenario;
    }

    public final long getDurationNs() {
        return this.durationNs;
    }

    public final boolean getWasForwarded() {
        return this.wasForwarded;
    }
}
