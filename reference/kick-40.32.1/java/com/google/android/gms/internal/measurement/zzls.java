package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzls {
    private static final Object zza = new Object();
    private static volatile boolean zzb = false;
    private static volatile zzlr zzc = null;
    private static volatile boolean zzd = false;
    private static volatile zzlr zze;

    static void zza() {
        zzd = true;
    }

    static boolean zzb() {
        synchronized (zza) {
        }
        return false;
    }

    static void zzc() {
        if (zze == null) {
            zze = new zzlr(null);
        }
    }

    static void zzd() {
        if (zzc == null) {
            zzc = new zzlr(null);
        }
    }
}
