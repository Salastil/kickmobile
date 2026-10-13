package com.google.android.gms.internal.pal;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzawa implements zzawn {
    private final zzavw zza;
    private final zzaxa zzb;
    private final boolean zzc;
    private final zzatz zzd;

    private zzawa(zzaxa zzaxaVar, zzatz zzatzVar, zzavw zzavwVar) {
        this.zzb = zzaxaVar;
        this.zzc = zzavwVar instanceof zzauk;
        this.zzd = zzatzVar;
        this.zza = zzavwVar;
    }

    static zzawa zzh(zzaxa zzaxaVar, zzatz zzatzVar, zzavw zzavwVar) {
        return new zzawa(zzaxaVar, zzatzVar, zzavwVar);
    }

    @Override // com.google.android.gms.internal.pal.zzawn
    public final Object zza() {
        zzavw zzavwVar = this.zza;
        return zzavwVar instanceof zzaun ? ((zzaun) zzavwVar).zzav() : zzavwVar.zzaO().zzao();
    }

    @Override // com.google.android.gms.internal.pal.zzawn
    public final boolean zzb(Object obj, Object obj2) {
        if (!((zzaun) obj).zzc.equals(((zzaun) obj2).zzc)) {
            return false;
        }
        if (this.zzc) {
            return ((zzauk) obj).zza.equals(((zzauk) obj2).zza);
        }
        return true;
    }

    @Override // com.google.android.gms.internal.pal.zzawn
    public final int zzc(Object obj) {
        int iHashCode = ((zzaun) obj).zzc.hashCode();
        return this.zzc ? (iHashCode * 53) + ((zzauk) obj).zza.zza.hashCode() : iHashCode;
    }

    @Override // com.google.android.gms.internal.pal.zzawn
    public final void zzd(Object obj, Object obj2) {
        zzawp.zzE(this.zzb, obj, obj2);
        if (this.zzc) {
            zzawp.zzD(this.zzd, obj, obj2);
        }
    }

    @Override // com.google.android.gms.internal.pal.zzawn
    public final int zze(Object obj) {
        int iZzh = ((zzaun) obj).zzc.zzh();
        return this.zzc ? iZzh + ((zzauk) obj).zza.zzf() : iZzh;
    }

    @Override // com.google.android.gms.internal.pal.zzawn
    public final void zzf(Object obj, zzaxp zzaxpVar) throws IOException {
        Iterator itZzc = ((zzauk) obj).zza.zzc();
        while (itZzc.hasNext()) {
            Map.Entry entry = (Map.Entry) itZzc.next();
            zzauc zzaucVar = (zzauc) entry.getKey();
            if (zzaucVar.zzc() != zzaxo.MESSAGE || zzaucVar.zzd() || zzaucVar.zze()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            if (entry instanceof zzave) {
                zzaxpVar.zzv(zzaucVar.zza(), ((zzave) entry).zza().zzc());
            } else {
                zzaxpVar.zzv(zzaucVar.zza(), entry.getValue());
            }
        }
        ((zzaun) obj).zzc.zzf(zzaxpVar);
    }

    @Override // com.google.android.gms.internal.pal.zzawn
    public final void zzg(Object obj, zzawi zzawiVar, zzaty zzatyVar) throws IOException {
        this.zzb.zzh(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.pal.zzawn
    public final void zzj(Object obj, byte[] bArr, int i, int i2, zzatb zzatbVar) throws IOException {
        zzaun zzaunVar = (zzaun) obj;
        if (zzaunVar.zzc == zzaxb.zza()) {
            zzaunVar.zzc = zzaxb.zzb();
        }
        throw null;
    }

    @Override // com.google.android.gms.internal.pal.zzawn
    public final void zzk(Object obj) {
        this.zzb.zzj(obj);
        this.zzd.zza(obj);
    }

    @Override // com.google.android.gms.internal.pal.zzawn
    public final boolean zzl(Object obj) {
        return ((zzauk) obj).zza.zze();
    }
}
