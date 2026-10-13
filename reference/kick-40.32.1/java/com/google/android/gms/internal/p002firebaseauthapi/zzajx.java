package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.common.base.Ascii;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzajx {
    private static volatile int zza = 100;

    static double zza(byte[] bArr, int i) {
        return Double.longBitsToDouble(zzd(bArr, i));
    }

    static float zzb(byte[] bArr, int i) {
        return Float.intBitsToFloat(zzc(bArr, i));
    }

    static int zza(byte[] bArr, int i, zzaka zzakaVar) throws zzamd {
        int iZzc = zzc(bArr, i, zzakaVar);
        int i2 = zzakaVar.zza;
        if (i2 < 0) {
            throw zzamd.zzf();
        }
        if (i2 > bArr.length - iZzc) {
            throw zzamd.zzj();
        }
        if (i2 == 0) {
            zzakaVar.zzc = zzakb.zza;
            return iZzc;
        }
        zzakaVar.zzc = zzakb.zza(bArr, iZzc, i2);
        return iZzc + i2;
    }

    static int zza(int i, byte[] bArr, int i2, int i3, Object obj, zzamv zzamvVar, zzaob<zzaoa, zzaoa> zzaobVar, zzaka zzakaVar) throws IOException {
        if (zzakaVar.zzd.zza(zzamvVar, i >>> 3) == null) {
            return zza(i, bArr, i2, i3, zzamz.zzc(obj), zzakaVar);
        }
        zzalt.zzb zzbVar = (zzalt.zzb) obj;
        zzbVar.zza();
        zzalm<zzalt.zze> zzalmVar = zzbVar.zzc;
        throw new NoSuchMethodError();
    }

    static int zzc(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    private static <T> int zza(zzanl<T> zzanlVar, byte[] bArr, int i, int i2, int i3, zzaka zzakaVar) throws IOException {
        T tZza = zzanlVar.zza();
        int iZza = zza(tZza, zzanlVar, bArr, i, i2, i3, zzakaVar);
        zzanlVar.zzd(tZza);
        zzakaVar.zzc = tZza;
        return iZza;
    }

    static int zza(zzanl<?> zzanlVar, int i, byte[] bArr, int i2, int i3, zzalx<Object> zzalxVar, zzaka zzakaVar) throws IOException {
        int i4 = (i & (-8)) | 4;
        int iZza = zza(zzanlVar, bArr, i2, i3, i4, zzakaVar);
        zzalxVar.add(zzakaVar.zzc);
        while (iZza < i3) {
            int iZzc = zzc(bArr, iZza, zzakaVar);
            if (i != zzakaVar.zza) {
                break;
            }
            iZza = zza(zzanlVar, bArr, iZzc, i3, i4, zzakaVar);
            zzalxVar.add(zzakaVar.zzc);
        }
        return iZza;
    }

    static <T> int zza(zzanl<T> zzanlVar, byte[] bArr, int i, int i2, zzaka zzakaVar) throws IOException {
        T tZza = zzanlVar.zza();
        int iZza = zza(tZza, zzanlVar, bArr, i, i2, zzakaVar);
        zzanlVar.zzd(tZza);
        zzakaVar.zzc = tZza;
        return iZza;
    }

    static int zzb(zzanl<?> zzanlVar, int i, byte[] bArr, int i2, int i3, zzalx<?> zzalxVar, zzaka zzakaVar) throws IOException {
        int iZza = zza(zzanlVar, bArr, i2, i3, zzakaVar);
        zzalxVar.add(zzakaVar.zzc);
        while (iZza < i3) {
            int iZzc = zzc(bArr, iZza, zzakaVar);
            if (i != zzakaVar.zza) {
                break;
            }
            iZza = zza(zzanlVar, bArr, iZzc, i3, zzakaVar);
            zzalxVar.add(zzakaVar.zzc);
        }
        return iZza;
    }

    static int zza(byte[] bArr, int i, zzalx<?> zzalxVar, zzaka zzakaVar) throws IOException {
        zzalu zzaluVar = (zzalu) zzalxVar;
        int iZzc = zzc(bArr, i, zzakaVar);
        int i2 = zzakaVar.zza;
        if (i2 < 0) {
            throw zzamd.zzf();
        }
        if (i2 > bArr.length - iZzc) {
            throw zzamd.zzj();
        }
        int i3 = i2 + iZzc;
        while (iZzc < i3) {
            iZzc = zzc(bArr, iZzc, zzakaVar);
            zzaluVar.zzc(zzakaVar.zza);
        }
        if (iZzc == i3) {
            return iZzc;
        }
        throw zzamd.zzj();
    }

    static int zzb(byte[] bArr, int i, zzaka zzakaVar) throws zzamd {
        int iZzc = zzc(bArr, i, zzakaVar);
        int i2 = zzakaVar.zza;
        if (i2 < 0) {
            throw zzamd.zzf();
        }
        if (i2 == 0) {
            zzakaVar.zzc = "";
            return iZzc;
        }
        zzakaVar.zzc = zzaog.zza(bArr, iZzc, i2);
        return iZzc + i2;
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzaoa zzaoaVar, zzaka zzakaVar) throws zzamd {
        if ((i >>> 3) == 0) {
            throw zzamd.zzc();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int iZzd = zzd(bArr, i2, zzakaVar);
            zzaoaVar.zza(i, Long.valueOf(zzakaVar.zzb));
            return iZzd;
        }
        if (i4 == 1) {
            zzaoaVar.zza(i, Long.valueOf(zzd(bArr, i2)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int iZzc = zzc(bArr, i2, zzakaVar);
            int i5 = zzakaVar.zza;
            if (i5 < 0) {
                throw zzamd.zzf();
            }
            if (i5 > bArr.length - iZzc) {
                throw zzamd.zzj();
            }
            if (i5 == 0) {
                zzaoaVar.zza(i, zzakb.zza);
            } else {
                zzaoaVar.zza(i, zzakb.zza(bArr, iZzc, i5));
            }
            return iZzc + i5;
        }
        if (i4 != 3) {
            if (i4 == 5) {
                zzaoaVar.zza(i, Integer.valueOf(zzc(bArr, i2)));
                return i2 + 4;
            }
            throw zzamd.zzc();
        }
        zzaoa zzaoaVarZzd = zzaoa.zzd();
        int i6 = (i & (-8)) | 4;
        zzakaVar.zze++;
        zza(zzakaVar.zze);
        int i7 = 0;
        while (i2 < i3) {
            int iZzc2 = zzc(bArr, i2, zzakaVar);
            i7 = zzakaVar.zza;
            if (i7 == i6) {
                i2 = iZzc2;
                break;
            }
            i2 = zza(i7, bArr, iZzc2, i3, zzaoaVarZzd, zzakaVar);
        }
        zzakaVar.zze--;
        if (i2 > i3 || i7 != i6) {
            throw zzamd.zzg();
        }
        zzaoaVar.zza(i, zzaoaVarZzd);
        return i2;
    }

    static int zzc(byte[] bArr, int i, zzaka zzakaVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b >= 0) {
            zzakaVar.zza = b;
            return i2;
        }
        return zza(b, bArr, i2, zzakaVar);
    }

    static int zza(int i, byte[] bArr, int i2, zzaka zzakaVar) {
        int i3 = i & 127;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            zzakaVar.zza = i3 | (b << 7);
            return i4;
        }
        int i5 = i3 | ((b & 127) << 7);
        int i6 = i2 + 2;
        byte b2 = bArr[i4];
        if (b2 >= 0) {
            zzakaVar.zza = i5 | (b2 << Ascii.SO);
            return i6;
        }
        int i7 = i5 | ((b2 & 127) << 14);
        int i8 = i2 + 3;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzakaVar.zza = i7 | (b3 << Ascii.NAK);
            return i8;
        }
        int i9 = i7 | ((b3 & 127) << 21);
        int i10 = i2 + 4;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzakaVar.zza = i9 | (b4 << Ascii.FS);
            return i10;
        }
        int i11 = i9 | ((b4 & 127) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zzakaVar.zza = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzalx<?> zzalxVar, zzaka zzakaVar) {
        zzalu zzaluVar = (zzalu) zzalxVar;
        int iZzc = zzc(bArr, i2, zzakaVar);
        zzaluVar.zzc(zzakaVar.zza);
        while (iZzc < i3) {
            int iZzc2 = zzc(bArr, iZzc, zzakaVar);
            if (i != zzakaVar.zza) {
                break;
            }
            iZzc = zzc(bArr, iZzc2, zzakaVar);
            zzaluVar.zzc(zzakaVar.zza);
        }
        return iZzc;
    }

    static int zzd(byte[] bArr, int i, zzaka zzakaVar) {
        int i2 = i + 1;
        long j = bArr[i];
        if (j >= 0) {
            zzakaVar.zzb = j;
            return i2;
        }
        int i3 = i + 2;
        byte b = bArr[i2];
        long j2 = (j & 127) | (((long) (b & 127)) << 7);
        int i4 = 7;
        while (b < 0) {
            int i5 = i3 + 1;
            byte b2 = bArr[i3];
            i4 += 7;
            j2 |= ((long) (b2 & 127)) << i4;
            b = b2;
            i3 = i5;
        }
        zzakaVar.zzb = j2;
        return i3;
    }

    static <T> int zza(Object obj, zzanl<T> zzanlVar, byte[] bArr, int i, int i2, int i3, zzaka zzakaVar) throws IOException {
        zzakaVar.zze++;
        zza(zzakaVar.zze);
        int iZza = ((zzamz) zzanlVar).zza(obj, bArr, i, i2, i3, zzakaVar);
        zzakaVar.zze--;
        zzakaVar.zzc = obj;
        return iZza;
    }

    static <T> int zza(Object obj, zzanl<T> zzanlVar, byte[] bArr, int i, int i2, zzaka zzakaVar) throws IOException {
        int iZza = i + 1;
        int i3 = bArr[i];
        if (i3 < 0) {
            iZza = zza(i3, bArr, iZza, zzakaVar);
            i3 = zzakaVar.zza;
        }
        int i4 = iZza;
        if (i3 < 0 || i3 > i2 - i4) {
            throw zzamd.zzj();
        }
        zzakaVar.zze++;
        zza(zzakaVar.zze);
        int i5 = i4 + i3;
        zzanlVar.zza(obj, bArr, i4, i5, zzakaVar);
        zzakaVar.zze--;
        zzakaVar.zzc = obj;
        return i5;
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzaka zzakaVar) throws zzamd {
        if ((i >>> 3) == 0) {
            throw zzamd.zzc();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            return zzd(bArr, i2, zzakaVar);
        }
        if (i4 == 1) {
            return i2 + 8;
        }
        if (i4 == 2) {
            return zzc(bArr, i2, zzakaVar) + zzakaVar.zza;
        }
        if (i4 != 3) {
            if (i4 == 5) {
                return i2 + 4;
            }
            throw zzamd.zzc();
        }
        int i5 = (i & (-8)) | 4;
        zzakaVar.zze++;
        zza(zzakaVar.zze);
        int i6 = 0;
        while (i2 < i3) {
            i2 = zzc(bArr, i2, zzakaVar);
            i6 = zzakaVar.zza;
            if (i6 == i5) {
                break;
            }
            i2 = zza(i6, bArr, i2, i3, zzakaVar);
        }
        zzakaVar.zze--;
        if (i2 > i3 || i6 != i5) {
            throw zzamd.zzg();
        }
        return i2;
    }

    static long zzd(byte[] bArr, int i) {
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    private static void zza(int i) throws zzamd {
        if (i >= zza) {
            throw zzamd.zzh();
        }
    }
}
