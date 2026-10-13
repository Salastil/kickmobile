package com.google.android.gms.internal.cast;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzzm implements zzzs {
    private final zzzi zza;
    private final zzaad zzb;
    private final boolean zzc;
    private final zzxs zzd;

    private zzzm(zzaad zzaadVar, zzxs zzxsVar, zzzi zzziVar) {
        this.zzb = zzaadVar;
        this.zzc = zzziVar instanceof zzyb;
        this.zzd = zzxsVar;
        this.zza = zzziVar;
    }

    static zzzm zzi(zzaad zzaadVar, zzxs zzxsVar, zzzi zzziVar) {
        return new zzzm(zzaadVar, zzxsVar, zzziVar);
    }

    @Override // com.google.android.gms.internal.cast.zzzs
    public final Object zza() {
        zzzi zzziVar = this.zza;
        return zzziVar instanceof zzyd ? ((zzyd) zzziVar).zzy() : zzziVar.zzO().zzw();
    }

    @Override // com.google.android.gms.internal.cast.zzzs
    public final boolean zzb(Object obj, Object obj2) {
        if (!((zzyd) obj).zzc.equals(((zzyd) obj2).zzc)) {
            return false;
        }
        if (this.zzc) {
            return ((zzyb) obj).zzb.equals(((zzyb) obj2).zzb);
        }
        return true;
    }

    @Override // com.google.android.gms.internal.cast.zzzs
    public final int zzc(Object obj) {
        int iHashCode = ((zzyd) obj).zzc.hashCode();
        return this.zzc ? (iHashCode * 53) + ((zzyb) obj).zzb.zza.hashCode() : iHashCode;
    }

    @Override // com.google.android.gms.internal.cast.zzzs
    public final void zzd(Object obj, Object obj2) {
        zzzu.zzE(this.zzb, obj, obj2);
        if (this.zzc) {
            zzzu.zzD(this.zzd, obj, obj2);
        }
    }

    @Override // com.google.android.gms.internal.cast.zzzs
    public final int zze(Object obj) {
        int iZze = ((zzyd) obj).zzc.zze();
        return this.zzc ? iZze + ((zzyb) obj).zzb.zzf() : iZze;
    }

    @Override // com.google.android.gms.internal.cast.zzzs
    public final void zzf(Object obj, zzaap zzaapVar) throws IOException {
        Iterator itZzc = ((zzyb) obj).zzb.zzc();
        while (itZzc.hasNext()) {
            Map.Entry entry = (Map.Entry) itZzc.next();
            zzxv zzxvVar = (zzxv) entry.getKey();
            if (zzxvVar.zzc() != zzaao.MESSAGE || zzxvVar.zzd() || zzxvVar.zze()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            if (entry instanceof zzyq) {
                zzaapVar.zzt(zzxvVar.zza(), ((zzyq) entry).zza().zzc());
            } else {
                zzaapVar.zzt(zzxvVar.zza(), entry.getValue());
            }
        }
        ((zzyd) obj).zzc.zzd(zzaapVar);
    }

    @Override // com.google.android.gms.internal.cast.zzzs
    public final void zzg(Object obj) {
        this.zzb.zza(obj);
        this.zzd.zza(obj);
    }

    @Override // com.google.android.gms.internal.cast.zzzs
    public final boolean zzh(Object obj) {
        return ((zzyb) obj).zzb.zze();
    }
}
