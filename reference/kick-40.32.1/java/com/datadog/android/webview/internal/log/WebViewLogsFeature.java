package com.datadog.android.webview.internal.log;

import android.content.Context;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.api.feature.StorageBackedFeature;
import com.datadog.android.api.net.RequestFactory;
import com.datadog.android.api.storage.DataWriter;
import com.datadog.android.api.storage.FeatureStorageConfiguration;
import com.datadog.android.api.storage.NoOpDataWriter;
import com.datadog.android.webview.internal.storage.WebViewDataWriter;
import com.datadog.android.webview.internal.storage.WebViewEventSerializer;
import com.google.gson.JsonObject;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WebViewLogsFeature.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 $2\u00020\u0001:\u0001$B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020 H\u0016R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u0013X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u00020\u0019X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006%"}, d2 = {"Lcom/datadog/android/webview/internal/log/WebViewLogsFeature;", "Lcom/datadog/android/api/feature/StorageBackedFeature;", "sdkCore", "Lcom/datadog/android/api/feature/FeatureSdkCore;", "requestFactory", "Lcom/datadog/android/api/net/RequestFactory;", "(Lcom/datadog/android/api/feature/FeatureSdkCore;Lcom/datadog/android/api/net/RequestFactory;)V", "dataWriter", "Lcom/datadog/android/api/storage/DataWriter;", "Lcom/google/gson/JsonObject;", "getDataWriter$dd_sdk_android_webview_release", "()Lcom/datadog/android/api/storage/DataWriter;", "setDataWriter$dd_sdk_android_webview_release", "(Lcom/datadog/android/api/storage/DataWriter;)V", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getInitialized$dd_sdk_android_webview_release", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "name", "", "getName", "()Ljava/lang/String;", "getRequestFactory", "()Lcom/datadog/android/api/net/RequestFactory;", "storageConfiguration", "Lcom/datadog/android/api/storage/FeatureStorageConfiguration;", "getStorageConfiguration", "()Lcom/datadog/android/api/storage/FeatureStorageConfiguration;", "createDataWriter", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "onInitialize", "", "appContext", "Landroid/content/Context;", "onStop", "Companion", "dd-sdk-android-webview_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class WebViewLogsFeature implements StorageBackedFeature {
    public static final String WEB_LOGS_FEATURE_NAME = "web-logs";
    private DataWriter<JsonObject> dataWriter;
    private final AtomicBoolean initialized;
    private final String name;
    private final RequestFactory requestFactory;
    private final FeatureSdkCore sdkCore;
    private final FeatureStorageConfiguration storageConfiguration;

    public WebViewLogsFeature(FeatureSdkCore sdkCore, RequestFactory requestFactory) {
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        Intrinsics.checkNotNullParameter(requestFactory, "requestFactory");
        this.sdkCore = sdkCore;
        this.requestFactory = requestFactory;
        this.dataWriter = new NoOpDataWriter();
        this.initialized = new AtomicBoolean(false);
        this.name = WEB_LOGS_FEATURE_NAME;
        this.storageConfiguration = FeatureStorageConfiguration.INSTANCE.getDEFAULT();
    }

    @Override // com.datadog.android.api.feature.StorageBackedFeature
    public RequestFactory getRequestFactory() {
        return this.requestFactory;
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

    @Override // com.datadog.android.api.feature.Feature
    public String getName() {
        return this.name;
    }

    @Override // com.datadog.android.api.feature.Feature
    public void onInitialize(Context appContext) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.dataWriter = createDataWriter(this.sdkCore.getInternalLogger());
        this.initialized.set(true);
    }

    @Override // com.datadog.android.api.feature.StorageBackedFeature
    public FeatureStorageConfiguration getStorageConfiguration() {
        return this.storageConfiguration;
    }

    @Override // com.datadog.android.api.feature.Feature
    public void onStop() {
        this.dataWriter = new NoOpDataWriter();
        this.initialized.set(false);
    }

    private final DataWriter<JsonObject> createDataWriter(InternalLogger internalLogger) {
        return new WebViewDataWriter(new WebViewEventSerializer(), internalLogger);
    }
}
