package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzarp implements zzvr {
    private zzarp(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        new zzabt(bArr);
    }

    public static zzvr zzb(zzaab zzaabVar) throws GeneralSecurityException {
        return new zzarp(zzaabVar.zze().zzb(zzvx.zza()), zzaabVar.zzc().zzb());
    }

    @Override // com.google.android.gms.internal.pal.zzvr
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        throw null;
    }
}
