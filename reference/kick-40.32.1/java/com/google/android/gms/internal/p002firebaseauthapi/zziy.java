package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zziy implements zzbm {
    private static final ThreadLocal<Cipher> zza = new zzja();

    public static zzbm zza(zzen zzenVar) throws GeneralSecurityException {
        return zzhk.zza(zzenVar, (zzhj<Cipher>) new zzhj() { // from class: com.google.android.gms.internal.firebase-auth-api.zzix
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzhj
            public final Object zza() {
                return zziy.zzb();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Cipher zzb() throws GeneralSecurityException {
        try {
            Cipher cipher = zza.get();
            if (cipher != null) {
                return cipher;
            }
            throw new GeneralSecurityException("AES GCM SIV cipher is invalid.");
        } catch (IllegalStateException e) {
            throw new GeneralSecurityException("AES GCM SIV cipher is not available or is invalid.", e);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbm
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbm
    public final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        throw new NoSuchMethodError();
    }
}
