package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzafg implements zzajd {
    private static final zzafg zza = new zzafg();
    private static final zzaix zzb = zzaix.zzd(zzafe.zza, zzaht.class, zzvw.class);

    zzafg() {
    }

    public static void zzc() throws GeneralSecurityException {
        zzaii.zza().zzc(zza);
        zzaii.zza().zzb(zzb);
    }

    public static void zze(zzaiy zzaiyVar) throws GeneralSecurityException {
        zzaiyVar.zzb(zza);
    }

    @Override // com.google.android.gms.internal.pal.zzajd
    public final Class zza() {
        return zzvw.class;
    }

    @Override // com.google.android.gms.internal.pal.zzajd
    public final Class zzb() {
        return zzvw.class;
    }

    @Override // com.google.android.gms.internal.pal.zzajd
    public final /* bridge */ /* synthetic */ Object zzd(zzwf zzwfVar, zzajc zzajcVar) throws GeneralSecurityException {
        zzahw zzahwVar = (zzahw) zzwfVar.zze(zzahw.class);
        zzahx zzahxVarZza = (zzahwVar == null || zzahwVar.zza()) ? zzaia.zza : zzaig.zza().zzb().zza(zzwfVar, zzahwVar, "hybrid_encrypt", "encrypt");
        zzwd zzwdVarZzb = ((zzwe) zzwfVar).zzb();
        return new zzaff(new zzafd((zzvw) zzajcVar.zza(zzwdVarZzb), zzwdVarZzb.zzc()), zzahxVarZza);
    }
}
