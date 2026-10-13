package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzacb {
    public static final /* synthetic */ int zza = 0;
    private static final zzarq zzb;
    private static final zzais zzc;
    private static final zzaip zzd;
    private static final zzahp zze;
    private static final zzahm zzf;

    static {
        zzarq zzarqVarZza = zzajp.zza("type.googleapis.com/google.crypto.tink.XAesGcmKey");
        zzb = zzarqVarZza;
        zzc = zzais.zzd(zzaca.zza, zzaaa.class, zzajf.class);
        zzd = zzaip.zzd(zzabx.zza, zzarqVarZza, zzajf.class);
        zze = zzahp.zzd(zzaby.zza, zzzv.class, zzaje.class);
        zzf = zzahm.zzd(zzabz.zza, zzarqVarZza, zzaje.class);
    }

    public static void zza(zzail zzailVar) throws GeneralSecurityException {
        zzailVar.zzd(zzc);
        zzailVar.zze(zzd);
        zzailVar.zzb(zze);
        zzailVar.zzc(zzf);
    }

    static /* synthetic */ zzajf zzb(zzaaa zzaaaVar) {
        zzaos zzaosVarZze = zzaot.zze();
        zzaosVarZze.zza("type.googleapis.com/google.crypto.tink.XAesGcmKey");
        zzapr zzaprVarZzd = zzaps.zzd();
        zzapt zzaptVarZzb = zzapu.zzb();
        zzaptVarZzb.zza(zzaaaVar.zzd());
        zzaprVarZzd.zza((zzapu) zzaptVarZzb.zzal());
        zzaosVarZze.zzb(((zzaps) zzaprVarZzd.zzal()).zzaQ());
        zzaosVarZze.zzc(zzf(zzaaaVar.zzc()));
        return zzajf.zza((zzaot) zzaosVarZze.zzal());
    }

    static /* synthetic */ zzaaa zzc(zzajf zzajfVar) throws GeneralSecurityException {
        if (!zzajfVar.zzc().zza().equals("type.googleapis.com/google.crypto.tink.XAesGcmKey")) {
            String strZza = zzajfVar.zzc().zza();
            String.valueOf(strZza);
            throw new IllegalArgumentException("Wrong type URL in call to XAesGcmProtoSerialization.parseParameters: ".concat(String.valueOf(strZza)));
        }
        try {
            zzaps zzapsVarZzc = zzaps.zzc(zzajfVar.zzc().zzb(), zzaty.zza());
            if (zzapsVarZzc.zza() == 0) {
                return zzaaa.zzb(zzg(zzajfVar.zzc().zzc()), zzapsVarZzc.zzb().zza());
            }
            throw new GeneralSecurityException("Only version 0 parameters are accepted");
        } catch (zzavb e) {
            throw new GeneralSecurityException("Parsing XAesGcmParameters failed: ", e);
        }
    }

    static /* synthetic */ zzaje zzd(zzzv zzzvVar, zzwm zzwmVar) {
        zzapp zzappVarZze = zzapq.zze();
        byte[] bArrZzb = zzzvVar.zze().zzb(zzwmVar);
        zzappVarZze.zzb(zzatl.zzr(bArrZzb, 0, bArrZzb.length));
        zzapt zzaptVarZzb = zzapu.zzb();
        zzaptVarZzb.zza(zzzvVar.zzf().zzd());
        zzappVarZze.zza((zzapu) zzaptVarZzb.zzal());
        return zzaje.zzf("type.googleapis.com/google.crypto.tink.XAesGcmKey", ((zzapq) zzappVarZze.zzal()).zzaQ(), 3, zzf(zzzvVar.zzf().zzc()), zzzvVar.zzb());
    }

    static /* synthetic */ zzzv zze(zzaje zzajeVar, zzwm zzwmVar) throws GeneralSecurityException {
        if (!zzajeVar.zze().equals("type.googleapis.com/google.crypto.tink.XAesGcmKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to XAesGcmProtoSerialization.parseKey");
        }
        try {
            zzapq zzapqVarZzd = zzapq.zzd(zzajeVar.zza(), zzaty.zza());
            if (zzapqVarZzd.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            if (zzapqVarZzd.zzc().zzb() == 32) {
                return zzzv.zzd(zzaaa.zzb(zzg(zzajeVar.zzb()), zzapqVarZzd.zzb().zza()), zzars.zza(zzapqVarZzd.zzc().zzx(), zzwmVar), zzajeVar.zzc());
            }
            throw new GeneralSecurityException("Only 32 byte key size is accepted");
        } catch (zzavb unused) {
            throw new GeneralSecurityException("Parsing XAesGcmKey failed");
        }
    }

    private static zzapm zzf(zzzz zzzzVar) throws GeneralSecurityException {
        if (Objects.equals(zzzzVar, zzzz.zza)) {
            return zzapm.TINK;
        }
        if (Objects.equals(zzzzVar, zzzz.zzb)) {
            return zzapm.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(zzzzVar.toString()));
    }

    private static zzzz zzg(zzapm zzapmVar) throws GeneralSecurityException {
        int iOrdinal = zzapmVar.ordinal();
        if (iOrdinal == 1) {
            return zzzz.zza;
        }
        if (iOrdinal == 3) {
            return zzzz.zzb;
        }
        throw new GeneralSecurityException(zzabo.zze((byte) 34, zzapmVar));
    }
}
