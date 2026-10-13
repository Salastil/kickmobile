package com.google.android.gms.internal.p002firebaseauthapi;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzbj extends zzbe {
    private long zza;
    private long zzb;
    private int zzc;

    private static long zza(long j) {
        long j2 = (j ^ (j >>> 33)) * (-49064778989728563L);
        long j3 = (j2 ^ (j2 >>> 33)) * (-4265267296055464877L);
        return j3 ^ (j3 >>> 33);
    }

    private static long zzb(long j) {
        return Long.rotateLeft(j * (-8663945395140668459L), 31) * 5545529020109919103L;
    }

    private static long zzc(long j) {
        return Long.rotateLeft(j * 5545529020109919103L, 33) * (-8663945395140668459L);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbe
    protected final zzbd zzb() {
        long j = this.zza;
        int i = this.zzc;
        long j2 = j ^ ((long) i);
        long j3 = this.zzb ^ ((long) i);
        long j4 = j2 + j3;
        this.zza = j4;
        this.zzb = j3 + j4;
        this.zza = zza(j4);
        long jZza = zza(this.zzb);
        long j5 = this.zza + jZza;
        this.zza = j5;
        this.zzb = jZza + j5;
        return zzbd.zza(ByteBuffer.wrap(new byte[16]).order(ByteOrder.LITTLE_ENDIAN).putLong(this.zza).putLong(this.zzb).array());
    }

    zzbj(int i) {
        super(16);
        long j = i;
        this.zza = j;
        this.zzb = j;
        this.zzc = 0;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbe
    protected final void zza(ByteBuffer byteBuffer) {
        long j = byteBuffer.getLong();
        long j2 = byteBuffer.getLong();
        long jZzb = zzb(j) ^ this.zza;
        this.zza = jZzb;
        long jRotateLeft = Long.rotateLeft(jZzb, 27);
        long j3 = this.zzb;
        this.zza = ((jRotateLeft + j3) * 5) + 1390208809;
        long jZzc = zzc(j2) ^ j3;
        this.zzb = jZzc;
        this.zzb = ((Long.rotateLeft(jZzc, 31) + this.zza) * 5) + 944331445;
        this.zzc += 16;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbe
    protected final void zzb(ByteBuffer byteBuffer) {
        long j;
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        long j7;
        this.zzc += byteBuffer.remaining();
        long j8 = 0;
        switch (byteBuffer.remaining()) {
            case 1:
                j = 0;
                j7 = j ^ ((long) (byteBuffer.get(0) & 255));
                this.zza = zzb(j7) ^ this.zza;
                this.zzb ^= zzc(j8);
                return;
            case 2:
                j2 = 0;
                j = j2 ^ (((long) (byteBuffer.get(1) & 255)) << 8);
                j7 = j ^ ((long) (byteBuffer.get(0) & 255));
                this.zza = zzb(j7) ^ this.zza;
                this.zzb ^= zzc(j8);
                return;
            case 3:
                j3 = 0;
                j2 = j3 ^ (((long) (byteBuffer.get(2) & 255)) << 16);
                j = j2 ^ (((long) (byteBuffer.get(1) & 255)) << 8);
                j7 = j ^ ((long) (byteBuffer.get(0) & 255));
                this.zza = zzb(j7) ^ this.zza;
                this.zzb ^= zzc(j8);
                return;
            case 4:
                j4 = 0;
                j3 = j4 ^ (((long) (byteBuffer.get(3) & 255)) << 24);
                j2 = j3 ^ (((long) (byteBuffer.get(2) & 255)) << 16);
                j = j2 ^ (((long) (byteBuffer.get(1) & 255)) << 8);
                j7 = j ^ ((long) (byteBuffer.get(0) & 255));
                this.zza = zzb(j7) ^ this.zza;
                this.zzb ^= zzc(j8);
                return;
            case 5:
                j5 = 0;
                j4 = j5 ^ (((long) (byteBuffer.get(4) & 255)) << 32);
                j3 = j4 ^ (((long) (byteBuffer.get(3) & 255)) << 24);
                j2 = j3 ^ (((long) (byteBuffer.get(2) & 255)) << 16);
                j = j2 ^ (((long) (byteBuffer.get(1) & 255)) << 8);
                j7 = j ^ ((long) (byteBuffer.get(0) & 255));
                this.zza = zzb(j7) ^ this.zza;
                this.zzb ^= zzc(j8);
                return;
            case 6:
                j6 = 0;
                j5 = j6 ^ (((long) (byteBuffer.get(5) & 255)) << 40);
                j4 = j5 ^ (((long) (byteBuffer.get(4) & 255)) << 32);
                j3 = j4 ^ (((long) (byteBuffer.get(3) & 255)) << 24);
                j2 = j3 ^ (((long) (byteBuffer.get(2) & 255)) << 16);
                j = j2 ^ (((long) (byteBuffer.get(1) & 255)) << 8);
                j7 = j ^ ((long) (byteBuffer.get(0) & 255));
                this.zza = zzb(j7) ^ this.zza;
                this.zzb ^= zzc(j8);
                return;
            case 7:
                j6 = ((long) (byteBuffer.get(6) & 255)) << 48;
                j5 = j6 ^ (((long) (byteBuffer.get(5) & 255)) << 40);
                j4 = j5 ^ (((long) (byteBuffer.get(4) & 255)) << 32);
                j3 = j4 ^ (((long) (byteBuffer.get(3) & 255)) << 24);
                j2 = j3 ^ (((long) (byteBuffer.get(2) & 255)) << 16);
                j = j2 ^ (((long) (byteBuffer.get(1) & 255)) << 8);
                j7 = j ^ ((long) (byteBuffer.get(0) & 255));
                this.zza = zzb(j7) ^ this.zza;
                this.zzb ^= zzc(j8);
                return;
            case 8:
                j7 = byteBuffer.getLong();
                this.zza = zzb(j7) ^ this.zza;
                this.zzb ^= zzc(j8);
                return;
            case 9:
                j8 ^= (long) (byteBuffer.get(8) & 255);
                j7 = byteBuffer.getLong();
                this.zza = zzb(j7) ^ this.zza;
                this.zzb ^= zzc(j8);
                return;
            case 10:
                j8 ^= ((long) (byteBuffer.get(9) & 255)) << 8;
                j8 ^= (long) (byteBuffer.get(8) & 255);
                j7 = byteBuffer.getLong();
                this.zza = zzb(j7) ^ this.zza;
                this.zzb ^= zzc(j8);
                return;
            case 11:
                j8 ^= ((long) (byteBuffer.get(10) & 255)) << 16;
                j8 ^= ((long) (byteBuffer.get(9) & 255)) << 8;
                j8 ^= (long) (byteBuffer.get(8) & 255);
                j7 = byteBuffer.getLong();
                this.zza = zzb(j7) ^ this.zza;
                this.zzb ^= zzc(j8);
                return;
            case 12:
                j8 ^= ((long) (byteBuffer.get(11) & 255)) << 24;
                j8 ^= ((long) (byteBuffer.get(10) & 255)) << 16;
                j8 ^= ((long) (byteBuffer.get(9) & 255)) << 8;
                j8 ^= (long) (byteBuffer.get(8) & 255);
                j7 = byteBuffer.getLong();
                this.zza = zzb(j7) ^ this.zza;
                this.zzb ^= zzc(j8);
                return;
            case 13:
                j8 ^= ((long) (byteBuffer.get(12) & 255)) << 32;
                j8 ^= ((long) (byteBuffer.get(11) & 255)) << 24;
                j8 ^= ((long) (byteBuffer.get(10) & 255)) << 16;
                j8 ^= ((long) (byteBuffer.get(9) & 255)) << 8;
                j8 ^= (long) (byteBuffer.get(8) & 255);
                j7 = byteBuffer.getLong();
                this.zza = zzb(j7) ^ this.zza;
                this.zzb ^= zzc(j8);
                return;
            case 14:
                j8 ^= ((long) (byteBuffer.get(13) & 255)) << 40;
                j8 ^= ((long) (byteBuffer.get(12) & 255)) << 32;
                j8 ^= ((long) (byteBuffer.get(11) & 255)) << 24;
                j8 ^= ((long) (byteBuffer.get(10) & 255)) << 16;
                j8 ^= ((long) (byteBuffer.get(9) & 255)) << 8;
                j8 ^= (long) (byteBuffer.get(8) & 255);
                j7 = byteBuffer.getLong();
                this.zza = zzb(j7) ^ this.zza;
                this.zzb ^= zzc(j8);
                return;
            case 15:
                j8 = ((long) (byteBuffer.get(14) & 255)) << 48;
                j8 ^= ((long) (byteBuffer.get(13) & 255)) << 40;
                j8 ^= ((long) (byteBuffer.get(12) & 255)) << 32;
                j8 ^= ((long) (byteBuffer.get(11) & 255)) << 24;
                j8 ^= ((long) (byteBuffer.get(10) & 255)) << 16;
                j8 ^= ((long) (byteBuffer.get(9) & 255)) << 8;
                j8 ^= (long) (byteBuffer.get(8) & 255);
                j7 = byteBuffer.getLong();
                this.zza = zzb(j7) ^ this.zza;
                this.zzb ^= zzc(j8);
                return;
            default:
                throw new AssertionError("Should never get here.");
        }
    }
}
