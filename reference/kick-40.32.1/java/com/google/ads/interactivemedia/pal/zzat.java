package com.google.ads.interactivemedia.pal;

import android.os.Handler;
import com.google.android.gms.internal.pal.zzck;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzat {
    private final Handler zza;
    private final zzck zzb;
    private Runnable zzc;

    public zzat(Handler handler, zzck zzckVar) {
        this.zza = handler;
        this.zzb = zzckVar;
    }

    protected final void finalize() throws Throwable {
        zzb();
        super.finalize();
    }

    public final void zza(Runnable runnable) {
        if (this.zzc != null) {
            return;
        }
        zzas zzasVar = new zzas(this, runnable);
        this.zzc = zzasVar;
        this.zza.postDelayed(zzasVar, this.zzb.zzb());
    }

    public final void zzb() {
        Runnable runnable = this.zzc;
        if (runnable == null) {
            return;
        }
        this.zza.removeCallbacks(runnable);
        this.zzc = null;
    }

    final /* synthetic */ Handler zzc() {
        return this.zza;
    }

    final /* synthetic */ zzck zzd() {
        return this.zzb;
    }
}
