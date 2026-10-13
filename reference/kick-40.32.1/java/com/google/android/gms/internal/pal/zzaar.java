package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzaar {
    public static final /* synthetic */ int zza = 0;
    private static final zzarq zzb;
    private static final zzais zzc;
    private static final zzaip zzd;
    private static final zzahp zze;
    private static final zzahm zzf;

    static {
        zzarq zzarqVarZza = zzajp.zza("type.googleapis.com/google.crypto.tink.AesEaxKey");
        zzb = zzarqVarZza;
        zzc = zzais.zzd(zzaaq.zza, zzxn.class, zzajf.class);
        zzd = zzaip.zzd(zzaan.zza, zzarqVarZza, zzajf.class);
        zze = zzahp.zzd(zzaao.zza, zzxh.class, zzaje.class);
        zzf = zzahm.zzd(zzaap.zza, zzarqVarZza, zzaje.class);
    }

    public static void zza(zzail zzailVar) throws GeneralSecurityException {
        zzailVar.zzd(zzc);
        zzailVar.zze(zzd);
        zzailVar.zzb(zze);
        zzailVar.zzc(zzf);
    }

    static /* synthetic */ zzajf zzb(zzxn zzxnVar) {
        zzaos zzaosVarZze = zzaot.zze();
        zzaosVarZze.zza("type.googleapis.com/google.crypto.tink.AesEaxKey");
        zzamp zzampVarZzd = zzamq.zzd();
        zzampVarZzd.zza(zzh(zzxnVar));
        zzampVarZzd.zzb(zzxnVar.zzc());
        zzaosVarZze.zzb(((zzamq) zzampVarZzd.zzal()).zzaQ());
        zzaosVarZze.zzc(zzf(zzxnVar.zze()));
        return zzajf.zza((zzaot) zzaosVarZze.zzal());
    }

    static /* synthetic */ zzxn zzc(zzajf zzajfVar) throws GeneralSecurityException {
        if (!zzajfVar.zzc().zza().equals("type.googleapis.com/google.crypto.tink.AesEaxKey")) {
            String strZza = zzajfVar.zzc().zza();
            String.valueOf(strZza);
            throw new IllegalArgumentException("Wrong type URL in call to AesEaxProtoSerialization.parseParameters: ".concat(String.valueOf(strZza)));
        }
        try {
            zzamq zzamqVarZzc = zzamq.zzc(zzajfVar.zzc().zzb(), zzaty.zza());
            zzxl zzxlVarZzb = zzxn.zzb();
            zzxlVarZzb.zza(zzamqVarZzc.zzb());
            zzxlVarZzb.zzb(zzamqVarZzc.zza().zza());
            zzxlVarZzb.zzc(16);
            zzxlVarZzb.zzd(zzg(zzajfVar.zzc().zzc()));
            return zzxlVarZzb.zze();
        } catch (zzavb e) {
            throw new GeneralSecurityException("Parsing AesEaxParameters failed: ", e);
        }
    }

    static /* synthetic */ zzaje zzd(zzxh zzxhVar, zzwm zzwmVar) {
        zzamn zzamnVarZze = zzamo.zze();
        zzamnVarZze.zza(zzh(zzxhVar.zzf()));
        byte[] bArrZzb = zzxhVar.zze().zzb(zzwmVar);
        zzamnVarZze.zzb(zzatl.zzr(bArrZzb, 0, bArrZzb.length));
        return zzaje.zzf("type.googleapis.com/google.crypto.tink.AesEaxKey", ((zzamo) zzamnVarZze.zzal()).zzaQ(), 3, zzf(zzxhVar.zzf().zze()), zzxhVar.zzb());
    }

    static /* synthetic */ zzxh zze(zzaje zzajeVar, zzwm zzwmVar) throws GeneralSecurityException {
        if (!zzajeVar.zze().equals("type.googleapis.com/google.crypto.tink.AesEaxKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesEaxProtoSerialization.parseKey");
        }
        try {
            zzamo zzamoVarZzd = zzamo.zzd(zzajeVar.zza(), zzaty.zza());
            if (zzamoVarZzd.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzxl zzxlVarZzb = zzxn.zzb();
            zzxlVarZzb.zza(zzamoVarZzd.zzc().zzb());
            zzxlVarZzb.zzb(zzamoVarZzd.zzb().zza());
            zzxlVarZzb.zzc(16);
            zzxlVarZzb.zzd(zzg(zzajeVar.zzb()));
            zzxn zzxnVarZze = zzxlVarZzb.zze();
            zzxg zzxgVarZzd = zzxh.zzd();
            zzxgVarZzd.zza(zzxnVarZze);
            zzxgVarZzd.zzb(zzars.zza(zzamoVarZzd.zzc().zzx(), zzwmVar));
            zzxgVarZzd.zzc(zzajeVar.zzc());
            return zzxgVarZzd.zzd();
        } catch (zzavb unused) {
            throw new GeneralSecurityException("Parsing AesEaxKey failed");
        }
    }

    private static zzapm zzf(zzxm zzxmVar) throws GeneralSecurityException {
        if (zzxm.zza.equals(zzxmVar)) {
            return zzapm.TINK;
        }
        if (zzxm.zzb.equals(zzxmVar)) {
            return zzapm.CRUNCHY;
        }
        if (zzxm.zzc.equals(zzxmVar)) {
            return zzapm.RAW;
        }
        String strValueOf = String.valueOf(zzxmVar);
        String.valueOf(strValueOf);
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(strValueOf)));
    }

    private static zzxm zzg(zzapm zzapmVar) throws GeneralSecurityException {
        int iOrdinal = zzapmVar.ordinal();
        if (iOrdinal == 1) {
            return zzxm.zza;
        }
        if (iOrdinal != 2) {
            if (iOrdinal == 3) {
                return zzxm.zzc;
            }
            if (iOrdinal != 4) {
                throw new GeneralSecurityException(zzabo.zze((byte) 34, zzapmVar));
            }
        }
        return zzxm.zzb;
    }

    private static zzams zzh(zzxn zzxnVar) throws GeneralSecurityException {
        zzamr zzamrVarZzb = zzams.zzb();
        zzamrVarZzb.zza(zzxnVar.zzd());
        return (zzams) zzamrVarZzb.zzal();
    }
}
