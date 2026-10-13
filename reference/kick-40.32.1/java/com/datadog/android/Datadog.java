package com.datadog.android;

import android.content.Context;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.SdkCore;
import com.datadog.android.api.feature.FeatureScope;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.core.configuration.Configuration;
import com.datadog.android.core.internal.DatadogCore;
import com.datadog.android.core.internal.HashGenerator;
import com.datadog.android.core.internal.NoOpInternalSdkCore;
import com.datadog.android.core.internal.SdkCoreRegistry;
import com.datadog.android.core.internal.Sha256HashGenerator;
import com.datadog.android.core.internal.metrics.BatchMetricsDispatcher;
import com.datadog.android.core.internal.utils.RuntimeUtilsKt;
import com.datadog.android.internal.utils.ThrowableExtKt;
import com.datadog.android.privacy.TrackingConsent;
import com.datadog.android.rum.internal.RumFeature;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: Datadog.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u001b\u001a\u00020\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0004H\u0007J(\u0010\u001e\u001a\u00020\u001f2\u0014\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010!2\b\b\u0002\u0010\"\u001a\u00020#H\u0007J(\u0010$\u001a\u00020\u001f2\u0014\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010!2\b\b\u0002\u0010\"\u001a\u00020#H\u0007J\u0012\u0010%\u001a\u00020\u001f2\b\b\u0002\u0010\"\u001a\u00020#H\u0007J\u0012\u0010&\u001a\u00020\u001f2\b\b\u0002\u0010\"\u001a\u00020#H\u0007J\u0012\u0010'\u001a\u00020\u001f2\b\b\u0002\u0010\"\u001a\u00020#H\u0007J\r\u0010(\u001a\u00020\u001fH\u0001¢\u0006\u0002\b)J\u0014\u0010*\u001a\u00020#2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0004H\u0007J\b\u0010+\u001a\u00020\u0012H\u0007J\"\u0010,\u001a\u0004\u0018\u00010#2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0007J,\u0010,\u001a\u0004\u0018\u00010#2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00042\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0007J\u0014\u00103\u001a\u0002042\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0004H\u0007J>\u00105\u001a\u00020\u001f2\u0006\u00106\u001a\u00020\u00042\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u00042\u0016\b\u0002\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010!2\b\b\u0002\u0010\"\u001a\u00020#H\u0007J\u001a\u00108\u001a\u00020\u001f2\u0006\u00109\u001a\u0002022\b\b\u0002\u0010\"\u001a\u00020#H\u0007JJ\u0010:\u001a\u00020\u001f2\u0006\u00106\u001a\u00020\u00042\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u00042\u0016\b\u0002\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010!2\b\b\u0002\u0010\"\u001a\u00020#H\u0007J\u0010\u0010<\u001a\u00020\u001f2\u0006\u0010=\u001a\u00020\u0012H\u0007J\u0014\u0010>\u001a\u00020\u001f2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u0018X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006?"}, d2 = {"Lcom/datadog/android/Datadog;", "", "()V", "CANNOT_CREATE_SDK_INSTANCE_ID_ERROR", "", "DD_APP_VERSION_TAG", "DD_NATIVE_SOURCE_TYPE", "DD_SDK_VERSION_TAG", "DD_SOURCE_TAG", "MESSAGE_ALREADY_INITIALIZED", "MESSAGE_SDK_NOT_INITIALIZED", "hashGenerator", "Lcom/datadog/android/core/internal/HashGenerator;", "getHashGenerator$dd_sdk_android_core_release", "()Lcom/datadog/android/core/internal/HashGenerator;", "setHashGenerator$dd_sdk_android_core_release", "(Lcom/datadog/android/core/internal/HashGenerator;)V", "libraryVerbosity", "", "getLibraryVerbosity$dd_sdk_android_core_release", "()I", "setLibraryVerbosity$dd_sdk_android_core_release", "(I)V", "registry", "Lcom/datadog/android/core/internal/SdkCoreRegistry;", "getRegistry$dd_sdk_android_core_release", "()Lcom/datadog/android/core/internal/SdkCoreRegistry;", "_internalProxy", "Lcom/datadog/android/_InternalProxy;", "instanceName", "addAccountExtraInfo", "", "extraInfo", "", "sdkCore", "Lcom/datadog/android/api/SdkCore;", "addUserProperties", "clearAccountInfo", "clearAllData", "clearUserInfo", "flushAndShutdownExecutors", "flushAndShutdownExecutors$dd_sdk_android_core_release", "getInstance", "getVerbosity", "initialize", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "configuration", "Lcom/datadog/android/core/configuration/Configuration;", "trackingConsent", "Lcom/datadog/android/privacy/TrackingConsent;", "isInitialized", "", "setAccountInfo", "id", "name", "setTrackingConsent", BatchMetricsDispatcher.TRACKING_CONSENT_KEY, "setUserInfo", "email", "setVerbosity", FirebaseAnalytics.Param.LEVEL, "stopInstance", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Datadog {
    public static final String CANNOT_CREATE_SDK_INSTANCE_ID_ERROR = "Cannot create SDK instance ID, stopping SDK initialization.";
    public static final String DD_APP_VERSION_TAG = "_dd.version";
    public static final String DD_NATIVE_SOURCE_TYPE = "_dd.native_source_type";
    public static final String DD_SDK_VERSION_TAG = "_dd.sdk_version";
    public static final String DD_SOURCE_TAG = "_dd.source";
    public static final String MESSAGE_ALREADY_INITIALIZED = "The Datadog library has already been initialized.";
    public static final String MESSAGE_SDK_NOT_INITIALIZED = "SDK instance with name %s is not found, returning no-op implementation. Please make sure to call Datadog.initialize([instanceName]) before getting the instance. SDK instance was requested from:\n%s";
    public static final Datadog INSTANCE = new Datadog();
    private static final SdkCoreRegistry registry = new SdkCoreRegistry(RuntimeUtilsKt.getUnboundInternalLogger());
    private static HashGenerator hashGenerator = new Sha256HashGenerator();
    private static int libraryVerbosity = Integer.MAX_VALUE;

    @JvmStatic
    public static final void addAccountExtraInfo(Map<String, ? extends Object> extraInfo) {
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        addAccountExtraInfo$default(extraInfo, null, 2, null);
    }

    @JvmStatic
    public static final void addUserProperties(Map<String, ? extends Object> extraInfo) {
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        addUserProperties$default(extraInfo, null, 2, null);
    }

    @JvmStatic
    public static final void clearAccountInfo() {
        clearAccountInfo$default(null, 1, null);
    }

    @JvmStatic
    public static final void clearAllData() {
        clearAllData$default(null, 1, null);
    }

    @JvmStatic
    public static final void clearUserInfo() {
        clearUserInfo$default(null, 1, null);
    }

    @JvmStatic
    public static final SdkCore getInstance() {
        return getInstance$default(null, 1, null);
    }

    @JvmStatic
    public static final boolean isInitialized() {
        return isInitialized$default(null, 1, null);
    }

    @JvmStatic
    public static final void setAccountInfo(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        setAccountInfo$default(id, null, null, null, 14, null);
    }

    @JvmStatic
    public static final void setAccountInfo(String id, String str) {
        Intrinsics.checkNotNullParameter(id, "id");
        setAccountInfo$default(id, str, null, null, 12, null);
    }

    @JvmStatic
    public static final void setAccountInfo(String id, String str, Map<String, ? extends Object> extraInfo) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        setAccountInfo$default(id, str, extraInfo, null, 8, null);
    }

    @JvmStatic
    public static final void setTrackingConsent(TrackingConsent consent) {
        Intrinsics.checkNotNullParameter(consent, "consent");
        setTrackingConsent$default(consent, null, 2, null);
    }

    @JvmStatic
    public static final void setUserInfo(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        setUserInfo$default(id, null, null, null, null, 30, null);
    }

    @JvmStatic
    public static final void setUserInfo(String id, String str) {
        Intrinsics.checkNotNullParameter(id, "id");
        setUserInfo$default(id, str, null, null, null, 28, null);
    }

    @JvmStatic
    public static final void setUserInfo(String id, String str, String str2) {
        Intrinsics.checkNotNullParameter(id, "id");
        setUserInfo$default(id, str, str2, null, null, 24, null);
    }

    @JvmStatic
    public static final void setUserInfo(String id, String str, String str2, Map<String, ? extends Object> extraInfo) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        setUserInfo$default(id, str, str2, extraInfo, null, 16, null);
    }

    @JvmStatic
    public static final void stopInstance() {
        stopInstance$default(null, 1, null);
    }

    private Datadog() {
    }

    public final SdkCoreRegistry getRegistry$dd_sdk_android_core_release() {
        return registry;
    }

    public final HashGenerator getHashGenerator$dd_sdk_android_core_release() {
        return hashGenerator;
    }

    public final void setHashGenerator$dd_sdk_android_core_release(HashGenerator hashGenerator2) {
        Intrinsics.checkNotNullParameter(hashGenerator2, "<set-?>");
        hashGenerator = hashGenerator2;
    }

    public final int getLibraryVerbosity$dd_sdk_android_core_release() {
        return libraryVerbosity;
    }

    public final void setLibraryVerbosity$dd_sdk_android_core_release(int i) {
        libraryVerbosity = i;
    }

    @JvmStatic
    public static final SdkCore initialize(String instanceName, Context context, Configuration configuration, TrackingConsent trackingConsent) {
        String str = instanceName;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(trackingConsent, "trackingConsent");
        SdkCoreRegistry sdkCoreRegistry = registry;
        synchronized (sdkCoreRegistry) {
            SdkCore sdkCoreRegistry2 = sdkCoreRegistry.getInstance(str);
            if (sdkCoreRegistry2 != null) {
                InternalLogger.DefaultImpls.log$default(RuntimeUtilsKt.getUnboundInternalLogger(), InternalLogger.Level.WARN, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.Datadog$initialize$1$1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return Datadog.MESSAGE_ALREADY_INITIALIZED;
                    }
                }, (Throwable) null, false, (Map) null, 56, (Object) null);
                return sdkCoreRegistry2;
            }
            String strGenerate = hashGenerator.generate(str + DomExceptionUtils.SEPARATOR + configuration.getCoreConfig$dd_sdk_android_core_release().getSite().getSiteName());
            if (strGenerate == null) {
                InternalLogger.DefaultImpls.log$default(RuntimeUtilsKt.getUnboundInternalLogger(), InternalLogger.Level.ERROR, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.Datadog$initialize$1$2
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return Datadog.CANNOT_CREATE_SDK_INSTANCE_ID_ERROR;
                    }
                }, (Throwable) null, false, (Map) null, 56, (Object) null);
                return null;
            }
            if (str == null) {
                str = SdkCoreRegistry.DEFAULT_INSTANCE_NAME;
            }
            String str2 = str;
            DatadogCore datadogCore = new DatadogCore(context, strGenerate, str2, null, null, null, 56, null);
            datadogCore.initialize$dd_sdk_android_core_release(configuration);
            datadogCore.getCoreFeature$dd_sdk_android_core_release().getTrackingConsentProvider().setConsent(trackingConsent);
            sdkCoreRegistry.register(str2, datadogCore);
            return datadogCore;
        }
    }

    @JvmStatic
    public static final SdkCore initialize(Context context, Configuration configuration, TrackingConsent trackingConsent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(trackingConsent, "trackingConsent");
        return initialize(null, context, configuration, trackingConsent);
    }

    public static /* synthetic */ SdkCore getInstance$default(String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return getInstance(str);
    }

    @JvmStatic
    public static final SdkCore getInstance(final String instanceName) {
        NoOpInternalSdkCore sdkCoreRegistry;
        SdkCoreRegistry sdkCoreRegistry2 = registry;
        synchronized (sdkCoreRegistry2) {
            if (instanceName == null) {
                instanceName = SdkCoreRegistry.DEFAULT_INSTANCE_NAME;
            }
            try {
                sdkCoreRegistry = sdkCoreRegistry2.getInstance(instanceName);
                if (sdkCoreRegistry == null) {
                    final Throwable thFillInStackTrace = new Throwable().fillInStackTrace();
                    InternalLogger.DefaultImpls.log$default(RuntimeUtilsKt.getUnboundInternalLogger(), InternalLogger.Level.WARN, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.Datadog$getInstance$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            Locale locale = Locale.US;
                            String str = instanceName;
                            Throwable stackCapture = thFillInStackTrace;
                            Intrinsics.checkNotNullExpressionValue(stackCapture, "stackCapture");
                            String str2 = String.format(locale, Datadog.MESSAGE_SDK_NOT_INITIALIZED, Arrays.copyOf(new Object[]{str, CollectionsKt.joinToString$default(CollectionsKt.drop(StringsKt.lines(ThrowableExtKt.loggableStackTrace(stackCapture)), 1), "\n", null, null, 0, null, null, 62, null)}, 2));
                            Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                            return str2;
                        }
                    }, (Throwable) null, false, (Map) null, 56, (Object) null);
                    sdkCoreRegistry = NoOpInternalSdkCore.INSTANCE;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sdkCoreRegistry;
    }

    public static /* synthetic */ boolean isInitialized$default(String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return isInitialized(str);
    }

    @JvmStatic
    public static final boolean isInitialized(String instanceName) {
        boolean z;
        SdkCoreRegistry sdkCoreRegistry = registry;
        synchronized (sdkCoreRegistry) {
            z = sdkCoreRegistry.getInstance(instanceName) != null;
        }
        return z;
    }

    public static /* synthetic */ void stopInstance$default(String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        stopInstance(str);
    }

    @JvmStatic
    public static final void stopInstance(String instanceName) {
        SdkCoreRegistry sdkCoreRegistry = registry;
        synchronized (sdkCoreRegistry) {
            SdkCore sdkCoreUnregister = sdkCoreRegistry.unregister(instanceName);
            DatadogCore datadogCore = sdkCoreUnregister instanceof DatadogCore ? (DatadogCore) sdkCoreUnregister : null;
            if (datadogCore != null) {
                datadogCore.stop$dd_sdk_android_core_release();
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    @JvmStatic
    public static final void setVerbosity(int level) {
        libraryVerbosity = level;
    }

    @JvmStatic
    public static final int getVerbosity() {
        return libraryVerbosity;
    }

    public static /* synthetic */ void setTrackingConsent$default(TrackingConsent trackingConsent, SdkCore sdkCore, int i, Object obj) {
        if ((i & 2) != 0) {
            sdkCore = getInstance$default(null, 1, null);
        }
        setTrackingConsent(trackingConsent, sdkCore);
    }

    @JvmStatic
    public static final void setTrackingConsent(TrackingConsent consent, SdkCore sdkCore) {
        Intrinsics.checkNotNullParameter(consent, "consent");
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        sdkCore.setTrackingConsent(consent);
    }

    public static /* synthetic */ void setUserInfo$default(String str, String str2, String str3, Map map, SdkCore sdkCore, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            str3 = null;
        }
        if ((i & 8) != 0) {
            map = MapsKt.emptyMap();
        }
        if ((i & 16) != 0) {
            sdkCore = getInstance$default(null, 1, null);
        }
        setUserInfo(str, str2, str3, map, sdkCore);
    }

    @JvmStatic
    public static final void setUserInfo(String id, String name, String email, Map<String, ? extends Object> extraInfo, SdkCore sdkCore) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        sdkCore.setUserInfo(id, name, email, extraInfo);
    }

    public static /* synthetic */ void addUserProperties$default(Map map, SdkCore sdkCore, int i, Object obj) {
        if ((i & 2) != 0) {
            sdkCore = getInstance$default(null, 1, null);
        }
        addUserProperties(map, sdkCore);
    }

    @JvmStatic
    public static final void addUserProperties(Map<String, ? extends Object> extraInfo, SdkCore sdkCore) {
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        sdkCore.addUserProperties(extraInfo);
    }

    public static /* synthetic */ void clearUserInfo$default(SdkCore sdkCore, int i, Object obj) {
        if ((i & 1) != 0) {
            sdkCore = getInstance$default(null, 1, null);
        }
        clearUserInfo(sdkCore);
    }

    @JvmStatic
    public static final void clearUserInfo(SdkCore sdkCore) {
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        sdkCore.clearUserInfo();
    }

    public static /* synthetic */ void clearAllData$default(SdkCore sdkCore, int i, Object obj) {
        if ((i & 1) != 0) {
            sdkCore = getInstance$default(null, 1, null);
        }
        clearAllData(sdkCore);
    }

    @JvmStatic
    public static final void clearAllData(SdkCore sdkCore) {
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        sdkCore.clearAllData();
    }

    public static /* synthetic */ void setAccountInfo$default(String str, String str2, Map map, SdkCore sdkCore, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            map = MapsKt.emptyMap();
        }
        if ((i & 8) != 0) {
            sdkCore = getInstance$default(null, 1, null);
        }
        setAccountInfo(str, str2, map, sdkCore);
    }

    @JvmStatic
    public static final void setAccountInfo(String id, String name, Map<String, ? extends Object> extraInfo, SdkCore sdkCore) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        sdkCore.setAccountInfo(id, name, extraInfo);
    }

    public static /* synthetic */ void addAccountExtraInfo$default(Map map, SdkCore sdkCore, int i, Object obj) {
        if ((i & 2) != 0) {
            sdkCore = getInstance$default(null, 1, null);
        }
        addAccountExtraInfo(map, sdkCore);
    }

    @JvmStatic
    public static final void addAccountExtraInfo(Map<String, ? extends Object> extraInfo, SdkCore sdkCore) {
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        sdkCore.addAccountExtraInfo(extraInfo);
    }

    public static /* synthetic */ void clearAccountInfo$default(SdkCore sdkCore, int i, Object obj) {
        if ((i & 1) != 0) {
            sdkCore = getInstance$default(null, 1, null);
        }
        clearAccountInfo(sdkCore);
    }

    @JvmStatic
    public static final void clearAccountInfo(SdkCore sdkCore) {
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        sdkCore.clearAccountInfo();
    }

    public final void flushAndShutdownExecutors$dd_sdk_android_core_release() {
        SdkCoreRegistry sdkCoreRegistry = registry;
        synchronized (sdkCoreRegistry) {
            SdkCore instance$default = SdkCoreRegistry.getInstance$default(sdkCoreRegistry, null, 1, null);
            FeatureSdkCore featureSdkCore = instance$default instanceof FeatureSdkCore ? (FeatureSdkCore) instance$default : null;
            if (featureSdkCore != null) {
                FeatureScope feature = featureSdkCore.getFeature("rum");
                if (feature != null) {
                    feature.sendEvent(MapsKt.mapOf(TuplesKt.to("type", RumFeature.FLUSH_AND_STOP_MONITOR_MESSAGE_TYPE)));
                }
                DatadogCore datadogCore = featureSdkCore instanceof DatadogCore ? (DatadogCore) featureSdkCore : null;
                if (datadogCore != null) {
                    datadogCore.flushStoredData$dd_sdk_android_core_release();
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public static /* synthetic */ _InternalProxy _internalProxy$default(Datadog datadog, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return datadog._internalProxy(str);
    }

    public final _InternalProxy _internalProxy(String instanceName) {
        return new _InternalProxy(getInstance(instanceName));
    }
}
