package com.google.android.gms.internal.pal;

import com.google.common.base.Ascii;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzatc {
    public static final /* synthetic */ int zza = 0;
    private static volatile int zzb = 100;

    static int zza(byte[] bArr, int i, zzatb zzatbVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zzb(b, bArr, i2, zzatbVar);
        }
        zzatbVar.zza = b;
        return i2;
    }

    static int zzb(int i, byte[] bArr, int i2, zzatb zzatbVar) {
        byte b = bArr[i2];
        int i3 = i2 + 1;
        int i4 = i & 127;
        if (b >= 0) {
            zzatbVar.zza = i4 | (b << 7);
            return i3;
        }
        int i5 = i4 | ((b & 127) << 7);
        int i6 = i2 + 2;
        byte b2 = bArr[i3];
        if (b2 >= 0) {
            zzatbVar.zza = i5 | (b2 << Ascii.SO);
            return i6;
        }
        int i7 = i5 | ((b2 & 127) << 14);
        int i8 = i2 + 3;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzatbVar.zza = i7 | (b3 << Ascii.NAK);
            return i8;
        }
        int i9 = i7 | ((b3 & 127) << 21);
        int i10 = i2 + 4;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzatbVar.zza = i9 | (b4 << Ascii.FS);
            return i10;
        }
        int i11 = i9 | ((b4 & 127) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zzatbVar.zza = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    static int zzc(byte[] bArr, int i, zzatb zzatbVar) {
        long j = bArr[i];
        int i2 = i + 1;
        if (j >= 0) {
            zzatbVar.zzb = j;
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
        zzatbVar.zzb = j2;
        return i3;
    }

    static int zzd(byte[] bArr, int i) {
        int i2 = bArr[i] & 255;
        int i3 = bArr[i + 1] & 255;
        int i4 = bArr[i + 2] & 255;
        return ((bArr[i + 3] & 255) << 24) | (i3 << 8) | i2 | (i4 << 16);
    }

    static long zze(byte[] bArr, int i) {
        return (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48) | ((((long) bArr[i + 7]) & 255) << 56);
    }

    static int zzf(byte[] bArr, int i, zzatb zzatbVar) throws zzavb {
        int iZza = zza(bArr, i, zzatbVar);
        int i2 = zzatbVar.zza;
        if (i2 < 0) {
            throw new zzavb("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i2 > bArr.length - iZza) {
            throw new zzavb("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        if (i2 == 0) {
            zzatbVar.zzc = zzatl.zza;
            return iZza;
        }
        zzatbVar.zzc = zzatl.zzr(bArr, iZza, i2);
        return iZza + i2;
    }

    static int zzg(zzawn zzawnVar, byte[] bArr, int i, int i2, zzatb zzatbVar) throws IOException {
        Object objZza = zzawnVar.zza();
        int iZzi = zzi(objZza, zzawnVar, bArr, i, i2, zzatbVar);
        zzawnVar.zzk(objZza);
        zzatbVar.zzc = objZza;
        return iZzi;
    }

    static int zzh(zzawn zzawnVar, byte[] bArr, int i, int i2, int i3, zzatb zzatbVar) throws IOException {
        Object objZza = zzawnVar.zza();
        int iZzj = zzj(objZza, zzawnVar, bArr, i, i2, i3, zzatbVar);
        zzawnVar.zzk(objZza);
        zzatbVar.zzc = objZza;
        return iZzj;
    }

    static int zzi(Object obj, zzawn zzawnVar, byte[] bArr, int i, int i2, zzatb zzatbVar) throws IOException {
        int iZzb = i + 1;
        int i3 = bArr[i];
        if (i3 < 0) {
            iZzb = zzb(i3, bArr, iZzb, zzatbVar);
            i3 = zzatbVar.zza;
        }
        int i4 = iZzb;
        if (i3 < 0 || i3 > i2 - i4) {
            throw new zzavb("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        int i5 = zzatbVar.zze + 1;
        zzatbVar.zze = i5;
        zzo(i5);
        int i6 = i4 + i3;
        zzawnVar.zzj(obj, bArr, i4, i6, zzatbVar);
        zzatbVar.zze--;
        zzatbVar.zzc = obj;
        return i6;
    }

    static int zzj(Object obj, zzawn zzawnVar, byte[] bArr, int i, int i2, int i3, zzatb zzatbVar) throws IOException {
        int i4 = zzatbVar.zze + 1;
        zzatbVar.zze = i4;
        zzo(i4);
        int iZzi = ((zzavz) zzawnVar).zzi(obj, bArr, i, i2, i3, zzatbVar);
        zzatbVar.zze--;
        zzatbVar.zzc = obj;
        return iZzi;
    }

    static int zzk(int i, byte[] bArr, int i2, int i3, zzauy zzauyVar, zzatb zzatbVar) {
        zzauo zzauoVar = (zzauo) zzauyVar;
        int iZza = zza(bArr, i2, zzatbVar);
        zzauoVar.zzh(zzatbVar.zza);
        while (iZza < i3) {
            int iZza2 = zza(bArr, iZza, zzatbVar);
            if (i != zzatbVar.zza) {
                break;
            }
            iZza = zza(bArr, iZza2, zzatbVar);
            zzauoVar.zzh(zzatbVar.zza);
        }
        return iZza;
    }

    static int zzl(byte[] bArr, int i, zzauy zzauyVar, zzatb zzatbVar) throws IOException {
        zzauo zzauoVar = (zzauo) zzauyVar;
        int iZza = zza(bArr, i, zzatbVar);
        int i2 = zzatbVar.zza + iZza;
        while (iZza < i2) {
            iZza = zza(bArr, iZza, zzatbVar);
            zzauoVar.zzh(zzatbVar.zza);
        }
        if (iZza == i2) {
            return iZza;
        }
        throw new zzavb("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    static int zzm(zzawn zzawnVar, int i, byte[] bArr, int i2, int i3, zzauy zzauyVar, zzatb zzatbVar) throws IOException {
        int iZzg = zzg(zzawnVar, bArr, i2, i3, zzatbVar);
        zzauyVar.add(zzatbVar.zzc);
        while (iZzg < i3) {
            int iZza = zza(bArr, iZzg, zzatbVar);
            if (i != zzatbVar.zza) {
                break;
            }
            iZzg = zzg(zzawnVar, bArr, iZza, i3, zzatbVar);
            zzauyVar.add(zzatbVar.zzc);
        }
        return iZzg;
    }

    static int zzn(int i, byte[] bArr, int i2, int i3, zzaxb zzaxbVar, zzatb zzatbVar) throws zzavb {
        if ((i >>> 3) == 0) {
            throw new zzavb("Protocol message contained an invalid tag (zero).");
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int iZzc = zzc(bArr, i2, zzatbVar);
            zzaxbVar.zzk(i, Long.valueOf(zzatbVar.zzb));
            return iZzc;
        }
        if (i4 == 1) {
            zzaxbVar.zzk(i, Long.valueOf(zze(bArr, i2)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int iZza = zza(bArr, i2, zzatbVar);
            int i5 = zzatbVar.zza;
            if (i5 < 0) {
                throw new zzavb("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            }
            if (i5 > bArr.length - iZza) {
                throw new zzavb("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            if (i5 == 0) {
                zzaxbVar.zzk(i, zzatl.zza);
            } else {
                zzaxbVar.zzk(i, zzatl.zzr(bArr, iZza, i5));
            }
            return iZza + i5;
        }
        if (i4 != 3) {
            if (i4 != 5) {
                throw new zzavb("Protocol message contained an invalid tag (zero).");
            }
            zzaxbVar.zzk(i, Integer.valueOf(zzd(bArr, i2)));
            return i2 + 4;
        }
        int i6 = (i & (-8)) | 4;
        zzaxb zzaxbVarZzb = zzaxb.zzb();
        int i7 = zzatbVar.zze + 1;
        zzatbVar.zze = i7;
        zzo(i7);
        int i8 = 0;
        while (i2 < i3) {
            int iZza2 = zza(bArr, i2, zzatbVar);
            int i9 = zzatbVar.zza;
            if (i9 == i6) {
                i8 = i9;
                i2 = iZza2;
                break;
            }
            i2 = zzn(i9, bArr, iZza2, i3, zzaxbVarZzb, zzatbVar);
            i8 = i9;
        }
        zzatbVar.zze--;
        if (i2 > i3 || i8 != i6) {
            throw new zzavb("Failed to parse the message.");
        }
        zzaxbVar.zzk(i, zzaxbVarZzb);
        return i2;
    }

    private static void zzo(int i) throws zzavb {
        if (i >= zzb) {
            throw new zzavb("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
    }
}
