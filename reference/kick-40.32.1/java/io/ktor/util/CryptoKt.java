package io.ktor.util;

import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"io/ktor/util/CryptoKt__CryptoJvmKt", "io/ktor/util/CryptoKt__CryptoKt"}, k = 4, mv = {2, 3, 0}, xi = 48)
public final class CryptoKt {
    public static final int NONCE_SIZE_IN_BYTES = 16;

    public static final Digest Digest(String str) {
        return CryptoKt__CryptoJvmKt.Digest(str);
    }

    public static final Object build(Digest digest, String str, Charset charset, Continuation<? super byte[]> continuation) {
        return CryptoKt__CryptoKt.build(digest, str, charset, continuation);
    }

    public static final Object build(Digest digest, byte[] bArr, Continuation<? super byte[]> continuation) {
        return CryptoKt__CryptoKt.build(digest, bArr, continuation);
    }

    public static final String generateNonce() {
        return CryptoKt__CryptoJvmKt.generateNonce();
    }

    public static final byte[] generateNonce(int i) {
        return CryptoKt__CryptoKt.generateNonce(i);
    }

    public static final Function1<String, byte[]> getDigestFunction(String str, Function1<? super String, String> function1) {
        return CryptoKt__CryptoJvmKt.getDigestFunction(str, function1);
    }

    public static final String hex(byte[] bArr) {
        return CryptoKt__CryptoKt.hex(bArr);
    }

    public static final byte[] hex(String str) {
        return CryptoKt__CryptoKt.hex(str);
    }

    public static final byte[] sha1(byte[] bArr) {
        return CryptoKt__CryptoJvmKt.sha1(bArr);
    }
}
