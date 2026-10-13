package com.google.android.gms.internal.pal;

import io.ktor.util.date.GMTDateParser;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public enum zzqn {
    STRING(GMTDateParser.SECONDS, zzqp.GENERAL, "-#", true),
    BOOLEAN('b', zzqp.BOOLEAN, "-", true),
    CHAR('c', zzqp.CHARACTER, "-", true),
    DECIMAL(GMTDateParser.DAY_OF_MONTH, zzqp.INTEGRAL, "-0+ ,(", false),
    OCTAL('o', zzqp.INTEGRAL, "-#0(", false),
    HEX('x', zzqp.INTEGRAL, "-#0(", true),
    FLOAT('f', zzqp.FLOAT, "-#0+ ,(", false),
    EXPONENT('e', zzqp.FLOAT, "-#0+ (", true),
    GENERAL('g', zzqp.FLOAT, "-0+ ,(", true),
    EXPONENT_HEX('a', zzqp.FLOAT, "-#0+ ", true);

    private static final zzqn[] zzk = new zzqn[26];
    private final char zzl;
    private final zzqp zzm;
    private final int zzn;
    private final String zzo;

    static {
        for (zzqn zzqnVar : values()) {
            zzk[zzf(zzqnVar.zzl)] = zzqnVar;
        }
    }

    zzqn(char c, zzqp zzqpVar, String str, boolean z) {
        this.zzl = c;
        this.zzm = zzqpVar;
        this.zzn = zzqo.zzc(str, z);
        StringBuilder sb = new StringBuilder(String.valueOf(c).length() + 1);
        sb.append("%");
        sb.append(c);
        this.zzo = sb.toString();
    }

    public static zzqn zza(char c) {
        zzqn zzqnVar = zzk[zzf(c)];
        if ((c & ' ') == 0 && (zzqnVar == null || (zzqnVar.zzn & 128) == 0)) {
            return null;
        }
        return zzqnVar;
    }

    private static int zzf(char c) {
        return (c | ' ') - 97;
    }

    public final char zzb() {
        return this.zzl;
    }

    public final zzqp zzc() {
        return this.zzm;
    }

    final int zzd() {
        return this.zzn;
    }

    public final String zze() {
        return this.zzo;
    }
}
