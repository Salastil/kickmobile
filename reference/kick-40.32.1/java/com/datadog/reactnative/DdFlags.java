package com.datadog.reactnative;

import com.datadog.android.rum.internal.RumFeature;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DdFlags.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0017J(\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0017J8\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0017R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/datadog/reactnative/DdFlags;", "Lcom/datadog/reactnative/NativeDdFlagsSpec;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "implementation", "Lcom/datadog/reactnative/DdFlagsImplementation;", "getName", "", "enable", "", "configuration", "Lcom/facebook/react/bridge/ReadableMap;", BaseJavaModule.METHOD_TYPE_PROMISE, "Lcom/facebook/react/bridge/Promise;", "setEvaluationContext", "clientName", "targetingKey", RumFeature.EVENT_ATTRIBUTES_PROPERTY, "trackEvaluation", "key", "rawFlag", "datadog_mobile-react-native_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DdFlags extends NativeDdFlagsSpec {
    private final DdFlagsImplementation implementation;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DdFlags(ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.implementation = new DdFlagsImplementation(null, 1, null);
    }

    @Override // com.datadog.reactnative.NativeDdFlagsSpec, com.facebook.react.bridge.NativeModule
    public String getName() {
        return "DdFlags";
    }

    @Override // com.datadog.reactnative.NativeDdFlagsSpec
    @ReactMethod
    public void enable(ReadableMap configuration, Promise promise) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.implementation.enable(configuration, promise);
    }

    @Override // com.datadog.reactnative.NativeDdFlagsSpec
    @ReactMethod
    public void setEvaluationContext(String clientName, String targetingKey, ReadableMap attributes, Promise promise) {
        Intrinsics.checkNotNullParameter(clientName, "clientName");
        Intrinsics.checkNotNullParameter(targetingKey, "targetingKey");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.implementation.setEvaluationContext(clientName, targetingKey, attributes, promise);
    }

    @Override // com.datadog.reactnative.NativeDdFlagsSpec
    @ReactMethod
    public void trackEvaluation(String clientName, String key, ReadableMap rawFlag, String targetingKey, ReadableMap attributes, Promise promise) {
        Intrinsics.checkNotNullParameter(clientName, "clientName");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(rawFlag, "rawFlag");
        Intrinsics.checkNotNullParameter(targetingKey, "targetingKey");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.implementation.trackEvaluation(clientName, key, rawFlag, targetingKey, attributes, promise);
    }
}
