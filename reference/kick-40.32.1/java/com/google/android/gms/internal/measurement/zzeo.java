package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
abstract class zzeo implements Runnable {
    final long zzi;
    final long zzj;
    final boolean zzk;
    final /* synthetic */ zzez zzl;

    zzeo(zzez zzezVar, boolean z) {
        Objects.requireNonNull(zzezVar);
        this.zzl = zzezVar;
        this.zzi = zzezVar.zza.currentTimeMillis();
        this.zzj = zzezVar.zza.elapsedRealtime();
        this.zzk = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zzl.zzR()) {
            zzb();
            return;
        }
        try {
            zza();
        } catch (Exception e) {
            this.zzl.zzN(e, false, this.zzk);
            zzb();
        }
    }

    abstract void zza() throws RemoteException;

    protected void zzb() {
    }
}
