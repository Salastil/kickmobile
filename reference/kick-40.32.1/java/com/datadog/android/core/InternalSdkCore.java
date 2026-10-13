package com.datadog.android.core;

import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.api.context.NetworkInfo;
import com.datadog.android.api.feature.FeatureScope;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.core.internal.net.FirstPartyHostHeaderTypeResolver;
import com.datadog.android.privacy.TrackingConsent;
import com.google.gson.JsonObject;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.collections.SetsKt;

/* JADX INFO: compiled from: InternalSdkCore.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010+\u001a\u00020,H'J\u000e\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.H'J\u001a\u00100\u001a\u0004\u0018\u0001012\u000e\b\u0002\u00102\u001a\b\u0012\u0004\u0012\u00020403H'J\b\u00105\u001a\u000206H'J\u0010\u00107\u001a\u00020,2\u0006\u00108\u001a\u00020\u0003H'J\u0010\u00109\u001a\u00020,2\u0006\u0010:\u001a\u00020;H'R\u001a\u0010\u0002\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u0012\u0010\u000b\u001a\u00020\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u00108&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u000f\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00038gX§\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0005\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00188gX§\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0005\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001d8&X§\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u0005\u001a\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\"8&X§\u0004¢\u0006\f\u0012\u0004\b#\u0010\u0005\u001a\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020'8&X§\u0004¢\u0006\f\u0012\u0004\b(\u0010\u0005\u001a\u0004\b)\u0010*¨\u0006<"}, d2 = {"Lcom/datadog/android/core/InternalSdkCore;", "Lcom/datadog/android/api/feature/FeatureSdkCore;", "appStartTimeNs", "", "getAppStartTimeNs$annotations", "()V", "getAppStartTimeNs", "()J", "appUptimeNs", "getAppUptimeNs$annotations", "getAppUptimeNs", "firstPartyHostResolver", "Lcom/datadog/android/core/internal/net/FirstPartyHostHeaderTypeResolver;", "getFirstPartyHostResolver", "()Lcom/datadog/android/core/internal/net/FirstPartyHostHeaderTypeResolver;", "isDeveloperModeEnabled", "", "isDeveloperModeEnabled$annotations", "()Z", "lastFatalAnrSent", "getLastFatalAnrSent$annotations", "getLastFatalAnrSent", "()Ljava/lang/Long;", "lastViewEvent", "Lcom/google/gson/JsonObject;", "getLastViewEvent$annotations", "getLastViewEvent", "()Lcom/google/gson/JsonObject;", "networkInfo", "Lcom/datadog/android/api/context/NetworkInfo;", "getNetworkInfo$annotations", "getNetworkInfo", "()Lcom/datadog/android/api/context/NetworkInfo;", "rootStorageDir", "Ljava/io/File;", "getRootStorageDir$annotations", "getRootStorageDir", "()Ljava/io/File;", "trackingConsent", "Lcom/datadog/android/privacy/TrackingConsent;", "getTrackingConsent$annotations", "getTrackingConsent", "()Lcom/datadog/android/privacy/TrackingConsent;", "deleteLastViewEvent", "", "getAllFeatures", "", "Lcom/datadog/android/api/feature/FeatureScope;", "getDatadogContext", "Lcom/datadog/android/api/context/DatadogContext;", "withFeatureContexts", "", "", "getPersistenceExecutorService", "Ljava/util/concurrent/ExecutorService;", "writeLastFatalAnrSent", "anrTimestamp", "writeLastViewEvent", "data", "", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface InternalSdkCore extends FeatureSdkCore {
    void deleteLastViewEvent();

    List<FeatureScope> getAllFeatures();

    long getAppStartTimeNs();

    long getAppUptimeNs();

    DatadogContext getDatadogContext(Set<String> withFeatureContexts);

    FirstPartyHostHeaderTypeResolver getFirstPartyHostResolver();

    Long getLastFatalAnrSent();

    JsonObject getLastViewEvent();

    NetworkInfo getNetworkInfo();

    ExecutorService getPersistenceExecutorService();

    File getRootStorageDir();

    TrackingConsent getTrackingConsent();

    boolean isDeveloperModeEnabled();

    void writeLastFatalAnrSent(long anrTimestamp);

    void writeLastViewEvent(byte[] data);

    /* JADX INFO: compiled from: InternalSdkCore.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void getAppStartTimeNs$annotations() {
        }

        public static /* synthetic */ void getAppUptimeNs$annotations() {
        }

        public static /* synthetic */ void getLastFatalAnrSent$annotations() {
        }

        public static /* synthetic */ void getLastViewEvent$annotations() {
        }

        public static /* synthetic */ void getNetworkInfo$annotations() {
        }

        public static /* synthetic */ void getRootStorageDir$annotations() {
        }

        public static /* synthetic */ void getTrackingConsent$annotations() {
        }

        public static /* synthetic */ void isDeveloperModeEnabled$annotations() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ DatadogContext getDatadogContext$default(InternalSdkCore internalSdkCore, Set set, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getDatadogContext");
            }
            if ((i & 1) != 0) {
                set = SetsKt.emptySet();
            }
            return internalSdkCore.getDatadogContext(set);
        }
    }
}
