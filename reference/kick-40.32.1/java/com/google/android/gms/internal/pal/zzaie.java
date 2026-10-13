package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzaie {
    private static final zzaie zzb = new zzaie();
    private final Map zza = new HashMap();

    public static zzaie zza() {
        return zzb;
    }

    public final synchronized void zzb(zzaid zzaidVar, Class cls) throws GeneralSecurityException {
        Map map = this.zza;
        zzaid zzaidVar2 = (zzaid) map.get(cls);
        if (zzaidVar2 != null && !zzaidVar2.equals(zzaidVar)) {
            throw new GeneralSecurityException("Different key creator for parameters class already inserted");
        }
        map.put(cls, zzaidVar);
    }
}
