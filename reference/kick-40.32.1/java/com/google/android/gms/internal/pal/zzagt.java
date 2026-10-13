package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzagt implements zzagr {
    private zzagt() {
        throw null;
    }

    /* synthetic */ zzagt(byte[] bArr) {
    }

    @Override // com.google.android.gms.internal.pal.zzagr
    public final zzagq zza() throws GeneralSecurityException {
        byte[] bArrZza = zzajh.zza(32);
        bArrZza[0] = (byte) (bArrZza[0] | 7);
        int i = bArrZza[31] & 63;
        bArrZza[31] = (byte) i;
        bArrZza[31] = (byte) (i | 128);
        return new zzagq(bArrZza, zzaro.zzb(bArrZza));
    }

    @Override // com.google.android.gms.internal.pal.zzagr
    public final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        return zzaro.zza(bArr, bArr2);
    }
}
