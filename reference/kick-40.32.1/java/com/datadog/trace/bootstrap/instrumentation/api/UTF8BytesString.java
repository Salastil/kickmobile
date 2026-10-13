package com.datadog.trace.bootstrap.instrumentation.api;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes6.dex */
public final class UTF8BytesString implements CharSequence {
    public static final UTF8BytesString EMPTY = create("");
    private final String string;
    private byte[] utf8Bytes;

    public static UTF8BytesString create(CharSequence charSequence) {
        if (charSequence == null) {
            return null;
        }
        if (charSequence instanceof UTF8BytesString) {
            return (UTF8BytesString) charSequence;
        }
        return new UTF8BytesString(String.valueOf(charSequence));
    }

    public static UTF8BytesString create(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return new UTF8BytesString(bArr);
    }

    public static UTF8BytesString create(String str, byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return new UTF8BytesString(str, bArr);
    }

    public static UTF8BytesString create(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return null;
        }
        byte[] bArr = new byte[byteBuffer.remaining()];
        byteBuffer.get(bArr);
        return new UTF8BytesString(bArr);
    }

    private UTF8BytesString(String str) {
        this.string = str;
    }

    private UTF8BytesString(byte[] bArr) {
        this(new String(bArr, StandardCharsets.UTF_8), bArr);
    }

    private UTF8BytesString(String str, byte[] bArr) {
        this.string = str;
        this.utf8Bytes = bArr;
    }

    public void transferTo(ByteBuffer byteBuffer) {
        encodeIfNecessary();
        byteBuffer.put(this.utf8Bytes);
    }

    public byte[] getUtf8Bytes() {
        encodeIfNecessary();
        return this.utf8Bytes;
    }

    public int encodedLength() {
        encodeIfNecessary();
        return this.utf8Bytes.length;
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.string;
    }

    private void encodeIfNecessary() {
        if (this.utf8Bytes == null) {
            this.utf8Bytes = this.string.getBytes(StandardCharsets.UTF_8);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        return this.string.equals(obj instanceof UTF8BytesString ? ((UTF8BytesString) obj).string : null);
    }

    public int hashCode() {
        return this.string.hashCode();
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.string.length();
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        return this.string.charAt(i);
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        return this.string.subSequence(i, i2);
    }
}
