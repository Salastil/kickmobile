package com.datadog.android.trace.api.propagation;

import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.datadog.android.trace.api.span.DatadogSpanContext;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NoOpDatadogPropagation.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002Jg\u0010\u0003\u001a\u0004\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0006\u001a\u0002H\u00052H\u0010\u0007\u001aD\u0012\u0013\u0012\u0011H\u0005¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0006\u0012%\u0012#\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\bH\u0016¢\u0006\u0002\u0010\u000fJp\u0010\u0010\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u0002H\u00052K\u0010\u0012\u001aG\u0012\u0013\u0012\u0011H\u0005¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u000e0\u0013H\u0016¢\u0006\u0002\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/datadog/android/trace/api/propagation/NoOpDatadogPropagation;", "Lcom/datadog/android/trace/api/propagation/DatadogPropagation;", "()V", "extract", "Lcom/datadog/android/trace/api/span/DatadogSpanContext;", "C", "carrier", "getter", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "", "", "classifier", "", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Lcom/datadog/android/trace/api/span/DatadogSpanContext;", "inject", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "setter", "Lkotlin/Function3;", "key", "value", "(Lcom/datadog/android/trace/api/span/DatadogSpanContext;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)V", "dd-sdk-android-trace-api_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NoOpDatadogPropagation implements DatadogPropagation {
    @Override // com.datadog.android.trace.api.propagation.DatadogPropagation
    public <C> DatadogSpanContext extract(C carrier, Function2<? super C, ? super Function2<? super String, ? super String, Boolean>, Unit> getter) {
        Intrinsics.checkNotNullParameter(getter, "getter");
        return null;
    }

    @Override // com.datadog.android.trace.api.propagation.DatadogPropagation
    public <C> void inject(DatadogSpanContext context, C carrier, Function3<? super C, ? super String, ? super String, Unit> setter) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(setter, "setter");
    }
}
