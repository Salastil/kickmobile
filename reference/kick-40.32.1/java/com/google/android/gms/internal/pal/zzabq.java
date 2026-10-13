package com.google.android.gms.internal.pal;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
abstract class zzabq {
    private final zzabo zza;
    private final zzabo zzb;

    public zzabq(byte[] bArr) throws GeneralSecurityException {
        if (!zzaco.zza(1)) {
            throw new GeneralSecurityException("Can not use ChaCha20Poly1305 in FIPS-mode.");
        }
        this.zza = zza(bArr, 1);
        this.zzb = zza(bArr, 0);
    }

    abstract zzabo zza(byte[] bArr, int i) throws InvalidKeyException;

    public final byte[] zzb(byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        int length = bArr2.length;
        if (length > 2147483631) {
            throw new GeneralSecurityException("plaintext too long");
        }
        int i = length + 16;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i);
        if (byteBufferAllocate.remaining() < i) {
            throw new IllegalArgumentException("Given ByteBuffer output is too small");
        }
        int iPosition = byteBufferAllocate.position();
        this.zza.zzc(byteBufferAllocate, bArr, bArr2);
        byteBufferAllocate.position(iPosition);
        byteBufferAllocate.limit(byteBufferAllocate.limit() - 16);
        ByteBuffer byteBufferZzd = this.zzb.zzd(bArr, 0);
        byte[] bArr4 = new byte[32];
        byteBufferZzd.get(bArr4);
        int iRemaining = byteBufferAllocate.remaining();
        int i2 = iRemaining % 16;
        int i3 = i2 == 0 ? iRemaining : (iRemaining + 16) - i2;
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(i3 + 16).order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder.put(bArr3);
        byteBufferOrder.position(0);
        byteBufferOrder.put(byteBufferAllocate);
        byteBufferOrder.position(i3);
        byteBufferOrder.putLong(0L);
        byteBufferOrder.putLong(iRemaining);
        byte[] bArrZza = zzabv.zza(bArr4, byteBufferOrder.array());
        byteBufferAllocate.limit(byteBufferAllocate.limit() + 16);
        byteBufferAllocate.put(bArrZza);
        return byteBufferAllocate.array();
    }
}
