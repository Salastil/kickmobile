package com.google.android.gms.internal.pal;

import java.security.InvalidKeyException;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzabs extends zzabo {
    public zzabs(byte[] bArr, int i) throws InvalidKeyException {
        super(bArr, i);
    }

    @Override // com.google.android.gms.internal.pal.zzabo
    final int[] zza(int[] iArr, int i) {
        int length = iArr.length;
        if (length != 6) {
            throw new IllegalArgumentException(String.format("XChaCha20 uses 192-bit nonces, but got a %d-bit nonce", Integer.valueOf(length * 32)));
        }
        int[] iArr2 = new int[16];
        int[] iArr3 = this.zza;
        int i2 = zzabm.zza;
        int[] iArr4 = new int[16];
        zzabm.zza(iArr4, iArr3);
        iArr4[12] = iArr[0];
        iArr4[13] = iArr[1];
        iArr4[14] = iArr[2];
        iArr4[15] = iArr[3];
        zzabm.zzb(iArr4);
        iArr4[4] = iArr4[12];
        iArr4[5] = iArr4[13];
        iArr4[6] = iArr4[14];
        iArr4[7] = iArr4[15];
        zzabm.zza(iArr2, Arrays.copyOf(iArr4, 8));
        iArr2[12] = i;
        iArr2[13] = 0;
        iArr2[14] = iArr[4];
        iArr2[15] = iArr[5];
        return iArr2;
    }

    @Override // com.google.android.gms.internal.pal.zzabo
    final int zzb() {
        return 24;
    }
}
