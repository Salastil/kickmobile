package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzafg implements zzafp {
    private final zzafc zza;
    private final zzafz zzb;
    private final boolean zzc;
    private final zzadg zzd;

    private zzafg(zzafz zzafzVar, zzadg zzadgVar, zzafc zzafcVar) {
        this.zzb = zzafzVar;
        this.zzc = zzafcVar instanceof zzadr;
        this.zzd = zzadgVar;
        this.zza = zzafcVar;
    }

    static zzafg zzh(zzafz zzafzVar, zzadg zzadgVar, zzafc zzafcVar) {
        return new zzafg(zzafzVar, zzadgVar, zzafcVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzafp
    public final Object zza() {
        zzafc zzafcVar = this.zza;
        return zzafcVar instanceof zzadu ? ((zzadu) zzafcVar).zzck() : zzafcVar.zzcI().zzbg();
    }

    @Override // com.google.android.gms.internal.measurement.zzafp
    public final boolean zzb(Object obj, Object obj2) {
        if (!((zzadu) obj).zzc.equals(((zzadu) obj2).zzc)) {
            return false;
        }
        if (this.zzc) {
            return ((zzadr) obj).zzb.equals(((zzadr) obj2).zzb);
        }
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzafp
    public final int zzc(Object obj) {
        int iHashCode = ((zzadu) obj).zzc.hashCode();
        return this.zzc ? (iHashCode * 53) + ((zzadr) obj).zzb.zza.hashCode() : iHashCode;
    }

    @Override // com.google.android.gms.internal.measurement.zzafp
    public final void zzd(Object obj, Object obj2) {
        zzafq.zzE(this.zzb, obj, obj2);
        if (this.zzc) {
            zzafq.zzD(this.zzd, obj, obj2);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzafp
    public final int zze(Object obj) {
        int iZzh = ((zzadu) obj).zzc.zzh();
        return this.zzc ? iZzh + ((zzadr) obj).zzb.zzg() : iZzh;
    }

    @Override // com.google.android.gms.internal.measurement.zzafp
    public final void zzf(Object obj, zzago zzagoVar) throws IOException {
        Iterator itZzc = ((zzadr) obj).zzb.zzc();
        while (itZzc.hasNext()) {
            Map.Entry entry = (Map.Entry) itZzc.next();
            zzadj zzadjVar = (zzadj) entry.getKey();
            if (zzadjVar.zzc() != zzagn.MESSAGE || zzadjVar.zzd() || zzadjVar.zze()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            if (entry instanceof zzaej) {
                zzagoVar.zzv(zzadjVar.zza(), ((zzaej) entry).zza().zzc());
            } else {
                zzagoVar.zzv(zzadjVar.zza(), entry.getValue());
            }
        }
        ((zzadu) obj).zzc.zzf(zzagoVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzafp
    public final void zzg(Object obj, zzafo zzafoVar, zzadf zzadfVar) throws IOException {
        this.zzb.zzh(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzafp
    public final void zzj(Object obj, byte[] bArr, int i, int i2, zzacg zzacgVar) throws IOException {
        zzadu zzaduVar = (zzadu) obj;
        if (zzaduVar.zzc == zzaga.zza()) {
            zzaduVar.zzc = zzaga.zzb();
        }
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzafp
    public final void zzk(Object obj) {
        this.zzb.zzj(obj);
        this.zzd.zza(obj);
    }

    @Override // com.google.android.gms.internal.measurement.zzafp
    public final boolean zzl(Object obj) {
        return ((zzadr) obj).zzb.zze();
    }
}
