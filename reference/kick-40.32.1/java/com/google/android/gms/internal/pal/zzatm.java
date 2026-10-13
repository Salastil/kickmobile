package com.google.android.gms.internal.pal;

import androidx.work.WorkInfo;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
abstract class zzatm extends zzatp {
    private final byte[] zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private final int zzi;
    private int zzj;
    private int zzk;

    /* synthetic */ zzatm(byte[] bArr, int i, int i2, boolean z, byte[] bArr2) {
        super(null);
        this.zzk = Integer.MAX_VALUE;
        this.zze = bArr;
        this.zzf = i2 + i;
        this.zzh = i;
        this.zzi = i;
    }

    private final void zzH() {
        int i = this.zzf + this.zzg;
        this.zzf = i;
        int i2 = i - this.zzi;
        int i3 = this.zzk;
        if (i2 <= i3) {
            this.zzg = 0;
            return;
        }
        int i4 = i2 - i3;
        this.zzg = i4;
        this.zzf = i - i4;
    }

    @Override // com.google.android.gms.internal.pal.zzatp
    public final void zzB(int i) {
        this.zzk = i;
        zzH();
    }

    @Override // com.google.android.gms.internal.pal.zzatp
    public final boolean zzC() throws IOException {
        return this.zzh == this.zzf;
    }

    @Override // com.google.android.gms.internal.pal.zzatp
    public final int zzD() {
        return this.zzh - this.zzi;
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
        return Double.longBitsToDouble(zzz());
    }

    @Override // com.google.android.gms.internal.pal.zzatp
    public final float zzd() throws IOException {
        return Float.intBitsToFloat(zzy());
    }

    @Override // com.google.android.gms.internal.pal.zzatp
    public final long zze() throws IOException {
        return zzw();
    }

    @Override // com.google.android.gms.internal.pal.zzatp
    public final long zzf() throws IOException {
        return zzw();
    }

    @Override // com.google.android.gms.internal.pal.zzatp
    public final int zzg() throws IOException {
        return zzu();
    }

    @Override // com.google.android.gms.internal.pal.zzatp
    public final long zzh() throws IOException {
        return zzz();
    }

    @Override // com.google.android.gms.internal.pal.zzatp
    public final int zzi() throws IOException {
        return zzy();
    }

    @Override // com.google.android.gms.internal.pal.zzatp
    public final boolean zzj() throws IOException {
        return zzw() != 0;
    }

    @Override // com.google.android.gms.internal.pal.zzatp
    public final String zzk() throws IOException {
        int iZzt = zzt();
        if (iZzt > 0) {
            int i = this.zzf;
            int i2 = this.zzh;
            if (iZzt <= i - i2) {
                String str = new String(this.zze, i2, iZzt, zzauz.zza);
                this.zzh += iZzt;
                return str;
            }
        }
        if (iZzt == 0) {
            return "";
        }
        if (iZzt < 0) {
            throw new zzavb("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        throw new zzavb("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    @Override // com.google.android.gms.internal.pal.zzatp
    public final String zzl() throws IOException {
        int iZzt = zzt();
        if (iZzt > 0) {
            int i = this.zzf;
            int i2 = this.zzh;
            if (iZzt <= i - i2) {
                String strZzd = zzaxm.zzd(this.zze, i2, iZzt);
                this.zzh += iZzt;
                return strZzd;
            }
        }
        if (iZzt == 0) {
            return "";
        }
        if (iZzt <= 0) {
            throw new zzavb("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        throw new zzavb("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    @Override // com.google.android.gms.internal.pal.zzatp
    public final zzatl zzm() throws IOException {
        int iZzt = zzt();
        if (iZzt > 0) {
            int i = this.zzf;
            int i2 = this.zzh;
            if (iZzt <= i - i2) {
                zzatl zzatlVarZzs = zzatl.zzs(this.zze, i2, iZzt, false);
                this.zzh += iZzt;
                return zzatlVarZzs;
            }
        }
        if (iZzt == 0) {
            return zzatl.zza;
        }
        if (iZzt > 0) {
            int i3 = this.zzf;
            int i4 = this.zzh;
            if (iZzt <= i3 - i4) {
                int i5 = iZzt + i4;
                this.zzh = i5;
                return zzatl.zzu(Arrays.copyOfRange(this.zze, i4, i5), false);
            }
        }
        if (iZzt <= 0) {
            throw new zzavb("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        throw new zzavb("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    @Override // com.google.android.gms.internal.pal.zzatp
    public final int zzn() throws IOException {
        return zzt();
    }

    @Override // com.google.android.gms.internal.pal.zzatp
    public final int zzo() throws IOException {
        return zzu();
    }

    @Override // com.google.android.gms.internal.pal.zzatp
    public final int zzp() throws IOException {
        return zzy();
    }

    @Override // com.google.android.gms.internal.pal.zzatp
    public final long zzq() throws IOException {
        return zzz();
    }

    @Override // com.google.android.gms.internal.pal.zzatp
    public final int zzr() throws IOException {
        return zzF(zzt());
    }

    @Override // com.google.android.gms.internal.pal.zzatp
    public final long zzs() throws IOException {
        return zzG(zzw());
    }

    protected abstract int zzt() throws IOException;

    protected abstract int zzu() throws IOException;

    public final int zzy() throws IOException {
        int i = this.zzh;
        if (this.zzf - i < 4) {
            throw new zzavb("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        byte[] bArr = this.zze;
        this.zzh = i + 4;
        return (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24);
    }

    public final long zzz() throws IOException {
        int i = this.zzh;
        if (this.zzf - i < 8) {
            throw new zzavb("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        byte[] bArr = this.zze;
        this.zzh = i + 8;
        long j = bArr[i];
        long j2 = (((long) bArr[i + 1]) & 255) << 8;
        long j3 = bArr[i + 2];
        long j4 = bArr[i + 3];
        return ((((long) bArr[i + 6]) & 255) << 48) | (j & 255) | j2 | ((j3 & 255) << 16) | ((j4 & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((((long) bArr[i + 7]) & 255) << 56);
    }

    @Override // com.google.android.gms.internal.pal.zzatp
    public final int zzA(int i) throws zzavb {
        if (i < 0) {
            throw new zzavb("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        int i2 = i + (this.zzh - this.zzi);
        if (i2 < 0) {
            throw new zzavb("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit. If reading multiple messages, consider resetting the counter between each message using CodedInputStream.resetSizeCounter().");
        }
        int i3 = this.zzk;
        if (i2 > i3) {
            throw new zzavb("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        this.zzk = i2;
        zzH();
        return i3;
    }

    final long zzx() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            int i2 = this.zzh;
            if (i2 == this.zzf) {
                throw new zzavb("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            byte[] bArr = this.zze;
            this.zzh = i2 + 1;
            byte b = bArr[i2];
            j |= ((long) (b & 127)) << i;
            if ((b & 128) == 0) {
                return j;
            }
        }
        throw new zzavb("CodedInputStream encountered a malformed varint.");
    }

    protected final int zzv() throws IOException {
        int i;
        int i2 = this.zzh;
        int i3 = this.zzf;
        if (i3 != i2) {
            byte[] bArr = this.zze;
            int i4 = i2 + 1;
            byte b = bArr[i2];
            if (b >= 0) {
                this.zzh = i4;
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
                this.zzh = i5;
                return i;
            }
        }
        return (int) zzx();
    }

    public final long zzw() throws IOException {
        long j;
        long j2;
        long j3;
        int i = this.zzh;
        int i2 = this.zzf;
        if (i2 != i) {
            byte[] bArr = this.zze;
            int i3 = i + 1;
            byte b = bArr[i];
            if (b >= 0) {
                this.zzh = i3;
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
                this.zzh = i4;
                return j;
            }
        }
        return zzx();
    }
}
