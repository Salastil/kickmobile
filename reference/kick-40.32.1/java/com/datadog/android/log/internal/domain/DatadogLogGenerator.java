package com.datadog.android.log.internal.domain;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.context.AccountInfo;
import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.api.context.DeviceInfo;
import com.datadog.android.api.context.DeviceType;
import com.datadog.android.api.context.NetworkInfo;
import com.datadog.android.api.context.UserInfo;
import com.datadog.android.core.feature.event.ThreadDump;
import com.datadog.android.log.LogAttributes;
import com.datadog.android.log.internal.utils.LogUtilsKt;
import com.datadog.android.log.model.LogEvent;
import com.datadog.android.rum.internal.RumFeature;
import com.datadog.android.rum.internal.domain.RumContext;
import com.datadog.android.webview.internal.log.WebViewLogEventConsumer;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.ktor.sse.ServerSentEventKt;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: DatadogLogGenerator.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 L2\u00020\u0001:\u0001LB\u0019\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\f\u001a\u00020\rH\u0002J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u0006\u0010\f\u001a\u00020\rH\u0002J°\u0001\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u00032\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u00182\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020 2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016Jª\u0001\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00032\b\u0010*\u001a\u0004\u0018\u00010+2\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u00182\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020 2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010)2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-H\u0016J\u009c\u0001\u0010/\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00032\b\u00100\u001a\u0004\u0018\u0001012\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u00182\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020 2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0002J\u001c\u00102\u001a\u0004\u0018\u0001032\u0006\u0010\f\u001a\u00020\r2\b\u0010&\u001a\u0004\u0018\u00010'H\u0002JL\u00104\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0019052\u0006\u0010\f\u001a\u00020\r2\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u00182\u0006\u0010\"\u001a\u00020 2\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010#\u001a\u00020 H\u0002J\u0010\u00106\u001a\u0002072\u0006\u00108\u001a\u000209H\u0002J\u0010\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=H\u0002J\u0010\u0010>\u001a\u00020?2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u001a\u0010@\u001a\u00020A2\u0006\u0010\f\u001a\u00020\r2\b\u0010(\u001a\u0004\u0018\u00010)H\u0002J\u0010\u0010B\u001a\u00020C2\u0006\u00108\u001a\u000209H\u0002J\u0012\u0010D\u001a\u0004\u0018\u00010E2\u0006\u0010(\u001a\u00020)H\u0002J$\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00030G2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u001bH\u0002J\u001a\u0010H\u001a\u00020I2\u0006\u0010\f\u001a\u00020\r2\b\u0010$\u001a\u0004\u0018\u00010%H\u0002J\u0012\u0010J\u001a\u0004\u0018\u00010\u00032\u0006\u0010\f\u001a\u00020\rH\u0002J\u0012\u0010K\u001a\u0004\u0018\u00010\u00032\u0006\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006M"}, d2 = {"Lcom/datadog/android/log/internal/domain/DatadogLogGenerator;", "Lcom/datadog/android/log/internal/domain/LogGenerator;", "serviceName", "", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "(Ljava/lang/String;Lcom/datadog/android/api/InternalLogger;)V", "getServiceName$dd_sdk_android_logs_release", "()Ljava/lang/String;", "simpleDateFormat", "Ljava/text/SimpleDateFormat;", "appVersionTag", "datadogContext", "Lcom/datadog/android/api/context/DatadogContext;", "envTag", "generateLog", "Lcom/datadog/android/log/model/LogEvent;", FirebaseAnalytics.Param.LEVEL, "", "message", "errorKind", "errorMessage", "errorStack", RumFeature.EVENT_ATTRIBUTES_PROPERTY, "", "", "tags", "", "timestamp", "", "threadName", "attachNetworkInfo", "", "loggerName", "bundleWithTraces", "bundleWithRum", "userInfo", "Lcom/datadog/android/api/context/UserInfo;", "accountInfo", "Lcom/datadog/android/api/context/AccountInfo;", "networkInfo", "Lcom/datadog/android/api/context/NetworkInfo;", RumFeature.EVENT_THROWABLE_PROPERTY, "", "threads", "", "Lcom/datadog/android/core/feature/event/ThreadDump;", "internalGenerateLog", "error", "Lcom/datadog/android/log/model/LogEvent$Error;", "resolveAccountInfo", "Lcom/datadog/android/log/model/LogEvent$Account;", "resolveAttributes", "", "resolveDeviceInfo", "Lcom/datadog/android/log/model/LogEvent$LogEventDevice;", "deviceInfo", "Lcom/datadog/android/api/context/DeviceInfo;", "resolveDeviceType", "Lcom/datadog/android/log/model/LogEvent$Type;", "deviceType", "Lcom/datadog/android/api/context/DeviceType;", "resolveLogLevelStatus", "Lcom/datadog/android/log/model/LogEvent$Status;", "resolveNetworkInfo", "Lcom/datadog/android/log/model/LogEvent$Network;", "resolveOsInfo", "Lcom/datadog/android/log/model/LogEvent$Os;", "resolveSimCarrier", "Lcom/datadog/android/log/model/LogEvent$SimCarrier;", "resolveTags", "", "resolveUserInfo", "Lcom/datadog/android/log/model/LogEvent$Usr;", "serviceTag", "variantTag", "Companion", "dd-sdk-android-logs_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DatadogLogGenerator implements LogGenerator {
    public static final int CRASH = 9;
    public static final String ISO_8601 = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    public static final String RESERVED_TAG_DROPPED_WARNING = "User-provided tag %s is dropped, because it matches reserved tag key";
    private final InternalLogger internalLogger;
    private final String serviceName;
    private final SimpleDateFormat simpleDateFormat;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Set<String> RESERVED_TAG_KEYS = SetsKt.setOf((Object[]) new String[]{"env", "version", "variant", "service"});

    /* JADX INFO: compiled from: DatadogLogGenerator.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DeviceType.values().length];
            try {
                iArr[DeviceType.MOBILE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DeviceType.TABLET.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DeviceType.TV.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DeviceType.DESKTOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[DeviceType.GAMING_CONSOLE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[DeviceType.BOT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[DeviceType.OTHER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public DatadogLogGenerator(String str, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.serviceName = str;
        this.internalLogger = internalLogger;
        this.simpleDateFormat = LogUtilsKt.buildLogDateFormat();
    }

    public /* synthetic */ DatadogLogGenerator(String str, InternalLogger internalLogger, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, internalLogger);
    }

    /* JADX INFO: renamed from: getServiceName$dd_sdk_android_logs_release, reason: from getter */
    public final String getServiceName() {
        return this.serviceName;
    }

    @Override // com.datadog.android.log.internal.domain.LogGenerator
    public LogEvent generateLog(int level, String message, Throwable throwable, Map<String, ? extends Object> attributes, Set<String> tags, long timestamp, String threadName, DatadogContext datadogContext, boolean attachNetworkInfo, String loggerName, boolean bundleWithTraces, boolean bundleWithRum, UserInfo userInfo, AccountInfo accountInfo, NetworkInfo networkInfo, List<ThreadDump> threads) {
        LogEvent.Error error;
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(tags, "tags");
        Intrinsics.checkNotNullParameter(threadName, "threadName");
        Intrinsics.checkNotNullParameter(datadogContext, "datadogContext");
        Intrinsics.checkNotNullParameter(loggerName, "loggerName");
        Intrinsics.checkNotNullParameter(threads, "threads");
        Map<String, ? extends Object> mutableMap = MapsKt.toMutableMap(attributes);
        if (throwable != null) {
            Object objRemove = mutableMap.remove("_dd.error.fingerprint");
            String str = objRemove instanceof String ? (String) objRemove : null;
            String canonicalName = throwable.getClass().getCanonicalName();
            if (canonicalName == null) {
                canonicalName = throwable.getClass().getSimpleName();
            }
            String str2 = canonicalName;
            String strStackTraceToString = ExceptionsKt.stackTraceToString(throwable);
            String message2 = throwable.getMessage();
            List<ThreadDump> list = threads;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (ThreadDump threadDump : list) {
                arrayList.add(new LogEvent.Thread(threadDump.getName(), threadDump.getCrashed(), threadDump.getStack(), threadDump.getState()));
            }
            ArrayList arrayList2 = arrayList;
            error = new LogEvent.Error(str2, message2, strStackTraceToString, null, str, arrayList2.isEmpty() ? null : arrayList2, 8, null);
        } else {
            error = null;
        }
        return internalGenerateLog(level, message, error, mutableMap, tags, timestamp, threadName, datadogContext, attachNetworkInfo, loggerName, bundleWithTraces, bundleWithRum, userInfo, accountInfo, networkInfo);
    }

    @Override // com.datadog.android.log.internal.domain.LogGenerator
    public LogEvent generateLog(int level, String message, String errorKind, String errorMessage, String errorStack, Map<String, ? extends Object> attributes, Set<String> tags, long timestamp, String threadName, DatadogContext datadogContext, boolean attachNetworkInfo, String loggerName, boolean bundleWithTraces, boolean bundleWithRum, UserInfo userInfo, AccountInfo accountInfo, NetworkInfo networkInfo) {
        LogEvent.Error error;
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(tags, "tags");
        Intrinsics.checkNotNullParameter(threadName, "threadName");
        Intrinsics.checkNotNullParameter(datadogContext, "datadogContext");
        Intrinsics.checkNotNullParameter(loggerName, "loggerName");
        Map<String, ? extends Object> mutableMap = MapsKt.toMutableMap(attributes);
        if (errorKind == null && errorMessage == null && errorStack == null) {
            error = null;
        } else {
            Object objRemove = mutableMap.remove("_dd.error.source_type");
            String str = objRemove instanceof String ? (String) objRemove : null;
            Object objRemove2 = mutableMap.remove("_dd.error.fingerprint");
            error = new LogEvent.Error(errorKind, errorMessage, errorStack, str, objRemove2 instanceof String ? (String) objRemove2 : null, null, 32, null);
        }
        return internalGenerateLog(level, message, error, mutableMap, tags, timestamp, threadName, datadogContext, attachNetworkInfo, loggerName, bundleWithTraces, bundleWithRum, userInfo, accountInfo, networkInfo);
    }

    private final LogEvent internalGenerateLog(int level, String message, LogEvent.Error error, Map<String, ? extends Object> attributes, Set<String> tags, long timestamp, String threadName, DatadogContext datadogContext, boolean attachNetworkInfo, String loggerName, boolean bundleWithTraces, boolean bundleWithRum, UserInfo userInfo, AccountInfo accountInfo, NetworkInfo networkInfo) {
        String formattedDate;
        long serverTimeOffsetMs = timestamp + datadogContext.getTime().getServerTimeOffsetMs();
        Map<String, Object> mapResolveAttributes = resolveAttributes(datadogContext, attributes, bundleWithTraces, threadName, bundleWithRum);
        synchronized (this.simpleDateFormat) {
            formattedDate = this.simpleDateFormat.format(new Date(serverTimeOffsetMs));
        }
        DeviceInfo deviceInfo = datadogContext.getDeviceInfo();
        Set<String> setResolveTags = resolveTags(datadogContext, tags);
        LogEvent.Usr usrResolveUserInfo = resolveUserInfo(datadogContext, userInfo);
        LogEvent.Account accountResolveAccountInfo = resolveAccountInfo(datadogContext, accountInfo);
        LogEvent.Network networkResolveNetworkInfo = (networkInfo != null || attachNetworkInfo) ? resolveNetworkInfo(datadogContext, networkInfo) : null;
        LogEvent.Logger logger = new LogEvent.Logger(loggerName, threadName, datadogContext.getSdkVersion());
        String service = this.serviceName;
        if (service == null) {
            service = datadogContext.getService();
        }
        String str = service;
        LogEvent.Status statusResolveLogLevelStatus = resolveLogLevelStatus(level);
        String appBuildId = datadogContext.getAppBuildId();
        LogEvent.Dd dd = new LogEvent.Dd(new LogEvent.DdDevice(deviceInfo.getArchitecture()));
        String strJoinToString$default = CollectionsKt.joinToString$default(setResolveTags, WebViewLogEventConsumer.DDTAGS_SEPARATOR, null, null, 0, null, null, 62, null);
        LogEvent.Os osResolveOsInfo = resolveOsInfo(deviceInfo);
        LogEvent.LogEventDevice logEventDeviceResolveDeviceInfo = resolveDeviceInfo(deviceInfo);
        String strValueOf = String.valueOf(datadogContext.getVersionCode());
        Intrinsics.checkNotNullExpressionValue(formattedDate, "formattedDate");
        return new LogEvent(logEventDeviceResolveDeviceInfo, osResolveOsInfo, statusResolveLogLevelStatus, str, message, formattedDate, logger, dd, usrResolveUserInfo, accountResolveAccountInfo, networkResolveNetworkInfo, error, appBuildId, strValueOf, strJoinToString$default, mapResolveAttributes);
    }

    private final LogEvent.Os resolveOsInfo(DeviceInfo deviceInfo) {
        return new LogEvent.Os(deviceInfo.getOsName(), deviceInfo.getOsVersion(), null, deviceInfo.getOsMajorVersion(), 4, null);
    }

    private final LogEvent.LogEventDevice resolveDeviceInfo(DeviceInfo deviceInfo) {
        return new LogEvent.LogEventDevice(resolveDeviceType(deviceInfo.getDeviceType()), deviceInfo.getDeviceName(), deviceInfo.getDeviceModel(), deviceInfo.getDeviceBrand(), deviceInfo.getArchitecture(), null, null, null, null, null, null, Integer.valueOf(deviceInfo.getLogicalCpuCount()), deviceInfo.getTotalRam(), deviceInfo.isLowRam(), 2016, null);
    }

    private final LogEvent.Type resolveDeviceType(DeviceType deviceType) {
        switch (WhenMappings.$EnumSwitchMapping$0[deviceType.ordinal()]) {
            case 1:
                return LogEvent.Type.MOBILE;
            case 2:
                return LogEvent.Type.TABLET;
            case 3:
                return LogEvent.Type.TV;
            case 4:
                return LogEvent.Type.DESKTOP;
            case 5:
                return LogEvent.Type.GAMING_CONSOLE;
            case 6:
                return LogEvent.Type.BOT;
            case 7:
                return LogEvent.Type.OTHER;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final String envTag(DatadogContext datadogContext) {
        String env = datadogContext.getEnv();
        if (env.length() <= 0) {
            return null;
        }
        return "env:" + env;
    }

    private final String appVersionTag(DatadogContext datadogContext) {
        String version = datadogContext.getVersion();
        if (version.length() <= 0) {
            return null;
        }
        return "version:" + version;
    }

    private final String variantTag(DatadogContext datadogContext) {
        String variant = datadogContext.getVariant();
        if (variant.length() <= 0) {
            return null;
        }
        return "variant:" + variant;
    }

    private final String serviceTag(DatadogContext datadogContext) {
        String service = this.serviceName;
        if (service == null) {
            service = datadogContext.getService();
        }
        if (service.length() <= 0) {
            return null;
        }
        return "service:" + service;
    }

    private final LogEvent.Network resolveNetworkInfo(DatadogContext datadogContext, NetworkInfo networkInfo) {
        if (networkInfo == null) {
            networkInfo = datadogContext.getNetworkInfo();
        }
        LogEvent.SimCarrier simCarrierResolveSimCarrier = resolveSimCarrier(networkInfo);
        Long strength = networkInfo.getStrength();
        String string = strength != null ? strength.toString() : null;
        Long downKbps = networkInfo.getDownKbps();
        String string2 = downKbps != null ? downKbps.toString() : null;
        Long upKbps = networkInfo.getUpKbps();
        return new LogEvent.Network(new LogEvent.Client(simCarrierResolveSimCarrier, string, string2, upKbps != null ? upKbps.toString() : null, networkInfo.getConnectivity().toString()));
    }

    private final LogEvent.Usr resolveUserInfo(DatadogContext datadogContext, UserInfo userInfo) {
        if (userInfo == null) {
            userInfo = datadogContext.getUserInfo();
        }
        return new LogEvent.Usr(userInfo.getAnonymousId(), userInfo.getId(), userInfo.getName(), userInfo.getEmail(), MapsKt.toMutableMap(userInfo.getAdditionalProperties()));
    }

    private final LogEvent.Account resolveAccountInfo(DatadogContext datadogContext, AccountInfo accountInfo) {
        if (accountInfo == null) {
            accountInfo = datadogContext.getAccountInfo();
        }
        if (accountInfo != null) {
            return new LogEvent.Account(accountInfo.getId(), accountInfo.getName(), MapsKt.toMutableMap(accountInfo.getExtraInfo()));
        }
        return null;
    }

    private final Set<String> resolveTags(DatadogContext datadogContext, Set<String> tags) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : tags) {
            final String str = (String) obj;
            String str2 = (String) CollectionsKt.firstOrNull(StringsKt.split$default((CharSequence) str, new String[]{ServerSentEventKt.COLON}, false, 0, 6, (Object) null));
            if (str2 != null && RESERVED_TAG_KEYS.contains(str2)) {
                InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.WARN, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.log.internal.domain.DatadogLogGenerator$resolveTags$combinedTags$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        String str3 = String.format(Locale.US, DatadogLogGenerator.RESERVED_TAG_DROPPED_WARNING, Arrays.copyOf(new Object[]{str}, 1));
                        Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                        return str3;
                    }
                }, (Throwable) null, true, (Map) null, 40, (Object) null);
            } else {
                arrayList.add(obj);
            }
        }
        Set<String> mutableSet = CollectionsKt.toMutableSet(arrayList);
        String strEnvTag = envTag(datadogContext);
        if (strEnvTag != null) {
            mutableSet.add(strEnvTag);
        }
        String strAppVersionTag = appVersionTag(datadogContext);
        if (strAppVersionTag != null) {
            mutableSet.add(strAppVersionTag);
        }
        String strVariantTag = variantTag(datadogContext);
        if (strVariantTag != null) {
            mutableSet.add(strVariantTag);
        }
        String strServiceTag = serviceTag(datadogContext);
        if (strServiceTag != null) {
            mutableSet.add(strServiceTag);
        }
        return mutableSet;
    }

    private final Map<String, Object> resolveAttributes(DatadogContext datadogContext, Map<String, ? extends Object> attributes, boolean bundleWithTraces, String threadName, boolean bundleWithRum) {
        Map<String, Object> map;
        Map<String, Object> map2;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(attributes);
        if (bundleWithTraces && (map2 = datadogContext.getFeaturesContext().get("tracing")) != null) {
            Object obj = map2.get("context@" + threadName);
            Map map3 = obj instanceof Map ? (Map) obj : null;
            if (map3 != null) {
                linkedHashMap.put(LogAttributes.DD_TRACE_ID, map3.get("trace_id"));
                linkedHashMap.put(LogAttributes.DD_SPAN_ID, map3.get("span_id"));
            }
        }
        if (bundleWithRum && (map = datadogContext.getFeaturesContext().get("rum")) != null) {
            linkedHashMap.put("application_id", map.get("application_id"));
            linkedHashMap.put("session_id", map.get("session_id"));
            linkedHashMap.put(LogAttributes.RUM_VIEW_ID, map.get("view_id"));
            linkedHashMap.put(LogAttributes.RUM_ACTION_ID, map.get(RumContext.ACTION_ID));
        }
        return linkedHashMap;
    }

    private final LogEvent.Status resolveLogLevelStatus(int level) {
        switch (level) {
            case 2:
                return LogEvent.Status.TRACE;
            case 3:
                return LogEvent.Status.DEBUG;
            case 4:
                return LogEvent.Status.INFO;
            case 5:
                return LogEvent.Status.WARN;
            case 6:
                return LogEvent.Status.ERROR;
            case 7:
                return LogEvent.Status.CRITICAL;
            case 8:
            default:
                return LogEvent.Status.DEBUG;
            case 9:
                return LogEvent.Status.EMERGENCY;
        }
    }

    private final LogEvent.SimCarrier resolveSimCarrier(NetworkInfo networkInfo) {
        if (networkInfo.getCarrierId() == null && networkInfo.getCarrierName() == null) {
            return null;
        }
        Long carrierId = networkInfo.getCarrierId();
        return new LogEvent.SimCarrier(carrierId != null ? carrierId.toString() : null, networkInfo.getCarrierName());
    }

    /* JADX INFO: compiled from: DatadogLogGenerator.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/datadog/android/log/internal/domain/DatadogLogGenerator$Companion;", "", "()V", "CRASH", "", "ISO_8601", "", "RESERVED_TAG_DROPPED_WARNING", "RESERVED_TAG_KEYS", "", "getRESERVED_TAG_KEYS$dd_sdk_android_logs_release", "()Ljava/util/Set;", "dd-sdk-android-logs_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Set<String> getRESERVED_TAG_KEYS$dd_sdk_android_logs_release() {
            return DatadogLogGenerator.RESERVED_TAG_KEYS;
        }
    }
}
