package com.google.android.gms.internal.pal;

import java.util.logging.Level;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public abstract class zzpc extends zzpn implements zzpw {
    protected zzpc(Level level, boolean z) {
        super(level, false);
    }

    @Override // com.google.android.gms.internal.pal.zzpn
    protected final zztb zza() {
        return zzsz.zza();
    }

    @Override // com.google.android.gms.internal.pal.zzpn
    protected final boolean zzb(zzpr zzprVar) {
        zzqx zzqxVarZzl = zzl();
        int iZza = zzqxVarZzl.zza();
        for (int i = 0; i < iZza; i++) {
            if (zzqxVarZzl.zzb(i).zzd() == "eye3tag") {
                if (zzqxVarZzl.zzd(zzpl.zza) != null) {
                    break;
                }
                zzpz zzpzVar = zzpl.zzi;
                if (zzqxVarZzl.zzd(zzpzVar) != null) {
                    break;
                }
                zzm(zzpzVar, zzqj.SMALL);
                break;
            }
        }
        return super.zzb(zzprVar);
    }
}
