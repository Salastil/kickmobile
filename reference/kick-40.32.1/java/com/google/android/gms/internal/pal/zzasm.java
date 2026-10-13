package com.google.android.gms.internal.pal;

import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzasm {
    public static BigDecimal zza(String str) throws NumberFormatException {
        zzc(str);
        BigDecimal bigDecimal = new BigDecimal(str);
        if (Math.abs(bigDecimal.scale()) < 10000) {
            return bigDecimal;
        }
        String.valueOf(str);
        throw new NumberFormatException("Number has unsupported scale: ".concat(String.valueOf(str)));
    }

    public static BigInteger zzb(String str) throws NumberFormatException {
        zzc(str);
        return new BigInteger(str);
    }

    private static void zzc(String str) {
        if (str.length() <= 10000) {
            return;
        }
        String strSubstring = str.substring(0, 30);
        StringBuilder sb = new StringBuilder(String.valueOf(strSubstring).length() + 28);
        sb.append("Number string too large: ");
        sb.append(strSubstring);
        sb.append("...");
        throw new NumberFormatException(sb.toString());
    }
}
