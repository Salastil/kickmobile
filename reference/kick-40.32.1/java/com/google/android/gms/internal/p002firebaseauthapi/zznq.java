package com.google.android.gms.internal.p002firebaseauthapi;

import android.security.keystore.KeyGenParameterSpec;
import com.google.android.gms.stats.CodePackage;
import com.google.crypto.tink.integration.android.AndroidKeystoreKmsClient;
import expo.modules.crypto.aes.AesConfig;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStoreException;
import java.util.Arrays;
import java.util.Locale;
import javax.crypto.KeyGenerator;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zznq implements zzco {
    private static final Object zza = new Object();

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
    public static final class zza {
        public zza() {
            zznq.zza();
        }
    }

    static /* synthetic */ boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzco
    public final zzbm zza(String str) throws GeneralSecurityException {
        zznr zznrVar;
        try {
            synchronized (zza) {
                zznrVar = new zznr(zzaap.zza(AndroidKeystoreKmsClient.PREFIX, str));
                byte[] bArrZza = zzqm.zza(10);
                byte[] bArr = new byte[0];
                if (!Arrays.equals(bArrZza, zznrVar.zza(zznrVar.zzb(bArrZza, bArr), bArr))) {
                    throw new KeyStoreException("cannot use Android Keystore: encryption/decryption of non-empty message and empty aad returns an incorrect result");
                }
            }
            return zznrVar;
        } catch (IOException e) {
            throw new GeneralSecurityException(e);
        }
    }

    public zznq() throws GeneralSecurityException {
        this(new zza());
    }

    private zznq(zza zzaVar) {
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzco
    public final boolean zzb(String str) {
        return str.toLowerCase(Locale.US).startsWith(AndroidKeystoreKmsClient.PREFIX);
    }

    static boolean zzc(String str) throws GeneralSecurityException {
        synchronized (zza) {
            String strZza = zzaap.zza(AndroidKeystoreKmsClient.PREFIX, str);
            if (zznp.zzb(strZza)) {
                return false;
            }
            KeyGenParameterSpec keyGenParameterSpecBuild = new KeyGenParameterSpec.Builder(strZza, 3).setKeySize(256).setBlockModes(CodePackage.GCM).setEncryptionPaddings("NoPadding").build();
            KeyGenerator keyGenerator = KeyGenerator.getInstance(AesConfig.CRYPTO_KEY_ALGORITHM, "AndroidKeyStore");
            keyGenerator.init(keyGenParameterSpecBuild);
            keyGenerator.generateKey();
            return true;
        }
    }
}
