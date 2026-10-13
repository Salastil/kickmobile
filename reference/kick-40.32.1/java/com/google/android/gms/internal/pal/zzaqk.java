package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzaqk implements zzvr {
    private zzaqk(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        new zzabp(bArr);
    }

    public static zzvr zzb(zzyg zzygVar) throws GeneralSecurityException {
        return new zzaqk(zzygVar.zze().zzb(zzvx.zza()), zzygVar.zzc().zzb());
    }

    @Override // com.google.android.gms.internal.pal.zzvr
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        throw null;
    }
}
