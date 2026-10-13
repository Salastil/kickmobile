package com.datadog.android.ndk.internal;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.feature.FeatureScope;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.core.internal.persistence.Deserializer;
import com.datadog.android.core.internal.persistence.file.FileExtKt;
import com.datadog.android.core.internal.utils.ConcurrencyExtKt;
import com.datadog.android.rum.internal.RumFeature;
import com.google.gson.JsonObject;
import java.io.File;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DatadogNdkCrashHandler.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u0000 .2\u00020\u0001:\u0001.BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\b¢\u0006\u0002\u0010\u0010J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0003J\b\u0010$\u001a\u00020!H\u0002J\b\u0010%\u001a\u00020!H\u0002J\u0010\u0010&\u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0016J$\u0010'\u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\b\u0010(\u001a\u0004\u0018\u00010\t2\b\u0010)\u001a\u0004\u0018\u00010\u000eH\u0003J\b\u0010*\u001a\u00020!H\u0016J\b\u0010+\u001a\u00020!H\u0003J(\u0010,\u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010-\u001a\u00020\b2\u0006\u0010(\u001a\u00020\t2\u0006\u0010)\u001a\u00020\u000eH\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/datadog/android/ndk/internal/DatadogNdkCrashHandler;", "Lcom/datadog/android/ndk/internal/NdkCrashHandler;", "storageDir", "Ljava/io/File;", "dataPersistenceExecutorService", "Ljava/util/concurrent/ExecutorService;", "ndkCrashLogDeserializer", "Lcom/datadog/android/core/internal/persistence/Deserializer;", "", "Lcom/datadog/android/ndk/internal/NdkCrashLog;", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "lastRumViewEventProvider", "Lkotlin/Function0;", "Lcom/google/gson/JsonObject;", "nativeCrashSourceType", "(Ljava/io/File;Ljava/util/concurrent/ExecutorService;Lcom/datadog/android/core/internal/persistence/Deserializer;Lcom/datadog/android/api/InternalLogger;Lkotlin/jvm/functions/Function0;Ljava/lang/String;)V", "lastNdkCrashLog", "getLastNdkCrashLog$dd_sdk_android_core_release", "()Lcom/datadog/android/ndk/internal/NdkCrashLog;", "setLastNdkCrashLog$dd_sdk_android_core_release", "(Lcom/datadog/android/ndk/internal/NdkCrashLog;)V", "lastRumViewEvent", "getLastRumViewEvent$dd_sdk_android_core_release", "()Lcom/google/gson/JsonObject;", "setLastRumViewEvent$dd_sdk_android_core_release", "(Lcom/google/gson/JsonObject;)V", "getNativeCrashSourceType$dd_sdk_android_core_release", "()Ljava/lang/String;", "ndkCrashDataDirectory", "getNdkCrashDataDirectory$dd_sdk_android_core_release", "()Ljava/io/File;", "checkAndHandleNdkCrashReport", "", "sdkCore", "Lcom/datadog/android/api/feature/FeatureSdkCore;", "clearAllReferences", "clearCrashLog", "handleNdkCrash", "handleNdkCrashLog", "ndkCrashLog", "lastViewEvent", "prepareData", "readCrashData", "sendCrashRumEvent", "errorLogMessage", "Companion", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DatadogNdkCrashHandler implements NdkCrashHandler {
    public static final String CRASH_DATA_FILE_NAME = "crash_log";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String ERROR_READ_NDK_DIR = "Error while trying to read the NDK crash directory";
    public static final String INFO_RUM_FEATURE_NOT_REGISTERED = "RUM feature is not registered, won't report NDK crash info as RUM error.";
    public static final String LOG_CRASH_MSG = "NDK crash detected with signal: %s";
    public static final String NDK_CRASH_REPORTS_FOLDER_NAME = "ndk_crash_reports_v2";
    private static final String NDK_CRASH_REPORTS_PENDING_FOLDER_NAME = "ndk_crash_reports_intermediary_v2";
    public static final String NETWORK_INFO_FILE_NAME = "network_information";
    private static final String RUM_VIEW_EVENT_FILE_NAME = "last_view_event";
    private static final int STORAGE_VERSION = 2;
    public static final String USER_INFO_FILE_NAME = "user_information";
    private final ExecutorService dataPersistenceExecutorService;
    private final InternalLogger internalLogger;
    private NdkCrashLog lastNdkCrashLog;
    private JsonObject lastRumViewEvent;
    private final Function0<JsonObject> lastRumViewEventProvider;
    private final String nativeCrashSourceType;
    private final File ndkCrashDataDirectory;
    private final Deserializer<String, NdkCrashLog> ndkCrashLogDeserializer;

    public DatadogNdkCrashHandler(File storageDir, ExecutorService dataPersistenceExecutorService, Deserializer<String, NdkCrashLog> ndkCrashLogDeserializer, InternalLogger internalLogger, Function0<JsonObject> lastRumViewEventProvider, String nativeCrashSourceType) {
        Intrinsics.checkNotNullParameter(storageDir, "storageDir");
        Intrinsics.checkNotNullParameter(dataPersistenceExecutorService, "dataPersistenceExecutorService");
        Intrinsics.checkNotNullParameter(ndkCrashLogDeserializer, "ndkCrashLogDeserializer");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        Intrinsics.checkNotNullParameter(lastRumViewEventProvider, "lastRumViewEventProvider");
        Intrinsics.checkNotNullParameter(nativeCrashSourceType, "nativeCrashSourceType");
        this.dataPersistenceExecutorService = dataPersistenceExecutorService;
        this.ndkCrashLogDeserializer = ndkCrashLogDeserializer;
        this.internalLogger = internalLogger;
        this.lastRumViewEventProvider = lastRumViewEventProvider;
        this.nativeCrashSourceType = nativeCrashSourceType;
        this.ndkCrashDataDirectory = INSTANCE.getNdkGrantedDir(storageDir);
    }

    public /* synthetic */ DatadogNdkCrashHandler(File file, ExecutorService executorService, Deserializer deserializer, InternalLogger internalLogger, Function0 function0, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(file, executorService, deserializer, internalLogger, function0, (i & 32) != 0 ? "ndk" : str);
    }

    /* JADX INFO: renamed from: getNativeCrashSourceType$dd_sdk_android_core_release, reason: from getter */
    public final String getNativeCrashSourceType() {
        return this.nativeCrashSourceType;
    }

    /* JADX INFO: renamed from: getNdkCrashDataDirectory$dd_sdk_android_core_release, reason: from getter */
    public final File getNdkCrashDataDirectory() {
        return this.ndkCrashDataDirectory;
    }

    /* JADX INFO: renamed from: getLastRumViewEvent$dd_sdk_android_core_release, reason: from getter */
    public final JsonObject getLastRumViewEvent() {
        return this.lastRumViewEvent;
    }

    public final void setLastRumViewEvent$dd_sdk_android_core_release(JsonObject jsonObject) {
        this.lastRumViewEvent = jsonObject;
    }

    /* JADX INFO: renamed from: getLastNdkCrashLog$dd_sdk_android_core_release, reason: from getter */
    public final NdkCrashLog getLastNdkCrashLog() {
        return this.lastNdkCrashLog;
    }

    public final void setLastNdkCrashLog$dd_sdk_android_core_release(NdkCrashLog ndkCrashLog) {
        this.lastNdkCrashLog = ndkCrashLog;
    }

    @Override // com.datadog.android.ndk.internal.NdkCrashHandler
    public void prepareData() {
        ConcurrencyExtKt.executeSafe(this.dataPersistenceExecutorService, "NDK crash check", this.internalLogger, new Runnable() { // from class: com.datadog.android.ndk.internal.DatadogNdkCrashHandler$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.readCrashData();
            }
        });
    }

    @Override // com.datadog.android.ndk.internal.NdkCrashHandler
    public void handleNdkCrash(final FeatureSdkCore sdkCore) {
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        ConcurrencyExtKt.executeSafe(this.dataPersistenceExecutorService, "NDK crash report ", this.internalLogger, new Runnable() { // from class: com.datadog.android.ndk.internal.DatadogNdkCrashHandler$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.checkAndHandleNdkCrashReport(sdkCore);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void readCrashData() {
        if (FileExtKt.existsSafe(this.ndkCrashDataDirectory, this.internalLogger)) {
            try {
                try {
                    this.lastRumViewEvent = this.lastRumViewEventProvider.invoke();
                    File[] fileArrListFilesSafe = FileExtKt.listFilesSafe(this.ndkCrashDataDirectory, this.internalLogger);
                    if (fileArrListFilesSafe != null) {
                        for (File file : fileArrListFilesSafe) {
                            if (Intrinsics.areEqual(file.getName(), CRASH_DATA_FILE_NAME)) {
                                String textSafe$default = FileExtKt.readTextSafe$default(file, null, this.internalLogger, 1, null);
                                this.lastNdkCrashLog = textSafe$default != null ? this.ndkCrashLogDeserializer.deserialize(textSafe$default) : null;
                            }
                        }
                    }
                } catch (SecurityException e) {
                    InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.ndk.internal.DatadogNdkCrashHandler.readCrashData.2
                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return DatadogNdkCrashHandler.ERROR_READ_NDK_DIR;
                        }
                    }, (Throwable) e, false, (Map) null, 48, (Object) null);
                }
            } finally {
                clearCrashLog();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkAndHandleNdkCrashReport(FeatureSdkCore sdkCore) {
        NdkCrashLog ndkCrashLog = this.lastNdkCrashLog;
        if (ndkCrashLog != null) {
            handleNdkCrashLog(sdkCore, ndkCrashLog, this.lastRumViewEvent);
            clearAllReferences();
        }
    }

    private final void clearAllReferences() {
        this.lastRumViewEvent = null;
        this.lastNdkCrashLog = null;
    }

    private final void handleNdkCrashLog(FeatureSdkCore sdkCore, NdkCrashLog ndkCrashLog, JsonObject lastViewEvent) {
        if (ndkCrashLog == null) {
            return;
        }
        String str = String.format(Locale.US, LOG_CRASH_MSG, Arrays.copyOf(new Object[]{ndkCrashLog.getSignalName()}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        if (lastViewEvent != null) {
            sendCrashRumEvent(sdkCore, str, ndkCrashLog, lastViewEvent);
        }
    }

    private final void sendCrashRumEvent(FeatureSdkCore sdkCore, String errorLogMessage, NdkCrashLog ndkCrashLog, JsonObject lastViewEvent) {
        FeatureScope feature = sdkCore.getFeature("rum");
        if (feature != null) {
            feature.sendEvent(MapsKt.mapOf(TuplesKt.to("type", RumFeature.NDK_CRASH_BUS_MESSAGE_TYPE), TuplesKt.to("sourceType", this.nativeCrashSourceType), TuplesKt.to("timestamp", Long.valueOf(ndkCrashLog.getTimestamp())), TuplesKt.to("timeSinceAppStartMs", ndkCrashLog.getTimeSinceAppStartMs()), TuplesKt.to("signalName", ndkCrashLog.getSignalName()), TuplesKt.to("stacktrace", ndkCrashLog.getStacktrace()), TuplesKt.to("message", errorLogMessage), TuplesKt.to("lastViewEvent", lastViewEvent)));
        } else {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.INFO, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.ndk.internal.DatadogNdkCrashHandler.sendCrashRumEvent.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "RUM feature is not registered, won't report NDK crash info as RUM error.";
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
        }
    }

    private final void clearCrashLog() {
        if (FileExtKt.existsSafe(this.ndkCrashDataDirectory, this.internalLogger)) {
            try {
                File[] fileArrListFilesSafe = FileExtKt.listFilesSafe(this.ndkCrashDataDirectory, this.internalLogger);
                if (fileArrListFilesSafe != null) {
                    for (File file : fileArrListFilesSafe) {
                        FilesKt.deleteRecursively(file);
                    }
                }
            } catch (Throwable th) {
                InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.ndk.internal.DatadogNdkCrashHandler.clearCrashLog.2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Unable to clear the NDK crash report file: " + DatadogNdkCrashHandler.this.getNdkCrashDataDirectory().getAbsolutePath();
                    }
                }, th, false, (Map) null, 48, (Object) null);
            }
        }
    }

    /* JADX INFO: compiled from: DatadogNdkCrashHandler.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0000¢\u0006\u0002\b\u0012J\u0015\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0000¢\u0006\u0002\b\u0014J\u0015\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0001¢\u0006\u0002\b\u0016J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0015\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0000¢\u0006\u0002\b\u001aJ\u0015\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0000¢\u0006\u0002\b\u001cR\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/datadog/android/ndk/internal/DatadogNdkCrashHandler$Companion;", "", "()V", "CRASH_DATA_FILE_NAME", "", "ERROR_READ_NDK_DIR", "INFO_RUM_FEATURE_NOT_REGISTERED", "LOG_CRASH_MSG", "NDK_CRASH_REPORTS_FOLDER_NAME", "NDK_CRASH_REPORTS_PENDING_FOLDER_NAME", "NETWORK_INFO_FILE_NAME", "RUM_VIEW_EVENT_FILE_NAME", "STORAGE_VERSION", "", "USER_INFO_FILE_NAME", "getGrantedNetworkInfoFile", "Ljava/io/File;", "storageDir", "getGrantedNetworkInfoFile$dd_sdk_android_core_release", "getGrantedUserInfoFile", "getGrantedUserInfoFile$dd_sdk_android_core_release", "getLastViewEventFile", "getLastViewEventFile$dd_sdk_android_core_release", "getNdkGrantedDir", "getNdkPendingDir", "getPendingNetworkInfoFile", "getPendingNetworkInfoFile$dd_sdk_android_core_release", "getPendingUserInfoFile", "getPendingUserInfoFile$dd_sdk_android_core_release", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final File getNdkGrantedDir(File storageDir) {
            return new File(storageDir, "ndk_crash_reports_v2");
        }

        private final File getNdkPendingDir(File storageDir) {
            return new File(storageDir, DatadogNdkCrashHandler.NDK_CRASH_REPORTS_PENDING_FOLDER_NAME);
        }

        @Deprecated(message = "We will still process this path to check file from the old SDK versions, but don't use it anymore for writing.")
        public final File getLastViewEventFile$dd_sdk_android_core_release(File storageDir) {
            Intrinsics.checkNotNullParameter(storageDir, "storageDir");
            return new File(getNdkGrantedDir(storageDir), "last_view_event");
        }

        public final File getPendingNetworkInfoFile$dd_sdk_android_core_release(File storageDir) {
            Intrinsics.checkNotNullParameter(storageDir, "storageDir");
            return new File(getNdkPendingDir(storageDir), DatadogNdkCrashHandler.NETWORK_INFO_FILE_NAME);
        }

        public final File getGrantedNetworkInfoFile$dd_sdk_android_core_release(File storageDir) {
            Intrinsics.checkNotNullParameter(storageDir, "storageDir");
            return new File(getNdkGrantedDir(storageDir), DatadogNdkCrashHandler.NETWORK_INFO_FILE_NAME);
        }

        public final File getPendingUserInfoFile$dd_sdk_android_core_release(File storageDir) {
            Intrinsics.checkNotNullParameter(storageDir, "storageDir");
            return new File(getNdkPendingDir(storageDir), DatadogNdkCrashHandler.USER_INFO_FILE_NAME);
        }

        public final File getGrantedUserInfoFile$dd_sdk_android_core_release(File storageDir) {
            Intrinsics.checkNotNullParameter(storageDir, "storageDir");
            return new File(getNdkGrantedDir(storageDir), DatadogNdkCrashHandler.USER_INFO_FILE_NAME);
        }
    }
}
