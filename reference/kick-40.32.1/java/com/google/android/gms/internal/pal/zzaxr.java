package com.google.android.gms.internal.pal;

import java.lang.reflect.Method;
import javax.annotation.Nullable;
import org.threeten.bp.Year;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzaxr {
    public static final /* synthetic */ int zza = 0;

    static {
        zzawx zzawxVarZzc = zzawy.zzc();
        zzawxVarZzc.zza(-62135596800L);
        zzawxVarZzc.zzb(0);
        zzawx zzawxVarZzc2 = zzawy.zzc();
        zzawxVarZzc2.zza(253402300799L);
        zzawxVarZzc2.zzb(Year.MAX_VALUE);
        zzawx zzawxVarZzc3 = zzawy.zzc();
        zzawxVarZzc3.zza(0L);
        zzawxVarZzc3.zzb(0);
        new zzaxq();
        zzc("now");
        zzc("getEpochSecond");
        zzc("getNano");
    }

    public static zzawy zza(long j) {
        long jAddExact = j / 1000;
        if (!zzb(jAddExact)) {
            StringBuilder sb = new StringBuilder(String.valueOf(jAddExact).length() + 117);
            sb.append("Timestamp is not valid. Input seconds is too large. Seconds (");
            sb.append(jAddExact);
            sb.append(") must be in range [-62,135,596,800, +253,402,300,799]. ");
            throw new IllegalArgumentException(sb.toString());
        }
        int i = (int) ((j % 1000) * 1000000);
        if (i <= -1000000000 || i >= 1000000000) {
            jAddExact = Math.addExact(jAddExact, i / 1000000000);
            i %= 1000000000;
        }
        if (i < 0) {
            i += 1000000000;
            jAddExact = Math.subtractExact(jAddExact, 1L);
        }
        zzawx zzawxVarZzc = zzawy.zzc();
        zzawxVarZzc.zza(jAddExact);
        zzawxVarZzc.zzb(i);
        zzawy zzawyVar = (zzawy) zzawxVarZzc.zzal();
        long jZza = zzawyVar.zza();
        int iZzb = zzawyVar.zzb();
        if (zzb(jZza) && iZzb >= 0 && iZzb < 1000000000) {
            return zzawyVar;
        }
        StringBuilder sb2 = new StringBuilder(String.valueOf(jZza).length() + 135 + String.valueOf(iZzb).length() + 37);
        sb2.append("Timestamp is not valid. See proto definition for valid values. Seconds (");
        sb2.append(jZza);
        sb2.append(") must be in range [-62,135,596,800, +253,402,300,799]. Nanos (");
        sb2.append(iZzb);
        sb2.append(") must be in range [0, +999,999,999].");
        throw new IllegalArgumentException(sb2.toString());
    }

    private static boolean zzb(long j) {
        return j >= -62135596800L && j <= 253402300799L;
    }

    @Nullable
    private static Method zzc(String str) {
        try {
            return Class.forName("java.time.Instant").getMethod(str, null);
        } catch (Exception unused) {
            return null;
        }
    }
}
