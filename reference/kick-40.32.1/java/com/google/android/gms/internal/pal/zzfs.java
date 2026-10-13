package com.google.android.gms.internal.pal;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzfs extends zzgo {
    private final long zzh;

    public zzfs(zzfb zzfbVar, String str, String str2, zzad zzadVar, long j, int i, int i2) {
        super(zzfbVar, "y0L1OSEMWW8/imV1M3pvQITWJfkGk5GAMqJuL5aNLdq8sTbK6BFpI8/D5pLc65zr", "dBSRUGPKY8JzIPoAEV0GB9RkRHGvAJPAM3BhqN1QQjE=", zzadVar, i, 25);
        this.zzh = j;
    }

    @Override // com.google.android.gms.internal.pal.zzgo
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        long jLongValue = ((Long) this.zze.invoke(null, null)).longValue();
        zzad zzadVar = this.zzd;
        synchronized (zzadVar) {
            zzadVar.zzY(jLongValue);
            long j = this.zzh;
            if (j != 0) {
                zzadVar.zzk(jLongValue - j);
                zzadVar.zzn(j);
            }
        }
    }
}
