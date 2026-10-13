package com.datadog.android.flags.internal.storage;

import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.api.feature.FeatureScope;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.api.storage.EventBatchWriter;
import com.datadog.android.api.storage.EventBatchWriterKt;
import com.datadog.android.api.storage.EventType;
import com.datadog.android.api.storage.RawBatchEvent;
import com.datadog.android.flags.internal.EvaluationEventWriter;
import com.datadog.android.flags.internal.aggregation.EvaluationAggregationStats;
import com.datadog.android.internal.telemetry.TelemetryContext;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: compiled from: EvaluationEventRecordWriter.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/datadog/android/flags/internal/storage/EvaluationEventRecordWriter;", "Lcom/datadog/android/flags/internal/EvaluationEventWriter;", "sdkCore", "Lcom/datadog/android/api/feature/FeatureSdkCore;", "(Lcom/datadog/android/api/feature/FeatureSdkCore;)V", "writeAll", "", "events", "", "Lcom/datadog/android/flags/internal/aggregation/EvaluationAggregationStats;", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class EvaluationEventRecordWriter implements EvaluationEventWriter {
    private final FeatureSdkCore sdkCore;

    public EvaluationEventRecordWriter(FeatureSdkCore sdkCore) {
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        this.sdkCore = sdkCore;
    }

    @Override // com.datadog.android.flags.internal.EvaluationEventWriter
    public void writeAll(final List<EvaluationAggregationStats> events) {
        Intrinsics.checkNotNullParameter(events, "events");
        if (events.isEmpty()) {
            return;
        }
        final String str = "flags-evaluations";
        FeatureScope feature = this.sdkCore.getFeature("flags-evaluations");
        if (feature != null) {
            FeatureScope.DefaultImpls.withWriteContext$default(feature, null, new Function2<DatadogContext, Function1<? super Function1<? super EventBatchWriter, ? extends Unit>, ? extends Unit>, Unit>() { // from class: com.datadog.android.flags.internal.storage.EvaluationEventRecordWriter.writeAll.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    final List<EvaluationAggregationStats> list = events;
                    final String str2 = str;
                    writeScope.invoke(new Function1<EventBatchWriter, Unit>() { // from class: com.datadog.android.flags.internal.storage.EvaluationEventRecordWriter.writeAll.1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(EventBatchWriter eventBatchWriter) {
                            invoke2(eventBatchWriter);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(EventBatchWriter batchWriter) {
                            Intrinsics.checkNotNullParameter(batchWriter, "batchWriter");
                            Iterator<EvaluationAggregationStats> it = list.iterator();
                            while (it.hasNext()) {
                                String string = it.next().toEvaluationEvent(datadogContext).toJson().toString();
                                Intrinsics.checkNotNullExpressionValue(string, "event.toEvaluationEvent(…              .toString()");
                                byte[] bytes = string.getBytes(Charsets.UTF_8);
                                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                                EventBatchWriterKt.write(batchWriter, new RawBatchEvent(bytes, null, 2, null), null, EventType.DEFAULT, new TelemetryContext(str2, null, 2, null));
                            }
                        }
                    });
                }
            }, 1, null);
        }
    }
}
