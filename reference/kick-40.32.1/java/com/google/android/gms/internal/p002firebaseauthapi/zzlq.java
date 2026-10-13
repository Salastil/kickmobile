package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzlq {
    private static final byte[] zza = new byte[0];

    public static zzlu zza(zzkl zzklVar) throws GeneralSecurityException {
        zzcs zzcsVarZzb = zzklVar.zzb();
        if (zzcsVarZzb instanceof zzel) {
            return new zzls((zzel) zzcsVarZzb);
        }
        if (zzcsVarZzb instanceof zzdw) {
            return new zzlt((zzdw) zzcsVarZzb);
        }
        if (zzcsVarZzb instanceof zzjp) {
            return new zzlv((zzjp) zzcsVarZzb);
        }
        throw new GeneralSecurityException("Unsupported DEM parameters: " + String.valueOf(zzcsVarZzb));
    }
}
