package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzcw {
    public static final zzcw zza = new zzcw("UNKNOWN_KEYMATERIAL");
    public static final zzcw zzb = new zzcw("SYMMETRIC");
    public static final zzcw zzc = new zzcw("ASYMMETRIC_PRIVATE");
    public static final zzcw zzd = new zzcw("ASYMMETRIC_PUBLIC");
    public static final zzcw zze = new zzcw("REMOTE");
    private final String zzf;

    public final String toString() {
        return this.zzf;
    }

    private zzcw(String str) {
        this.zzf = str;
    }
}
