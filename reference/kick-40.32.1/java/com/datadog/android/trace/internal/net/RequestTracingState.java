package com.datadog.android.trace.internal.net;

import com.datadog.android.api.instrumentation.network.HttpRequestInfo;
import com.datadog.android.api.instrumentation.network.HttpRequestInfoBuilder;
import com.datadog.android.trace.api.span.DatadogSpan;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RequestTracingState.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u000fJ:\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u0018J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0013\u0010\u001b\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006!"}, d2 = {"Lcom/datadog/android/trace/internal/net/RequestTracingState;", "", "requestInfoBuilder", "Lcom/datadog/android/api/instrumentation/network/HttpRequestInfoBuilder;", "isSampled", "", "span", "Lcom/datadog/android/trace/api/span/DatadogSpan;", "sampleRate", "", "(Lcom/datadog/android/api/instrumentation/network/HttpRequestInfoBuilder;ZLcom/datadog/android/trace/api/span/DatadogSpan;Ljava/lang/Float;)V", "()Z", "getRequestInfoBuilder", "()Lcom/datadog/android/api/instrumentation/network/HttpRequestInfoBuilder;", "getSampleRate", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getSpan", "()Lcom/datadog/android/trace/api/span/DatadogSpan;", "component1", "component2", "component3", "component4", "copy", "(Lcom/datadog/android/api/instrumentation/network/HttpRequestInfoBuilder;ZLcom/datadog/android/trace/api/span/DatadogSpan;Ljava/lang/Float;)Lcom/datadog/android/trace/internal/net/RequestTracingState;", "createRequestInfo", "Lcom/datadog/android/api/instrumentation/network/HttpRequestInfo;", "equals", "other", "hashCode", "", "toString", "", "dd-sdk-android-trace_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class RequestTracingState {
    private final boolean isSampled;
    private final HttpRequestInfoBuilder requestInfoBuilder;
    private final Float sampleRate;
    private final DatadogSpan span;

    public static /* synthetic */ RequestTracingState copy$default(RequestTracingState requestTracingState, HttpRequestInfoBuilder httpRequestInfoBuilder, boolean z, DatadogSpan datadogSpan, Float f, int i, Object obj) {
        if ((i & 1) != 0) {
            httpRequestInfoBuilder = requestTracingState.requestInfoBuilder;
        }
        if ((i & 2) != 0) {
            z = requestTracingState.isSampled;
        }
        if ((i & 4) != 0) {
            datadogSpan = requestTracingState.span;
        }
        if ((i & 8) != 0) {
            f = requestTracingState.sampleRate;
        }
        return requestTracingState.copy(httpRequestInfoBuilder, z, datadogSpan, f);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final HttpRequestInfoBuilder getRequestInfoBuilder() {
        return this.requestInfoBuilder;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsSampled() {
        return this.isSampled;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final DatadogSpan getSpan() {
        return this.span;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Float getSampleRate() {
        return this.sampleRate;
    }

    public final RequestTracingState copy(HttpRequestInfoBuilder requestInfoBuilder, boolean isSampled, DatadogSpan span, Float sampleRate) {
        Intrinsics.checkNotNullParameter(requestInfoBuilder, "requestInfoBuilder");
        return new RequestTracingState(requestInfoBuilder, isSampled, span, sampleRate);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RequestTracingState)) {
            return false;
        }
        RequestTracingState requestTracingState = (RequestTracingState) other;
        return Intrinsics.areEqual(this.requestInfoBuilder, requestTracingState.requestInfoBuilder) && this.isSampled == requestTracingState.isSampled && Intrinsics.areEqual(this.span, requestTracingState.span) && Intrinsics.areEqual((Object) this.sampleRate, (Object) requestTracingState.sampleRate);
    }

    public int hashCode() {
        int iHashCode = ((this.requestInfoBuilder.hashCode() * 31) + Boolean.hashCode(this.isSampled)) * 31;
        DatadogSpan datadogSpan = this.span;
        int iHashCode2 = (iHashCode + (datadogSpan == null ? 0 : datadogSpan.hashCode())) * 31;
        Float f = this.sampleRate;
        return iHashCode2 + (f != null ? f.hashCode() : 0);
    }

    public String toString() {
        return "RequestTracingState(requestInfoBuilder=" + this.requestInfoBuilder + ", isSampled=" + this.isSampled + ", span=" + this.span + ", sampleRate=" + this.sampleRate + ")";
    }

    public RequestTracingState(HttpRequestInfoBuilder requestInfoBuilder, boolean z, DatadogSpan datadogSpan, Float f) {
        Intrinsics.checkNotNullParameter(requestInfoBuilder, "requestInfoBuilder");
        this.requestInfoBuilder = requestInfoBuilder;
        this.isSampled = z;
        this.span = datadogSpan;
        this.sampleRate = f;
    }

    public /* synthetic */ RequestTracingState(HttpRequestInfoBuilder httpRequestInfoBuilder, boolean z, DatadogSpan datadogSpan, Float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(httpRequestInfoBuilder, (i & 2) != 0 ? false : z, (i & 4) != 0 ? null : datadogSpan, (i & 8) != 0 ? null : f);
    }

    public final HttpRequestInfoBuilder getRequestInfoBuilder() {
        return this.requestInfoBuilder;
    }

    public final boolean isSampled() {
        return this.isSampled;
    }

    public final DatadogSpan getSpan() {
        return this.span;
    }

    public final Float getSampleRate() {
        return this.sampleRate;
    }

    public final HttpRequestInfo createRequestInfo() {
        return this.requestInfoBuilder.build();
    }
}
