package com.google.android.gms.internal.pal;

import android.os.Build;
import expo.modules.crypto.aes.AesConfig;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Objects;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzaat {
    private static final ThreadLocal zza = new zzaas();

    public static Cipher zza() {
        return (Cipher) zza.get();
    }

    public static SecretKey zzb(byte[] bArr) throws GeneralSecurityException {
        zzarn.zza(bArr.length);
        return new SecretKeySpec(bArr, AesConfig.CRYPTO_KEY_ALGORITHM);
    }

    public static AlgorithmParameterSpec zzc(byte[] bArr, int i, int i2) {
        Charset charset = zzajp.zza;
        Integer numValueOf = !Objects.equals(System.getProperty("java.vendor"), "The Android Project") ? null : Integer.valueOf(Build.VERSION.SDK_INT);
        return (numValueOf == null || numValueOf.intValue() > 19) ? new GCMParameterSpec(128, bArr, 0, i2) : new IvParameterSpec(bArr, 0, i2);
    }
}
