package com.google.android.gms.internal.cast;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast-framework@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzgu extends zzgw {
    private final Handler zza;

    public zzgu(Looper looper) {
        this.zza = new Handler(looper);
    }

    @Override // com.google.android.gms.internal.cast.zzgw
    public final void zza(zzgt zzgtVar) {
        this.zza.postDelayed(zzgtVar.zzc(), 0L);
    }
}
