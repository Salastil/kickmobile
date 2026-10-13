package com.datadog.android.log.internal.logger;

import android.util.Log;
import com.datadog.android.log.Logger;
import com.datadog.android.rum.internal.RumFeature;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.ktor.sse.ServerSentEventKt;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.apache.commons.io.FilenameUtils;

/* JADX INFO: compiled from: LogcatLogHandler.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0006\b\u0000\u0018\u0000 +2\u00020\u0001:\u0001+B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u001f\u0010\r\u001a\u0004\u0018\u00010\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010H\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u0004\u0018\u00010\u000eH\u0000¢\u0006\u0002\b\u0014Ji\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u00032\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u001e2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016¢\u0006\u0002\u0010$JU\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00032\b\u0010%\u001a\u0004\u0018\u00010&2\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u001e2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016¢\u0006\u0002\u0010'J\u0012\u0010(\u001a\u00020\u00032\b\u0010)\u001a\u0004\u0018\u00010\u000eH\u0002J\u0012\u0010*\u001a\u00020\u00032\b\u0010)\u001a\u0004\u0018\u00010\u000eH\u0002R\u0014\u0010\u0006\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006,"}, d2 = {"Lcom/datadog/android/log/internal/logger/LogcatLogHandler;", "Lcom/datadog/android/log/internal/logger/LogHandler;", "serviceName", "", "useClassnameAsTag", "", "isDebug", "(Ljava/lang/String;ZZ)V", "isDebug$dd_sdk_android_logs_release", "()Z", "getServiceName$dd_sdk_android_logs_release", "()Ljava/lang/String;", "getUseClassnameAsTag$dd_sdk_android_logs_release", "findValidCallStackElement", "Ljava/lang/StackTraceElement;", "stackTrace", "", "findValidCallStackElement$dd_sdk_android_logs_release", "([Ljava/lang/StackTraceElement;)Ljava/lang/StackTraceElement;", "getCallerStackElement", "getCallerStackElement$dd_sdk_android_logs_release", "handleLog", "", FirebaseAnalytics.Param.LEVEL, "", "message", "errorKind", "errorMessage", "errorStacktrace", RumFeature.EVENT_ATTRIBUTES_PROPERTY, "", "", "tags", "", "timestamp", "", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Set;Ljava/lang/Long;)V", RumFeature.EVENT_THROWABLE_PROPERTY, "", "(ILjava/lang/String;Ljava/lang/Throwable;Ljava/util/Map;Ljava/util/Set;Ljava/lang/Long;)V", "resolveSuffix", "stackTraceElement", "resolveTag", "Companion", "dd-sdk-android-logs_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LogcatLogHandler implements LogHandler {
    private static final String[] IGNORED_CLASS_NAMES;
    private static final String[] IGNORED_PACKAGE_PREFIXES;
    private static final int MAX_TAG_LENGTH = 23;
    private final boolean isDebug;
    private final String serviceName;
    private final boolean useClassnameAsTag;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(0 == true ? 1 : 0);
    private static final Regex ANONYMOUS_CLASS = new Regex("(\\$\\d+)+$");

    public LogcatLogHandler(String serviceName, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(serviceName, "serviceName");
        this.serviceName = serviceName;
        this.useClassnameAsTag = z;
        this.isDebug = z2;
    }

    public /* synthetic */ LogcatLogHandler(String str, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z, (i & 4) != 0 ? false : z2);
    }

    /* JADX INFO: renamed from: getServiceName$dd_sdk_android_logs_release, reason: from getter */
    public final String getServiceName() {
        return this.serviceName;
    }

    /* JADX INFO: renamed from: getUseClassnameAsTag$dd_sdk_android_logs_release, reason: from getter */
    public final boolean getUseClassnameAsTag() {
        return this.useClassnameAsTag;
    }

    /* JADX INFO: renamed from: isDebug$dd_sdk_android_logs_release, reason: from getter */
    public final boolean getIsDebug() {
        return this.isDebug;
    }

    @Override // com.datadog.android.log.internal.logger.LogHandler
    public void handleLog(int level, String message, Throwable throwable, Map<String, ? extends Object> attributes, Set<String> tags, Long timestamp) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(tags, "tags");
        StackTraceElement callerStackElement$dd_sdk_android_logs_release = getCallerStackElement$dd_sdk_android_logs_release();
        String strResolveTag = resolveTag(callerStackElement$dd_sdk_android_logs_release);
        Log.println(level, strResolveTag, message + resolveSuffix(callerStackElement$dd_sdk_android_logs_release));
        if (throwable != null) {
            Log.println(level, strResolveTag, Log.getStackTraceString(throwable));
        }
    }

    @Override // com.datadog.android.log.internal.logger.LogHandler
    public void handleLog(int level, String message, String errorKind, String errorMessage, String errorStacktrace, Map<String, ? extends Object> attributes, Set<String> tags, Long timestamp) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(tags, "tags");
        StackTraceElement callerStackElement$dd_sdk_android_logs_release = getCallerStackElement$dd_sdk_android_logs_release();
        String strResolveTag = resolveTag(callerStackElement$dd_sdk_android_logs_release);
        Log.println(level, strResolveTag, message + resolveSuffix(callerStackElement$dd_sdk_android_logs_release));
        if (errorStacktrace != null) {
            Log.println(level, strResolveTag, errorStacktrace);
        }
    }

    private final String resolveTag(StackTraceElement stackTraceElement) {
        String strSubstringAfterLast$default;
        if (stackTraceElement == null) {
            strSubstringAfterLast$default = this.serviceName;
        } else {
            String className = stackTraceElement.getClassName();
            Intrinsics.checkNotNullExpressionValue(className, "stackTraceElement.className");
            strSubstringAfterLast$default = StringsKt.substringAfterLast$default(ANONYMOUS_CLASS.replace(className, ""), FilenameUtils.EXTENSION_SEPARATOR, (String) null, 2, (Object) null);
        }
        strSubstringAfterLast$default.length();
        return strSubstringAfterLast$default;
    }

    private final String resolveSuffix(StackTraceElement stackTraceElement) {
        if (stackTraceElement == null) {
            return "";
        }
        return "\t| at ." + stackTraceElement.getMethodName() + "(" + stackTraceElement.getFileName() + ServerSentEventKt.COLON + stackTraceElement.getLineNumber() + ")";
    }

    public final StackTraceElement getCallerStackElement$dd_sdk_android_logs_release() {
        if (!this.isDebug || !this.useClassnameAsTag) {
            return null;
        }
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        Intrinsics.checkNotNullExpressionValue(stackTrace, "stackTrace");
        return findValidCallStackElement$dd_sdk_android_logs_release(stackTrace);
    }

    /* JADX INFO: compiled from: LogcatLogHandler.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0080\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0080\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\f\u0010\tR\u000e\u0010\r\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/datadog/android/log/internal/logger/LogcatLogHandler$Companion;", "", "()V", "ANONYMOUS_CLASS", "Lkotlin/text/Regex;", "IGNORED_CLASS_NAMES", "", "", "getIGNORED_CLASS_NAMES$dd_sdk_android_logs_release", "()[Ljava/lang/String;", "[Ljava/lang/String;", "IGNORED_PACKAGE_PREFIXES", "getIGNORED_PACKAGE_PREFIXES$dd_sdk_android_logs_release", "MAX_TAG_LENGTH", "", "dd-sdk-android-logs_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String[] getIGNORED_CLASS_NAMES$dd_sdk_android_logs_release() {
            return LogcatLogHandler.IGNORED_CLASS_NAMES;
        }

        public final String[] getIGNORED_PACKAGE_PREFIXES$dd_sdk_android_logs_release() {
            return LogcatLogHandler.IGNORED_PACKAGE_PREFIXES;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        String str = null;
        String canonicalName = Logger.class.getCanonicalName();
        String canonicalName2 = LogHandler.class.getCanonicalName();
        String canonicalName3 = LogHandler.class.getCanonicalName();
        if (canonicalName3 != null) {
            str = canonicalName3 + "$DefaultImpls";
        }
        IGNORED_CLASS_NAMES = new String[]{canonicalName, canonicalName2, str, LogcatLogHandler.class.getCanonicalName(), ConditionalLogHandler.class.getCanonicalName(), CombinedLogHandler.class.getCanonicalName(), DatadogLogHandler.class.getCanonicalName()};
        IGNORED_PACKAGE_PREFIXES = new String[]{"com.datadog.android.timber", "timber.log"};
    }

    public final StackTraceElement findValidCallStackElement$dd_sdk_android_logs_release(StackTraceElement[] stackTrace) {
        Intrinsics.checkNotNullParameter(stackTrace, "stackTrace");
        for (StackTraceElement stackTraceElement : stackTrace) {
            if (!ArraysKt.contains(IGNORED_CLASS_NAMES, stackTraceElement.getClassName())) {
                for (String str : IGNORED_PACKAGE_PREFIXES) {
                    String className = stackTraceElement.getClassName();
                    Intrinsics.checkNotNullExpressionValue(className, "element.className");
                    if (!StringsKt.startsWith$default(className, str, false, 2, (Object) null)) {
                    }
                }
                return stackTraceElement;
            }
        }
        return null;
    }
}
