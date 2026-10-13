package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.common.base.Ascii;
import io.ktor.util.date.GMTDateParser;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public abstract class zzbd {
    private static final char[] zza = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', GMTDateParser.DAY_OF_MONTH, 'e', 'f'};

    public final int hashCode() {
        if (zzb() >= 32) {
            return zza();
        }
        byte[] bArrZzd = zzd();
        int i = bArrZzd[0] & 255;
        for (int i2 = 1; i2 < bArrZzd.length; i2++) {
            i |= (bArrZzd[i2] & 255) << (i2 << 3);
        }
        return i;
    }

    public abstract int zza();

    abstract boolean zza(zzbd zzbdVar);

    public abstract int zzb();

    public abstract byte[] zzc();

    static zzbd zza(byte[] bArr) {
        return new zzbg(bArr);
    }

    public final String toString() {
        byte[] bArrZzd = zzd();
        StringBuilder sb = new StringBuilder(bArrZzd.length * 2);
        for (byte b : bArrZzd) {
            char[] cArr = zza;
            sb.append(cArr[(b >> 4) & 15]);
            sb.append(cArr[b & Ascii.SI]);
        }
        return sb.toString();
    }

    zzbd() {
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzbd) {
            zzbd zzbdVar = (zzbd) obj;
            if (zzb() == zzbdVar.zzb() && zza(zzbdVar)) {
                return true;
            }
        }
        return false;
    }

    byte[] zzd() {
        return zzc();
    }
}
