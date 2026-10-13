package com.google.android.gms.internal.pal;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.interfaces.ECPrivateKey;
import java.security.spec.ECPrivateKeySpec;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzaql implements zzvv {
    private zzaql(ECPrivateKey eCPrivateKey, byte[] bArr, String str, zzaqq zzaqqVar, zzafp zzafpVar, byte[] bArr2) {
    }

    public static zzvv zza(zzaeb zzaebVar) throws GeneralSecurityException {
        zzaqp zzaqpVar = (zzaqp) zzaqm.zza.zzb(zzaebVar.zzg().zzc());
        byte[] bArrZza = zzagv.zza(zzaebVar.zzf().zzb(zzvx.zza()));
        ECPrivateKey eCPrivateKey = (ECPrivateKey) ((KeyFactory) zzaqx.zze.zzb("EC")).generatePrivate(new ECPrivateKeySpec(new BigInteger(1, bArrZza), zzaqr.zzd(zzaqpVar)));
        byte[] bArrZzb = new byte[0];
        if (zzaebVar.zzg().zzh() != null) {
            bArrZzb = zzaebVar.zzg().zzh().zzb();
        }
        return new zzaql(eCPrivateKey, bArrZzb, zzaqm.zzb(zzaebVar.zzg().zzd()), (zzaqq) zzaqm.zzb.zzb(zzaebVar.zzg().zze()), zzafq.zza(zzaebVar.zzg()), zzaebVar.zzh().zzg().zzb());
    }
}
