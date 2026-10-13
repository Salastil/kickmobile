package com.google.android.gms.internal.pal;

import android.content.Context;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzez implements Runnable {
    final /* synthetic */ int zza;
    final /* synthetic */ zzfb zzb;

    zzez(zzfb zzfbVar, int i, boolean z) {
        this.zza = i;
        Objects.requireNonNull(zzfbVar);
        this.zzb = zzfbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbd zzbdVarZza;
        int i = this.zza;
        zzfb zzfbVar = this.zzb;
        if (i > 0) {
            try {
                Thread.sleep(i * 1000);
            } catch (InterruptedException unused) {
            }
        }
        try {
            Context context = zzfbVar.zza;
            zzbdVarZza = zzjj.zza(context, context.getPackageName(), Integer.toString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode));
        } catch (Throwable unused2) {
            zzbdVarZza = null;
        }
        zzfb zzfbVar2 = this.zzb;
        zzfbVar2.zzs(zzbdVarZza);
        int i2 = this.zza;
        if (i2 < 4) {
            if (zzbdVarZza != null && zzbdVarZza.zza() && !zzbdVarZza.zzb().equals("0000000000000000000000000000000000000000000000000000000000000000") && zzbdVarZza.zzd() && zzbdVarZza.zze().zza() && zzbdVarZza.zze().zzb() != -2) {
                return;
            }
            zzfbVar2.zzp(i2 + 1, true);
        }
    }
}
