package com.datadog.android.trace.internal;

import android.content.Context;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.api.feature.StorageBackedFeature;
import com.datadog.android.api.net.RequestFactory;
import com.datadog.android.api.storage.FeatureStorageConfiguration;
import com.datadog.android.trace.InternalCoreWriterProvider;
import com.datadog.android.trace.event.SpanEventMapper;
import com.datadog.android.trace.internal.data.CoreTraceWriter;
import com.datadog.android.trace.internal.domain.event.CoreTracerSpanToSpanEventMapper;
import com.datadog.android.trace.internal.domain.event.SpanEventMapperWrapper;
import com.datadog.android.trace.internal.domain.event.SpanEventSerializer;
import com.datadog.android.trace.internal.net.TracesRequestFactory;
import com.datadog.trace.common.writer.NoOpWriter;
import com.datadog.trace.common.writer.Writer;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TracingFeature.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010'\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\b\u0010(\u001a\u00020)H\u0016J\u0010\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0016J\b\u0010.\u001a\u00020+H\u0016R\u001a\u0010\f\u001a\u00020\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u0013X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\t\u001a\u00020\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001b\u001a\u00020\u001c8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020$X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&¨\u0006/"}, d2 = {"Lcom/datadog/android/trace/internal/TracingFeature;", "Lcom/datadog/android/trace/InternalCoreWriterProvider;", "Lcom/datadog/android/api/feature/StorageBackedFeature;", "sdkCore", "Lcom/datadog/android/api/feature/FeatureSdkCore;", "customEndpointUrl", "", "spanEventMapper", "Lcom/datadog/android/trace/event/SpanEventMapper;", "networkInfoEnabled", "", "(Lcom/datadog/android/api/feature/FeatureSdkCore;Ljava/lang/String;Lcom/datadog/android/trace/event/SpanEventMapper;Z)V", "coreTracerDataWriter", "Lcom/datadog/trace/common/writer/Writer;", "getCoreTracerDataWriter$dd_sdk_android_trace_release", "()Lcom/datadog/trace/common/writer/Writer;", "setCoreTracerDataWriter$dd_sdk_android_trace_release", "(Lcom/datadog/trace/common/writer/Writer;)V", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getInitialized$dd_sdk_android_trace_release", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "name", "getName", "()Ljava/lang/String;", "getNetworkInfoEnabled$dd_sdk_android_trace_release", "()Z", "requestFactory", "Lcom/datadog/android/api/net/RequestFactory;", "getRequestFactory", "()Lcom/datadog/android/api/net/RequestFactory;", "requestFactory$delegate", "Lkotlin/Lazy;", "getSpanEventMapper$dd_sdk_android_trace_release", "()Lcom/datadog/android/trace/event/SpanEventMapper;", "storageConfiguration", "Lcom/datadog/android/api/storage/FeatureStorageConfiguration;", "getStorageConfiguration", "()Lcom/datadog/android/api/storage/FeatureStorageConfiguration;", "createDataWriter", "getCoreTracerWriter", "Lcom/datadog/android/trace/internal/DatadogSpanWriterWrapper;", "onInitialize", "", "appContext", "Landroid/content/Context;", "onStop", "dd-sdk-android-trace_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TracingFeature implements InternalCoreWriterProvider, StorageBackedFeature {
    private Writer coreTracerDataWriter;
    private final AtomicBoolean initialized;
    private final String name;
    private final boolean networkInfoEnabled;

    /* JADX INFO: renamed from: requestFactory$delegate, reason: from kotlin metadata */
    private final Lazy requestFactory;
    private final FeatureSdkCore sdkCore;
    private final SpanEventMapper spanEventMapper;
    private final FeatureStorageConfiguration storageConfiguration;

    public TracingFeature(FeatureSdkCore sdkCore, final String str, SpanEventMapper spanEventMapper, boolean z) {
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        Intrinsics.checkNotNullParameter(spanEventMapper, "spanEventMapper");
        this.sdkCore = sdkCore;
        this.spanEventMapper = spanEventMapper;
        this.networkInfoEnabled = z;
        this.coreTracerDataWriter = new NoOpWriter();
        this.initialized = new AtomicBoolean(false);
        this.name = "tracing";
        this.requestFactory = LazyKt.lazy(new Function0<TracesRequestFactory>() { // from class: com.datadog.android.trace.internal.TracingFeature$requestFactory$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TracesRequestFactory invoke() {
                return new TracesRequestFactory(str, this.sdkCore.getInternalLogger());
            }
        });
        this.storageConfiguration = FeatureStorageConfiguration.INSTANCE.getDEFAULT();
    }

    /* JADX INFO: renamed from: getSpanEventMapper$dd_sdk_android_trace_release, reason: from getter */
    public final SpanEventMapper getSpanEventMapper() {
        return this.spanEventMapper;
    }

    /* JADX INFO: renamed from: getNetworkInfoEnabled$dd_sdk_android_trace_release, reason: from getter */
    public final boolean getNetworkInfoEnabled() {
        return this.networkInfoEnabled;
    }

    /* JADX INFO: renamed from: getCoreTracerDataWriter$dd_sdk_android_trace_release, reason: from getter */
    public final Writer getCoreTracerDataWriter() {
        return this.coreTracerDataWriter;
    }

    public final void setCoreTracerDataWriter$dd_sdk_android_trace_release(Writer writer) {
        Intrinsics.checkNotNullParameter(writer, "<set-?>");
        this.coreTracerDataWriter = writer;
    }

    /* JADX INFO: renamed from: getInitialized$dd_sdk_android_trace_release, reason: from getter */
    public final AtomicBoolean getInitialized() {
        return this.initialized;
    }

    @Override // com.datadog.android.api.feature.Feature
    public String getName() {
        return this.name;
    }

    @Override // com.datadog.android.api.feature.Feature
    public void onInitialize(Context appContext) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.coreTracerDataWriter = createDataWriter(this.sdkCore);
        this.initialized.set(true);
    }

    @Override // com.datadog.android.api.feature.StorageBackedFeature
    public RequestFactory getRequestFactory() {
        return (RequestFactory) this.requestFactory.getValue();
    }

    @Override // com.datadog.android.api.feature.StorageBackedFeature
    public FeatureStorageConfiguration getStorageConfiguration() {
        return this.storageConfiguration;
    }

    @Override // com.datadog.android.api.feature.Feature
    public void onStop() {
        this.initialized.set(false);
    }

    @Override // com.datadog.android.trace.InternalCoreWriterProvider
    public DatadogSpanWriterWrapper getCoreTracerWriter() {
        return new DatadogSpanWriterWrapper(this.coreTracerDataWriter);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Writer createDataWriter(FeatureSdkCore sdkCore) {
        InternalLogger internalLogger = sdkCore.getInternalLogger();
        return new CoreTraceWriter(sdkCore, new CoreTracerSpanToSpanEventMapper(this.networkInfoEnabled), new SpanEventMapperWrapper(this.spanEventMapper, internalLogger), new SpanEventSerializer(internalLogger, null, 2, 0 == true ? 1 : 0), internalLogger, null, 32, null);
    }
}
