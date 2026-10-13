package com.google.android.gms.internal.p002firebaseauthapi;

import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
abstract class zzaoh {
    protected static int zzb(String str, byte[] bArr, int i, int i2) {
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        if (bytes.length - i > i2) {
            throw new ArrayIndexOutOfBoundsException("Not enough space in output buffer to encode UTF-8 string");
        }
        System.arraycopy(bytes, 0, bArr, i, bytes.length);
        return i + bytes.length;
    }

    abstract int zza(String str, byte[] bArr, int i, int i2);

    abstract String zza(byte[] bArr, int i, int i2) throws zzamd;

    static int zza(String str) {
        int length = str.length();
        int i = 0;
        while (i < length && str.charAt(i) < 128) {
            i++;
        }
        int iZza = length;
        while (i < length) {
            char cCharAt = str.charAt(i);
            if (cCharAt >= 2048) {
                try {
                    iZza += zzaog.zza(str, i);
                    break;
                } catch (zzaok unused) {
                    return str.getBytes(StandardCharsets.UTF_8).length;
                }
            }
            iZza += (127 - cCharAt) >>> 31;
            i++;
        }
        if (iZza >= length) {
            return iZza;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) iZza) + 4294967296L));
    }

    zzaoh() {
    }
}
