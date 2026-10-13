package com.kick.mobile.capacitorauthmigrator;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import javax.crypto.Cipher;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PasswordStorageHelper.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/kick/mobile/capacitorauthmigrator/PasswordStorageHelper;", "", "<init>", "()V", "Companion", "capacitor-auth-migrator_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class PasswordStorageHelper {
    private static final String ANDROID_KEYSTORE = "AndroidKeyStore";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int KEY_LENGTH = 2048;
    private static final String KEY_NAME = "token";
    private static final String RSA_ECB_PKCS1_PADDING = "RSA/ECB/PKCS1Padding";
    private static final String SERVICE_NAME = "cap_sec";

    /* JADX INFO: compiled from: PasswordStorageHelper.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eJ\u001a\u0010\u000f\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/kick/mobile/capacitorauthmigrator/PasswordStorageHelper$Companion;", "", "<init>", "()V", "ANDROID_KEYSTORE", "", "SERVICE_NAME", "RSA_ECB_PKCS1_PADDING", "KEY_LENGTH", "", "KEY_NAME", "getToken", "", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "decrypt", "decryptionKey", "Ljava/security/PrivateKey;", "encryptedData", "capacitor-auth-migrator_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final byte[] getToken(Context context) throws NoSuchAlgorithmException, UnrecoverableKeyException, IOException, KeyStoreException, CertificateException {
            String string;
            Intrinsics.checkNotNullParameter(context, "context");
            SharedPreferences sharedPreferences = context.getSharedPreferences(PasswordStorageHelper.SERVICE_NAME, 0);
            Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
            KeyStore keyStore = KeyStore.getInstance(PasswordStorageHelper.ANDROID_KEYSTORE);
            keyStore.load(null);
            Key key = keyStore.getKey(context.getPackageName() + "_cap_sec", null);
            if (key == null || !(key instanceof PrivateKey) || (string = sharedPreferences.getString(PasswordStorageHelper.KEY_NAME, null)) == null) {
                return null;
            }
            return decrypt((PrivateKey) key, string);
        }

        public final byte[] decrypt(PrivateKey decryptionKey, String encryptedData) {
            Intrinsics.checkNotNullParameter(decryptionKey, "decryptionKey");
            if (encryptedData == null) {
                return null;
            }
            int i = 0;
            byte[] bArrDecode = Base64.decode(encryptedData, 0);
            try {
                Cipher cipher = Cipher.getInstance(PasswordStorageHelper.RSA_ECB_PKCS1_PADDING);
                cipher.init(2, decryptionKey);
                if (bArrDecode.length <= 256) {
                    return cipher.doFinal(bArrDecode);
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (i < bArrDecode.length) {
                    int iMin = Math.min(256, bArrDecode.length - i);
                    byteArrayOutputStream.write(cipher.doFinal(bArrDecode, i, iMin));
                    i += iMin;
                }
                return byteArrayOutputStream.toByteArray();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}
