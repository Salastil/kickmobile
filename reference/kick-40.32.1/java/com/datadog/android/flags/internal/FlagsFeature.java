package com.datadog.android.flags.internal;

import android.content.Context;
import android.util.Log;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.api.feature.StorageBackedFeature;
import com.datadog.android.api.storage.FeatureStorageConfiguration;
import com.datadog.android.flags.FlagsClient;
import com.datadog.android.flags.FlagsConfiguration;
import com.datadog.android.flags.internal.net.ExposuresRequestFactory;
import com.datadog.android.flags.internal.net.PrecomputedAssignmentsRequestFactory;
import com.datadog.android.flags.internal.storage.ExposureEventRecordWriter;
import com.datadog.android.flags.internal.storage.NoOpRecordWriter;
import com.datadog.android.flags.internal.storage.RecordWriter;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FlagsFeature.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 A2\u00020\u0001:\u0001AB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\r\u0010+\u001a\u00020,H\u0000¢\u0006\u0002\b-J\b\u0010.\u001a\u00020\bH\u0002J\u0017\u0010/\u001a\u0004\u0018\u00010\"2\u0006\u0010\u0012\u001a\u00020\u0013H\u0000¢\u0006\u0002\b0J#\u00101\u001a\u00020\"2\u0006\u0010\u0012\u001a\u00020\u00132\f\u00102\u001a\b\u0012\u0004\u0012\u00020\"03H\u0000¢\u0006\u0002\b4J)\u00105\u001a\u00020,2\u0006\u00106\u001a\u00020\u00132\b\b\u0002\u00107\u001a\u0002082\b\b\u0002\u00109\u001a\u00020\u0010H\u0000¢\u0006\u0002\b:J\u0010\u0010;\u001a\u00020,2\u0006\u0010<\u001a\u00020=H\u0016J\b\u0010>\u001a\u00020,H\u0016J\u0017\u0010?\u001a\u0004\u0018\u00010\"2\u0006\u0010\u0012\u001a\u00020\u0013H\u0000¢\u0006\u0002\b@R\u001a\u0010\u0007\u001a\u00020\bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u0013X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u0017X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\"0!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\u00020$X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\u00020(X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*¨\u0006B"}, d2 = {"Lcom/datadog/android/flags/internal/FlagsFeature;", "Lcom/datadog/android/api/feature/StorageBackedFeature;", "sdkCore", "Lcom/datadog/android/api/feature/FeatureSdkCore;", "flagsConfiguration", "Lcom/datadog/android/flags/FlagsConfiguration;", "(Lcom/datadog/android/api/feature/FeatureSdkCore;Lcom/datadog/android/flags/FlagsConfiguration;)V", "dataWriter", "Lcom/datadog/android/flags/internal/storage/RecordWriter;", "getDataWriter$dd_sdk_android_flags_release", "()Lcom/datadog/android/flags/internal/storage/RecordWriter;", "setDataWriter$dd_sdk_android_flags_release", "(Lcom/datadog/android/flags/internal/storage/RecordWriter;)V", "getFlagsConfiguration$dd_sdk_android_flags_release", "()Lcom/datadog/android/flags/FlagsConfiguration;", "isDebugBuild", "", "isInitialized", "name", "", "getName", "()Ljava/lang/String;", "precomputedRequestFactory", "Lcom/datadog/android/flags/internal/net/PrecomputedAssignmentsRequestFactory;", "getPrecomputedRequestFactory$dd_sdk_android_flags_release", "()Lcom/datadog/android/flags/internal/net/PrecomputedAssignmentsRequestFactory;", "processor", "Lcom/datadog/android/flags/internal/EventsProcessor;", "getProcessor$dd_sdk_android_flags_release", "()Lcom/datadog/android/flags/internal/EventsProcessor;", "setProcessor$dd_sdk_android_flags_release", "(Lcom/datadog/android/flags/internal/EventsProcessor;)V", "registeredClients", "", "Lcom/datadog/android/flags/FlagsClient;", "requestFactory", "Lcom/datadog/android/flags/internal/net/ExposuresRequestFactory;", "getRequestFactory", "()Lcom/datadog/android/flags/internal/net/ExposuresRequestFactory;", "storageConfiguration", "Lcom/datadog/android/api/storage/FeatureStorageConfiguration;", "getStorageConfiguration", "()Lcom/datadog/android/api/storage/FeatureStorageConfiguration;", "clearClients", "", "clearClients$dd_sdk_android_flags_release", "createDataWriter", "getClient", "getClient$dd_sdk_android_flags_release", "getOrRegisterNewClient", "newClientFactory", "Lkotlin/Function0;", "getOrRegisterNewClient$dd_sdk_android_flags_release", "logErrorWithPolicy", "message", FirebaseAnalytics.Param.LEVEL, "Lcom/datadog/android/api/InternalLogger$Level;", "shouldCrashInStrict", "logErrorWithPolicy$dd_sdk_android_flags_release", "onInitialize", "appContext", "Landroid/content/Context;", "onStop", "unregisterClient", "unregisterClient$dd_sdk_android_flags_release", "Companion", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FlagsFeature implements StorageBackedFeature {
    private static final String LOG_TAG = "[Datadog Flags]";
    private volatile RecordWriter dataWriter;
    private final FlagsConfiguration flagsConfiguration;
    private volatile boolean isDebugBuild;
    private volatile boolean isInitialized;
    private final String name;
    private final PrecomputedAssignmentsRequestFactory precomputedRequestFactory;
    private volatile EventsProcessor processor;
    private final Map<String, FlagsClient> registeredClients;
    private final ExposuresRequestFactory requestFactory;
    private final FeatureSdkCore sdkCore;
    private final FeatureStorageConfiguration storageConfiguration;

    public FlagsFeature(FeatureSdkCore sdkCore, FlagsConfiguration flagsConfiguration) {
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        Intrinsics.checkNotNullParameter(flagsConfiguration, "flagsConfiguration");
        this.sdkCore = sdkCore;
        this.flagsConfiguration = flagsConfiguration;
        this.processor = new NoOpEventsProcessor();
        this.dataWriter = new NoOpRecordWriter();
        this.registeredClients = new LinkedHashMap();
        this.storageConfiguration = FeatureStorageConfiguration.INSTANCE.getDEFAULT();
        this.requestFactory = new ExposuresRequestFactory(sdkCore.getInternalLogger(), flagsConfiguration.getCustomExposureEndpoint$dd_sdk_android_flags_release());
        this.precomputedRequestFactory = new PrecomputedAssignmentsRequestFactory(sdkCore.getInternalLogger(), flagsConfiguration.getCustomFlagEndpoint$dd_sdk_android_flags_release());
        this.name = "flags";
    }

    /* JADX INFO: renamed from: getFlagsConfiguration$dd_sdk_android_flags_release, reason: from getter */
    public final FlagsConfiguration getFlagsConfiguration() {
        return this.flagsConfiguration;
    }

    /* JADX INFO: renamed from: getProcessor$dd_sdk_android_flags_release, reason: from getter */
    public final EventsProcessor getProcessor() {
        return this.processor;
    }

    public final void setProcessor$dd_sdk_android_flags_release(EventsProcessor eventsProcessor) {
        Intrinsics.checkNotNullParameter(eventsProcessor, "<set-?>");
        this.processor = eventsProcessor;
    }

    /* JADX INFO: renamed from: getDataWriter$dd_sdk_android_flags_release, reason: from getter */
    public final RecordWriter getDataWriter() {
        return this.dataWriter;
    }

    public final void setDataWriter$dd_sdk_android_flags_release(RecordWriter recordWriter) {
        Intrinsics.checkNotNullParameter(recordWriter, "<set-?>");
        this.dataWriter = recordWriter;
    }

    @Override // com.datadog.android.api.feature.StorageBackedFeature
    public FeatureStorageConfiguration getStorageConfiguration() {
        return this.storageConfiguration;
    }

    @Override // com.datadog.android.api.feature.StorageBackedFeature
    public ExposuresRequestFactory getRequestFactory() {
        return this.requestFactory;
    }

    /* JADX INFO: renamed from: getPrecomputedRequestFactory$dd_sdk_android_flags_release, reason: from getter */
    public final PrecomputedAssignmentsRequestFactory getPrecomputedRequestFactory() {
        return this.precomputedRequestFactory;
    }

    @Override // com.datadog.android.api.feature.Feature
    public String getName() {
        return this.name;
    }

    @Override // com.datadog.android.api.feature.Feature
    public void onInitialize(Context appContext) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        if (this.isInitialized) {
            InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.WARN, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.flags.internal.FlagsFeature.onInitialize.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "onInitialize called multiple times - ignoring duplicate call";
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
            return;
        }
        this.isDebugBuild = (appContext.getApplicationInfo().flags & 2) != 0;
        this.isInitialized = true;
        this.dataWriter = createDataWriter();
        this.processor = new ExposureEventsProcessor(this.dataWriter, this.sdkCore.getTimeProvider());
    }

    @Override // com.datadog.android.api.feature.Feature
    public void onStop() {
        this.dataWriter = new NoOpRecordWriter();
        this.isInitialized = false;
        synchronized (this.registeredClients) {
            this.registeredClients.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    private final RecordWriter createDataWriter() {
        return new ExposureEventRecordWriter(this.sdkCore);
    }

    public final FlagsClient getClient$dd_sdk_android_flags_release(String name) {
        FlagsClient flagsClient;
        Intrinsics.checkNotNullParameter(name, "name");
        synchronized (this.registeredClients) {
            flagsClient = this.registeredClients.get(name);
        }
        return flagsClient;
    }

    public final FlagsClient getOrRegisterNewClient$dd_sdk_android_flags_release(String name, Function0<? extends FlagsClient> newClientFactory) {
        FlagsClient flagsClient;
        FlagsClient flagsClientInvoke;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(newClientFactory, "newClientFactory");
        synchronized (this.registeredClients) {
            flagsClient = this.registeredClients.get(name);
        }
        if (flagsClient != null) {
            logErrorWithPolicy$dd_sdk_android_flags_release("Attempted to create a FlagsClient named '" + name + "', but one already exists. The existing client will be used, and new configuration will be ignored.", InternalLogger.Level.WARN, true);
            return flagsClient;
        }
        synchronized (this.registeredClients) {
            flagsClientInvoke = this.registeredClients.get(name);
            if (flagsClientInvoke == null) {
                FlagsFeature flagsFeature = this;
                flagsClientInvoke = newClientFactory.invoke();
                this.registeredClients.put(name, flagsClientInvoke);
            }
        }
        return flagsClientInvoke;
    }

    public final FlagsClient unregisterClient$dd_sdk_android_flags_release(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.registeredClients.remove(name);
    }

    public final void clearClients$dd_sdk_android_flags_release() {
        this.registeredClients.clear();
    }

    public static /* synthetic */ void logErrorWithPolicy$dd_sdk_android_flags_release$default(FlagsFeature flagsFeature, String str, InternalLogger.Level level, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            level = InternalLogger.Level.ERROR;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        flagsFeature.logErrorWithPolicy$dd_sdk_android_flags_release(str, level, z);
    }

    public final void logErrorWithPolicy$dd_sdk_android_flags_release(String message, InternalLogger.Level level, boolean shouldCrashInStrict) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(level, "level");
        final String str = "[Datadog Flags] " + message;
        if (!this.isDebugBuild) {
            InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), level, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.flags.internal.FlagsFeature$logErrorWithPolicy$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return str;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
        } else if (this.flagsConfiguration.getGracefulModeEnabled$dd_sdk_android_flags_release()) {
            Log.e(LOG_TAG, message);
        } else {
            if (shouldCrashInStrict) {
                throw new IllegalStateException(str.toString());
            }
            Log.e(LOG_TAG, message);
        }
    }
}
