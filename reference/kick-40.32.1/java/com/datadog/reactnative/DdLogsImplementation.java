package com.datadog.reactnative;

import com.datadog.android.Datadog;
import com.datadog.android.core.InternalSdkCore;
import com.datadog.android.log.Logger;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReadableMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DdLogsImplementation.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u001e\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u001e\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u001e\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J<\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u00102\b\u0010\u001b\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J<\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u00102\b\u0010\u001b\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J<\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u00102\b\u0010\u001b\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J<\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u00102\b\u0010\u001b\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006 "}, d2 = {"Lcom/datadog/reactnative/DdLogsImplementation;", "", "datadog", "Lcom/datadog/reactnative/DatadogWrapper;", "logger", "Lkotlin/Function0;", "Lcom/datadog/android/log/Logger;", "<init>", "(Lcom/datadog/reactnative/DatadogWrapper;Lkotlin/jvm/functions/Function0;)V", "loggerInstance", "reactNativeLogger", "getReactNativeLogger", "()Lcom/datadog/android/log/Logger;", "debug", "", "message", "", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lcom/facebook/react/bridge/ReadableMap;", BaseJavaModule.METHOD_TYPE_PROMISE, "Lcom/facebook/react/bridge/Promise;", "info", "warn", "error", "debugWithError", "errorKind", "errorMessage", "stacktrace", "infoWithError", "warnWithError", "errorWithError", "Companion", "datadog_mobile-react-native_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DdLogsImplementation {
    public static final String NAME = "DdLogs";
    private final DatadogWrapper datadog;
    private final Function0<Logger> logger;
    private Logger loggerInstance;

    /* JADX WARN: Multi-variable type inference failed */
    public DdLogsImplementation() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public DdLogsImplementation(DatadogWrapper datadog, Function0<Logger> logger) {
        Intrinsics.checkNotNullParameter(datadog, "datadog");
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.datadog = datadog;
        this.logger = logger;
        DatadogSDKWrapperStorage.INSTANCE.addOnInitializedListener(new Function1() { // from class: com.datadog.reactnative.DdLogsImplementation$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DdLogsImplementation._init_$lambda$1(this.f$0, (InternalSdkCore) obj);
            }
        });
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ DdLogsImplementation(final DatadogWrapper datadogWrapper, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        datadogWrapper = (i & 1) != 0 ? new DatadogSDKWrapper() : datadogWrapper;
        this(datadogWrapper, (i & 2) != 0 ? new Function0() { // from class: com.datadog.reactnative.DdLogsImplementation$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                DatadogWrapper datadogWrapper2 = datadogWrapper;
                return new Logger.Builder(Datadog.getInstance$default(null, 1, null)).setLogcatLogsEnabled(true).setBundleWithRumEnabled(datadogWrapper2.getBundleLogsWithRum()).setBundleWithTraceEnabled(datadogWrapper2.getBundleLogsWithTraces()).setName("DdLogs").build();
            }
        } : function0);
    }

    private final Logger getReactNativeLogger() {
        if (this.loggerInstance == null) {
            this.loggerInstance = this.logger.invoke();
        }
        Logger logger = this.loggerInstance;
        Intrinsics.checkNotNull(logger);
        return logger;
    }

    static final Unit _init_$lambda$1(DdLogsImplementation ddLogsImplementation, InternalSdkCore it) {
        Intrinsics.checkNotNullParameter(it, "it");
        ddLogsImplementation.loggerInstance = null;
        return Unit.INSTANCE;
    }

    public final void debug(String message, ReadableMap context, Promise promise) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Logger.d$default(getReactNativeLogger(), message, null, MapsKt.plus(context.toHashMap(), GlobalState.INSTANCE.getGlobalAttributes$datadog_mobile_react_native_release()), 2, null);
        promise.resolve(null);
    }

    public final void info(String message, ReadableMap context, Promise promise) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Logger.i$default(getReactNativeLogger(), message, null, MapsKt.plus(context.toHashMap(), GlobalState.INSTANCE.getGlobalAttributes$datadog_mobile_react_native_release()), 2, null);
        promise.resolve(null);
    }

    public final void warn(String message, ReadableMap context, Promise promise) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Logger.w$default(getReactNativeLogger(), message, null, MapsKt.plus(context.toHashMap(), GlobalState.INSTANCE.getGlobalAttributes$datadog_mobile_react_native_release()), 2, null);
        promise.resolve(null);
    }

    public final void error(String message, ReadableMap context, Promise promise) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Logger.e$default(getReactNativeLogger(), message, null, MapsKt.plus(context.toHashMap(), GlobalState.INSTANCE.getGlobalAttributes$datadog_mobile_react_native_release()), 2, null);
        promise.resolve(null);
    }

    public final void debugWithError(String message, String errorKind, String errorMessage, String stacktrace, ReadableMap context, Promise promise) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(promise, "promise");
        getReactNativeLogger().log(3, message, errorKind, errorMessage, stacktrace, MapsKt.plus(context.toHashMap(), GlobalState.INSTANCE.getGlobalAttributes$datadog_mobile_react_native_release()));
        promise.resolve(null);
    }

    public final void infoWithError(String message, String errorKind, String errorMessage, String stacktrace, ReadableMap context, Promise promise) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(promise, "promise");
        getReactNativeLogger().log(4, message, errorKind, errorMessage, stacktrace, MapsKt.plus(context.toHashMap(), GlobalState.INSTANCE.getGlobalAttributes$datadog_mobile_react_native_release()));
        promise.resolve(null);
    }

    public final void warnWithError(String message, String errorKind, String errorMessage, String stacktrace, ReadableMap context, Promise promise) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(promise, "promise");
        getReactNativeLogger().log(5, message, errorKind, errorMessage, stacktrace, MapsKt.plus(context.toHashMap(), GlobalState.INSTANCE.getGlobalAttributes$datadog_mobile_react_native_release()));
        promise.resolve(null);
    }

    public final void errorWithError(String message, String errorKind, String errorMessage, String stacktrace, ReadableMap context, Promise promise) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(promise, "promise");
        getReactNativeLogger().log(6, message, errorKind, errorMessage, stacktrace, MapsKt.plus(context.toHashMap(), GlobalState.INSTANCE.getGlobalAttributes$datadog_mobile_react_native_release()));
        promise.resolve(null);
    }
}
