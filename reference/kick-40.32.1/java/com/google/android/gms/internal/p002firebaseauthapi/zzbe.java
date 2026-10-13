package com.google.android.gms.internal.p002firebaseauthapi;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
abstract class zzbe extends zzbb {
    private final ByteBuffer zza;
    private final int zzb;
    private final int zzc;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbi
    public final zzbd zza() {
        zzc();
        this.zza.flip();
        if (this.zza.remaining() > 0) {
            zzb(this.zza);
            ByteBuffer byteBuffer = this.zza;
            byteBuffer.position(byteBuffer.limit());
        }
        return zzb();
    }

    protected abstract void zza(ByteBuffer byteBuffer);

    protected abstract zzbd zzb();

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbi
    public final zzbi zza(byte b) {
        this.zza.put(b);
        zzd();
        return this;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbb
    public final zzbi zza(byte[] bArr, int i, int i2) {
        ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr, 0, i2).order(ByteOrder.LITTLE_ENDIAN);
        if (byteBufferOrder.remaining() <= this.zza.remaining()) {
            this.zza.put(byteBufferOrder);
            zzd();
            return this;
        }
        int iPosition = this.zzb - this.zza.position();
        for (int i3 = 0; i3 < iPosition; i3++) {
            this.zza.put(byteBufferOrder.get());
        }
        zzc();
        while (byteBufferOrder.remaining() >= this.zzc) {
            zza(byteBufferOrder);
        }
        this.zza.put(byteBufferOrder);
        return this;
    }

    protected zzbe(int i) {
        this(16, 16);
    }

    private zzbe(int i, int i2) {
        this.zza = ByteBuffer.allocate(23).order(ByteOrder.LITTLE_ENDIAN);
        this.zzb = 16;
        this.zzc = 16;
    }

    private final void zzc() {
        this.zza.flip();
        while (true) {
            int iRemaining = this.zza.remaining();
            int i = this.zzc;
            ByteBuffer byteBuffer = this.zza;
            if (iRemaining >= i) {
                zza(byteBuffer);
            } else {
                byteBuffer.compact();
                return;
            }
        }
    }

    private final void zzd() {
        if (this.zza.remaining() < 8) {
            zzc();
        }
    }

    protected void zzb(ByteBuffer byteBuffer) {
        byteBuffer.position(byteBuffer.limit());
        byteBuffer.limit(this.zzc + 7);
        while (true) {
            int iPosition = byteBuffer.position();
            int i = this.zzc;
            if (iPosition < i) {
                byteBuffer.putLong(0L);
            } else {
                byteBuffer.limit(i);
                byteBuffer.flip();
                zza(byteBuffer);
                return;
            }
        }
    }
}
