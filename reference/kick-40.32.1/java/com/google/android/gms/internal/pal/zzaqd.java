package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzaqd implements zzvr {
    private zzaqd(byte[] bArr, zzarq zzarqVar) throws GeneralSecurityException {
        if (!zzaco.zza(2)) {
            throw new GeneralSecurityException("Can not use AES-GCM in FIPS-mode, as BoringCrypto module is not available.");
        }
        zzaat.zzb(bArr);
        zzarqVar.zzb();
    }

    public static zzvr zzb(zzxp zzxpVar) throws GeneralSecurityException {
        zzxpVar.zzf();
        zzxpVar.zzf();
        return new zzaqd(zzxpVar.zze().zzb(zzvx.zza()), zzxpVar.zzc());
    }

    @Override // com.google.android.gms.internal.pal.zzvr
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        throw null;
    }
}
