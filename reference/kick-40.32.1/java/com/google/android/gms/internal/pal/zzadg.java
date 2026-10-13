package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzadg implements zzajd {
    private static final zzadg zza = new zzadg();
    private static final zzaix zzb = zzaix.zzd(zzade.zza, zzaht.class, zzvu.class);

    zzadg() {
    }

    public static void zzc() throws GeneralSecurityException {
        zzaii.zza().zzc(zza);
        zzaii.zza().zzb(zzb);
    }

    @Override // com.google.android.gms.internal.pal.zzajd
    public final Class zza() {
        return zzvu.class;
    }

    @Override // com.google.android.gms.internal.pal.zzajd
    public final Class zzb() {
        return zzvu.class;
    }

    @Override // com.google.android.gms.internal.pal.zzajd
    public final /* bridge */ /* synthetic */ Object zzd(zzwf zzwfVar, zzajc zzajcVar) throws GeneralSecurityException {
        zzahx zzahxVarZza;
        zzahx zzahxVarZza2;
        zzarq zzarqVarZzd;
        zzait zzaitVar = new zzait();
        for (int i = 0; i < zzwfVar.zzc(); i++) {
            zzwd zzwdVarZzd = ((zzwe) zzwfVar).zzd(i);
            if (zzwdVarZzd.zzb().equals(zzwb.zza)) {
                zzvu zzvuVar = (zzvu) zzajcVar.zza(zzwdVarZzd);
                zzvz zzvzVarZza = zzwdVarZzd.zza();
                if (zzvzVarZza instanceof zzadb) {
                    zzarqVarZzd = ((zzadb) zzvzVarZza).zze();
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
                zzaitVar.zza(zzarqVarZzd, new zzadd(zzvuVar, zzwdVarZzd.zzc()));
            }
        }
        zzahw zzahwVar = (zzahw) zzwfVar.zze(zzahw.class);
        if (zzahwVar == null || zzahwVar.zza()) {
            zzahxVarZza = zzaia.zza;
            zzahxVarZza2 = zzahxVarZza;
        } else {
            zzahy zzahyVarZzb = zzaig.zza().zzb();
            zzahxVarZza = zzahyVarZzb.zza(zzwfVar, zzahwVar, "daead", "encrypt");
            zzahxVarZza2 = zzahyVarZzb.zza(zzwfVar, zzahwVar, "daead", "decrypt");
        }
        zzwe zzweVar = (zzwe) zzwfVar;
        return new zzadf(new zzadd((zzvu) zzajcVar.zza(zzweVar.zzb()), zzweVar.zzb().zzc()), zzaitVar.zzb(), zzahxVarZza, zzahxVarZza2);
    }
}
