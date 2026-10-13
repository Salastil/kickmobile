package com.android.billingclient.api;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes5.dex */
final class zzdq {
    private static boolean zza = false;
    private static long zzb = 3000;
    private static long zzc = 30000;
    private static int zzd = 3;
    private static volatile boolean zze = true;

    static int zza() {
        return zzd;
    }

    static long zzb() {
        return zzc;
    }

    static long zzc() {
        return zzb;
    }

    static void zzd(long j) {
        zzc = j;
    }

    static void zze(int i) {
        zzd = i;
    }

    static void zzf(long j) {
        zzb = j;
    }

    static void zzg(boolean z) {
        zza = z;
    }

    static void zzh(boolean z) {
        zze = z;
    }

    static boolean zzi() {
        return zze;
    }

    static boolean zzj() {
        return zza;
    }
}
