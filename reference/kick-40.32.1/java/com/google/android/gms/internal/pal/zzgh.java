package com.google.android.gms.internal.pal;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzgh extends zzgo {
    public zzgh(zzfb zzfbVar, String str, String str2, zzad zzadVar, int i, int i2) {
        super(zzfbVar, "Qz9CKMoDCHphOXPELo049qp61nrfn738aUeATKOiX7hq+kw0ujtW3xI/vlQKBh37", "bze+wYBAHEMh8JSXqo0+D4B3Aq+R4fX2jHr7eo7ufbY=", zzadVar, i, 51);
    }

    @Override // com.google.android.gms.internal.pal.zzgo
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        zzad zzadVar = this.zzd;
        synchronized (zzadVar) {
            zzew zzewVar = new zzew((String) this.zze.invoke(null, null));
            zzadVar.zzF(zzewVar.zza.longValue());
            zzadVar.zzG(zzewVar.zzb.longValue());
        }
    }
}
