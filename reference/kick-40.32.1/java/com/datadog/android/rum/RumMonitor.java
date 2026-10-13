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
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: RumMonitor.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\bg\u0018\u00002\u00020\u0001J\n\u0010\b\u001a\u0004\u0018\u00010\tH&J0\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0011H&J\u001a\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H&J:\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0011H&J:\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u000f2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0011H&J\u0018\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0001H&J\u001c\u0010\u001e\u001a\u00020\u000b2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u0011H&J\u0010\u0010 \u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH&J\u001e\u0010!\u001a\u00020\u000b2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0011H&J\u0010\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u0003H'J\b\u0010$\u001a\u00020\u000bH&J<\u0010%\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u000f2\u0006\u0010'\u001a\u00020(2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0011H'J<\u0010)\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u000f2\u0006\u0010'\u001a\u00020*2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0011H'J\u0016\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0011H&J\u001e\u0010,\u001a\u00020\u000b2\u0014\u0010-\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u00020\u000b0.H&J\u0010\u0010/\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000fH&J\u0016\u00100\u001a\u00020\u000b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f01H&J\b\u00102\u001a\u00020\u000bH'J0\u00103\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0011H&J4\u00104\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u000f2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0011H'J>\u00105\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u00106\u001a\u0002072\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0011H'J8\u00108\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u000f2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0011H&J0\u0010<\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0011H&J0\u0010=\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0011H&JI\u0010>\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000f2\b\u0010?\u001a\u0004\u0018\u00010@2\b\u0010A\u001a\u0004\u0018\u00010B2\u0006\u0010C\u001a\u00020D2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0011H&¢\u0006\u0002\u0010EJY\u0010F\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000f2\b\u0010?\u001a\u0004\u0018\u00010@2\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010G\u001a\u00020\u000f2\b\u0010H\u001a\u0004\u0018\u00010\u000f2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0011H&¢\u0006\u0002\u0010IJO\u0010F\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000f2\b\u0010?\u001a\u0004\u0018\u00010@2\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0011H&¢\u0006\u0002\u0010JJ\b\u0010K\u001a\u00020\u000bH&J(\u0010L\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00012\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0011H&J4\u0010M\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u000f2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0011H'J4\u0010N\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u000f2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0011H'R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006O"}, d2 = {"Lcom/datadog/android/rum/RumMonitor;", "", "debug", "", "getDebug", "()Z", "setDebug", "(Z)V", "_getInternal", "Lcom/datadog/android/rum/_RumInternalProxy;", "addAction", "", "type", "Lcom/datadog/android/rum/RumActionType;", "name", "", RumFeature.EVENT_ATTRIBUTES_PROPERTY, "", "addAttribute", "key", "value", "addError", "message", "source", "Lcom/datadog/android/rum/RumErrorSource;", RumFeature.EVENT_THROWABLE_PROPERTY, "", "addErrorWithStacktrace", "stacktrace", "addFeatureFlagEvaluation", "addFeatureFlagEvaluations", "featureFlags", "addTiming", "addViewAttributes", "addViewLoadingTime", "overwrite", "clearAttributes", "failFeatureOperation", "operationKey", "failureReason", "Lcom/datadog/android/rum/featureoperations/FailureReason;", "failOperation", "Lcom/datadog/android/rum/operations/FailureReason;", "getAttributes", "getCurrentSessionId", "callback", "Lkotlin/Function1;", "removeAttribute", "removeViewAttributes", "", "reportAppFullyDisplayed", "startAction", "startFeatureOperation", "startOperation", "options", "Lcom/datadog/android/rum/operations/OperationOptions;", "startResource", FirebaseAnalytics.Param.METHOD, "Lcom/datadog/android/rum/RumResourceMethod;", ImagesContract.URL, "startView", "stopAction", "stopResource", "statusCode", "", ContentDisposition.Parameters.Size, "", "kind", "Lcom/datadog/android/rum/RumResourceKind;", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Lcom/datadog/android/rum/RumResourceKind;Ljava/util/Map;)V", "stopResourceWithError", "stackTrace", "errorType", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/datadog/android/rum/RumErrorSource;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/datadog/android/rum/RumErrorSource;Ljava/lang/Throwable;Ljava/util/Map;)V", "stopSession", "stopView", "succeedFeatureOperation", "succeedOperation", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface RumMonitor {
    /* synthetic */ _RumInternalProxy _getInternal();

    void addAction(RumActionType type, String name, Map<String, ? extends Object> attributes);

    void addAttribute(String key, Object value);

    void addError(String message, RumErrorSource source, Throwable throwable, Map<String, ? extends Object> attributes);

    void addErrorWithStacktrace(String message, RumErrorSource source, String stacktrace, Map<String, ? extends Object> attributes);

    void addFeatureFlagEvaluation(String name, Object value);

    void addFeatureFlagEvaluations(Map<String, ? extends Object> featureFlags);

    void addTiming(String name);

    void addViewAttributes(Map<String, ? extends Object> attributes);

    void addViewLoadingTime(boolean overwrite);

    void clearAttributes();

    @Deprecated(message = "Use failOperation instead.", replaceWith = @ReplaceWith(expression = "failOperation(name, operationKey, failureReason, attributes)", imports = {}))
    void failFeatureOperation(String name, String operationKey, FailureReason failureReason, Map<String, ? extends Object> attributes);

    void failOperation(String name, String operationKey, com.datadog.android.rum.operations.FailureReason failureReason, Map<String, ? extends Object> attributes);

    Map<String, Object> getAttributes();

    void getCurrentSessionId(Function1<? super String, Unit> callback);

    boolean getDebug();

    void removeAttribute(String key);

    void removeViewAttributes(Collection<String> attributes);

    void reportAppFullyDisplayed();

    void setDebug(boolean z);

    void startAction(RumActionType type, String name, Map<String, ? extends Object> attributes);

    @Deprecated(message = "Use startOperation instead.", replaceWith = @ReplaceWith(expression = "startOperation(name, operationKey, attributes)", imports = {}))
    void startFeatureOperation(String name, String operationKey, Map<String, ? extends Object> attributes);

    void startOperation(String name, String operationKey, OperationOptions options, Map<String, ? extends Object> attributes);

    void startResource(String key, RumResourceMethod method, String url, Map<String, ? extends Object> attributes);

    void startView(Object key, String name, Map<String, ? extends Object> attributes);

    void stopAction(RumActionType type, String name, Map<String, ? extends Object> attributes);

    void stopResource(String key, Integer statusCode, Long size, RumResourceKind kind, Map<String, ? extends Object> attributes);

    void stopResourceWithError(String key, Integer statusCode, String message, RumErrorSource source, String stackTrace, String errorType, Map<String, ? extends Object> attributes);

    void stopResourceWithError(String key, Integer statusCode, String message, RumErrorSource source, Throwable throwable, Map<String, ? extends Object> attributes);

    void stopSession();

    void stopView(Object key, Map<String, ? extends Object> attributes);

    @Deprecated(message = "Use succeedOperation instead.", replaceWith = @ReplaceWith(expression = "succeedOperation(name, operationKey, attributes)", imports = {}))
    void succeedFeatureOperation(String name, String operationKey, Map<String, ? extends Object> attributes);

    void succeedOperation(String name, String operationKey, Map<String, ? extends Object> attributes);

    /* JADX INFO: compiled from: RumMonitor.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void startView$default(RumMonitor rumMonitor, Object obj, String str, Map map, int i, Object obj2) {
            if (obj2 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startView");
            }
            if ((i & 4) != 0) {
                map = MapsKt.emptyMap();
            }
            rumMonitor.startView(obj, str, map);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void stopView$default(RumMonitor rumMonitor, Object obj, Map map, int i, Object obj2) {
            if (obj2 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: stopView");
            }
            if ((i & 2) != 0) {
                map = MapsKt.emptyMap();
            }
            rumMonitor.stopView(obj, map);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void addAction$default(RumMonitor rumMonitor, RumActionType rumActionType, String str, Map map, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addAction");
            }
            if ((i & 4) != 0) {
                map = MapsKt.emptyMap();
            }
            rumMonitor.addAction(rumActionType, str, map);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void startAction$default(RumMonitor rumMonitor, RumActionType rumActionType, String str, Map map, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startAction");
            }
            if ((i & 4) != 0) {
                map = MapsKt.emptyMap();
            }
            rumMonitor.startAction(rumActionType, str, map);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void stopAction$default(RumMonitor rumMonitor, RumActionType rumActionType, String str, Map map, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: stopAction");
            }
            if ((i & 4) != 0) {
                map = MapsKt.emptyMap();
            }
            rumMonitor.stopAction(rumActionType, str, map);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void startResource$default(RumMonitor rumMonitor, String str, RumResourceMethod rumResourceMethod, String str2, Map map, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startResource");
            }
            if ((i & 8) != 0) {
                map = MapsKt.emptyMap();
            }
            rumMonitor.startResource(str, rumResourceMethod, str2, map);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void stopResource$default(RumMonitor rumMonitor, String str, Integer num, Long l, RumResourceKind rumResourceKind, Map map, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: stopResource");
            }
            if ((i & 16) != 0) {
                map = MapsKt.emptyMap();
            }
            rumMonitor.stopResource(str, num, l, rumResourceKind, map);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void stopResourceWithError$default(RumMonitor rumMonitor, String str, Integer num, String str2, RumErrorSource rumErrorSource, Throwable th, Map map, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: stopResourceWithError");
            }
            if ((i & 32) != 0) {
                map = MapsKt.emptyMap();
            }
            rumMonitor.stopResourceWithError(str, num, str2, rumErrorSource, th, map);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void stopResourceWithError$default(RumMonitor rumMonitor, String str, Integer num, String str2, RumErrorSource rumErrorSource, String str3, String str4, Map map, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: stopResourceWithError");
            }
            rumMonitor.stopResourceWithError(str, num, str2, rumErrorSource, str3, str4, (i & 64) != 0 ? MapsKt.emptyMap() : map);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void addError$default(RumMonitor rumMonitor, String str, RumErrorSource rumErrorSource, Throwable th, Map map, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addError");
            }
            if ((i & 8) != 0) {
                map = MapsKt.emptyMap();
            }
            rumMonitor.addError(str, rumErrorSource, th, map);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void addErrorWithStacktrace$default(RumMonitor rumMonitor, String str, RumErrorSource rumErrorSource, String str2, Map map, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addErrorWithStacktrace");
            }
            if ((i & 8) != 0) {
                map = MapsKt.emptyMap();
            }
            rumMonitor.addErrorWithStacktrace(str, rumErrorSource, str2, map);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void startFeatureOperation$default(RumMonitor rumMonitor, String str, String str2, Map map, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startFeatureOperation");
            }
            if ((i & 2) != 0) {
                str2 = null;
            }
            if ((i & 4) != 0) {
                map = MapsKt.emptyMap();
            }
            rumMonitor.startFeatureOperation(str, str2, map);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void startOperation$default(RumMonitor rumMonitor, String str, String str2, OperationOptions operationOptions, Map map, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startOperation");
            }
            if ((i & 2) != 0) {
                str2 = null;
            }
            if ((i & 4) != 0) {
                operationOptions = OperationOptions.Empty.INSTANCE;
            }
            if ((i & 8) != 0) {
                map = MapsKt.emptyMap();
            }
            rumMonitor.startOperation(str, str2, operationOptions, map);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void succeedFeatureOperation$default(RumMonitor rumMonitor, String str, String str2, Map map, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: succeedFeatureOperation");
            }
            if ((i & 2) != 0) {
                str2 = null;
            }
            if ((i & 4) != 0) {
                map = MapsKt.emptyMap();
            }
            rumMonitor.succeedFeatureOperation(str, str2, map);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void succeedOperation$default(RumMonitor rumMonitor, String str, String str2, Map map, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: succeedOperation");
            }
            if ((i & 2) != 0) {
                str2 = null;
            }
            if ((i & 4) != 0) {
                map = MapsKt.emptyMap();
            }
            rumMonitor.succeedOperation(str, str2, map);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void failFeatureOperation$default(RumMonitor rumMonitor, String str, String str2, FailureReason failureReason, Map map, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: failFeatureOperation");
            }
            if ((i & 2) != 0) {
                str2 = null;
            }
            if ((i & 8) != 0) {
                map = MapsKt.emptyMap();
            }
            rumMonitor.failFeatureOperation(str, str2, failureReason, map);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void failOperation$default(RumMonitor rumMonitor, String str, String str2, com.datadog.android.rum.operations.FailureReason failureReason, Map map, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: failOperation");
            }
            if ((i & 2) != 0) {
                str2 = null;
            }
            if ((i & 8) != 0) {
                map = MapsKt.emptyMap();
            }
            rumMonitor.failOperation(str, str2, failureReason, map);
        }
    }
}
