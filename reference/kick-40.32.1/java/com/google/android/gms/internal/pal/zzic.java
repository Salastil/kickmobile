package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzic {
    private final String zza;
    private final Object zzb;
    private final int zzc;

    protected zzic(String str, Object obj, int i) {
        this.zza = str;
        this.zzb = obj;
        this.zzc = i;
    }

    public static zzic zza(String str, boolean z) {
        return new zzic(str, Boolean.valueOf(z), 1);
    }

    public static zzic zzb(String str, long j) {
        return new zzic(str, Long.valueOf(j), 2);
    }

    public final Object zzc() {
        zzih zzihVarZza = zzij.zza();
        if (zzihVarZza == null) {
            if (zzij.zzb() != null) {
                zzij.zzb().zza();
            }
            return this.zzb;
        }
        int i = this.zzc - 1;
        String str = this.zza;
        return i != 0 ? zzihVarZza.zzb(str, ((Long) this.zzb).longValue()) : zzihVarZza.zza(str, ((Boolean) this.zzb).booleanValue());
    }
}
