package com.google.android.gms.internal.pal;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzaqm implements zzvw {
    static final zzahb zza;
    static final zzahb zzb;
    private final zzaqo zzc;
    private final String zzd;
    private final byte[] zze;
    private final zzaqq zzf;
    private final zzafp zzg;
    private final byte[] zzh;

    static {
        zzaha zzahaVarZza = zzahb.zza();
        zzahaVarZza.zza(zzaqp.NIST_P256, zzadv.zza);
        zzahaVarZza.zza(zzaqp.NIST_P384, zzadv.zzb);
        zzahaVarZza.zza(zzaqp.NIST_P521, zzadv.zzc);
        zza = zzahaVarZza.zzb();
        zzaha zzahaVarZza2 = zzahb.zza();
        zzahaVarZza2.zza(zzaqq.UNCOMPRESSED, zzady.zzb);
        zzahaVarZza2.zza(zzaqq.COMPRESSED, zzady.zza);
        zzahaVarZza2.zza(zzaqq.DO_NOT_USE_CRUNCHY_UNCOMPRESSED, zzady.zzc);
        zzb = zzahaVarZza2.zzb();
    }

    private zzaqm(ECPublicKey eCPublicKey, byte[] bArr, String str, zzaqq zzaqqVar, zzafp zzafpVar, byte[] bArr2) throws GeneralSecurityException {
        zzagz.zza(eCPublicKey.getW(), eCPublicKey.getParams().getCurve());
        this.zzc = new zzaqo(eCPublicKey);
        this.zze = bArr;
        this.zzd = str;
        this.zzf = zzaqqVar;
        this.zzg = zzafpVar;
        this.zzh = bArr2;
    }

    static final String zzb(zzadx zzadxVar) throws GeneralSecurityException {
        if (zzadxVar.equals(zzadx.zza)) {
            return "HmacSha1";
        }
        if (zzadxVar.equals(zzadx.zzb)) {
            return "HmacSha224";
        }
        if (zzadxVar.equals(zzadx.zzc)) {
            return "HmacSha256";
        }
        if (zzadxVar.equals(zzadx.zzd)) {
            return "HmacSha384";
        }
        if (zzadxVar.equals(zzadx.zze)) {
            return "HmacSha512";
        }
        String strValueOf = String.valueOf(zzadxVar);
        String.valueOf(strValueOf);
        throw new GeneralSecurityException("hash unsupported for EciesAeadHkdf: ".concat(String.valueOf(strValueOf)));
    }

    public static zzvw zzc(zzaec zzaecVar) throws GeneralSecurityException {
        zzaqp zzaqpVar = (zzaqp) zza.zzb(zzaecVar.zzh().zzc());
        byte[] byteArray = zzaecVar.zze().getAffineX().toByteArray();
        byte[] byteArray2 = zzaecVar.zze().getAffineY().toByteArray();
        ECParameterSpec eCParameterSpecZzd = zzaqr.zzd(zzaqpVar);
        ECPoint eCPoint = new ECPoint(new BigInteger(1, byteArray), new BigInteger(1, byteArray2));
        zzagz.zza(eCPoint, eCParameterSpecZzd.getCurve());
        ECPublicKey eCPublicKey = (ECPublicKey) ((KeyFactory) zzaqx.zze.zzb("EC")).generatePublic(new ECPublicKeySpec(eCPoint, eCParameterSpecZzd));
        byte[] bArrZzb = new byte[0];
        if (zzaecVar.zzh().zzh() != null) {
            bArrZzb = zzaecVar.zzh().zzh().zzb();
        }
        return new zzaqm(eCPublicKey, bArrZzb, zzb(zzaecVar.zzh().zzd()), (zzaqq) zzb.zzb(zzaecVar.zzh().zze()), zzafq.zza(zzaecVar.zzh()), zzaecVar.zzg().zzb());
    }

    @Override // com.google.android.gms.internal.pal.zzvw
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        zzafp zzafpVar = this.zzg;
        zzaqn zzaqnVarZza = this.zzc.zza(this.zzd, this.zze, bArr2, zzafpVar.zza(), this.zzf);
        return zzafpVar.zzb(zzaqnVarZza.zzb(), this.zzh, zzaqnVarZza.zza(), bArr);
    }
}
