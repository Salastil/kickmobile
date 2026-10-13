package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public enum zzuq implements zzaur {
    IAB_TCF_SPECIAL_FEATURE_UNKNOWN(0),
    IAB_TCF_SPECIAL_FEATURE_USE_PRECISE_GEOLOCATION_DATA(1),
    IAB_TCF_SPECIAL_FEATURE_ACTIVELY_SCAN_DEVICE_CHARACTERISTICS_FOR_IDENTIFICATION(2),
    UNRECOGNIZED(-1);

    private final int zze;

    zzuq(int i) {
        this.zze = i;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.zze);
    }

    public final int zza() {
        if (this != UNRECOGNIZED) {
            return this.zze;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
