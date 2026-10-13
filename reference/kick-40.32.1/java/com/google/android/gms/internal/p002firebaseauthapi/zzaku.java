package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.work.WorkInfo;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzaku extends zzakn {
    private final InputStream zze;
    private final byte[] zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl;

    private static boolean zza(int i, int i2, int i3) {
        return i3 < i || i2 > i3 - i;
    }

    private final byte zzy() throws IOException {
        if (this.zzi == this.zzg) {
            zzg(1);
        }
        byte[] bArr = this.zzf;
        int i = this.zzi;
        this.zzi = i + 1;
        return bArr[i];
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
    public final double zza() throws IOException {
        return Double.longBitsToDouble(zzab());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
    public final float zzb() throws IOException {
        return Float.intBitsToFloat(zzz());
    }

    private static int zza(InputStream inputStream) throws IOException {
        try {
            return inputStream.available();
        } catch (zzamd e) {
            e.zzk();
            throw e;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
    public final int zzc() {
        return this.zzk + this.zzi;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
    public final int zzb(int i) throws zzamd {
        if (i < 0) {
            throw zzamd.zzf();
        }
        int i2 = this.zzk + this.zzi;
        if (i > Integer.MAX_VALUE - i2) {
            throw zzamd.zzi();
        }
        if (zza(i2, i, this.zzl)) {
            throw zzamd.zzj();
        }
        int i3 = this.zzl;
        this.zzl = i2 + i;
        zzad();
        return i3;
    }

    private static int zza(InputStream inputStream, byte[] bArr, int i, int i2) throws IOException {
        try {
            return inputStream.read(bArr, i, i2);
        } catch (zzamd e) {
            e.zzk();
            throw e;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
    public final int zzd() throws IOException {
        return zzaa();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
    public final int zze() throws IOException {
        return zzz();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
    public final int zzf() throws IOException {
        return zzaa();
    }

    private final int zzz() throws IOException {
        int i = this.zzi;
        if (this.zzg - i < 4) {
            zzg(4);
            i = this.zzi;
        }
        byte[] bArr = this.zzf;
        this.zzi = i + 4;
        return (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24);
    }

    private final int zzaa() throws IOException {
        int i;
        int i2 = this.zzi;
        int i3 = this.zzg;
        if (i3 != i2) {
            byte[] bArr = this.zzf;
            int i4 = i2 + 1;
            byte b = bArr[i2];
            if (b >= 0) {
                this.zzi = i4;
                return b;
            }
            if (i3 - i4 >= 9) {
                int i5 = i2 + 2;
                int i6 = (bArr[i4] << 7) ^ b;
                if (i6 < 0) {
                    i = i6 ^ WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT;
                } else {
                    int i7 = i2 + 3;
                    int i8 = (bArr[i5] << Ascii.SO) ^ i6;
                    if (i8 >= 0) {
                        i = i8 ^ 16256;
                    } else {
                        int i9 = i2 + 4;
                        int i10 = i8 ^ (bArr[i7] << Ascii.NAK);
                        if (i10 < 0) {
                            i = (-2080896) ^ i10;
                        } else {
                            i7 = i2 + 5;
                            byte b2 = bArr[i9];
                            int i11 = (i10 ^ (b2 << Ascii.FS)) ^ 266354560;
                            if (b2 < 0) {
                                i9 = i2 + 6;
                                if (bArr[i7] < 0) {
                                    i7 = i2 + 7;
                                    if (bArr[i9] < 0) {
                                        i9 = i2 + 8;
                                        if (bArr[i7] < 0) {
                                            i7 = i2 + 9;
                                            if (bArr[i9] < 0) {
                                                int i12 = i2 + 10;
                                                if (bArr[i7] >= 0) {
                                                    i5 = i12;
                                                    i = i11;
                                                }
                                            }
                                        }
                                    }
                                }
                                i = i11;
                            }
                            i = i11;
                        }
                        i5 = i9;
                    }
                    i5 = i7;
                }
                this.zzi = i5;
                return i;
            }
        }
        return (int) zzm();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
    public final int zzg() throws IOException {
        return zzz();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
    public final int zzh() throws IOException {
        return zza(zzaa());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
    public final int zzi() throws IOException {
        if (zzw()) {
            this.zzj = 0;
            return 0;
        }
        int iZzaa = zzaa();
        this.zzj = iZzaa;
        if ((iZzaa >>> 3) != 0) {
            return iZzaa;
        }
        throw zzamd.zzc();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
    public final int zzj() throws IOException {
        return zzaa();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
    public final long zzk() throws IOException {
        return zzab();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
    public final long zzl() throws IOException {
        return zzac();
    }

    private final long zzab() throws IOException {
        int i = this.zzi;
        if (this.zzg - i < 8) {
            zzg(8);
            i = this.zzi;
        }
        byte[] bArr = this.zzf;
        this.zzi = i + 8;
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    private final long zzac() throws IOException {
        long j;
        long j2;
        long j3;
        int i = this.zzi;
        int i2 = this.zzg;
        if (i2 != i) {
            byte[] bArr = this.zzf;
            int i3 = i + 1;
            byte b = bArr[i];
            if (b >= 0) {
                this.zzi = i3;
                return b;
            }
            if (i2 - i3 >= 9) {
                int i4 = i + 2;
                int i5 = (bArr[i3] << 7) ^ b;
                if (i5 < 0) {
                    j = i5 ^ WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT;
                } else {
                    int i6 = i + 3;
                    int i7 = (bArr[i4] << Ascii.SO) ^ i5;
                    if (i7 >= 0) {
                        j = i7 ^ 16256;
                        i4 = i6;
                    } else {
                        int i8 = i + 4;
                        int i9 = i7 ^ (bArr[i6] << Ascii.NAK);
                        if (i9 < 0) {
                            long j4 = (-2080896) ^ i9;
                            i4 = i8;
                            j = j4;
                        } else {
                            long j5 = i9;
                            i4 = i + 5;
                            long j6 = j5 ^ (((long) bArr[i8]) << 28);
                            if (j6 >= 0) {
                                j2 = 266354560;
                            } else {
                                int i10 = i + 6;
                                long j7 = j6 ^ (((long) bArr[i4]) << 35);
                                if (j7 < 0) {
                                    j3 = -34093383808L;
                                } else {
                                    i4 = i + 7;
                                    j6 = j7 ^ (((long) bArr[i10]) << 42);
                                    if (j6 >= 0) {
                                        j2 = 4363953127296L;
                                    } else {
                                        i10 = i + 8;
                                        j7 = j6 ^ (((long) bArr[i4]) << 49);
                                        if (j7 < 0) {
                                            j3 = -558586000294016L;
                                        } else {
                                            i4 = i + 9;
                                            j6 = j7 ^ (((long) bArr[i10]) << 56);
                                            if (j6 >= 0) {
                                                j2 = 71499008037633920L;
                                            } else {
                                                int i11 = i + 10;
                                                long j8 = (((long) bArr[i4]) << 63) ^ j6;
                                                if (j8 >= 0) {
                                                    j = j8 ^ (-9151873028817141888L);
                                                    i4 = i11;
                                                }
                                            }
                                        }
                                    }
                                }
                                j = j7 ^ j3;
                                i4 = i10;
                            }
                            j = j6 ^ j2;
                        }
                    }
                }
                this.zzi = i4;
                return j;
            }
        }
        return zzm();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
    final long zzm() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte bZzy = zzy();
            j |= ((long) (bZzy & 127)) << i;
            if ((bZzy & 128) == 0) {
                return j;
            }
        }
        throw zzamd.zze();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
    public final long zzn() throws IOException {
        return zzab();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
    public final long zzo() throws IOException {
        return zza(zzac());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
    public final long zzp() throws IOException {
        return zzac();
    }

    private static long zza(InputStream inputStream, long j) throws IOException {
        try {
            return inputStream.skip(j);
        } catch (zzamd e) {
            e.zzk();
            throw e;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
    public final zzakb zzq() throws IOException {
        int iZzaa = zzaa();
        int i = this.zzg;
        int i2 = this.zzi;
        if (iZzaa <= i - i2 && iZzaa > 0) {
            zzakb zzakbVarZza = zzakb.zza(this.zzf, i2, iZzaa, false);
            this.zzi += iZzaa;
            return zzakbVarZza;
        }
        if (iZzaa == 0) {
            return zzakb.zza;
        }
        if (iZzaa < 0) {
            throw zzamd.zzf();
        }
        byte[] bArrZzj = zzj(iZzaa);
        if (bArrZzj != null) {
            return zzakb.zza(bArrZzj, 0, bArrZzj.length, false);
        }
        int i3 = this.zzi;
        int i4 = this.zzg;
        int length = i4 - i3;
        this.zzk += i4;
        this.zzi = 0;
        this.zzg = 0;
        List<byte[]> listZzf = zzf(iZzaa - length);
        byte[] bArr = new byte[iZzaa];
        System.arraycopy(this.zzf, i3, bArr, 0, length);
        for (byte[] bArr2 : listZzf) {
            System.arraycopy(bArr2, 0, bArr, length, bArr2.length);
            length += bArr2.length;
        }
        return zzakb.zzb(bArr);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
    public final String zzr() throws IOException {
        int iZzaa = zzaa();
        if (iZzaa > 0 && iZzaa <= this.zzg - this.zzi) {
            String str = new String(this.zzf, this.zzi, iZzaa, StandardCharsets.UTF_8);
            this.zzi += iZzaa;
            return str;
        }
        if (iZzaa == 0) {
            return "";
        }
        if (iZzaa < 0) {
            throw zzamd.zzf();
        }
        if (iZzaa <= this.zzg) {
            zzg(iZzaa);
            String str2 = new String(this.zzf, this.zzi, iZzaa, StandardCharsets.UTF_8);
            this.zzi += iZzaa;
            return str2;
        }
        return new String(zza(iZzaa, false), StandardCharsets.UTF_8);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
    public final String zzs() throws IOException {
        byte[] bArrZza;
        int iZzaa = zzaa();
        int i = this.zzi;
        int i2 = this.zzg;
        if (iZzaa <= i2 - i && iZzaa > 0) {
            bArrZza = this.zzf;
            this.zzi = i + iZzaa;
        } else {
            if (iZzaa == 0) {
                return "";
            }
            if (iZzaa < 0) {
                throw zzamd.zzf();
            }
            i = 0;
            if (iZzaa <= i2) {
                zzg(iZzaa);
                bArrZza = this.zzf;
                this.zzi = iZzaa;
            } else {
                bArrZza = zza(iZzaa, false);
            }
        }
        return zzaog.zza(bArrZza, i, iZzaa);
    }

    private final List<byte[]> zzf(int i) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (i > 0) {
            int iMin = Math.min(i, 4096);
            byte[] bArr = new byte[iMin];
            int i2 = 0;
            while (i2 < iMin) {
                int iZza = zza(this.zze, bArr, i2, iMin - i2);
                if (iZza == -1) {
                    throw zzamd.zzj();
                }
                this.zzk += iZza;
                i2 += iZza;
            }
            i -= iMin;
            arrayList.add(bArr);
        }
        return arrayList;
    }

    private zzaku(InputStream inputStream, int i) {
        super();
        this.zzl = Integer.MAX_VALUE;
        zzalw.zza(inputStream, "input");
        this.zze = inputStream;
        this.zzf = new byte[4096];
        this.zzg = 0;
        this.zzi = 0;
        this.zzk = 0;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
    public final void zzc(int i) throws zzamd {
        if (this.zzj != i) {
            throw zzamd.zzb();
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
    public final void zzd(int i) {
        this.zzl = i;
        zzad();
    }

    private final void zzad() {
        int i = this.zzg + this.zzh;
        this.zzg = i;
        int i2 = this.zzk + i;
        int i3 = this.zzl;
        if (i2 > i3) {
            int i4 = i2 - i3;
            this.zzh = i4;
            this.zzg = i - i4;
            return;
        }
        this.zzh = 0;
    }

    private final void zzg(int i) throws IOException {
        if (zzi(i)) {
            return;
        }
        if (i > (this.zzc - this.zzk) - this.zzi) {
            throw zzamd.zzi();
        }
        throw zzamd.zzj();
    }

    private final void zzh(int i) throws IOException {
        int i2 = this.zzg;
        int i3 = this.zzi;
        if (i <= i2 - i3 && i >= 0) {
            this.zzi = i3 + i;
            return;
        }
        if (i < 0) {
            throw zzamd.zzf();
        }
        int i4 = this.zzk + i3;
        if (zza(i4, i, this.zzc)) {
            throw zzamd.zzi();
        }
        if (zza(i4, i, this.zzl)) {
            int i5 = this.zzl;
            if (i5 >= i4) {
                zzh(i5 - i4);
            }
            throw zzamd.zzj();
        }
        int i6 = this.zzk;
        int i7 = this.zzi;
        this.zzk = i6 + i7;
        int i8 = this.zzg - i7;
        this.zzg = 0;
        this.zzi = 0;
        while (i8 < i) {
            try {
                long j = i - i8;
                long jZza = zza(this.zze, j);
                if (jZza >= 0 && jZza <= j) {
                    if (jZza == 0) {
                        break;
                    } else {
                        i8 += (int) jZza;
                    }
                } else {
                    throw new IllegalStateException(String.valueOf(this.zze.getClass()) + "#skip returned invalid result: " + jZza + "\nThe InputStream implementation is buggy.");
                }
            } catch (Throwable th) {
                this.zzk += i8;
                zzad();
                throw th;
            }
        }
        this.zzk += i8;
        zzad();
        if (i8 >= i) {
            return;
        }
        int i9 = this.zzg;
        int i10 = i9 - this.zzi;
        this.zzi = i9;
        zzg(1);
        while (true) {
            int i11 = i - i10;
            int i12 = this.zzg;
            if (i11 > i12) {
                i10 += i12;
                this.zzi = i12;
                zzg(1);
            } else {
                this.zzi = i11;
                return;
            }
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
    public final boolean zzw() throws IOException {
        return this.zzi == this.zzg && !zzi(1);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
    public final boolean zzx() throws IOException {
        return zzac() != 0;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
    public final boolean zze(int i) throws IOException {
        int i2 = i & 7;
        int i3 = 0;
        if (i2 == 0) {
            if (this.zzg - this.zzi >= 10) {
                while (i3 < 10) {
                    byte[] bArr = this.zzf;
                    int i4 = this.zzi;
                    this.zzi = i4 + 1;
                    if (bArr[i4] < 0) {
                        i3++;
                    }
                }
                throw zzamd.zze();
            }
            while (i3 < 10) {
                if (zzy() < 0) {
                    i3++;
                }
            }
            throw zzamd.zze();
            return true;
        }
        if (i2 == 1) {
            zzh(8);
            return true;
        }
        if (i2 == 2) {
            zzh(zzaa());
            return true;
        }
        if (i2 == 3) {
            zzv();
            zzc(((i >>> 3) << 3) | 4);
            return true;
        }
        if (i2 == 4) {
            zzu();
            return false;
        }
        if (i2 == 5) {
            zzh(4);
            return true;
        }
        throw zzamd.zza();
    }

    private final boolean zzi(int i) throws IOException {
        int i2 = this.zzi;
        if (i2 + i <= this.zzg) {
            throw new IllegalStateException("refillBuffer() called when " + i + " bytes were already available in buffer");
        }
        int i3 = this.zzk + i2;
        if (zza(i3, i, this.zzc) || zza(i3, i, this.zzl)) {
            return false;
        }
        int i4 = this.zzi;
        if (i4 > 0) {
            int i5 = this.zzg;
            if (i5 > i4) {
                byte[] bArr = this.zzf;
                System.arraycopy(bArr, i4, bArr, 0, i5 - i4);
            }
            this.zzk += i4;
            this.zzg -= i4;
            this.zzi = 0;
        }
        InputStream inputStream = this.zze;
        byte[] bArr2 = this.zzf;
        int i6 = this.zzg;
        int iZza = zza(inputStream, bArr2, i6, Math.min(bArr2.length - i6, (this.zzc - this.zzk) - this.zzg));
        if (iZza != 0 && iZza >= -1 && iZza <= this.zzf.length) {
            if (iZza <= 0) {
                return false;
            }
            this.zzg += iZza;
            zzad();
            return this.zzg >= i || zzi(i);
        }
        throw new IllegalStateException(String.valueOf(this.zze.getClass()) + "#read(byte[]) returned invalid result: " + iZza + "\nThe InputStream implementation is buggy.");
    }

    private final byte[] zza(int i, boolean z) throws IOException {
        byte[] bArrZzj = zzj(i);
        if (bArrZzj != null) {
            return bArrZzj;
        }
        int i2 = this.zzi;
        int i3 = this.zzg;
        int length = i3 - i2;
        this.zzk += i3;
        this.zzi = 0;
        this.zzg = 0;
        List<byte[]> listZzf = zzf(i - length);
        byte[] bArr = new byte[i];
        System.arraycopy(this.zzf, i2, bArr, 0, length);
        for (byte[] bArr2 : listZzf) {
            System.arraycopy(bArr2, 0, bArr, length, bArr2.length);
            length += bArr2.length;
        }
        return bArr;
    }

    private final byte[] zzj(int i) throws IOException {
        if (i == 0) {
            return zzalw.zza;
        }
        if (i < 0) {
            throw zzamd.zzf();
        }
        int i2 = this.zzk + this.zzi;
        if (zza(i2, i, this.zzc)) {
            throw zzamd.zzi();
        }
        if (zza(i2, i, this.zzl)) {
            int i3 = this.zzl;
            if (i3 >= i2) {
                zzh(i3 - i2);
            }
            throw zzamd.zzj();
        }
        int i4 = this.zzg - this.zzi;
        int i5 = i - i4;
        if (i5 >= 4096 && i5 > zza(this.zze)) {
            return null;
        }
        byte[] bArr = new byte[i];
        System.arraycopy(this.zzf, this.zzi, bArr, 0, i4);
        this.zzk += this.zzg;
        this.zzi = 0;
        this.zzg = 0;
        while (i4 < i) {
            int iZza = zza(this.zze, bArr, i4, i - i4);
            if (iZza == -1) {
                throw zzamd.zzj();
            }
            this.zzk += iZza;
            i4 += iZza;
        }
        return bArr;
    }
}
