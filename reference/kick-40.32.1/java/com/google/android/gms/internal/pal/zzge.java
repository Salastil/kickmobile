package com.google.android.gms.internal.pal;

import android.content.Context;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzge extends zzgo {
    private List zzh;
    private final Context zzi;

    public zzge(zzfb zzfbVar, String str, String str2, zzad zzadVar, int i, int i2, Context context) {
        super(zzfbVar, "XXF2CX++qjQzFfJDmqd+84h356GlStFLqQSTRbbce/csPkd7M5mpQw1l7igXWffL", "FGCYjW2JaOcRH3mqSkgHIxbWzEwOVje6sx286yuA1xM=", zzadVar, i, 31);
        this.zzh = null;
        this.zzi = context;
    }

    @Override // com.google.android.gms.internal.pal.zzgo
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        zzad zzadVar = this.zzd;
        zzadVar.zzq(-1L);
        zzadVar.zzr(-1L);
        Context contextZzb = this.zzi;
        if (contextZzb == null) {
            contextZzb = this.zza.zzb();
        }
        if (this.zzh == null) {
            this.zzh = (List) this.zze.invoke(null, contextZzb);
        }
        List list = this.zzh;
        if (list == null || list.size() != 2) {
            return;
        }
        synchronized (zzadVar) {
            zzadVar.zzq(((Long) this.zzh.get(0)).longValue());
            zzadVar.zzr(((Long) this.zzh.get(1)).longValue());
        }
    }
}
