package com.datadog.android.trace.event;

import com.datadog.android.trace.model.SpanEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NoOpSpanEventMapper.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0006"}, d2 = {"Lcom/datadog/android/trace/event/NoOpSpanEventMapper;", "Lcom/datadog/android/trace/event/SpanEventMapper;", "()V", "map", "Lcom/datadog/android/trace/model/SpanEvent;", "event", "dd-sdk-android-trace_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NoOpSpanEventMapper implements SpanEventMapper {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.datadog.android.event.EventMapper
    public SpanEvent map(SpanEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return event;
    }
}
