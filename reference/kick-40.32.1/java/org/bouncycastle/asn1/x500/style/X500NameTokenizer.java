package org.bouncycastle.asn1.x500.style;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes10.dex */
public class X500NameTokenizer {
    private int index;
    private final char separator;
    private final String value;

    public X500NameTokenizer(String str) {
        this(str, AbstractJsonLexerKt.COMMA);
    }

    public X500NameTokenizer(String str, char c) {
        str.getClass();
        if (c == '\"' || c == '\\') {
            throw new IllegalArgumentException("reserved separator character");
        }
        this.value = str;
        this.separator = c;
        this.index = str.length() < 1 ? 0 : -1;
    }

    public boolean hasMoreTokens() {
        return this.index < this.value.length();
    }

    public String nextToken() {
        if (this.index >= this.value.length()) {
            return null;
        }
        int i = this.index + 1;
        boolean z = false;
        boolean z2 = false;
        while (true) {
            int i2 = this.index + 1;
            this.index = i2;
            if (i2 >= this.value.length()) {
                if (!z && !z2) {
                    break;
                }
                throw new IllegalArgumentException("badly formatted directory string");
            }
            char cCharAt = this.value.charAt(this.index);
            if (z) {
                z = false;
            } else if (cCharAt == '\"') {
                z2 = !z2;
            } else if (z2) {
                continue;
            } else if (cCharAt == '\\') {
                z = true;
            } else if (cCharAt == this.separator) {
                break;
            }
        }
        return this.value.substring(i, this.index);
    }
}
