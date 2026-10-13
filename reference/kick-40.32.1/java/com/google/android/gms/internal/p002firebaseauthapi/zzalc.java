package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.work.WorkInfo;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzalc extends zzaky {
    private final byte[] zzb;
    private final int zzc;
    private int zzd;
    private int zze;
    private final OutputStream zzf;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
    public final int zza() {
        throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
    }

    zzalc(OutputStream outputStream, int i) {
        super();
        if (outputStream == null) {
            throw new NullPointerException("out");
        }
        this.zzf = outputStream;
        if (i < 0) {
            throw new IllegalArgumentException("bufferSize must be >= 0");
        }
        byte[] bArr = new byte[Math.max(i, 20)];
        this.zzb = bArr;
        this.zzc = bArr.length;
    }

    private final void zzb(byte b) {
        int i = this.zzd;
        this.zzb[i] = b;
        this.zzd = i + 1;
        this.zze++;
    }

    private final void zzg(int i) {
        int i2 = this.zzd;
        byte[] bArr = this.zzb;
        bArr[i2] = (byte) i;
        bArr[i2 + 1] = (byte) (i >> 8);
        bArr[i2 + 2] = (byte) (i >> 16);
        bArr[i2 + 3] = i >> Ascii.CAN;
        this.zzd = i2 + 4;
        this.zze += 4;
    }

    private final void zzf(long j) {
        int i = this.zzd;
        byte[] bArr = this.zzb;
        bArr[i] = (byte) j;
        bArr[i + 1] = (byte) (j >> 8);
        bArr[i + 2] = (byte) (j >> 16);
        bArr[i + 3] = (byte) (j >> 24);
        bArr[i + 4] = (byte) (j >> 32);
        bArr[i + 5] = (byte) (j >> 40);
        bArr[i + 6] = (byte) (j >> 48);
        bArr[i + 7] = (byte) (j >> 56);
        this.zzd = i + 8;
        this.zze += 8;
    }

    private final void zzj(int i, int i2) {
        zzh((i << 3) | i2);
    }

    private final void zzh(int i) {
        int i2 = this.zzd;
        int i3 = this.zze;
        int i4 = i & WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT;
        byte[] bArr = this.zzb;
        if (i4 == 0) {
            bArr[i2] = (byte) i;
            this.zzd = i2 + 1;
            this.zze = i3 + 1;
            return;
        }
        bArr[i2] = (byte) (i | 128);
        int i5 = i >>> 7;
        if ((i5 & WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT) == 0) {
            bArr[i2 + 1] = (byte) i5;
            this.zzd = i2 + 2;
            this.zze = i3 + 2;
            return;
        }
        bArr[i2 + 1] = (byte) (i5 | 128);
        int i6 = i >>> 14;
        if ((i6 & WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT) == 0) {
            bArr[i2 + 2] = (byte) i6;
            this.zzd = i2 + 3;
            this.zze = i3 + 3;
            return;
        }
        bArr[i2 + 2] = (byte) (i6 | 128);
        int i7 = i >>> 21;
        if ((i7 & WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT) == 0) {
            bArr[i2 + 3] = (byte) i7;
            this.zzd = i2 + 4;
            this.zze = i3 + 4;
        } else {
            bArr[i2 + 3] = (byte) (i7 | 128);
            bArr[i2 + 4] = (byte) (i >>> 28);
            this.zzd = i2 + 5;
            this.zze = i3 + 5;
        }
    }

    private final void zzg(long j) {
        int i = this.zzd;
        int i2 = this.zze;
        long j2 = j & (-128);
        byte[] bArr = this.zzb;
        if (j2 == 0) {
            bArr[i] = (byte) j;
            this.zzd = i + 1;
            this.zze = i2 + 1;
            return;
        }
        bArr[i] = (byte) (((int) j) | 128);
        long j3 = j >>> 7;
        if ((j3 & (-128)) == 0) {
            bArr[i + 1] = (byte) j3;
            this.zzd = i + 2;
            this.zze = i2 + 2;
            return;
        }
        bArr[i + 1] = (byte) (((int) j3) | 128);
        long j4 = j >>> 14;
        if ((j4 & (-128)) == 0) {
            bArr[i + 2] = (byte) j4;
            this.zzd = i + 3;
            this.zze = i2 + 3;
            return;
        }
        bArr[i + 2] = (byte) (((int) j4) | 128);
        long j5 = j >>> 21;
        if ((j5 & (-128)) == 0) {
            bArr[i + 3] = (byte) j5;
            this.zzd = i + 4;
            this.zze = i2 + 4;
            return;
        }
        bArr[i + 3] = (byte) (((int) j5) | 128);
        long j6 = j >>> 28;
        if ((j6 & (-128)) == 0) {
            bArr[i + 4] = (byte) j6;
            this.zzd = i + 5;
            this.zze = i2 + 5;
            return;
        }
        bArr[i + 4] = (byte) (((int) j6) | 128);
        long j7 = j >>> 35;
        if ((j7 & (-128)) == 0) {
            bArr[i + 5] = (byte) j7;
            this.zzd = i + 6;
            this.zze = i2 + 6;
            return;
        }
        bArr[i + 5] = (byte) (((int) j7) | 128);
        long j8 = j >>> 42;
        if ((j8 & (-128)) == 0) {
            bArr[i + 6] = (byte) j8;
            this.zzd = i + 7;
            this.zze = i2 + 7;
            return;
        }
        bArr[i + 6] = (byte) (((int) j8) | 128);
        long j9 = j >>> 49;
        if ((j9 & (-128)) == 0) {
            bArr[i + 7] = (byte) j9;
            this.zzd = i + 8;
            this.zze = i2 + 8;
            return;
        }
        bArr[i + 7] = (byte) (((int) j9) | 128);
        long j10 = j >>> 56;
        if (((-128) & j10) == 0) {
            bArr[i + 8] = (byte) j10;
            this.zzd = i + 9;
            this.zze = i2 + 9;
        } else {
            bArr[i + 8] = (byte) (((int) j10) | 128);
            bArr[i + 9] = (byte) (j >>> 63);
            this.zzd = i + 10;
            this.zze = i2 + 10;
        }
    }

    private final void zzd() throws IOException {
        this.zzf.write(this.zzb, 0, this.zzd);
        this.zzd = 0;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
    public final void zzb() throws IOException {
        if (this.zzd > 0) {
            zzd();
        }
    }

    private final void zzi(int i) throws IOException {
        if (this.zzc - this.zzd < i) {
            zzd();
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
    public final void zza(byte b) throws IOException {
        if (this.zzd == this.zzc) {
            zzd();
        }
        zzb(b);
    }

    private final void zzc(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.zzc;
        int i4 = this.zzd;
        int i5 = i3 - i4;
        byte[] bArr2 = this.zzb;
        if (i5 >= i2) {
            System.arraycopy(bArr, i, bArr2, i4, i2);
            this.zzd += i2;
        } else {
            int i6 = i3 - i4;
            System.arraycopy(bArr, i, bArr2, i4, i6);
            int i7 = i + i6;
            i2 -= i6;
            this.zzd = this.zzc;
            this.zze += i6;
            zzd();
            if (i2 <= this.zzc) {
                System.arraycopy(bArr, i7, this.zzb, 0, i2);
                this.zzd = i2;
            } else {
                this.zzf.write(bArr, i7, i2);
            }
        }
        this.zze += i2;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
    public final void zza(int i, boolean z) throws IOException {
        zzi(11);
        zzj(i, 0);
        zzb(z ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
    public final void zzb(byte[] bArr, int i, int i2) throws IOException {
        zzc(i2);
        zzc(bArr, 0, i2);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
    public final void zza(int i, zzakb zzakbVar) throws IOException {
        zzc(i, 2);
        zza(zzakbVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
    public final void zza(zzakb zzakbVar) throws IOException {
        zzc(zzakbVar.zza());
        zzakbVar.zza(this);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
    public final void zza(int i, int i2) throws IOException {
        zzi(14);
        zzj(i, 5);
        zzg(i2);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
    public final void zza(int i) throws IOException {
        zzi(4);
        zzg(i);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
    public final void zza(int i, long j) throws IOException {
        zzi(18);
        zzj(i, 1);
        zzf(j);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
    public final void zza(long j) throws IOException {
        zzi(8);
        zzf(j);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
    public final void zzb(int i, int i2) throws IOException {
        zzi(20);
        zzj(i, 0);
        if (i2 >= 0) {
            zzh(i2);
        } else {
            zzg(i2);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
    public final void zzb(int i) throws IOException {
        if (i >= 0) {
            zzc(i);
        } else {
            zzb(i);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakc
    public final void zza(byte[] bArr, int i, int i2) throws IOException {
        zzc(bArr, i, i2);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
    public final void zza(zzamv zzamvVar) throws IOException {
        zzc(zzamvVar.zzl());
        zzamvVar.zza(this);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
    public final void zza(int i, zzamv zzamvVar) throws IOException {
        zzc(1, 3);
        zzd(2, i);
        zzc(3, 2);
        zza(zzamvVar);
        zzc(1, 4);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
    public final void zzb(int i, zzakb zzakbVar) throws IOException {
        zzc(1, 3);
        zzd(2, i);
        zza(3, zzakbVar);
        zzc(1, 4);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
    public final void zza(int i, String str) throws IOException {
        zzc(i, 2);
        zza(str);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
    public final void zza(String str) throws IOException {
        int iZza;
        int length = str.length() * 3;
        int iZzd = zzd(length);
        int i = iZzd + length;
        int i2 = this.zzc;
        if (i > i2) {
            byte[] bArr = new byte[length];
            int iZza2 = zzaog.zza(str, bArr, 0, length);
            zzc(iZza2);
            zza(bArr, 0, iZza2);
            return;
        }
        if (i > i2 - this.zzd) {
            zzd();
        }
        int iZzd2 = zzd(str.length());
        int i3 = this.zzd;
        try {
            if (iZzd2 == iZzd) {
                int i4 = i3 + iZzd2;
                this.zzd = i4;
                int iZza3 = zzaog.zza(str, this.zzb, i4, this.zzc - i4);
                this.zzd = i3;
                iZza = (iZza3 - i3) - iZzd2;
                zzh(iZza);
                this.zzd = iZza3;
            } else {
                iZza = zzaog.zza(str);
                zzh(iZza);
                this.zzd = zzaog.zza(str, this.zzb, this.zzd, iZza);
            }
            this.zze += iZza;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new zzakz(e);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
    public final void zzc(int i, int i2) throws IOException {
        zzc((i << 3) | i2);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
    public final void zzd(int i, int i2) throws IOException {
        zzi(20);
        zzj(i, 0);
        zzh(i2);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
    public final void zzc(int i) throws IOException {
        zzi(5);
        zzh(i);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
    public final void zzb(int i, long j) throws IOException {
        zzi(20);
        zzj(i, 0);
        zzg(j);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
    public final void zzb(long j) throws IOException {
        zzi(10);
        zzg(j);
    }
}
