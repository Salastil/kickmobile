package expo.modules.crypto.aes.extensions;

import expo.modules.crypto.aes.objects.SealedData;
import java.nio.ByteBuffer;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.ShortBufferException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CipherExtensions.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u0014\u0010\u0005\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0001H\u0000¨\u0006\u0007"}, d2 = {"encrypt", "Lexpo/modules/crypto/aes/objects/SealedData;", "Ljavax/crypto/Cipher;", "plaintext", "Ljava/nio/ByteBuffer;", "decrypt", "sealedData", "expo-crypto_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class CipherExtensionsKt {
    public static final SealedData encrypt(Cipher cipher, ByteBuffer plaintext) throws BadPaddingException, IllegalBlockSizeException, ShortBufferException {
        Intrinsics.checkNotNullParameter(cipher, "<this>");
        Intrinsics.checkNotNullParameter(plaintext, "plaintext");
        int iRemaining = plaintext.remaining();
        int outputSize = cipher.getOutputSize(iRemaining) - iRemaining;
        byte[] iv = cipher.getIV();
        Intrinsics.checkNotNullExpressionValue(iv, "getIV(...)");
        SealedData sealedData = new SealedData(iv, iRemaining, outputSize);
        cipher.doFinal(plaintext, sealedData.getTaggedCiphertextBuffer$expo_crypto_release());
        return sealedData;
    }

    public static final ByteBuffer decrypt(Cipher cipher, SealedData sealedData) throws BadPaddingException, IllegalBlockSizeException, ShortBufferException {
        Intrinsics.checkNotNullParameter(cipher, "<this>");
        Intrinsics.checkNotNullParameter(sealedData, "sealedData");
        ByteBuffer taggedCiphertextBuffer$expo_crypto_release = sealedData.getTaggedCiphertextBuffer$expo_crypto_release();
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(cipher.getOutputSize(taggedCiphertextBuffer$expo_crypto_release.remaining()));
        cipher.doFinal(taggedCiphertextBuffer$expo_crypto_release, byteBufferAllocate);
        Intrinsics.checkNotNullExpressionValue(byteBufferAllocate, "also(...)");
        return byteBufferAllocate;
    }
}
