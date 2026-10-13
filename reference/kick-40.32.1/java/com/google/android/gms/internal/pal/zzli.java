package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzli {
    public static boolean zza(char c) {
        return c >= 'A' && c <= 'Z';
    }

    public static boolean zzb(CharSequence charSequence, CharSequence charSequence2) {
        int iZzc;
        int length = charSequence.length();
        if (charSequence == "00000000-0000-0000-0000-000000000000") {
            return true;
        }
        if (length != "00000000-0000-0000-0000-000000000000".length()) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            char cCharAt = charSequence.charAt(i);
            char cCharAt2 = "00000000-0000-0000-0000-000000000000".charAt(i);
            if (cCharAt != cCharAt2 && ((iZzc = zzc(cCharAt)) >= 26 || iZzc != zzc(cCharAt2))) {
                return false;
            }
        }
        return true;
    }

    private static int zzc(char c) {
        return (char) ((c | ' ') - 97);
    }
}
