package com.google.android.gms.internal.measurement;

import java.util.logging.Level;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public abstract class zzxo extends zzxz implements zzyi {
    protected zzxo(Level level, boolean z) {
        super(level, false);
    }

    @Override // com.google.android.gms.internal.measurement.zzxz
    protected final zzabn zza() {
        return zzabl.zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzxz
    protected final boolean zzb(zzyd zzydVar) {
        zzzj zzzjVarZzl = zzl();
        int iZza = zzzjVarZzl.zza();
        for (int i = 0; i < iZza; i++) {
            if (zzzjVarZzl.zzb(i).zzd() == "eye3tag") {
                if (zzzjVarZzl.zzd(zzxx.zza) != null) {
                    break;
                }
                zzyl zzylVar = zzxx.zzi;
                if (zzzjVarZzl.zzd(zzylVar) != null) {
                    break;
                }
                zzm(zzylVar, zzyv.SMALL);
                break;
            }
        }
        return super.zzb(zzydVar);
    }
}
