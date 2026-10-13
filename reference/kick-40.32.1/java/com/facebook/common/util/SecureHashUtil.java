package com.facebook.common.util;

import android.util.Base64;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.Metadata;
import kotlin.UShort;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* JADX INFO: compiled from: SecureHashUtil.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\bH\u0007J\u0018\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0005H\u0002J\u0018\u0010\u0011\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0005H\u0002R\u0010\u0010\u000e\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/facebook/common/util/SecureHashUtil;", "", "<init>", "()V", "makeSHA1Hash", "", "text", "bytes", "", "makeSHA256Hash", "makeSHA1HashBase64", "makeMD5Hash", "stream", "Ljava/io/InputStream;", "HEX_CHAR_TABLE", "convertToHex", "raw", "makeHash", "algorithm", "BUFFER_SIZE", "", "fbcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SecureHashUtil {
    private static final int BUFFER_SIZE = 4096;
    public static final SecureHashUtil INSTANCE = new SecureHashUtil();
    public static final byte[] HEX_CHAR_TABLE = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};

    private SecureHashUtil() {
    }

    @JvmStatic
    public static final String makeSHA1Hash(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        try {
            Charset charsetForName = Charset.forName("utf-8");
            Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(...)");
            byte[] bytes = text.getBytes(charsetForName);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            return makeSHA1Hash(bytes);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    @JvmStatic
    public static final String makeSHA1Hash(byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return INSTANCE.makeHash(bytes, "SHA-1");
    }

    @JvmStatic
    public static final String makeSHA256Hash(byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return INSTANCE.makeHash(bytes, "SHA-256");
    }

    @JvmStatic
    public static final String makeSHA1HashBase64(byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(bytes, 0, bytes.length);
            String strEncodeToString = Base64.encodeToString(messageDigest.digest(), 11);
            Intrinsics.checkNotNullExpressionValue(strEncodeToString, "encodeToString(...)");
            return strEncodeToString;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    @JvmStatic
    public static final String makeMD5Hash(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        try {
            Charset charsetForName = Charset.forName("utf-8");
            Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(...)");
            byte[] bytes = text.getBytes(charsetForName);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            return makeMD5Hash(bytes);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    @JvmStatic
    public static final String makeMD5Hash(byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return INSTANCE.makeHash(bytes, MessageDigestAlgorithms.MD5);
    }

    @JvmStatic
    public static final String makeMD5Hash(InputStream stream) throws IOException {
        Intrinsics.checkNotNullParameter(stream, "stream");
        return INSTANCE.makeHash(stream, MessageDigestAlgorithms.MD5);
    }

    @JvmStatic
    public static final String convertToHex(byte[] raw) throws UnsupportedEncodingException {
        Intrinsics.checkNotNullParameter(raw, "raw");
        StringBuilder sb = new StringBuilder(raw.length);
        for (byte b : raw) {
            byte[] bArr = HEX_CHAR_TABLE;
            sb.append((char) (UShort.m12974constructorimpl(bArr[(b & 255) >>> 4]) & 65535));
            sb.append((char) (UShort.m12974constructorimpl(bArr[b & Ascii.SI]) & 65535));
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    private final String makeHash(byte[] bytes, String algorithm) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            messageDigest.update(bytes, 0, bytes.length);
            byte[] bArrDigest = messageDigest.digest();
            Intrinsics.checkNotNull(bArrDigest);
            return convertToHex(bArrDigest);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException(e2);
        }
    }

    private final String makeHash(InputStream stream, String algorithm) throws IOException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            byte[] bArr = new byte[4096];
            while (true) {
                int i = stream.read(bArr);
                if (i > 0) {
                    messageDigest.update(bArr, 0, i);
                } else {
                    byte[] bArrDigest = messageDigest.digest();
                    Intrinsics.checkNotNull(bArrDigest);
                    return convertToHex(bArrDigest);
                }
            }
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException(e2);
        }
    }
}
