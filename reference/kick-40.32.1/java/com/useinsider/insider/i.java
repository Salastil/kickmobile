package com.useinsider.insider;

import android.util.Base64;
import expo.modules.crypto.aes.AesConfig;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
class i {
    private final byte[] c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f341a = "AES/GCM/NoPadding";
    private final String b = AesConfig.CRYPTO_KEY_ALGORITHM;
    private final int d = 12;
    private final int e = 128;
    private final int f = 16;

    i(byte[] bArr) {
        this.c = bArr;
    }

    String a(byte[] bArr, l lVar) {
        try {
            byte[] bArrB = lVar.b();
            byte[] bArr2 = new byte[12];
            new SecureRandom().nextBytes(bArr2);
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(1, new SecretKeySpec(this.c, AesConfig.CRYPTO_KEY_ALGORITHM), new GCMParameterSpec(128, bArr2));
            byte[] bArrDoFinal = cipher.doFinal(bArr);
            byte[] bArr3 = new byte[bArrB.length + 12 + bArrDoFinal.length];
            System.arraycopy(bArrB, 0, bArr3, 0, bArrB.length);
            System.arraycopy(bArr2, 0, bArr3, bArrB.length, 12);
            System.arraycopy(bArrDoFinal, 0, bArr3, bArrB.length + 12, bArrDoFinal.length);
            return Base64.encodeToString(bArr3, 2);
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return null;
        }
    }

    String b(byte[] bArr, byte[] bArr2) {
        try {
            byte[] bArr3 = new byte[12];
            byte[] bArr4 = new byte[16];
            int iMin = Math.min(bArr.length, 12);
            int iMin2 = Math.min(bArr2.length, 16);
            System.arraycopy(bArr, 0, bArr3, 0, iMin);
            System.arraycopy(bArr2, 0, bArr4, 0, iMin2);
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(1, new SecretKeySpec(bArr4, AesConfig.CRYPTO_KEY_ALGORITHM), new GCMParameterSpec(128, bArr3));
            byte[] bArrDoFinal = cipher.doFinal(bArr);
            byte[] bArr5 = new byte[bArrDoFinal.length + 12];
            System.arraycopy(bArr3, 0, bArr5, 0, 12);
            System.arraycopy(bArrDoFinal, 0, bArr5, 12, bArrDoFinal.length);
            return Base64.encodeToString(bArr5, 2);
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return null;
        }
    }

    String a(byte[] bArr) {
        try {
            if (bArr.length <= 12) {
                return null;
            }
            byte[] bArr2 = new byte[12];
            int length = bArr.length - 12;
            byte[] bArr3 = new byte[length];
            System.arraycopy(bArr, 0, bArr2, 0, 12);
            System.arraycopy(bArr, 12, bArr3, 0, length);
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(2, new SecretKeySpec(this.c, AesConfig.CRYPTO_KEY_ALGORITHM), new GCMParameterSpec(128, bArr2));
            return new String(cipher.doFinal(bArr3));
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return null;
        }
    }

    String a(byte[] bArr, byte[] bArr2) {
        try {
            if (bArr.length <= 12) {
                return null;
            }
            int iMin = Math.min(bArr2.length, 16);
            byte[] bArr3 = new byte[12];
            int length = bArr.length - 12;
            byte[] bArr4 = new byte[length];
            byte[] bArr5 = new byte[16];
            System.arraycopy(bArr, 0, bArr3, 0, 12);
            System.arraycopy(bArr, 12, bArr4, 0, length);
            System.arraycopy(bArr2, 0, bArr5, 0, iMin);
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(2, new SecretKeySpec(bArr5, AesConfig.CRYPTO_KEY_ALGORITHM), new GCMParameterSpec(128, bArr3));
            return new String(cipher.doFinal(bArr4));
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return null;
        }
    }
}
