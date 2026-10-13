package com.datadog.android.trace.api.propagation;

import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.datadog.android.trace.api.span.DatadogSpanContext;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: DatadogPropagation.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001Jg\u0010\u0002\u001a\u0004\u0018\u00010\u0003\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0005\u001a\u0002H\u00042H\u0010\u0006\u001aD\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0005\u0012%\u0012#\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0007H&¢\u0006\u0002\u0010\u000eJp\u0010\u000f\u001a\u00020\r\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u0002H\u00042K\u0010\u0011\u001aG\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\n¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\n¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\r0\u0012H&¢\u0006\u0002\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/datadog/android/trace/api/propagation/DatadogPropagation;", "", "extract", "Lcom/datadog/android/trace/api/span/DatadogSpanContext;", "C", "carrier", "getter", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "", "", "classifier", "", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Lcom/datadog/android/trace/api/span/DatadogSpanContext;", "inject", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "setter", "Lkotlin/Function3;", "key", "value", "(Lcom/datadog/android/trace/api/span/DatadogSpanContext;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)V", "dd-sdk-android-trace-api_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface DatadogPropagation {
    <C> DatadogSpanContext extract(C carrier, Function2<? super C, ? super Function2<? super String, ? super String, Boolean>, Unit> getter);

    <C> void inject(DatadogSpanContext context, C carrier, Function3<? super C, ? super String, ? super String, Unit> setter);
}
