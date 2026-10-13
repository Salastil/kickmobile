package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzabf {
    public static final /* synthetic */ int zza = 0;
    private static final zzarq zzb;
    private static final zzais zzc;
    private static final zzaip zzd;
    private static final zzahp zze;
    private static final zzahm zzf;

    static {
        zzarq zzarqVarZza = zzajp.zza("type.googleapis.com/google.crypto.tink.AesGcmSivKey");
        zzb = zzarqVarZza;
        zzc = zzais.zzd(zzabe.zza, zzyf.class, zzajf.class);
        zzd = zzaip.zzd(zzabb.zza, zzarqVarZza, zzajf.class);
        zze = zzahp.zzd(zzabc.zza, zzxy.class, zzaje.class);
        zzf = zzahm.zzd(zzabd.zza, zzarqVarZza, zzaje.class);
    }

    public static void zza(zzail zzailVar) throws GeneralSecurityException {
        zzailVar.zzd(zzc);
        zzailVar.zze(zzd);
        zzailVar.zzb(zze);
        zzailVar.zzc(zzf);
    }

    static /* synthetic */ zzajf zzb(zzyf zzyfVar) {
        zzaos zzaosVarZze = zzaot.zze();
        zzaosVarZze.zza("type.googleapis.com/google.crypto.tink.AesGcmSivKey");
        zzamz zzamzVarZzd = zzana.zzd();
        zzamzVarZzd.zza(zzyfVar.zzc());
        zzaosVarZze.zzb(((zzana) zzamzVarZzd.zzal()).zzaQ());
        zzaosVarZze.zzc(zzf(zzyfVar.zzd()));
        return zzajf.zza((zzaot) zzaosVarZze.zzal());
    }

    static /* synthetic */ zzyf zzc(zzajf zzajfVar) throws GeneralSecurityException {
        if (!zzajfVar.zzc().zza().equals("type.googleapis.com/google.crypto.tink.AesGcmSivKey")) {
            String strZza = zzajfVar.zzc().zza();
            String.valueOf(strZza);
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmSivProtoSerialization.parseParameters: ".concat(String.valueOf(strZza)));
        }
        try {
            zzana zzanaVarZzc = zzana.zzc(zzajfVar.zzc().zzb(), zzaty.zza());
            if (zzanaVarZzc.zzb() != 0) {
                throw new GeneralSecurityException("Only version 0 parameters are accepted");
            }
            zzyd zzydVarZzb = zzyf.zzb();
            zzydVarZzb.zza(zzanaVarZzc.zza());
            zzydVarZzb.zzb(zzg(zzajfVar.zzc().zzc()));
            return zzydVarZzb.zzc();
        } catch (zzavb e) {
            throw new GeneralSecurityException("Parsing AesGcmSivParameters failed: ", e);
        }
    }

    static /* synthetic */ zzaje zzd(zzxy zzxyVar, zzwm zzwmVar) {
        zzamx zzamxVarZzd = zzamy.zzd();
        byte[] bArrZzb = zzxyVar.zze().zzb(zzwmVar);
        zzamxVarZzd.zza(zzatl.zzr(bArrZzb, 0, bArrZzb.length));
        return zzaje.zzf("type.googleapis.com/google.crypto.tink.AesGcmSivKey", ((zzamy) zzamxVarZzd.zzal()).zzaQ(), 3, zzf(zzxyVar.zzf().zzd()), zzxyVar.zzb());
    }

    static /* synthetic */ zzxy zze(zzaje zzajeVar, zzwm zzwmVar) throws GeneralSecurityException {
        if (!zzajeVar.zze().equals("type.googleapis.com/google.crypto.tink.AesGcmSivKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmSivProtoSerialization.parseKey");
        }
        try {
            zzamy zzamyVarZzc = zzamy.zzc(zzajeVar.zza(), zzaty.zza());
            if (zzamyVarZzc.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzyd zzydVarZzb = zzyf.zzb();
            zzydVarZzb.zza(zzamyVarZzc.zzb().zzb());
            zzydVarZzb.zzb(zzg(zzajeVar.zzb()));
            zzyf zzyfVarZzc = zzydVarZzb.zzc();
            zzxx zzxxVarZzd = zzxy.zzd();
            zzxxVarZzd.zza(zzyfVarZzc);
            zzxxVarZzd.zzb(zzars.zza(zzamyVarZzc.zzb().zzx(), zzwmVar));
            zzxxVarZzd.zzc(zzajeVar.zzc());
            return zzxxVarZzd.zzd();
        } catch (zzavb unused) {
            throw new GeneralSecurityException("Parsing AesGcmSivKey failed");
        }
    }

    private static zzapm zzf(zzye zzyeVar) throws GeneralSecurityException {
        if (zzye.zza.equals(zzyeVar)) {
            return zzapm.TINK;
        }
        if (zzye.zzb.equals(zzyeVar)) {
            return zzapm.CRUNCHY;
        }
        if (zzye.zzc.equals(zzyeVar)) {
            return zzapm.RAW;
        }
        String strValueOf = String.valueOf(zzyeVar);
        String.valueOf(strValueOf);
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(strValueOf)));
    }

    private static zzye zzg(zzapm zzapmVar) throws GeneralSecurityException {
        int iOrdinal = zzapmVar.ordinal();
        if (iOrdinal == 1) {
            return zzye.zza;
        }
        if (iOrdinal != 2) {
            if (iOrdinal == 3) {
                return zzye.zzc;
            }
            if (iOrdinal != 4) {
                throw new GeneralSecurityException(zzabo.zze((byte) 34, zzapmVar));
            }
        }
        return zzye.zzb;
    }
}
