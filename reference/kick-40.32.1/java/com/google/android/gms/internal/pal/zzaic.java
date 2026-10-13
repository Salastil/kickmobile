package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzaic {
    private static final zzahi zzb = zzaib.zza;
    private static final zzaic zzc = zzc();
    private final Map zza = new HashMap();

    public static zzaic zza() {
        return zzc;
    }

    private static zzaic zzc() {
        zzaic zzaicVar = new zzaic();
        try {
            zzaicVar.zzb(zzb, zzahu.class);
            return zzaicVar;
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException("unexpected error.", e);
        }
    }

    public final synchronized void zzb(zzahi zzahiVar, Class cls) throws GeneralSecurityException {
        Map map = this.zza;
        zzahi zzahiVar2 = (zzahi) map.get(cls);
        if (zzahiVar2 != null && !zzahiVar2.equals(zzahiVar)) {
            String string = cls.toString();
            StringBuilder sb = new StringBuilder(string.length() + 60);
            sb.append("Different key creator for parameters class ");
            sb.append(string);
            sb.append(" already inserted");
            throw new GeneralSecurityException(sb.toString());
        }
        map.put(cls, zzahiVar);
    }
}
