package com.google.android.gms.internal.pal;

import java.util.Set;
import java.util.logging.Level;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzsf extends zzru {
    private final String zza;
    private final Level zzb;
    private final Set zzc;
    private final zzre zzd;
    private final int zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzsf(String str, String str2, boolean z, int i, boolean z2, boolean z3) {
        super(str2);
        Level level = Level.ALL;
        int i2 = zzsg.zza;
        this.zza = "";
        this.zze = 2;
        this.zzb = level;
        this.zzc = zzsg.zzb;
        this.zzd = zzsg.zzc;
    }

    @Override // com.google.android.gms.internal.pal.zzqt
    public final boolean zzb(Level level) {
        return true;
    }

    @Override // com.google.android.gms.internal.pal.zzqt
    public final void zzc(zzqr zzqrVar) {
        String strZza = (String) zzqrVar.zzl().zzd(zzqk.zza);
        if (strZza == null) {
            strZza = zza();
        }
        if (strZza == null) {
            strZza = zzqrVar.zzg().zza();
            int iIndexOf = strZza.indexOf(36, strZza.lastIndexOf(46));
            if (iIndexOf >= 0) {
                strZza = strZza.substring(0, iIndexOf);
            }
        }
        String str = this.zza;
        zzsg.zzi(zzqrVar, zzrz.zza(str, strZza, true), 2, this.zzb, this.zzc, this.zzd);
    }
}
