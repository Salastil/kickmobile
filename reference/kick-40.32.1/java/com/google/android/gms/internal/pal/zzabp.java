package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzabp extends zzabq {
    public zzabp(byte[] bArr) throws GeneralSecurityException {
        super(bArr);
    }

    @Override // com.google.android.gms.internal.pal.zzabq
    final zzabo zza(byte[] bArr, int i) throws InvalidKeyException {
        return new zzabn(bArr, i);
    }
}
