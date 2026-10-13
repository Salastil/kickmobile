package expo.modules.crypto.aes.objects;

import expo.modules.crypto.aes.AesConfig;
import expo.modules.crypto.aes.enums.KeySize;
import expo.modules.kotlin.sharedobjects.SharedObject;
import io.ktor.http.ContentDisposition;
import java.security.NoSuchAlgorithmException;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EncryptionKey.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lexpo/modules/crypto/aes/objects/EncryptionKey;", "Lexpo/modules/kotlin/sharedobjects/SharedObject;", ContentDisposition.Parameters.Size, "Lexpo/modules/crypto/aes/enums/KeySize;", "<init>", "(Lexpo/modules/crypto/aes/enums/KeySize;)V", "bytes", "", "([B)V", "keySize", "getKeySize", "()Lexpo/modules/crypto/aes/enums/KeySize;", "cryptoKey", "Ljavax/crypto/SecretKey;", "getCryptoKey", "()Ljavax/crypto/SecretKey;", "getBytes", "()[B", "getAdditionalMemoryPressure", "", "expo-crypto_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class EncryptionKey extends SharedObject {
    private final SecretKey cryptoKey;
    private final KeySize keySize;

    public final KeySize getKeySize() {
        return this.keySize;
    }

    public final SecretKey getCryptoKey() {
        return this.cryptoKey;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EncryptionKey(KeySize size) throws NoSuchAlgorithmException {
        super(null, 1, null);
        Intrinsics.checkNotNullParameter(size, "size");
        KeyGenerator keyGenerator = KeyGenerator.getInstance(AesConfig.CRYPTO_KEY_ALGORITHM);
        keyGenerator.init(size.getBitSize());
        this.keySize = size;
        SecretKey secretKeyGenerateKey = keyGenerator.generateKey();
        Intrinsics.checkNotNullExpressionValue(secretKeyGenerateKey, "generateKey(...)");
        this.cryptoKey = secretKeyGenerateKey;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EncryptionKey(byte[] bytes) {
        super(null, 1, null);
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        this.keySize = KeySize.INSTANCE.fromByteLength(bytes.length);
        this.cryptoKey = new SecretKeySpec(bytes, AesConfig.CRYPTO_KEY_ALGORITHM);
    }

    public final byte[] getBytes() {
        byte[] encoded = this.cryptoKey.getEncoded();
        Intrinsics.checkNotNullExpressionValue(encoded, "getEncoded(...)");
        return encoded;
    }

    @Override // expo.modules.kotlin.sharedobjects.SharedObject
    public int getAdditionalMemoryPressure() {
        return this.keySize.getByteSize();
    }
}
