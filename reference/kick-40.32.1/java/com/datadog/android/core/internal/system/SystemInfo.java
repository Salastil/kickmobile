package com.datadog.android.core.internal.system;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: SystemInfo.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001:\u0001\u0019B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/datadog/android/core/internal/system/SystemInfo;", "", "batteryFullOrCharging", "", "batteryLevel", "", "powerSaveMode", "onExternalPowerSource", "(ZIZZ)V", "getBatteryFullOrCharging", "()Z", "getBatteryLevel", "()I", "getOnExternalPowerSource", "getPowerSaveMode", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "BatteryStatus", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class SystemInfo {
    private final boolean batteryFullOrCharging;
    private final int batteryLevel;
    private final boolean onExternalPowerSource;
    private final boolean powerSaveMode;

    public SystemInfo() {
        this(false, 0, false, false, 15, null);
    }

    public static /* synthetic */ SystemInfo copy$default(SystemInfo systemInfo, boolean z, int i, boolean z2, boolean z3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = systemInfo.batteryFullOrCharging;
        }
        if ((i2 & 2) != 0) {
            i = systemInfo.batteryLevel;
        }
        if ((i2 & 4) != 0) {
            z2 = systemInfo.powerSaveMode;
        }
        if ((i2 & 8) != 0) {
            z3 = systemInfo.onExternalPowerSource;
        }
        return systemInfo.copy(z, i, z2, z3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getBatteryFullOrCharging() {
        return this.batteryFullOrCharging;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getBatteryLevel() {
        return this.batteryLevel;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getPowerSaveMode() {
        return this.powerSaveMode;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getOnExternalPowerSource() {
        return this.onExternalPowerSource;
    }

    public final SystemInfo copy(boolean batteryFullOrCharging, int batteryLevel, boolean powerSaveMode, boolean onExternalPowerSource) {
        return new SystemInfo(batteryFullOrCharging, batteryLevel, powerSaveMode, onExternalPowerSource);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SystemInfo)) {
            return false;
        }
        SystemInfo systemInfo = (SystemInfo) other;
        return this.batteryFullOrCharging == systemInfo.batteryFullOrCharging && this.batteryLevel == systemInfo.batteryLevel && this.powerSaveMode == systemInfo.powerSaveMode && this.onExternalPowerSource == systemInfo.onExternalPowerSource;
    }

    public int hashCode() {
        return (((((Boolean.hashCode(this.batteryFullOrCharging) * 31) + Integer.hashCode(this.batteryLevel)) * 31) + Boolean.hashCode(this.powerSaveMode)) * 31) + Boolean.hashCode(this.onExternalPowerSource);
    }

    public String toString() {
        return "SystemInfo(batteryFullOrCharging=" + this.batteryFullOrCharging + ", batteryLevel=" + this.batteryLevel + ", powerSaveMode=" + this.powerSaveMode + ", onExternalPowerSource=" + this.onExternalPowerSource + ")";
    }

    public SystemInfo(boolean z, int i, boolean z2, boolean z3) {
        this.batteryFullOrCharging = z;
        this.batteryLevel = i;
        this.powerSaveMode = z2;
        this.onExternalPowerSource = z3;
    }

    public /* synthetic */ SystemInfo(boolean z, int i, boolean z2, boolean z3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? -1 : i, (i2 & 4) != 0 ? false : z2, (i2 & 8) != 0 ? false : z3);
    }

    public final boolean getBatteryFullOrCharging() {
        return this.batteryFullOrCharging;
    }

    public final int getBatteryLevel() {
        return this.batteryLevel;
    }

    public final boolean getPowerSaveMode() {
        return this.powerSaveMode;
    }

    public final boolean getOnExternalPowerSource() {
        return this.onExternalPowerSource;
    }

    /* JADX INFO: compiled from: SystemInfo.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0080\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\t"}, d2 = {"Lcom/datadog/android/core/internal/system/SystemInfo$BatteryStatus;", "", "(Ljava/lang/String;I)V", "UNKNOWN", "CHARGING", "DISCHARGING", "NOT_CHARGING", "FULL", "Companion", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum BatteryStatus {
        UNKNOWN,
        CHARGING,
        DISCHARGING,
        NOT_CHARGING,
        FULL;


        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* JADX INFO: compiled from: SystemInfo.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/core/internal/system/SystemInfo$BatteryStatus$Companion;", "", "()V", "fromAndroidStatus", "Lcom/datadog/android/core/internal/system/SystemInfo$BatteryStatus;", "status", "", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final BatteryStatus fromAndroidStatus(int status) {
                if (status == 2) {
                    return BatteryStatus.CHARGING;
                }
                if (status == 3) {
                    return BatteryStatus.DISCHARGING;
                }
                if (status == 4) {
                    return BatteryStatus.NOT_CHARGING;
                }
                if (status == 5) {
                    return BatteryStatus.FULL;
                }
                return BatteryStatus.UNKNOWN;
            }
        }
    }
}
