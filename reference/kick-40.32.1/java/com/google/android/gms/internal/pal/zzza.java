package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzza {
    public static final /* synthetic */ int zza = 0;
    private static final zzarq zzb;
    private static final zzais zzc;
    private static final zzaip zzd;
    private static final zzahp zze;
    private static final zzahm zzf;

    static {
        zzarq zzarqVarZza = zzajp.zza("type.googleapis.com/google.crypto.tink.KmsAeadKey");
        zzb = zzarqVarZza;
        zzc = zzais.zzd(zzyz.zza, zzyv.class, zzajf.class);
        zzd = zzaip.zzd(zzyw.zza, zzarqVarZza, zzajf.class);
        zze = zzahp.zzd(zzyx.zza, zzyt.class, zzaje.class);
        zzf = zzahm.zzd(zzyy.zza, zzarqVarZza, zzaje.class);
    }

    public static void zza(zzail zzailVar) throws GeneralSecurityException {
        zzailVar.zzd(zzc);
        zzailVar.zze(zzd);
        zzailVar.zzb(zze);
        zzailVar.zzc(zzf);
    }

    static /* synthetic */ zzajf zzb(zzyv zzyvVar) {
        zzaos zzaosVarZze = zzaot.zze();
        zzaosVarZze.zza("type.googleapis.com/google.crypto.tink.KmsAeadKey");
        zzapg zzapgVarZzc = zzaph.zzc();
        zzapgVarZzc.zza(zzyvVar.zzc());
        zzaosVarZze.zzb(((zzaph) zzapgVarZzc.zzal()).zzaQ());
        zzaosVarZze.zzc(zzf(zzyvVar.zzd()));
        return zzajf.zza((zzaot) zzaosVarZze.zzal());
    }

    static /* synthetic */ zzyv zzc(zzajf zzajfVar) throws GeneralSecurityException {
        if (zzajfVar.zzc().zza().equals("type.googleapis.com/google.crypto.tink.KmsAeadKey")) {
            try {
                return zzyv.zzb(zzaph.zzb(zzajfVar.zzc().zzb(), zzaty.zza()).zza(), zzg(zzajfVar.zzc().zzc()));
            } catch (zzavb e) {
                throw new GeneralSecurityException("Parsing KmsAeadKeyFormat failed: ", e);
            }
        }
        String strZza = zzajfVar.zzc().zza();
        String.valueOf(strZza);
        throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsAeadProtoSerialization.parseParameters: ".concat(String.valueOf(strZza)));
    }

    static /* synthetic */ zzaje zzd(zzyt zzytVar, zzwm zzwmVar) {
        zzape zzapeVarZzd = zzapf.zzd();
        zzapg zzapgVarZzc = zzaph.zzc();
        zzapgVarZzc.zza(zzytVar.zze().zzc());
        zzapeVarZzd.zza((zzaph) zzapgVarZzc.zzal());
        return zzaje.zzf("type.googleapis.com/google.crypto.tink.KmsAeadKey", ((zzapf) zzapeVarZzd.zzal()).zzaQ(), 6, zzf(zzytVar.zze().zzd()), zzytVar.zzb());
    }

    static /* synthetic */ zzyt zze(zzaje zzajeVar, zzwm zzwmVar) throws GeneralSecurityException {
        if (!zzajeVar.zze().equals("type.googleapis.com/google.crypto.tink.KmsAeadKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsAeadProtoSerialization.parseKey");
        }
        try {
            zzapf zzapfVarZzc = zzapf.zzc(zzajeVar.zza(), zzaty.zza());
            if (zzapfVarZzc.zza() == 0) {
                return zzyt.zzd(zzyv.zzb(zzapfVarZzc.zzb().zza(), zzg(zzajeVar.zzb())), zzajeVar.zzc());
            }
            String strValueOf = String.valueOf(zzapfVarZzc);
            StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 49);
            sb.append("KmsAeadKey are only accepted with version 0, got ");
            sb.append(strValueOf);
            throw new GeneralSecurityException(sb.toString());
        } catch (zzavb e) {
            throw new GeneralSecurityException("Parsing KmsAeadKey failed: ", e);
        }
    }

    private static zzapm zzf(zzyu zzyuVar) throws GeneralSecurityException {
        if (zzyu.zza.equals(zzyuVar)) {
            return zzapm.TINK;
        }
        if (zzyu.zzb.equals(zzyuVar)) {
            return zzapm.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(zzyuVar.toString()));
    }

    private static zzyu zzg(zzapm zzapmVar) throws GeneralSecurityException {
        int iOrdinal = zzapmVar.ordinal();
        if (iOrdinal == 1) {
            return zzyu.zza;
        }
        if (iOrdinal == 3) {
            return zzyu.zzb;
        }
        int iZza = zzapmVar.zza();
        StringBuilder sb = new StringBuilder(String.valueOf(iZza).length() + 34);
        sb.append("Unable to parse OutputPrefixType: ");
        sb.append(iZza);
        throw new GeneralSecurityException(sb.toString());
    }
}
