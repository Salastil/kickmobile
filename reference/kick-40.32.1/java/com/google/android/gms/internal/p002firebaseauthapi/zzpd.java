package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzpd {
    private static final zzpd zza = new zzpd();
    private final Map<String, zzcs> zzb = new HashMap();

    public static zzpd zza() {
        return zza;
    }

    zzpd() {
    }

    private final synchronized void zza(String str, zzcs zzcsVar) throws GeneralSecurityException {
        boolean zContainsKey = this.zzb.containsKey(str);
        Map<String, zzcs> map = this.zzb;
        if (zContainsKey) {
            if (map.get(str).equals(zzcsVar)) {
                return;
            }
            throw new GeneralSecurityException("Parameters object with name " + str + " already exists (" + String.valueOf(this.zzb.get(str)) + "), cannot insert " + String.valueOf(zzcsVar));
        }
        map.put(str, zzcsVar);
    }

    public final synchronized void zza(Map<String, zzcs> map) throws GeneralSecurityException {
        for (Map.Entry<String, zzcs> entry : map.entrySet()) {
            zza(entry.getKey(), entry.getValue());
        }
    }
}
