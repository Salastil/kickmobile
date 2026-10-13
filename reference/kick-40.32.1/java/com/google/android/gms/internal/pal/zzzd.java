package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzzd {
    public static final zzzd zza = new zzzd("ASSUME_AES_GCM");
    public static final zzzd zzb = new zzzd("ASSUME_XCHACHA20POLY1305");
    public static final zzzd zzc = new zzzd("ASSUME_CHACHA20POLY1305");
    public static final zzzd zzd = new zzzd("ASSUME_AES_CTR_HMAC");
    public static final zzzd zze = new zzzd("ASSUME_AES_EAX");
    public static final zzzd zzf = new zzzd("ASSUME_AES_GCM_SIV");
    private final String zzg;

    private zzzd(String str) {
        this.zzg = str;
    }

    public final String toString() {
        return this.zzg;
    }
}
