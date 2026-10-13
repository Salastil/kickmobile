package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import java.security.Provider;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzalh implements zzajz {
    public zzalh(zzajr zzajrVar) {
    }

    public static zzajz zza(zzajr zzajrVar) throws GeneralSecurityException {
        if (!zzaco.zza(1)) {
            throw new GeneralSecurityException("Cannot use AES-CMAC in FIPS-mode.");
        }
        Provider providerZza = zzagw.zza();
        if (providerZza != null) {
            try {
                return zzalg.zza(zzajrVar, providerZza);
            } catch (GeneralSecurityException unused) {
            }
        }
        return new zzalh(zzajrVar);
    }
}
