package com.datadog.android.core.internal;

import android.app.Application;
import android.content.Context;
import com.datadog.android.Datadog;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.api.context.NetworkInfo;
import com.datadog.android.api.context.TimeInfo;
import com.datadog.android.api.feature.Feature;
import com.datadog.android.api.feature.FeatureContextUpdateReceiver;
import com.datadog.android.api.feature.FeatureEventReceiver;
import com.datadog.android.api.feature.FeatureScope;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.core.InternalSdkCore;
import com.datadog.android.core.configuration.BatchSize;
import com.datadog.android.core.configuration.Configuration;
import com.datadog.android.core.configuration.UploadFrequency;
import com.datadog.android.core.internal.lifecycle.ProcessLifecycleCallback;
import com.datadog.android.core.internal.logger.SdkInternalLogger;
import com.datadog.android.core.internal.metrics.BatchMetricsDispatcher;
import com.datadog.android.core.internal.net.FirstPartyHostHeaderTypeResolver;
import com.datadog.android.core.internal.time.DefaultAppStartTimeProvider;
import com.datadog.android.core.internal.time.TimeProviderExtKt;
import com.datadog.android.core.internal.utils.ConcurrencyExtKt;
import com.datadog.android.core.internal.utils.LockExtKt;
import com.datadog.android.core.thread.FlushableExecutorService;
import com.datadog.android.error.internal.CrashReportsFeature;
import com.datadog.android.internal.lifecycle.ProcessLifecycleMonitor;
import com.datadog.android.internal.system.BuildSdkVersionProvider;
import com.datadog.android.internal.telemetry.InternalTelemetryEvent;
import com.datadog.android.internal.time.TimeProvider;
import com.datadog.android.privacy.TrackingConsent;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.gson.JsonObject;
import expo.modules.notifications.service.NotificationsService;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.Call;
import okhttp3.OkHttpClient;

/* JADX INFO: compiled from: DatadogCore.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000ª\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0002\b\u0000\u0018\u0000 ³\u00012\u00020\u0001:\u0002³\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\u001e\u0010d\u001a\u00020e2\u0014\u0010f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010h0gH\u0016J\u001e\u0010i\u001a\u00020e2\u0014\u0010f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010h0gH\u0017J\u001c\u0010j\u001a\u00020e2\u0012\u0010k\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020h0gH\u0002J\b\u0010l\u001a\u00020eH\u0016J\b\u0010m\u001a\u00020eH\u0017J\b\u0010n\u001a\u00020eH\u0017J!\u0010o\u001a\u00020p2\u0017\u0010q\u001a\u0013\u0012\u0004\u0012\u00020r\u0012\u0004\u0012\u00020e0\b¢\u0006\u0002\bsH\u0016J\u0010\u0010t\u001a\u00020u2\u0006\u0010v\u001a\u00020\u0005H\u0016J\u0010\u0010w\u001a\u00020x2\u0006\u0010v\u001a\u00020\u0005H\u0016J\b\u0010y\u001a\u00020eH\u0017J\r\u0010z\u001a\u00020eH\u0001¢\u0006\u0002\b{J\u000e\u0010|\u001a\b\u0012\u0004\u0012\u00020~0}H\u0016J\u001b\u0010\u007f\u001a\u0005\u0018\u00010\u0080\u00012\u000e\u0010\u0081\u0001\u001a\t\u0012\u0004\u0012\u00020\u00050\u0082\u0001H\u0016J\u0014\u0010\u0083\u0001\u001a\u0004\u0018\u00010~2\u0007\u0010\u0084\u0001\u001a\u00020\u0005H\u0016J)\u0010\u0085\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010h0g2\u0007\u0010\u0084\u0001\u001a\u00020\u00052\u0007\u0010\u0086\u0001\u001a\u00020;H\u0016J\t\u0010\u0087\u0001\u001a\u00020xH\u0016J\u0019\u0010\u0088\u0001\u001a\u00020e2\b\u0010\u0089\u0001\u001a\u00030\u008a\u0001H\u0000¢\u0006\u0003\b\u008b\u0001J\t\u0010\u008c\u0001\u001a\u00020eH\u0002J\u0011\u0010\u008d\u0001\u001a\u00020;2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\t\u0010\u008e\u0001\u001a\u00020;H\u0016J\u0012\u0010\u008f\u0001\u001a\u00020;2\u0007\u0010\u0090\u0001\u001a\u00020\u0005H\u0002J\u0014\u0010\u0091\u0001\u001a\u00030\u008a\u00012\b\u0010\u0089\u0001\u001a\u00030\u008a\u0001H\u0002J\u0013\u0010\u0092\u0001\u001a\u00020e2\b\u0010\u0093\u0001\u001a\u00030\u0094\u0001H\u0016J\u0012\u0010\u0095\u0001\u001a\u00020e2\u0007\u0010\u0096\u0001\u001a\u00020'H\u0016J\u0012\u0010\u0097\u0001\u001a\u00020e2\u0007\u0010\u0084\u0001\u001a\u00020\u0005H\u0016J\t\u0010\u0098\u0001\u001a\u00020eH\u0002J\u0013\u0010\u0099\u0001\u001a\u00020e2\b\u0010\u0089\u0001\u001a\u00030\u008a\u0001H\u0002J2\u0010\u009a\u0001\u001a\u00020e2\u0007\u0010\u009b\u0001\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0014\u0010f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010h0gH\u0016J\u0015\u0010\u009c\u0001\u001a\u00020e2\n\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009e\u0001H\u0016J\u0012\u0010\u009f\u0001\u001a\u00020e2\u0007\u0010\u0096\u0001\u001a\u00020'H\u0016J\u001c\u0010 \u0001\u001a\u00020e2\u0007\u0010\u0084\u0001\u001a\u00020\u00052\b\u0010¡\u0001\u001a\u00030¢\u0001H\u0016J\u0012\u0010£\u0001\u001a\u00020e2\u0007\u0010¤\u0001\u001a\u00020aH\u0017J=\u0010¥\u0001\u001a\u00020e2\u0007\u0010\u009b\u0001\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\t\u0010¦\u0001\u001a\u0004\u0018\u00010\u00052\u0014\u0010f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010h0gH\u0017J\u0011\u0010§\u0001\u001a\u00020e2\u0006\u0010\u0010\u001a\u00020\u0003H\u0002J\t\u0010¨\u0001\u001a\u00020eH\u0002J\u000f\u0010©\u0001\u001a\u00020eH\u0000¢\u0006\u0003\bª\u0001JN\u0010«\u0001\u001a\u00020e2\u0007\u0010\u0084\u0001\u001a\u00020\u00052\u0007\u0010\u0086\u0001\u001a\u00020;21\u0010¬\u0001\u001a,\u0012\"\u0012 \u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010h0-¢\u0006\r\b\u00ad\u0001\u0012\b\b\u0006\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020e0\bH\u0016J\u0012\u0010®\u0001\u001a\u00020e2\u0007\u0010¯\u0001\u001a\u00020\u0014H\u0017J\u0013\u0010°\u0001\u001a\u00020e2\b\u0010±\u0001\u001a\u00030²\u0001H\u0017R\u0014\u0010\u0010\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0016R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u00020\u001aX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020 X\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010%\u001a\b\u0012\u0004\u0012\u00020'0&X\u0080\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b(\u0010)\u001a\u0004\b*\u0010+R \u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020.0-X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0014\u00101\u001a\u0002028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b3\u00104R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0014\u00107\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0014\u0010:\u001a\u00020;8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b<\u0010=R$\u0010?\u001a\u00020;2\u0006\u0010>\u001a\u00020;@PX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010=\"\u0004\b@\u0010AR\u0016\u0010B\u001a\u0004\u0018\u00010\u00148WX\u0096\u0004¢\u0006\u0006\u001a\u0004\bC\u0010DR\u0016\u0010E\u001a\u0004\u0018\u00010F8WX\u0096\u0004¢\u0006\u0006\u001a\u0004\bG\u0010HR\u0014\u0010\u0006\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bI\u00106R\u0014\u0010J\u001a\u00020K8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bL\u0010MR\u0010\u0010N\u001a\u0004\u0018\u00010OX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010P\u001a\u00020Q8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bR\u0010SR\u0014\u0010T\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bU\u00106R\u000e\u0010V\u001a\u00020WX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010X\u001a\u00020Y8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bZ\u0010[R\u0014\u0010\\\u001a\u00020]8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b^\u0010_R\u0014\u0010`\u001a\u00020a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bb\u0010c¨\u0006´\u0001"}, d2 = {"Lcom/datadog/android/core/internal/DatadogCore;", "Lcom/datadog/android/core/InternalSdkCore;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "instanceId", "", "name", "internalLoggerProvider", "Lkotlin/Function1;", "Lcom/datadog/android/api/feature/FeatureSdkCore;", "Lcom/datadog/android/api/InternalLogger;", "executorServiceFactory", "Lcom/datadog/android/core/thread/FlushableExecutorService$Factory;", "buildSdkVersionProvider", "Lcom/datadog/android/internal/system/BuildSdkVersionProvider;", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lcom/datadog/android/core/thread/FlushableExecutorService$Factory;Lcom/datadog/android/internal/system/BuildSdkVersionProvider;)V", "appContext", "getAppContext$dd_sdk_android_core_release", "()Landroid/content/Context;", "appStartTimeNs", "", "getAppStartTimeNs", "()J", "appUptimeNs", "getAppUptimeNs", "contextProvider", "Lcom/datadog/android/core/internal/ContextProvider;", "getContextProvider$dd_sdk_android_core_release", "()Lcom/datadog/android/core/internal/ContextProvider;", "setContextProvider$dd_sdk_android_core_release", "(Lcom/datadog/android/core/internal/ContextProvider;)V", "coreFeature", "Lcom/datadog/android/core/internal/CoreFeature;", "getCoreFeature$dd_sdk_android_core_release", "()Lcom/datadog/android/core/internal/CoreFeature;", "setCoreFeature$dd_sdk_android_core_release", "(Lcom/datadog/android/core/internal/CoreFeature;)V", "featureContextUpdateReceivers", "", "Lcom/datadog/android/api/feature/FeatureContextUpdateReceiver;", "getFeatureContextUpdateReceivers$dd_sdk_android_core_release$annotations", "()V", "getFeatureContextUpdateReceivers$dd_sdk_android_core_release", "()Ljava/util/Set;", "features", "", "Lcom/datadog/android/core/internal/SdkFeature;", "getFeatures$dd_sdk_android_core_release", "()Ljava/util/Map;", "firstPartyHostResolver", "Lcom/datadog/android/core/internal/net/FirstPartyHostHeaderTypeResolver;", "getFirstPartyHostResolver", "()Lcom/datadog/android/core/internal/net/FirstPartyHostHeaderTypeResolver;", "getInstanceId$dd_sdk_android_core_release", "()Ljava/lang/String;", "internalLogger", "getInternalLogger", "()Lcom/datadog/android/api/InternalLogger;", "isActive", "", "isActive$dd_sdk_android_core_release", "()Z", "<set-?>", "isDeveloperModeEnabled", "setDeveloperModeEnabled$dd_sdk_android_core_release", "(Z)V", "lastFatalAnrSent", "getLastFatalAnrSent", "()Ljava/lang/Long;", "lastViewEvent", "Lcom/google/gson/JsonObject;", "getLastViewEvent", "()Lcom/google/gson/JsonObject;", "getName", "networkInfo", "Lcom/datadog/android/api/context/NetworkInfo;", "getNetworkInfo", "()Lcom/datadog/android/api/context/NetworkInfo;", "processLifecycleMonitor", "Lcom/datadog/android/internal/lifecycle/ProcessLifecycleMonitor;", "rootStorageDir", "Ljava/io/File;", "getRootStorageDir", "()Ljava/io/File;", "service", "getService", "shutdownHook", "Ljava/lang/Thread;", "time", "Lcom/datadog/android/api/context/TimeInfo;", "getTime", "()Lcom/datadog/android/api/context/TimeInfo;", "timeProvider", "Lcom/datadog/android/internal/time/TimeProvider;", "getTimeProvider", "()Lcom/datadog/android/internal/time/TimeProvider;", "trackingConsent", "Lcom/datadog/android/privacy/TrackingConsent;", "getTrackingConsent", "()Lcom/datadog/android/privacy/TrackingConsent;", "addAccountExtraInfo", "", "extraInfo", "", "", "addUserProperties", "applyAdditionalConfiguration", "additionalConfiguration", "clearAccountInfo", "clearAllData", "clearUserInfo", "createOkHttpCallFactory", "Lokhttp3/Call$Factory;", "block", "Lokhttp3/OkHttpClient$Builder;", "Lkotlin/ExtensionFunctionType;", "createScheduledExecutorService", "Ljava/util/concurrent/ScheduledExecutorService;", "executorContext", "createSingleThreadExecutorService", "Ljava/util/concurrent/ExecutorService;", "deleteLastViewEvent", "flushStoredData", "flushStoredData$dd_sdk_android_core_release", "getAllFeatures", "", "Lcom/datadog/android/api/feature/FeatureScope;", "getDatadogContext", "Lcom/datadog/android/api/context/DatadogContext;", "withFeatureContexts", "", "getFeature", "featureName", "getFeatureContext", "useContextThread", "getPersistenceExecutorService", "initialize", "configuration", "Lcom/datadog/android/core/configuration/Configuration;", "initialize$dd_sdk_android_core_release", "initializeCrashReportFeature", "isAppDebuggable", "isCoreActive", "isEnvironmentNameValid", "envName", "modifyConfigurationForDeveloperDebug", "registerFeature", "feature", "Lcom/datadog/android/api/feature/Feature;", "removeContextUpdateReceiver", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "removeEventReceiver", "removeShutdownHook", "sendCoreConfigurationTelemetryEvent", "setAccountInfo", "id", "setAnonymousId", "anonymousId", "Ljava/util/UUID;", "setContextUpdateReceiver", "setEventReceiver", NotificationsService.RECEIVER_KEY, "Lcom/datadog/android/api/feature/FeatureEventReceiver;", "setTrackingConsent", BatchMetricsDispatcher.TRACKING_CONSENT_KEY, "setUserInfo", "email", "setupLifecycleMonitorCallback", "setupShutdownHook", "stop", "stop$dd_sdk_android_core_release", "updateFeatureContext", "updateCallback", "Lkotlin/ParameterName;", "writeLastFatalAnrSent", "anrTimestamp", "writeLastViewEvent", "data", "", "Companion", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DatadogCore implements InternalSdkCore {
    private static final long CONFIGURATION_TELEMETRY_DELAY_MS;
    public static final String CONTEXT_UPDATE_LISTENER_ALREADY_REGISTERED = "SDK core already has \"%s\" listener registered.";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String ENV_NAME_VALIDATION_REG_EX = "[a-zA-Z0-9_:./-]{0,195}[a-zA-Z0-9_./-]";
    public static final String EVENT_RECEIVER_ALREADY_EXISTS = "Feature \"%s\" already has event receiver registered, overwriting it.";
    public static final String MESSAGE_ENV_NAME_NOT_VALID = "The environment name should contain maximum 196 of the following allowed characters [a-zA-Z0-9_:./-] and should never finish with a semicolon.In this case the Datadog SDK will not be initialised.";
    public static final String MISSING_FEATURE_FOR_EVENT_RECEIVER = "Cannot add event receiver for feature \"%s\", it is not registered.";
    public static final String NO_NEED_TO_WRITE_LAST_VIEW_EVENT = "No need to write last RUM view event: NDK crash reports feature is not enabled and API is below 30.";
    public static final String SHUTDOWN_THREAD_NAME = "datadog_shutdown";
    private final Context appContext;
    private final BuildSdkVersionProvider buildSdkVersionProvider;
    private ContextProvider contextProvider;
    public CoreFeature coreFeature;
    private final FlushableExecutorService.Factory executorServiceFactory;
    private final Set<FeatureContextUpdateReceiver> featureContextUpdateReceivers;
    private final Map<String, SdkFeature> features;
    private final String instanceId;
    private final InternalLogger internalLogger;
    private boolean isDeveloperModeEnabled;
    private final String name;
    private ProcessLifecycleMonitor processLifecycleMonitor;
    private Thread shutdownHook;

    public static /* synthetic */ void getFeatureContextUpdateReceivers$dd_sdk_android_core_release$annotations() {
    }

    public DatadogCore(Context context, String instanceId, String name, Function1<? super FeatureSdkCore, ? extends InternalLogger> internalLoggerProvider, FlushableExecutorService.Factory factory, BuildSdkVersionProvider buildSdkVersionProvider) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(instanceId, "instanceId");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(internalLoggerProvider, "internalLoggerProvider");
        Intrinsics.checkNotNullParameter(buildSdkVersionProvider, "buildSdkVersionProvider");
        this.instanceId = instanceId;
        this.name = name;
        this.executorServiceFactory = factory;
        this.buildSdkVersionProvider = buildSdkVersionProvider;
        this.features = new ConcurrentHashMap();
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        this.appContext = applicationContext;
        this.contextProvider = new NoOpContextProvider();
        Set<FeatureContextUpdateReceiver> setNewSetFromMap = Collections.newSetFromMap(new ConcurrentHashMap());
        Intrinsics.checkNotNullExpressionValue(setNewSetFromMap, "newSetFromMap(ConcurrentHashMap())");
        this.featureContextUpdateReceivers = setNewSetFromMap;
        this.internalLogger = internalLoggerProvider.invoke(this);
    }

    /* JADX INFO: renamed from: getInstanceId$dd_sdk_android_core_release, reason: from getter */
    public final String getInstanceId() {
        return this.instanceId;
    }

    @Override // com.datadog.android.api.SdkCore
    public String getName() {
        return this.name;
    }

    public /* synthetic */ DatadogCore(Context context, String str, String str2, AnonymousClass1 anonymousClass1, FlushableExecutorService.Factory factory, BuildSdkVersionProvider buildSdkVersionProvider, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, str2, (i & 8) != 0 ? new Function1<FeatureSdkCore, SdkInternalLogger>() { // from class: com.datadog.android.core.internal.DatadogCore.1
            @Override // kotlin.jvm.functions.Function1
            public final SdkInternalLogger invoke(FeatureSdkCore it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new SdkInternalLogger(it, null, null, 6, null);
            }
        } : anonymousClass1, (i & 16) != 0 ? null : factory, (i & 32) != 0 ? BuildSdkVersionProvider.INSTANCE.getDEFAULT() : buildSdkVersionProvider);
    }

    public final CoreFeature getCoreFeature$dd_sdk_android_core_release() {
        CoreFeature coreFeature = this.coreFeature;
        if (coreFeature != null) {
            return coreFeature;
        }
        Intrinsics.throwUninitializedPropertyAccessException("coreFeature");
        return null;
    }

    public final void setCoreFeature$dd_sdk_android_core_release(CoreFeature coreFeature) {
        Intrinsics.checkNotNullParameter(coreFeature, "<set-?>");
        this.coreFeature = coreFeature;
    }

    public final Map<String, SdkFeature> getFeatures$dd_sdk_android_core_release() {
        return this.features;
    }

    /* JADX INFO: renamed from: getAppContext$dd_sdk_android_core_release, reason: from getter */
    public final Context getAppContext() {
        return this.appContext;
    }

    /* JADX INFO: renamed from: getContextProvider$dd_sdk_android_core_release, reason: from getter */
    public final ContextProvider getContextProvider() {
        return this.contextProvider;
    }

    public final void setContextProvider$dd_sdk_android_core_release(ContextProvider contextProvider) {
        Intrinsics.checkNotNullParameter(contextProvider, "<set-?>");
        this.contextProvider = contextProvider;
    }

    public final boolean isActive$dd_sdk_android_core_release() {
        return getCoreFeature$dd_sdk_android_core_release().getInitialized().get();
    }

    public final Set<FeatureContextUpdateReceiver> getFeatureContextUpdateReceivers$dd_sdk_android_core_release() {
        return this.featureContextUpdateReceivers;
    }

    @Override // com.datadog.android.api.SdkCore
    public TimeInfo getTime() {
        return TimeProviderExtKt.composeTimeInfo(getTimeProvider());
    }

    @Override // com.datadog.android.api.SdkCore
    public String getService() {
        return getCoreFeature$dd_sdk_android_core_release().getServiceName();
    }

    @Override // com.datadog.android.core.InternalSdkCore
    public FirstPartyHostHeaderTypeResolver getFirstPartyHostResolver() {
        return getCoreFeature$dd_sdk_android_core_release().getFirstPartyHostHeaderTypeResolver();
    }

    @Override // com.datadog.android.api.feature.FeatureSdkCore
    public InternalLogger getInternalLogger() {
        return this.internalLogger;
    }

    @Override // com.datadog.android.api.feature.FeatureSdkCore
    public TimeProvider getTimeProvider() {
        return getCoreFeature$dd_sdk_android_core_release().getTimeProvider();
    }

    @Override // com.datadog.android.core.InternalSdkCore
    /* JADX INFO: renamed from: isDeveloperModeEnabled, reason: from getter */
    public boolean getIsDeveloperModeEnabled() {
        return this.isDeveloperModeEnabled;
    }

    public void setDeveloperModeEnabled$dd_sdk_android_core_release(boolean z) {
        this.isDeveloperModeEnabled = z;
    }

    @Override // com.datadog.android.api.feature.FeatureSdkCore
    public void registerFeature(Feature feature) {
        Intrinsics.checkNotNullParameter(feature, "feature");
        SdkFeature sdkFeature = new SdkFeature(getCoreFeature$dd_sdk_android_core_release(), this.contextProvider, feature, getInternalLogger(), null, 16, null);
        this.features.put(feature.getName(), sdkFeature);
        sdkFeature.initialize(this.appContext, this.instanceId);
        if (Intrinsics.areEqual(feature.getName(), "rum")) {
            getCoreFeature$dd_sdk_android_core_release().getNdkCrashHandler().handleNdkCrash(this);
        }
    }

    @Override // com.datadog.android.api.feature.FeatureSdkCore
    public FeatureScope getFeature(String featureName) {
        Intrinsics.checkNotNullParameter(featureName, "featureName");
        return this.features.get(featureName);
    }

    @Override // com.datadog.android.api.SdkCore
    public void setTrackingConsent(final TrackingConsent consent) {
        Intrinsics.checkNotNullParameter(consent, "consent");
        ConcurrencyExtKt.executeSafe(getCoreFeature$dd_sdk_android_core_release().getContextExecutorService$dd_sdk_android_core_release(), "DatadogCore.setTrackingConsent", getInternalLogger(), new Runnable() { // from class: com.datadog.android.core.internal.DatadogCore$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.getCoreFeature$dd_sdk_android_core_release().getTrackingConsentProvider().setConsent(consent);
            }
        });
    }

    @Override // com.datadog.android.api.SdkCore
    public void setUserInfo(final String id, final String name, final String email, Map<String, ? extends Object> extraInfo) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        final Map map = MapsKt.toMap(extraInfo);
        ConcurrencyExtKt.executeSafe(getCoreFeature$dd_sdk_android_core_release().getContextExecutorService$dd_sdk_android_core_release(), "DatadogCore.setUserInfo", getInternalLogger(), new Runnable() { // from class: com.datadog.android.core.internal.DatadogCore$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.getCoreFeature$dd_sdk_android_core_release().getUserInfoProvider().setUserInfo(id, name, email, map);
            }
        });
    }

    @Override // com.datadog.android.api.SdkCore
    public void addUserProperties(Map<String, ? extends Object> extraInfo) {
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        final Map map = MapsKt.toMap(extraInfo);
        ConcurrencyExtKt.executeSafe(getCoreFeature$dd_sdk_android_core_release().getContextExecutorService$dd_sdk_android_core_release(), "DatadogCore.addUserProperties", getInternalLogger(), new Runnable() { // from class: com.datadog.android.core.internal.DatadogCore$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.getCoreFeature$dd_sdk_android_core_release().getUserInfoProvider().addUserProperties(map);
            }
        });
    }

    @Override // com.datadog.android.api.SdkCore
    public void clearUserInfo() {
        ConcurrencyExtKt.executeSafe(getCoreFeature$dd_sdk_android_core_release().getContextExecutorService$dd_sdk_android_core_release(), "DatadogCore.clearUserInfo", getInternalLogger(), new Runnable() { // from class: com.datadog.android.core.internal.DatadogCore$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.getCoreFeature$dd_sdk_android_core_release().getUserInfoProvider().clearUserInfo();
            }
        });
    }

    @Override // com.datadog.android.api.SdkCore
    public void clearAllData() {
        ConcurrencyExtKt.executeSafe(getCoreFeature$dd_sdk_android_core_release().getContextExecutorService$dd_sdk_android_core_release(), "DatadogCore.clearAllData", getInternalLogger(), new Runnable() { // from class: com.datadog.android.core.internal.DatadogCore$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                DatadogCore.clearAllData$lambda$6(this.f$0);
            }
        });
    }

    static final void clearAllData$lambda$6(final DatadogCore datadogCore) {
        Iterator<T> it = datadogCore.features.values().iterator();
        while (it.hasNext()) {
            ((SdkFeature) it.next()).clearAllData();
        }
        ConcurrencyExtKt.executeSafe(datadogCore.getPersistenceExecutorService(), "Clear all data", datadogCore.getInternalLogger(), new Runnable() { // from class: com.datadog.android.core.internal.DatadogCore$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                DatadogCore.clearAllData$lambda$6$lambda$5(this.f$0);
            }
        });
    }

    static final void clearAllData$lambda$6$lambda$5(DatadogCore datadogCore) {
        datadogCore.getCoreFeature$dd_sdk_android_core_release().deleteLastViewEvent$dd_sdk_android_core_release();
        datadogCore.getCoreFeature$dd_sdk_android_core_release().deleteLastFatalAnrSent$dd_sdk_android_core_release();
    }

    @Override // com.datadog.android.api.SdkCore
    public void setAccountInfo(final String id, final String name, Map<String, ? extends Object> extraInfo) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        final Map map = MapsKt.toMap(extraInfo);
        ConcurrencyExtKt.executeSafe(getCoreFeature$dd_sdk_android_core_release().getContextExecutorService$dd_sdk_android_core_release(), "DatadogCore.setAccountInfo", getInternalLogger(), new Runnable() { // from class: com.datadog.android.core.internal.DatadogCore$$ExternalSyntheticLambda13
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.getCoreFeature$dd_sdk_android_core_release().getAccountInfoProvider().setAccountInfo(id, name, map);
            }
        });
    }

    @Override // com.datadog.android.api.SdkCore
    public void addAccountExtraInfo(Map<String, ? extends Object> extraInfo) {
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        final Map map = MapsKt.toMap(extraInfo);
        ConcurrencyExtKt.executeSafe(getCoreFeature$dd_sdk_android_core_release().getContextExecutorService$dd_sdk_android_core_release(), "DatadogCore.addAccountExtraInfo", getInternalLogger(), new Runnable() { // from class: com.datadog.android.core.internal.DatadogCore$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.getCoreFeature$dd_sdk_android_core_release().getAccountInfoProvider().addExtraInfo(map);
            }
        });
    }

    @Override // com.datadog.android.api.SdkCore
    public void clearAccountInfo() {
        ConcurrencyExtKt.executeSafe(getCoreFeature$dd_sdk_android_core_release().getContextExecutorService$dd_sdk_android_core_release(), "DatadogCore.clearAccountInfo", getInternalLogger(), new Runnable() { // from class: com.datadog.android.core.internal.DatadogCore$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.getCoreFeature$dd_sdk_android_core_release().getAccountInfoProvider().clearAccountInfo();
            }
        });
    }

    @Override // com.datadog.android.api.feature.FeatureSdkCore
    public void updateFeatureContext(final String featureName, boolean useContextThread, final Function1<? super Map<String, Object>, Unit> updateCallback) {
        Intrinsics.checkNotNullParameter(featureName, "featureName");
        Intrinsics.checkNotNullParameter(updateCallback, "updateCallback");
        final Function0<Unit> function0 = new Function0<Unit>() { // from class: com.datadog.android.core.internal.DatadogCore$updateFeatureContext$runnable$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                final SdkFeature sdkFeature = this.this$0.getFeatures$dd_sdk_android_core_release().get(featureName);
                if (sdkFeature == null) {
                    return;
                }
                Lock lockWriteLock = sdkFeature.getFeatureContextLock().writeLock();
                Intrinsics.checkNotNullExpressionValue(lockWriteLock, "feature.featureContextLock.writeLock()");
                TimeUnit timeUnit = TimeUnit.SECONDS;
                InternalLogger internalLogger = this.this$0.getInternalLogger();
                final Function1<Map<String, Object>, Unit> function1 = updateCallback;
                final DatadogCore datadogCore = this.this$0;
                final String str = featureName;
                LockExtKt.safeTryWithLock(lockWriteLock, 1L, timeUnit, internalLogger, new Function0<Unit>() { // from class: com.datadog.android.core.internal.DatadogCore$updateFeatureContext$runnable$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        Map<String, ? extends Object> featureContext$dd_sdk_android_core_release = sdkFeature.getFeatureContext$dd_sdk_android_core_release();
                        function1.invoke(featureContext$dd_sdk_android_core_release);
                        Set<FeatureContextUpdateReceiver> featureContextUpdateReceivers$dd_sdk_android_core_release = datadogCore.getFeatureContextUpdateReceivers$dd_sdk_android_core_release();
                        String str2 = str;
                        Iterator<T> it = featureContextUpdateReceivers$dd_sdk_android_core_release.iterator();
                        while (it.hasNext()) {
                            ((FeatureContextUpdateReceiver) it.next()).onContextUpdate(str2, featureContext$dd_sdk_android_core_release);
                        }
                    }
                });
            }
        };
        if (useContextThread) {
            ConcurrencyExtKt.executeSafe(getCoreFeature$dd_sdk_android_core_release().getContextExecutorService$dd_sdk_android_core_release(), "DatadogCore.updateFeatureContext-" + featureName, getInternalLogger(), new Runnable() { // from class: com.datadog.android.core.internal.DatadogCore$$ExternalSyntheticLambda14
                @Override // java.lang.Runnable
                public final void run() {
                    function0.invoke();
                }
            });
            return;
        }
        function0.invoke();
    }

    @Override // com.datadog.android.api.feature.FeatureSdkCore
    public Map<String, Object> getFeatureContext(final String featureName, boolean useContextThread) throws Exception {
        Intrinsics.checkNotNullParameter(featureName, "featureName");
        Callable callable = new Callable() { // from class: com.datadog.android.core.internal.DatadogCore$$ExternalSyntheticLambda11
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return DatadogCore.getFeatureContext$lambda$11(this.f$0, featureName);
            }
        };
        if (useContextThread) {
            Map<String, Object> map = (Map) ConcurrencyExtKt.getSafe(ConcurrencyExtKt.submitSafe(getCoreFeature$dd_sdk_android_core_release().getContextExecutorService$dd_sdk_android_core_release(), "DatadogCore.getFeatureContext-" + featureName, getInternalLogger(), callable), "DatadogCore.getFeatureContext-" + featureName, getInternalLogger());
            return map == null ? MapsKt.emptyMap() : map;
        }
        Object objCall = callable.call();
        Intrinsics.checkNotNullExpressionValue(objCall, "{\n            @Suppress(…callable.call()\n        }");
        return (Map) objCall;
    }

    static final Map getFeatureContext$lambda$11(DatadogCore datadogCore, String str) {
        final SdkFeature sdkFeature = datadogCore.features.get(str);
        if (sdkFeature == null) {
            return MapsKt.emptyMap();
        }
        Lock lock = sdkFeature.getFeatureContextLock().readLock();
        Intrinsics.checkNotNullExpressionValue(lock, "feature.featureContextLock.readLock()");
        Map map = (Map) LockExtKt.safeWithLock(lock, datadogCore.getInternalLogger(), new Function0<HashMap<String, Object>>() { // from class: com.datadog.android.core.internal.DatadogCore$getFeatureContext$callable$1$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final HashMap<String, Object> invoke() {
                return new HashMap<>(sdkFeature.getFeatureContext$dd_sdk_android_core_release());
            }
        });
        return map == null ? MapsKt.emptyMap() : map;
    }

    @Override // com.datadog.android.api.feature.FeatureSdkCore
    public void setEventReceiver(final String featureName, FeatureEventReceiver receiver) {
        Intrinsics.checkNotNullParameter(featureName, "featureName");
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        SdkFeature sdkFeature = this.features.get(featureName);
        if (sdkFeature == null) {
            InternalLogger.DefaultImpls.log$default(getInternalLogger(), InternalLogger.Level.WARN, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.DatadogCore.setEventReceiver.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str = String.format(Locale.US, DatadogCore.MISSING_FEATURE_FOR_EVENT_RECEIVER, Arrays.copyOf(new Object[]{featureName}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
            return;
        }
        if (sdkFeature.getEventReceiver$dd_sdk_android_core_release().get() != null) {
            InternalLogger.DefaultImpls.log$default(getInternalLogger(), InternalLogger.Level.WARN, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.DatadogCore.setEventReceiver.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str = String.format(Locale.US, DatadogCore.EVENT_RECEIVER_ALREADY_EXISTS, Arrays.copyOf(new Object[]{featureName}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
        }
        sdkFeature.getEventReceiver$dd_sdk_android_core_release().set(receiver);
    }

    @Override // com.datadog.android.api.feature.FeatureSdkCore
    public void setContextUpdateReceiver(final FeatureContextUpdateReceiver listener) throws Exception {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (this.featureContextUpdateReceivers.contains(listener)) {
            InternalLogger.DefaultImpls.log$default(getInternalLogger(), InternalLogger.Level.WARN, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.DatadogCore.setContextUpdateReceiver.1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str = String.format(Locale.US, DatadogCore.CONTEXT_UPDATE_LISTENER_ALREADY_REGISTERED, Arrays.copyOf(new Object[]{listener}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
        }
        for (Map.Entry<String, SdkFeature> entry : this.features.entrySet()) {
            Map<String, ? extends Object> featureContext = getFeatureContext(entry.getKey(), false);
            if (!featureContext.isEmpty()) {
                listener.onContextUpdate(entry.getKey(), featureContext);
            }
        }
        this.featureContextUpdateReceivers.add(listener);
    }

    @Override // com.datadog.android.api.feature.FeatureSdkCore
    public void removeContextUpdateReceiver(FeatureContextUpdateReceiver listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.featureContextUpdateReceivers.remove(listener);
    }

    @Override // com.datadog.android.api.feature.FeatureSdkCore
    public void removeEventReceiver(String featureName) {
        AtomicReference<FeatureEventReceiver> eventReceiver$dd_sdk_android_core_release;
        Intrinsics.checkNotNullParameter(featureName, "featureName");
        SdkFeature sdkFeature = this.features.get(featureName);
        if (sdkFeature == null || (eventReceiver$dd_sdk_android_core_release = sdkFeature.getEventReceiver$dd_sdk_android_core_release()) == null) {
            return;
        }
        eventReceiver$dd_sdk_android_core_release.set(null);
    }

    @Override // com.datadog.android.api.feature.FeatureSdkCore
    public ExecutorService createSingleThreadExecutorService(String executorContext) {
        Intrinsics.checkNotNullParameter(executorContext, "executorContext");
        return getCoreFeature$dd_sdk_android_core_release().createExecutorService(executorContext);
    }

    @Override // com.datadog.android.api.feature.FeatureSdkCore
    public ScheduledExecutorService createScheduledExecutorService(String executorContext) {
        Intrinsics.checkNotNullParameter(executorContext, "executorContext");
        return getCoreFeature$dd_sdk_android_core_release().createScheduledExecutorService(executorContext);
    }

    @Override // com.datadog.android.api.feature.FeatureSdkCore
    public Call.Factory createOkHttpCallFactory(Function1<? super OkHttpClient.Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        return getCoreFeature$dd_sdk_android_core_release().createOkHttpCallFactory(block);
    }

    @Override // com.datadog.android.api.feature.FeatureSdkCore
    public void setAnonymousId(final UUID anonymousId) {
        ConcurrencyExtKt.executeSafe(getCoreFeature$dd_sdk_android_core_release().getContextExecutorService$dd_sdk_android_core_release(), "DatadogCore.setAnonymousId", getInternalLogger(), new Runnable() { // from class: com.datadog.android.core.internal.DatadogCore$$ExternalSyntheticLambda16
            @Override // java.lang.Runnable
            public final void run() {
                DatadogCore datadogCore = this.f$0;
                UUID uuid = anonymousId;
                datadogCore.getCoreFeature$dd_sdk_android_core_release().getUserInfoProvider().setAnonymousId(uuid != null ? uuid.toString() : null);
            }
        });
    }

    @Override // com.datadog.android.api.SdkCore
    public boolean isCoreActive() {
        return isActive$dd_sdk_android_core_release();
    }

    @Override // com.datadog.android.core.InternalSdkCore
    public NetworkInfo getNetworkInfo() {
        return getCoreFeature$dd_sdk_android_core_release().getNetworkInfoProvider().getLastNetworkInfo();
    }

    @Override // com.datadog.android.core.InternalSdkCore
    public TrackingConsent getTrackingConsent() {
        TrackingConsent trackingConsent = (TrackingConsent) ConcurrencyExtKt.getSafe(ConcurrencyExtKt.submitSafe(getCoreFeature$dd_sdk_android_core_release().getContextExecutorService$dd_sdk_android_core_release(), "getTrackingConsent", getInternalLogger(), new Callable() { // from class: com.datadog.android.core.internal.DatadogCore$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.getCoreFeature$dd_sdk_android_core_release().getTrackingConsentProvider().getConsent();
            }
        }), "getTrackingConsent", getInternalLogger());
        return trackingConsent == null ? TrackingConsent.NOT_GRANTED : trackingConsent;
    }

    @Override // com.datadog.android.core.InternalSdkCore
    public File getRootStorageDir() {
        return getCoreFeature$dd_sdk_android_core_release().getStorageDir$dd_sdk_android_core_release();
    }

    @Override // com.datadog.android.core.InternalSdkCore
    public JsonObject getLastViewEvent() {
        return getCoreFeature$dd_sdk_android_core_release().getLastViewEvent$dd_sdk_android_core_release();
    }

    @Override // com.datadog.android.core.InternalSdkCore
    public Long getLastFatalAnrSent() {
        return getCoreFeature$dd_sdk_android_core_release().getLastFatalAnrSent$dd_sdk_android_core_release();
    }

    @Override // com.datadog.android.core.InternalSdkCore
    public long getAppStartTimeNs() {
        return getCoreFeature$dd_sdk_android_core_release().getAppStartTimeNs$dd_sdk_android_core_release();
    }

    @Override // com.datadog.android.core.InternalSdkCore
    public long getAppUptimeNs() {
        return getCoreFeature$dd_sdk_android_core_release().getAppUptimeNs$dd_sdk_android_core_release();
    }

    @Override // com.datadog.android.core.InternalSdkCore
    public void writeLastViewEvent(byte[] data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (this.buildSdkVersionProvider.getIsAtLeastR() || this.features.containsKey("ndk-crash-reporting")) {
            getCoreFeature$dd_sdk_android_core_release().writeLastViewEvent$dd_sdk_android_core_release(data);
        } else {
            InternalLogger.DefaultImpls.log$default(getInternalLogger(), InternalLogger.Level.INFO, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.DatadogCore.writeLastViewEvent.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return DatadogCore.NO_NEED_TO_WRITE_LAST_VIEW_EVENT;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
        }
    }

    @Override // com.datadog.android.core.InternalSdkCore
    public void deleteLastViewEvent() {
        getCoreFeature$dd_sdk_android_core_release().deleteLastViewEvent$dd_sdk_android_core_release();
    }

    @Override // com.datadog.android.core.InternalSdkCore
    public void writeLastFatalAnrSent(long anrTimestamp) {
        getCoreFeature$dd_sdk_android_core_release().writeLastFatalAnrSent$dd_sdk_android_core_release(anrTimestamp);
    }

    @Override // com.datadog.android.core.InternalSdkCore
    public ExecutorService getPersistenceExecutorService() {
        return getCoreFeature$dd_sdk_android_core_release().getPersistenceExecutorService$dd_sdk_android_core_release();
    }

    @Override // com.datadog.android.core.InternalSdkCore
    public List<FeatureScope> getAllFeatures() {
        return CollectionsKt.toList(this.features.values());
    }

    @Override // com.datadog.android.core.InternalSdkCore
    public DatadogContext getDatadogContext(final Set<String> withFeatureContexts) {
        Intrinsics.checkNotNullParameter(withFeatureContexts, "withFeatureContexts");
        return (DatadogContext) ConcurrencyExtKt.getSafe(ConcurrencyExtKt.submitSafe(getCoreFeature$dd_sdk_android_core_release().getContextExecutorService$dd_sdk_android_core_release(), "getDatadogContext", getInternalLogger(), new Callable() { // from class: com.datadog.android.core.internal.DatadogCore$$ExternalSyntheticLambda8
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return DatadogCore.getDatadogContext$lambda$16(this.f$0, withFeatureContexts);
            }
        }), "getDatadogContext", getInternalLogger());
    }

    static final DatadogContext getDatadogContext$lambda$16(DatadogCore datadogCore, Set set) {
        ContextProvider contextProvider = datadogCore.contextProvider;
        if (contextProvider instanceof NoOpContextProvider) {
            return null;
        }
        return contextProvider.getContext(set);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void initialize$dd_sdk_android_core_release(Configuration configuration) {
        Configuration configurationModifyConfigurationForDeveloperDebug;
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        if (!isEnvironmentNameValid(configuration.getEnv$dd_sdk_android_core_release())) {
            throw new IllegalArgumentException(MESSAGE_ENV_NAME_NOT_VALID);
        }
        int i = 2;
        if (isAppDebuggable(this.appContext) && configuration.getCoreConfig$dd_sdk_android_core_release().getEnableDeveloperModeWhenDebuggable()) {
            configurationModifyConfigurationForDeveloperDebug = modifyConfigurationForDeveloperDebug(configuration);
            setDeveloperModeEnabled$dd_sdk_android_core_release(true);
            Datadog.setVerbosity(2);
        } else {
            configurationModifyConfigurationForDeveloperDebug = configuration;
        }
        FlushableExecutorService.Factory dEFAULT_FLUSHABLE_EXECUTOR_SERVICE_FACTORY$dd_sdk_android_core_release = this.executorServiceFactory;
        if (dEFAULT_FLUSHABLE_EXECUTOR_SERVICE_FACTORY$dd_sdk_android_core_release == null) {
            dEFAULT_FLUSHABLE_EXECUTOR_SERVICE_FACTORY$dd_sdk_android_core_release = CoreFeature.INSTANCE.getDEFAULT_FLUSHABLE_EXECUTOR_SERVICE_FACTORY$dd_sdk_android_core_release();
        }
        setCoreFeature$dd_sdk_android_core_release(new CoreFeature(getInternalLogger(), new DefaultAppStartTimeProvider(new Function0<TimeProvider>() { // from class: com.datadog.android.core.internal.DatadogCore$initialize$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TimeProvider invoke() {
                return this.this$0.getTimeProvider();
            }
        }, null, i, 0 == true ? 1 : 0), dEFAULT_FLUSHABLE_EXECUTOR_SERVICE_FACTORY$dd_sdk_android_core_release, CoreFeature.INSTANCE.getDEFAULT_SCHEDULED_EXECUTOR_SERVICE_FACTORY$dd_sdk_android_core_release(), null, 16, null));
        getCoreFeature$dd_sdk_android_core_release().initialize(this.appContext, this.instanceId, configurationModifyConfigurationForDeveloperDebug, TrackingConsent.PENDING);
        this.contextProvider = new DatadogContextProvider(getCoreFeature$dd_sdk_android_core_release(), new FeatureContextProvider() { // from class: com.datadog.android.core.internal.DatadogCore$$ExternalSyntheticLambda10
            @Override // com.datadog.android.core.internal.FeatureContextProvider
            public final Map getFeatureContext(String str) {
                return DatadogCore.initialize$lambda$17(this.f$0, str);
            }
        });
        applyAdditionalConfiguration(configurationModifyConfigurationForDeveloperDebug.getAdditionalConfig$dd_sdk_android_core_release());
        if (configurationModifyConfigurationForDeveloperDebug.getCrashReportsEnabled$dd_sdk_android_core_release()) {
            initializeCrashReportFeature();
        }
        setupLifecycleMonitorCallback(this.appContext);
        setupShutdownHook();
        sendCoreConfigurationTelemetryEvent(configuration);
    }

    static final Map initialize$lambda$17(DatadogCore datadogCore, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return datadogCore.getFeatureContext(it, false);
    }

    private final void initializeCrashReportFeature() {
        registerFeature(new CrashReportsFeature(this));
    }

    private final Configuration modifyConfigurationForDeveloperDebug(Configuration configuration) {
        return Configuration.copy$default(configuration, Configuration.Core.copy$default(configuration.getCoreConfig$dd_sdk_android_core_release(), false, false, null, BatchSize.SMALL, UploadFrequency.FREQUENT, null, null, null, null, null, null, null, null, 8167, null), null, null, null, null, false, null, null, 254, null);
    }

    private final void applyAdditionalConfiguration(Map<String, ? extends Object> additionalConfiguration) {
        Object obj = additionalConfiguration.get(Datadog.DD_SOURCE_TAG);
        if (obj != null && (obj instanceof String) && !StringsKt.isBlank((CharSequence) obj)) {
            getCoreFeature$dd_sdk_android_core_release().setSourceName$dd_sdk_android_core_release((String) obj);
        }
        Object obj2 = additionalConfiguration.get(Datadog.DD_SDK_VERSION_TAG);
        if (obj2 != null && (obj2 instanceof String) && !StringsKt.isBlank((CharSequence) obj2)) {
            getCoreFeature$dd_sdk_android_core_release().setSdkVersion$dd_sdk_android_core_release((String) obj2);
        }
        Object obj3 = additionalConfiguration.get("_dd.version");
        if (obj3 == null || !(obj3 instanceof String) || StringsKt.isBlank((CharSequence) obj3)) {
            return;
        }
        getCoreFeature$dd_sdk_android_core_release().getPackageVersionProvider().setVersion((String) obj3);
    }

    private final void setupLifecycleMonitorCallback(Context appContext) {
        if (appContext instanceof Application) {
            ProcessLifecycleMonitor processLifecycleMonitor = new ProcessLifecycleMonitor(new ProcessLifecycleCallback(appContext, getName(), getInternalLogger()));
            ((Application) appContext).registerActivityLifecycleCallbacks(processLifecycleMonitor);
            this.processLifecycleMonitor = processLifecycleMonitor;
        }
    }

    private final boolean isEnvironmentNameValid(String envName) {
        return new Regex(ENV_NAME_VALIDATION_REG_EX).matches(envName);
    }

    private final boolean isAppDebuggable(Context context) {
        return (context.getApplicationInfo().flags & 2) != 0;
    }

    private final void setupShutdownHook() {
        try {
            this.shutdownHook = new Thread(new Runnable() { // from class: com.datadog.android.core.internal.DatadogCore$$ExternalSyntheticLambda15
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.stop$dd_sdk_android_core_release();
                }
            }, SHUTDOWN_THREAD_NAME);
            Runtime runtime = Runtime.getRuntime();
            Thread thread = this.shutdownHook;
            if (thread == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shutdownHook");
                thread = null;
            }
            runtime.addShutdownHook(thread);
        } catch (IllegalArgumentException e) {
            InternalLogger.DefaultImpls.log$default(getInternalLogger(), InternalLogger.Level.ERROR, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.DatadogCore.setupShutdownHook.2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Shutdown hook was rejected";
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
        } catch (IllegalStateException e2) {
            InternalLogger.DefaultImpls.log$default(getInternalLogger(), InternalLogger.Level.ERROR, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.DatadogCore.setupShutdownHook.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Unable to add shutdown hook, Runtime is already shutting down";
                }
            }, (Throwable) e2, false, (Map) null, 48, (Object) null);
            stop$dd_sdk_android_core_release();
        } catch (SecurityException e3) {
            InternalLogger.DefaultImpls.log$default(getInternalLogger(), InternalLogger.Level.ERROR, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.DatadogCore.setupShutdownHook.3
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Security Manager denied adding shutdown hook ";
                }
            }, (Throwable) e3, false, (Map) null, 48, (Object) null);
        }
    }

    private final void removeShutdownHook() {
        if (this.shutdownHook != null) {
            try {
                Runtime runtime = Runtime.getRuntime();
                Thread thread = this.shutdownHook;
                if (thread == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("shutdownHook");
                    thread = null;
                }
                runtime.removeShutdownHook(thread);
            } catch (IllegalStateException e) {
                InternalLogger.DefaultImpls.log$default(getInternalLogger(), InternalLogger.Level.ERROR, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.DatadogCore.removeShutdownHook.1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Unable to remove shutdown hook, Runtime is already shutting down";
                    }
                }, (Throwable) e, false, (Map) null, 48, (Object) null);
            } catch (SecurityException e2) {
                InternalLogger.DefaultImpls.log$default(getInternalLogger(), InternalLogger.Level.ERROR, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.DatadogCore.removeShutdownHook.2
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Security Manager denied removing shutdown hook ";
                    }
                }, (Throwable) e2, false, (Map) null, 48, (Object) null);
            }
        }
    }

    private final void sendCoreConfigurationTelemetryEvent(final Configuration configuration) {
        ConcurrencyExtKt.scheduleSafe(getCoreFeature$dd_sdk_android_core_release().getUploadExecutorService$dd_sdk_android_core_release(), "Configuration telemetry", CONFIGURATION_TELEMETRY_DELAY_MS, TimeUnit.MILLISECONDS, getInternalLogger(), new Runnable() { // from class: com.datadog.android.core.internal.DatadogCore$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                DatadogCore.sendCoreConfigurationTelemetryEvent$lambda$23(this.f$0, configuration);
            }
        });
    }

    static final void sendCoreConfigurationTelemetryEvent$lambda$23(DatadogCore datadogCore, Configuration configuration) {
        FeatureScope feature = datadogCore.getFeature("rum");
        if (feature == null) {
            return;
        }
        feature.sendEvent(new InternalTelemetryEvent.Configuration(configuration.getCrashReportsEnabled$dd_sdk_android_core_release(), configuration.getCoreConfig$dd_sdk_android_core_release().getBatchSize().getWindowDurationMs(), configuration.getCoreConfig$dd_sdk_android_core_release().getUploadFrequency().getBaseStepMs(), configuration.getCoreConfig$dd_sdk_android_core_release().getProxy() != null, configuration.getCoreConfig$dd_sdk_android_core_release().getEncryption() != null, configuration.getCoreConfig$dd_sdk_android_core_release().getBatchProcessingLevel().getMaxBatchesPerUploadJob()));
    }

    public final void stop$dd_sdk_android_core_release() {
        Iterator<T> it = this.features.keySet().iterator();
        while (it.hasNext()) {
            SdkFeature sdkFeatureRemove = this.features.remove((String) it.next());
            if (sdkFeatureRemove != null) {
                sdkFeatureRemove.stop();
            }
        }
        ProcessLifecycleMonitor processLifecycleMonitor = this.processLifecycleMonitor;
        Context context = this.appContext;
        if ((context instanceof Application) && processLifecycleMonitor != null) {
            ((Application) context).unregisterActivityLifecycleCallbacks(processLifecycleMonitor);
        }
        this.contextProvider = new NoOpContextProvider();
        getCoreFeature$dd_sdk_android_core_release().stop();
        setDeveloperModeEnabled$dd_sdk_android_core_release(false);
        removeShutdownHook();
    }

    public final void flushStoredData$dd_sdk_android_core_release() throws InterruptedException {
        getCoreFeature$dd_sdk_android_core_release().drainAndShutdownExecutors();
        Iterator<T> it = this.features.values().iterator();
        while (it.hasNext()) {
            ((SdkFeature) it.next()).flushStoredData$dd_sdk_android_core_release();
        }
    }

    /* JADX INFO: compiled from: DatadogCore.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0080T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/datadog/android/core/internal/DatadogCore$Companion;", "", "()V", "CONFIGURATION_TELEMETRY_DELAY_MS", "", "getCONFIGURATION_TELEMETRY_DELAY_MS$dd_sdk_android_core_release", "()J", "CONTEXT_UPDATE_LISTENER_ALREADY_REGISTERED", "", "ENV_NAME_VALIDATION_REG_EX", "EVENT_RECEIVER_ALREADY_EXISTS", "MESSAGE_ENV_NAME_NOT_VALID", "MISSING_FEATURE_FOR_EVENT_RECEIVER", "NO_NEED_TO_WRITE_LAST_VIEW_EVENT", "SHUTDOWN_THREAD_NAME", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final long getCONFIGURATION_TELEMETRY_DELAY_MS$dd_sdk_android_core_release() {
            return DatadogCore.CONFIGURATION_TELEMETRY_DELAY_MS;
        }
    }

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        CONFIGURATION_TELEMETRY_DELAY_MS = 5000L;
    }
}
