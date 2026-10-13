package com.google.android.gms.internal.p002firebaseauthapi;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzzj implements zzbr {
    static final zznx<zzzq, zzkl.zzc> zza = zznx.zza().zza(zzzq.NIST_P256, zzkl.zzc.zza).zza(zzzq.NIST_P384, zzkl.zzc.zzb).zza(zzzq.NIST_P521, zzkl.zzc.zzc).zza();
    static final zznx<zzzp, zzkl.zze> zzb = zznx.zza().zza(zzzp.UNCOMPRESSED, zzkl.zze.zzb).zza(zzzp.COMPRESSED, zzkl.zze.zza).zza(zzzp.DO_NOT_USE_CRUNCHY_UNCOMPRESSED, zzkl.zze.zzc).zza();
    private final zzzl zzc;
    private final String zzd;
    private final byte[] zze;
    private final zzzp zzf;
    private final zzlu zzg;
    private final byte[] zzh;

    public static zzbr zza(zzkr zzkrVar) throws GeneralSecurityException {
        zzzq zzzqVar = (zzzq) zza.zza(((zzkl) ((zzln) zzkrVar.zza())).zzd());
        byte[] byteArray = zzkrVar.zzf().getAffineX().toByteArray();
        byte[] byteArray2 = zzkrVar.zzf().getAffineY().toByteArray();
        ECParameterSpec eCParameterSpecZza = zzzn.zza(zzzqVar);
        ECPoint eCPoint = new ECPoint(new BigInteger(1, byteArray), new BigInteger(1, byteArray2));
        zznv.zza(eCPoint, eCParameterSpecZza.getCurve());
        ECPublicKey eCPublicKey = (ECPublicKey) zzzr.zze.zza("EC").generatePublic(new ECPublicKeySpec(eCPoint, eCParameterSpecZza));
        byte[] bArrZzb = new byte[0];
        if (((zzkl) ((zzln) zzkrVar.zza())).zzh() != null) {
            bArrZzb = ((zzkl) ((zzln) zzkrVar.zza())).zzh().zzb();
        }
        return new zzzj(eCPublicKey, bArrZzb, zza(((zzkl) ((zzln) zzkrVar.zza())).zze()), (zzzp) zzb.zza(((zzkl) ((zzln) zzkrVar.zza())).zzf()), zzlq.zza((zzkl) ((zzln) zzkrVar.zza())), zzkrVar.zzd().zzb());
    }

    static final String zza(zzkl.zzb zzbVar) throws GeneralSecurityException {
        if (zzbVar.equals(zzkl.zzb.zza)) {
            return "HmacSha1";
        }
        if (zzbVar.equals(zzkl.zzb.zzb)) {
            return "HmacSha224";
        }
        if (zzbVar.equals(zzkl.zzb.zzc)) {
            return "HmacSha256";
        }
        if (zzbVar.equals(zzkl.zzb.zzd)) {
            return "HmacSha384";
        }
        if (zzbVar.equals(zzkl.zzb.zze)) {
            return "HmacSha512";
        }
        throw new GeneralSecurityException("hash unsupported for EciesAeadHkdf: " + String.valueOf(zzbVar));
    }

    private zzzj(ECPublicKey eCPublicKey, byte[] bArr, String str, zzzp zzzpVar, zzlu zzluVar, byte[] bArr2) throws GeneralSecurityException {
        zznv.zza(eCPublicKey.getW(), eCPublicKey.getParams().getCurve());
        this.zzc = new zzzl(eCPublicKey);
        this.zze = bArr;
        this.zzd = str;
        this.zzf = zzzpVar;
        this.zzg = zzluVar;
        this.zzh = bArr2;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbr
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        zzzo zzzoVarZza = this.zzc.zza(this.zzd, this.zze, bArr2, this.zzg.zza(), this.zzf);
        return this.zzg.zza(zzzoVarZza.zzb(), this.zzh, zzzoVarZza.zza(), bArr);
    }
}
