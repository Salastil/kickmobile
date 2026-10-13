package com.google.android.gms.internal.pal;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zztc extends RuntimeException {
    private zztc(String str, String str2) {
        super(str);
    }

    public static zztc zza(String str, String str2, int i, int i2) {
        return new zztc(zze(str, str2, i, i2), str2);
    }

    public static zztc zzb(String str, String str2, int i) {
        return new zztc(zze(str, str2, i, i + 1), str2);
    }

    public static zztc zzc(String str, String str2, int i) {
        return new zztc(zze(str, str2, i, -1), str2);
    }

    public static zztc zzd(String str, String str2) {
        return new zztc(str, str2);
    }

    private static String zze(String str, String str2, int i, int i2) {
        if (i2 < 0) {
            i2 = str2.length();
        }
        StringBuilder sb = new StringBuilder(str);
        sb.append(": ");
        if (i > 8) {
            sb.append("...");
            sb.append((CharSequence) str2, i - 5, i);
        } else {
            sb.append((CharSequence) str2, 0, i);
        }
        sb.append(AbstractJsonLexerKt.BEGIN_LIST);
        sb.append(str2.substring(i, i2));
        sb.append(AbstractJsonLexerKt.END_LIST);
        if (str2.length() - i2 > 8) {
            sb.append((CharSequence) str2, i2, i2 + 5);
            sb.append("...");
        } else {
            sb.append((CharSequence) str2, i2, str2.length());
        }
        return sb.toString();
    }

    @Override // java.lang.Throwable
    public final synchronized Throwable fillInStackTrace() {
        return this;
    }
}
