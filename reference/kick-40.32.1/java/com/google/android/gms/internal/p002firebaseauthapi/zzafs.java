package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzafs implements Runnable {
    private final /* synthetic */ zzafv zza;
    private final /* synthetic */ zzafp zzb;

    zzafs(zzafp zzafpVar, zzafv zzafvVar) {
        this.zza = zzafvVar;
        Objects.requireNonNull(zzafpVar);
        this.zzb = zzafpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zzb.zza.zzh) {
            if (!this.zzb.zza.zzh.isEmpty()) {
                this.zza.zza(this.zzb.zza.zzh.get(0), new Object[0]);
            }
        }
    }
}
