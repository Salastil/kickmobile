package com.google.android.gms.internal.pal;

import java.math.BigInteger;
import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzaer {
    public static final /* synthetic */ int zza = 0;
    private static final zzarq zzb;
    private static final zzarq zzc;
    private static final zzais zzd;
    private static final zzaip zze;
    private static final zzahp zzf;
    private static final zzahm zzg;
    private static final zzahp zzh;
    private static final zzahm zzi;
    private static final zzahb zzj;
    private static final zzahb zzk;
    private static final zzahb zzl;
    private static final zzahb zzm;

    static {
        zzarq zzarqVarZza = zzajp.zza("type.googleapis.com/google.crypto.tink.HpkePrivateKey");
        zzb = zzarqVarZza;
        zzarq zzarqVarZza2 = zzajp.zza("type.googleapis.com/google.crypto.tink.HpkePublicKey");
        zzc = zzarqVarZza2;
        zzd = zzais.zzd(zzaeq.zza, zzaej.class, zzajf.class);
        zze = zzaip.zzd(zzael.zza, zzarqVarZza, zzajf.class);
        zzf = zzahp.zzd(zzaem.zza, zzaes.class, zzaje.class);
        zzg = zzahm.zzd(zzaen.zza, zzarqVarZza2, zzaje.class);
        zzh = zzahp.zzd(zzaeo.zza, zzaek.class, zzaje.class);
        zzi = zzahm.zzd(zzaep.zza, zzarqVarZza, zzaje.class);
        zzaha zzahaVarZza = zzahb.zza();
        zzahaVarZza.zza(zzapm.RAW, zzaei.zzc);
        zzahaVarZza.zza(zzapm.TINK, zzaei.zza);
        zzahaVarZza.zza(zzapm.LEGACY, zzaei.zzb);
        zzahaVarZza.zza(zzapm.CRUNCHY, zzaei.zzb);
        zzj = zzahaVarZza.zzb();
        zzaha zzahaVarZza2 = zzahb.zza();
        zzahaVarZza2.zza(zzaog.DHKEM_P256_HKDF_SHA256, zzaeh.zza);
        zzahaVarZza2.zza(zzaog.DHKEM_P384_HKDF_SHA384, zzaeh.zzb);
        zzahaVarZza2.zza(zzaog.DHKEM_P521_HKDF_SHA512, zzaeh.zzc);
        zzahaVarZza2.zza(zzaog.DHKEM_X25519_HKDF_SHA256, zzaeh.zzf);
        zzk = zzahaVarZza2.zzb();
        zzaha zzahaVarZza3 = zzahb.zza();
        zzahaVarZza3.zza(zzaof.HKDF_SHA256, zzaeg.zza);
        zzahaVarZza3.zza(zzaof.HKDF_SHA384, zzaeg.zzb);
        zzahaVarZza3.zza(zzaof.HKDF_SHA512, zzaeg.zzc);
        zzl = zzahaVarZza3.zzb();
        zzaha zzahaVarZza4 = zzahb.zza();
        zzahaVarZza4.zza(zzaoe.AES_128_GCM, zzaed.zza);
        zzahaVarZza4.zza(zzaoe.AES_256_GCM, zzaed.zzb);
        zzahaVarZza4.zza(zzaoe.CHACHA20_POLY1305, zzaed.zzc);
        zzm = zzahaVarZza4.zzb();
    }

    public static void zza(zzail zzailVar) throws GeneralSecurityException {
        zzailVar.zzd(zzd);
        zzailVar.zze(zze);
        zzailVar.zzb(zzf);
        zzailVar.zzc(zzg);
        zzailVar.zzb(zzh);
        zzailVar.zzc(zzi);
    }

    static /* synthetic */ zzajf zzb(zzaej zzaejVar) {
        zzaos zzaosVarZze = zzaot.zze();
        zzaosVarZze.zza("type.googleapis.com/google.crypto.tink.HpkePrivateKey");
        zzaoh zzaohVarZzc = zzaoi.zzc();
        zzaohVarZzc.zza(zzh(zzaejVar));
        zzaosVarZze.zzb(((zzaoi) zzaohVarZzc.zzal()).zzaQ());
        zzaosVarZze.zzc((zzapm) zzj.zzb(zzaejVar.zzf()));
        return zzajf.zza((zzaot) zzaosVarZze.zzal());
    }

    static /* synthetic */ zzaej zzc(zzajf zzajfVar) throws GeneralSecurityException {
        if (!zzajfVar.zzc().zza().equals("type.googleapis.com/google.crypto.tink.HpkePrivateKey")) {
            String strZza = zzajfVar.zzc().zza();
            String.valueOf(strZza);
            throw new IllegalArgumentException("Wrong type URL in call to HpkeProtoSerialization.parseParameters: ".concat(String.valueOf(strZza)));
        }
        try {
            return zzj(zzajfVar.zzc().zzc(), zzaoi.zzb(zzajfVar.zzc().zzb(), zzaty.zza()).zza());
        } catch (zzavb e) {
            throw new GeneralSecurityException("Parsing HpkeParameters failed: ", e);
        }
    }

    static /* synthetic */ zzaes zze(zzaje zzajeVar, zzwm zzwmVar) throws GeneralSecurityException {
        if (!zzajeVar.zze().equals("type.googleapis.com/google.crypto.tink.HpkePublicKey")) {
            String strZze = zzajeVar.zze();
            String.valueOf(strZze);
            throw new IllegalArgumentException("Wrong type URL in call to HpkeProtoSerialization.parsePublicKey: ".concat(String.valueOf(strZze)));
        }
        try {
            zzaoo zzaooVarZzd = zzaoo.zzd(zzajeVar.zza(), zzaty.zza());
            if (zzaooVarZzd.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzaej zzaejVarZzj = zzj(zzajeVar.zzb(), zzaooVarZzd.zzb());
            return zzaes.zzc(zzaejVarZzj, zzk(zzaejVarZzj.zzc(), zzaooVarZzd.zzc().zzx()), zzajeVar.zzc());
        } catch (zzavb unused) {
            throw new GeneralSecurityException("Parsing HpkePublicKey failed");
        }
    }

    static /* synthetic */ zzaje zzf(zzaek zzaekVar, zzwm zzwmVar) {
        zzaol zzaolVarZze = zzaom.zze();
        zzaolVarZze.zza(0);
        zzaolVarZze.zzb(zzi(zzaekVar.zzf()));
        byte[] bArrZzb = zzaekVar.zzd().zzb(zzwmVar);
        zzaolVarZze.zzc(zzatl.zzr(bArrZzb, 0, bArrZzb.length));
        return zzaje.zzf("type.googleapis.com/google.crypto.tink.HpkePrivateKey", ((zzaom) zzaolVarZze.zzal()).zzaQ(), 4, (zzapm) zzj.zzb(zzaekVar.zze().zzf()), zzaekVar.zzf().zzb());
    }

    static /* synthetic */ zzaek zzg(zzaje zzajeVar, zzwm zzwmVar) throws GeneralSecurityException {
        if (!zzajeVar.zze().equals("type.googleapis.com/google.crypto.tink.HpkePrivateKey")) {
            String strZze = zzajeVar.zze();
            String.valueOf(strZze);
            throw new IllegalArgumentException("Wrong type URL in call to HpkeProtoSerialization.parsePrivateKey: ".concat(String.valueOf(strZze)));
        }
        try {
            zzaom zzaomVarZzd = zzaom.zzd(zzajeVar.zza(), zzaty.zza());
            if (zzaomVarZzd.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzaoo zzaooVarZzb = zzaomVarZzd.zzb();
            if (zzaooVarZzb.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzaej zzaejVarZzj = zzj(zzajeVar.zzb(), zzaooVarZzb.zzb());
            zzaes zzaesVarZzc = zzaes.zzc(zzaejVarZzj, zzk(zzaejVarZzj.zzc(), zzaooVarZzb.zzc().zzx()), zzajeVar.zzc());
            zzaeh zzaehVarZzc = zzaejVarZzj.zzc();
            BigInteger bigInteger = new BigInteger(1, zzaomVarZzd.zzc().zzx());
            byte[] bArr = zzagm.zza;
            int i = 32;
            if (zzaehVarZzc != zzaeh.zzf && zzaehVarZzc != zzaeh.zza) {
                if (zzaehVarZzc == zzaeh.zzb) {
                    i = 48;
                } else {
                    if (zzaehVarZzc != zzaeh.zzc) {
                        throw new GeneralSecurityException("Unrecognized HPKE KEM identifier");
                    }
                    i = 66;
                }
            }
            return zzaek.zzc(zzaesVarZzc, zzars.zza(zzagv.zzb(bigInteger, i), zzwmVar));
        } catch (zzavb unused) {
            throw new GeneralSecurityException("Parsing HpkePrivateKey failed");
        }
    }

    private static zzaok zzh(zzaej zzaejVar) throws GeneralSecurityException {
        zzaoj zzaojVarZzd = zzaok.zzd();
        zzaojVarZzd.zza((zzaog) zzk.zzb(zzaejVar.zzc()));
        zzaojVarZzd.zzb((zzaof) zzl.zzb(zzaejVar.zzd()));
        zzaojVarZzd.zzc((zzaoe) zzm.zzb(zzaejVar.zze()));
        return (zzaok) zzaojVarZzd.zzal();
    }

    private static zzaoo zzi(zzaes zzaesVar) throws GeneralSecurityException {
        zzaon zzaonVarZze = zzaoo.zze();
        zzaonVarZze.zza(0);
        zzaonVarZze.zzb(zzh(zzaesVar.zze()));
        byte[] bArrZzb = zzaesVar.zzd().zzb();
        zzaonVarZze.zzc(zzatl.zzr(bArrZzb, 0, bArrZzb.length));
        return (zzaoo) zzaonVarZze.zzal();
    }

    private static zzaej zzj(zzapm zzapmVar, zzaok zzaokVar) throws GeneralSecurityException {
        zzaef zzaefVar = new zzaef(null);
        zzaefVar.zzd((zzaei) zzj.zzc(zzapmVar));
        zzaefVar.zza((zzaeh) zzk.zzc(zzaokVar.zza()));
        zzaefVar.zzb((zzaeg) zzl.zzc(zzaokVar.zzb()));
        zzaefVar.zzc((zzaed) zzm.zzc(zzaokVar.zzc()));
        return zzaefVar.zze();
    }

    private static zzarq zzk(zzaeh zzaehVar, byte[] bArr) throws GeneralSecurityException {
        int i;
        BigInteger bigInteger = new BigInteger(1, bArr);
        byte[] bArr2 = zzagm.zza;
        if (zzaehVar == zzaeh.zzf) {
            i = 32;
        } else if (zzaehVar == zzaeh.zza) {
            i = 65;
        } else if (zzaehVar == zzaeh.zzb) {
            i = 97;
        } else {
            if (zzaehVar != zzaeh.zzc) {
                throw new GeneralSecurityException("Unrecognized HPKE KEM identifier");
            }
            i = 133;
        }
        return zzarq.zza(zzagv.zzb(bigInteger, i));
    }
}
