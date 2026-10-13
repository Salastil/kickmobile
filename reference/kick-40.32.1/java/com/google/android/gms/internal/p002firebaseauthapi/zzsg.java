package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.Provider;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzsg implements zzrd {
    private static final zzjd.zza zza = zzjd.zza.zza;

    public static zzrd zza(zzqt zzqtVar) throws GeneralSecurityException {
        if (!zza.zza()) {
            throw new GeneralSecurityException("Cannot use AES-CMAC in FIPS-mode.");
        }
        Provider providerZza = zznt.zza();
        if (providerZza != null) {
            try {
                return zzsh.zza(zzqtVar, providerZza);
            } catch (GeneralSecurityException unused) {
            }
        }
        return new zzsg(zzqtVar);
    }

    private zzsg(zzqt zzqtVar) {
    }
}
