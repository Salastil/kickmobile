package com.datadog.trace.core.propagation.ptags;

import com.datadog.android.trace.internal.compat.function.IntPredicate;
import com.datadog.trace.core.propagation.PropagationTags;
import com.datadog.trace.logger.LoggerFactory;
import com.datadog.trace.relocate.api.RatelimitedLogger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes6.dex */
final class DatadogPTagsCodec extends PTagsCodec {
    private static final int MAX_ALLOWED_CHAR = 126;
    private static final int MIN_ALLOWED_CHAR = 32;
    private static final String PROPAGATION_ERROR_DECODING_ERROR = "decoding_error";
    private static final String PROPAGATION_ERROR_EXTRACT_MAX_SIZE = "extract_max_size";
    private static final char TAGS_SEPARATOR = ',';
    private static final char TAG_KEY_SEPARATOR = '=';
    private static final RatelimitedLogger log = new RatelimitedLogger(LoggerFactory.getLogger((Class<?>) DatadogPTagsCodec.class), 5, TimeUnit.MINUTES);
    private final int xDatadogTagsLimit;

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isAllowedKeyChar(int i) {
        return i > 32 && i <= 126 && i != 44;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isAllowedValueChar(int i) {
        return i >= 32 && i <= 126;
    }

    @Override // com.datadog.trace.core.propagation.ptags.PTagsCodec
    protected int appendSuffix(StringBuilder sb, PTagsFactory.PTags pTags, int i) {
        return i;
    }

    DatadogPTagsCodec(int i) {
        this.xDatadogTagsLimit = i;
    }

    @Override // com.datadog.trace.core.propagation.ptags.PTagsCodec
    PropagationTags fromHeaderValue(PTagsFactory pTagsFactory, String str) {
        if (str == null) {
            return pTagsFactory.empty();
        }
        if (str.length() > this.xDatadogTagsLimit) {
            return pTagsFactory.createInvalid(PROPAGATION_ERROR_EXTRACT_MAX_SIZE);
        }
        int length = str.length();
        List<TagElement> arrayList = null;
        TagValue tagValue = null;
        int i = 0;
        TagValue tagValue2 = null;
        while (i < length) {
            int iValidateCharsUntilSeparatorOrEnd = validateCharsUntilSeparatorOrEnd(str, i, TAG_KEY_SEPARATOR, new IntPredicate() { // from class: com.datadog.trace.core.propagation.ptags.DatadogPTagsCodec$$ExternalSyntheticLambda0
                @Override // com.datadog.android.trace.internal.compat.function.IntPredicate
                public final boolean check(int i2) {
                    return DatadogPTagsCodec.isAllowedKeyChar(i2);
                }
            });
            if (iValidateCharsUntilSeparatorOrEnd < 0 || iValidateCharsUntilSeparatorOrEnd == length) {
                log.warn("Invalid datadog tags header value: '{}' at {}", str, Integer.valueOf(i));
                return pTagsFactory.createInvalid(PROPAGATION_ERROR_DECODING_ERROR);
            }
            int i2 = iValidateCharsUntilSeparatorOrEnd + 1;
            int iValidateCharsUntilSeparatorOrEnd2 = validateCharsUntilSeparatorOrEnd(str, i2, ',', new IntPredicate() { // from class: com.datadog.trace.core.propagation.ptags.DatadogPTagsCodec$$ExternalSyntheticLambda1
                @Override // com.datadog.android.trace.internal.compat.function.IntPredicate
                public final boolean check(int i3) {
                    return DatadogPTagsCodec.isAllowedValueChar(i3);
                }
            });
            if (iValidateCharsUntilSeparatorOrEnd2 < 0) {
                log.warn("Invalid datadog tags header value: '{}' at {}", str, Integer.valueOf(iValidateCharsUntilSeparatorOrEnd));
                return pTagsFactory.createInvalid(PROPAGATION_ERROR_DECODING_ERROR);
            }
            TagKey tagKeyFrom = TagKey.from(TagElement.Encoding.DATADOG, str, i, iValidateCharsUntilSeparatorOrEnd);
            TagValue tagValueFrom = TagValue.from(TagElement.Encoding.DATADOG, str, i2, iValidateCharsUntilSeparatorOrEnd2);
            if (tagKeyFrom != null && !tagKeyFrom.equals(UPSTREAM_SERVICES_DEPRECATED_TAG)) {
                if (!validateTagValue(tagKeyFrom, tagValueFrom)) {
                    log.warn("Invalid datadog tags header value: '{}' invalid tag value at {}", str, Integer.valueOf(i2));
                    if (tagKeyFrom.equals(TRACE_ID_TAG)) {
                        return pTagsFactory.createInvalid("malformed_tid " + ((Object) tagValueFrom));
                    }
                    return pTagsFactory.createInvalid(PROPAGATION_ERROR_DECODING_ERROR);
                }
                if (tagKeyFrom.equals(DECISION_MAKER_TAG)) {
                    tagValue2 = tagValueFrom;
                } else if (tagKeyFrom.equals(TRACE_ID_TAG)) {
                    tagValue = tagValueFrom;
                } else {
                    if (arrayList == null) {
                        arrayList = new ArrayList<>(6);
                    }
                    arrayList.add(tagKeyFrom);
                    arrayList.add(tagValueFrom);
                }
            }
            i = iValidateCharsUntilSeparatorOrEnd2 + 1;
        }
        return pTagsFactory.createValid(arrayList, tagValue2, tagValue);
    }

    @Override // com.datadog.trace.core.propagation.ptags.PTagsCodec
    protected int estimateHeaderSize(PTagsFactory.PTags pTags) {
        return pTags.getXDatadogTagsSize();
    }

    @Override // com.datadog.trace.core.propagation.ptags.PTagsCodec
    protected int appendPrefix(StringBuilder sb, PTagsFactory.PTags pTags) {
        return pTags.getXDatadogTagsSize();
    }

    @Override // com.datadog.trace.core.propagation.ptags.PTagsCodec
    protected int appendTag(StringBuilder sb, TagElement tagElement, TagElement tagElement2, int i) {
        if (i <= this.xDatadogTagsLimit) {
            if (sb.length() > 0) {
                sb.append(',');
            }
            sb.append(tagElement.forType(TagElement.Encoding.DATADOG));
            sb.append(TAG_KEY_SEPARATOR);
            sb.append(tagElement2.forType(TagElement.Encoding.DATADOG));
        }
        return i;
    }

    @Override // com.datadog.trace.core.propagation.ptags.PTagsCodec
    protected boolean isTooLarge(StringBuilder sb, int i) {
        return i > this.xDatadogTagsLimit;
    }

    @Override // com.datadog.trace.core.propagation.ptags.PTagsCodec
    protected boolean isEmpty(StringBuilder sb, int i) {
        return sb.length() == 0;
    }

    private static int validateCharsUntilSeparatorOrEnd(String str, int i, char c, IntPredicate intPredicate) {
        int length = str.length();
        if (i >= length) {
            return -1;
        }
        char cCharAt = str.charAt(i);
        while (intPredicate.check(cCharAt) && cCharAt != c) {
            i++;
            if (i < length) {
                cCharAt = str.charAt(i);
                if (i >= length - 1 || cCharAt != c) {
                }
                return i;
            }
            if (i >= length) {
                return i;
            }
        }
        return -1;
    }
}
