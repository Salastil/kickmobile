package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.work.WorkInfo;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
abstract class zzakq extends zzakn {
    private final byte[] zze;
    private final int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;

    private final byte zzac() throws IOException {
        int i = this.zzh;
        if (i == this.zzg) {
            throw zzamd.zzj();
        }
        byte[] bArr = this.zze;
        this.zzh = i + 1;
        return bArr[i];
    }

    protected abstract int zzy() throws IOException;

    protected abstract int zzz() throws IOException;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
    public final double zza() throws IOException {
        return Double.longBitsToDouble(zzae());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
    public final float zzb() throws IOException {
        return Float.intBitsToFloat(zzad());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
    public final int zzc() {
        return this.zzh - this.zzi;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
    public final int zzb(int i) throws zzamd {
        if (i < 0) {
            throw zzamd.zzf();
        }
        int i2 = this.zzh;
        int i3 = i2 + i;
        if (i3 < 0) {
            i3 = Integer.MAX_VALUE;
            if (i > Integer.MAX_VALUE - (i2 - this.zzi)) {
                throw zzamd.zzi();
            }
        }
        int i4 = this.zzk;
        if (i3 > i4) {
            throw zzamd.zzj();
        }
        zzf(i3);
        return i4;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
    public final int zzd() throws IOException {
        return zzy();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
    public final int zze() throws IOException {
        return zzad();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
    public final int zzf() throws IOException {
        return zzy();
    }

    private final int zzad() throws IOException {
        int i = this.zzh;
        if (this.zzg - i < 4) {
            throw zzamd.zzj();
        }
        byte[] bArr = this.zze;
        this.zzh = i + 4;
        return (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24);
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0069 A[PHI: r3
      0x0069: PHI (r3v6 int) = (r3v5 int), (r3v10 int), (r3v12 int) binds: [B:15:0x003f, B:19:0x004b, B:23:0x0057] A[DONT_GENERATE, DONT_INLINE]] */
    protected final int zzaa() throws IOException {
        try {
            int i = this.zzh;
            byte[] bArr = this.zze;
            int i2 = i + 1;
            int i3 = bArr[i];
            if (i3 < 0) {
                int i4 = i + 2;
                int i5 = (bArr[i2] << 7) ^ i3;
                if (i5 < 0) {
                    i3 = (i5 == true ? 1 : 0) ^ WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT;
                } else {
                    int i6 = i + 3;
                    int i7 = (i5 == true ? 1 : 0) ^ (bArr[i4] << 14);
                    if (i7 >= 0) {
                        int i8 = i7 ^ 16256;
                        i2 = i6;
                        i3 = i8;
                    } else {
                        i4 = i + 4;
                        int i9 = i7 ^ (bArr[i6] << 21);
                        if (i9 < 0) {
                            i3 = i9 ^ (-2080896);
                        } else {
                            int i10 = i + 5;
                            int i11 = bArr[i4];
                            int i12 = (i9 ^ (i11 << 28)) ^ 266354560;
                            if (i11 < 0) {
                                i4 = i + 6;
                                if (bArr[i10] < 0) {
                                    i10 = i + 7;
                                    if (bArr[i4] < 0) {
                                        i4 = i + 8;
                                        if (bArr[i10] < 0) {
                                            i10 = i + 9;
                                            if (bArr[i4] < 0) {
                                                int i13 = i + 10;
                                                if (bArr[i10] < 0) {
                                                    throw zzamd.zze();
                                                }
                                                i3 = i12;
                                                i2 = i13;
                                            } else {
                                                int i14 = i10;
                                                i3 = i12;
                                                i2 = i14;
                                            }
                                        }
                                    } else {
                                        int i15 = i10;
                                        i3 = i12;
                                        i2 = i15;
                                    }
                                }
                                i3 = i12;
                            } else {
                                int i16 = i10;
                                i3 = i12;
                                i2 = i16;
                            }
                        }
                    }
                }
                i2 = i4;
            }
            this.zzh = i2;
            if (i2 <= this.zzg) {
                return i3;
            }
            throw zzamd.zzj();
        } catch (zzamd e) {
            if (this.zzh > this.zzg) {
                throw zzamd.zzj();
            }
            throw e;
        } catch (IndexOutOfBoundsException unused) {
            throw zzamd.zzj();
        }
    }

    protected final int zzab() throws IOException {
        int i;
        int i2 = this.zzh;
        int i3 = this.zzg;
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
        return (int) zzm();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
    public final int zzg() throws IOException {
        return zzad();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
    public final int zzh() throws IOException {
        return zza(zzz());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
    public final int zzi() throws IOException {
        if (zzw()) {
            this.zzj = 0;
            return 0;
        }
        int iZzz = zzz();
        this.zzj = iZzz;
        if ((iZzz >>> 3) != 0) {
            return iZzz;
        }
        throw zzamd.zzc();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
    public final int zzj() throws IOException {
        return zzz();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
    public final long zzk() throws IOException {
        return zzae();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
    public final long zzl() throws IOException {
        return zzaf();
    }

    private final long zzae() throws IOException {
        int i = this.zzh;
        if (this.zzg - i < 8) {
            throw zzamd.zzj();
        }
        byte[] bArr = this.zze;
        this.zzh = i + 8;
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    private final long zzaf() throws IOException {
        long j;
        long j2;
        long j3;
        int i = this.zzh;
        int i2 = this.zzg;
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
                this.zzh = i4;
                return j;
            }
        }
        return zzm();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
    final long zzm() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte bZzac = zzac();
            j |= ((long) (bZzac & 127)) << i;
            if ((bZzac & 128) == 0) {
                return j;
            }
        }
        throw zzamd.zze();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
    public final long zzn() throws IOException {
        return zzae();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
    public final long zzo() throws IOException {
        return zza(zzaf());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
    public final long zzp() throws IOException {
        return zzaf();
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0032 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:16:0x0034 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:17:0x0036  */
    /* JADX WARN: Code duplicated, block: B:20:0x003d  */
    /* JADX WARN: Code duplicated, block: B:22:0x0042  */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
    public final zzakb zzq() throws IOException {
        byte[] bArrCopyOfRange;
        int iZzz = zzz();
        if (iZzz > 0) {
            int i = this.zzg;
            int i2 = this.zzh;
            if (iZzz <= i - i2) {
                zzakb zzakbVarZza = zzakb.zza(this.zze, i2, iZzz, false);
                this.zzh += iZzz;
                return zzakbVarZza;
            }
        }
        if (iZzz == 0) {
            return zzakb.zza;
        }
        if (iZzz > 0) {
            int i3 = this.zzg;
            int i4 = this.zzh;
            if (iZzz <= i3 - i4) {
                int i5 = iZzz + i4;
                this.zzh = i5;
                bArrCopyOfRange = Arrays.copyOfRange(this.zze, i4, i5);
            } else {
                if (iZzz <= 0) {
                    throw zzamd.zzj();
                }
                if (iZzz == 0) {
                    bArrCopyOfRange = zzalw.zza;
                } else {
                    throw zzamd.zzf();
                }
            }
        } else {
            if (iZzz <= 0) {
                throw zzamd.zzj();
            }
            if (iZzz == 0) {
                bArrCopyOfRange = zzalw.zza;
            } else {
                throw zzamd.zzf();
            }
        }
        return zzakb.zza(bArrCopyOfRange, false);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
    public final String zzr() throws IOException {
        int iZzz = zzz();
        if (iZzz > 0 && iZzz <= this.zzg - this.zzh) {
            String str = new String(this.zze, this.zzh, iZzz, StandardCharsets.UTF_8);
            this.zzh += iZzz;
            return str;
        }
        if (iZzz == 0) {
            return "";
        }
        if (iZzz < 0) {
            throw zzamd.zzf();
        }
        throw zzamd.zzj();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
    public final String zzs() throws IOException {
        int iZzz = zzz();
        if (iZzz > 0) {
            int i = this.zzg;
            int i2 = this.zzh;
            if (iZzz <= i - i2) {
                String strZza = zzaog.zza(this.zze, i2, iZzz);
                this.zzh += iZzz;
                return strZza;
            }
        }
        if (iZzz == 0) {
            return "";
        }
        if (iZzz <= 0) {
            throw zzamd.zzf();
        }
        throw zzamd.zzj();
    }

    private zzakq(byte[] bArr, int i, int i2, boolean z) {
        super();
        this.zzk = Integer.MAX_VALUE;
        this.zze = bArr;
        int i3 = i2 + i;
        this.zzf = i3;
        this.zzg = i3;
        this.zzh = i;
        this.zzi = i;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
    public final void zzc(int i) throws zzamd {
        if (this.zzj != i) {
            throw zzamd.zzb();
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
    public final void zzd(int i) {
        zzf(i);
    }

    private final void zzf(int i) {
        this.zzk = i;
        int i2 = this.zzf;
        if (i <= i2) {
            this.zzg = i;
        } else {
            this.zzg = i2;
        }
    }

    private final void zzg(int i) throws IOException {
        if (i >= 0) {
            int i2 = this.zzg;
            int i3 = this.zzh;
            if (i <= i2 - i3) {
                this.zzh = i3 + i;
                return;
            }
        }
        if (i < 0) {
            throw zzamd.zzf();
        }
        throw zzamd.zzj();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
    public final boolean zzw() throws IOException {
        return this.zzh == this.zzg;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
    public final boolean zzx() throws IOException {
        return zzaf() != 0;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
    public final boolean zze(int i) throws IOException {
        int i2 = i & 7;
        int i3 = 0;
        if (i2 == 0) {
            if (this.zzg - this.zzh >= 10) {
                while (i3 < 10) {
                    byte[] bArr = this.zze;
                    int i4 = this.zzh;
                    this.zzh = i4 + 1;
                    if (bArr[i4] < 0) {
                        i3++;
                    }
                }
                throw zzamd.zze();
            }
            while (i3 < 10) {
                if (zzac() < 0) {
                    i3++;
                }
            }
            throw zzamd.zze();
            return true;
        }
        if (i2 == 1) {
            zzg(8);
            return true;
        }
        if (i2 == 2) {
            zzg(zzz());
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
            zzg(4);
            return true;
        }
        throw zzamd.zza();
    }
}
