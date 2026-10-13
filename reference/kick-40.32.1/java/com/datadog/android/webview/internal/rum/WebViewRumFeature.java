package com.datadog.android.webview.internal.rum;

import android.content.Context;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.feature.FeatureContextUpdateReceiver;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.api.feature.StorageBackedFeature;
import com.datadog.android.api.net.RequestFactory;
import com.datadog.android.api.storage.DataWriter;
import com.datadog.android.api.storage.FeatureStorageConfiguration;
import com.datadog.android.api.storage.NoOpDataWriter;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.datadog.android.webview.internal.rum.domain.NativeRumViewsCache;
import com.datadog.android.webview.internal.rum.domain.WebViewNativeRumViewsCache;
import com.datadog.android.webview.internal.storage.WebViewDataWriter;
import com.datadog.android.webview.internal.storage.WebViewEventSerializer;
import com.google.gson.JsonObject;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WebViewRumFeature.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 62\u00020\u00012\u00020\u0002:\u00016B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0016\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010,\u001a\u00020-H\u0002J&\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\f2\u0014\u00101\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000bH\u0016J\u0010\u00102\u001a\u00020/2\u0006\u00103\u001a\u000204H\u0016J\b\u00105\u001a\u00020/H\u0016R(\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R(\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u001dX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\fX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0014\u0010\u0007\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\u00020(X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*¨\u00067"}, d2 = {"Lcom/datadog/android/webview/internal/rum/WebViewRumFeature;", "Lcom/datadog/android/api/feature/StorageBackedFeature;", "Lcom/datadog/android/api/feature/FeatureContextUpdateReceiver;", "sdkCore", "Lcom/datadog/android/api/feature/FeatureSdkCore;", "requestFactory", "Lcom/datadog/android/api/net/RequestFactory;", "nativeRumViewsCache", "Lcom/datadog/android/webview/internal/rum/domain/NativeRumViewsCache;", "(Lcom/datadog/android/api/feature/FeatureSdkCore;Lcom/datadog/android/api/net/RequestFactory;Lcom/datadog/android/webview/internal/rum/domain/NativeRumViewsCache;)V", "cachedRumContext", "", "", "", "getCachedRumContext$dd_sdk_android_webview_release", "()Ljava/util/Map;", "setCachedRumContext$dd_sdk_android_webview_release", "(Ljava/util/Map;)V", "cachedTracingContext", "getCachedTracingContext$dd_sdk_android_webview_release", "setCachedTracingContext$dd_sdk_android_webview_release", "dataWriter", "Lcom/datadog/android/api/storage/DataWriter;", "Lcom/google/gson/JsonObject;", "getDataWriter$dd_sdk_android_webview_release", "()Lcom/datadog/android/api/storage/DataWriter;", "setDataWriter$dd_sdk_android_webview_release", "(Lcom/datadog/android/api/storage/DataWriter;)V", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getInitialized$dd_sdk_android_webview_release", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "name", "getName", "()Ljava/lang/String;", "getNativeRumViewsCache$dd_sdk_android_webview_release", "()Lcom/datadog/android/webview/internal/rum/domain/NativeRumViewsCache;", "getRequestFactory", "()Lcom/datadog/android/api/net/RequestFactory;", "storageConfiguration", "Lcom/datadog/android/api/storage/FeatureStorageConfiguration;", "getStorageConfiguration", "()Lcom/datadog/android/api/storage/FeatureStorageConfiguration;", "createDataWriter", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "onContextUpdate", "", "featureName", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "onInitialize", "appContext", "Landroid/content/Context;", "onStop", "Companion", "dd-sdk-android-webview_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class WebViewRumFeature implements StorageBackedFeature, FeatureContextUpdateReceiver {
    public static final String WEB_RUM_FEATURE_NAME = "web-rum";
    private volatile Map<String, ? extends Object> cachedRumContext;
    private volatile Map<String, ? extends Object> cachedTracingContext;
    private DataWriter<JsonObject> dataWriter;
    private final AtomicBoolean initialized;
    private final String name;
    private final NativeRumViewsCache nativeRumViewsCache;
    private final RequestFactory requestFactory;
    private final FeatureSdkCore sdkCore;
    private final FeatureStorageConfiguration storageConfiguration;

    public WebViewRumFeature(FeatureSdkCore sdkCore, RequestFactory requestFactory, NativeRumViewsCache nativeRumViewsCache) {
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        Intrinsics.checkNotNullParameter(requestFactory, "requestFactory");
        Intrinsics.checkNotNullParameter(nativeRumViewsCache, "nativeRumViewsCache");
        this.sdkCore = sdkCore;
        this.requestFactory = requestFactory;
        this.nativeRumViewsCache = nativeRumViewsCache;
        this.dataWriter = new NoOpDataWriter();
        this.initialized = new AtomicBoolean(false);
        this.cachedRumContext = MapsKt.emptyMap();
        this.cachedTracingContext = MapsKt.emptyMap();
        this.name = WEB_RUM_FEATURE_NAME;
        this.storageConfiguration = FeatureStorageConfiguration.INSTANCE.getDEFAULT();
    }

    @Override // com.datadog.android.api.feature.StorageBackedFeature
    public RequestFactory getRequestFactory() {
        return this.requestFactory;
    }

    public /* synthetic */ WebViewRumFeature(FeatureSdkCore featureSdkCore, RequestFactory requestFactory, WebViewNativeRumViewsCache webViewNativeRumViewsCache, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(featureSdkCore, requestFactory, (i & 4) != 0 ? new WebViewNativeRumViewsCache(featureSdkCore.getTimeProvider(), 0L, 2, null) : webViewNativeRumViewsCache);
    }

    /* JADX INFO: renamed from: getNativeRumViewsCache$dd_sdk_android_webview_release, reason: from getter */
    public final NativeRumViewsCache getNativeRumViewsCache() {
        return this.nativeRumViewsCache;
    }

    public final DataWriter<JsonObject> getDataWriter$dd_sdk_android_webview_release() {
        return this.dataWriter;
    }

    public final void setDataWriter$dd_sdk_android_webview_release(DataWriter<JsonObject> dataWriter) {
        Intrinsics.checkNotNullParameter(dataWriter, "<set-?>");
        this.dataWriter = dataWriter;
    }

    /* JADX INFO: renamed from: getInitialized$dd_sdk_android_webview_release, reason: from getter */
    public final AtomicBoolean getInitialized() {
        return this.initialized;
    }

    public final Map<String, Object> getCachedRumContext$dd_sdk_android_webview_release() {
        return this.cachedRumContext;
    }

    public final void setCachedRumContext$dd_sdk_android_webview_release(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.cachedRumContext = map;
    }

    public final Map<String, Object> getCachedTracingContext$dd_sdk_android_webview_release() {
        return this.cachedTracingContext;
    }

    public final void setCachedTracingContext$dd_sdk_android_webview_release(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.cachedTracingContext = map;
    }

    @Override // com.datadog.android.api.feature.Feature
    public String getName() {
        return this.name;
    }

    @Override // com.datadog.android.api.feature.Feature
    public void onInitialize(Context appContext) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.sdkCore.setContextUpdateReceiver(this);
        this.dataWriter = createDataWriter(this.sdkCore.getInternalLogger());
        this.initialized.set(true);
    }

    @Override // com.datadog.android.api.feature.FeatureContextUpdateReceiver
    public void onContextUpdate(String featureName, Map<String, ? extends Object> context) {
        Intrinsics.checkNotNullParameter(featureName, "featureName");
        Intrinsics.checkNotNullParameter(context, "context");
        if (Intrinsics.areEqual(featureName, "rum")) {
            this.nativeRumViewsCache.addToCache(context);
            this.cachedRumContext = context;
        } else if (Intrinsics.areEqual(featureName, "tracing")) {
            this.cachedTracingContext = context;
        }
    }

    @Override // com.datadog.android.api.feature.StorageBackedFeature
    public FeatureStorageConfiguration getStorageConfiguration() {
        return this.storageConfiguration;
    }

    @Override // com.datadog.android.api.feature.Feature
    public void onStop() {
        this.sdkCore.removeContextUpdateReceiver(this);
        this.dataWriter = new NoOpDataWriter();
        this.initialized.set(false);
        this.cachedRumContext = MapsKt.emptyMap();
        this.cachedTracingContext = MapsKt.emptyMap();
    }

    private final DataWriter<JsonObject> createDataWriter(InternalLogger internalLogger) {
        return new WebViewDataWriter(new WebViewEventSerializer(), internalLogger);
    }
}
