package com.amazonaws.ivs.player;

import java.security.Key;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes9.dex */
class CipherEncrypt {
    private static final String ALGORITHM = "AES";
    private static final int AUTH_TAG_LENGTH_BITS = 128;
    private static final int IV_LENGTH_BYTES = 12;
    private static final String TRANSFORMATION = "AES/GCM/NoPadding";
    private final Key secretKey;
    private final SecureRandom secureRandom;

    CipherEncrypt() {
        SecureRandom secureRandom = new SecureRandom();
        this.secureRandom = secureRandom;
        byte[] bArr = new byte[16];
        secureRandom.nextBytes(bArr);
        this.secretKey = new SecretKeySpec(bArr, "AES");
    }

    byte[] encrypt(byte[] bArr) throws Exception {
        byte[] bArr2 = new byte[12];
        this.secureRandom.nextBytes(bArr2);
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(1, this.secretKey, new GCMParameterSpec(128, bArr2));
        byte[] bArrDoFinal = cipher.doFinal(bArr);
        byte[] bArr3 = new byte[bArrDoFinal.length + 12];
        System.arraycopy(bArr2, 0, bArr3, 0, 12);
        System.arraycopy(bArrDoFinal, 0, bArr3, 12, bArrDoFinal.length);
        return bArr3;
    }

    byte[] decrypt(byte[] bArr) throws Exception {
        byte[] bArr2 = new byte[12];
        System.arraycopy(bArr, 0, bArr2, 0, 12);
        int length = bArr.length - 12;
        byte[] bArr3 = new byte[length];
        System.arraycopy(bArr, 12, bArr3, 0, length);
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(2, this.secretKey, new GCMParameterSpec(128, bArr2));
        return cipher.doFinal(bArr3);
    }
}
