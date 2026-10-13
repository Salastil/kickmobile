package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzcn {
    private static final CopyOnWriteArrayList<zzco> zza = new CopyOnWriteArrayList<>();

    public static zzco zza(String str) throws GeneralSecurityException {
        for (zzco zzcoVar : zza) {
            if (zzcoVar.zzb(str)) {
                return zzcoVar;
            }
        }
        throw new GeneralSecurityException("No KMS client does support: " + str);
    }
}
