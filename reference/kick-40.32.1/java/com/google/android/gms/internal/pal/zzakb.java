package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzakb implements zzajd {
    private static final zzakb zza = new zzakb();

    private zzakb() {
    }

    static void zzc() throws GeneralSecurityException {
        zzaii.zza().zzc(zza);
    }

    @Override // com.google.android.gms.internal.pal.zzajd
    public final Class zza() {
        return zzajz.class;
    }

    @Override // com.google.android.gms.internal.pal.zzajd
    public final Class zzb() {
        return zzajz.class;
    }

    @Override // com.google.android.gms.internal.pal.zzajd
    public final /* bridge */ /* synthetic */ Object zzd(zzwf zzwfVar, zzajc zzajcVar) throws GeneralSecurityException {
        zzarq zzarqVarZzd;
        zzwe zzweVar = (zzwe) zzwfVar;
        zzwd zzwdVarZzb = zzweVar.zzb();
        zzait zzaitVar = new zzait();
        for (int i = 0; i < zzwfVar.zzc(); i++) {
            zzwd zzwdVarZzd = zzweVar.zzd(i);
            if (zzwdVarZzd.zzb().equals(zzwb.zza)) {
                zzajz zzajzVar = (zzajz) zzajcVar.zza(zzwdVarZzd);
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
                zzaitVar.zza(zzarqVarZzd, zzajzVar);
            }
        }
        return new zzaka(zzaitVar.zzb(), (zzajz) zzajcVar.zza(zzwdVarZzb), null);
    }
}
