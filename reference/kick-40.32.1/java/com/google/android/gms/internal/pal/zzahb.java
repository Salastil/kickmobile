package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzahb {
    private final Map zza;
    private final Map zzb;

    /* synthetic */ zzahb(Map map, Map map2, byte[] bArr) {
        this.zza = map;
        this.zzb = map2;
    }

    public static zzaha zza() {
        return new zzaha(null);
    }

    public final Enum zzb(Object obj) throws GeneralSecurityException {
        Enum r1 = (Enum) this.zzb.get(obj);
        if (r1 != null) {
            return r1;
        }
        String strValueOf = String.valueOf(obj);
        String.valueOf(strValueOf);
        throw new GeneralSecurityException("Unable to convert object enum: ".concat(String.valueOf(strValueOf)));
    }

    public final Object zzc(Enum r2) throws GeneralSecurityException {
        Object obj = this.zza.get(r2);
        if (obj != null) {
            return obj;
        }
        String strValueOf = String.valueOf(r2);
        String.valueOf(strValueOf);
        throw new GeneralSecurityException("Unable to convert proto enum: ".concat(String.valueOf(strValueOf)));
    }
}
