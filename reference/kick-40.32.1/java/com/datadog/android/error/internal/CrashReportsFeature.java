package com.datadog.android.error.internal;

import android.content.Context;
import com.datadog.android.api.feature.Feature;
import com.datadog.android.api.feature.FeatureSdkCore;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CrashReportsFeature.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0015H\u0016J\b\u0010\u0019\u001a\u00020\u0015H\u0002J\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u0014\u0010\u0005\u001a\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/datadog/android/error/internal/CrashReportsFeature;", "Lcom/datadog/android/api/feature/Feature;", "sdkCore", "Lcom/datadog/android/api/feature/FeatureSdkCore;", "(Lcom/datadog/android/api/feature/FeatureSdkCore;)V", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getInitialized$dd_sdk_android_core_release", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "name", "", "getName", "()Ljava/lang/String;", "originalUncaughtExceptionHandler", "Ljava/lang/Thread$UncaughtExceptionHandler;", "kotlin.jvm.PlatformType", "getOriginalUncaughtExceptionHandler$dd_sdk_android_core_release", "()Ljava/lang/Thread$UncaughtExceptionHandler;", "setOriginalUncaughtExceptionHandler$dd_sdk_android_core_release", "(Ljava/lang/Thread$UncaughtExceptionHandler;)V", "onInitialize", "", "appContext", "Landroid/content/Context;", "onStop", "resetOriginalExceptionHandler", "setupExceptionHandler", "Companion", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CrashReportsFeature implements Feature {
    public static final String CRASH_FEATURE_NAME = "crash";
    private final AtomicBoolean initialized;
    private final String name;
    private Thread.UncaughtExceptionHandler originalUncaughtExceptionHandler;
    private final FeatureSdkCore sdkCore;

    public CrashReportsFeature(FeatureSdkCore sdkCore) {
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        this.sdkCore = sdkCore;
        this.initialized = new AtomicBoolean(false);
        this.originalUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        this.name = "crash";
    }

    /* JADX INFO: renamed from: getInitialized$dd_sdk_android_core_release, reason: from getter */
    public final AtomicBoolean getInitialized() {
        return this.initialized;
    }

    /* JADX INFO: renamed from: getOriginalUncaughtExceptionHandler$dd_sdk_android_core_release, reason: from getter */
    public final Thread.UncaughtExceptionHandler getOriginalUncaughtExceptionHandler() {
        return this.originalUncaughtExceptionHandler;
    }

    public final void setOriginalUncaughtExceptionHandler$dd_sdk_android_core_release(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.originalUncaughtExceptionHandler = uncaughtExceptionHandler;
    }

    @Override // com.datadog.android.api.feature.Feature
    public String getName() {
        return this.name;
    }

    @Override // com.datadog.android.api.feature.Feature
    public void onInitialize(Context appContext) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        setupExceptionHandler(appContext);
        this.initialized.set(true);
    }

    @Override // com.datadog.android.api.feature.Feature
    public void onStop() {
        resetOriginalExceptionHandler();
        this.initialized.set(false);
    }

    private final void setupExceptionHandler(Context appContext) {
        this.originalUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        new DatadogExceptionHandler(this.sdkCore, appContext).register();
    }

    private final void resetOriginalExceptionHandler() {
        Thread.setDefaultUncaughtExceptionHandler(this.originalUncaughtExceptionHandler);
    }
}
