package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.Provider;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzacc implements zzvr {
    private zzacc(byte[] bArr, byte[] bArr2, Provider provider) throws GeneralSecurityException {
        if (!zzaco.zza(1)) {
            throw new GeneralSecurityException("Can not use ChaCha20Poly1305 in FIPS-mode.");
        }
        if (bArr.length != 32) {
            throw new InvalidKeyException("The key length in bytes must be 32.");
        }
    }

    public static zzvr zzb(zzaab zzaabVar) throws GeneralSecurityException {
        return new zzacc(zzaabVar.zze().zzb(zzvx.zza()), zzaabVar.zzc().zzb(), zzabg.zzc().getProvider());
    }

    @Override // com.google.android.gms.internal.pal.zzvr
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        throw null;
    }
}
