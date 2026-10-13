package com.google.android.gms.internal.measurement;

import com.google.common.base.Function;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final /* synthetic */ class zzqp implements Function {
    static final /* synthetic */ zzqp zza = new zzqp();

    private /* synthetic */ zzqp() {
    }

    @Override // com.google.common.base.Function
    public final /* synthetic */ Object apply(Object obj) {
        zzmg zzmgVar = (zzmg) obj;
        zzqu zzquVarZzh = zzqv.zzh();
        if (zzmgVar == null) {
            return (zzqv) zzquVarZzh.zzbd();
        }
        for (zzmi zzmiVar : zzmgVar.zze()) {
            zzqw zzqwVarZzh = zzqx.zzh();
            zzqwVarZzh.zza(zzmiVar.zza());
            int iZzq = zzmiVar.zzq();
            int i = iZzq - 1;
            if (iZzq == 0) {
                throw null;
            }
            if (i == 0) {
                zzqwVarZzh.zzb(zzmiVar.zzb());
            } else if (i == 1) {
                zzqwVarZzh.zzc(zzmiVar.zzc());
            } else if (i == 2) {
                zzqwVarZzh.zzd(zzmiVar.zzd());
            } else if (i == 3) {
                zzqwVarZzh.zze(zzmiVar.zze());
            } else {
                if (i != 4) {
                    throw new IllegalStateException("No known flag type");
                }
                zzqwVarZzh.zzf(zzmiVar.zzf());
            }
            zzquVarZzh.zze((zzqx) zzqwVarZzh.zzbd());
        }
        zzquVarZzh.zzc(zzmgVar.zzd());
        zzquVarZzh.zza(zzmgVar.zza());
        zzquVarZzh.zzd(zzmgVar.zzf());
        if (zzmgVar.zzb()) {
            zzquVarZzh.zzb(zzmgVar.zzc());
        }
        return (zzqv) zzquVarZzh.zzbd();
    }
}
