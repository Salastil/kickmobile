package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzakt implements zzajd {
    private static final zzakt zza = new zzakt();
    private static final zzaix zzb = zzaix.zzd(zzakq.zza, zzaht.class, zzwj.class);

    zzakt() {
    }

    static void zzc() throws GeneralSecurityException {
        zzaii.zza().zzc(zza);
        zzaii.zza().zzb(zzb);
    }

    @Override // com.google.android.gms.internal.pal.zzajd
    public final Class zza() {
        return zzwj.class;
    }

    @Override // com.google.android.gms.internal.pal.zzajd
    public final Class zzb() {
        return zzwj.class;
    }

    @Override // com.google.android.gms.internal.pal.zzajd
    public final /* bridge */ /* synthetic */ Object zzd(zzwf zzwfVar, zzajc zzajcVar) throws GeneralSecurityException {
        zzahx zzahxVar;
        zzahx zzahxVarZza;
        zzarq zzarqVarZzd;
        zzait zzaitVar = new zzait();
        for (int i = 0; i < zzwfVar.zzc(); i++) {
            zzwd zzwdVarZzd = ((zzwe) zzwfVar).zzd(i);
            if (zzwdVarZzd.zzb().equals(zzwb.zza)) {
                zzwj zzwjVar = (zzwj) zzajcVar.zza(zzwdVarZzd);
                zzvz zzvzVarZza = zzwdVarZzd.zza();
                if (zzvzVarZza instanceof zzako) {
                    zzarqVarZzd = ((zzako) zzvzVarZza).zze();
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
                zzaitVar.zza(zzarqVarZzd, new zzakr(zzwjVar, zzwdVarZzd.zzc()));
            }
        }
        zzahw zzahwVar = (zzahw) zzwfVar.zze(zzahw.class);
        if (zzahwVar == null || zzahwVar.zza()) {
            zzahxVar = zzaia.zza;
            zzahxVarZza = zzahxVar;
        } else {
            zzahy zzahyVarZzb = zzaig.zza().zzb();
            zzahx zzahxVarZza2 = zzahyVarZzb.zza(zzwfVar, zzahwVar, "mac", "compute");
            zzahxVarZza = zzahyVarZzb.zza(zzwfVar, zzahwVar, "mac", "verify");
            zzahxVar = zzahxVarZza2;
        }
        zzwe zzweVar = (zzwe) zzwfVar;
        return new zzaks(new zzakr((zzwj) zzajcVar.zza(zzweVar.zzb()), zzweVar.zzb().zzc()), zzaitVar.zzb(), zzahxVar, zzahxVarZza, null);
    }
}
