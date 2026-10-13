package com.datadog.android.rum.internal.timeseries;

import androidx.exifinterface.media.ExifInterface;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.api.feature.FeatureScope;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.api.storage.DataWriter;
import com.datadog.android.api.storage.EventBatchWriter;
import com.datadog.android.api.storage.EventType;
import com.datadog.android.rum.internal.domain.RumContext;
import com.datadog.android.rum.internal.instrumentation.insights.InsightsCollector;
import com.datadog.android.rum.internal.instrumentation.insights.NoOpInsightsCollector;
import com.datadog.android.rum.internal.timeseries.factory.EventFactory;
import com.datadog.android.rum.internal.timeseries.provider.DataPointsReader;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: Pipeline.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 !*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002:\u0001!BS\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0010\u0010\t\u001a\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\u0010\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J,\u0010\u001a\u001a\u0004\u0018\u0001H\u001b\"\u0004\b\u0001\u0010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u001fH\u0082\b¢\u0006\u0002\u0010 R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/datadog/android/rum/internal/timeseries/Pipeline;", ExifInterface.GPS_DIRECTION_TRUE, "", "sdkCore", "Lcom/datadog/android/api/feature/FeatureSdkCore;", "reader", "Lcom/datadog/android/rum/internal/timeseries/provider/DataPointsReader;", "buffer", "Lcom/datadog/android/rum/internal/timeseries/Buffer;", "eventFactory", "Lcom/datadog/android/rum/internal/timeseries/factory/EventFactory;", "dataWriter", "Lcom/datadog/android/api/storage/DataWriter;", "insightsCollector", "Lcom/datadog/android/rum/internal/instrumentation/insights/InsightsCollector;", "(Lcom/datadog/android/api/feature/FeatureSdkCore;Lcom/datadog/android/rum/internal/timeseries/provider/DataPointsReader;Lcom/datadog/android/rum/internal/timeseries/Buffer;Lcom/datadog/android/rum/internal/timeseries/factory/EventFactory;Lcom/datadog/android/api/storage/DataWriter;Lcom/datadog/android/rum/internal/instrumentation/insights/InsightsCollector;)V", "intervalMs", "", "getIntervalMs", "()J", "drainAndWrite", "", "rumContext", "Lcom/datadog/android/rum/internal/domain/RumContext;", "execute", "flush", "safeCall", "R", "message", "", "block", "Lkotlin/Function0;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Pipeline<T> {
    private static final Companion Companion = new Companion(null);
    private static final String ERROR_EVENT_CREATION_FAILED = "Timeseries event creation failed";
    private static final String ERROR_FLUSH_FAILED = "Timeseries flush failed";
    private final Buffer<T> buffer;
    private final DataWriter<Object> dataWriter;
    private final EventFactory<T, ?> eventFactory;
    private final InsightsCollector insightsCollector;
    private final DataPointsReader<T> reader;
    private final FeatureSdkCore sdkCore;

    public Pipeline(FeatureSdkCore sdkCore, DataPointsReader<T> reader, Buffer<T> buffer, EventFactory<T, ?> eventFactory, DataWriter<Object> dataWriter, InsightsCollector insightsCollector) {
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        Intrinsics.checkNotNullParameter(reader, "reader");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Intrinsics.checkNotNullParameter(eventFactory, "eventFactory");
        Intrinsics.checkNotNullParameter(dataWriter, "dataWriter");
        Intrinsics.checkNotNullParameter(insightsCollector, "insightsCollector");
        this.sdkCore = sdkCore;
        this.reader = reader;
        this.buffer = buffer;
        this.eventFactory = eventFactory;
        this.dataWriter = dataWriter;
        this.insightsCollector = insightsCollector;
    }

    public /* synthetic */ Pipeline(FeatureSdkCore featureSdkCore, DataPointsReader dataPointsReader, Buffer buffer, EventFactory eventFactory, DataWriter dataWriter, NoOpInsightsCollector noOpInsightsCollector, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(featureSdkCore, dataPointsReader, buffer, eventFactory, dataWriter, (i & 32) != 0 ? new NoOpInsightsCollector() : noOpInsightsCollector);
    }

    public final long getIntervalMs() {
        return this.reader.getIntervalMs();
    }

    public final void execute(RumContext rumContext) {
        Intrinsics.checkNotNullParameter(rumContext, "rumContext");
        DataPoint<T> dataPoint = this.reader.read();
        synchronized (this) {
            if (dataPoint != null) {
                try {
                    this.buffer.add(dataPoint);
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (this.buffer.isFull()) {
                drainAndWrite(rumContext);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void flush(RumContext rumContext) {
        Intrinsics.checkNotNullParameter(rumContext, "rumContext");
        synchronized (this) {
            drainAndWrite(rumContext);
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void drainAndWrite(final RumContext rumContext) {
        List<DataPoint<T>> listDrain = this.buffer.drain();
        if (listDrain.isEmpty()) {
            return;
        }
        final List<DataPoint<T>> list = listDrain;
        FeatureScope feature = this.sdkCore.getFeature("rum");
        if (feature != null) {
            feature.withWriteContext(SetsKt.setOf((Object[]) new String[]{"session-replay", "tracing"}), new Function2<DatadogContext, Function1<? super Function1<? super EventBatchWriter, ? extends Unit>, ? extends Unit>, Unit>(this) { // from class: com.datadog.android.rum.internal.timeseries.Pipeline.drainAndWrite.1
                final /* synthetic */ Pipeline<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(DatadogContext datadogContext, Function1<? super Function1<? super EventBatchWriter, ? extends Unit>, ? extends Unit> function1) {
                    invoke2(datadogContext, (Function1<? super Function1<? super EventBatchWriter, Unit>, Unit>) function1);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(DatadogContext datadogContext, Function1<? super Function1<? super EventBatchWriter, Unit>, Unit> writeScope) {
                    final Object objCreate;
                    Intrinsics.checkNotNullParameter(datadogContext, "datadogContext");
                    Intrinsics.checkNotNullParameter(writeScope, "writeScope");
                    Pipeline<T> pipeline = this.this$0;
                    try {
                        objCreate = ((Pipeline) pipeline).eventFactory.create(datadogContext, rumContext, list);
                    } catch (Throwable th) {
                        InternalLogger.DefaultImpls.log$default(((Pipeline) pipeline).sdkCore.getInternalLogger(), InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new C07241(Pipeline.ERROR_EVENT_CREATION_FAILED), th, false, (Map) null, 48, (Object) null);
                        objCreate = null;
                    }
                    if (objCreate == null) {
                        return;
                    }
                    final Pipeline<T> pipeline2 = this.this$0;
                    writeScope.invoke(new Function1<EventBatchWriter, Unit>() { // from class: com.datadog.android.rum.internal.timeseries.Pipeline.drainAndWrite.1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(EventBatchWriter eventBatchWriter) {
                            invoke2(eventBatchWriter);
                            return Unit.INSTANCE;
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(EventBatchWriter batchWriter) {
                            Intrinsics.checkNotNullParameter(batchWriter, "batchWriter");
                            Pipeline<T> pipeline3 = pipeline2;
                            try {
                                if (((Pipeline) pipeline3).dataWriter.write(batchWriter, objCreate, EventType.DEFAULT)) {
                                    ((Pipeline) pipeline3).insightsCollector.onTimeseries(((Pipeline) pipeline3).eventFactory.getEventName());
                                }
                                Unit unit = Unit.INSTANCE;
                            } catch (Throwable th2) {
                                InternalLogger.DefaultImpls.log$default(((Pipeline) pipeline3).sdkCore.getInternalLogger(), InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new C07241(Pipeline.ERROR_FLUSH_FAILED), th2, false, (Map) null, 48, (Object) null);
                            }
                        }
                    });
                }
            });
        }
    }

    private final <R> R safeCall(String message, Function0<? extends R> block) {
        try {
            return block.invoke();
        } catch (Throwable th) {
            InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new C07241(message), th, false, (Map) null, 48, (Object) null);
            return null;
        }
    }

    /* JADX INFO: renamed from: com.datadog.android.rum.internal.timeseries.Pipeline$safeCall$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Pipeline.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "R", ExifInterface.GPS_DIRECTION_TRUE, "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class C07241 extends Lambda implements Function0<String> {
        final /* synthetic */ String $message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C07241(String str) {
            super(0);
            this.$message = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return this.$message;
        }
    }

    /* JADX INFO: compiled from: Pipeline.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/datadog/android/rum/internal/timeseries/Pipeline$Companion;", "", "()V", "ERROR_EVENT_CREATION_FAILED", "", "ERROR_FLUSH_FAILED", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
