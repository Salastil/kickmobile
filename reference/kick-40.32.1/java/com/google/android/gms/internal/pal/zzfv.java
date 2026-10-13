package com.google.android.gms.internal.pal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzfv extends zzgo {
    private final zzfc zzh;

    public zzfv(zzfb zzfbVar, String str, String str2, zzad zzadVar, int i, int i2, zzfc zzfcVar) {
        super(zzfbVar, "4UiqdD16WGcqj9vsERkA6tbA4c/2yE/sXnYMi3TR5nPXoyMXncc0iB8g5zhndeqU", "5yR6P4d4j2VnbvLNLQtiv9yBd7AWiKZJ6Mp0Kq9QPto=", zzadVar, i, 85);
        this.zzh = zzfcVar;
    }

    @Override // com.google.android.gms.internal.pal.zzgo
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        Method method = this.zze;
        zzfc zzfcVar = this.zzh;
        long[] jArr = (long[]) method.invoke(null, Long.valueOf(zzfcVar.zzf()), Long.valueOf(zzfcVar.zzg()), Long.valueOf(zzfcVar.zzi()), Long.valueOf(zzfcVar.zzh()));
        zzad zzadVar = this.zzd;
        synchronized (zzadVar) {
            zzadVar.zzV(jArr[0]);
            zzadVar.zzW(jArr[1]);
        }
    }
}
