package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzale {
    public static final /* synthetic */ int zza = 0;
    private static final zzarq zzb;
    private static final zzais zzc;
    private static final zzaip zzd;
    private static final zzahp zze;
    private static final zzahm zzf;

    static {
        zzarq zzarqVarZza = zzajp.zza("type.googleapis.com/google.crypto.tink.AesCmacKey");
        zzb = zzarqVarZza;
        zzc = zzais.zzd(zzald.zza, zzajy.class, zzajf.class);
        zzd = zzaip.zzd(zzala.zza, zzarqVarZza, zzajf.class);
        zze = zzahp.zzd(zzalb.zza, zzajr.class, zzaje.class);
        zzf = zzahm.zzd(zzalc.zza, zzarqVarZza, zzaje.class);
    }

    public static void zza(zzail zzailVar) throws GeneralSecurityException {
        zzailVar.zzd(zzc);
        zzailVar.zze(zzd);
        zzailVar.zzb(zze);
        zzailVar.zzc(zzf);
    }

    static /* synthetic */ zzajf zzb(zzajy zzajyVar) {
        zzaos zzaosVarZze = zzaot.zze();
        zzaosVarZze.zza("type.googleapis.com/google.crypto.tink.AesCmacKey");
        zzalz zzalzVarZzd = zzama.zzd();
        zzalzVarZzd.zzb(zzh(zzajyVar));
        zzalzVarZzd.zza(zzajyVar.zzc());
        zzaosVarZze.zzb(((zzama) zzalzVarZzd.zzal()).zzaQ());
        zzaosVarZze.zzc(zzf(zzajyVar.zzf()));
        return zzajf.zza((zzaot) zzaosVarZze.zzal());
    }

    static /* synthetic */ zzajy zzc(zzajf zzajfVar) throws GeneralSecurityException {
        if (!zzajfVar.zzc().zza().equals("type.googleapis.com/google.crypto.tink.AesCmacKey")) {
            String strZza = zzajfVar.zzc().zza();
            String.valueOf(strZza);
            throw new IllegalArgumentException("Wrong type URL in call to AesCmacProtoSerialization.parseParameters: ".concat(String.valueOf(strZza)));
        }
        try {
            zzama zzamaVarZzc = zzama.zzc(zzajfVar.zzc().zzb(), zzaty.zza());
            zzajw zzajwVarZzb = zzajy.zzb();
            zzajwVarZzb.zza(zzamaVarZzc.zza());
            zzajwVarZzb.zzb(zzamaVarZzc.zzb().zza());
            zzajwVarZzb.zzc(zzg(zzajfVar.zzc().zzc()));
            return zzajwVarZzb.zzd();
        } catch (zzavb e) {
            throw new GeneralSecurityException("Parsing AesCmacParameters failed: ", e);
        }
    }

    static /* synthetic */ zzaje zzd(zzajr zzajrVar, zzwm zzwmVar) {
        zzalx zzalxVarZze = zzaly.zze();
        zzalxVarZze.zzb(zzh(zzajrVar.zzf()));
        byte[] bArrZzb = zzajrVar.zzd().zzb(zzwmVar);
        zzalxVarZze.zza(zzatl.zzr(bArrZzb, 0, bArrZzb.length));
        return zzaje.zzf("type.googleapis.com/google.crypto.tink.AesCmacKey", ((zzaly) zzalxVarZze.zzal()).zzaQ(), 3, zzf(zzajrVar.zzf().zzf()), zzajrVar.zzb());
    }

    static /* synthetic */ zzajr zze(zzaje zzajeVar, zzwm zzwmVar) throws GeneralSecurityException {
        if (!zzajeVar.zze().equals("type.googleapis.com/google.crypto.tink.AesCmacKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesCmacProtoSerialization.parseKey");
        }
        try {
            zzaly zzalyVarZzd = zzaly.zzd(zzajeVar.zza(), zzaty.zza());
            if (zzalyVarZzd.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzajw zzajwVarZzb = zzajy.zzb();
            zzajwVarZzb.zza(zzalyVarZzd.zzb().zzb());
            zzajwVarZzb.zzb(zzalyVarZzd.zzc().zza());
            zzajwVarZzb.zzc(zzg(zzajeVar.zzb()));
            zzajy zzajyVarZzd = zzajwVarZzb.zzd();
            zzajq zzajqVarZzc = zzajr.zzc();
            zzajqVarZzc.zza(zzajyVarZzd);
            zzajqVarZzc.zzb(zzars.zza(zzalyVarZzd.zzb().zzx(), zzwmVar));
            zzajqVarZzc.zzc(zzajeVar.zzc());
            return zzajqVarZzc.zzd();
        } catch (zzavb | IllegalArgumentException unused) {
            throw new GeneralSecurityException("Parsing AesCmacKey failed");
        }
    }

    private static zzapm zzf(zzajx zzajxVar) throws GeneralSecurityException {
        if (zzajx.zza.equals(zzajxVar)) {
            return zzapm.TINK;
        }
        if (zzajx.zzb.equals(zzajxVar)) {
            return zzapm.CRUNCHY;
        }
        if (zzajx.zzd.equals(zzajxVar)) {
            return zzapm.RAW;
        }
        if (zzajx.zzc.equals(zzajxVar)) {
            return zzapm.LEGACY;
        }
        String strValueOf = String.valueOf(zzajxVar);
        String.valueOf(strValueOf);
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(strValueOf)));
    }

    private static zzajx zzg(zzapm zzapmVar) throws GeneralSecurityException {
        int iOrdinal = zzapmVar.ordinal();
        if (iOrdinal == 1) {
            return zzajx.zza;
        }
        if (iOrdinal == 2) {
            return zzajx.zzc;
        }
        if (iOrdinal == 3) {
            return zzajx.zzd;
        }
        if (iOrdinal == 4) {
            return zzajx.zzb;
        }
        int iZza = zzapmVar.zza();
        StringBuilder sb = new StringBuilder(String.valueOf(iZza).length() + 34);
        sb.append("Unable to parse OutputPrefixType: ");
        sb.append(iZza);
        throw new GeneralSecurityException(sb.toString());
    }

    private static zzamc zzh(zzajy zzajyVar) {
        zzamb zzambVarZzb = zzamc.zzb();
        zzambVarZzb.zza(zzajyVar.zzd());
        return (zzamc) zzambVarZzb.zzal();
    }
}
