package com.datadog.android.rum.internal.monitor;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.api.storage.EventBatchWriter;
import com.datadog.android.core.internal.utils.ConcurrencyExtKt;
import com.datadog.android.internal.thread.NamedCallable;
import com.datadog.android.rum.internal.domain.RumContext;
import com.datadog.android.rum.internal.domain.scope.RumRawEvent;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: DatadogRumMonitor.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\"\u0010\u0004\u001a\u001e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005\u0012\u0004\u0012\u00020\u00010\u0005j\u0002`\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "datadogContext", "Lcom/datadog/android/api/context/DatadogContext;", "writeScope", "Lkotlin/Function1;", "Lcom/datadog/android/api/storage/EventBatchWriter;", "Lcom/datadog/android/api/feature/EventWriteScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class DatadogRumMonitor$handleEvent$2 extends Lambda implements Function2<DatadogContext, Function1<? super Function1<? super EventBatchWriter, ? extends Unit>, ? extends Unit>, Unit> {
    final /* synthetic */ RumRawEvent $event;
    final /* synthetic */ DatadogRumMonitor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DatadogRumMonitor$handleEvent$2(DatadogRumMonitor datadogRumMonitor, RumRawEvent rumRawEvent) {
        super(2);
        this.this$0 = datadogRumMonitor;
        this.$event = rumRawEvent;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(DatadogContext datadogContext, Function1<? super Function1<? super EventBatchWriter, ? extends Unit>, ? extends Unit> function1) {
        invoke2(datadogContext, (Function1<? super Function1<? super EventBatchWriter, Unit>, Unit>) function1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(final DatadogContext datadogContext, final Function1<? super Function1<? super EventBatchWriter, Unit>, Unit> writeScope) {
        Intrinsics.checkNotNullParameter(datadogContext, "datadogContext");
        Intrinsics.checkNotNullParameter(writeScope, "writeScope");
        if (this.this$0.getExecutorService().isShutdown()) {
            return;
        }
        ExecutorService executorService = this.this$0.getExecutorService();
        InternalLogger internalLogger = this.this$0.sdkCore.getInternalLogger();
        String strValueOf = String.valueOf(Reflection.getOrCreateKotlinClass(this.$event.getClass()).getSimpleName());
        final DatadogRumMonitor datadogRumMonitor = this.this$0;
        final RumRawEvent rumRawEvent = this.$event;
        final RumContext rumContext = (RumContext) ConcurrencyExtKt.getSafe(ConcurrencyExtKt.submitSafe(executorService, "Rum event handling", internalLogger, new NamedCallable(strValueOf, new Callable() { // from class: com.datadog.android.rum.internal.monitor.DatadogRumMonitor$handleEvent$2$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return DatadogRumMonitor$handleEvent$2.invoke$lambda$1(datadogRumMonitor, rumRawEvent, datadogContext, writeScope);
            }
        })), "Rum get context", this.this$0.sdkCore.getInternalLogger());
        this.this$0.sdkCore.updateFeatureContext("rum", false, new Function1<Map<String, Object>, Unit>() { // from class: com.datadog.android.rum.internal.monitor.DatadogRumMonitor$handleEvent$2.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Map<String, Object> map) {
                invoke2(map);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Map<String, Object> it) {
                Map<String, Object> map;
                Intrinsics.checkNotNullParameter(it, "it");
                it.clear();
                RumContext rumContext2 = rumContext;
                if (rumContext2 == null || (map = rumContext2.toMap()) == null) {
                    return;
                }
                it.putAll(map);
            }
        });
    }

    static final RumContext invoke$lambda$1(DatadogRumMonitor datadogRumMonitor, RumRawEvent rumRawEvent, DatadogContext datadogContext, Function1 function1) {
        RumContext rumContextCurrentRumContext;
        synchronized (datadogRumMonitor.getRootScope()) {
            datadogRumMonitor.handleEventWithMethodCallPerf(rumRawEvent, datadogContext, function1);
            datadogRumMonitor.notifyDebugListenerWithState$dd_sdk_android_rum_release();
            rumContextCurrentRumContext = datadogRumMonitor.currentRumContext();
            datadogRumMonitor.updateCachedViewUrl(rumContextCurrentRumContext);
        }
        return rumContextCurrentRumContext;
    }
}
