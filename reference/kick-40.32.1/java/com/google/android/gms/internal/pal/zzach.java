package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzach {
    public static final /* synthetic */ int zza = 0;
    private static final zzarq zzb;
    private static final zzais zzc;
    private static final zzaip zzd;
    private static final zzahp zze;
    private static final zzahm zzf;

    static {
        zzarq zzarqVarZza = zzajp.zza("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key");
        zzb = zzarqVarZza;
        zzc = zzais.zzd(zzacg.zza, zzaah.class, zzajf.class);
        zzd = zzaip.zzd(zzacd.zza, zzarqVarZza, zzajf.class);
        zze = zzahp.zzd(zzace.zza, zzaab.class, zzaje.class);
        zzf = zzahm.zzd(zzacf.zza, zzarqVarZza, zzaje.class);
    }

    public static void zza(zzail zzailVar) throws GeneralSecurityException {
        zzailVar.zzd(zzc);
        zzailVar.zze(zzd);
        zzailVar.zzb(zze);
        zzailVar.zzc(zzf);
    }

    static /* synthetic */ zzajf zzb(zzaah zzaahVar) {
        zzaos zzaosVarZze = zzaot.zze();
        zzaosVarZze.zza("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key");
        zzaosVarZze.zzb(zzapy.zzc().zzaQ());
        zzaosVarZze.zzc(zzf(zzaahVar.zzd()));
        return zzajf.zza((zzaot) zzaosVarZze.zzal());
    }

    static /* synthetic */ zzaah zzc(zzajf zzajfVar) throws GeneralSecurityException {
        if (!zzajfVar.zzc().zza().equals("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key")) {
            String strZza = zzajfVar.zzc().zza();
            String.valueOf(strZza);
            throw new IllegalArgumentException("Wrong type URL in call to XChaCha20Poly1305ProtoSerialization.parseParameters: ".concat(String.valueOf(strZza)));
        }
        try {
            if (zzapy.zzb(zzajfVar.zzc().zzb(), zzaty.zza()).zza() == 0) {
                return zzaah.zzc(zzg(zzajfVar.zzc().zzc()));
            }
            throw new GeneralSecurityException("Only version 0 parameters are accepted");
        } catch (zzavb e) {
            throw new GeneralSecurityException("Parsing XChaCha20Poly1305Parameters failed: ", e);
        }
    }

    static /* synthetic */ zzaje zzd(zzaab zzaabVar, zzwm zzwmVar) {
        zzapv zzapvVarZzd = zzapw.zzd();
        byte[] bArrZzb = zzaabVar.zze().zzb(zzwmVar);
        zzapvVarZzd.zza(zzatl.zzr(bArrZzb, 0, bArrZzb.length));
        return zzaje.zzf("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key", ((zzapw) zzapvVarZzd.zzal()).zzaQ(), 3, zzf(zzaabVar.zzf().zzd()), zzaabVar.zzb());
    }

    static /* synthetic */ zzaab zze(zzaje zzajeVar, zzwm zzwmVar) throws GeneralSecurityException {
        if (!zzajeVar.zze().equals("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key")) {
            throw new IllegalArgumentException("Wrong type URL in call to XChaCha20Poly1305ProtoSerialization.parseKey");
        }
        try {
            zzapw zzapwVarZzc = zzapw.zzc(zzajeVar.zza(), zzaty.zza());
            if (zzapwVarZzc.zza() == 0) {
                return zzaab.zzd(zzg(zzajeVar.zzb()), zzars.zza(zzapwVarZzc.zzb().zzx(), zzwmVar), zzajeVar.zzc());
            }
            throw new GeneralSecurityException("Only version 0 keys are accepted");
        } catch (zzavb unused) {
            throw new GeneralSecurityException("Parsing XChaCha20Poly1305Key failed");
        }
    }

    private static zzapm zzf(zzaag zzaagVar) throws GeneralSecurityException {
        if (zzaag.zza.equals(zzaagVar)) {
            return zzapm.TINK;
        }
        if (zzaag.zzb.equals(zzaagVar)) {
            return zzapm.CRUNCHY;
        }
        if (zzaag.zzc.equals(zzaagVar)) {
            return zzapm.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(zzaagVar.toString()));
    }

    private static zzaag zzg(zzapm zzapmVar) throws GeneralSecurityException {
        int iOrdinal = zzapmVar.ordinal();
        if (iOrdinal == 1) {
            return zzaag.zza;
        }
        if (iOrdinal != 2) {
            if (iOrdinal == 3) {
                return zzaag.zzc;
            }
            if (iOrdinal != 4) {
                throw new GeneralSecurityException(zzabo.zze((byte) 34, zzapmVar));
            }
        }
        return zzaag.zzb;
    }
}
