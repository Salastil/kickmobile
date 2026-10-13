package com.datadog.android.trace.internal.net;

import com.datadog.android.trace.api.span.DatadogSpan;
import com.datadog.android.trace.api.span.DatadogSpanContext;
import java.util.List;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SpanSamplingIdProvider.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001b\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\b\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\t"}, d2 = {"Lcom/datadog/android/trace/internal/net/SpanSamplingIdProvider;", "", "()V", "provideId", "Lkotlin/ULong;", "span", "Lcom/datadog/android/trace/api/span/DatadogSpan;", "provideId-I7RO_PI", "(Lcom/datadog/android/trace/api/span/DatadogSpan;)J", "dd-sdk-android-trace_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SpanSamplingIdProvider {
    public static final SpanSamplingIdProvider INSTANCE = new SpanSamplingIdProvider();

    private SpanSamplingIdProvider() {
    }

    /* JADX INFO: renamed from: provideId-I7RO_PI, reason: not valid java name */
    public final long m11156provideIdI7RO_PI(DatadogSpan span) {
        List listSplit$default;
        String str;
        Long longOrNull;
        Intrinsics.checkNotNullParameter(span, "span");
        DatadogSpanContext datadogSpanContextContext = span.context();
        Object obj = datadogSpanContextContext.getTags().get("session_id");
        ULong uLongM12861boximpl = null;
        String str2 = obj instanceof String ? (String) obj : null;
        if (str2 != null && (listSplit$default = StringsKt.split$default((CharSequence) str2, new char[]{'-'}, false, 0, 6, (Object) null)) != null && (str = (String) CollectionsKt.lastOrNull(listSplit$default)) != null && (longOrNull = StringsKt.toLongOrNull(str, 16)) != null) {
            uLongM12861boximpl = ULong.m12861boximpl(ULong.m12867constructorimpl(longOrNull.longValue()));
        }
        return uLongM12861boximpl != null ? uLongM12861boximpl.getData() : ULong.m12867constructorimpl(datadogSpanContextContext.getTraceId().toLong());
    }
}
