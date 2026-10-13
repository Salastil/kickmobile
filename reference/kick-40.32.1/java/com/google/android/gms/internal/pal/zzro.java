package com.google.android.gms.internal.pal;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public abstract class zzro {
    private static final zzro zza = new zzri();

    /* synthetic */ zzro(byte[] bArr) {
    }

    public abstract void zza(zzre zzreVar, Object obj);

    public abstract int zzb();

    public abstract Set zzc();

    public static zzro zzh(zzqx zzqxVar, zzqx zzqxVar2) {
        int iZza = zzqxVar2.zza();
        if (iZza == 0) {
            return zza;
        }
        byte[] bArr = null;
        return iZza <= 28 ? new zzrm(zzqxVar, zzqxVar2, bArr) : new zzrn(zzqxVar, zzqxVar2, bArr);
    }
}
