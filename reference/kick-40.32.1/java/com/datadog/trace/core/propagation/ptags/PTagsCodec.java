package com.datadog.trace.core.propagation.ptags;

import com.datadog.trace.core.propagation.PropagationTags;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
abstract class PTagsCodec {
    private static final String PROPAGATION_ERROR_DISABLED = "disabled";
    protected static final String PROPAGATION_ERROR_INCONSISTENT_TID = "inconsistent_tid ";
    private static final String PROPAGATION_ERROR_INJECT_MAX_SIZE = "inject_max_size";
    protected static final String PROPAGATION_ERROR_MALFORMED_TID = "malformed_tid ";
    protected static final TagKey DECISION_MAKER_TAG = TagKey.from("dm");
    protected static final TagKey TRACE_ID_TAG = TagKey.from("tid");
    protected static final TagKey UPSTREAM_SERVICES_DEPRECATED_TAG = TagKey.from("upstream_services");

    protected static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    protected abstract int appendPrefix(StringBuilder sb, PTagsFactory.PTags pTags);

    protected abstract int appendSuffix(StringBuilder sb, PTagsFactory.PTags pTags, int i);

    protected abstract int appendTag(StringBuilder sb, TagElement tagElement, TagElement tagElement2, int i);

    protected abstract int estimateHeaderSize(PTagsFactory.PTags pTags);

    abstract PropagationTags fromHeaderValue(PTagsFactory pTagsFactory, String str);

    protected abstract boolean isEmpty(StringBuilder sb, int i);

    protected abstract boolean isTooLarge(StringBuilder sb, int i);

    PTagsCodec() {
    }

    static String headerValue(PTagsCodec pTagsCodec, PTagsFactory.PTags pTags) {
        int iEstimateHeaderSize = pTagsCodec.estimateHeaderSize(pTags);
        if (iEstimateHeaderSize == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(iEstimateHeaderSize);
        int iAppendPrefix = pTagsCodec.appendPrefix(sb, pTags);
        if (!pTags.isPropagationTagsDisabled()) {
            if (pTags.getDecisionMakerTagValue() != null) {
                iAppendPrefix = pTagsCodec.appendTag(sb, DECISION_MAKER_TAG, pTags.getDecisionMakerTagValue(), iAppendPrefix);
            }
            if (pTags.getTraceIdHighOrderBitsHexTagValue() != null) {
                iAppendPrefix = pTagsCodec.appendTag(sb, TRACE_ID_TAG, pTags.getTraceIdHighOrderBitsHexTagValue(), iAppendPrefix);
            }
            Iterator<TagElement> it = pTags.getTagPairs().iterator();
            while (it.hasNext() && !pTagsCodec.isTooLarge(sb, iAppendPrefix)) {
                iAppendPrefix = pTagsCodec.appendTag(sb, it.next(), it.next(), iAppendPrefix);
            }
        }
        int iAppendSuffix = pTagsCodec.appendSuffix(sb, pTags, iAppendPrefix);
        if (pTagsCodec.isTooLarge(sb, iAppendSuffix) || pTagsCodec.isEmpty(sb, iAppendSuffix)) {
            return null;
        }
        return sb.toString();
    }

    static void fillTagMap(PTagsFactory.PTags pTags, Map<String, String> map) {
        if (pTags.getXDatadogTagsSize() > pTags.getxDatadogTagsLimit()) {
            if (pTags.isPropagationTagsDisabled()) {
                map.put("_dd.propagation_error", PROPAGATION_ERROR_DISABLED);
                return;
            } else {
                map.put("_dd.propagation_error", PROPAGATION_ERROR_INJECT_MAX_SIZE);
                return;
            }
        }
        Iterator<TagElement> it = pTags.getTagPairs().iterator();
        while (it.hasNext()) {
            map.put(it.next().forType(TagElement.Encoding.DATADOG).toString(), it.next().forType(TagElement.Encoding.DATADOG).toString());
        }
        if (pTags.getDecisionMakerTagValue() != null) {
            map.put(DECISION_MAKER_TAG.forType(TagElement.Encoding.DATADOG).toString(), pTags.getDecisionMakerTagValue().forType(TagElement.Encoding.DATADOG).toString());
        }
        if (pTags.getTraceIdHighOrderBitsHexTagValue() != null) {
            map.put(TRACE_ID_TAG.forType(TagElement.Encoding.DATADOG).toString(), pTags.getTraceIdHighOrderBitsHexTagValue().forType(TagElement.Encoding.DATADOG).toString());
        }
        if (pTags.getError() != null) {
            map.put("_dd.propagation_error", pTags.getError());
        }
    }

    static int calcXDatadogTagsSize(List<TagElement> list) {
        int prefixLength = TagElement.Encoding.DATADOG.getPrefixLength();
        int length = 0;
        boolean z = true;
        for (TagElement tagElement : list) {
            if (z) {
                length += prefixLength;
            }
            z = !z;
            length = length + tagElement.length() + 1;
        }
        if (length == 0) {
            return 0;
        }
        return length - 1;
    }

    static int calcXDatadogTagsSize(int i, TagKey tagKey, TagValue tagValue) {
        if (tagValue == null) {
            return i;
        }
        if (i > 0) {
            i++;
        }
        return i + tagKey.length() + 1 + tagValue.length() + TagElement.Encoding.DATADOG.getPrefixLength();
    }

    protected static boolean validateTagValue(TagKey tagKey, TagValue tagValue) {
        if (!tagKey.equals(DECISION_MAKER_TAG) || validateDecisionMakerTag(tagValue)) {
            return !tagKey.equals(TRACE_ID_TAG) || validateTraceId(tagValue);
        }
        return false;
    }

    private static boolean validateDecisionMakerTag(TagValue tagValue) {
        int i;
        int length;
        int iIndexOf = tagValue.indexOf('-');
        if (iIndexOf < 0) {
            return false;
        }
        if ((iIndexOf != 0 && iIndexOf != 10) || (i = iIndexOf + 1) == (length = tagValue.length())) {
            return false;
        }
        for (int i2 = 0; i2 < iIndexOf; i2++) {
            if (!isHexDigit(tagValue.charAt(i2))) {
                return false;
            }
        }
        for (i = iIndexOf + 1; i < length; i++) {
            if (!isDigit(tagValue.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean validateTraceId(TagValue tagValue) {
        if (tagValue.length() != 16) {
            return false;
        }
        for (int i = 0; i < 16; i++) {
            if (!isHexDigit(tagValue.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    protected static boolean isHexDigit(char c) {
        return (c >= 'a' && c <= 'f') || isDigit(c);
    }
}
