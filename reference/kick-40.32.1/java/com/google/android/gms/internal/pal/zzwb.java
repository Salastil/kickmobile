package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzwb {
    public static final zzwb zza = new zzwb("ENABLED");
    public static final zzwb zzb = new zzwb("DISABLED");
    public static final zzwb zzc = new zzwb("DESTROYED");
    private final String zzd;

    private zzwb(String str) {
        this.zzd = str;
    }

    public final String toString() {
        return this.zzd;
    }
}
