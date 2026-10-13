package com.google.android.gms.internal.measurement;

import io.ktor.util.date.GMTDateParser;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public enum zzyz {
    STRING(GMTDateParser.SECONDS, zzzb.GENERAL, "-#", true),
    BOOLEAN('b', zzzb.BOOLEAN, "-", true),
    CHAR('c', zzzb.CHARACTER, "-", true),
    DECIMAL(GMTDateParser.DAY_OF_MONTH, zzzb.INTEGRAL, "-0+ ,(", false),
    OCTAL('o', zzzb.INTEGRAL, "-#0(", false),
    HEX('x', zzzb.INTEGRAL, "-#0(", true),
    FLOAT('f', zzzb.FLOAT, "-#0+ ,(", false),
    EXPONENT('e', zzzb.FLOAT, "-#0+ (", true),
    GENERAL('g', zzzb.FLOAT, "-0+ ,(", true),
    EXPONENT_HEX('a', zzzb.FLOAT, "-#0+ ", true);

    private static final zzyz[] zzk = new zzyz[26];
    private final char zzl;
    private final zzzb zzm;
    private final int zzn;
    private final String zzo;

    static {
        for (zzyz zzyzVar : values()) {
            zzk[zzf(zzyzVar.zzl)] = zzyzVar;
        }
    }

    zzyz(char c, zzzb zzzbVar, String str, boolean z) {
        this.zzl = c;
        this.zzm = zzzbVar;
        this.zzn = zzza.zzc(str, z);
        StringBuilder sb = new StringBuilder(String.valueOf(c).length() + 1);
        sb.append("%");
        sb.append(c);
        this.zzo = sb.toString();
    }

    public static zzyz zza(char c) {
        zzyz zzyzVar = zzk[zzf(c)];
        if ((c & ' ') == 0 && (zzyzVar == null || (zzyzVar.zzn & 128) == 0)) {
            return null;
        }
        return zzyzVar;
    }

    private static int zzf(char c) {
        return (c | ' ') - 97;
    }

    public final char zzb() {
        return this.zzl;
    }

    public final zzzb zzc() {
        return this.zzm;
    }

    final int zzd() {
        return this.zzn;
    }

    public final String zze() {
        return this.zzo;
    }
}
