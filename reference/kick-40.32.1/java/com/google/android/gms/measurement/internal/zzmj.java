package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzmj implements Runnable {
    final /* synthetic */ zzr zza;
    final /* synthetic */ com.google.android.gms.internal.measurement.zzcs zzb;
    final /* synthetic */ zznl zzc;

    zzmj(zznl zznlVar, zzr zzrVar, com.google.android.gms.internal.measurement.zzcs zzcsVar) {
        this.zza = zzrVar;
        this.zzb = zzcsVar;
        Objects.requireNonNull(zznlVar);
        this.zzc = zznlVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.gms.internal.measurement.zzcs zzcsVar;
        zzpp zzppVarZzk;
        String strZzm = null;
        try {
            try {
                zznl zznlVar = this.zzc;
                zzic zzicVar = zznlVar.zzu;
                if (zzicVar.zzd().zzl().zzo(zzjk.ANALYTICS_STORAGE)) {
                    zzgb zzgbVarZzZ = zznlVar.zzZ();
                    if (zzgbVarZzZ != null) {
                        zzr zzrVar = this.zza;
                        Preconditions.checkNotNull(zzrVar);
                        strZzm = zzgbVarZzZ.zzm(zzrVar);
                        if (strZzm != null) {
                            zznlVar.zzu.zzj().zzQ(strZzm);
                            zzicVar.zzd().zze.zzb(strZzm);
                        }
                        zznlVar.zzV();
                        zznl zznlVar2 = this.zzc;
                        zzcsVar = this.zzb;
                        zzppVarZzk = zznlVar2.zzu.zzk();
                        zzppVarZzk.zzao(zzcsVar, strZzm);
                    }
                    zzicVar.zzaW().zzb().zza("Failed to get app instance id");
                } else {
                    zzicVar.zzaW().zzh().zza("Analytics storage consent denied; will not get app instance id");
                    zznlVar.zzu.zzj().zzQ(null);
                    zzicVar.zzd().zze.zzb(null);
                }
                zzppVarZzk = zzicVar.zzk();
                zzcsVar = this.zzb;
            } catch (RemoteException e) {
                this.zzc.zzu.zzaW().zzb().zzb("Failed to get app instance id", e);
            }
            zzppVarZzk.zzao(zzcsVar, strZzm);
        } catch (Throwable th) {
            zznl zznlVar3 = this.zzc;
            zznlVar3.zzu.zzk().zzao(this.zzb, null);
            throw th;
        }
    }
}
