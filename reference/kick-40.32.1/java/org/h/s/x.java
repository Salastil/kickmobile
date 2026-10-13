package org.h.s;

import expo.modules.securestore.encryptors.AESEncryptor;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.encoding.Base64;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes10.dex */
public abstract class x {
    /* JADX WARN: Code duplicated, block: B:19:0x0067  */
    /* JADX WARN: Code duplicated, block: B:21:0x006b  */
    /* JADX WARN: Code duplicated, block: B:23:0x0073  */
    /* JADX WARN: Code duplicated, block: B:24:0x0079  */
    /* JADX WARN: Code duplicated, block: B:33:? A[RETURN, SYNTHETIC] */
    public static final Pair a(String plainText, Object key) {
        Throwable th;
        byte[] bArr;
        byte[] bArrDoFinal;
        Object objM12684constructorimpl;
        Intrinsics.checkNotNullParameter(plainText, "plainText");
        Intrinsics.checkNotNullParameter(key, "key");
        byte[] bArr2 = null;
        if (plainText.length() == 0) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            SecretKey secretKey = (SecretKey) key;
            bArr = new byte[12];
            try {
                new SecureRandom().nextBytes(bArr);
                cipher.init(1, secretKey, new GCMParameterSpec(128, bArr));
                byte[] bytes = plainText.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                bArrDoFinal = cipher.doFinal(bytes);
                Intrinsics.checkNotNullExpressionValue(bArrDoFinal, "doFinal(...)");
                try {
                    objM12684constructorimpl = Result.m12684constructorimpl(Unit.INSTANCE);
                } catch (Throwable th2) {
                    th = th2;
                    Result.Companion companion2 = Result.INSTANCE;
                    objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
                }
            } catch (Throwable th3) {
                th = th3;
                bArrDoFinal = null;
                Result.Companion companion3 = Result.INSTANCE;
                objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
                if (Result.m12691isSuccessimpl(objM12684constructorimpl)) {
                    return null;
                }
                if (bArr == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(AESEncryptor.IV_PROPERTY);
                    bArr = null;
                }
                if (bArrDoFinal == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("encryptedBytes");
                } else {
                    bArr2 = bArrDoFinal;
                }
                return new Pair(bArr, bArr2);
            }
        } catch (Throwable th4) {
            th = th4;
            bArr = null;
        }
        if (Result.m12691isSuccessimpl(objM12684constructorimpl)) {
            return null;
        }
        if (bArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AESEncryptor.IV_PROPERTY);
            bArr = null;
        }
        if (bArrDoFinal == null) {
            Intrinsics.throwUninitializedPropertyAccessException("encryptedBytes");
        } else {
            bArr2 = bArrDoFinal;
        }
        return new Pair(bArr, bArr2);
    }

    public static final String a(String plainText, String publicKey) {
        Throwable th;
        String strA;
        Object objM12684constructorimpl;
        Intrinsics.checkNotNullParameter(plainText, "plainText");
        Intrinsics.checkNotNullParameter(publicKey, "publicKey");
        if (plainText.length() == 0 || publicKey.length() == 0) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPPadding");
            Intrinsics.checkNotNullParameter(publicKey, "<this>");
            PublicKey publicKeyGeneratePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode$default(Base64.INSTANCE, publicKey, 0, 0, 6, (Object) null)));
            Intrinsics.checkNotNullExpressionValue(publicKeyGeneratePublic, "generatePublic(...)");
            cipher.init(1, publicKeyGeneratePublic);
            byte[] bytes = plainText.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            byte[] bArrDoFinal = cipher.doFinal(bytes);
            Intrinsics.checkNotNullExpressionValue(bArrDoFinal, "doFinal(...)");
            strA = w.a(bArrDoFinal);
            try {
                objM12684constructorimpl = Result.m12684constructorimpl(Unit.INSTANCE);
            } catch (Throwable th2) {
                th = th2;
                Result.Companion companion2 = Result.INSTANCE;
                objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
            }
        } catch (Throwable th3) {
            th = th3;
            strA = null;
        }
        if (!Result.m12691isSuccessimpl(objM12684constructorimpl)) {
            return null;
        }
        if (strA != null) {
            return strA;
        }
        Intrinsics.throwUninitializedPropertyAccessException("encodedString");
        return null;
    }

    public static final String a(Object key) {
        Intrinsics.checkNotNullParameter(key, "key");
        byte[] encoded = ((SecretKey) key).getEncoded();
        Intrinsics.checkNotNullExpressionValue(encoded, "getEncoded(...)");
        return w.a(encoded);
    }
}
