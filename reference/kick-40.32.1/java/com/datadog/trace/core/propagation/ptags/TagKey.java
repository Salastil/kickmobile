package com.datadog.trace.core.propagation.ptags;

import com.datadog.trace.api.cache.DDCaches;
import com.datadog.trace.api.cache.DDPartialKeyCache;
import com.datadog.trace.logger.Logger;
import com.datadog.trace.logger.LoggerFactory;

/* JADX INFO: loaded from: classes6.dex */
final class TagKey extends TagElement {
    private final String[] keys = new String[TagElement.Encoding.getNumValues()];
    private final String none;
    private static final Logger log = LoggerFactory.getLogger((Class<?>) TagKey.class);
    private static final DDPartialKeyCache<String, TagKey> keyCache = DDCaches.newFixedSizePartialKeyCache(64);

    static TagKey from(String str) {
        if (str == null || isHeaderInvalid(str, 0, str.length(), (String) null)) {
            Logger logger = log;
            if (logger.isDebugEnabled()) {
                logger.debug("Invalid header s: {}", str);
            }
            return null;
        }
        return keyCache.computeIfAbsent(str, 0, str.length(), new TagKey$$ExternalSyntheticLambda0(), new TagKey$$ExternalSyntheticLambda1(), new TagKey$$ExternalSyntheticLambda2());
    }

    static TagKey from(TagElement.Encoding encoding, String str) {
        if (isHeaderInvalid(encoding, str)) {
            Logger logger = log;
            if (!logger.isDebugEnabled()) {
                return null;
            }
            logger.debug("Invalid header h: {} s: {}", encoding, str);
            return null;
        }
        return keyCache.computeIfAbsent(str, encoding.getPrefixLength(), str.length(), new TagKey$$ExternalSyntheticLambda0(), new TagKey$$ExternalSyntheticLambda1(), new TagKey$$ExternalSyntheticLambda2());
    }

    static TagKey from(TagElement.Encoding encoding, String str, int i, int i2) {
        if (isHeaderInvalid(encoding, str, i, i2)) {
            Logger logger = log;
            if (!logger.isDebugEnabled()) {
                return null;
            }
            logger.debug("Invalid header h: {} s: {} b: {} e: {}", encoding, str, Integer.valueOf(i), Integer.valueOf(i2));
            return null;
        }
        return keyCache.computeIfAbsent(str, i + encoding.getPrefixLength(), i2, new TagKey$$ExternalSyntheticLambda0(), new TagKey$$ExternalSyntheticLambda1(), new TagKey$$ExternalSyntheticLambda2());
    }

    private static boolean isHeaderInvalid(TagElement.Encoding encoding, String str) {
        if (encoding == null || str == null) {
            return true;
        }
        return isHeaderInvalid(encoding, str, 0, str.length());
    }

    private static boolean isHeaderInvalid(TagElement.Encoding encoding, String str, int i, int i2) {
        if (encoding == null || str == null) {
            return true;
        }
        return isHeaderInvalid(str, i, i2, encoding.getPrefix());
    }

    private static boolean isHeaderInvalid(String str, int i, int i2, String str2) {
        int length = str2 == null ? 0 : str2.length();
        int length2 = str.length();
        if (i < 0 || i2 <= 0 || i2 - i <= length || length2 <= length || length2 < i2) {
            return true;
        }
        return (str2 == null || str.startsWith(str2, i)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int hash(String str, int i, int i2) {
        int iMin = Integer.min(str.length(), i2);
        int iCharAt = 0;
        if (i >= 0 && iMin > 0) {
            while (i < iMin) {
                iCharAt = (iCharAt * 31) + str.charAt(i);
                i++;
            }
        }
        return iCharAt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean compare(String str, int i, int i2, TagKey tagKey) {
        int iMin = Integer.min(str.length(), i2);
        if (i < 0 || iMin < 0 || iMin - i != tagKey.length()) {
            return false;
        }
        int i3 = 0;
        boolean z = true;
        while (z && i < iMin) {
            z = str.charAt(i) == tagKey.charAt(i3);
            i++;
            i3++;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TagKey produce(String str, int i, int i2, int i3) {
        return new TagKey(str, i2, i3);
    }

    TagKey(String str, int i, int i2) {
        this.none = (i == 0 && i2 == str.length()) ? str : str.substring(i, i2);
        for (TagElement.Encoding encoding : TagElement.Encoding.getCachedValues()) {
            this.keys[encoding.ordinal()] = encoding.getPrefix() + this.none;
        }
    }

    @Override // com.datadog.trace.core.propagation.ptags.TagElement
    CharSequence forType(TagElement.Encoding encoding) {
        return this.keys[encoding.ordinal()];
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.none.equals(((TagKey) obj).none);
    }

    public int hashCode() {
        return this.none.hashCode();
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.none;
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.none.length();
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        return this.none.charAt(i);
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        return this.none.subSequence(i, i2);
    }
}
