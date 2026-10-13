package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzaay {
    public static final /* synthetic */ int zza = 0;
    private static final zzarq zzb;
    private static final zzais zzc;
    private static final zzaip zzd;
    private static final zzahp zze;
    private static final zzahm zzf;

    static {
        zzarq zzarqVarZza = zzajp.zza("type.googleapis.com/google.crypto.tink.AesGcmKey");
        zzb = zzarqVarZza;
        zzc = zzais.zzd(zzaax.zza, zzxw.class, zzajf.class);
        zzd = zzaip.zzd(zzaau.zza, zzarqVarZza, zzajf.class);
        zze = zzahp.zzd(zzaav.zza, zzxp.class, zzaje.class);
        zzf = zzahm.zzd(zzaaw.zza, zzarqVarZza, zzaje.class);
    }

    public static void zza(zzail zzailVar) throws GeneralSecurityException {
        zzailVar.zzd(zzc);
        zzailVar.zze(zzd);
        zzailVar.zzb(zze);
        zzailVar.zzc(zzf);
    }

    static /* synthetic */ zzajf zzb(zzxw zzxwVar) {
        zzaos zzaosVarZze = zzaot.zze();
        zzaosVarZze.zza("type.googleapis.com/google.crypto.tink.AesGcmKey");
        zzamv zzamvVarZzd = zzamw.zzd();
        zzamvVarZzd.zza(zzxwVar.zzc());
        zzaosVarZze.zzb(((zzamw) zzamvVarZzd.zzal()).zzaQ());
        zzaosVarZze.zzc(zzf(zzxwVar.zzd()));
        return zzajf.zza((zzaot) zzaosVarZze.zzal());
    }

    static /* synthetic */ zzxw zzc(zzajf zzajfVar) throws GeneralSecurityException {
        if (!zzajfVar.zzc().zza().equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
            String strZza = zzajfVar.zzc().zza();
            String.valueOf(strZza);
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmProtoSerialization.parseParameters: ".concat(String.valueOf(strZza)));
        }
        try {
            zzamw zzamwVarZzc = zzamw.zzc(zzajfVar.zzc().zzb(), zzaty.zza());
            if (zzamwVarZzc.zzb() != 0) {
                throw new GeneralSecurityException("Only version 0 parameters are accepted");
            }
            zzxu zzxuVarZzb = zzxw.zzb();
            zzxuVarZzb.zza(zzamwVarZzc.zza());
            zzxuVarZzb.zzb(12);
            zzxuVarZzb.zzc(16);
            zzxuVarZzb.zzd(zzg(zzajfVar.zzc().zzc()));
            return zzxuVarZzb.zze();
        } catch (zzavb e) {
            throw new GeneralSecurityException("Parsing AesGcmParameters failed: ", e);
        }
    }

    static /* synthetic */ zzaje zzd(zzxp zzxpVar, zzwm zzwmVar) {
        zzxpVar.zzf();
        zzamt zzamtVarZzd = zzamu.zzd();
        byte[] bArrZzb = zzxpVar.zze().zzb(zzwmVar);
        zzamtVarZzd.zza(zzatl.zzr(bArrZzb, 0, bArrZzb.length));
        return zzaje.zzf("type.googleapis.com/google.crypto.tink.AesGcmKey", ((zzamu) zzamtVarZzd.zzal()).zzaQ(), 3, zzf(zzxpVar.zzf().zzd()), zzxpVar.zzb());
    }

    static /* synthetic */ zzxp zze(zzaje zzajeVar, zzwm zzwmVar) throws GeneralSecurityException {
        if (!zzajeVar.zze().equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmProtoSerialization.parseKey");
        }
        try {
            zzamu zzamuVarZzc = zzamu.zzc(zzajeVar.zza(), zzaty.zza());
            if (zzamuVarZzc.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzxu zzxuVarZzb = zzxw.zzb();
            zzxuVarZzb.zza(zzamuVarZzc.zzb().zzb());
            zzxuVarZzb.zzb(12);
            zzxuVarZzb.zzc(16);
            zzxuVarZzb.zzd(zzg(zzajeVar.zzb()));
            zzxw zzxwVarZze = zzxuVarZzb.zze();
            zzxo zzxoVarZzd = zzxp.zzd();
            zzxoVarZzd.zza(zzxwVarZze);
            zzxoVarZzd.zzb(zzars.zza(zzamuVarZzc.zzb().zzx(), zzwmVar));
            zzxoVarZzd.zzc(zzajeVar.zzc());
            return zzxoVarZzd.zzd();
        } catch (zzavb unused) {
            throw new GeneralSecurityException("Parsing AesGcmKey failed");
        }
    }

    private static zzapm zzf(zzxv zzxvVar) throws GeneralSecurityException {
        if (zzxv.zza.equals(zzxvVar)) {
            return zzapm.TINK;
        }
        if (zzxv.zzb.equals(zzxvVar)) {
            return zzapm.CRUNCHY;
        }
        if (zzxv.zzc.equals(zzxvVar)) {
            return zzapm.RAW;
        }
        String strValueOf = String.valueOf(zzxvVar);
        String.valueOf(strValueOf);
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(strValueOf)));
    }

    private static zzxv zzg(zzapm zzapmVar) throws GeneralSecurityException {
        int iOrdinal = zzapmVar.ordinal();
        if (iOrdinal == 1) {
            return zzxv.zza;
        }
        if (iOrdinal != 2) {
            if (iOrdinal == 3) {
                return zzxv.zzc;
            }
            if (iOrdinal != 4) {
                throw new GeneralSecurityException(zzabo.zze((byte) 34, zzapmVar));
            }
        }
        return zzxv.zzb;
    }
}
