package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzabl {
    public static final /* synthetic */ int zza = 0;
    private static final zzarq zzb;
    private static final zzais zzc;
    private static final zzaip zzd;
    private static final zzahp zze;
    private static final zzahm zzf;

    static {
        zzarq zzarqVarZza = zzajp.zza("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key");
        zzb = zzarqVarZza;
        zzc = zzais.zzd(zzabk.zza, zzyl.class, zzajf.class);
        zzd = zzaip.zzd(zzabh.zza, zzarqVarZza, zzajf.class);
        zze = zzahp.zzd(zzabi.zza, zzyg.class, zzaje.class);
        zzf = zzahm.zzd(zzabj.zza, zzarqVarZza, zzaje.class);
    }

    public static void zza(zzail zzailVar) throws GeneralSecurityException {
        zzailVar.zzd(zzc);
        zzailVar.zze(zzd);
        zzailVar.zzb(zze);
        zzailVar.zzc(zzf);
    }

    static /* synthetic */ zzajf zzb(zzyl zzylVar) {
        zzaos zzaosVarZze = zzaot.zze();
        zzaosVarZze.zza("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key");
        zzaosVarZze.zzb(zzani.zzb().zzaQ());
        zzaosVarZze.zzc(zzf(zzylVar.zzc()));
        return zzajf.zza((zzaot) zzaosVarZze.zzal());
    }

    static /* synthetic */ zzyl zzc(zzajf zzajfVar) throws GeneralSecurityException {
        if (!zzajfVar.zzc().zza().equals("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key")) {
            String strZza = zzajfVar.zzc().zza();
            String.valueOf(strZza);
            throw new IllegalArgumentException("Wrong type URL in call to ChaCha20Poly1305ProtoSerialization.parseParameters: ".concat(String.valueOf(strZza)));
        }
        try {
            zzani.zza(zzajfVar.zzc().zzb(), zzaty.zza());
            return zzyl.zzb(zzg(zzajfVar.zzc().zzc()));
        } catch (zzavb e) {
            throw new GeneralSecurityException("Parsing ChaCha20Poly1305Parameters failed: ", e);
        }
    }

    static /* synthetic */ zzaje zzd(zzyg zzygVar, zzwm zzwmVar) {
        zzanf zzanfVarZzd = zzang.zzd();
        byte[] bArrZzb = zzygVar.zze().zzb(zzwmVar);
        zzanfVarZzd.zza(zzatl.zzr(bArrZzb, 0, bArrZzb.length));
        return zzaje.zzf("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key", ((zzang) zzanfVarZzd.zzal()).zzaQ(), 3, zzf(zzygVar.zzf().zzc()), zzygVar.zzb());
    }

    static /* synthetic */ zzyg zze(zzaje zzajeVar, zzwm zzwmVar) throws GeneralSecurityException {
        if (!zzajeVar.zze().equals("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key")) {
            throw new IllegalArgumentException("Wrong type URL in call to ChaCha20Poly1305ProtoSerialization.parseKey");
        }
        try {
            zzang zzangVarZzc = zzang.zzc(zzajeVar.zza(), zzaty.zza());
            if (zzangVarZzc.zza() == 0) {
                return zzyg.zzd(zzg(zzajeVar.zzb()), zzars.zza(zzangVarZzc.zzb().zzx(), zzwmVar), zzajeVar.zzc());
            }
            throw new GeneralSecurityException("Only version 0 keys are accepted");
        } catch (zzavb unused) {
            throw new GeneralSecurityException("Parsing ChaCha20Poly1305Key failed");
        }
    }

    private static zzapm zzf(zzyk zzykVar) throws GeneralSecurityException {
        if (zzyk.zza.equals(zzykVar)) {
            return zzapm.TINK;
        }
        if (zzyk.zzb.equals(zzykVar)) {
            return zzapm.CRUNCHY;
        }
        if (zzyk.zzc.equals(zzykVar)) {
            return zzapm.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(zzykVar.toString()));
    }

    private static zzyk zzg(zzapm zzapmVar) throws GeneralSecurityException {
        int iOrdinal = zzapmVar.ordinal();
        if (iOrdinal == 1) {
            return zzyk.zza;
        }
        if (iOrdinal != 2) {
            if (iOrdinal == 3) {
                return zzyk.zzc;
            }
            if (iOrdinal != 4) {
                throw new GeneralSecurityException(zzabo.zze((byte) 34, zzapmVar));
            }
        }
        return zzyk.zzb;
    }
}
