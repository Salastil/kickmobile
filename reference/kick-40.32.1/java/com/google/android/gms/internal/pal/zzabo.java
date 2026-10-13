package com.google.android.gms.internal.pal;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
abstract class zzabo {
    int[] zza;
    private final int zzb;

    public zzabo(byte[] bArr, int i) throws InvalidKeyException {
        if (bArr.length != 32) {
            throw new InvalidKeyException("The key length in bytes must be 32.");
        }
        this.zza = zzabm.zzd(bArr);
        this.zzb = i;
    }

    static /* synthetic */ String zze(byte b, zzapm zzapmVar) {
        int iZza = zzapmVar.zza();
        StringBuilder sb = new StringBuilder(String.valueOf(iZza).length() + b);
        sb.append("Unable to parse OutputPrefixType: ");
        sb.append(iZza);
        return sb.toString();
    }

    abstract int[] zza(int[] iArr, int i);

    abstract int zzb();

    public final void zzc(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (byteBuffer.remaining() < bArr2.length) {
            throw new IllegalArgumentException("Given ByteBuffer output is too small");
        }
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr2);
        if (bArr.length != zzb()) {
            int iZzb = zzb();
            StringBuilder sb = new StringBuilder(String.valueOf(iZzb).length() + 36);
            sb.append("The nonce length (in bytes) must be ");
            sb.append(iZzb);
            throw new GeneralSecurityException(sb.toString());
        }
        int iRemaining = byteBufferWrap.remaining();
        int i = iRemaining / 64;
        for (int i2 = 0; i2 < i + 1; i2++) {
            ByteBuffer byteBufferZzd = zzd(bArr, this.zzb + i2);
            if (i2 == i) {
                zzaqj.zzc(byteBuffer, byteBufferWrap, byteBufferZzd, iRemaining % 64);
            } else {
                zzaqj.zzc(byteBuffer, byteBufferWrap, byteBufferZzd, 64);
            }
        }
    }

    final ByteBuffer zzd(byte[] bArr, int i) {
        int[] iArrZza = zza(zzabm.zzd(bArr), i);
        int[] iArr = (int[]) iArrZza.clone();
        zzabm.zzb(iArr);
        for (int i2 = 0; i2 < 16; i2++) {
            iArrZza[i2] = iArrZza[i2] + iArr[i2];
        }
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder.asIntBuffer().put(iArrZza, 0, 16);
        return byteBufferOrder;
    }
}
