package com.datadog.android.rum.internal.utils;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.api.storage.DataWriter;
import com.datadog.android.api.storage.EventBatchWriter;
import com.datadog.android.api.storage.EventType;
import com.datadog.android.api.storage.NoOpDataWriter;
import com.datadog.android.rum.GlobalRumMonitor;
import com.datadog.android.rum.RumMonitor;
import com.datadog.android.rum.internal.monitor.AdvancedRumMonitor;
import com.datadog.android.webview.internal.MixedWebViewEventConsumer;
import expo.modules.notifications.service.NotificationsService;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SdkCoreExt.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000  2\u00020\u0001:\u0001 B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\"\u0010\u0006\u001a\u001e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\u0002\u0010\u0011J\u001a\u0010\u001a\u001a\u00020\t2\u0010\b\u0002\u0010\u001b\u001a\n\u0018\u00010\u001cj\u0004\u0018\u0001`\u001dH\u0002J-\u0010\u0014\u001a\u00020\u00002%\u0010\u001e\u001a!\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\u0018J-\u0010\u0019\u001a\u00020\u00002%\u0010\u001e\u001a!\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\u0018J\u0006\u0010\u001f\u001a\u00020\tR\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R-\u0010\u0014\u001a!\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R-\u0010\u0019\u001a!\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0006\u001a\u001e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/datadog/android/rum/internal/utils/WriteOperation;", "", "sdkCore", "Lcom/datadog/android/api/feature/FeatureSdkCore;", "datadogContext", "Lcom/datadog/android/api/context/DatadogContext;", "writeScope", "Lkotlin/Function1;", "Lcom/datadog/android/api/storage/EventBatchWriter;", "", "Lcom/datadog/android/api/feature/EventWriteScope;", "rumDataWriter", "Lcom/datadog/android/api/storage/DataWriter;", MixedWebViewEventConsumer.EVENT_TYPE_KEY, "Lcom/datadog/android/api/storage/EventType;", "eventSource", "Lkotlin/Function0;", "(Lcom/datadog/android/api/feature/FeatureSdkCore;Lcom/datadog/android/api/context/DatadogContext;Lkotlin/jvm/functions/Function1;Lcom/datadog/android/api/storage/DataWriter;Lcom/datadog/android/api/storage/EventType;Lkotlin/jvm/functions/Function0;)V", "advancedRumMonitor", "Lcom/datadog/android/rum/internal/monitor/AdvancedRumMonitor;", "onError", "Lkotlin/ParameterName;", "name", "rumMonitor", "Lcom/datadog/android/rum/internal/utils/EventOutcomeAction;", "onSuccess", "notifyEventWriteFailure", NotificationsService.EXCEPTION_KEY, "Ljava/lang/Exception;", "Lkotlin/Exception;", "action", "submit", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class WriteOperation {
    public static final String NO_ERROR_CALLBACK_PROVIDED_WARNING = "Write operation failed, but no onError callback was provided.";
    public static final String WRITE_OPERATION_FAILED_ERROR = "Write operation failed.";
    public static final String WRITE_OPERATION_IGNORED = "Write operation ignored, session is expired or RUM feature is disabled.";
    private final AdvancedRumMonitor advancedRumMonitor;
    private final DatadogContext datadogContext;
    private final Function0<Object> eventSource;
    private final EventType eventType;
    private Function1<? super AdvancedRumMonitor, Unit> onError;
    private Function1<? super AdvancedRumMonitor, Unit> onSuccess;
    private final DataWriter<Object> rumDataWriter;
    private final FeatureSdkCore sdkCore;
    private final Function1<Function1<? super EventBatchWriter, Unit>, Unit> writeScope;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Function1<AdvancedRumMonitor, Unit> NO_OP_EVENT_OUTCOME_ACTION = new Function1<AdvancedRumMonitor, Unit>() { // from class: com.datadog.android.rum.internal.utils.WriteOperation$Companion$NO_OP_EVENT_OUTCOME_ACTION$1
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(AdvancedRumMonitor it) {
            Intrinsics.checkNotNullParameter(it, "it");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(AdvancedRumMonitor advancedRumMonitor) {
            invoke2(advancedRumMonitor);
            return Unit.INSTANCE;
        }
    };

    /* JADX WARN: Multi-variable type inference failed */
    public WriteOperation(FeatureSdkCore sdkCore, DatadogContext datadogContext, Function1<? super Function1<? super EventBatchWriter, Unit>, Unit> writeScope, DataWriter<Object> rumDataWriter, EventType eventType, Function0<? extends Object> eventSource) {
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        Intrinsics.checkNotNullParameter(datadogContext, "datadogContext");
        Intrinsics.checkNotNullParameter(writeScope, "writeScope");
        Intrinsics.checkNotNullParameter(rumDataWriter, "rumDataWriter");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(eventSource, "eventSource");
        this.sdkCore = sdkCore;
        this.datadogContext = datadogContext;
        this.writeScope = writeScope;
        this.rumDataWriter = rumDataWriter;
        this.eventType = eventType;
        this.eventSource = eventSource;
        RumMonitor rumMonitor = GlobalRumMonitor.get(sdkCore);
        this.advancedRumMonitor = rumMonitor instanceof AdvancedRumMonitor ? (AdvancedRumMonitor) rumMonitor : null;
        Function1<AdvancedRumMonitor, Unit> function1 = NO_OP_EVENT_OUTCOME_ACTION;
        this.onError = function1;
        this.onSuccess = function1;
    }

    public final WriteOperation onError(Function1<? super AdvancedRumMonitor, Unit> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        this.onError = action;
        return this;
    }

    public final WriteOperation onSuccess(Function1<? super AdvancedRumMonitor, Unit> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        this.onSuccess = action;
        return this;
    }

    public final void submit() {
        this.writeScope.invoke(new Function1<EventBatchWriter, Unit>() { // from class: com.datadog.android.rum.internal.utils.WriteOperation.submit.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EventBatchWriter eventBatchWriter) {
                invoke2(eventBatchWriter);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(EventBatchWriter eventBatchWriter) {
                Intrinsics.checkNotNullParameter(eventBatchWriter, "eventBatchWriter");
                boolean z = WriteOperation.this.rumDataWriter instanceof NoOpDataWriter;
                WriteOperation writeOperation = WriteOperation.this;
                if (!z) {
                    try {
                        boolean zWrite = WriteOperation.this.rumDataWriter.write(eventBatchWriter, writeOperation.eventSource.invoke(), WriteOperation.this.eventType);
                        WriteOperation writeOperation2 = WriteOperation.this;
                        if (zWrite) {
                            AdvancedRumMonitor advancedRumMonitor = writeOperation2.advancedRumMonitor;
                            if (advancedRumMonitor != null) {
                                WriteOperation.this.onSuccess.invoke(advancedRumMonitor);
                                return;
                            }
                            return;
                        }
                        WriteOperation.notifyEventWriteFailure$default(writeOperation2, null, 1, null);
                        return;
                    } catch (Exception e) {
                        WriteOperation.this.notifyEventWriteFailure(e);
                        return;
                    }
                }
                InternalLogger.DefaultImpls.log$default(writeOperation.sdkCore.getInternalLogger(), InternalLogger.Level.INFO, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.utils.WriteOperation.submit.1.1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return WriteOperation.WRITE_OPERATION_IGNORED;
                    }
                }, (Throwable) null, false, (Map) null, 56, (Object) null);
                AdvancedRumMonitor advancedRumMonitor2 = WriteOperation.this.advancedRumMonitor;
                if (advancedRumMonitor2 != null) {
                    WriteOperation.this.onError.invoke(advancedRumMonitor2);
                }
            }
        });
    }

    static /* synthetic */ void notifyEventWriteFailure$default(WriteOperation writeOperation, Exception exc, int i, Object obj) {
        if ((i & 1) != 0) {
            exc = null;
        }
        writeOperation.notifyEventWriteFailure(exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyEventWriteFailure(Exception exception) {
        List listMutableListOf = CollectionsKt.mutableListOf(InternalLogger.Target.USER);
        if (exception != null) {
            listMutableListOf.add(InternalLogger.Target.TELEMETRY);
        }
        InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.ERROR, listMutableListOf, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.utils.WriteOperation.notifyEventWriteFailure.1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return WriteOperation.WRITE_OPERATION_FAILED_ERROR;
            }
        }, (Throwable) exception, false, (Map) null, 48, (Object) null);
        AdvancedRumMonitor advancedRumMonitor = this.advancedRumMonitor;
        if (advancedRumMonitor != null) {
            if (Intrinsics.areEqual(this.onError, NO_OP_EVENT_OUTCOME_ACTION)) {
                InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.WARN, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.utils.WriteOperation$notifyEventWriteFailure$2$1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return WriteOperation.NO_ERROR_CALLBACK_PROVIDED_WARNING;
                    }
                }, (Throwable) null, false, (Map) null, 56, (Object) null);
            }
            this.onError.invoke(advancedRumMonitor);
        }
    }

    /* JADX INFO: compiled from: SdkCoreExt.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R0\u0010\u0005\u001a!\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006j\u0002`\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/datadog/android/rum/internal/utils/WriteOperation$Companion;", "", "()V", "NO_ERROR_CALLBACK_PROVIDED_WARNING", "", "NO_OP_EVENT_OUTCOME_ACTION", "Lkotlin/Function1;", "Lcom/datadog/android/rum/internal/monitor/AdvancedRumMonitor;", "Lkotlin/ParameterName;", "name", "rumMonitor", "", "Lcom/datadog/android/rum/internal/utils/EventOutcomeAction;", "getNO_OP_EVENT_OUTCOME_ACTION", "()Lkotlin/jvm/functions/Function1;", "WRITE_OPERATION_FAILED_ERROR", "WRITE_OPERATION_IGNORED", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Function1<AdvancedRumMonitor, Unit> getNO_OP_EVENT_OUTCOME_ACTION() {
            return WriteOperation.NO_OP_EVENT_OUTCOME_ACTION;
        }
    }
}
