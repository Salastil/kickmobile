package expo.modules.crypto.aes;

import kotlin.Metadata;

/* JADX INFO: compiled from: AesConfig.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lexpo/modules/crypto/aes/AesConfig;", "", "<init>", "()V", "DEFAULT_IV_SIZE", "", "DEFAULT_TAG_SIZE", "CRYPTO_KEY_ALGORITHM", "", "CIPHER_TRANSFORMATION_NAME", "expo-crypto_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AesConfig {
    public static final String CIPHER_TRANSFORMATION_NAME = "AES/GCM/NoPadding";
    public static final String CRYPTO_KEY_ALGORITHM = "AES";
    public static final int DEFAULT_IV_SIZE = 12;
    public static final int DEFAULT_TAG_SIZE = 16;
    public static final AesConfig INSTANCE = new AesConfig();

    private AesConfig() {
    }
}
