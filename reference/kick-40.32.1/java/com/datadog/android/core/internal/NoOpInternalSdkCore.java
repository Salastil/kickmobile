package com.datadog.android.core.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.api.context.NetworkInfo;
import com.datadog.android.api.context.TimeInfo;
import com.datadog.android.api.feature.Feature;
import com.datadog.android.api.feature.FeatureContextUpdateReceiver;
import com.datadog.android.api.feature.FeatureEventReceiver;
import com.datadog.android.api.feature.FeatureScope;
import com.datadog.android.core.InternalSdkCore;
import com.datadog.android.core.internal.logger.SdkInternalLogger;
import com.datadog.android.core.internal.metrics.BatchMetricsDispatcher;
import com.datadog.android.core.internal.net.DefaultFirstPartyHostHeaderTypeResolver;
import com.datadog.android.core.internal.net.FirstPartyHostHeaderTypeResolver;
import com.datadog.android.internal.time.DefaultTimeProvider;
import com.datadog.android.internal.time.TimeProvider;
import com.datadog.android.privacy.TrackingConsent;
import com.datadog.trace.bootstrap.instrumentation.api.InstrumentationTags;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.gson.JsonObject;
import expo.modules.notifications.service.NotificationsService;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.ws.WebSocketProtocol;
import okio.Timeout;

/* JADX INFO: compiled from: NoOpInternalSdkCore.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001:\u0005stuvwB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u00105\u001a\u0002062\u0014\u00107\u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0006\u0012\u0004\u0018\u00010908H\u0016J\u001e\u0010:\u001a\u0002062\u0014\u00107\u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0006\u0012\u0004\u0018\u00010908H\u0016J\b\u0010;\u001a\u000206H\u0016J\b\u0010<\u001a\u000206H\u0016J\b\u0010=\u001a\u000206H\u0016J!\u0010>\u001a\u00020?2\u0017\u0010@\u001a\u0013\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u0002060A¢\u0006\u0002\bCH\u0016J\u0010\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020\u001cH\u0016J\u0010\u0010G\u001a\u00020H2\u0006\u0010F\u001a\u00020\u001cH\u0016J\b\u0010I\u001a\u000206H\u0016J\u000e\u0010J\u001a\b\u0012\u0004\u0012\u00020L0KH\u0016J\u0018\u0010M\u001a\u0004\u0018\u00010N2\f\u0010O\u001a\b\u0012\u0004\u0012\u00020\u001c0PH\u0016J\u0012\u0010Q\u001a\u0004\u0018\u00010L2\u0006\u0010R\u001a\u00020\u001cH\u0016J&\u0010S\u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0006\u0012\u0004\u0018\u000109082\u0006\u0010R\u001a\u00020\u001c2\u0006\u0010T\u001a\u00020\u0012H\u0016J\b\u0010U\u001a\u00020HH\u0016J\b\u0010V\u001a\u00020\u0012H\u0016J\u0010\u0010W\u001a\u0002062\u0006\u0010X\u001a\u00020YH\u0016J\u0010\u0010Z\u001a\u0002062\u0006\u0010[\u001a\u00020\\H\u0016J\u0010\u0010]\u001a\u0002062\u0006\u0010R\u001a\u00020\u001cH\u0016J0\u0010^\u001a\u0002062\u0006\u0010_\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0014\u00107\u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0006\u0012\u0004\u0018\u00010908H\u0016J\u0012\u0010`\u001a\u0002062\b\u0010a\u001a\u0004\u0018\u00010bH\u0016J\u0010\u0010c\u001a\u0002062\u0006\u0010[\u001a\u00020\\H\u0016J\u0018\u0010d\u001a\u0002062\u0006\u0010R\u001a\u00020\u001c2\u0006\u0010e\u001a\u00020fH\u0016J\u0010\u0010g\u001a\u0002062\u0006\u0010h\u001a\u000202H\u0016J:\u0010i\u001a\u0002062\u0006\u0010_\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010j\u001a\u0004\u0018\u00010\u001c2\u0014\u00107\u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0006\u0012\u0004\u0018\u00010908H\u0016J:\u0010k\u001a\u0002062\u0006\u0010R\u001a\u00020\u001c2\u0006\u0010T\u001a\u00020\u00122 \u0010l\u001a\u001c\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0006\u0012\u0004\u0018\u0001090m\u0012\u0004\u0012\u0002060AH\u0016J\u0010\u0010n\u001a\u0002062\u0006\u0010o\u001a\u00020\u0004H\u0016J\u0010\u0010p\u001a\u0002062\u0006\u0010q\u001a\u00020rH\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0013R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u001cX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020 8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0016\u0010#\u001a\u0004\u0018\u00010$8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u001eR\u0014\u0010)\u001a\u00020*X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0014\u0010-\u001a\u00020.8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u00100R\u0014\u00101\u001a\u0002028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b3\u00104¨\u0006x"}, d2 = {"Lcom/datadog/android/core/internal/NoOpInternalSdkCore;", "Lcom/datadog/android/core/InternalSdkCore;", "()V", "appStartTimeNs", "", "getAppStartTimeNs", "()J", "appUptimeNs", "getAppUptimeNs", "firstPartyHostResolver", "Lcom/datadog/android/core/internal/net/FirstPartyHostHeaderTypeResolver;", "getFirstPartyHostResolver", "()Lcom/datadog/android/core/internal/net/FirstPartyHostHeaderTypeResolver;", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "getInternalLogger", "()Lcom/datadog/android/api/InternalLogger;", "isDeveloperModeEnabled", "", "()Z", "lastFatalAnrSent", "getLastFatalAnrSent", "()Ljava/lang/Long;", "lastViewEvent", "Lcom/google/gson/JsonObject;", "getLastViewEvent", "()Lcom/google/gson/JsonObject;", "name", "", "getName", "()Ljava/lang/String;", "networkInfo", "Lcom/datadog/android/api/context/NetworkInfo;", "getNetworkInfo", "()Lcom/datadog/android/api/context/NetworkInfo;", "rootStorageDir", "Ljava/io/File;", "getRootStorageDir", "()Ljava/io/File;", "service", "getService", "time", "Lcom/datadog/android/api/context/TimeInfo;", "getTime", "()Lcom/datadog/android/api/context/TimeInfo;", "timeProvider", "Lcom/datadog/android/internal/time/TimeProvider;", "getTimeProvider", "()Lcom/datadog/android/internal/time/TimeProvider;", "trackingConsent", "Lcom/datadog/android/privacy/TrackingConsent;", "getTrackingConsent", "()Lcom/datadog/android/privacy/TrackingConsent;", "addAccountExtraInfo", "", "extraInfo", "", "", "addUserProperties", "clearAccountInfo", "clearAllData", "clearUserInfo", "createOkHttpCallFactory", "Lokhttp3/Call$Factory;", "block", "Lkotlin/Function1;", "Lokhttp3/OkHttpClient$Builder;", "Lkotlin/ExtensionFunctionType;", "createScheduledExecutorService", "Ljava/util/concurrent/ScheduledExecutorService;", "executorContext", "createSingleThreadExecutorService", "Ljava/util/concurrent/ExecutorService;", "deleteLastViewEvent", "getAllFeatures", "", "Lcom/datadog/android/api/feature/FeatureScope;", "getDatadogContext", "Lcom/datadog/android/api/context/DatadogContext;", "withFeatureContexts", "", "getFeature", "featureName", "getFeatureContext", "useContextThread", "getPersistenceExecutorService", "isCoreActive", "registerFeature", "feature", "Lcom/datadog/android/api/feature/Feature;", "removeContextUpdateReceiver", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/datadog/android/api/feature/FeatureContextUpdateReceiver;", "removeEventReceiver", "setAccountInfo", "id", "setAnonymousId", "anonymousId", "Ljava/util/UUID;", "setContextUpdateReceiver", "setEventReceiver", NotificationsService.RECEIVER_KEY, "Lcom/datadog/android/api/feature/FeatureEventReceiver;", "setTrackingConsent", BatchMetricsDispatcher.TRACKING_CONSENT_KEY, "setUserInfo", "email", "updateFeatureContext", "updateCallback", "", "writeLastFatalAnrSent", "anrTimestamp", "writeLastViewEvent", "data", "", "NoOpCall", "NoOpCallFactory", "NoOpExecutorService", "NoOpScheduledExecutorService", "NoOpScheduledFuture", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NoOpInternalSdkCore implements InternalSdkCore {
    public static final NoOpInternalSdkCore INSTANCE;
    private static final InternalLogger internalLogger;
    private static final String name;
    private static final TimeInfo time;

    @Override // com.datadog.android.api.SdkCore
    public void addAccountExtraInfo(Map<String, ? extends Object> extraInfo) {
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
    }

    @Override // com.datadog.android.api.SdkCore
    public void addUserProperties(Map<String, ? extends Object> extraInfo) {
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
    }

    @Override // com.datadog.android.api.SdkCore
    public void clearAccountInfo() {
    }

    @Override // com.datadog.android.api.SdkCore
    public void clearAllData() {
    }

    @Override // com.datadog.android.api.SdkCore
    public void clearUserInfo() {
    }

    @Override // com.datadog.android.core.InternalSdkCore
    public void deleteLastViewEvent() {
    }

    @Override // com.datadog.android.core.InternalSdkCore
    public long getAppStartTimeNs() {
        return 0L;
    }

    @Override // com.datadog.android.core.InternalSdkCore
    public long getAppUptimeNs() {
        return 0L;
    }

    @Override // com.datadog.android.core.InternalSdkCore
    public DatadogContext getDatadogContext(Set<String> withFeatureContexts) {
        Intrinsics.checkNotNullParameter(withFeatureContexts, "withFeatureContexts");
        return null;
    }

    @Override // com.datadog.android.core.InternalSdkCore
    public Long getLastFatalAnrSent() {
        return null;
    }

    @Override // com.datadog.android.core.InternalSdkCore
    public JsonObject getLastViewEvent() {
        return null;
    }

    @Override // com.datadog.android.core.InternalSdkCore
    public File getRootStorageDir() {
        return null;
    }

    @Override // com.datadog.android.api.SdkCore
    public boolean isCoreActive() {
        return false;
    }

    @Override // com.datadog.android.core.InternalSdkCore
    /* JADX INFO: renamed from: isDeveloperModeEnabled */
    public boolean getIsDeveloperModeEnabled() {
        return false;
    }

    @Override // com.datadog.android.api.feature.FeatureSdkCore
    public void removeContextUpdateReceiver(FeatureContextUpdateReceiver listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    @Override // com.datadog.android.api.feature.FeatureSdkCore
    public void removeEventReceiver(String featureName) {
        Intrinsics.checkNotNullParameter(featureName, "featureName");
    }

    @Override // com.datadog.android.api.SdkCore
    public void setAccountInfo(String id, String name2, Map<String, ? extends Object> extraInfo) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
    }

    @Override // com.datadog.android.api.feature.FeatureSdkCore
    public void setAnonymousId(UUID anonymousId) {
    }

    @Override // com.datadog.android.api.feature.FeatureSdkCore
    public void setContextUpdateReceiver(FeatureContextUpdateReceiver listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    @Override // com.datadog.android.api.feature.FeatureSdkCore
    public void setEventReceiver(String featureName, FeatureEventReceiver receiver) {
        Intrinsics.checkNotNullParameter(featureName, "featureName");
        Intrinsics.checkNotNullParameter(receiver, "receiver");
    }

    @Override // com.datadog.android.api.SdkCore
    public void setTrackingConsent(TrackingConsent consent) {
        Intrinsics.checkNotNullParameter(consent, "consent");
    }

    @Override // com.datadog.android.api.SdkCore
    public void setUserInfo(String id, String name2, String email, Map<String, ? extends Object> extraInfo) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
    }

    @Override // com.datadog.android.api.feature.FeatureSdkCore
    public void updateFeatureContext(String featureName, boolean useContextThread, Function1<? super Map<String, Object>, Unit> updateCallback) {
        Intrinsics.checkNotNullParameter(featureName, "featureName");
        Intrinsics.checkNotNullParameter(updateCallback, "updateCallback");
    }

    @Override // com.datadog.android.core.InternalSdkCore
    public void writeLastFatalAnrSent(long anrTimestamp) {
    }

    @Override // com.datadog.android.core.InternalSdkCore
    public void writeLastViewEvent(byte[] data) {
        Intrinsics.checkNotNullParameter(data, "data");
    }

    private NoOpInternalSdkCore() {
    }

    static {
        NoOpInternalSdkCore noOpInternalSdkCore = new NoOpInternalSdkCore();
        INSTANCE = noOpInternalSdkCore;
        name = "no-op";
        long deviceTimestampMillis = noOpInternalSdkCore.getTimeProvider().getDeviceTimestampMillis();
        time = TimeInfo.INSTANCE.getEMPTY$dd_sdk_android_core_release().copy(TimeUnit.MILLISECONDS.toNanos(deviceTimestampMillis), TimeUnit.MILLISECONDS.toNanos(deviceTimestampMillis), 0L, 0L);
        internalLogger = new SdkInternalLogger(noOpInternalSdkCore, null, null, 6, null);
    }

    @Override // com.datadog.android.api.SdkCore
    public String getName() {
        return name;
    }

    @Override // com.datadog.android.api.SdkCore
    public TimeInfo getTime() {
        return time;
    }

    @Override // com.datadog.android.api.SdkCore
    public String getService() {
        return "";
    }

    @Override // com.datadog.android.api.feature.FeatureSdkCore
    public InternalLogger getInternalLogger() {
        return internalLogger;
    }

    @Override // com.datadog.android.api.feature.FeatureSdkCore
    public TimeProvider getTimeProvider() {
        return new DefaultTimeProvider();
    }

    @Override // com.datadog.android.core.InternalSdkCore
    public NetworkInfo getNetworkInfo() {
        return new NetworkInfo(NetworkInfo.Connectivity.NETWORK_OTHER, null, null, null, null, null, null, WebSocketProtocol.PAYLOAD_SHORT, null);
    }

    @Override // com.datadog.android.core.InternalSdkCore
    public TrackingConsent getTrackingConsent() {
        return TrackingConsent.NOT_GRANTED;
    }

    @Override // com.datadog.android.core.InternalSdkCore
    public FirstPartyHostHeaderTypeResolver getFirstPartyHostResolver() {
        return new DefaultFirstPartyHostHeaderTypeResolver(MapsKt.emptyMap());
    }

    @Override // com.datadog.android.api.feature.FeatureSdkCore
    public void registerFeature(final Feature feature) {
        Intrinsics.checkNotNullParameter(feature, "feature");
        InternalLogger.DefaultImpls.log$default(getInternalLogger(), InternalLogger.Level.ERROR, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.NoOpInternalSdkCore.registerFeature.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                String str = String.format(Locale.US, NoOpInternalSdkCoreKt.REGISTER_FEATURE_INVOKED_ON_NO_OP_CORE_ERROR, Arrays.copyOf(new Object[]{feature.getName()}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                return str;
            }
        }, (Throwable) null, true, (Map) null, 40, (Object) null);
    }

    @Override // com.datadog.android.api.feature.FeatureSdkCore
    public FeatureScope getFeature(final String featureName) {
        Intrinsics.checkNotNullParameter(featureName, "featureName");
        InternalLogger.DefaultImpls.log$default(getInternalLogger(), InternalLogger.Level.ERROR, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.NoOpInternalSdkCore.getFeature.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                String str = String.format(Locale.US, NoOpInternalSdkCoreKt.GET_FEATURE_INVOKED_ON_NO_OP_CORE_ERROR, Arrays.copyOf(new Object[]{featureName}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                return str;
            }
        }, (Throwable) null, true, (Map) null, 40, (Object) null);
        return null;
    }

    @Override // com.datadog.android.api.feature.FeatureSdkCore
    public Map<String, Object> getFeatureContext(String featureName, boolean useContextThread) {
        Intrinsics.checkNotNullParameter(featureName, "featureName");
        return MapsKt.emptyMap();
    }

    @Override // com.datadog.android.api.feature.FeatureSdkCore
    public ExecutorService createSingleThreadExecutorService(String executorContext) {
        Intrinsics.checkNotNullParameter(executorContext, "executorContext");
        return new NoOpExecutorService();
    }

    @Override // com.datadog.android.api.feature.FeatureSdkCore
    public ScheduledExecutorService createScheduledExecutorService(String executorContext) {
        Intrinsics.checkNotNullParameter(executorContext, "executorContext");
        return new NoOpScheduledExecutorService();
    }

    @Override // com.datadog.android.api.feature.FeatureSdkCore
    public Call.Factory createOkHttpCallFactory(Function1<? super OkHttpClient.Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        return NoOpCallFactory.INSTANCE;
    }

    @Override // com.datadog.android.core.InternalSdkCore
    public ExecutorService getPersistenceExecutorService() {
        return new NoOpExecutorService();
    }

    @Override // com.datadog.android.core.InternalSdkCore
    public List<FeatureScope> getAllFeatures() {
        return CollectionsKt.emptyList();
    }

    /* JADX INFO: compiled from: NoOpInternalSdkCore.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001f\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J2\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100\u000f0\u000e\"\u0004\b\u0000\u0010\u00102\u0016\u0010\u0011\u001a\u0012\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H\u00100\u0013\u0018\u00010\u0012H\u0016JD\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100\u000f0\u000e\"\u0004\b\u0000\u0010\u00102\u0016\u0010\u0011\u001a\u0012\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H\u00100\u0013\u0018\u00010\u00122\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J-\u0010\u0014\u001a\u0004\u0018\u0001H\u0010\"\u0004\b\u0000\u0010\u00102\u0016\u0010\u0011\u001a\u0012\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H\u00100\u0013\u0018\u00010\u0012H\u0016¢\u0006\u0002\u0010\u0015J?\u0010\u0014\u001a\u0004\u0018\u0001H\u0010\"\u0004\b\u0000\u0010\u00102\u0016\u0010\u0011\u001a\u0012\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H\u00100\u0013\u0018\u00010\u00122\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016J\b\u0010\u0018\u001a\u00020\u0004H\u0016J\b\u0010\u0019\u001a\u00020\nH\u0016J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\f0\u000eH\u0016J\u0018\u0010\u001b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000f2\b\u0010\u001c\u001a\u0004\u0018\u00010\fH\u0016J-\u0010\u001b\u001a\n\u0012\u0004\u0012\u0002H\u0010\u0018\u00010\u000f\"\u0004\b\u0000\u0010\u00102\b\u0010\u001c\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001d\u001a\u0002H\u0010H\u0016¢\u0006\u0002\u0010\u001eJ&\u0010\u001b\u001a\n\u0012\u0004\u0012\u0002H\u0010\u0018\u00010\u000f\"\u0004\b\u0000\u0010\u00102\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u0002H\u0010\u0018\u00010\u0013H\u0016¨\u0006\u001f"}, d2 = {"Lcom/datadog/android/core/internal/NoOpInternalSdkCore$NoOpExecutorService;", "Ljava/util/concurrent/ExecutorService;", "()V", "awaitTermination", "", InstrumentationTags.TIMEOUT, "", "unit", "Ljava/util/concurrent/TimeUnit;", "execute", "", "command", "Ljava/lang/Runnable;", "invokeAll", "", "Ljava/util/concurrent/Future;", ExifInterface.GPS_DIRECTION_TRUE, "tasks", "", "Ljava/util/concurrent/Callable;", "invokeAny", "(Ljava/util/Collection;)Ljava/lang/Object;", "(Ljava/util/Collection;JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;", "isShutdown", "isTerminated", "shutdown", "shutdownNow", "submit", "task", "result", "(Ljava/lang/Runnable;Ljava/lang/Object;)Ljava/util/concurrent/Future;", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class NoOpExecutorService implements ExecutorService, AutoCloseable {
        @Override // java.util.concurrent.ExecutorService
        public boolean awaitTermination(long timeout, TimeUnit unit) {
            return true;
        }

        @Override // java.lang.AutoCloseable
        public /* synthetic */ void close() {
            UByte$$ExternalSyntheticBackport0.m((ExecutorService) this);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable command) {
        }

        @Override // java.util.concurrent.ExecutorService
        public <T> T invokeAny(Collection<? extends Callable<T>> tasks) {
            return null;
        }

        @Override // java.util.concurrent.ExecutorService
        public <T> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) {
            return null;
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isShutdown() {
            return true;
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isTerminated() {
            return true;
        }

        @Override // java.util.concurrent.ExecutorService
        public void shutdown() {
        }

        @Override // java.util.concurrent.ExecutorService
        public Future<?> submit(Runnable task) {
            return null;
        }

        @Override // java.util.concurrent.ExecutorService
        public <T> Future<T> submit(Runnable task, T result) {
            return null;
        }

        @Override // java.util.concurrent.ExecutorService
        public <T> Future<T> submit(Callable<T> task) {
            return null;
        }

        @Override // java.util.concurrent.ExecutorService
        public List<Runnable> shutdownNow() {
            return new ArrayList();
        }

        @Override // java.util.concurrent.ExecutorService
        public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) {
            return new ArrayList();
        }

        @Override // java.util.concurrent.ExecutorService
        public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) {
            return new ArrayList();
        }
    }

    /* JADX INFO: compiled from: NoOpInternalSdkCore.kt */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J2\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100\u000f0\u000e\"\u0004\b\u0000\u0010\u00102\u0016\u0010\u0011\u001a\u0012\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H\u00100\u0013\u0018\u00010\u0012H\u0016JD\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100\u000f0\u000e\"\u0004\b\u0000\u0010\u00102\u0016\u0010\u0011\u001a\u0012\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H\u00100\u0013\u0018\u00010\u00122\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J-\u0010\u0014\u001a\u0004\u0018\u0001H\u0010\"\u0004\b\u0000\u0010\u00102\u0016\u0010\u0011\u001a\u0012\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H\u00100\u0013\u0018\u00010\u0012H\u0016¢\u0006\u0002\u0010\u0015J?\u0010\u0014\u001a\u0004\u0018\u0001H\u0010\"\u0004\b\u0000\u0010\u00102\u0016\u0010\u0011\u001a\u0012\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H\u00100\u0013\u0018\u00010\u00122\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016J\b\u0010\u0018\u001a\u00020\u0004H\u0016J(\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u001a2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001b\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J6\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u001c0\u001a\"\u0004\b\u0000\u0010\u001c2\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u0002H\u001c\u0018\u00010\u00132\u0006\u0010\u001b\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J0\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u001a2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J0\u0010!\u001a\u0006\u0012\u0002\b\u00030\u001a2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\"\u001a\u00020\nH\u0016J\u000e\u0010#\u001a\b\u0012\u0004\u0012\u00020\f0\u000eH\u0016J\u0018\u0010$\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000f2\b\u0010%\u001a\u0004\u0018\u00010\fH\u0016J-\u0010$\u001a\n\u0012\u0004\u0012\u0002H\u0010\u0018\u00010\u000f\"\u0004\b\u0000\u0010\u00102\b\u0010%\u001a\u0004\u0018\u00010\f2\u0006\u0010&\u001a\u0002H\u0010H\u0016¢\u0006\u0002\u0010'J&\u0010$\u001a\n\u0012\u0004\u0012\u0002H\u0010\u0018\u00010\u000f\"\u0004\b\u0000\u0010\u00102\u000e\u0010%\u001a\n\u0012\u0004\u0012\u0002H\u0010\u0018\u00010\u0013H\u0016¨\u0006("}, d2 = {"Lcom/datadog/android/core/internal/NoOpInternalSdkCore$NoOpScheduledExecutorService;", "Ljava/util/concurrent/ScheduledExecutorService;", "()V", "awaitTermination", "", InstrumentationTags.TIMEOUT, "", "unit", "Ljava/util/concurrent/TimeUnit;", "execute", "", "command", "Ljava/lang/Runnable;", "invokeAll", "", "Ljava/util/concurrent/Future;", ExifInterface.GPS_DIRECTION_TRUE, "tasks", "", "Ljava/util/concurrent/Callable;", "invokeAny", "(Ljava/util/Collection;)Ljava/lang/Object;", "(Ljava/util/Collection;JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;", "isShutdown", "isTerminated", "schedule", "Ljava/util/concurrent/ScheduledFuture;", "delay", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "callable", "scheduleAtFixedRate", "initialDelay", TypedValues.Cycle.S_WAVE_PERIOD, "scheduleWithFixedDelay", "shutdown", "shutdownNow", "submit", "task", "result", "(Ljava/lang/Runnable;Ljava/lang/Object;)Ljava/util/concurrent/Future;", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class NoOpScheduledExecutorService implements ScheduledExecutorService, AutoCloseable {
        @Override // java.util.concurrent.ExecutorService
        public boolean awaitTermination(long timeout, TimeUnit unit) {
            return true;
        }

        @Override // java.lang.AutoCloseable
        public /* synthetic */ void close() {
            UByte$$ExternalSyntheticBackport0.m((ExecutorService) this);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable command) {
        }

        @Override // java.util.concurrent.ExecutorService
        public <T> T invokeAny(Collection<? extends Callable<T>> tasks) {
            return null;
        }

        @Override // java.util.concurrent.ExecutorService
        public <T> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) {
            return null;
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isShutdown() {
            return true;
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isTerminated() {
            return true;
        }

        @Override // java.util.concurrent.ExecutorService
        public void shutdown() {
        }

        @Override // java.util.concurrent.ExecutorService
        public Future<?> submit(Runnable task) {
            return null;
        }

        @Override // java.util.concurrent.ExecutorService
        public <T> Future<T> submit(Runnable task, T result) {
            return null;
        }

        @Override // java.util.concurrent.ExecutorService
        public <T> Future<T> submit(Callable<T> task) {
            return null;
        }

        @Override // java.util.concurrent.ExecutorService
        public List<Runnable> shutdownNow() {
            return new ArrayList();
        }

        @Override // java.util.concurrent.ExecutorService
        public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) {
            return new ArrayList();
        }

        @Override // java.util.concurrent.ExecutorService
        public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) {
            return new ArrayList();
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public <V> ScheduledFuture<V> schedule(Callable<V> callable, long delay, TimeUnit unit) {
            return new NoOpScheduledFuture();
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ScheduledFuture<?> schedule(Runnable command, long delay, TimeUnit unit) {
            return new NoOpScheduledFuture();
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ScheduledFuture<?> scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit) {
            return new NoOpScheduledFuture();
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ScheduledFuture<?> scheduleWithFixedDelay(Runnable command, long initialDelay, long delay, TimeUnit unit) {
            return new NoOpScheduledFuture();
        }
    }

    /* JADX INFO: compiled from: NoOpInternalSdkCore.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0096\u0002J\r\u0010\u000b\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\fJ \u0010\u000b\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002¢\u0006\u0002\u0010\u0011J\u0012\u0010\u0012\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0005H\u0016J\b\u0010\u0014\u001a\u00020\u0005H\u0016¨\u0006\u0015"}, d2 = {"Lcom/datadog/android/core/internal/NoOpInternalSdkCore$NoOpScheduledFuture;", "O", "Ljava/util/concurrent/ScheduledFuture;", "()V", "cancel", "", "mayInterruptIfRunning", "compareTo", "", "other", "Ljava/util/concurrent/Delayed;", "get", "()Ljava/lang/Object;", InstrumentationTags.TIMEOUT, "", "unit", "Ljava/util/concurrent/TimeUnit;", "(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;", "getDelay", "isCancelled", "isDone", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class NoOpScheduledFuture<O> implements ScheduledFuture<O> {
        @Override // java.util.concurrent.Future
        public boolean cancel(boolean mayInterruptIfRunning) {
            return false;
        }

        @Override // java.lang.Comparable
        public int compareTo(Delayed other) {
            return 0;
        }

        @Override // java.util.concurrent.Delayed
        public long getDelay(TimeUnit unit) {
            return 0L;
        }

        @Override // java.util.concurrent.Future
        public boolean isCancelled() {
            return false;
        }

        @Override // java.util.concurrent.Future
        public boolean isDone() {
            return false;
        }

        @Override // java.util.concurrent.Future
        public O get() throws ExecutionException {
            throw new ExecutionException("Unsupported", new UnsupportedOperationException());
        }

        @Override // java.util.concurrent.Future
        public O get(long timeout, TimeUnit unit) throws ExecutionException {
            throw new ExecutionException("Unsupported", new UnsupportedOperationException());
        }
    }

    /* JADX INFO: compiled from: NoOpInternalSdkCore.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/core/internal/NoOpInternalSdkCore$NoOpCallFactory;", "Lokhttp3/Call$Factory;", "()V", "newCall", "Lokhttp3/Call;", "request", "Lokhttp3/Request;", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class NoOpCallFactory implements Call.Factory {
        public static final NoOpCallFactory INSTANCE = new NoOpCallFactory();

        private NoOpCallFactory() {
        }

        @Override // okhttp3.Call.Factory
        public Call newCall(Request request) {
            Intrinsics.checkNotNullParameter(request, "request");
            return new NoOpCall(request);
        }
    }

    /* JADX INFO: compiled from: NoOpInternalSdkCore.kt */
    /* JADX INFO: loaded from: classes10.dex */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0001H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/datadog/android/core/internal/NoOpInternalSdkCore$NoOpCall;", "Lokhttp3/Call;", "originalRequest", "Lokhttp3/Request;", "(Lokhttp3/Request;)V", "cancel", "", "clone", "enqueue", "responseCallback", "Lokhttp3/Callback;", "execute", "Lokhttp3/Response;", "isCanceled", "", "isExecuted", "request", InstrumentationTags.TIMEOUT, "Lokio/Timeout;", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class NoOpCall implements Call {
        private final Request originalRequest;

        @Override // okhttp3.Call
        public void cancel() {
        }

        @Override // okhttp3.Call
        public void enqueue(Callback responseCallback) {
            Intrinsics.checkNotNullParameter(responseCallback, "responseCallback");
        }

        @Override // okhttp3.Call
        /* JADX INFO: renamed from: isCanceled */
        public boolean getCanceled() {
            return false;
        }

        @Override // okhttp3.Call
        public boolean isExecuted() {
            return false;
        }

        public NoOpCall(Request originalRequest) {
            Intrinsics.checkNotNullParameter(originalRequest, "originalRequest");
            this.originalRequest = originalRequest;
        }

        @Override // okhttp3.Call
        public Call clone() {
            return new NoOpCall(this.originalRequest);
        }

        @Override // okhttp3.Call
        public Response execute() {
            return new Response.Builder().request(this.originalRequest).protocol(Protocol.HTTP_1_1).message("OK").build();
        }

        @Override // okhttp3.Call
        /* JADX INFO: renamed from: request, reason: from getter */
        public Request getOriginalRequest() {
            return this.originalRequest;
        }

        @Override // okhttp3.Call
        public Timeout timeout() {
            return Timeout.NONE;
        }
    }
}
