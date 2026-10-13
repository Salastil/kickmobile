package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzabw implements zzvr {
    private zzabw(byte[] bArr, zzarq zzarqVar, int i) throws GeneralSecurityException {
        zzarj.zzb(zzalp.zzc(zzalq.zzb(bArr.length), zzars.zza(bArr, zzvx.zza())));
        zzarqVar.zzb();
    }

    public static zzvr zzb(zzzv zzzvVar) throws GeneralSecurityException {
        zzzvVar.zzf();
        zzzvVar.zzf();
        return new zzabw(zzzvVar.zze().zzb(zzvx.zza()), zzzvVar.zzc(), zzzvVar.zzf().zzd());
    }

    @Override // com.google.android.gms.internal.pal.zzvr
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        throw null;
    }
}
