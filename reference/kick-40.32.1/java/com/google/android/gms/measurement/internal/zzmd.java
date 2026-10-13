package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzmd implements Runnable {
    final /* synthetic */ AtomicReference zza;
    final /* synthetic */ zzr zzb;
    final /* synthetic */ boolean zzc;
    final /* synthetic */ zznl zzd;

    zzmd(zznl zznlVar, AtomicReference atomicReference, zzr zzrVar, boolean z) {
        this.zza = atomicReference;
        this.zzb = zzrVar;
        this.zzc = z;
        Objects.requireNonNull(zznlVar);
        this.zzd = zznlVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference;
        AtomicReference atomicReference2 = this.zza;
        synchronized (atomicReference2) {
            try {
                try {
                    zznl zznlVar = this.zzd;
                    zzgb zzgbVarZzZ = zznlVar.zzZ();
                    if (zzgbVarZzZ == null) {
                        zznlVar.zzu.zzaW().zzb().zza("Failed to get all user properties; not connected to service");
                        atomicReference2.notify();
                        return;
                    }
                    zzr zzrVar = this.zzb;
                    Preconditions.checkNotNull(zzrVar);
                    atomicReference2.set(zzgbVarZzZ.zzj(zzrVar, this.zzc));
                    zznlVar.zzV();
                    atomicReference = this.zza;
                    atomicReference.notify();
                } catch (RemoteException e) {
                    this.zzd.zzu.zzaW().zzb().zzb("Failed to get all user properties; remote exception", e);
                    atomicReference = this.zza;
                }
            } catch (Throwable th) {
                this.zza.notify();
                throw th;
            }
        }
    }
}
