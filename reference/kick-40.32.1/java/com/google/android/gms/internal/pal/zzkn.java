package com.google.android.gms.internal.pal;

import android.os.RemoteException;
import android.util.Log;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzkn {
    final /* synthetic */ zzko zza;
    private final byte[] zzb;
    private int zzc;
    private int zzd;

    /* synthetic */ zzkn(zzko zzkoVar, byte[] bArr, byte[] bArr2) {
        Objects.requireNonNull(zzkoVar);
        this.zza = zzkoVar;
        this.zzb = bArr;
    }

    public final synchronized void zza() {
        try {
            zzko zzkoVar = this.zza;
            if (zzkoVar.zzb) {
                zzkr zzkrVar = zzkoVar.zza;
                zzkrVar.zzg(this.zzb);
                zzkrVar.zzh(this.zzc);
                zzkrVar.zzi(this.zzd);
                zzkrVar.zzf(null);
                zzkrVar.zze();
            }
        } catch (RemoteException e) {
            Log.d("GASS", "Clearcut log failed", e);
        }
    }

    public final zzkn zzb(int i) {
        this.zzc = i;
        return this;
    }

    public final zzkn zzc(int i) {
        this.zzd = i;
        return this;
    }
}
