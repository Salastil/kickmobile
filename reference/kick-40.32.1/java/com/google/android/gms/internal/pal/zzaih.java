package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzaih {
    private static final zzaih zzb = new zzaih();
    private final Map zza = new HashMap();

    zzaih() {
    }

    public static zzaih zza() {
        return zzb;
    }

    public final synchronized void zzb(String str, zzwk zzwkVar) throws GeneralSecurityException {
        Map map = this.zza;
        if (!map.containsKey(str)) {
            map.put(str, zzwkVar);
            return;
        }
        if (((zzwk) map.get(str)).equals(zzwkVar)) {
            return;
        }
        String strValueOf = String.valueOf(map.get(str));
        String strValueOf2 = String.valueOf(zzwkVar);
        int length = String.valueOf(str).length();
        StringBuilder sb = new StringBuilder(length + 45 + String.valueOf(strValueOf).length() + 17 + String.valueOf(strValueOf2).length());
        sb.append("Parameters object with name ");
        sb.append(str);
        sb.append(" already exists (");
        sb.append(strValueOf);
        sb.append("), cannot insert ");
        sb.append(strValueOf2);
        throw new GeneralSecurityException(sb.toString());
    }

    public final synchronized void zzc(Map map) throws GeneralSecurityException {
        for (Map.Entry entry : map.entrySet()) {
            zzb((String) entry.getKey(), (zzwk) entry.getValue());
        }
    }
}
