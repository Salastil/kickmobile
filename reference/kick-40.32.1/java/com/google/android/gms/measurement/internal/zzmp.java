package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzmp implements Runnable {
    final /* synthetic */ zzbh zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ com.google.android.gms.internal.measurement.zzcs zzc;
    final /* synthetic */ zznl zzd;

    zzmp(zznl zznlVar, zzbh zzbhVar, String str, com.google.android.gms.internal.measurement.zzcs zzcsVar) {
        this.zza = zzbhVar;
        this.zzb = str;
        this.zzc = zzcsVar;
        Objects.requireNonNull(zznlVar);
        this.zzd = zznlVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.gms.internal.measurement.zzcs zzcsVar;
        zzpp zzppVarZzk;
        byte[] bArrZzk = null;
        try {
            try {
                zznl zznlVar = this.zzd;
                zzgb zzgbVarZzZ = zznlVar.zzZ();
                if (zzgbVarZzZ == null) {
                    zzic zzicVar = zznlVar.zzu;
                    zzicVar.zzaW().zzb().zza("Discarding data. Failed to send event to service to bundle");
                    zzppVarZzk = zzicVar.zzk();
                    zzcsVar = this.zzc;
                } else {
                    bArrZzk = zzgbVarZzZ.zzk(this.zza, this.zzb);
                    zznlVar.zzV();
                    zznl zznlVar2 = this.zzd;
                    zzcsVar = this.zzc;
                    zzppVarZzk = zznlVar2.zzu.zzk();
                }
            } catch (RemoteException e) {
                this.zzd.zzu.zzaW().zzb().zzb("Failed to send event to the service to bundle", e);
            }
            zzppVarZzk.zzar(zzcsVar, bArrZzk);
        } catch (Throwable th) {
            zznl zznlVar3 = this.zzd;
            zznlVar3.zzu.zzk().zzar(this.zzc, null);
            throw th;
        }
    }
}
