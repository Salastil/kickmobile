package com.datadog.android.trace;

import com.datadog.android.Datadog;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.SdkCore;
import com.datadog.android.api.feature.Feature;
import com.datadog.android.api.feature.FeatureScope;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.trace.api.span.DatadogSpanWriter;
import com.datadog.android.trace.api.tracer.DatadogTracerBuilder;
import com.datadog.android.trace.api.tracer.NoOpDatadogTracerBuilder;
import com.datadog.android.trace.internal.DatadogSpanWriterWrapper;
import com.datadog.android.trace.internal.DatadogTracerBuilderAdapter;
import com.datadog.android.trace.internal._TraceInternalProxy;
import com.datadog.trace.common.writer.NoOpWriter;
import com.datadog.trace.core.CoreTracer;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DatadogTracing.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0007B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\b"}, d2 = {"Lcom/datadog/android/trace/DatadogTracing;", "", "()V", "newTracerBuilder", "Lcom/datadog/android/trace/api/tracer/DatadogTracerBuilder;", "sdkCore", "Lcom/datadog/android/api/SdkCore;", "ErrorMessages", "dd-sdk-android-trace_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DatadogTracing {
    public static final DatadogTracing INSTANCE = new DatadogTracing();

    private DatadogTracing() {
    }

    public static /* synthetic */ DatadogTracerBuilder newTracerBuilder$default(SdkCore sdkCore, int i, Object obj) {
        if ((i & 1) != 0) {
            sdkCore = Datadog.getInstance$default(null, 1, null);
        }
        return newTracerBuilder(sdkCore);
    }

    @JvmStatic
    public static final DatadogTracerBuilder newTracerBuilder(SdkCore sdkCore) {
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        if (_TraceInternalProxy.INSTANCE.getTestBuilderProvider$dd_sdk_android_trace_release() != null) {
            DatadogTracerBuilder testBuilderProvider$dd_sdk_android_trace_release = _TraceInternalProxy.INSTANCE.getTestBuilderProvider$dd_sdk_android_trace_release();
            Intrinsics.checkNotNull(testBuilderProvider$dd_sdk_android_trace_release, "null cannot be cast to non-null type com.datadog.android.trace.api.tracer.DatadogTracerBuilder");
            return testBuilderProvider$dd_sdk_android_trace_release;
        }
        if (!(sdkCore instanceof FeatureSdkCore)) {
            return new NoOpDatadogTracerBuilder();
        }
        FeatureSdkCore featureSdkCore = (FeatureSdkCore) sdkCore;
        InternalLogger internalLogger = featureSdkCore.getInternalLogger();
        FeatureScope feature = featureSdkCore.getFeature("tracing");
        Feature featureUnwrap = feature != null ? feature.unwrap() : null;
        final InternalCoreWriterProvider internalCoreWriterProvider = featureUnwrap instanceof InternalCoreWriterProvider ? (InternalCoreWriterProvider) featureUnwrap : null;
        DatadogSpanWriter coreTracerWriter = internalCoreWriterProvider != null ? internalCoreWriterProvider.getCoreTracerWriter() : null;
        DatadogSpanWriterWrapper datadogSpanWriterWrapper = coreTracerWriter instanceof DatadogSpanWriterWrapper ? (DatadogSpanWriterWrapper) coreTracerWriter : null;
        NoOpWriter delegate = datadogSpanWriterWrapper != null ? datadogSpanWriterWrapper.getDelegate() : null;
        if (featureUnwrap == null) {
            InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.trace.DatadogTracing.newTracerBuilder.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return ErrorMessages.TRACING_NOT_ENABLED_ERROR_MESSAGE;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
        } else if (internalCoreWriterProvider == null) {
            InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.trace.DatadogTracing.newTracerBuilder.2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return ErrorMessages.WRITER_PROVIDER_INTERFACE_NOT_IMPLEMENTED_ERROR_MESSAGE;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
        } else if (delegate == null) {
            InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.trace.DatadogTracing.newTracerBuilder.3
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return ErrorMessages.INSTANCE.buildWrongWrapperMessage(internalCoreWriterProvider.getCoreTracerWriter().getClass());
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
        } else if (sdkCore.getService().length() == 0) {
            InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.trace.DatadogTracing.newTracerBuilder.4
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return ErrorMessages.DEFAULT_SERVICE_NAME_IS_MISSING_ERROR_MESSAGE;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
        }
        String service = sdkCore.getService();
        CoreTracer.CoreTracerBuilder coreTracerBuilder = new CoreTracer.CoreTracerBuilder(featureSdkCore.getInternalLogger());
        if (delegate == null) {
            delegate = new NoOpWriter();
        }
        CoreTracer.CoreTracerBuilder coreTracerBuilderWriter = coreTracerBuilder.writer(delegate);
        Intrinsics.checkNotNullExpressionValue(coreTracerBuilderWriter, "CoreTracerBuilder(sdkCor…r(writer ?: NoOpWriter())");
        return new DatadogTracerBuilderAdapter(featureSdkCore, service, coreTracerBuilderWriter);
    }

    /* JADX INFO: compiled from: DatadogTracing.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0007\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/datadog/android/trace/DatadogTracing$ErrorMessages;", "", "()V", "DEFAULT_SERVICE_NAME_IS_MISSING_ERROR_MESSAGE", "", "TRACING_NOT_ENABLED_ERROR_MESSAGE", "WRITER_PROVIDER_INTERFACE_NOT_IMPLEMENTED_ERROR_MESSAGE", "buildWrongWrapperMessage", "cls", "Ljava/lang/Class;", "dd-sdk-android-trace_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class ErrorMessages {
        public static final String DEFAULT_SERVICE_NAME_IS_MISSING_ERROR_MESSAGE = "Default service name is missing during DatadogTracerBuilder creation, did you initialize SDK?";
        public static final ErrorMessages INSTANCE = new ErrorMessages();
        public static final String TRACING_NOT_ENABLED_ERROR_MESSAGE = "You're trying to create an DatadogTracer instance, but either the SDK was not initialized or the Tracing feature was not registered. No tracing data will be sent.";
        public static final String WRITER_PROVIDER_INTERFACE_NOT_IMPLEMENTED_ERROR_MESSAGE = "The Tracing feature is not implementing the InternalCoreWriterProvider interface. No tracing data will be sent.";

        private ErrorMessages() {
        }

        public final String buildWrongWrapperMessage(Class<?> cls) {
            return "You're trying to create an DatadogTracer instance, but provided " + (cls != null ? cls.getCanonicalName() : null) + " writer wrapper is not supported.";
        }
    }
}
