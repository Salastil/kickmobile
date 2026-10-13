package com.datadog.trace.core.propagation.ptags;

import androidx.work.WorkInfo;
import com.datadog.trace.api.internal.util.LongStringUtils;
import com.datadog.trace.core.propagation.PropagationTags;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
public class PTagsFactory implements PropagationTags.Factory {
    static final String PROPAGATION_ERROR_TAG_KEY = "_dd.propagation_error";
    private final EnumMap<PropagationTags.HeaderType, PTagsCodec> DEC_ENC_MAP;
    private final int xDatadogTagsLimit;

    public PTagsFactory(int i) {
        EnumMap<PropagationTags.HeaderType, PTagsCodec> enumMap = new EnumMap<>(PropagationTags.HeaderType.class);
        this.DEC_ENC_MAP = enumMap;
        this.xDatadogTagsLimit = i;
        enumMap.put(PropagationTags.HeaderType.DATADOG, new DatadogPTagsCodec(i));
        enumMap.put(PropagationTags.HeaderType.W3C, new W3CPTagsCodec());
    }

    boolean isPropagationTagsDisabled() {
        return this.xDatadogTagsLimit <= 0;
    }

    int getxDatadogTagsLimit() {
        return this.xDatadogTagsLimit;
    }

    PTagsCodec getDecoderEncoder(PropagationTags.HeaderType headerType) {
        return this.DEC_ENC_MAP.get(headerType);
    }

    @Override // com.datadog.trace.core.propagation.PropagationTags.Factory
    public final PropagationTags empty() {
        return createValid(null, null, null);
    }

    @Override // com.datadog.trace.core.propagation.PropagationTags.Factory
    public final PropagationTags fromHeaderValue(PropagationTags.HeaderType headerType, String str) {
        return this.DEC_ENC_MAP.get(headerType).fromHeaderValue(this, str);
    }

    PropagationTags createValid(List<TagElement> list, TagValue tagValue, TagValue tagValue2) {
        return new PTags(this, list, tagValue, tagValue2);
    }

    PropagationTags createInvalid(String str) {
        return PTags.withError(this, str);
    }

    static class PTags extends PropagationTags {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final String EMPTY = "";
        private final boolean canChangeDecisionMaker;
        private volatile TagValue decisionMakerTagValue;
        protected volatile String error;
        protected final PTagsFactory factory;
        private volatile String[] headerCache;
        private volatile CharSequence origin;
        private volatile String rumSessionId;
        private volatile TagValue rumSessionIdTagValue;
        private volatile int samplingPriority;
        private final List<TagElement> tagPairs;
        private volatile long traceIdHighOrderBits;
        private volatile TagValue traceIdHighOrderBitsHexTagValue;
        protected volatile String tracestate;
        private volatile int xDatadogTagsSize;

        public PTags(PTagsFactory pTagsFactory, List<TagElement> list, TagValue tagValue, TagValue tagValue2) {
            this(pTagsFactory, list, tagValue, tagValue2, WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT, null);
        }

        PTags(PTagsFactory pTagsFactory, List<TagElement> list, TagValue tagValue, TagValue tagValue2, int i, CharSequence charSequence) {
            this.xDatadogTagsSize = -1;
            this.headerCache = null;
            this.factory = pTagsFactory;
            this.tagPairs = list;
            this.canChangeDecisionMaker = tagValue == null;
            this.decisionMakerTagValue = tagValue;
            this.samplingPriority = i;
            this.origin = charSequence;
            if (tagValue2 != null) {
                CharSequence charSequenceForType = tagValue2.forType(TagElement.Encoding.DATADOG);
                this.traceIdHighOrderBits = LongStringUtils.parseUnsignedLongHex(charSequenceForType, 0, charSequenceForType.length(), true);
            }
            this.traceIdHighOrderBitsHexTagValue = tagValue2;
            this.error = null;
        }

        static PTags withError(PTagsFactory pTagsFactory, String str) {
            PTags pTags = new PTags(pTagsFactory, null, null, null, WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT, null);
            pTags.error = str;
            return pTags;
        }

        @Override // com.datadog.trace.core.propagation.PropagationTags
        public void updateTraceSamplingPriority(int i, int i2) {
            if ((i == -128 || !this.canChangeDecisionMaker) && i2 != -128) {
                return;
            }
            if (this.samplingPriority != i) {
                clearCachedHeader(PropagationTags.HeaderType.W3C);
            }
            this.samplingPriority = i;
            if (i <= 0) {
                if (this.decisionMakerTagValue != null) {
                    clearCachedHeader(PropagationTags.HeaderType.DATADOG);
                    clearCachedHeader(PropagationTags.HeaderType.W3C);
                }
                this.decisionMakerTagValue = null;
                return;
            }
            if (i2 == -128) {
                i2 = 0;
            }
            if (i2 >= 0) {
                TagValue tagValueFrom = TagValue.from("-" + i2);
                if (!tagValueFrom.equals(this.decisionMakerTagValue)) {
                    clearCachedHeader(PropagationTags.HeaderType.DATADOG);
                    clearCachedHeader(PropagationTags.HeaderType.W3C);
                }
                this.decisionMakerTagValue = tagValueFrom;
            }
        }

        @Override // com.datadog.trace.core.propagation.PropagationTags
        public int getSamplingPriority() {
            return this.samplingPriority;
        }

        @Override // com.datadog.trace.core.propagation.PropagationTags
        public void updateTraceOrigin(CharSequence charSequence) {
            if (Objects.equals(this.origin, charSequence)) {
                return;
            }
            clearCachedHeader(PropagationTags.HeaderType.W3C);
            this.origin = TagValue.from(charSequence);
        }

        @Override // com.datadog.trace.core.propagation.PropagationTags
        public CharSequence getOrigin() {
            return this.origin;
        }

        @Override // com.datadog.trace.core.propagation.PropagationTags
        public long getTraceIdHighOrderBits() {
            return this.traceIdHighOrderBits;
        }

        @Override // com.datadog.trace.core.propagation.PropagationTags
        public void updateTraceIdHighOrderBits(long j) {
            if (this.traceIdHighOrderBits != j) {
                this.traceIdHighOrderBits = j;
                this.traceIdHighOrderBitsHexTagValue = j == 0 ? null : TagValue.from(LongStringUtils.toHexStringPadded(j, 16));
                clearCachedHeader(PropagationTags.HeaderType.DATADOG);
            }
        }

        @Override // com.datadog.trace.core.propagation.PropagationTags
        public String getRumSessionId() {
            return this.rumSessionId;
        }

        @Override // com.datadog.trace.core.propagation.PropagationTags
        public void updateRumSessionId(String str) {
            if (Objects.equals(this.rumSessionId, str)) {
                return;
            }
            this.rumSessionId = str;
            this.rumSessionIdTagValue = TagValue.from(this.rumSessionId);
            clearCachedHeader(PropagationTags.HeaderType.DATADOG);
            clearCachedHeader(PropagationTags.HeaderType.W3C);
        }

        @Override // com.datadog.trace.core.propagation.PropagationTags
        public String headerValue(PropagationTags.HeaderType headerType) {
            String cachedHeader = getCachedHeader(headerType);
            if (cachedHeader == null) {
                cachedHeader = PTagsCodec.headerValue(this.factory.getDecoderEncoder(headerType), this);
                if (cachedHeader != null) {
                    setCachedHeader(headerType, cachedHeader);
                } else {
                    setCachedHeader(headerType, "");
                }
            }
            if (cachedHeader == "") {
                return null;
            }
            return cachedHeader;
        }

        @Override // com.datadog.trace.core.propagation.PropagationTags
        public void fillTagMap(Map<String, String> map) {
            PTagsCodec.fillTagMap(this, map);
        }

        private String getCachedHeader(PropagationTags.HeaderType headerType) {
            String[] strArr = this.headerCache;
            if (strArr == null) {
                return null;
            }
            return strArr[headerType.ordinal()];
        }

        private void setCachedHeader(PropagationTags.HeaderType headerType, String str) {
            String[] strArr = this.headerCache;
            if (strArr == null) {
                strArr = new String[PropagationTags.HeaderType.getNumValues()];
                this.headerCache = strArr;
            }
            strArr[headerType.ordinal()] = str;
        }

        private void clearCachedHeader(PropagationTags.HeaderType headerType) {
            if (headerType == PropagationTags.HeaderType.DATADOG) {
                invalidateXDatadogTagsSize();
            }
            String[] strArr = this.headerCache;
            if (strArr == null) {
                return;
            }
            strArr[headerType.ordinal()] = null;
        }

        int getxDatadogTagsLimit() {
            return this.factory.getxDatadogTagsLimit();
        }

        boolean isPropagationTagsDisabled() {
            return this.factory.isPropagationTagsDisabled();
        }

        List<TagElement> getTagPairs() {
            List<TagElement> list = this.tagPairs;
            return list == null ? Collections.EMPTY_LIST : list;
        }

        private void invalidateXDatadogTagsSize() {
            this.xDatadogTagsSize = -1;
        }

        int getXDatadogTagsSize() {
            int i = this.xDatadogTagsSize;
            if (i != -1) {
                return i;
            }
            int iCalcXDatadogTagsSize = PTagsCodec.calcXDatadogTagsSize(PTagsCodec.calcXDatadogTagsSize(PTagsCodec.calcXDatadogTagsSize(getTagPairs()), PTagsCodec.DECISION_MAKER_TAG, this.decisionMakerTagValue), PTagsCodec.TRACE_ID_TAG, this.traceIdHighOrderBitsHexTagValue);
            this.xDatadogTagsSize = iCalcXDatadogTagsSize;
            return iCalcXDatadogTagsSize;
        }

        TagValue getTraceIdHighOrderBitsHexTagValue() {
            return this.traceIdHighOrderBitsHexTagValue;
        }

        TagValue getRumSessionIdTagValue() {
            return this.rumSessionIdTagValue;
        }

        TagValue getDecisionMakerTagValue() {
            return this.decisionMakerTagValue;
        }

        @Override // com.datadog.trace.core.propagation.PropagationTags
        public String getW3CTracestate() {
            return this.tracestate;
        }

        @Override // com.datadog.trace.core.propagation.PropagationTags
        public void updateW3CTracestate(String str) {
            this.tracestate = str;
        }

        String getError() {
            return this.error;
        }
    }
}
