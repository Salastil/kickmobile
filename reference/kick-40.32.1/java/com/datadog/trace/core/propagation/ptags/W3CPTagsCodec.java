package com.datadog.trace.core.propagation.ptags;

import androidx.media3.common.C;
import androidx.work.WorkInfo;
import com.datadog.android.trace.internal.compat.function.IntPredicate;
import com.datadog.trace.api.internal.util.LongStringUtils;
import com.datadog.trace.core.propagation.PropagationTags;
import com.datadog.trace.logger.LoggerFactory;
import com.datadog.trace.relocate.api.RatelimitedLogger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes6.dex */
public class W3CPTagsCodec extends PTagsCodec {
    private static final String DATADOG_MEMBER_KEY = "dd=";
    private static final char ELEMENT_SEPARATOR = ';';
    private static final char KEY_VALUE_SEPARATOR = ':';
    private static final int MAX_ALLOWED_CHAR = 126;
    private static final int MAX_HEADER_SIZE = 256;
    private static final int MAX_MEMBER_COUNT = 32;
    private static final char MEMBER_SEPARATOR = ',';
    private static final int MIN_ALLOWED_CHAR = 32;
    private static final RatelimitedLogger log = new RatelimitedLogger(LoggerFactory.getLogger((Class<?>) W3CPTagsCodec.class), 5, TimeUnit.MINUTES);
    private static final int EMPTY_SIZE = 3;

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isAllowedKeyChar(int i) {
        return i > 32 && i <= 126 && i != 58;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isAllowedValueChar(int i) {
        return i >= 32 && i <= 126;
    }

    private static boolean isLcAlpha(char c) {
        return c >= 'a' && c <= 'z';
    }

    private static boolean isOWC(char c) {
        return c == ' ' || c == '\t';
    }

    private static boolean isValidExtra(char c) {
        return c == '_' || c == '-' || c == '*' || c == '/';
    }

    private static boolean isValidMemberValueChar(char c) {
        return c >= ' ' && c <= '~' && c != ',' && c != '=';
    }

    @Override // com.datadog.trace.core.propagation.ptags.PTagsCodec
    protected boolean isTooLarge(StringBuilder sb, int i) {
        return i > 256;
    }

    /* JADX WARN: Code duplicated, block: B:91:0x0161  */
    @Override // com.datadog.trace.core.propagation.ptags.PTagsCodec
    PropagationTags fromHeaderValue(PTagsFactory pTagsFactory, String str) {
        String str2 = str;
        if (str2 == null || str2.isEmpty()) {
            return pTagsFactory.empty();
        }
        int length = str2.length();
        int iFindNextMember = findNextMember(str2, 0);
        if (iFindNextMember == length) {
            return pTagsFactory.empty();
        }
        int i = 0;
        int i2 = -1;
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        int iFindNextMember2 = iFindNextMember;
        while (iFindNextMember2 < length) {
            if (i == 32) {
                return pTagsFactory.empty();
            }
            if (i2 == -1 && str2.startsWith(DATADOG_MEMBER_KEY, iFindNextMember2)) {
                i5 = iFindNextMember2;
                i2 = i;
            }
            int iValidateMemberKey = validateMemberKey(str2, iFindNextMember2);
            if (iValidateMemberKey < 0) {
                return pTagsFactory.empty();
            }
            if (i3 == -1 && i2 != -1) {
                i3 = iValidateMemberKey;
            }
            int iValidateMemberValue = validateMemberValue(str2, iValidateMemberKey);
            if (iValidateMemberValue < 0) {
                return pTagsFactory.empty();
            }
            if (i4 == -1 && i2 != -1) {
                i4 = iValidateMemberValue;
            }
            iFindNextMember2 = findNextMember(str2, iValidateMemberValue);
            if (iFindNextMember2 < 0) {
                return pTagsFactory.empty();
            }
            i++;
        }
        if (i2 == -1) {
            return empty(pTagsFactory, str);
        }
        ArrayList arrayList = null;
        TagValue tagValue = null;
        TagValue tagValueFrom = null;
        int i6 = 0;
        int iValidateSamplingPriority = -128;
        int i7 = i3;
        TagValue tagValue2 = null;
        while (i7 < i4) {
            int i8 = i4;
            int iValidateCharsUntilSeparatorOrEnd = validateCharsUntilSeparatorOrEnd(str2, i7, i8, ':', false, new IntPredicate() { // from class: com.datadog.trace.core.propagation.ptags.W3CPTagsCodec$$ExternalSyntheticLambda0
                @Override // com.datadog.android.trace.internal.compat.function.IntPredicate
                public final boolean check(int i9) {
                    return W3CPTagsCodec.isAllowedKeyChar(i9);
                }
            });
            if (iValidateCharsUntilSeparatorOrEnd < 0 || iValidateCharsUntilSeparatorOrEnd == i8) {
                log.warn("Invalid datadog tags header value: '{}' at {}", str, Integer.valueOf(i7));
                return empty(pTagsFactory, str, iFindNextMember, i5, i8);
            }
            int i9 = i7;
            int i10 = iValidateCharsUntilSeparatorOrEnd + 1;
            ArrayList arrayList2 = arrayList;
            TagValue tagValue3 = tagValue2;
            str2 = str;
            int iValidateCharsUntilSeparatorOrEnd2 = validateCharsUntilSeparatorOrEnd(str2, i10, i8, ELEMENT_SEPARATOR, true, new IntPredicate() { // from class: com.datadog.trace.core.propagation.ptags.W3CPTagsCodec$$ExternalSyntheticLambda1
                @Override // com.datadog.android.trace.internal.compat.function.IntPredicate
                public final boolean check(int i11) {
                    return W3CPTagsCodec.isAllowedValueChar(i11);
                }
            });
            if (iValidateCharsUntilSeparatorOrEnd2 < 0) {
                log.warn("Invalid datadog tags header value: '{}' at {}", str2, Integer.valueOf(iValidateCharsUntilSeparatorOrEnd));
                return empty(pTagsFactory, str2, iFindNextMember, i5, i8);
            }
            int i11 = iValidateCharsUntilSeparatorOrEnd2 + 1;
            if (iValidateCharsUntilSeparatorOrEnd2 == i8) {
                iValidateCharsUntilSeparatorOrEnd2 = stripTrailingOWC(str2, i10, iValidateCharsUntilSeparatorOrEnd2);
            }
            TagKey tagKeyFrom = TagKey.from(TagElement.Encoding.W3C, str2, i9, iValidateCharsUntilSeparatorOrEnd);
            if (tagKeyFrom != null) {
                TagValue tagValueFrom2 = TagValue.from(TagElement.Encoding.W3C, str2, i10, iValidateCharsUntilSeparatorOrEnd2);
                if (tagKeyFrom.equals(UPSTREAM_SERVICES_DEPRECATED_TAG)) {
                    arrayList = arrayList2;
                } else {
                    if (!validateTagValue(tagKeyFrom, tagValueFrom2)) {
                        log.warn("Invalid datadog tags header value: '{}' invalid tag value at {}", str2, Integer.valueOf(i10));
                        if (tagKeyFrom.equals(TRACE_ID_TAG)) {
                            return pTagsFactory.createInvalid("malformed_tid " + ((Object) tagValueFrom2));
                        }
                        return empty(pTagsFactory, str2, iFindNextMember, i5, i8);
                    }
                    if (tagKeyFrom.equals(DECISION_MAKER_TAG)) {
                        tagValue2 = tagValueFrom2;
                    } else if (tagKeyFrom.equals(TRACE_ID_TAG)) {
                        tagValue = tagValueFrom2;
                        tagValue2 = tagValue3;
                    } else {
                        ArrayList arrayList3 = arrayList2 == null ? new ArrayList(6) : arrayList2;
                        arrayList3.add(tagKeyFrom);
                        arrayList3.add(tagValueFrom2);
                        arrayList = arrayList3;
                    }
                    arrayList = arrayList2;
                }
                tagValue2 = tagValue3;
            } else {
                int i12 = iValidateCharsUntilSeparatorOrEnd - i9;
                char cCharAt = str2.charAt(i9);
                int i13 = 1;
                if (i12 != 1) {
                    if (i12 == i13 || cCharAt != 'o') {
                        if (i6 != 0) {
                            i6++;
                        }
                        i6 += iValidateCharsUntilSeparatorOrEnd2 - i9;
                        arrayList = arrayList2;
                        tagValue2 = tagValue3;
                    } else {
                        tagValueFrom = TagValue.from(TagElement.Encoding.W3C, str2, i10, iValidateCharsUntilSeparatorOrEnd2);
                    }
                } else if (cCharAt == 's') {
                    iValidateSamplingPriority = validateSamplingPriority(str2, i10, iValidateCharsUntilSeparatorOrEnd2);
                } else {
                    i13 = 1;
                    if (i12 == i13) {
                    }
                    if (i6 != 0) {
                        i6++;
                    }
                    i6 += iValidateCharsUntilSeparatorOrEnd2 - i9;
                    arrayList = arrayList2;
                    tagValue2 = tagValue3;
                }
                tagValue2 = tagValue3;
                arrayList = arrayList2;
            }
            i4 = i8;
            i7 = i11;
        }
        return new W3CPTags(pTagsFactory, arrayList, tagValue2, tagValue, iValidateSamplingPriority, tagValueFrom, str2, iFindNextMember, i5, i4, i6);
    }

    @Override // com.datadog.trace.core.propagation.ptags.PTagsCodec
    protected int estimateHeaderSize(PTagsFactory.PTags pTags) {
        int xDatadogTagsSize = EMPTY_SIZE + 1 + pTags.getXDatadogTagsSize();
        if (pTags.getOrigin() != null) {
            xDatadogTagsSize += pTags.getOrigin().length() + 3;
        }
        if (pTags.getSamplingPriority() != -128) {
            xDatadogTagsSize += 5;
        }
        if (!(pTags instanceof W3CPTags)) {
            return pTags.tracestate != null ? xDatadogTagsSize + pTags.tracestate.length() : xDatadogTagsSize;
        }
        W3CPTags w3CPTags = (W3CPTags) pTags;
        int i = xDatadogTagsSize + w3CPTags.maxUnknownSize;
        return w3CPTags.ddMemberStart != -1 ? i + (w3CPTags.tracestate.length() - (w3CPTags.ddMemberValueEnd - w3CPTags.ddMemberStart)) : i;
    }

    @Override // com.datadog.trace.core.propagation.ptags.PTagsCodec
    protected int appendPrefix(StringBuilder sb, PTagsFactory.PTags pTags) {
        sb.append(DATADOG_MEMBER_KEY);
        if (pTags.getSamplingPriority() != -128) {
            sb.append("s:");
            sb.append(pTags.getSamplingPriority());
        }
        CharSequence origin = pTags.getOrigin();
        if (origin != null) {
            if (sb.length() > EMPTY_SIZE) {
                sb.append(ELEMENT_SEPARATOR);
            }
            sb.append("o:");
            if (origin instanceof TagValue) {
                sb.append(((TagValue) origin).forType(TagElement.Encoding.W3C));
            } else {
                sb.append(origin);
            }
        }
        return sb.length();
    }

    @Override // com.datadog.trace.core.propagation.ptags.PTagsCodec
    protected int appendTag(StringBuilder sb, TagElement tagElement, TagElement tagElement2, int i) {
        return appendTag(sb, tagElement, tagElement2, TagElement.Encoding.W3C, i);
    }

    @Override // com.datadog.trace.core.propagation.ptags.PTagsCodec
    protected int appendSuffix(StringBuilder sb, PTagsFactory.PTags pTags, int i) {
        if (i < 256 && (pTags instanceof W3CPTags)) {
            i = cleanUpAndAppendUnknown(sb, (W3CPTags) pTags, i);
        }
        int i2 = EMPTY_SIZE;
        if (i == i2) {
            i = 0;
            sb.setLength(0);
        }
        return cleanUpAndAppendSuffix(sb, pTags, i) != i ? Math.max(i, i2 + 1) : i;
    }

    @Override // com.datadog.trace.core.propagation.ptags.PTagsCodec
    protected boolean isEmpty(StringBuilder sb, int i) {
        return i <= EMPTY_SIZE;
    }

    private int appendTag(StringBuilder sb, TagElement tagElement, TagElement tagElement2, TagElement.Encoding encoding, int i) {
        int i2;
        if (i >= 256) {
            return i;
        }
        if (i > EMPTY_SIZE) {
            sb.append(ELEMENT_SEPARATOR);
            i2 = i + 1;
        } else {
            i2 = i;
        }
        CharSequence charSequenceForType = tagElement.forType(encoding);
        sb.append(charSequenceForType);
        int length = i2 + charSequenceForType.length();
        sb.append(':');
        CharSequence charSequenceForType2 = tagElement2.forType(encoding);
        sb.append(charSequenceForType2);
        int length2 = length + 1 + charSequenceForType2.length();
        if (length2 <= 256) {
            return length2;
        }
        sb.setLength(i);
        return i;
    }

    private static int validateCharsUntilSeparatorOrEnd(String str, int i, int i2, char c, boolean z, IntPredicate intPredicate) {
        if (i >= i2) {
            return -1;
        }
        char cCharAt = str.charAt(i);
        boolean z2 = false;
        do {
            if (z && isOWC(cCharAt)) {
                if (cCharAt == '\t') {
                    z2 = true;
                }
            } else if (z2 || !intPredicate.check(cCharAt) || cCharAt == c) {
                return -1;
            }
            i++;
            if (i < i2) {
                cCharAt = str.charAt(i);
                if (i < i2 - 1 && cCharAt == c) {
                    break;
                }
            }
        } while (i < i2);
        return i;
    }

    private static int validateSamplingPriority(String str, int i, int i2) {
        try {
            return parseIntDecimal(str, i, i2);
        } catch (Exception unused) {
            return WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT;
        }
    }

    private static int parseIntDecimal(String str, int i, int i2) throws NumberFormatException {
        boolean z;
        if (i < 0 || i > i2 || i2 > str.length()) {
            throw new IndexOutOfBoundsException();
        }
        if (i < i2) {
            char cCharAt = str.charAt(i);
            int i3 = 0;
            int i4 = C.RATE_UNSET_INT;
            if (cCharAt < '0') {
                if (cCharAt == '-') {
                    z = true;
                    i4 = Integer.MIN_VALUE;
                } else {
                    if (cCharAt != '+') {
                        throw new NumberFormatException(str);
                    }
                    z = false;
                }
                i++;
                if (i == i2) {
                    throw new NumberFormatException(str);
                }
            } else {
                z = false;
            }
            int i5 = i4 / 10;
            while (i < i2) {
                int iCharAt = str.charAt(i) - '0';
                if (iCharAt < 0 || iCharAt > 9 || i3 < i5) {
                    throw new NumberFormatException(str);
                }
                int i6 = i3 * 10;
                if (i6 < i4 + iCharAt) {
                    throw new NumberFormatException(str);
                }
                i++;
                i3 = i6 - iCharAt;
            }
            return z ? i3 : -i3;
        }
        throw new NumberFormatException("");
    }

    private static int validateMemberKey(String str, int i) {
        int length = str.length();
        if (i < 0 || i >= length) {
            return -1;
        }
        boolean z = false;
        int i2 = 1;
        while (i < length) {
            if (i2 > 242 && (z || i2 > 257)) {
                return -1;
            }
            char cCharAt = str.charAt(i);
            if (!isLcAlpha(cCharAt)) {
                if (!isDigit(cCharAt)) {
                    if (i2 != 1) {
                        if (!isValidExtra(cCharAt)) {
                            if (cCharAt != '=') {
                                if (cCharAt == '@' && i2 <= 242) {
                                    i++;
                                    z = true;
                                    break;
                                }
                                return -1;
                            }
                            if (!z) {
                                i++;
                                break;
                            }
                            return -1;
                        }
                    } else {
                        return -1;
                    }
                } else if (i2 == 1) {
                    z = true;
                }
            }
            i++;
            i2++;
        }
        if (z) {
            int i3 = 1;
            while (i < length) {
                if (i3 > 15) {
                    return -1;
                }
                char cCharAt2 = str.charAt(i);
                if (!isLcAlpha(cCharAt2)) {
                    if (i3 != 1) {
                        if (!isDigit(cCharAt2) && !isValidExtra(cCharAt2) && cCharAt2 == '=') {
                            i++;
                            break;
                        }
                    } else {
                        return -1;
                    }
                }
                i++;
                i3++;
            }
        }
        if (i >= length) {
            return -1;
        }
        return i;
    }

    private static int validateMemberValue(String str, int i) {
        int length = str.length();
        if (i < 0 || i >= length) {
            return -1;
        }
        boolean z = false;
        int i2 = 0;
        int i3 = 1;
        boolean z2 = true;
        boolean z3 = true;
        while (i < length) {
            if (!z) {
                i2 = i3 - 1;
            }
            if (i2 > 256) {
                return -1;
            }
            char cCharAt = str.charAt(i);
            if (cCharAt == ' ') {
                z = true;
            } else if (cCharAt == '\t') {
                z2 = false;
                z = true;
            } else {
                if (cCharAt == ',') {
                    break;
                }
                if (!z2 || !isValidMemberValueChar(cCharAt)) {
                    return -1;
                }
                z = false;
                z3 = false;
            }
            i++;
            i3++;
        }
        if (z3) {
            return -1;
        }
        if (z || i3 <= 257) {
            return i;
        }
        return -1;
    }

    private static int findNextMember(String str, int i) {
        int length = str.length();
        if (i < 0) {
            return -1;
        }
        if (i >= length) {
            return length;
        }
        while (i < length) {
            char cCharAt = str.charAt(i);
            if (!isOWC(cCharAt) && cCharAt != ',') {
                break;
            }
            i++;
        }
        return i;
    }

    private static int stripTrailingOWC(String str, int i, int i2) {
        int i3 = i2 - 1;
        char cCharAt = str.charAt(i3);
        while (isOWC(cCharAt) && i3 > i) {
            i3--;
            cCharAt = str.charAt(i3);
        }
        return i3 + 1;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x007d  */
    private static int cleanUpAndAppendUnknown(StringBuilder sb, W3CPTags w3CPTags, int i) {
        int i2;
        int i3;
        if (w3CPTags.maxUnknownSize != 0 && w3CPTags.ddMemberStart != -1 && w3CPTags.ddMemberStart < w3CPTags.ddMemberValueEnd) {
            String str = w3CPTags.tracestate;
            int i4 = w3CPTags.ddMemberStart + EMPTY_SIZE;
            int i5 = i;
            while (i4 < w3CPTags.ddMemberValueEnd && i < 256) {
                int iIndexOf = str.indexOf(59, i4);
                if (iIndexOf < 0) {
                    iIndexOf = w3CPTags.ddMemberValueEnd;
                }
                if (str.startsWith(TagElement.Encoding.W3C.getPrefix(), i4)) {
                    i2 = i;
                } else {
                    char cCharAt = str.charAt(i4);
                    if (str.charAt(i4 + 1) == ':' && (cCharAt == 'o' || cCharAt == 's')) {
                        i2 = i;
                    } else {
                        if (sb.length() > EMPTY_SIZE) {
                            sb.append(ELEMENT_SEPARATOR);
                            i3 = i + 1;
                        } else {
                            i3 = i;
                        }
                        int iStripTrailingOWC = iIndexOf == w3CPTags.ddMemberValueEnd ? stripTrailingOWC(str, i4, iIndexOf) : iIndexOf;
                        sb.append((CharSequence) str, i4, iStripTrailingOWC);
                        i2 = i3 + (iStripTrailingOWC - i4);
                    }
                }
                i4 = iIndexOf + 1;
                int i6 = i2;
                i5 = i;
                i = i6;
            }
            if (i > 256) {
                sb.setLength(i5);
                return i5;
            }
        }
        return i;
    }

    private static int cleanUpAndAppendSuffix(StringBuilder sb, PTagsFactory.PTags pTags, int i) {
        String str = pTags.tracestate;
        if (str == null) {
            return i;
        }
        int i2 = pTags instanceof W3CPTags ? ((W3CPTags) pTags).ddMemberStart : -1;
        int i3 = i == 0 ? 32 : 31;
        int length = str.length();
        int iFindNextMember = findNextMember(str, 0);
        while (iFindNextMember < length) {
            int iIndexOf = str.indexOf(44, iFindNextMember);
            if (iIndexOf < 0) {
                iIndexOf = length;
            }
            if (i2 == -1 && str.startsWith(DATADOG_MEMBER_KEY, iFindNextMember)) {
                i2 = iFindNextMember;
            }
            if (iFindNextMember != i2) {
                if (sb.length() > 0) {
                    sb.append(',');
                    i++;
                }
                int iStripTrailingOWC = stripTrailingOWC(str, iFindNextMember, iIndexOf);
                sb.append((CharSequence) str, iFindNextMember, iStripTrailingOWC);
                i += iStripTrailingOWC - iFindNextMember;
                i3--;
            }
            iFindNextMember = i3 == 0 ? length : findNextMember(str, iIndexOf + 1);
        }
        return i;
    }

    private static W3CPTags empty(PTagsFactory pTagsFactory, String str) {
        return empty(pTagsFactory, str, 0, -1, -1);
    }

    private static W3CPTags empty(PTagsFactory pTagsFactory, String str, int i, int i2, int i3) {
        return new W3CPTags(pTagsFactory, null, null, null, WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT, null, str, i, i2, i3, 0);
    }

    private static class W3CPTags extends PTagsFactory.PTags {
        private final int ddMemberStart;
        private final int ddMemberValueEnd;
        private final int firstMemberStart;
        private final int maxUnknownSize;

        public W3CPTags(PTagsFactory pTagsFactory, List<TagElement> list, TagValue tagValue, TagValue tagValue2, int i, CharSequence charSequence, String str, int i2, int i3, int i4, int i5) {
            super(pTagsFactory, list, tagValue, tagValue2, i, charSequence);
            this.tracestate = str;
            this.firstMemberStart = i2;
            this.ddMemberStart = i3;
            this.ddMemberValueEnd = i4;
            this.maxUnknownSize = i5;
        }

        @Override // com.datadog.trace.core.propagation.ptags.PTagsFactory.PTags, com.datadog.trace.core.propagation.PropagationTags
        public void updateTraceIdHighOrderBits(long j) {
            long traceIdHighOrderBits = getTraceIdHighOrderBits();
            if (traceIdHighOrderBits != 0 && traceIdHighOrderBits != j) {
                this.error = "inconsistent_tid " + LongStringUtils.toHexStringPadded(traceIdHighOrderBits, 16);
            }
            super.updateTraceIdHighOrderBits(j);
        }
    }
}
