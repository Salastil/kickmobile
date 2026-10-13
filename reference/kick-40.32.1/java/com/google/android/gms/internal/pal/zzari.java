package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzari implements zzalr {
    final zzalr zza;
    final zzalr zzb;

    /* synthetic */ zzari(zzalr zzalrVar, zzalr zzalrVar2, byte[] bArr) {
        this.zza = zzalrVar;
        this.zzb = zzalrVar2;
    }

    @Override // com.google.android.gms.internal.pal.zzalr
    public final byte[] zza(byte[] bArr, int i) throws GeneralSecurityException {
        return bArr.length <= 64 ? this.zza.zza(bArr, i) : this.zzb.zza(bArr, i);
    }
}
