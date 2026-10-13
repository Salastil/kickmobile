package com.google.android.gms.internal.pal;

import expo.modules.crypto.aes.AesConfig;
import java.security.GeneralSecurityException;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzaqc implements zzvr {
    static {
        new zzaqb();
    }

    private zzaqc(byte[] bArr, int i, byte[] bArr2) throws GeneralSecurityException {
        if (!zzaco.zza(1)) {
            throw new GeneralSecurityException("Can not use AES-EAX in FIPS-mode.");
        }
        if (i != 12 && i != 16) {
            throw new IllegalArgumentException("IV size should be either 12 or 16 bytes");
        }
        int length = bArr.length;
        zzarn.zza(length);
        new SecretKeySpec(bArr, AesConfig.CRYPTO_KEY_ALGORITHM);
        zzarj.zzb(zzalp.zzc(zzalq.zzb(length), zzars.zza(bArr, zzvx.zza())));
    }

    public static zzvr zzb(zzxh zzxhVar) throws GeneralSecurityException {
        if (!zzaco.zza(1)) {
            throw new GeneralSecurityException("Can not use AES-EAX in FIPS-mode.");
        }
        zzxhVar.zzf();
        return new zzaqc(zzxhVar.zze().zzb(zzvx.zza()), zzxhVar.zzf().zzd(), zzxhVar.zzc().zzb());
    }

    @Override // com.google.android.gms.internal.pal.zzvr
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        throw null;
    }
}
