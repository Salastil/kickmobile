package com.datadog.android.ndk.internal;

import android.content.Context;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.feature.Feature;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.core.InternalSdkCore;
import com.datadog.android.core.internal.metrics.BatchMetricsDispatcher;
import com.datadog.android.internal.utils.StrictModeExtKt;
import com.datadog.android.privacy.TrackingConsent;
import com.datadog.android.privacy.TrackingConsentProviderCallback;
import java.io.File;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NdkCrashReportsFeature.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\b\u0000\u0018\u0000 \"2\u00020\u00012\u00020\u0002:\u0001\"B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0000¢\u0006\u0002\b\u0010J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0012H\u0016J!\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001fH\u0082 J\t\u0010 \u001a\u00020\u0012H\u0082 J\u0011\u0010!\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\rH\u0082 R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/datadog/android/ndk/internal/NdkCrashReportsFeature;", "Lcom/datadog/android/api/feature/Feature;", "Lcom/datadog/android/privacy/TrackingConsentProviderCallback;", "sdkCore", "Lcom/datadog/android/api/feature/FeatureSdkCore;", "(Lcom/datadog/android/api/feature/FeatureSdkCore;)V", "name", "", "getName", "()Ljava/lang/String;", "nativeLibraryLoaded", "", "consentToInt", "", "newConsent", "Lcom/datadog/android/privacy/TrackingConsent;", "consentToInt$dd_sdk_android_ndk_release", "loadNativeLibrary", "", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "onConsentUpdated", "previousConsent", "onInitialize", "appContext", "Landroid/content/Context;", "onStop", "registerSignalHandler", "storagePath", BatchMetricsDispatcher.TRACKING_CONSENT_KEY, "appStartTimeMs", "", "unregisterSignalHandler", "updateTrackingConsent", "Companion", "dd-sdk-android-ndk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NdkCrashReportsFeature implements Feature, TrackingConsentProviderCallback {
    private static final String ERROR_LOADING_NATIVE_MESSAGE = "We could not load the native library for NDK crash reporting.";
    public static final String NDK_CRASH_REPORTS_FOLDER = "ndk_crash_reports_v2";
    public static final String NO_SDK_ROOT_DIR_MESSAGE = "Cannot get a directory for SDK data storage. Please make sure that SDK is initialized.";
    public static final int TRACKING_CONSENT_GRANTED = 1;
    public static final int TRACKING_CONSENT_NOT_GRANTED = 2;
    public static final int TRACKING_CONSENT_PENDING = 0;
    private final String name;
    private boolean nativeLibraryLoaded;
    private final FeatureSdkCore sdkCore;

    /* JADX INFO: compiled from: NdkCrashReportsFeature.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TrackingConsent.values().length];
            try {
                iArr[TrackingConsent.PENDING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TrackingConsent.GRANTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final native void registerSignalHandler(String storagePath, int consent, long appStartTimeMs);

    private final native void unregisterSignalHandler();

    private final native void updateTrackingConsent(int consent);

    public NdkCrashReportsFeature(FeatureSdkCore sdkCore) {
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        this.sdkCore = sdkCore;
        this.name = "ndk-crash-reporting";
    }

    @Override // com.datadog.android.api.feature.Feature
    public String getName() {
        return this.name;
    }

    @Override // com.datadog.android.api.feature.Feature
    public void onInitialize(Context appContext) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        loadNativeLibrary(this.sdkCore.getInternalLogger());
        if (this.nativeLibraryLoaded) {
            FeatureSdkCore featureSdkCore = this.sdkCore;
            Intrinsics.checkNotNull(featureSdkCore, "null cannot be cast to non-null type com.datadog.android.core.InternalSdkCore");
            InternalSdkCore internalSdkCore = (InternalSdkCore) featureSdkCore;
            File rootStorageDir = internalSdkCore.getRootStorageDir();
            if (rootStorageDir == null) {
                InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.WARN, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.ndk.internal.NdkCrashReportsFeature.onInitialize.1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return NdkCrashReportsFeature.NO_SDK_ROOT_DIR_MESSAGE;
                    }
                }, (Throwable) null, false, (Map) null, 56, (Object) null);
                return;
            }
            final File file = new File(rootStorageDir, "ndk_crash_reports_v2");
            try {
                StrictModeExtKt.allowThreadDiskWrites(new Function0<Boolean>() { // from class: com.datadog.android.ndk.internal.NdkCrashReportsFeature.onInitialize.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Boolean invoke() {
                        return Boolean.valueOf(file.mkdirs());
                    }
                });
                long deviceTimestampMillis = this.sdkCore.getTimeProvider().getDeviceTimestampMillis();
                long nanos = (TimeUnit.MILLISECONDS.toNanos(deviceTimestampMillis) - this.sdkCore.getTimeProvider().getDeviceElapsedTimeNanos()) + ((InternalSdkCore) this.sdkCore).getAppStartTimeNs();
                String absolutePath = file.getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(absolutePath, "ndkCrashesDirs.absolutePath");
                int iConsentToInt$dd_sdk_android_ndk_release = consentToInt$dd_sdk_android_ndk_release(internalSdkCore.getTrackingConsent());
                TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                registerSignalHandler(absolutePath, iConsentToInt$dd_sdk_android_ndk_release, nanos / 1000000);
            } catch (SecurityException e) {
                InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.ERROR, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.ndk.internal.NdkCrashReportsFeature.onInitialize.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Unable to create NDK Crash Report folder " + file;
                    }
                }, (Throwable) e, false, (Map) null, 48, (Object) null);
            }
        }
    }

    @Override // com.datadog.android.api.feature.Feature
    public void onStop() {
        if (this.nativeLibraryLoaded) {
            unregisterSignalHandler();
        }
    }

    @Override // com.datadog.android.privacy.TrackingConsentProviderCallback
    public void onConsentUpdated(TrackingConsent previousConsent, TrackingConsent newConsent) {
        Intrinsics.checkNotNullParameter(previousConsent, "previousConsent");
        Intrinsics.checkNotNullParameter(newConsent, "newConsent");
        if (this.nativeLibraryLoaded) {
            updateTrackingConsent(consentToInt$dd_sdk_android_ndk_release(newConsent));
        }
    }

    public final int consentToInt$dd_sdk_android_ndk_release(TrackingConsent newConsent) {
        Intrinsics.checkNotNullParameter(newConsent, "newConsent");
        int i = WhenMappings.$EnumSwitchMapping$0[newConsent.ordinal()];
        if (i != 1) {
            return i != 2 ? 2 : 1;
        }
        return 0;
    }

    private final void loadNativeLibrary(InternalLogger internalLogger) {
        Throwable th;
        try {
            StrictModeExtKt.allowThreadDiskReads(new Function0<Unit>() { // from class: com.datadog.android.ndk.internal.NdkCrashReportsFeature.loadNativeLibrary.1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    System.loadLibrary("datadog-ndk");
                }
            });
            this.nativeLibraryLoaded = true;
            th = null;
        } catch (NullPointerException | SecurityException | UnsatisfiedLinkError e) {
            th = e;
        }
        Throwable th2 = th;
        if (th2 != null) {
            InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.ndk.internal.NdkCrashReportsFeature$loadNativeLibrary$2$1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "We could not load the native library for NDK crash reporting.";
                }
            }, th2, false, (Map) null, 48, (Object) null);
        }
    }
}
