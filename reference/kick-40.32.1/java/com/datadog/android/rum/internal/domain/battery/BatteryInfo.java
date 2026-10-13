package com.datadog.android.rum.internal.domain.battery;

import com.datadog.android.rum.internal.domain.InfoData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BatteryInfo.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ&\u0010\u000f\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/datadog/android/rum/internal/domain/battery/BatteryInfo;", "Lcom/datadog/android/rum/internal/domain/InfoData;", "batteryLevel", "", "lowPowerMode", "", "(Ljava/lang/Float;Ljava/lang/Boolean;)V", "getBatteryLevel", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getLowPowerMode", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "copy", "(Ljava/lang/Float;Ljava/lang/Boolean;)Lcom/datadog/android/rum/internal/domain/battery/BatteryInfo;", "equals", "other", "", "hashCode", "", "toString", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class BatteryInfo implements InfoData {
    private final Float batteryLevel;
    private final Boolean lowPowerMode;

    /* JADX WARN: Multi-variable type inference failed */
    public BatteryInfo() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ BatteryInfo copy$default(BatteryInfo batteryInfo, Float f, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            f = batteryInfo.batteryLevel;
        }
        if ((i & 2) != 0) {
            bool = batteryInfo.lowPowerMode;
        }
        return batteryInfo.copy(f, bool);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Float getBatteryLevel() {
        return this.batteryLevel;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Boolean getLowPowerMode() {
        return this.lowPowerMode;
    }

    public final BatteryInfo copy(Float batteryLevel, Boolean lowPowerMode) {
        return new BatteryInfo(batteryLevel, lowPowerMode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BatteryInfo)) {
            return false;
        }
        BatteryInfo batteryInfo = (BatteryInfo) other;
        return Intrinsics.areEqual((Object) this.batteryLevel, (Object) batteryInfo.batteryLevel) && Intrinsics.areEqual(this.lowPowerMode, batteryInfo.lowPowerMode);
    }

    public int hashCode() {
        Float f = this.batteryLevel;
        int iHashCode = (f == null ? 0 : f.hashCode()) * 31;
        Boolean bool = this.lowPowerMode;
        return iHashCode + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        return "BatteryInfo(batteryLevel=" + this.batteryLevel + ", lowPowerMode=" + this.lowPowerMode + ")";
    }

    public BatteryInfo(Float f, Boolean bool) {
        this.batteryLevel = f;
        this.lowPowerMode = bool;
    }

    public /* synthetic */ BatteryInfo(Float f, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : f, (i & 2) != 0 ? null : bool);
    }

    public final Float getBatteryLevel() {
        return this.batteryLevel;
    }

    public final Boolean getLowPowerMode() {
        return this.lowPowerMode;
    }
}
