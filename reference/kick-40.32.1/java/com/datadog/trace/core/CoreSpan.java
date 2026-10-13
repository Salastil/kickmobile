package com.datadog.trace.core;

import com.datadog.trace.api.DDTraceId;
import com.datadog.trace.core.CoreSpan;

/* JADX INFO: loaded from: classes6.dex */
public interface CoreSpan<T extends CoreSpan<T>> {
    /* JADX INFO: renamed from: addThrowable */
    T mo11180addThrowable(Throwable th);

    long getDurationNano();

    int getError();

    short getHttpStatusCode();

    /* JADX INFO: renamed from: getLocalRootSpan */
    T mo11181getLocalRootSpan();

    CharSequence getOperationName();

    CharSequence getOrigin();

    long getParentId();

    CharSequence getResourceName();

    String getServiceName();

    long getSpanId();

    long getStartTime();

    <U> U getTag(CharSequence charSequence);

    <U> U getTag(CharSequence charSequence, U u);

    DDTraceId getTraceId();

    CharSequence getType();

    boolean hasSamplingPriority();

    boolean isForceKeep();

    boolean isMeasured();

    boolean isTopLevel();

    void processTagsAndBaggage(MetadataConsumer metadataConsumer);

    T removeTag(String str);

    /* JADX INFO: renamed from: setErrorMessage */
    T mo11182setErrorMessage(String str);

    T setFlag(CharSequence charSequence, boolean z);

    /* JADX INFO: renamed from: setMeasured */
    T mo11183setMeasured(boolean z);

    /* JADX INFO: renamed from: setMetric */
    T mo11184setMetric(CharSequence charSequence, double d);

    T setMetric(CharSequence charSequence, float f);

    /* JADX INFO: renamed from: setMetric */
    T mo11185setMetric(CharSequence charSequence, int i);

    /* JADX INFO: renamed from: setMetric */
    T mo11186setMetric(CharSequence charSequence, long j);

    /* JADX INFO: renamed from: setSamplingPriority */
    T mo11187setSamplingPriority(int i, int i2);

    T setSamplingPriority(int i, CharSequence charSequence, double d, int i2);

    T setSpanSamplingPriority(double d, int i);

    /* JADX INFO: renamed from: setTag */
    T mo11188setTag(String str, double d);

    /* JADX INFO: renamed from: setTag */
    T mo11189setTag(String str, int i);

    /* JADX INFO: renamed from: setTag */
    T mo11190setTag(String str, long j);

    /* JADX INFO: renamed from: setTag */
    T mo11191setTag(String str, CharSequence charSequence);

    /* JADX INFO: renamed from: setTag */
    T mo11192setTag(String str, Number number);

    /* JADX INFO: renamed from: setTag */
    T mo11193setTag(String str, Object obj);

    /* JADX INFO: renamed from: setTag */
    T mo11194setTag(String str, String str2);

    /* JADX INFO: renamed from: setTag */
    T mo11195setTag(String str, boolean z);
}
