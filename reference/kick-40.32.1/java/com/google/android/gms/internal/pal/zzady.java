package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzady {
    public static final zzady zza = new zzady("COMPRESSED");
    public static final zzady zzb = new zzady("UNCOMPRESSED");
    public static final zzady zzc = new zzady("LEGACY_UNCOMPRESSED");
    private final String zzd;

    private zzady(String str) {
        this.zzd = str;
    }

    public final String toString() {
        return this.zzd;
    }
}
