package com.datadog.android.log;

import com.datadog.android.Datadog;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.SdkCore;
import com.datadog.android.api.feature.FeatureScope;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.api.storage.DataWriter;
import com.datadog.android.core.sampling.RateBasedSampler;
import com.datadog.android.internal.utils.MapUtilsKt;
import com.datadog.android.log.internal.LogsFeature;
import com.datadog.android.log.internal.domain.DatadogLogGenerator;
import com.datadog.android.log.internal.logger.CombinedLogHandler;
import com.datadog.android.log.internal.logger.DatadogLogHandler;
import com.datadog.android.log.internal.logger.LogHandler;
import com.datadog.android.log.internal.logger.LogcatLogHandler;
import com.datadog.android.log.internal.logger.NoOpLogHandler;
import com.datadog.android.log.model.LogEvent;
import com.datadog.android.rum.internal.RumFeature;
import com.facebook.common.callercontext.ContextChain;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.useinsider.insiderhybrid.constants.InsiderHybridMethods;
import io.ktor.sse.ServerSentEventKt;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: Logger.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u0003\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 72\u00020\u0001:\u000267B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001J\u000e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0007J\u0016\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0007H\u0002J4\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00072\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001aH\u0007J4\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00072\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001aH\u0007J4\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00072\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001aH\u0007J]\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0017\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010\u00072\b\u0010!\u001a\u0004\u0018\u00010\u00072\b\u0010\"\u001a\u0004\u0018\u00010\u00072\u0014\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001a2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%H\u0002¢\u0006\u0002\u0010&JK\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0017\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0014\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001a2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%H\u0000¢\u0006\u0004\b'\u0010(JN\u0010)\u001a\u00020\u00102\u0006\u0010*\u001a\u00020\u001f2\u0006\u0010\u0017\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010\u00072\b\u0010!\u001a\u0004\u0018\u00010\u00072\b\u0010\"\u001a\u0004\u0018\u00010\u00072\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001aH\u0007J<\u0010)\u001a\u00020\u00102\u0006\u0010*\u001a\u00020\u001f2\u0006\u0010\u0017\u001a\u00020\u00072\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001aH\u0007J\u000e\u0010+\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0007J\u000e\u0010,\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0007J\u0010\u0010-\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0007H\u0002J\u000e\u0010.\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0007J\u001c\u0010/\u001a\u00020\u00102\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020201H\u0002J4\u00103\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00072\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001aH\u0007J4\u00104\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00072\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001aH\u0007J4\u00105\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00072\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001aH\u0007R\u001c\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0004R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u00068"}, d2 = {"Lcom/datadog/android/log/Logger;", "", "handler", "Lcom/datadog/android/log/internal/logger/LogHandler;", "(Lcom/datadog/android/log/internal/logger/LogHandler;)V", RumFeature.EVENT_ATTRIBUTES_PROPERTY, "Ljava/util/concurrent/ConcurrentHashMap;", "", "getHandler$dd_sdk_android_logs_release", "()Lcom/datadog/android/log/internal/logger/LogHandler;", "setHandler$dd_sdk_android_logs_release", "tags", "Ljava/util/concurrent/CopyOnWriteArraySet;", "getTags$dd_sdk_android_logs_release", "()Ljava/util/concurrent/CopyOnWriteArraySet;", "addAttribute", "", "key", "value", "addTag", "tag", "addTagInternal", "d", "message", RumFeature.EVENT_THROWABLE_PROPERTY, "", "", "e", ContextChain.TAG_INFRA, "internalLog", FirebaseAnalytics.Param.LEVEL, "", "errorKind", "errorMessage", "errorStacktrace", "localAttributes", "timestamp", "", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/Long;)V", "internalLog$dd_sdk_android_logs_release", "(ILjava/lang/String;Ljava/lang/Throwable;Ljava/util/Map;Ljava/lang/Long;)V", "log", "priority", "removeAttribute", "removeTag", "removeTagInternal", "removeTagsWithKey", "safelyRemoveTagsWithKey", "keyFilter", "Lkotlin/Function1;", "", "v", "w", "wtf", "Builder", "Companion", "dd-sdk-android-logs_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Logger {
    public static final float DEFAULT_SAMPLE_RATE = 100.0f;
    public static final String SDK_NOT_INITIALIZED_WARNING_MESSAGE = "You're trying to create a Logger instance, but the SDK was not yet initialized. This Logger will not be able to send any messages. Please initialize the Datadog SDK first before creating a new Logger instance.";
    private final ConcurrentHashMap<String, Object> attributes;
    private LogHandler handler;
    private final CopyOnWriteArraySet<String> tags;

    public final void d(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        d$default(this, message, null, null, 6, null);
    }

    public final void d(String message, Throwable th) {
        Intrinsics.checkNotNullParameter(message, "message");
        d$default(this, message, th, null, 4, null);
    }

    public final void e(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        e$default(this, message, null, null, 6, null);
    }

    public final void e(String message, Throwable th) {
        Intrinsics.checkNotNullParameter(message, "message");
        e$default(this, message, th, null, 4, null);
    }

    public final void i(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        i$default(this, message, null, null, 6, null);
    }

    public final void i(String message, Throwable th) {
        Intrinsics.checkNotNullParameter(message, "message");
        i$default(this, message, th, null, 4, null);
    }

    public final void log(int i, String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        log$default(this, i, message, null, null, 12, null);
    }

    public final void log(int i, String message, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(message, "message");
        log$default(this, i, message, str, str2, str3, null, 32, null);
    }

    public final void log(int i, String message, Throwable th) {
        Intrinsics.checkNotNullParameter(message, "message");
        log$default(this, i, message, th, null, 8, null);
    }

    public final void v(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        v$default(this, message, null, null, 6, null);
    }

    public final void v(String message, Throwable th) {
        Intrinsics.checkNotNullParameter(message, "message");
        v$default(this, message, th, null, 4, null);
    }

    public final void w(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        w$default(this, message, null, null, 6, null);
    }

    public final void w(String message, Throwable th) {
        Intrinsics.checkNotNullParameter(message, "message");
        w$default(this, message, th, null, 4, null);
    }

    public final void wtf(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        wtf$default(this, message, null, null, 6, null);
    }

    public final void wtf(String message, Throwable th) {
        Intrinsics.checkNotNullParameter(message, "message");
        wtf$default(this, message, th, null, 4, null);
    }

    public Logger(LogHandler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.handler = handler;
        this.attributes = new ConcurrentHashMap<>();
        this.tags = new CopyOnWriteArraySet<>();
    }

    /* JADX INFO: renamed from: getHandler$dd_sdk_android_logs_release, reason: from getter */
    public final LogHandler getHandler() {
        return this.handler;
    }

    public final void setHandler$dd_sdk_android_logs_release(LogHandler logHandler) {
        Intrinsics.checkNotNullParameter(logHandler, "<set-?>");
        this.handler = logHandler;
    }

    public final CopyOnWriteArraySet<String> getTags$dd_sdk_android_logs_release() {
        return this.tags;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void v$default(Logger logger, String str, Throwable th, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        if ((i & 4) != 0) {
            map = MapsKt.emptyMap();
        }
        logger.v(str, th, map);
    }

    public final void v(String message, Throwable throwable, Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        internalLog$dd_sdk_android_logs_release$default(this, 2, message, throwable, attributes, null, 16, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void d$default(Logger logger, String str, Throwable th, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        if ((i & 4) != 0) {
            map = MapsKt.emptyMap();
        }
        logger.d(str, th, map);
    }

    public final void d(String message, Throwable throwable, Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        internalLog$dd_sdk_android_logs_release$default(this, 3, message, throwable, attributes, null, 16, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void i$default(Logger logger, String str, Throwable th, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        if ((i & 4) != 0) {
            map = MapsKt.emptyMap();
        }
        logger.i(str, th, map);
    }

    public final void i(String message, Throwable throwable, Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        internalLog$dd_sdk_android_logs_release$default(this, 4, message, throwable, attributes, null, 16, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void w$default(Logger logger, String str, Throwable th, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        if ((i & 4) != 0) {
            map = MapsKt.emptyMap();
        }
        logger.w(str, th, map);
    }

    public final void w(String message, Throwable throwable, Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        internalLog$dd_sdk_android_logs_release$default(this, 5, message, throwable, attributes, null, 16, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void e$default(Logger logger, String str, Throwable th, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        if ((i & 4) != 0) {
            map = MapsKt.emptyMap();
        }
        logger.e(str, th, map);
    }

    public final void e(String message, Throwable throwable, Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        internalLog$dd_sdk_android_logs_release$default(this, 6, message, throwable, attributes, null, 16, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void wtf$default(Logger logger, String str, Throwable th, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        if ((i & 4) != 0) {
            map = MapsKt.emptyMap();
        }
        logger.wtf(str, th, map);
    }

    public final void wtf(String message, Throwable throwable, Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        internalLog$dd_sdk_android_logs_release$default(this, 7, message, throwable, attributes, null, 16, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void log$default(Logger logger, int i, String str, Throwable th, Map map, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            th = null;
        }
        if ((i2 & 8) != 0) {
            map = MapsKt.emptyMap();
        }
        logger.log(i, str, th, map);
    }

    public final void log(int priority, String message, Throwable throwable, Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        internalLog$dd_sdk_android_logs_release$default(this, priority, message, throwable, attributes, null, 16, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void log$default(Logger logger, int i, String str, String str2, String str3, String str4, Map map, int i2, Object obj) {
        if ((i2 & 32) != 0) {
            map = MapsKt.emptyMap();
        }
        logger.log(i, str, str2, str3, str4, map);
    }

    public final void log(int priority, String message, String errorKind, String errorMessage, String errorStacktrace, Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        internalLog$default(this, priority, message, errorKind, errorMessage, errorStacktrace, attributes, null, 64, null);
    }

    /* JADX INFO: compiled from: Logger.kt */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0012\u001a\u00020\u0013J\u001a\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J\u0012\u0010\u0018\u001a\u00020\u00152\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0002J\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0006J\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0006J\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0006J\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\nJ\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0006J\u000e\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\fJ\u0010\u0010\"\u001a\u00020\u00002\b\b\u0001\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/datadog/android/log/Logger$Builder;", "", "sdkCore", "Lcom/datadog/android/api/SdkCore;", "(Lcom/datadog/android/api/SdkCore;)V", "bundleWithRumEnabled", "", "bundleWithTraceEnabled", "logcatLogsEnabled", "loggerName", "", "minDatadogLogsPriority", "", "networkInfoEnabled", "sampleRate", "", "Lcom/datadog/android/api/feature/FeatureSdkCore;", "serviceName", "build", "Lcom/datadog/android/log/Logger;", "buildDatadogHandler", "Lcom/datadog/android/log/internal/logger/LogHandler;", "logsFeature", "Lcom/datadog/android/log/internal/LogsFeature;", "buildLogcatHandler", "setBundleWithRumEnabled", "enabled", "setBundleWithTraceEnabled", "setLogcatLogsEnabled", InsiderHybridMethods.SET_NAME, "name", "setNetworkInfoEnabled", "setRemoteLogThreshold", "minLogThreshold", "setRemoteSampleRate", "setService", "service", "dd-sdk-android-logs_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Builder {
        private boolean bundleWithRumEnabled;
        private boolean bundleWithTraceEnabled;
        private boolean logcatLogsEnabled;
        private String loggerName;
        private int minDatadogLogsPriority;
        private boolean networkInfoEnabled;
        private float sampleRate;
        private final FeatureSdkCore sdkCore;
        private String serviceName;

        /* JADX WARN: Multi-variable type inference failed */
        public Builder() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public Builder(SdkCore sdkCore) {
            Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
            this.sdkCore = (FeatureSdkCore) sdkCore;
            this.bundleWithTraceEnabled = true;
            this.bundleWithRumEnabled = true;
            this.sampleRate = 100.0f;
            this.minDatadogLogsPriority = -1;
        }

        public /* synthetic */ Builder(SdkCore sdkCore, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? Datadog.getInstance$default(null, 1, null) : sdkCore);
        }

        public final Logger build() {
            NoOpLogHandler noOpLogHandlerBuildLogcatHandler;
            FeatureScope feature = this.sdkCore.getFeature("logs");
            LogsFeature logsFeature = feature != null ? (LogsFeature) feature.unwrap() : null;
            boolean z = this.sampleRate > 0.0f;
            if (z && this.logcatLogsEnabled) {
                noOpLogHandlerBuildLogcatHandler = new CombinedLogHandler(buildDatadogHandler(this.sdkCore, logsFeature), buildLogcatHandler(this.sdkCore));
            } else if (z) {
                noOpLogHandlerBuildLogcatHandler = buildDatadogHandler(this.sdkCore, logsFeature);
            } else {
                noOpLogHandlerBuildLogcatHandler = this.logcatLogsEnabled ? buildLogcatHandler(this.sdkCore) : new NoOpLogHandler();
            }
            return new Logger(noOpLogHandlerBuildLogcatHandler);
        }

        public final Builder setService(String service) {
            Intrinsics.checkNotNullParameter(service, "service");
            this.serviceName = service;
            return this;
        }

        public final Builder setRemoteLogThreshold(int minLogThreshold) {
            this.minDatadogLogsPriority = minLogThreshold;
            return this;
        }

        public final Builder setLogcatLogsEnabled(boolean enabled) {
            this.logcatLogsEnabled = enabled;
            return this;
        }

        public final Builder setNetworkInfoEnabled(boolean enabled) {
            this.networkInfoEnabled = enabled;
            return this;
        }

        public final Builder setName(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            this.loggerName = name;
            return this;
        }

        public final Builder setBundleWithTraceEnabled(boolean enabled) {
            this.bundleWithTraceEnabled = enabled;
            return this;
        }

        public final Builder setBundleWithRumEnabled(boolean enabled) {
            this.bundleWithRumEnabled = enabled;
            return this;
        }

        public final Builder setRemoteSampleRate(float sampleRate) {
            this.sampleRate = sampleRate;
            return this;
        }

        private final LogHandler buildLogcatHandler(SdkCore sdkCore) {
            String service = this.serviceName;
            if (service == null) {
                service = sdkCore != null ? sdkCore.getService() : null;
                if (service == null) {
                    service = "unknown";
                }
            }
            return new LogcatLogHandler(service, true, false, 4, null);
        }

        private final LogHandler buildDatadogHandler(FeatureSdkCore sdkCore, LogsFeature logsFeature) {
            if (logsFeature == null) {
                InternalLogger.DefaultImpls.log$default(sdkCore.getInternalLogger(), InternalLogger.Level.ERROR, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.log.Logger$Builder$buildDatadogHandler$1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return Logger.SDK_NOT_INITIALIZED_WARNING_MESSAGE;
                    }
                }, (Throwable) null, false, (Map) null, 56, (Object) null);
                return new NoOpLogHandler();
            }
            String packageName$dd_sdk_android_logs_release = this.loggerName;
            if (packageName$dd_sdk_android_logs_release == null) {
                packageName$dd_sdk_android_logs_release = logsFeature.getPackageName();
            }
            String str = packageName$dd_sdk_android_logs_release;
            String service = this.serviceName;
            if (service == null) {
                service = sdkCore.getService();
            }
            DatadogLogGenerator datadogLogGenerator = new DatadogLogGenerator(service, sdkCore.getInternalLogger());
            DataWriter<LogEvent> dataWriter$dd_sdk_android_logs_release = logsFeature.getDataWriter$dd_sdk_android_logs_release();
            int i = this.minDatadogLogsPriority;
            return new DatadogLogHandler(str, datadogLogGenerator, sdkCore, dataWriter$dd_sdk_android_logs_release, this.networkInfoEnabled, this.bundleWithTraceEnabled, this.bundleWithRumEnabled, new RateBasedSampler(this.sampleRate), i);
        }
    }

    public final void addAttribute(String key, Object value) {
        Intrinsics.checkNotNullParameter(key, "key");
        ConcurrentHashMap<String, Object> concurrentHashMap = this.attributes;
        if (value == null) {
            concurrentHashMap.put(key, MapUtilsKt.getNULL_MAP_VALUE());
        } else {
            concurrentHashMap.put(key, value);
        }
    }

    public final void removeAttribute(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.attributes.remove(key);
    }

    public final void addTag(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        addTagInternal(key + ServerSentEventKt.COLON + value);
    }

    public final void addTag(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        addTagInternal(tag);
    }

    public final void removeTag(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        removeTagInternal(tag);
    }

    public final void removeTagsWithKey(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        final String str = key + ServerSentEventKt.COLON;
        safelyRemoveTagsWithKey(new Function1<String, Boolean>() { // from class: com.datadog.android.log.Logger.removeTagsWithKey.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(StringsKt.startsWith$default(it, str, false, 2, (Object) null));
            }
        });
    }

    public static /* synthetic */ void internalLog$dd_sdk_android_logs_release$default(Logger logger, int i, String str, Throwable th, Map map, Long l, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            l = null;
        }
        logger.internalLog$dd_sdk_android_logs_release(i, str, th, map, l);
    }

    public final void internalLog$dd_sdk_android_logs_release(int level, String message, Throwable throwable, Map<String, ? extends Object> localAttributes, Long timestamp) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(localAttributes, "localAttributes");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(this.attributes);
        linkedHashMap.putAll(localAttributes);
        this.handler.handleLog(level, message, throwable, linkedHashMap, new HashSet(this.tags), timestamp);
    }

    static /* synthetic */ void internalLog$default(Logger logger, int i, String str, String str2, String str3, String str4, Map map, Long l, int i2, Object obj) {
        logger.internalLog(i, str, str2, str3, str4, map, (i2 & 64) != 0 ? null : l);
    }

    private final void internalLog(int level, String message, String errorKind, String errorMessage, String errorStacktrace, Map<String, ? extends Object> localAttributes, Long timestamp) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(this.attributes);
        linkedHashMap.putAll(localAttributes);
        this.handler.handleLog(level, message, errorKind, errorMessage, errorStacktrace, linkedHashMap, new HashSet(this.tags), timestamp);
    }

    private final void addTagInternal(String tag) {
        this.tags.add(tag);
    }

    private final void removeTagInternal(String tag) {
        this.tags.remove(tag);
    }

    private final void safelyRemoveTagsWithKey(Function1<? super String, Boolean> keyFilter) {
        Object[] array = this.tags.toArray(new String[0]);
        ArrayList arrayList = new ArrayList();
        for (Object obj : array) {
            if (keyFilter.invoke(obj).booleanValue()) {
                arrayList.add(obj);
            }
        }
        this.tags.removeAll(arrayList);
    }
}
