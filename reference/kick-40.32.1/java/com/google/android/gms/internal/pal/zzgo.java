package com.google.android.gms.internal.pal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public abstract class zzgo implements Callable {
    protected final zzfb zza;
    protected final String zzb;
    protected final String zzc;
    protected final zzad zzd;
    protected Method zze;
    protected final int zzf;
    protected final int zzg;

    public zzgo(zzfb zzfbVar, String str, String str2, zzad zzadVar, int i, int i2) {
        getClass().getSimpleName();
        this.zza = zzfbVar;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = zzadVar;
        this.zzf = i;
        this.zzg = i2;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        int i;
        try {
            long jNanoTime = System.nanoTime();
            zzfb zzfbVar = this.zza;
            Method methodZzo = zzfbVar.zzo(this.zzb, this.zzc);
            this.zze = methodZzo;
            if (methodZzo == null) {
                return null;
            }
            zza();
            zzdo zzdoVarZzh = zzfbVar.zzh();
            if (zzdoVarZzh == null || (i = this.zzf) == Integer.MIN_VALUE) {
                return null;
            }
            zzdoVarZzh.zza(this.zzg, i, (System.nanoTime() - jNanoTime) / 1000, null, null);
            return null;
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    protected abstract void zza() throws IllegalAccessException, InvocationTargetException;
}
