package com.datadog.android.trace.internal;

import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.datadog.android.trace.api.span.DatadogSpanContext;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DatadogPropagationHelper.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0007\bB\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0002\t\n¨\u0006\u000b"}, d2 = {"Lcom/datadog/android/trace/internal/ParentContextSource;", "", "()V", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lcom/datadog/android/trace/api/span/DatadogSpanContext;", "getContext", "()Lcom/datadog/android/trace/api/span/DatadogSpanContext;", "FromHeaders", "FromTag", "Lcom/datadog/android/trace/internal/ParentContextSource$FromHeaders;", "Lcom/datadog/android/trace/internal/ParentContextSource$FromTag;", "dd-sdk-android-trace_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class ParentContextSource {
    public /* synthetic */ ParentContextSource(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract DatadogSpanContext getContext();

    private ParentContextSource() {
    }

    /* JADX INFO: compiled from: DatadogPropagationHelper.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/trace/internal/ParentContextSource$FromHeaders;", "Lcom/datadog/android/trace/internal/ParentContextSource;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lcom/datadog/android/trace/api/span/DatadogSpanContext;", "(Lcom/datadog/android/trace/api/span/DatadogSpanContext;)V", "getContext", "()Lcom/datadog/android/trace/api/span/DatadogSpanContext;", "dd-sdk-android-trace_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class FromHeaders extends ParentContextSource {
        private final DatadogSpanContext context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FromHeaders(DatadogSpanContext context) {
            super(null);
            Intrinsics.checkNotNullParameter(context, "context");
            this.context = context;
        }

        @Override // com.datadog.android.trace.internal.ParentContextSource
        public DatadogSpanContext getContext() {
            return this.context;
        }
    }

    /* JADX INFO: compiled from: DatadogPropagationHelper.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/trace/internal/ParentContextSource$FromTag;", "Lcom/datadog/android/trace/internal/ParentContextSource;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lcom/datadog/android/trace/api/span/DatadogSpanContext;", "(Lcom/datadog/android/trace/api/span/DatadogSpanContext;)V", "getContext", "()Lcom/datadog/android/trace/api/span/DatadogSpanContext;", "dd-sdk-android-trace_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class FromTag extends ParentContextSource {
        private final DatadogSpanContext context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FromTag(DatadogSpanContext context) {
            super(null);
            Intrinsics.checkNotNullParameter(context, "context");
            this.context = context;
        }

        @Override // com.datadog.android.trace.internal.ParentContextSource
        public DatadogSpanContext getContext() {
            return this.context;
        }
    }
}
