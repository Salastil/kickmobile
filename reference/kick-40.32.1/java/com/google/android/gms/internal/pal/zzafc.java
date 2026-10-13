package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzafc implements zzajd {
    private static final zzafc zza = new zzafc();
    private static final zzaix zzb = zzaix.zzd(zzafa.zza, zzaht.class, zzvv.class);

    zzafc() {
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
        return zzvv.class;
    }

    @Override // com.google.android.gms.internal.pal.zzajd
    public final Class zzb() {
        return zzvv.class;
    }

    @Override // com.google.android.gms.internal.pal.zzajd
    public final /* bridge */ /* synthetic */ Object zzd(zzwf zzwfVar, zzajc zzajcVar) throws GeneralSecurityException {
        zzarq zzarqVarZzd;
        zzait zzaitVar = new zzait();
        for (int i = 0; i < zzwfVar.zzc(); i++) {
            zzwd zzwdVarZzd = ((zzwe) zzwfVar).zzd(i);
            if (zzwdVarZzd.zzb().equals(zzwb.zza)) {
                zzvv zzvvVar = (zzvv) zzajcVar.zza(zzwdVarZzd);
                zzvz zzvzVarZza = zzwdVarZzd.zza();
                if (zzvzVarZza instanceof zzafi) {
                    zzarqVarZzd = ((zzafi) zzvzVarZza).zzi().zzg();
                } else {
                    if (!(zzvzVarZza instanceof zzaht)) {
                        String name = zzvzVarZza.getClass().getName();
                        String strValueOf = String.valueOf(zzvzVarZza.zza());
                        StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 59 + String.valueOf(strValueOf).length());
                        sb.append("Cannot get output prefix for key of class ");
                        sb.append(name);
                        sb.append(" with parameters ");
                        sb.append(strValueOf);
                        throw new GeneralSecurityException(sb.toString());
                    }
                    zzarqVarZzd = ((zzaht) zzvzVarZza).zzd();
                }
                zzaitVar.zza(zzarqVarZzd, new zzaez(zzvvVar, zzwdVarZzd.zzc()));
            }
        }
        zzahw zzahwVar = (zzahw) zzwfVar.zze(zzahw.class);
        return new zzafb(zzaitVar.zzb(), (zzahwVar == null || zzahwVar.zza()) ? zzaia.zza : zzaig.zza().zzb().zza(zzwfVar, zzahwVar, "hybrid_decrypt", "decrypt"));
    }
}
