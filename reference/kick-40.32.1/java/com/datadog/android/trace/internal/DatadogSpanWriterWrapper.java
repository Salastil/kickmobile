package com.datadog.android.trace.internal;

import com.datadog.android.trace.api.span.DatadogSpanWriter;
import com.datadog.trace.common.writer.Writer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DatadogSpanWriterWrapper.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/trace/internal/DatadogSpanWriterWrapper;", "Lcom/datadog/android/trace/api/span/DatadogSpanWriter;", "delegate", "Lcom/datadog/trace/common/writer/Writer;", "(Lcom/datadog/trace/common/writer/Writer;)V", "getDelegate$dd_sdk_android_trace_release", "()Lcom/datadog/trace/common/writer/Writer;", "dd-sdk-android-trace_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DatadogSpanWriterWrapper implements DatadogSpanWriter {
    private final Writer delegate;

    public DatadogSpanWriterWrapper(Writer delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
    }

    /* JADX INFO: renamed from: getDelegate$dd_sdk_android_trace_release, reason: from getter */
    public final Writer getDelegate() {
        return this.delegate;
    }
}
