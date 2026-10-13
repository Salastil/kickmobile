package com.google.android.gms.internal.pal;

import android.util.Log;
import io.ktor.sse.ServerSentEventKt;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzsg extends zzru {
    public static final /* synthetic */ int zza = 0;
    private static final Set zzb;
    private static final zzre zzc;
    private static final zzse zzd;
    private final String zze;
    private final Level zzf;
    private final Set zzg;
    private final zzre zzh;
    private final int zzi;

    static {
        Set setUnmodifiableSet = Collections.unmodifiableSet(new HashSet(Arrays.asList(zzpl.zza, zzqk.zza, zzql.zza)));
        zzb = setUnmodifiableSet;
        zzc = zzrh.zza(setUnmodifiableSet).zzc();
        zzd = new zzse(null);
    }

    /* synthetic */ zzsg(String str, String str2, boolean z, int i, Level level, Set set, zzre zzreVar, byte[] bArr) {
        super(str2);
        this.zze = zzrz.zza("", str2, true);
        this.zzi = 2;
        this.zzf = level;
        this.zzg = set;
        this.zzh = zzreVar;
    }

    public static zzse zze() {
        return zzd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:21:0x005b  */
    /* JADX WARN: Code duplicated, block: B:23:0x006a  */
    /* JADX WARN: Code duplicated, block: B:28:0x0088  */
    public static void zzi(zzqr zzqrVar, String str, int i, Level level, Set set, zzre zzreVar) {
        StringBuilder sb;
        String string;
        Boolean bool = (Boolean) zzqrVar.zzl().zzd(zzql.zza);
        if (bool == null || !bool.booleanValue()) {
            zzro zzroVarZzh = zzro.zzh(zzrr.zzj(), zzqrVar.zzl());
            boolean z = zzqrVar.zze().intValue() < level.intValue();
            if (z) {
                sb = new StringBuilder();
                if (zzqs.zza(2, zzqrVar.zzg(), sb)) {
                    sb.append(ServerSentEventKt.SPACE);
                }
                if (z) {
                    zzqm.zza(zzqrVar, sb);
                    int i2 = zzrs.zza;
                    zzqq zzqqVar = new zzqq("[CONTEXT ", " ]", sb);
                    zzroVarZzh.zza(zzreVar, zzqqVar);
                    zzqqVar.zzb();
                } else {
                    zzqm.zza(zzqrVar, sb);
                    int i3 = zzrs.zza;
                    zzqq zzqqVar2 = new zzqq("[CONTEXT ", " ]", sb);
                    zzroVarZzh.zza(zzreVar, zzqqVar2);
                    zzqqVar2.zzb();
                }
                string = sb.toString();
            } else {
                int i4 = zzrs.zza;
                if (zzqrVar.zzh() == null && zzroVarZzh.zzb() <= set.size() && set.containsAll(zzroVarZzh.zzc())) {
                    string = zzqv.zza(zzqrVar.zzj());
                } else {
                    sb = new StringBuilder();
                    if (zzqs.zza(2, zzqrVar.zzg(), sb)) {
                        sb.append(ServerSentEventKt.SPACE);
                    }
                    if (z || zzqrVar.zzh() == null) {
                        zzqm.zza(zzqrVar, sb);
                        int i5 = zzrs.zza;
                        zzqq zzqqVar3 = new zzqq("[CONTEXT ", " ]", sb);
                        zzroVarZzh.zza(zzreVar, zzqqVar3);
                        zzqqVar3.zzb();
                    } else {
                        sb.append("(REDACTED) ");
                        sb.append(zzqrVar.zzh().zzb());
                    }
                    string = sb.toString();
                }
            }
            Throwable th = (Throwable) zzqrVar.zzl().zzd(zzpl.zza);
            int iZzb = zzrz.zzb(zzqrVar.zze());
            if (iZzb == 2) {
                Log.v(str, string, th);
                return;
            }
            if (iZzb == 3) {
                Log.d(str, string, th);
                return;
            }
            if (iZzb == 4) {
                Log.i(str, string, th);
            } else if (iZzb != 5) {
                Log.e(str, string, th);
            } else {
                Log.w(str, string, th);
            }
        }
    }

    @Override // com.google.android.gms.internal.pal.zzqt
    public final boolean zzb(Level level) {
        String str = this.zze;
        int iZzb = zzrz.zzb(level);
        return Log.isLoggable(str, iZzb) || Log.isLoggable("all", iZzb);
    }

    @Override // com.google.android.gms.internal.pal.zzqt
    public final void zzc(zzqr zzqrVar) {
        zzi(zzqrVar, this.zze, 2, this.zzf, this.zzg, this.zzh);
    }
}
