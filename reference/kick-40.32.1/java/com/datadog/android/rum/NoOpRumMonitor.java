package com.datadog.android.rum;

import com.datadog.android.rum.featureoperations.FailureReason;
import com.datadog.android.rum.internal.RumFeature;
import com.datadog.android.rum.operations.OperationOptions;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.ktor.http.ContentDisposition;
import java.util.Collection;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NoOpRumMonitor.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J.\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012H\u0016J\u001a\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u0013H\u0016J8\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012H\u0016J8\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00102\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012H\u0016J\u0018\u0010\u001f\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0013H\u0016J\u001c\u0010 \u001a\u00020\f2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00130\u0012H\u0016J\u0010\u0010\"\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001e\u0010#\u001a\u00020\f2\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012H\u0016J\u0010\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020\u0004H\u0016J\b\u0010&\u001a\u00020\fH\u0016J8\u0010'\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010(\u001a\u0004\u0018\u00010\u00102\u0006\u0010)\u001a\u00020*2\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012H\u0017J8\u0010+\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010(\u001a\u0004\u0018\u00010\u00102\u0006\u0010)\u001a\u00020,2\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012H\u0016J\u0016\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012H\u0016J\u001e\u0010.\u001a\u00020\f2\u0014\u0010/\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\f00H\u0016J\u0010\u00101\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0010H\u0016J\u0016\u00102\u001a\u00020\f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u001003H\u0016J\b\u00104\u001a\u00020\fH\u0016J.\u00105\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012H\u0016J0\u00106\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010(\u001a\u0004\u0018\u00010\u00102\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012H\u0017J8\u00107\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010(\u001a\u0004\u0018\u00010\u00102\u0006\u00108\u001a\u0002092\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012H\u0016J6\u0010:\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u00102\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012H\u0016J.\u0010>\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00102\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012H\u0016J.\u0010?\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012H\u0016JG\u0010@\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00102\b\u0010A\u001a\u0004\u0018\u00010B2\b\u0010C\u001a\u0004\u0018\u00010D2\u0006\u0010E\u001a\u00020F2\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012H\u0016¢\u0006\u0002\u0010GJW\u0010H\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00102\b\u0010A\u001a\u0004\u0018\u00010B2\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010I\u001a\u00020\u00102\b\u0010J\u001a\u0004\u0018\u00010\u00102\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012H\u0016¢\u0006\u0002\u0010KJM\u0010H\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00102\b\u0010A\u001a\u0004\u0018\u00010B2\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012H\u0016¢\u0006\u0002\u0010LJ\b\u0010M\u001a\u00020\fH\u0016J&\u0010N\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00132\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012H\u0016J0\u0010O\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010(\u001a\u0004\u0018\u00010\u00102\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012H\u0017J0\u0010P\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010(\u001a\u0004\u0018\u00010\u00102\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006Q"}, d2 = {"Lcom/datadog/android/rum/NoOpRumMonitor;", "Lcom/datadog/android/rum/RumMonitor;", "()V", "debug", "", "getDebug", "()Z", "setDebug", "(Z)V", "_getInternal", "Lcom/datadog/android/rum/_RumInternalProxy;", "addAction", "", "type", "Lcom/datadog/android/rum/RumActionType;", "name", "", RumFeature.EVENT_ATTRIBUTES_PROPERTY, "", "", "addAttribute", "key", "value", "addError", "message", "source", "Lcom/datadog/android/rum/RumErrorSource;", RumFeature.EVENT_THROWABLE_PROPERTY, "", "addErrorWithStacktrace", "stacktrace", "addFeatureFlagEvaluation", "addFeatureFlagEvaluations", "featureFlags", "addTiming", "addViewAttributes", "addViewLoadingTime", "overwrite", "clearAttributes", "failFeatureOperation", "operationKey", "failureReason", "Lcom/datadog/android/rum/featureoperations/FailureReason;", "failOperation", "Lcom/datadog/android/rum/operations/FailureReason;", "getAttributes", "getCurrentSessionId", "callback", "Lkotlin/Function1;", "removeAttribute", "removeViewAttributes", "", "reportAppFullyDisplayed", "startAction", "startFeatureOperation", "startOperation", "options", "Lcom/datadog/android/rum/operations/OperationOptions;", "startResource", FirebaseAnalytics.Param.METHOD, "Lcom/datadog/android/rum/RumResourceMethod;", ImagesContract.URL, "startView", "stopAction", "stopResource", "statusCode", "", ContentDisposition.Parameters.Size, "", "kind", "Lcom/datadog/android/rum/RumResourceKind;", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Lcom/datadog/android/rum/RumResourceKind;Ljava/util/Map;)V", "stopResourceWithError", "stackTrace", "errorType", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/datadog/android/rum/RumErrorSource;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/datadog/android/rum/RumErrorSource;Ljava/lang/Throwable;Ljava/util/Map;)V", "stopSession", "stopView", "succeedFeatureOperation", "succeedOperation", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NoOpRumMonitor implements RumMonitor {
    private boolean debug;

    @Override // com.datadog.android.rum.RumMonitor
    public _RumInternalProxy _getInternal() {
        return null;
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void addAction(RumActionType type, String name, Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void addAttribute(String key, Object value) {
        Intrinsics.checkNotNullParameter(key, "key");
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void addError(String message, RumErrorSource source, Throwable throwable, Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void addErrorWithStacktrace(String message, RumErrorSource source, String stacktrace, Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void addFeatureFlagEvaluation(String name, Object value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void addFeatureFlagEvaluations(Map<String, ? extends Object> featureFlags) {
        Intrinsics.checkNotNullParameter(featureFlags, "featureFlags");
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void addTiming(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void addViewAttributes(Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void addViewLoadingTime(boolean overwrite) {
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void clearAttributes() {
    }

    @Override // com.datadog.android.rum.RumMonitor
    @Deprecated(message = "Use failOperation instead.")
    public void failFeatureOperation(String name, String operationKey, FailureReason failureReason, Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(failureReason, "failureReason");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void failOperation(String name, String operationKey, com.datadog.android.rum.operations.FailureReason failureReason, Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(failureReason, "failureReason");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void getCurrentSessionId(Function1<? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void removeAttribute(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void removeViewAttributes(Collection<String> attributes) {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void reportAppFullyDisplayed() {
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void startAction(RumActionType type, String name, Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
    }

    @Override // com.datadog.android.rum.RumMonitor
    @Deprecated(message = "Use startOperation instead.")
    public void startFeatureOperation(String name, String operationKey, Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void startOperation(String name, String operationKey, OperationOptions options, Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void startResource(String key, RumResourceMethod method, String url, Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void startView(Object key, String name, Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void stopAction(RumActionType type, String name, Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void stopResource(String key, Integer statusCode, Long size, RumResourceKind kind, Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void stopResourceWithError(String key, Integer statusCode, String message, RumErrorSource source, String stackTrace, String errorType, Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(stackTrace, "stackTrace");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void stopResourceWithError(String key, Integer statusCode, String message, RumErrorSource source, Throwable throwable, Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void stopSession() {
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void stopView(Object key, Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
    }

    @Override // com.datadog.android.rum.RumMonitor
    @Deprecated(message = "Use succeedOperation instead.")
    public void succeedFeatureOperation(String name, String operationKey, Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void succeedOperation(String name, String operationKey, Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
    }

    @Override // com.datadog.android.rum.RumMonitor
    public boolean getDebug() {
        return this.debug;
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void setDebug(boolean z) {
        this.debug = z;
    }

    @Override // com.datadog.android.rum.RumMonitor
    public Map<String, Object> getAttributes() {
        return MapsKt.emptyMap();
    }
}
