package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzzk {
    public static final /* synthetic */ int zza = 0;
    private static final zzarq zzb;
    private static final zzais zzc;
    private static final zzaip zzd;
    private static final zzahp zze;
    private static final zzahm zzf;

    static {
        zzarq zzarqVarZza = zzajp.zza("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey");
        zzb = zzarqVarZza;
        zzc = zzais.zzd(zzzj.zza, zzzf.class, zzajf.class);
        zzd = zzaip.zzd(zzzg.zza, zzarqVarZza, zzajf.class);
        zze = zzahp.zzd(zzzh.zza, zzzb.class, zzaje.class);
        zzf = zzahm.zzd(zzzi.zza, zzarqVarZza, zzaje.class);
    }

    public static void zza(zzail zzailVar) throws GeneralSecurityException {
        zzailVar.zzd(zzc);
        zzailVar.zze(zzd);
        zzailVar.zzb(zze);
        zzailVar.zzc(zzf);
    }

    static /* synthetic */ zzajf zzb(zzzf zzzfVar) {
        zzaos zzaosVarZze = zzaot.zze();
        zzaosVarZze.zza("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey");
        zzaosVarZze.zzb(zzg(zzzfVar).zzaQ());
        zzaosVarZze.zzc(zzf(zzzfVar.zzc()));
        return zzajf.zza((zzaot) zzaosVarZze.zzal());
    }

    static /* synthetic */ zzzf zzc(zzajf zzajfVar) throws GeneralSecurityException {
        if (!zzajfVar.zzc().zza().equals("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey")) {
            String strZza = zzajfVar.zzc().zza();
            String.valueOf(strZza);
            throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsEnvelopeAeadProtoSerialization.parseParameters: ".concat(String.valueOf(strZza)));
        }
        try {
            return zzh(zzapl.zzc(zzajfVar.zzc().zzb(), zzaty.zza()), zzajfVar.zzc().zzc());
        } catch (zzavb e) {
            throw new GeneralSecurityException("Parsing KmsEnvelopeAeadKeyFormat failed: ", e);
        }
    }

    static /* synthetic */ zzaje zzd(zzzb zzzbVar, zzwm zzwmVar) {
        zzapi zzapiVarZzd = zzapj.zzd();
        zzapiVarZzd.zza(zzg(zzzbVar.zze()));
        return zzaje.zzf("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey", ((zzapj) zzapiVarZzd.zzal()).zzaQ(), 6, zzf(zzzbVar.zze().zzc()), zzzbVar.zzb());
    }

    static /* synthetic */ zzzb zze(zzaje zzajeVar, zzwm zzwmVar) throws GeneralSecurityException {
        if (!zzajeVar.zze().equals("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsEnvelopeAeadProtoSerialization.parseKey");
        }
        try {
            zzapj zzapjVarZzc = zzapj.zzc(zzajeVar.zza(), zzaty.zza());
            if (zzapjVarZzc.zza() == 0) {
                return zzzb.zzd(zzh(zzapjVarZzc.zzb(), zzajeVar.zzb()), zzajeVar.zzc());
            }
            String strValueOf = String.valueOf(zzapjVarZzc);
            StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 58);
            sb.append("KmsEnvelopeAeadKeys are only accepted with version 0, got ");
            sb.append(strValueOf);
            throw new GeneralSecurityException(sb.toString());
        } catch (zzavb e) {
            throw new GeneralSecurityException("Parsing KmsEnvelopeAeadKey failed: ", e);
        }
    }

    private static zzapm zzf(zzze zzzeVar) throws GeneralSecurityException {
        if (zzze.zza.equals(zzzeVar)) {
            return zzapm.TINK;
        }
        if (zzze.zzb.equals(zzzeVar)) {
            return zzapm.RAW;
        }
        String strValueOf = String.valueOf(zzzeVar);
        String.valueOf(strValueOf);
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(strValueOf)));
    }

    private static zzapl zzg(zzzf zzzfVar) throws GeneralSecurityException {
        try {
            zzaot zzaotVarZzd = zzaot.zzd(zzwn.zza(zzzfVar.zzd()), zzaty.zza());
            zzapk zzapkVarZzd = zzapl.zzd();
            zzapkVarZzd.zza(zzzfVar.zzb());
            zzapkVarZzd.zzb(zzaotVarZzd);
            return (zzapl) zzapkVarZzd.zzal();
        } catch (zzavb e) {
            throw new GeneralSecurityException("Parsing KmsEnvelopeAeadKeyFormat failed: ", e);
        }
    }

    private static zzzf zzh(zzapl zzaplVar, zzapm zzapmVar) throws GeneralSecurityException {
        zzzd zzzdVar;
        zzze zzzeVar;
        zzaos zzaosVarZze = zzaot.zze();
        zzaosVarZze.zza(zzaplVar.zzb().zza());
        zzaosVarZze.zzb(zzaplVar.zzb().zzb());
        zzaosVarZze.zzc(zzapm.RAW);
        zzwk zzwkVarZzb = zzwn.zzb(((zzaot) zzaosVarZze.zzal()).zzaq());
        if (zzwkVarZzb instanceof zzxw) {
            zzzdVar = zzzd.zza;
        } else if (zzwkVarZzb instanceof zzyl) {
            zzzdVar = zzzd.zzc;
        } else if (zzwkVarZzb instanceof zzaah) {
            zzzdVar = zzzd.zzb;
        } else if (zzwkVarZzb instanceof zzxf) {
            zzzdVar = zzzd.zzd;
        } else if (zzwkVarZzb instanceof zzxn) {
            zzzdVar = zzzd.zze;
        } else {
            if (!(zzwkVarZzb instanceof zzyf)) {
                throw new GeneralSecurityException("Unsupported DEK parameters when parsing ".concat(zzwkVarZzb.toString()));
            }
            zzzdVar = zzzd.zzf;
        }
        zzzc zzzcVar = new zzzc(null);
        int iOrdinal = zzapmVar.ordinal();
        if (iOrdinal == 1) {
            zzzeVar = zzze.zza;
        } else {
            if (iOrdinal != 3) {
                int iZza = zzapmVar.zza();
                StringBuilder sb = new StringBuilder(String.valueOf(iZza).length() + 34);
                sb.append("Unable to parse OutputPrefixType: ");
                sb.append(iZza);
                throw new GeneralSecurityException(sb.toString());
            }
            zzzeVar = zzze.zzb;
        }
        zzzcVar.zza(zzzeVar);
        zzzcVar.zzb(zzaplVar.zza());
        zzzcVar.zzd((zzwr) zzwkVarZzb);
        zzzcVar.zzc(zzzdVar);
        return zzzcVar.zze();
    }
}
