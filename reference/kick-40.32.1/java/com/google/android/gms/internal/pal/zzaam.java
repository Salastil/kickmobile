package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzaam {
    public static final /* synthetic */ int zza = 0;
    private static final zzarq zzb;
    private static final zzais zzc;
    private static final zzaip zzd;
    private static final zzahp zze;
    private static final zzahm zzf;

    static {
        zzarq zzarqVarZza = zzajp.zza("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey");
        zzb = zzarqVarZza;
        zzc = zzais.zzd(zzaal.zza, zzxf.class, zzajf.class);
        zzd = zzaip.zzd(zzaai.zza, zzarqVarZza, zzajf.class);
        zze = zzahp.zzd(zzaaj.zza, zzwx.class, zzaje.class);
        zzf = zzahm.zzd(zzaak.zza, zzarqVarZza, zzaje.class);
    }

    public static void zza(zzail zzailVar) throws GeneralSecurityException {
        zzailVar.zzd(zzc);
        zzailVar.zze(zzd);
        zzailVar.zzb(zze);
        zzailVar.zzc(zzf);
    }

    static /* synthetic */ zzajf zzb(zzxf zzxfVar) {
        zzaos zzaosVarZze = zzaot.zze();
        zzaosVarZze.zza("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey");
        zzamf zzamfVarZzd = zzamg.zzd();
        zzamj zzamjVarZzc = zzamk.zzc();
        zzaml zzamlVarZzb = zzamm.zzb();
        zzamlVarZzb.zza(zzxfVar.zzf());
        zzamjVarZzc.zza((zzamm) zzamlVarZzb.zzal());
        zzamjVarZzc.zzb(zzxfVar.zzc());
        zzamfVarZzd.zza((zzamk) zzamjVarZzc.zzal());
        zzaoa zzaoaVarZze = zzaob.zze();
        zzaoaVarZze.zza(zzi(zzxfVar));
        zzaoaVarZze.zzb(zzxfVar.zzd());
        zzamfVarZzd.zzb((zzaob) zzaoaVarZze.zzal());
        zzaosVarZze.zzb(((zzamg) zzamfVarZzd.zzal()).zzaQ());
        zzaosVarZze.zzc(zzf(zzxfVar.zzg()));
        return zzajf.zza((zzaot) zzaosVarZze.zzal());
    }

    static /* synthetic */ zzxf zzc(zzajf zzajfVar) throws GeneralSecurityException {
        if (!zzajfVar.zzc().zza().equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
            String strZza = zzajfVar.zzc().zza();
            String.valueOf(strZza);
            throw new IllegalArgumentException("Wrong type URL in call to AesCtrHmacAeadProtoSerialization.parseParameters: ".concat(String.valueOf(strZza)));
        }
        try {
            zzamg zzamgVarZzc = zzamg.zzc(zzajfVar.zzc().zzb(), zzaty.zza());
            if (zzamgVarZzc.zzb().zzc() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzxc zzxcVarZzb = zzxf.zzb();
            zzxcVarZzb.zza(zzamgVarZzc.zza().zzb());
            zzxcVarZzb.zzb(zzamgVarZzc.zzb().zzb());
            zzxcVarZzb.zzc(zzamgVarZzc.zza().zza().zza());
            zzxcVarZzb.zzd(zzamgVarZzc.zzb().zza().zzb());
            zzxcVarZzb.zzf(zzh(zzamgVarZzc.zzb().zza().zza()));
            zzxcVarZzb.zze(zzg(zzajfVar.zzc().zzc()));
            return zzxcVarZzb.zzg();
        } catch (zzavb e) {
            throw new GeneralSecurityException("Parsing AesCtrHmacAeadParameters failed: ", e);
        }
    }

    static /* synthetic */ zzaje zzd(zzwx zzwxVar, zzwm zzwmVar) {
        zzamd zzamdVarZze = zzame.zze();
        zzamh zzamhVarZzd = zzami.zzd();
        zzaml zzamlVarZzb = zzamm.zzb();
        zzamlVarZzb.zza(zzwxVar.zzg().zzf());
        zzamhVarZzd.zza((zzamm) zzamlVarZzb.zzal());
        byte[] bArrZzb = zzwxVar.zze().zzb(zzwmVar);
        zzamhVarZzd.zzb(zzatl.zzr(bArrZzb, 0, bArrZzb.length));
        zzamdVarZze.zza((zzami) zzamhVarZzd.zzal());
        zzany zzanyVarZze = zzanz.zze();
        zzanyVarZze.zza(zzi(zzwxVar.zzg()));
        byte[] bArrZzb2 = zzwxVar.zzf().zzb(zzwmVar);
        zzanyVarZze.zzb(zzatl.zzr(bArrZzb2, 0, bArrZzb2.length));
        zzamdVarZze.zzb((zzanz) zzanyVarZze.zzal());
        return zzaje.zzf("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey", ((zzame) zzamdVarZze.zzal()).zzaQ(), 3, zzf(zzwxVar.zzg().zzg()), zzwxVar.zzb());
    }

    static /* synthetic */ zzwx zze(zzaje zzajeVar, zzwm zzwmVar) throws GeneralSecurityException {
        if (!zzajeVar.zze().equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesCtrHmacAeadProtoSerialization.parseKey");
        }
        try {
            zzame zzameVarZzd = zzame.zzd(zzajeVar.zza(), zzaty.zza());
            if (zzameVarZzd.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            if (zzameVarZzd.zzb().zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys inner AES CTR keys are accepted");
            }
            if (zzameVarZzd.zzc().zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys inner HMAC keys are accepted");
            }
            zzxc zzxcVarZzb = zzxf.zzb();
            zzxcVarZzb.zza(zzameVarZzd.zzb().zzc().zzb());
            zzxcVarZzb.zzb(zzameVarZzd.zzc().zzc().zzb());
            zzxcVarZzb.zzc(zzameVarZzd.zzb().zzb().zza());
            zzxcVarZzb.zzd(zzameVarZzd.zzc().zzb().zzb());
            zzxcVarZzb.zzf(zzh(zzameVarZzd.zzc().zzb().zza()));
            zzxcVarZzb.zze(zzg(zzajeVar.zzb()));
            zzxf zzxfVarZzg = zzxcVarZzb.zzg();
            zzww zzwwVarZzd = zzwx.zzd();
            zzwwVarZzd.zza(zzxfVarZzg);
            zzwwVarZzd.zzb(zzars.zza(zzameVarZzd.zzb().zzc().zzx(), zzwmVar));
            zzwwVarZzd.zzc(zzars.zza(zzameVarZzd.zzc().zzc().zzx(), zzwmVar));
            zzwwVarZzd.zzd(zzajeVar.zzc());
            return zzwwVarZzd.zze();
        } catch (zzavb unused) {
            throw new GeneralSecurityException("Parsing AesCtrHmacAeadKey failed");
        }
    }

    private static zzapm zzf(zzxe zzxeVar) throws GeneralSecurityException {
        if (zzxe.zza.equals(zzxeVar)) {
            return zzapm.TINK;
        }
        if (zzxe.zzb.equals(zzxeVar)) {
            return zzapm.CRUNCHY;
        }
        if (zzxe.zzc.equals(zzxeVar)) {
            return zzapm.RAW;
        }
        String strValueOf = String.valueOf(zzxeVar);
        String.valueOf(strValueOf);
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(strValueOf)));
    }

    private static zzxe zzg(zzapm zzapmVar) throws GeneralSecurityException {
        int iOrdinal = zzapmVar.ordinal();
        if (iOrdinal == 1) {
            return zzxe.zza;
        }
        if (iOrdinal != 2) {
            if (iOrdinal == 3) {
                return zzxe.zzc;
            }
            if (iOrdinal != 4) {
                throw new GeneralSecurityException(zzabo.zze((byte) 34, zzapmVar));
            }
        }
        return zzxe.zzb;
    }

    private static zzxd zzh(zzanx zzanxVar) throws GeneralSecurityException {
        int iOrdinal = zzanxVar.ordinal();
        if (iOrdinal == 1) {
            return zzxd.zza;
        }
        if (iOrdinal == 2) {
            return zzxd.zzd;
        }
        if (iOrdinal == 3) {
            return zzxd.zzc;
        }
        if (iOrdinal == 4) {
            return zzxd.zze;
        }
        if (iOrdinal == 5) {
            return zzxd.zzb;
        }
        int iZza = zzanxVar.zza();
        StringBuilder sb = new StringBuilder(String.valueOf(iZza).length() + 26);
        sb.append("Unable to parse HashType: ");
        sb.append(iZza);
        throw new GeneralSecurityException(sb.toString());
    }

    private static zzaod zzi(zzxf zzxfVar) throws GeneralSecurityException {
        zzanx zzanxVar;
        zzaoc zzaocVarZzc = zzaod.zzc();
        zzaocVarZzc.zzb(zzxfVar.zze());
        zzxd zzxdVarZzh = zzxfVar.zzh();
        if (zzxd.zza.equals(zzxdVarZzh)) {
            zzanxVar = zzanx.SHA1;
        } else if (zzxd.zzb.equals(zzxdVarZzh)) {
            zzanxVar = zzanx.SHA224;
        } else if (zzxd.zzc.equals(zzxdVarZzh)) {
            zzanxVar = zzanx.SHA256;
        } else if (zzxd.zzd.equals(zzxdVarZzh)) {
            zzanxVar = zzanx.SHA384;
        } else {
            if (!zzxd.zze.equals(zzxdVarZzh)) {
                String strValueOf = String.valueOf(zzxdVarZzh);
                String.valueOf(strValueOf);
                throw new GeneralSecurityException("Unable to serialize HashType ".concat(String.valueOf(strValueOf)));
            }
            zzanxVar = zzanx.SHA512;
        }
        zzaocVarZzc.zza(zzanxVar);
        return (zzaod) zzaocVarZzc.zzal();
    }
}
