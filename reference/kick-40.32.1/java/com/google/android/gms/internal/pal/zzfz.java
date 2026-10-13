package com.google.android.gms.internal.pal;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzfz extends zzgo {
    private final zzee zzh;
    private final long zzi;
    private final long zzj;

    public zzfz(zzfb zzfbVar, String str, String str2, zzad zzadVar, int i, int i2, zzee zzeeVar, long j, long j2) {
        super(zzfbVar, "0RGuaC1LZ8p4RZIWK5IFPvVh1XqX7pdLKGQgqTXZ1mkub6VwNtebK8xyUGpHkvMn", "mIcXOfgrOloP6pQFjXZ3aL2iJ7mq+own2SaqzDvu6Tk=", zzadVar, i, 11);
        this.zzh = zzeeVar;
        this.zzi = j;
        this.zzj = j2;
    }

    @Override // com.google.android.gms.internal.pal.zzgo
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        zzee zzeeVar = this.zzh;
        if (zzeeVar != null) {
            zzec zzecVar = new zzec((String) this.zze.invoke(null, zzeeVar.zzb(), Long.valueOf(this.zzi), Long.valueOf(this.zzj)));
            zzad zzadVar = this.zzd;
            synchronized (zzadVar) {
                zzadVar.zzf(zzecVar.zza.longValue());
                if (zzecVar.zzb.longValue() >= 0) {
                    zzadVar.zzT(zzecVar.zzb.longValue());
                }
                if (zzecVar.zzc.longValue() >= 0) {
                    zzadVar.zzU(zzecVar.zzc.longValue());
                }
            }
        }
    }
}
