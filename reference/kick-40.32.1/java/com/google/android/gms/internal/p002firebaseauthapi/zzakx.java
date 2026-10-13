package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.work.WorkInfo;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.util.Locale;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzakx extends zzaky {
    private final byte[] zzb;
    private final int zzc;
    private int zzd;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
    public final int zza() {
        return this.zzc - this.zzd;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
    public final void zzb() {
    }

    zzakx(byte[] bArr, int i, int i2) {
        this(bArr, 0, i2, null);
    }

    private zzakx(byte[] bArr, int i, int i2, zzala zzalaVar) {
        super();
        if (bArr == null) {
            throw new NullPointerException("buffer");
        }
        if (((bArr.length - i2) | i2) < 0) {
            throw new IllegalArgumentException(String.format(Locale.US, "Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), 0, Integer.valueOf(i2)));
        }
        this.zzb = bArr;
        this.zzd = 0;
        this.zzc = i2;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
    public final void zza(byte b) throws IOException {
        int i = this.zzd;
        try {
            int i2 = i + 1;
            try {
                this.zzb[i] = b;
                this.zzd = i2;
            } catch (IndexOutOfBoundsException e) {
                e = e;
                i = i2;
                throw new zzakz(i, this.zzc, 1, (Throwable) e);
            }
        } catch (IndexOutOfBoundsException e2) {
            e = e2;
        }
    }

    private final void zzc(byte[] bArr, int i, int i2) throws IOException {
        try {
            System.arraycopy(bArr, i, this.zzb, this.zzd, i2);
            this.zzd += i2;
        } catch (IndexOutOfBoundsException e) {
            throw new zzakz(this.zzd, this.zzc, i2, (Throwable) e);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
    public final void zza(int i, boolean z) throws IOException {
        zzc(i, 0);
        zza(z ? (byte) 1 : (byte) 0);
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
        zzc(i, 5);
        zza(i2);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
    public final void zza(int i) throws IOException {
        int i2 = this.zzd;
        try {
            byte[] bArr = this.zzb;
            bArr[i2] = (byte) i;
            bArr[i2 + 1] = (byte) (i >> 8);
            bArr[i2 + 2] = (byte) (i >> 16);
            bArr[i2 + 3] = i >> Ascii.CAN;
            this.zzd = i2 + 4;
        } catch (IndexOutOfBoundsException e) {
            throw new zzakz(i2, this.zzc, 4, (Throwable) e);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
    public final void zza(int i, long j) throws IOException {
        zzc(i, 1);
        zza(j);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
    public final void zza(long j) throws IOException {
        int i = this.zzd;
        try {
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
        } catch (IndexOutOfBoundsException e) {
            throw new zzakz(i, this.zzc, 8, (Throwable) e);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
    public final void zzb(int i, int i2) throws IOException {
        zzc(i, 0);
        zzb(i2);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
    public final void zzb(int i) throws IOException {
        if (i >= 0) {
            zzc(i);
            return;
        }
        long j = i;
        int i2 = this.zzd;
        try {
            byte[] bArr = this.zzb;
            int i3 = i2 + 1;
            try {
                bArr[i2] = (byte) (((int) j) | 128);
                int i4 = i2 + 2;
                try {
                    bArr[i3] = (byte) (((int) (j >>> 7)) | 128);
                    int i5 = i2 + 3;
                    bArr[i4] = (byte) (((int) (j >>> 14)) | 128);
                    i4 = i2 + 4;
                    bArr[i5] = (byte) (((int) (j >>> 21)) | 128);
                    int i6 = i2 + 5;
                    bArr[i4] = (byte) (((int) (j >>> 28)) | 128);
                    int i7 = i2 + 6;
                    try {
                        bArr[i6] = -1;
                        int i8 = i2 + 7;
                        bArr[i7] = -1;
                        i7 = i2 + 8;
                        bArr[i8] = -1;
                        i3 = i2 + 9;
                        bArr[i7] = -1;
                        i2 += 10;
                        bArr[i3] = 1;
                        this.zzd = i2;
                    } catch (IndexOutOfBoundsException e) {
                        int i9 = i7;
                        e = e;
                        i2 = i9;
                        throw new zzakz(i2, this.zzc, 10, (Throwable) e);
                    }
                } catch (IndexOutOfBoundsException e2) {
                    e = e2;
                    i2 = i4;
                }
            } catch (IndexOutOfBoundsException e3) {
                e = e3;
                i2 = i3;
            }
        } catch (IndexOutOfBoundsException e4) {
            e = e4;
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
        int i = this.zzd;
        try {
            int iZzd = zzd(str.length() * 3);
            int iZzd2 = zzd(str.length());
            if (iZzd2 == iZzd) {
                int i2 = i + iZzd2;
                this.zzd = i2;
                byte[] bArr = this.zzb;
                int iZza = zzaog.zza(str, bArr, i2, bArr.length - i2);
                this.zzd = i;
                zzc((iZza - i) - iZzd2);
                this.zzd = iZza;
                return;
            }
            zzc(zzaog.zza(str));
            byte[] bArr2 = this.zzb;
            int i3 = this.zzd;
            this.zzd = zzaog.zza(str, bArr2, i3, bArr2.length - i3);
        } catch (IndexOutOfBoundsException e) {
            throw new zzakz(e);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
    public final void zzc(int i, int i2) throws IOException {
        zzc((i << 3) | i2);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
    public final void zzd(int i, int i2) throws IOException {
        zzc(i, 0);
        zzc(i2);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
    public final void zzc(int i) throws IOException {
        int i2 = this.zzd;
        int i3 = i & WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT;
        byte[] bArr = this.zzb;
        try {
            if (i3 == 0) {
                int i4 = i2 + 1;
                bArr[i2] = (byte) i;
                this.zzd = i4;
                return;
            }
            int i5 = i2 + 1;
            bArr[i2] = (byte) (i | 128);
            int i6 = i >>> 7;
            try {
                if ((i6 & WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT) == 0) {
                    int i7 = i2 + 2;
                    bArr[i5] = (byte) i6;
                    this.zzd = i7;
                    return;
                }
                int i8 = i2 + 2;
                try {
                    bArr[i5] = (byte) (i6 | 128);
                    int i9 = i >>> 14;
                    if ((i9 & WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT) == 0) {
                        int i10 = i2 + 3;
                        bArr[i8] = (byte) i9;
                        this.zzd = i10;
                        return;
                    }
                    int i11 = i2 + 3;
                    try {
                        bArr[i8] = (byte) (i9 | 128);
                        int i12 = i >>> 21;
                        if ((i12 & WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT) == 0) {
                            int i13 = i2 + 4;
                            bArr[i11] = (byte) i12;
                            this.zzd = i13;
                            return;
                        } else {
                            i8 = i2 + 4;
                            bArr[i11] = (byte) (i12 | 128);
                            int i14 = i2 + 5;
                            bArr[i8] = (byte) (i >>> 28);
                            this.zzd = i14;
                            return;
                        }
                    } catch (IndexOutOfBoundsException e) {
                        e = e;
                        i3 = i11;
                    }
                } catch (IndexOutOfBoundsException e2) {
                    e = e2;
                    i3 = i8;
                }
                throw new zzakz(i3, this.zzc, 1, (Throwable) e);
            } catch (IndexOutOfBoundsException e3) {
                i3 = i;
                e = e3;
            }
        } catch (IndexOutOfBoundsException e4) {
            e = e4;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
    public final void zzb(int i, long j) throws IOException {
        zzc(i, 0);
        zzb(j);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
    public final void zzb(long j) throws IOException {
        int i = this.zzd;
        long j2 = j & (-128);
        byte[] bArr = this.zzb;
        try {
            if (j2 == 0) {
                bArr[i] = (byte) j;
                this.zzd = i + 1;
                return;
            }
            bArr[i] = (byte) (((int) j) | 128);
            long j3 = j >>> 7;
            if ((j3 & (-128)) == 0) {
                bArr[i + 1] = (byte) j3;
                this.zzd = i + 2;
                return;
            }
            bArr[i + 1] = (byte) (((int) j3) | 128);
            long j4 = j >>> 14;
            if ((j4 & (-128)) == 0) {
                bArr[i + 2] = (byte) j4;
                this.zzd = i + 3;
                return;
            }
            bArr[i + 2] = (byte) (((int) j4) | 128);
            long j5 = j >>> 21;
            if ((j5 & (-128)) == 0) {
                bArr[i + 3] = (byte) j5;
                this.zzd = i + 4;
                return;
            }
            bArr[i + 3] = (byte) (((int) j5) | 128);
            long j6 = j >>> 28;
            if ((j6 & (-128)) == 0) {
                bArr[i + 4] = (byte) j6;
                this.zzd = i + 5;
                return;
            }
            bArr[i + 4] = (byte) (((int) j6) | 128);
            long j7 = j >>> 35;
            if ((j7 & (-128)) == 0) {
                bArr[i + 5] = (byte) j7;
                this.zzd = i + 6;
                return;
            }
            bArr[i + 5] = (byte) (((int) j7) | 128);
            long j8 = j >>> 42;
            if ((j8 & (-128)) == 0) {
                bArr[i + 6] = (byte) j8;
                this.zzd = i + 7;
                return;
            }
            bArr[i + 6] = (byte) (((int) j8) | 128);
            long j9 = j >>> 49;
            if ((j9 & (-128)) == 0) {
                bArr[i + 7] = (byte) j9;
                this.zzd = i + 8;
                return;
            }
            bArr[i + 7] = (byte) (((int) j9) | 128);
            long j10 = j >>> 56;
            if (((-128) & j10) == 0) {
                bArr[i + 8] = (byte) j10;
                this.zzd = i + 9;
            } else {
                bArr[i + 8] = (byte) (((int) j10) | 128);
                bArr[i + 9] = (byte) (j >>> 63);
                this.zzd = i + 10;
            }
        } catch (IndexOutOfBoundsException e) {
            throw new zzakz(i, this.zzc, 1, (Throwable) e);
        }
    }
}
