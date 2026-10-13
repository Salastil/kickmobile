package com.google.android.gms.internal.pal;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzfy extends zzgo {
    private final zzet zzh;

    public zzfy(zzfb zzfbVar, String str, String str2, zzad zzadVar, int i, int i2, zzet zzetVar) {
        super(zzfbVar, "/BhgxpXYgahRBmZkS3xjCzPdid3mZtzdZmJFkhACyEa2oS6asfWgI5KysEGcSPE9", "ngST2QkCVNtF272EQbVjeXMfCtACYPfIcakPMgsny7g=", zzadVar, i, 94);
        this.zzh = zzetVar;
    }

    @Override // com.google.android.gms.internal.pal.zzgo
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        int iIntValue = ((Integer) this.zze.invoke(null, this.zzh.zza())).intValue();
        zzad zzadVar = this.zzd;
        synchronized (zzadVar) {
            zzadVar.zzae(zzar.zza(iIntValue));
        }
    }
}
