package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzarj implements zzalr {
    public static zzalr zzb(zzalp zzalpVar) throws GeneralSecurityException {
        zzalr zzalrVarZzb = zzalv.zzb(zzalpVar);
        try {
            return new zzari(zzalrVarZzb, zzalw.zzb(zzalpVar), null);
        } catch (GeneralSecurityException unused) {
            return zzalrVarZzb;
        }
    }

    @Override // com.google.android.gms.internal.pal.zzalr
    public final byte[] zza(byte[] bArr, int i) throws GeneralSecurityException {
        throw null;
    }
}
