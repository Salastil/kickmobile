package com.datadog.android.trace.internal.data;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.api.feature.FeatureScope;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.api.storage.EventBatchWriter;
import com.datadog.android.api.storage.EventType;
import com.datadog.android.api.storage.RawBatchEvent;
import com.datadog.android.event.EventMapper;
import com.datadog.android.event.NoOpEventMapper;
import com.datadog.android.trace.internal.RumContextPropagator;
import com.datadog.android.trace.internal.domain.event.ContextAwareMapper;
import com.datadog.android.trace.internal.storage.ContextAwareSerializer;
import com.datadog.android.trace.model.SpanEvent;
import com.datadog.trace.common.writer.Writer;
import com.datadog.trace.core.DDSpan;
import com.facebook.react.uimanager.ViewProps;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: compiled from: CoreTraceWriter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 &2\u00020\u0001:\u0001&BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0016H\u0016J\u0018\u0010\u001d\u001a\u00020\u00162\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001fH\u0016J \u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0006H\u0003R \u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/datadog/android/trace/internal/data/CoreTraceWriter;", "Lcom/datadog/trace/common/writer/Writer;", "sdkCore", "Lcom/datadog/android/api/feature/FeatureSdkCore;", "ddSpanToSpanEventMapper", "Lcom/datadog/android/trace/internal/domain/event/ContextAwareMapper;", "Lcom/datadog/trace/core/DDSpan;", "Lcom/datadog/android/trace/model/SpanEvent;", "eventMapper", "Lcom/datadog/android/event/EventMapper;", "serializer", "Lcom/datadog/android/trace/internal/storage/ContextAwareSerializer;", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "rumContextPropagator", "Lcom/datadog/android/trace/internal/RumContextPropagator;", "(Lcom/datadog/android/api/feature/FeatureSdkCore;Lcom/datadog/android/trace/internal/domain/event/ContextAwareMapper;Lcom/datadog/android/event/EventMapper;Lcom/datadog/android/trace/internal/storage/ContextAwareSerializer;Lcom/datadog/android/api/InternalLogger;Lcom/datadog/android/trace/internal/RumContextPropagator;)V", "getDdSpanToSpanEventMapper$dd_sdk_android_trace_release", "()Lcom/datadog/android/trace/internal/domain/event/ContextAwareMapper;", "getEventMapper$dd_sdk_android_trace_release", "()Lcom/datadog/android/event/EventMapper;", "close", "", "flush", "", "incrementDropCounts", "p0", "", ViewProps.START, "write", "trace", "", "writeSpan", "datadogContext", "Lcom/datadog/android/api/context/DatadogContext;", "writer", "Lcom/datadog/android/api/storage/EventBatchWriter;", "span", "Companion", "dd-sdk-android-trace_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CoreTraceWriter implements Writer {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Set<Integer> DROP_SAMPLING_PRIORITIES = SetsKt.setOf((Object[]) new Integer[]{0, -1});
    public static final String ERROR_SERIALIZING = "Error serializing %s model";
    private final ContextAwareMapper<DDSpan, SpanEvent> ddSpanToSpanEventMapper;
    private final EventMapper<SpanEvent> eventMapper;
    private final InternalLogger internalLogger;
    private final RumContextPropagator rumContextPropagator;
    private final FeatureSdkCore sdkCore;
    private final ContextAwareSerializer<SpanEvent> serializer;

    @Override // com.datadog.trace.common.writer.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // com.datadog.trace.common.writer.Writer
    public boolean flush() {
        return true;
    }

    @Override // com.datadog.trace.common.writer.Writer
    public void incrementDropCounts(int p0) {
    }

    @Override // com.datadog.trace.common.writer.Writer
    public void start() {
    }

    public CoreTraceWriter(FeatureSdkCore sdkCore, ContextAwareMapper<DDSpan, SpanEvent> ddSpanToSpanEventMapper, EventMapper<SpanEvent> eventMapper, ContextAwareSerializer<SpanEvent> serializer, InternalLogger internalLogger, RumContextPropagator rumContextPropagator) {
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        Intrinsics.checkNotNullParameter(ddSpanToSpanEventMapper, "ddSpanToSpanEventMapper");
        Intrinsics.checkNotNullParameter(eventMapper, "eventMapper");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        Intrinsics.checkNotNullParameter(rumContextPropagator, "rumContextPropagator");
        this.sdkCore = sdkCore;
        this.ddSpanToSpanEventMapper = ddSpanToSpanEventMapper;
        this.eventMapper = eventMapper;
        this.serializer = serializer;
        this.internalLogger = internalLogger;
        this.rumContextPropagator = rumContextPropagator;
    }

    public final ContextAwareMapper<DDSpan, SpanEvent> getDdSpanToSpanEventMapper$dd_sdk_android_trace_release() {
        return this.ddSpanToSpanEventMapper;
    }

    public /* synthetic */ CoreTraceWriter(final FeatureSdkCore featureSdkCore, ContextAwareMapper contextAwareMapper, NoOpEventMapper noOpEventMapper, ContextAwareSerializer contextAwareSerializer, InternalLogger internalLogger, RumContextPropagator rumContextPropagator, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(featureSdkCore, contextAwareMapper, (i & 4) != 0 ? new NoOpEventMapper() : noOpEventMapper, contextAwareSerializer, internalLogger, (i & 32) != 0 ? new RumContextPropagator(new Function0<FeatureSdkCore>() { // from class: com.datadog.android.trace.internal.data.CoreTraceWriter.1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FeatureSdkCore invoke() {
                return featureSdkCore;
            }
        }) : rumContextPropagator);
    }

    public final EventMapper<SpanEvent> getEventMapper$dd_sdk_android_trace_release() {
        return this.eventMapper;
    }

    @Override // com.datadog.trace.common.writer.Writer
    public void write(final List<? extends DDSpan> trace) {
        FeatureScope feature;
        if (trace == null || (feature = this.sdkCore.getFeature("tracing")) == null) {
            return;
        }
        FeatureScope.DefaultImpls.withWriteContext$default(feature, null, new Function2<DatadogContext, Function1<? super Function1<? super EventBatchWriter, ? extends Unit>, ? extends Unit>, Unit>() { // from class: com.datadog.android.trace.internal.data.CoreTraceWriter.write.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(DatadogContext datadogContext, Function1<? super Function1<? super EventBatchWriter, ? extends Unit>, ? extends Unit> function1) {
                invoke2(datadogContext, (Function1<? super Function1<? super EventBatchWriter, Unit>, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(final DatadogContext datadogContext, Function1<? super Function1<? super EventBatchWriter, Unit>, Unit> writeScope) {
                Intrinsics.checkNotNullParameter(datadogContext, "datadogContext");
                Intrinsics.checkNotNullParameter(writeScope, "writeScope");
                List<DDSpan> list = trace;
                ArrayList arrayList = new ArrayList();
                for (Object obj : list) {
                    if (!CollectionsKt.contains(CoreTraceWriter.INSTANCE.getDROP_SAMPLING_PRIORITIES$dd_sdk_android_trace_release(), ((DDSpan) obj).getTraceSamplingPriority())) {
                        arrayList.add(obj);
                    }
                }
                ArrayList arrayList2 = arrayList;
                CoreTraceWriter coreTraceWriter = this;
                ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    arrayList3.add(RumContextPropagator.Companion.extractRumContext$dd_sdk_android_trace_release$default(RumContextPropagator.INSTANCE, (DDSpan) it.next(), coreTraceWriter.rumContextPropagator, false, 2, null));
                }
                final ArrayList arrayList4 = arrayList3;
                final CoreTraceWriter coreTraceWriter2 = this;
                writeScope.invoke(new Function1<EventBatchWriter, Unit>() { // from class: com.datadog.android.trace.internal.data.CoreTraceWriter.write.1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(EventBatchWriter eventBatchWriter) {
                        invoke2(eventBatchWriter);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(EventBatchWriter it2) {
                        Intrinsics.checkNotNullParameter(it2, "it");
                        List<DDSpan> list2 = arrayList4;
                        CoreTraceWriter coreTraceWriter3 = coreTraceWriter2;
                        DatadogContext datadogContext2 = datadogContext;
                        Iterator<T> it3 = list2.iterator();
                        while (it3.hasNext()) {
                            coreTraceWriter3.writeSpan(datadogContext2, it2, (DDSpan) it3.next());
                        }
                    }
                });
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void writeSpan(DatadogContext datadogContext, EventBatchWriter writer, DDSpan span) {
        final SpanEvent map = this.eventMapper.map(this.ddSpanToSpanEventMapper.map(datadogContext, span));
        if (map == null) {
            return;
        }
        try {
            String strSerialize = this.serializer.serialize(datadogContext, map);
            if (strSerialize != null) {
                byte[] bytes = strSerialize.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                if (bytes != null) {
                    synchronized (this) {
                        writer.write(new RawBatchEvent(bytes, null, 2, null), null, EventType.DEFAULT);
                    }
                }
            }
        } catch (Throwable th) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.USER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.trace.internal.data.CoreTraceWriter.writeSpan.2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str = String.format(Locale.US, "Error serializing %s model", Arrays.copyOf(new Object[]{map.getClass().getSimpleName()}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
            }, th, false, (Map) null, 48, (Object) null);
        }
    }

    /* JADX INFO: compiled from: CoreTraceWriter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0080T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/datadog/android/trace/internal/data/CoreTraceWriter$Companion;", "", "()V", "DROP_SAMPLING_PRIORITIES", "", "", "getDROP_SAMPLING_PRIORITIES$dd_sdk_android_trace_release", "()Ljava/util/Set;", "ERROR_SERIALIZING", "", "dd-sdk-android-trace_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Set<Integer> getDROP_SAMPLING_PRIORITIES$dd_sdk_android_trace_release() {
            return CoreTraceWriter.DROP_SAMPLING_PRIORITIES;
        }
    }
}
