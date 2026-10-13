package com.datadog.trace.bootstrap.instrumentation.api;

import com.datadog.android.trace.internal.compat.function.Supplier;
import com.datadog.trace.logger.Logger;
import com.datadog.trace.logger.LoggerFactory;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes6.dex */
public class URIUtils {
    private static final byte[] REPLACEMENT = {-17, -65, -67};
    private static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) URIUtils.class);

    private URIUtils() {
    }

    public static String decode(String str) {
        return decode(str, false);
    }

    public static String decode(String str, boolean z) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length == 0 || (str.indexOf(37) < 0 && (!z || str.indexOf(43) < 0))) {
            return str;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(length + 2);
        int i = 0;
        while (i < length) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '%') {
                int i2 = i + 2;
                if (i2 < length) {
                    int iDigit = Character.digit(str.charAt(i + 1), 16);
                    int iDigit2 = Character.digit(str.charAt(i2), 16);
                    if ((iDigit | iDigit2) < 0) {
                        byte[] bArr = REPLACEMENT;
                        byteBufferAllocate.put(bArr[0]);
                        byteBufferAllocate.put(bArr[1]);
                        byteBufferAllocate.put(bArr[2]);
                    } else {
                        byteBufferAllocate.put((byte) ((iDigit << 4) + iDigit2));
                    }
                    i = i2;
                } else {
                    byte[] bArr2 = REPLACEMENT;
                    byteBufferAllocate.put(bArr2[0]);
                    byteBufferAllocate.put(bArr2[1]);
                    byteBufferAllocate.put(bArr2[2]);
                    i = length;
                }
            } else {
                if (z && cCharAt == '+') {
                    cCharAt = ' ';
                }
                byteBufferAllocate.put((byte) cCharAt);
            }
            i++;
        }
        byteBufferAllocate.flip();
        return new String(byteBufferAllocate.array(), 0, byteBufferAllocate.limit(), StandardCharsets.UTF_8);
    }

    public static URI safeParse(String str) {
        if (str == null) {
            return null;
        }
        try {
            return URI.create(str);
        } catch (IllegalArgumentException e) {
            LOGGER.debug("Unable to parse request uri {}", str, e);
            return null;
        }
    }

    public static abstract class LazyUrl implements CharSequence, Supplier<String> {
        protected String lazy;

        public abstract String path();

        protected LazyUrl(String str) {
            this.lazy = str;
        }

        @Override // java.lang.CharSequence
        public String toString() {
            String str = this.lazy;
            if (str != null) {
                return str;
            }
            String str2 = get();
            this.lazy = str2;
            return str2;
        }

        @Override // java.lang.CharSequence
        public int length() {
            return toString().length();
        }

        @Override // java.lang.CharSequence
        public char charAt(int i) {
            return toString().charAt(i);
        }

        @Override // java.lang.CharSequence
        public CharSequence subSequence(int i, int i2) {
            return toString().subSequence(i, i2);
        }

        public int hashCode() {
            return toString().hashCode();
        }
    }
}
