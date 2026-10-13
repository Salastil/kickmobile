package com.datadog.android.api.feature;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.SdkCore;
import com.datadog.android.internal.time.TimeProvider;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import expo.modules.notifications.service.NotificationsService;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.OkHttpClient;

/* JADX INFO: compiled from: FeatureSdkCore.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J#\u0010\n\u001a\u00020\u000b2\u0019\b\u0002\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0002\b\u0010H&J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H&J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u0014H&J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u0014H&J(\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001b2\u0006\u0010\u0019\u001a\u00020\u00142\b\b\u0002\u0010\u001d\u001a\u00020\u001eH&J\u0010\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020!H&J\u0010\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020$H&J\u0010\u0010%\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u0014H&J\u0012\u0010&\u001a\u00020\u000f2\b\u0010'\u001a\u0004\u0018\u00010(H&J\u0010\u0010)\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020$H&J\u0018\u0010*\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010+\u001a\u00020,H&JK\u0010-\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u00142\b\b\u0002\u0010\u001d\u001a\u00020\u001e2/\u0010.\u001a+\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u001c0/¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020\u000f0\rH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u00063"}, d2 = {"Lcom/datadog/android/api/feature/FeatureSdkCore;", "Lcom/datadog/android/api/SdkCore;", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "getInternalLogger", "()Lcom/datadog/android/api/InternalLogger;", "timeProvider", "Lcom/datadog/android/internal/time/TimeProvider;", "getTimeProvider", "()Lcom/datadog/android/internal/time/TimeProvider;", "createOkHttpCallFactory", "Lokhttp3/Call$Factory;", "block", "Lkotlin/Function1;", "Lokhttp3/OkHttpClient$Builder;", "", "Lkotlin/ExtensionFunctionType;", "createScheduledExecutorService", "Ljava/util/concurrent/ScheduledExecutorService;", "executorContext", "", "createSingleThreadExecutorService", "Ljava/util/concurrent/ExecutorService;", "getFeature", "Lcom/datadog/android/api/feature/FeatureScope;", "featureName", "getFeatureContext", "", "", "useContextThread", "", "registerFeature", "feature", "Lcom/datadog/android/api/feature/Feature;", "removeContextUpdateReceiver", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/datadog/android/api/feature/FeatureContextUpdateReceiver;", "removeEventReceiver", "setAnonymousId", "anonymousId", "Ljava/util/UUID;", "setContextUpdateReceiver", "setEventReceiver", NotificationsService.RECEIVER_KEY, "Lcom/datadog/android/api/feature/FeatureEventReceiver;", "updateFeatureContext", "updateCallback", "", "Lkotlin/ParameterName;", "name", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface FeatureSdkCore extends SdkCore {
    Call.Factory createOkHttpCallFactory(Function1<? super OkHttpClient.Builder, Unit> block);

    ScheduledExecutorService createScheduledExecutorService(String executorContext);

    ExecutorService createSingleThreadExecutorService(String executorContext);

    FeatureScope getFeature(String featureName);

    Map<String, Object> getFeatureContext(String featureName, boolean useContextThread);

    InternalLogger getInternalLogger();

    TimeProvider getTimeProvider();

    void registerFeature(Feature feature);

    void removeContextUpdateReceiver(FeatureContextUpdateReceiver listener);

    void removeEventReceiver(String featureName);

    void setAnonymousId(UUID anonymousId);

    void setContextUpdateReceiver(FeatureContextUpdateReceiver listener);

    void setEventReceiver(String featureName, FeatureEventReceiver receiver);

    void updateFeatureContext(String featureName, boolean useContextThread, Function1<? super Map<String, Object>, Unit> updateCallback);

    /* JADX INFO: compiled from: FeatureSdkCore.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void updateFeatureContext$default(FeatureSdkCore featureSdkCore, String str, boolean z, Function1 function1, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateFeatureContext");
            }
            if ((i & 2) != 0) {
                z = true;
            }
            featureSdkCore.updateFeatureContext(str, z, function1);
        }

        public static /* synthetic */ Map getFeatureContext$default(FeatureSdkCore featureSdkCore, String str, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getFeatureContext");
            }
            if ((i & 2) != 0) {
                z = true;
            }
            return featureSdkCore.getFeatureContext(str, z);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Call.Factory createOkHttpCallFactory$default(FeatureSdkCore featureSdkCore, Function1 function1, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createOkHttpCallFactory");
            }
            if ((i & 1) != 0) {
                function1 = new Function1<OkHttpClient.Builder, Unit>() { // from class: com.datadog.android.api.feature.FeatureSdkCore.createOkHttpCallFactory.1
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(OkHttpClient.Builder builder) {
                        Intrinsics.checkNotNullParameter(builder, "$this$null");
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(OkHttpClient.Builder builder) {
                        invoke2(builder);
                        return Unit.INSTANCE;
                    }
                };
            }
            return featureSdkCore.createOkHttpCallFactory(function1);
        }
    }
}
