package com.datadog.reactnative;

import android.util.Log;
import com.datadog.android.rum.RumActionType;
import com.datadog.android.rum.RumAttributes;
import com.datadog.android.rum.RumErrorSource;
import com.datadog.android.rum.RumResourceKind;
import com.datadog.android.rum.RumResourceMethod;
import com.datadog.android.rum.featureoperations.FailureReason;
import com.datadog.android.rum.internal.RumFeature;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.datadog.android.rum.internal.instrumentation.gestures.WindowCallbackWrapper;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.events.PointerEventHelper;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import io.ktor.http.ContentDisposition;
import io.ktor.http.ContentType;
import io.ktor.http.LinkHeader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: DdRumImplementation.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 D2\u00020\u0001:\u0001DB\u001d\b\u0000\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J.\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J&\u0010\u0013\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J.\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J.\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J8\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J.\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001bH\u0002J6\u0010\u001c\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J>\u0010\u001f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J>\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010(\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012J\u001e\u0010)\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010+\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010,\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010-\u001a\u00020\t2\u0006\u0010.\u001a\u00020/2\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u00100\u001a\u00020\t2\u0006\u00101\u001a\u0002022\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u00103\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012J\u001e\u00104\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u00105\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u00106\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012J*\u00107\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012J*\u00109\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012J2\u0010:\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u000b2\u0006\u0010;\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012J\f\u0010<\u001a\u00020=*\u00020\u000bH\u0002J\f\u0010>\u001a\u00020?*\u00020\u000bH\u0002J\f\u0010@\u001a\u00020A*\u00020\u000bH\u0002J\f\u0010B\u001a\u00020C*\u00020\u000bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006E"}, d2 = {"Lcom/datadog/reactnative/DdRumImplementation;", "", "datadog", "Lcom/datadog/reactnative/DatadogWrapper;", "heatmapActionHandler", "Lcom/datadog/reactnative/HeatmapActionHandler;", "<init>", "(Lcom/datadog/reactnative/DatadogWrapper;Lcom/datadog/reactnative/HeatmapActionHandler;)V", "startView", "", "key", "", "name", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lcom/facebook/react/bridge/ReadableMap;", "timestampMs", "", BaseJavaModule.METHOD_TYPE_PROMISE, "Lcom/facebook/react/bridge/Promise;", "stopView", "startAction", "type", "stopAction", "addAction", PointerEventHelper.POINTER_TYPE_TOUCH, "addActionWithoutHeatmap", RumFeature.EVENT_ATTRIBUTES_PROPERTY, "", "startResource", FirebaseAnalytics.Param.METHOD, ImagesContract.URL, "stopResource", "statusCode", "kind", ContentDisposition.Parameters.Size, "addError", "message", "source", "stacktrace", "fingerprint", "addTiming", "addViewAttribute", "value", "removeViewAttribute", "addViewAttributes", "removeViewAttributes", UserMetadata.KEYDATA_FILENAME, "Lcom/facebook/react/bridge/ReadableArray;", "addViewLoadingTime", "overwrite", "", "stopSession", "addFeatureFlagEvaluation", "valueAsMap", "getCurrentSessionId", "startFeatureOperation", "operationKey", "succeedFeatureOperation", "failFeatureOperation", "failureReason", "asRumActionType", "Lcom/datadog/android/rum/RumActionType;", "asRumResourceKind", "Lcom/datadog/android/rum/RumResourceKind;", "asErrorSource", "Lcom/datadog/android/rum/RumErrorSource;", "asRumResourceMethod", "Lcom/datadog/android/rum/RumResourceMethod;", "Companion", "datadog_mobile-react-native_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DdRumImplementation {
    private static final long MISSING_RESOURCE_SIZE = -1;
    public static final String NAME = "DdRum";
    private final DatadogWrapper datadog;
    private final HeatmapActionHandler heatmapActionHandler;

    /* JADX WARN: Multi-variable type inference failed */
    public DdRumImplementation() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public DdRumImplementation(DatadogWrapper datadog, HeatmapActionHandler heatmapActionHandler) {
        Intrinsics.checkNotNullParameter(datadog, "datadog");
        Intrinsics.checkNotNullParameter(heatmapActionHandler, "heatmapActionHandler");
        this.datadog = datadog;
        this.heatmapActionHandler = heatmapActionHandler;
    }

    public /* synthetic */ DdRumImplementation(DatadogSDKWrapper datadogSDKWrapper, HeatmapActionHandler heatmapActionHandler, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new DatadogSDKWrapper() : datadogSDKWrapper, (i & 2) != 0 ? new HeatmapActionHandler(null, null, 3, null) : heatmapActionHandler);
    }

    public final void startView(String key, String name, ReadableMap context, double timestampMs, Promise promise) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Map<String, ? extends Object> mutableMap = MapsKt.toMutableMap(context.toHashMap());
        mutableMap.put(RumAttributes.INTERNAL_TIMESTAMP, Long.valueOf((long) timestampMs));
        this.datadog.getRumMonitor().startView(key, name, mutableMap);
        promise.resolve(null);
    }

    public final void stopView(String key, ReadableMap context, double timestampMs, Promise promise) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Map<String, ? extends Object> mutableMap = MapsKt.toMutableMap(context.toHashMap());
        mutableMap.put(RumAttributes.INTERNAL_TIMESTAMP, Long.valueOf((long) timestampMs));
        this.datadog.getRumMonitor().stopView(key, mutableMap);
        promise.resolve(null);
    }

    public final void startAction(String type, String name, ReadableMap context, double timestampMs, Promise promise) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Map<String, ? extends Object> mutableMap = MapsKt.toMutableMap(context.toHashMap());
        mutableMap.put(RumAttributes.INTERNAL_TIMESTAMP, Long.valueOf((long) timestampMs));
        this.datadog.getRumMonitor().startAction(asRumActionType(type), name, mutableMap);
        promise.resolve(null);
    }

    public final void stopAction(String type, String name, ReadableMap context, double timestampMs, Promise promise) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Map<String, ? extends Object> mutableMap = MapsKt.toMutableMap(context.toHashMap());
        mutableMap.put(RumAttributes.INTERNAL_TIMESTAMP, Long.valueOf((long) timestampMs));
        this.datadog.getRumMonitor().stopAction(asRumActionType(type), name, mutableMap);
        promise.resolve(null);
    }

    public final void addAction(final String type, final String name, ReadableMap touch, ReadableMap context, double timestampMs, Promise promise) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(promise, "promise");
        final Map<String, ? extends Object> mutableMap = MapsKt.toMutableMap(context.toHashMap());
        mutableMap.put(RumAttributes.INTERNAL_TIMESTAMP, Long.valueOf((long) timestampMs));
        HeatmapActionHandler.EligibleAction eligibleActionResolveEligibility$datadog_mobile_react_native_release = this.heatmapActionHandler.resolveEligibility$datadog_mobile_react_native_release(this.datadog, type, name, touch);
        if (eligibleActionResolveEligibility$datadog_mobile_react_native_release == null) {
            addActionWithoutHeatmap(type, name, mutableMap);
            promise.resolve(null);
        } else {
            promise.resolve(null);
            this.heatmapActionHandler.attachHeatmapData$datadog_mobile_react_native_release(eligibleActionResolveEligibility$datadog_mobile_react_native_release, name, mutableMap, new Function0() { // from class: com.datadog.reactnative.DdRumImplementation$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return DdRumImplementation.addAction$lambda$1(this.f$0, type, name, mutableMap);
                }
            });
        }
    }

    static final Unit addAction$lambda$1(DdRumImplementation ddRumImplementation, String str, String str2, Map map) {
        ddRumImplementation.addActionWithoutHeatmap(str, str2, map);
        return Unit.INSTANCE;
    }

    private final void addActionWithoutHeatmap(String type, String name, Map<String, ? extends Object> attributes) {
        this.datadog.getRumMonitor().addAction(asRumActionType(type), name, attributes);
    }

    public final void startResource(String key, String method, String url, ReadableMap context, double timestampMs, Promise promise) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Map<String, ? extends Object> mutableMap = MapsKt.toMutableMap(context.toHashMap());
        mutableMap.put(RumAttributes.INTERNAL_TIMESTAMP, Long.valueOf((long) timestampMs));
        this.datadog.getRumMonitor().startResource(key, asRumResourceMethod(method), url, mutableMap);
        promise.resolve(null);
    }

    public final void stopResource(String key, double statusCode, String kind, double size, ReadableMap context, double timestampMs, Promise promise) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Map<String, ? extends Object> mutableMap = MapsKt.toMutableMap(context.toHashMap());
        mutableMap.put(RumAttributes.INTERNAL_TIMESTAMP, Long.valueOf((long) timestampMs));
        long j = (long) size;
        this.datadog.getRumMonitor().stopResource(key, Integer.valueOf((int) statusCode), j == -1 ? null : Long.valueOf(j), asRumResourceKind(kind), mutableMap);
        promise.resolve(null);
    }

    public final void addError(String message, String source, String stacktrace, ReadableMap context, double timestampMs, String fingerprint, Promise promise) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(stacktrace, "stacktrace");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fingerprint, "fingerprint");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Map<String, ? extends Object> mutableMap = MapsKt.toMutableMap(context.toHashMap());
        mutableMap.put(RumAttributes.INTERNAL_TIMESTAMP, Long.valueOf((long) timestampMs));
        if (fingerprint.length() > 0) {
            mutableMap.put("_dd.error.fingerprint", fingerprint);
        }
        this.datadog.getRumMonitor().addErrorWithStacktrace(message, asErrorSource(source), stacktrace, mutableMap);
        promise.resolve(null);
    }

    public final void addTiming(String name, Promise promise) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.datadog.getRumMonitor().addTiming(name);
        promise.resolve(null);
    }

    public final void addViewAttribute(String key, ReadableMap value, Promise promise) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Object obj = DdSdkBridgeExtKt.toMap(value).get("value");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(key, obj);
        this.datadog.getRumMonitor().addViewAttributes(linkedHashMap);
        promise.resolve(null);
    }

    public final void removeViewAttribute(String key, Promise promise) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.datadog.getRumMonitor().removeViewAttributes(CollectionsKt.listOf(key));
        promise.resolve(null);
    }

    public final void addViewAttributes(ReadableMap attributes, Promise promise) {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.datadog.getRumMonitor().addViewAttributes(DdSdkBridgeExtKt.toMap(attributes));
        promise.resolve(null);
    }

    public final void removeViewAttributes(ReadableArray keys, Promise promise) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        Intrinsics.checkNotNullParameter(promise, "promise");
        IntRange intRangeUntil = RangesKt.until(0, keys.size());
        ArrayList arrayList = new ArrayList();
        Iterator<Integer> it = intRangeUntil.iterator();
        while (it.hasNext()) {
            String string = keys.getString(((IntIterator) it).nextInt());
            if (string != null) {
                arrayList.add(string);
            }
        }
        this.datadog.getRumMonitor().removeViewAttributes(arrayList);
        promise.resolve(null);
    }

    public final void addViewLoadingTime(boolean overwrite, Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.datadog.getRumMonitor().addViewLoadingTime(overwrite);
        promise.resolve(null);
    }

    public final void stopSession(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.datadog.getRumMonitor().stopSession();
        promise.resolve(null);
    }

    public final void addFeatureFlagEvaluation(String name, ReadableMap valueAsMap, Promise promise) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(valueAsMap, "valueAsMap");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Object obj = valueAsMap.toHashMap().get("value");
        if (obj != null) {
            this.datadog.getRumMonitor().addFeatureFlagEvaluation(name, obj);
        }
        promise.resolve(null);
    }

    public final void getCurrentSessionId(final Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.datadog.getRumMonitor().getCurrentSessionId(new Function1() { // from class: com.datadog.reactnative.DdRumImplementation$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DdRumImplementation.getCurrentSessionId$lambda$0(promise, (String) obj);
            }
        });
    }

    static final Unit getCurrentSessionId$lambda$0(Promise promise, String str) {
        promise.resolve(str);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void startFeatureOperation$default(DdRumImplementation ddRumImplementation, String str, String str2, ReadableMap readableMap, Promise promise, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        ddRumImplementation.startFeatureOperation(str, str2, readableMap, promise);
    }

    public final void startFeatureOperation(String name, String operationKey, ReadableMap attributes, Promise promise) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.datadog.getRumMonitor().startFeatureOperation(name, operationKey, MapsKt.toMutableMap(attributes.toHashMap()));
        promise.resolve(null);
    }

    public static /* synthetic */ void succeedFeatureOperation$default(DdRumImplementation ddRumImplementation, String str, String str2, ReadableMap readableMap, Promise promise, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        ddRumImplementation.succeedFeatureOperation(str, str2, readableMap, promise);
    }

    public final void succeedFeatureOperation(String name, String operationKey, ReadableMap attributes, Promise promise) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.datadog.getRumMonitor().succeedFeatureOperation(name, operationKey, MapsKt.toMutableMap(attributes.toHashMap()));
        promise.resolve(null);
    }

    public static /* synthetic */ void failFeatureOperation$default(DdRumImplementation ddRumImplementation, String str, String str2, String str3, ReadableMap readableMap, Promise promise, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        ddRumImplementation.failFeatureOperation(str, str2, str3, readableMap, promise);
    }

    public final void failFeatureOperation(String name, String operationKey, String failureReason, ReadableMap attributes, Promise promise) {
        Object objM12684constructorimpl;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(failureReason, "failureReason");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Map<String, ? extends Object> mutableMap = MapsKt.toMutableMap(attributes.toHashMap());
        try {
            Result.Companion companion = Result.INSTANCE;
            DdRumImplementation ddRumImplementation = this;
            String upperCase = failureReason.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            objM12684constructorimpl = Result.m12684constructorimpl(FailureReason.valueOf(upperCase));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        FailureReason failureReason2 = FailureReason.OTHER;
        if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
            objM12684constructorimpl = failureReason2;
        }
        this.datadog.getRumMonitor().failFeatureOperation(name, operationKey, (FailureReason) objM12684constructorimpl, mutableMap);
        promise.resolve(null);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final RumActionType asRumActionType(String str) {
        Locale US = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US, "US");
        String lowerCase = str.toLowerCase(US);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        switch (lowerCase.hashCode()) {
            case -907680051:
                if (lowerCase.equals(ViewProps.SCROLL)) {
                    return RumActionType.SCROLL;
                }
                break;
            case 114595:
                if (lowerCase.equals("tap")) {
                    return RumActionType.TAP;
                }
                break;
            case 3015911:
                if (lowerCase.equals(WindowCallbackWrapper.BACK_DEFAULT_TARGET_NAME)) {
                    return RumActionType.BACK;
                }
                break;
            case 94750088:
                if (lowerCase.equals("click")) {
                    return RumActionType.CLICK;
                }
                break;
            case 109854522:
                if (lowerCase.equals("swipe")) {
                    return RumActionType.SWIPE;
                }
                break;
        }
        return RumActionType.CUSTOM;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final RumResourceKind asRumResourceKind(String str) {
        Locale US = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US, "US");
        String lowerCase = str.toLowerCase(US);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        switch (lowerCase.hashCode()) {
            case -1393046460:
                if (lowerCase.equals("beacon")) {
                    return RumResourceKind.BEACON;
                }
                break;
            case -1052618729:
                if (lowerCase.equals("native")) {
                    return RumResourceKind.NATIVE;
                }
                break;
            case 3401:
                if (lowerCase.equals("js")) {
                    return RumResourceKind.JS;
                }
                break;
            case 98819:
                if (lowerCase.equals("css")) {
                    return RumResourceKind.CSS;
                }
                break;
            case 118658:
                if (lowerCase.equals("xhr")) {
                    return RumResourceKind.XHR;
                }
                break;
            case 3148879:
                if (lowerCase.equals(ContentType.Font.TYPE)) {
                    return RumResourceKind.FONT;
                }
                break;
            case 97322682:
                if (lowerCase.equals("fetch")) {
                    return RumResourceKind.FETCH;
                }
                break;
            case 100313435:
                if (lowerCase.equals("image")) {
                    return RumResourceKind.IMAGE;
                }
                break;
            case 103772132:
                if (lowerCase.equals(LinkHeader.Parameters.Media)) {
                    return RumResourceKind.MEDIA;
                }
                break;
            case 106069776:
                if (lowerCase.equals("other")) {
                    return RumResourceKind.OTHER;
                }
                break;
            case 861720859:
                if (lowerCase.equals("document")) {
                    return RumResourceKind.DOCUMENT;
                }
                break;
        }
        return RumResourceKind.UNKNOWN;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final RumErrorSource asErrorSource(String str) {
        Locale US = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US, "US");
        String lowerCase = str.toLowerCase(US);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        switch (lowerCase.hashCode()) {
            case -1349088399:
                if (lowerCase.equals("custom")) {
                    return RumErrorSource.CUSTOM;
                }
                break;
            case -1097337456:
                if (lowerCase.equals("logger")) {
                    return RumErrorSource.LOGGER;
                }
                break;
            case -934521548:
                if (lowerCase.equals("report")) {
                    return RumErrorSource.REPORT;
                }
                break;
            case -896505829:
                if (lowerCase.equals("source")) {
                    return RumErrorSource.SOURCE;
                }
                break;
            case 92750597:
                if (lowerCase.equals("agent")) {
                    return RumErrorSource.AGENT;
                }
                break;
            case 951510359:
                if (lowerCase.equals("console")) {
                    return RumErrorSource.CONSOLE;
                }
                break;
            case 1224424441:
                if (lowerCase.equals("webview")) {
                    return RumErrorSource.WEBVIEW;
                }
                break;
            case 1843485230:
                if (lowerCase.equals("network")) {
                    return RumErrorSource.NETWORK;
                }
                break;
        }
        return RumErrorSource.SOURCE;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final RumResourceMethod asRumResourceMethod(String str) {
        Locale US = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US, "US");
        String lowerCase = str.toLowerCase(US);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        switch (lowerCase.hashCode()) {
            case -1335458389:
                if (lowerCase.equals("delete")) {
                    return RumResourceMethod.DELETE;
                }
                break;
            case -1249474914:
                if (lowerCase.equals("options")) {
                    return RumResourceMethod.OPTIONS;
                }
                break;
            case 102230:
                if (lowerCase.equals("get")) {
                    return RumResourceMethod.GET;
                }
                break;
            case 111375:
                if (lowerCase.equals("put")) {
                    return RumResourceMethod.PUT;
                }
                break;
            case 3198432:
                if (lowerCase.equals("head")) {
                    return RumResourceMethod.HEAD;
                }
                break;
            case 3446944:
                if (lowerCase.equals("post")) {
                    return RumResourceMethod.POST;
                }
                break;
            case 106438728:
                if (lowerCase.equals("patch")) {
                    return RumResourceMethod.PATCH;
                }
                break;
            case 110620997:
                if (lowerCase.equals("trace")) {
                    return RumResourceMethod.TRACE;
                }
                break;
            case 951351530:
                if (lowerCase.equals("connect")) {
                    return RumResourceMethod.CONNECT;
                }
                break;
        }
        Log.w(DdRum.class.getCanonicalName(), "Unknown RUM resource method given: " + str + ", using " + RumResourceMethod.GET + " as default");
        return RumResourceMethod.GET;
    }
}
