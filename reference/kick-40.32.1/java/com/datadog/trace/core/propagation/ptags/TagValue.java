package com.datadog.trace.core.propagation.ptags;

import com.datadog.trace.api.cache.DDCaches;
import com.datadog.trace.api.cache.DDPartialKeyCache;
import com.datadog.trace.logger.Logger;
import com.datadog.trace.logger.LoggerFactory;

/* JADX INFO: loaded from: classes6.dex */
final class TagValue extends TagElement {
    private final int hash;
    private final int source;
    private final CharSequence[] values;
    private static final Logger log = LoggerFactory.getLogger((Class<?>) TagValue.class);
    private static final DDPartialKeyCache<CharSequence, TagValue> valueCache = DDCaches.newFixedSizePartialKeyCache(128);
    private static final int DD_SOURCE = TagElement.Encoding.DATADOG.ordinal();

    /* JADX INFO: Access modifiers changed from: private */
    interface CharConverter {
        char convert(char c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static char convertDDtoW3C(char c) {
        if (c == ',' || c == ';' || c == '~') {
            return '_';
        }
        if (c == '=') {
            return '~';
        }
        return c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static char convertW3CtoDD(char c) {
        if (c == '~') {
            return '=';
        }
        return c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static char identity(char c) {
        return c;
    }

    static TagValue from(CharSequence charSequence) {
        return from(TagElement.Encoding.DATADOG, charSequence);
    }

    static TagValue from(TagElement.Encoding encoding, CharSequence charSequence) {
        return from(encoding, charSequence, charSequence == null ? -1 : 0, charSequence != null ? charSequence.length() : -1);
    }

    static TagValue from(TagElement.Encoding encoding, CharSequence charSequence, int i, int i2) {
        if (charSequence == null || isValueInvalid(charSequence, i, i2)) {
            Logger logger = log;
            if (!logger.isDebugEnabled()) {
                return null;
            }
            logger.debug("Invalid header h: {} s: {} b: {} e: {}", encoding, charSequence, Integer.valueOf(i), Integer.valueOf(i2));
            return null;
        }
        if (encoding == TagElement.Encoding.W3C) {
            return valueCache.computeIfAbsent(charSequence, i, i2, new DDPartialKeyCache.Hasher() { // from class: com.datadog.trace.core.propagation.ptags.TagValue$$ExternalSyntheticLambda3
                @Override // com.datadog.trace.api.cache.DDPartialKeyCache.Hasher
                public final int apply(Object obj, int i3, int i4) {
                    return TagValue.hashW3C((CharSequence) obj, i3, i4);
                }
            }, new DDPartialKeyCache.Comparator() { // from class: com.datadog.trace.core.propagation.ptags.TagValue$$ExternalSyntheticLambda4
                @Override // com.datadog.trace.api.cache.DDPartialKeyCache.Comparator
                public final boolean test(Object obj, int i3, int i4, Object obj2) {
                    return TagValue.compareW3C((CharSequence) obj, i3, i4, (TagValue) obj2);
                }
            }, new DDPartialKeyCache.Producer() { // from class: com.datadog.trace.core.propagation.ptags.TagValue$$ExternalSyntheticLambda5
                @Override // com.datadog.trace.api.cache.DDPartialKeyCache.Producer
                public final Object apply(Object obj, int i3, int i4, int i5) {
                    return TagValue.produceW3C((CharSequence) obj, i3, i4, i5);
                }
            });
        }
        return valueCache.computeIfAbsent(charSequence, i, i2, new DDPartialKeyCache.Hasher() { // from class: com.datadog.trace.core.propagation.ptags.TagValue$$ExternalSyntheticLambda6
            @Override // com.datadog.trace.api.cache.DDPartialKeyCache.Hasher
            public final int apply(Object obj, int i3, int i4) {
                return TagValue.hashDD((CharSequence) obj, i3, i4);
            }
        }, new DDPartialKeyCache.Comparator() { // from class: com.datadog.trace.core.propagation.ptags.TagValue$$ExternalSyntheticLambda7
            @Override // com.datadog.trace.api.cache.DDPartialKeyCache.Comparator
            public final boolean test(Object obj, int i3, int i4, Object obj2) {
                return TagValue.compareDD((CharSequence) obj, i3, i4, (TagValue) obj2);
            }
        }, new DDPartialKeyCache.Producer() { // from class: com.datadog.trace.core.propagation.ptags.TagValue$$ExternalSyntheticLambda8
            @Override // com.datadog.trace.api.cache.DDPartialKeyCache.Producer
            public final Object apply(Object obj, int i3, int i4, int i5) {
                return TagValue.produceDD((CharSequence) obj, i3, i4, i5);
            }
        });
    }

    private static boolean isValueInvalid(CharSequence charSequence, int i, int i2) {
        return i < 0 || i2 <= 0 || charSequence.length() < i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int hashDD(CharSequence charSequence, int i, int i2) {
        return hash(new TagValue$$ExternalSyntheticLambda1(), charSequence, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int hashW3C(CharSequence charSequence, int i, int i2) {
        return hash(new TagValue$$ExternalSyntheticLambda0(), charSequence, i, i2);
    }

    private static int hash(CharConverter charConverter, CharSequence charSequence, int i, int i2) {
        int iMin = Integer.min(charSequence.length(), i2);
        int iConvert = 0;
        if (i >= 0 && iMin > 0) {
            while (i < iMin) {
                iConvert = (iConvert * 31) + charConverter.convert(charSequence.charAt(i));
                i++;
            }
        }
        return iConvert;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean compareDD(CharSequence charSequence, int i, int i2, TagValue tagValue) {
        return compare(new TagValue$$ExternalSyntheticLambda0(), charSequence, i, i2, tagValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean compareW3C(CharSequence charSequence, int i, int i2, TagValue tagValue) {
        return compare(new TagValue$$ExternalSyntheticLambda2(), charSequence, i, i2, tagValue);
    }

    private static boolean compare(CharConverter charConverter, CharSequence charSequence, int i, int i2, TagValue tagValue) {
        int iMin = Integer.min(charSequence.length(), i2);
        if (i < 0 || iMin < 0 || iMin - i != tagValue.length()) {
            return false;
        }
        int i3 = 0;
        boolean z = true;
        while (z && i < iMin) {
            z = charConverter.convert(charSequence.charAt(i)) == tagValue.charAt(i3);
            i++;
            i3++;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TagValue produceDD(CharSequence charSequence, int i, int i2, int i3) {
        return new TagValue(TagElement.Encoding.DATADOG, i, charSequence, i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TagValue produceW3C(CharSequence charSequence, int i, int i2, int i3) {
        return new TagValue(TagElement.Encoding.W3C, i, charSequence, i2, i3);
    }

    TagValue(TagElement.Encoding encoding, int i, CharSequence charSequence, int i2, int i3) {
        CharSequence[] charSequenceArr = new CharSequence[TagElement.Encoding.getNumValues()];
        this.values = charSequenceArr;
        int iOrdinal = encoding.ordinal();
        this.source = iOrdinal;
        this.hash = i;
        if (i2 != 0 || i3 != charSequence.length()) {
            StringBuilder sb = new StringBuilder(i3 - i2);
            sb.append(charSequence, i2, i3);
            charSequence = sb.toString();
        }
        charSequenceArr[iOrdinal] = charSequence;
    }

    @Override // com.datadog.trace.core.propagation.ptags.TagElement
    CharSequence forType(TagElement.Encoding encoding) {
        int iOrdinal = encoding.ordinal();
        CharSequence[] charSequenceArr = this.values;
        CharSequence charSequence = charSequenceArr[iOrdinal];
        if (charSequence != null) {
            return charSequence;
        }
        CharSequence string = charSequenceArr[this.source];
        int length = string.length();
        CharConverter tagValue$$ExternalSyntheticLambda1 = this.source == DD_SOURCE ? new TagValue$$ExternalSyntheticLambda1() : new TagValue$$ExternalSyntheticLambda2();
        StringBuilder sb = null;
        for (int i = 0; i < length; i++) {
            char cCharAt = string.charAt(i);
            char cConvert = tagValue$$ExternalSyntheticLambda1.convert(cCharAt);
            if (cConvert != cCharAt && sb == null) {
                sb = new StringBuilder(length);
                sb.append(string, 0, i);
            }
            if (sb != null) {
                sb.append(cConvert);
            }
        }
        CharSequence[] charSequenceArr2 = this.values;
        if (sb != null) {
            string = sb.toString();
        }
        charSequenceArr2[iOrdinal] = string;
        return string;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TagValue tagValue = (TagValue) obj;
        if (this.hash != tagValue.hash) {
            return false;
        }
        CharSequence charSequence = this.values[this.source];
        CharSequence charSequence2 = tagValue.values[tagValue.source];
        int length = charSequence.length();
        if (length != charSequence2.length()) {
            return false;
        }
        int i = this.source;
        if (i == tagValue.source) {
            for (int i2 = 0; i2 < length; i2++) {
                if (charSequence.charAt(i2) != charSequence2.charAt(i2)) {
                    return false;
                }
            }
        } else {
            int i3 = DD_SOURCE;
            CharConverter tagValue$$ExternalSyntheticLambda0 = i == i3 ? new TagValue$$ExternalSyntheticLambda0() : new TagValue$$ExternalSyntheticLambda2();
            CharConverter tagValue$$ExternalSyntheticLambda1 = tagValue.source == i3 ? new TagValue$$ExternalSyntheticLambda0() : new TagValue$$ExternalSyntheticLambda2();
            for (int i4 = 0; i4 < length; i4++) {
                if (tagValue$$ExternalSyntheticLambda0.convert(charSequence.charAt(i4)) != tagValue$$ExternalSyntheticLambda1.convert(charSequence2.charAt(i4))) {
                    return false;
                }
            }
        }
        return true;
    }

    public int hashCode() {
        return this.hash;
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.values[this.source].toString();
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.values[this.source].length();
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        int i2 = this.source;
        int i3 = DD_SOURCE;
        CharSequence[] charSequenceArr = this.values;
        if (i2 == i3) {
            return charSequenceArr[i2].charAt(i);
        }
        return convertW3CtoDD(charSequenceArr[i2].charAt(i));
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        return this.values[this.source].subSequence(i, i2);
    }

    public int indexOf(char c) {
        if (this.source != DD_SOURCE) {
            c = convertDDtoW3C(c);
        }
        CharSequence charSequence = this.values[this.source];
        int length = charSequence.length();
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            if (charSequence.charAt(i2) == c) {
                i = i2;
            }
        }
        return i;
    }
}
