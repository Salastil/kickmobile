package com.google.android.gms.internal.measurement;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public abstract class zzaaa {
    private static final zzaaa zza = new zzzu();

    /* synthetic */ zzaaa(byte[] bArr) {
    }

    public abstract void zza(zzzq zzzqVar, Object obj);

    public abstract int zzb();

    public abstract Set zzc();

    public static zzaaa zzh(zzzj zzzjVar, zzzj zzzjVar2) {
        int iZza = zzzjVar2.zza();
        if (iZza == 0) {
            return zza;
        }
        byte[] bArr = null;
        return iZza <= 28 ? new zzzy(zzzjVar, zzzjVar2, bArr) : new zzzz(zzzjVar, zzzjVar2, bArr);
    }
}
