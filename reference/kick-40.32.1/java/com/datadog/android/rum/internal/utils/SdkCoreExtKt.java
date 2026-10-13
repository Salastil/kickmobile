package com.datadog.android.rum.internal.utils;

import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.api.storage.DataWriter;
import com.datadog.android.api.storage.EventBatchWriter;
import com.datadog.android.api.storage.EventType;
import com.datadog.android.webview.internal.MixedWebViewEventConsumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SdkCoreExt.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a^\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\"\u0010\u0005\u001a\u001e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012\u0004\u0012\u00020\b0\u0006j\u0002`\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u0010H\u0000*B\b\u0000\u0010\u0011\"\u001d\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\b0\u00062\u001d\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\b0\u0006¨\u0006\u0016"}, d2 = {"newRumEventWriteOperation", "Lcom/datadog/android/rum/internal/utils/WriteOperation;", "Lcom/datadog/android/api/feature/FeatureSdkCore;", "datadogContext", "Lcom/datadog/android/api/context/DatadogContext;", "writeScope", "Lkotlin/Function1;", "Lcom/datadog/android/api/storage/EventBatchWriter;", "", "Lcom/datadog/android/api/feature/EventWriteScope;", "rumDataWriter", "Lcom/datadog/android/api/storage/DataWriter;", "", MixedWebViewEventConsumer.EVENT_TYPE_KEY, "Lcom/datadog/android/api/storage/EventType;", "eventSource", "Lkotlin/Function0;", "EventOutcomeAction", "Lcom/datadog/android/rum/internal/monitor/AdvancedRumMonitor;", "Lkotlin/ParameterName;", "name", "rumMonitor", "dd-sdk-android-rum_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SdkCoreExtKt {
    public static /* synthetic */ WriteOperation newRumEventWriteOperation$default(FeatureSdkCore featureSdkCore, DatadogContext datadogContext, Function1 function1, DataWriter dataWriter, EventType eventType, Function0 function0, int i, Object obj) {
        if ((i & 8) != 0) {
            eventType = EventType.DEFAULT;
        }
        return newRumEventWriteOperation(featureSdkCore, datadogContext, function1, dataWriter, eventType, function0);
    }

    public static final WriteOperation newRumEventWriteOperation(FeatureSdkCore featureSdkCore, DatadogContext datadogContext, Function1<? super Function1<? super EventBatchWriter, Unit>, Unit> writeScope, DataWriter<Object> rumDataWriter, EventType eventType, Function0<? extends Object> eventSource) {
        Intrinsics.checkNotNullParameter(featureSdkCore, "<this>");
        Intrinsics.checkNotNullParameter(datadogContext, "datadogContext");
        Intrinsics.checkNotNullParameter(writeScope, "writeScope");
        Intrinsics.checkNotNullParameter(rumDataWriter, "rumDataWriter");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(eventSource, "eventSource");
        return new WriteOperation(featureSdkCore, datadogContext, writeScope, rumDataWriter, eventType, eventSource);
    }
}
