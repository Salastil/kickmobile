package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzaak implements zzsz {
    public static zzsz zza(zzsx zzsxVar) throws GeneralSecurityException {
        zzsz zzszVarZza = zzta.zza(zzsxVar);
        try {
            return new zzaaj(zzszVarZza, zztc.zza(zzsxVar));
        } catch (GeneralSecurityException unused) {
            return zzszVarZza;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzsz
    public final byte[] zza(byte[] bArr, int i) throws GeneralSecurityException {
        throw new NoSuchMethodError();
    }
}
