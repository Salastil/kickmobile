package com.datadog.android.flags.internal.storage;

import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.api.feature.FeatureScope;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.api.storage.EventBatchWriter;
import com.datadog.android.api.storage.EventType;
import com.datadog.android.api.storage.RawBatchEvent;
import com.datadog.android.flags.model.ExposureEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: compiled from: ExposureEventRecordWriter.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/datadog/android/flags/internal/storage/ExposureEventRecordWriter;", "Lcom/datadog/android/flags/internal/storage/RecordWriter;", "sdkCore", "Lcom/datadog/android/api/feature/FeatureSdkCore;", "(Lcom/datadog/android/api/feature/FeatureSdkCore;)V", "write", "", "record", "Lcom/datadog/android/flags/model/ExposureEvent;", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ExposureEventRecordWriter implements RecordWriter {
    private final FeatureSdkCore sdkCore;

    public ExposureEventRecordWriter(FeatureSdkCore sdkCore) {
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        this.sdkCore = sdkCore;
    }

    @Override // com.datadog.android.flags.internal.storage.RecordWriter
    public void write(final ExposureEvent record) {
        Intrinsics.checkNotNullParameter(record, "record");
        FeatureScope feature = this.sdkCore.getFeature("flags");
        if (feature != null) {
            FeatureScope.DefaultImpls.withWriteContext$default(feature, null, new Function2<DatadogContext, Function1<? super Function1<? super EventBatchWriter, ? extends Unit>, ? extends Unit>, Unit>() { // from class: com.datadog.android.flags.internal.storage.ExposureEventRecordWriter.write.1
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
                public final void invoke2(DatadogContext datadogContext, Function1<? super Function1<? super EventBatchWriter, Unit>, Unit> writeScope) {
                    Intrinsics.checkNotNullParameter(datadogContext, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(writeScope, "writeScope");
                    final ExposureEvent exposureEvent = record;
                    final ExposureEventRecordWriter exposureEventRecordWriter = this;
                    writeScope.invoke(new Function1<EventBatchWriter, Unit>() { // from class: com.datadog.android.flags.internal.storage.ExposureEventRecordWriter.write.1.1
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
                        public final void invoke2(EventBatchWriter it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            String string = exposureEvent.toJson().toString();
                            Intrinsics.checkNotNullExpressionValue(string, "record.toJson().toString()");
                            byte[] bytes = string.getBytes(Charsets.UTF_8);
                            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                            RawBatchEvent rawBatchEvent = new RawBatchEvent(bytes, null, 2, null);
                            synchronized (exposureEventRecordWriter) {
                                it.write(rawBatchEvent, null, EventType.DEFAULT);
                                Unit unit = Unit.INSTANCE;
                            }
                        }
                    });
                }
            }, 1, null);
        }
    }
}
