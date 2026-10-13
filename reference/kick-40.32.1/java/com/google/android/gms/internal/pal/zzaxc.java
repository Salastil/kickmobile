package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzaxc extends zzaxa {
    zzaxc() {
    }

    @Override // com.google.android.gms.internal.pal.zzaxa
    final /* bridge */ /* synthetic */ void zza(Object obj, int i, long j) {
        ((zzaxb) obj).zzk(i << 3, Long.valueOf(j));
    }

    @Override // com.google.android.gms.internal.pal.zzaxa
    final /* bridge */ /* synthetic */ void zzb(Object obj, int i, int i2) {
        ((zzaxb) obj).zzk((i << 3) | 5, Integer.valueOf(i2));
    }

    @Override // com.google.android.gms.internal.pal.zzaxa
    final /* bridge */ /* synthetic */ void zzc(Object obj, int i, long j) {
        ((zzaxb) obj).zzk((i << 3) | 1, Long.valueOf(j));
    }

    @Override // com.google.android.gms.internal.pal.zzaxa
    final /* bridge */ /* synthetic */ void zzd(Object obj, int i, zzatl zzatlVar) {
        ((zzaxb) obj).zzk((i << 3) | 2, zzatlVar);
    }

    @Override // com.google.android.gms.internal.pal.zzaxa
    final /* bridge */ /* synthetic */ void zze(Object obj, int i, Object obj2) {
        ((zzaxb) obj).zzk((i << 3) | 3, (zzaxb) obj2);
    }

    @Override // com.google.android.gms.internal.pal.zzaxa
    final /* synthetic */ Object zzf() {
        return zzaxb.zzb();
    }

    @Override // com.google.android.gms.internal.pal.zzaxa
    final /* synthetic */ Object zzg(Object obj) {
        zzaxb zzaxbVar = (zzaxb) obj;
        zzaxbVar.zzd();
        return zzaxbVar;
    }

    @Override // com.google.android.gms.internal.pal.zzaxa
    final /* bridge */ /* synthetic */ Object zzh(Object obj) {
        zzaun zzaunVar = (zzaun) obj;
        zzaxb zzaxbVar = zzaunVar.zzc;
        if (zzaxbVar != zzaxb.zza()) {
            return zzaxbVar;
        }
        zzaxb zzaxbVarZzb = zzaxb.zzb();
        zzaunVar.zzc = zzaxbVarZzb;
        return zzaxbVarZzb;
    }

    @Override // com.google.android.gms.internal.pal.zzaxa
    final /* synthetic */ void zzi(Object obj, Object obj2) {
        ((zzaun) obj).zzc = (zzaxb) obj2;
    }

    @Override // com.google.android.gms.internal.pal.zzaxa
    final void zzj(Object obj) {
        ((zzaun) obj).zzc.zzd();
    }
}
