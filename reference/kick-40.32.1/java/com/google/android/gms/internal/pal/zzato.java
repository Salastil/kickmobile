package com.google.android.gms.internal.pal;

import androidx.media3.common.C;
import androidx.work.WorkInfo;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzato extends zzatp {
    private final InputStream zze;
    private final byte[] zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl;

    /* synthetic */ zzato(InputStream inputStream, int i, byte[] bArr) {
        super(null);
        this.zzl = Integer.MAX_VALUE;
        byte[] bArr2 = zzauz.zzb;
        this.zze = inputStream;
        this.zzf = new byte[4096];
        this.zzg = 0;
        this.zzi = 0;
        this.zzk = 0;
    }

    private final void zzH(int i) throws IOException {
        if (zzI(i)) {
            return;
        }
        if (i <= (Integer.MAX_VALUE - this.zzk) - this.zzi) {
            throw new zzavb("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        throw new zzavb("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit. If reading multiple messages, consider resetting the counter between each message using CodedInputStream.resetSizeCounter().");
    }

    private final boolean zzI(int i) throws IOException {
        int i2 = this.zzi;
        int i3 = i2 + i;
        int i4 = this.zzg;
        if (i3 <= i4) {
            StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 66);
            sb.append("refillBuffer() called when ");
            sb.append(i);
            sb.append(" bytes were already available in buffer");
            throw new IllegalStateException(sb.toString());
        }
        int i5 = this.zzk;
        if (i > (Integer.MAX_VALUE - i5) - i2 || i5 + i2 + i > this.zzl) {
            return false;
        }
        if (i2 > 0) {
            if (i4 > i2) {
                byte[] bArr = this.zzf;
                System.arraycopy(bArr, i2, bArr, 0, i4 - i2);
            }
            i5 = this.zzk + i2;
            this.zzk = i5;
            i4 = this.zzg - i2;
            this.zzg = i4;
            this.zzi = 0;
        }
        try {
            int i6 = this.zze.read(this.zzf, i4, Math.min(4096 - i4, (Integer.MAX_VALUE - i5) - i4));
            if (i6 != 0 && i6 >= -1 && i6 <= 4096) {
                if (i6 <= 0) {
                    return false;
                }
                this.zzg += i6;
                zzz();
                return this.zzg >= i || zzI(i);
            }
            String strValueOf = String.valueOf(this.zze.getClass());
            StringBuilder sb2 = new StringBuilder(String.valueOf(strValueOf).length() + 39 + String.valueOf(i6).length() + 41);
            sb2.append(strValueOf);
            sb2.append("#read(byte[]) returned invalid result: ");
            sb2.append(i6);
            sb2.append("\nThe InputStream implementation is buggy.");
            throw new IllegalStateException(sb2.toString());
        } catch (zzavb e) {
            e.zza();
            throw e;
        }
    }

    private final byte[] zzJ(int i, boolean z) throws IOException {
        byte[] bArrZzK = zzK(i);
        if (bArrZzK != null) {
            return bArrZzK;
        }
        int i2 = this.zzi;
        int i3 = this.zzg;
        int i4 = i3 - i2;
        this.zzk += i3;
        this.zzi = 0;
        this.zzg = 0;
        List<byte[]> listZzL = zzL(i - i4);
        byte[] bArr = new byte[i];
        System.arraycopy(this.zzf, i2, bArr, 0, i4);
        for (byte[] bArr2 : listZzL) {
            int length = bArr2.length;
            System.arraycopy(bArr2, 0, bArr, i4, length);
            i4 += length;
        }
        return bArr;
    }

    private final byte[] zzK(int i) throws IOException {
        if (i == 0) {
            return zzauz.zzb;
        }
        int i2 = this.zzk;
        int i3 = this.zzi;
        int i4 = i2 + i3 + i;
        if (C.RATE_UNSET_INT + i4 > 0) {
            throw new zzavb("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit. If reading multiple messages, consider resetting the counter between each message using CodedInputStream.resetSizeCounter().");
        }
        int i5 = this.zzl;
        if (i4 > i5) {
            zzy((i5 - i2) - i3);
            throw new zzavb("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        int i6 = this.zzg - i3;
        int i7 = i - i6;
        if (i7 >= 4096) {
            try {
                if (i7 > this.zze.available()) {
                    return null;
                }
            } catch (zzavb e) {
                e.zza();
                throw e;
            }
        }
        byte[] bArr = new byte[i];
        System.arraycopy(this.zzf, this.zzi, bArr, 0, i6);
        this.zzk += this.zzg;
        this.zzi = 0;
        this.zzg = 0;
        while (i6 < i) {
            try {
                int i8 = this.zze.read(bArr, i6, i - i6);
                if (i8 == -1) {
                    throw new zzavb("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                }
                this.zzk += i8;
                i6 += i8;
            } catch (zzavb e2) {
                e2.zza();
                throw e2;
            }
        }
        return bArr;
    }

    private final List zzL(int i) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (i > 0) {
            int iMin = Math.min(i, 4096);
            byte[] bArr = new byte[iMin];
            int i2 = 0;
            while (i2 < iMin) {
                int i3 = this.zze.read(bArr, i2, iMin - i2);
                if (i3 == -1) {
                    throw new zzavb("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                }
                this.zzk += i3;
                i2 += i3;
            }
            i -= iMin;
            arrayList.add(bArr);
        }
        return arrayList;
    }

    private final void zzz() {
        int i = this.zzg + this.zzh;
        this.zzg = i;
        int i2 = this.zzk + i;
        int i3 = this.zzl;
        if (i2 <= i3) {
            this.zzh = 0;
            return;
        }
        int i4 = i2 - i3;
        this.zzh = i4;
        this.zzg = i - i4;
    }

    @Override // com.google.android.gms.internal.pal.zzatp
    public final void zzB(int i) {
        this.zzl = i;
        zzz();
    }

    @Override // com.google.android.gms.internal.pal.zzatp
    public final boolean zzC() throws IOException {
        return this.zzi == this.zzg && !zzI(1);
    }

    @Override // com.google.android.gms.internal.pal.zzatp
    public final int zzD() {
        return this.zzk + this.zzi;
    }

    @Override // com.google.android.gms.internal.pal.zzatp
    public final int zza() throws IOException {
        if (zzC()) {
            this.zzj = 0;
            return 0;
        }
        int iZzt = zzt();
        this.zzj = iZzt;
        if ((iZzt >>> 3) != 0) {
            return iZzt;
        }
        throw new zzavb("Protocol message contained an invalid tag (zero).");
    }

    @Override // com.google.android.gms.internal.pal.zzatp
    public final void zzb(int i) throws zzavb {
        if (this.zzj != 0) {
            throw new zzavb("Protocol message end-group tag did not match expected tag.");
        }
    }

    @Override // com.google.android.gms.internal.pal.zzatp
    public final double zzc() throws IOException {
        return Double.longBitsToDouble(zzx());
    }

    @Override // com.google.android.gms.internal.pal.zzatp
    public final float zzd() throws IOException {
        return Float.intBitsToFloat(zzw());
    }

    @Override // com.google.android.gms.internal.pal.zzatp
    public final long zze() throws IOException {
        return zzu();
    }

    @Override // com.google.android.gms.internal.pal.zzatp
    public final long zzf() throws IOException {
        return zzu();
    }

    @Override // com.google.android.gms.internal.pal.zzatp
    public final int zzg() throws IOException {
        return zzt();
    }

    @Override // com.google.android.gms.internal.pal.zzatp
    public final long zzh() throws IOException {
        return zzx();
    }

    @Override // com.google.android.gms.internal.pal.zzatp
    public final int zzi() throws IOException {
        return zzw();
    }

    @Override // com.google.android.gms.internal.pal.zzatp
    public final boolean zzj() throws IOException {
        return zzu() != 0;
    }

    @Override // com.google.android.gms.internal.pal.zzatp
    public final String zzk() throws IOException {
        int iZzt = zzt();
        if (iZzt > 0) {
            int i = this.zzg;
            int i2 = this.zzi;
            if (iZzt <= i - i2) {
                String str = new String(this.zzf, i2, iZzt, zzauz.zza);
                this.zzi += iZzt;
                return str;
            }
        }
        if (iZzt == 0) {
            return "";
        }
        if (iZzt < 0) {
            throw new zzavb("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (iZzt > this.zzg) {
            return new String(zzJ(iZzt, false), zzauz.zza);
        }
        zzH(iZzt);
        String str2 = new String(this.zzf, this.zzi, iZzt, zzauz.zza);
        this.zzi += iZzt;
        return str2;
    }

    @Override // com.google.android.gms.internal.pal.zzatp
    public final String zzl() throws IOException {
        byte[] bArrZzJ;
        int iZzt = zzt();
        int i = this.zzi;
        int i2 = this.zzg;
        if (iZzt <= i2 - i && iZzt > 0) {
            bArrZzJ = this.zzf;
            this.zzi = i + iZzt;
        } else {
            if (iZzt == 0) {
                return "";
            }
            if (iZzt < 0) {
                throw new zzavb("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            }
            i = 0;
            if (iZzt <= i2) {
                zzH(iZzt);
                bArrZzJ = this.zzf;
                this.zzi = iZzt;
            } else {
                bArrZzJ = zzJ(iZzt, false);
            }
        }
        return zzaxm.zzd(bArrZzJ, i, iZzt);
    }

    @Override // com.google.android.gms.internal.pal.zzatp
    public final zzatl zzm() throws IOException {
        int iZzt = zzt();
        int i = this.zzg;
        int i2 = this.zzi;
        if (iZzt <= i - i2 && iZzt > 0) {
            zzatl zzatlVarZzs = zzatl.zzs(this.zzf, i2, iZzt, false);
            this.zzi += iZzt;
            return zzatlVarZzs;
        }
        if (iZzt == 0) {
            return zzatl.zza;
        }
        if (iZzt < 0) {
            throw new zzavb("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        byte[] bArrZzK = zzK(iZzt);
        if (bArrZzK != null) {
            return zzatl.zzs(bArrZzK, 0, bArrZzK.length, false);
        }
        int i3 = this.zzi;
        int i4 = this.zzg;
        int i5 = i4 - i3;
        this.zzk += i4;
        this.zzi = 0;
        this.zzg = 0;
        List<byte[]> listZzL = zzL(iZzt - i5);
        byte[] bArr = new byte[iZzt];
        System.arraycopy(this.zzf, i3, bArr, 0, i5);
        for (byte[] bArr2 : listZzL) {
            int length = bArr2.length;
            System.arraycopy(bArr2, 0, bArr, i5, length);
            i5 += length;
        }
        return zzatl.zzt(bArr);
    }

    @Override // com.google.android.gms.internal.pal.zzatp
    public final int zzn() throws IOException {
        return zzt();
    }

    @Override // com.google.android.gms.internal.pal.zzatp
    public final int zzo() throws IOException {
        return zzt();
    }

    @Override // com.google.android.gms.internal.pal.zzatp
    public final int zzp() throws IOException {
        return zzw();
    }

    @Override // com.google.android.gms.internal.pal.zzatp
    public final long zzq() throws IOException {
        return zzx();
    }

    @Override // com.google.android.gms.internal.pal.zzatp
    public final int zzr() throws IOException {
        return zzF(zzt());
    }

    @Override // com.google.android.gms.internal.pal.zzatp
    public final long zzs() throws IOException {
        return zzG(zzu());
    }

    final long zzv() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            if (this.zzi == this.zzg) {
                zzH(1);
            }
            byte[] bArr = this.zzf;
            int i2 = this.zzi;
            this.zzi = i2 + 1;
            byte b = bArr[i2];
            j |= ((long) (b & 127)) << i;
            if ((b & 128) == 0) {
                return j;
            }
        }
        throw new zzavb("CodedInputStream encountered a malformed varint.");
    }

    public final int zzw() throws IOException {
        int i = this.zzi;
        if (this.zzg - i < 4) {
            zzH(4);
            i = this.zzi;
        }
        byte[] bArr = this.zzf;
        this.zzi = i + 4;
        return (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24);
    }

    public final long zzx() throws IOException {
        int i = this.zzi;
        if (this.zzg - i < 8) {
            zzH(8);
            i = this.zzi;
        }
        byte[] bArr = this.zzf;
        this.zzi = i + 8;
        long j = bArr[i];
        long j2 = (((long) bArr[i + 1]) & 255) << 8;
        long j3 = bArr[i + 2];
        long j4 = bArr[i + 3];
        return ((((long) bArr[i + 6]) & 255) << 48) | (j & 255) | j2 | ((j3 & 255) << 16) | ((j4 & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((((long) bArr[i + 7]) & 255) << 56);
    }

    public final void zzy(int i) throws IOException {
        int i2 = this.zzg;
        int i3 = this.zzi;
        int i4 = i2 - i3;
        if (i <= i4 && i >= 0) {
            this.zzi = i3 + i;
            return;
        }
        if (i < 0) {
            throw new zzavb("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        int i5 = this.zzk;
        int i6 = i5 + i3;
        int i7 = this.zzl;
        if (i6 + i > i7) {
            zzy((i7 - i5) - i3);
            throw new zzavb("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        this.zzk = i6;
        this.zzg = 0;
        this.zzi = 0;
        while (i4 < i) {
            try {
                long j = i - i4;
                try {
                    long jSkip = this.zze.skip(j);
                    if (jSkip < 0 || jSkip > j) {
                        String strValueOf = String.valueOf(this.zze.getClass());
                        StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 31 + String.valueOf(jSkip).length() + 41);
                        sb.append(strValueOf);
                        sb.append("#skip returned invalid result: ");
                        sb.append(jSkip);
                        sb.append("\nThe InputStream implementation is buggy.");
                        throw new IllegalStateException(sb.toString());
                    }
                    if (jSkip == 0) {
                        break;
                    } else {
                        i4 += (int) jSkip;
                    }
                } catch (zzavb e) {
                    e.zza();
                    throw e;
                }
            } catch (Throwable th) {
                this.zzk += i4;
                zzz();
                throw th;
            }
        }
        this.zzk += i4;
        zzz();
        if (i4 >= i) {
            return;
        }
        int i8 = this.zzg;
        int i9 = i8 - this.zzi;
        this.zzi = i8;
        zzH(1);
        while (true) {
            int i10 = i - i9;
            int i11 = this.zzg;
            if (i10 <= i11) {
                this.zzi = i10;
                return;
            } else {
                i9 += i11;
                this.zzi = i11;
                zzH(1);
            }
        }
    }

    @Override // com.google.android.gms.internal.pal.zzatp
    public final int zzA(int i) throws zzavb {
        if (i < 0) {
            throw new zzavb("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        int i2 = i + this.zzk + this.zzi;
        if (i2 < 0) {
            throw new zzavb("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit. If reading multiple messages, consider resetting the counter between each message using CodedInputStream.resetSizeCounter().");
        }
        int i3 = this.zzl;
        if (i2 > i3) {
            throw new zzavb("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        this.zzl = i2;
        zzz();
        return i3;
    }

    public final int zzt() throws IOException {
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
        return (int) zzv();
    }

    public final long zzu() throws IOException {
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
                    } else {
                        int i8 = i + 4;
                        int i9 = i7 ^ (bArr[i6] << Ascii.NAK);
                        if (i9 < 0) {
                            long j4 = (-2080896) ^ i9;
                            i4 = i8;
                            j = j4;
                        } else {
                            i6 = i + 5;
                            long j5 = (((long) bArr[i8]) << 28) ^ ((long) i9);
                            if (j5 >= 0) {
                                j = j5 ^ 266354560;
                            } else {
                                i4 = i + 6;
                                long j6 = (((long) bArr[i6]) << 35) ^ j5;
                                if (j6 < 0) {
                                    j3 = -34093383808L;
                                } else {
                                    int i10 = i + 7;
                                    long j7 = j6 ^ (((long) bArr[i4]) << 42);
                                    if (j7 >= 0) {
                                        j2 = 4363953127296L;
                                    } else {
                                        i4 = i + 8;
                                        j6 = j7 ^ (((long) bArr[i10]) << 49);
                                        if (j6 < 0) {
                                            j3 = -558586000294016L;
                                        } else {
                                            i10 = i + 9;
                                            j7 = j6 ^ (((long) bArr[i4]) << 56);
                                            if (j7 >= 0) {
                                                j2 = 71499008037633920L;
                                            } else {
                                                i4 = i + 10;
                                                long j8 = j7 ^ (((long) bArr[i10]) << 63);
                                                if (j8 >= 0) {
                                                    j = j8 ^ (-9151873028817141888L);
                                                }
                                            }
                                        }
                                    }
                                    j = j7 ^ j2;
                                    i4 = i10;
                                }
                                j = j6 ^ j3;
                            }
                        }
                    }
                    i4 = i6;
                }
                this.zzi = i4;
                return j;
            }
        }
        return zzv();
    }
}
