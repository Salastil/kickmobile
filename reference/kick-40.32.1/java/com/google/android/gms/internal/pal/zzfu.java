package com.google.android.gms.internal.pal;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzfu implements Callable {
    private final zzfb zza;
    private final zzad zzb;

    public zzfu(zzfb zzfbVar, zzad zzadVar) {
        this.zza = zzfbVar;
        this.zzb = zzadVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzfb zzfbVar = this.zza;
        if (zzfbVar.zzm() != null) {
            zzfbVar.zzm().get();
        }
        zzbd zzbdVarZzl = zzfbVar.zzl();
        if (zzbdVarZzl == null) {
            return null;
        }
        try {
            zzad zzadVar = this.zzb;
            synchronized (zzadVar) {
                try {
                    byte[] bArrZzaq = zzbdVarZzl.zzaq();
                    zzadVar.zzan(bArrZzaq, 0, bArrZzaq.length, zzaty.zza());
                } catch (Throwable th) {
                    throw th;
                }
            }
            return null;
        } catch (zzavb | NullPointerException unused) {
            return null;
        }
    }
}
