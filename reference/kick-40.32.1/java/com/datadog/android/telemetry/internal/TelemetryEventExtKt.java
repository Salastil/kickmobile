package com.datadog.android.telemetry.internal;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.telemetry.model.TelemetryConfigurationEvent;
import com.datadog.android.telemetry.model.TelemetryDebugEvent;
import com.datadog.android.telemetry.model.TelemetryErrorEvent;
import com.datadog.android.telemetry.model.TelemetryUsageEvent;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TelemetryEventExt.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a\u001e\u0010\u0002\u001a\u0004\u0018\u00010\b*\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a\u001e\u0010\u0002\u001a\u0004\u0018\u00010\n*\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a\u001e\u0010\u0002\u001a\u0004\u0018\u00010\f*\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"UNKNOWN_SOURCE_WARNING_MESSAGE_FORMAT", "", "tryFromSource", "Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$Source;", "Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$Source$Companion;", "source", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "Lcom/datadog/android/telemetry/model/TelemetryDebugEvent$Source;", "Lcom/datadog/android/telemetry/model/TelemetryDebugEvent$Source$Companion;", "Lcom/datadog/android/telemetry/model/TelemetryErrorEvent$Source;", "Lcom/datadog/android/telemetry/model/TelemetryErrorEvent$Source$Companion;", "Lcom/datadog/android/telemetry/model/TelemetryUsageEvent$Source;", "Lcom/datadog/android/telemetry/model/TelemetryUsageEvent$Source$Companion;", "dd-sdk-android-rum_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TelemetryEventExtKt {
    public static final String UNKNOWN_SOURCE_WARNING_MESSAGE_FORMAT = "You are using an unknown source %s for your events";

    public static final TelemetryDebugEvent.Source tryFromSource(TelemetryDebugEvent.Source.Companion companion, final String source, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        try {
            return companion.fromJson(source);
        } catch (NoSuchElementException e) {
            InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.telemetry.internal.TelemetryEventExtKt.tryFromSource.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str = String.format(Locale.US, "You are using an unknown source %s for your events", Arrays.copyOf(new Object[]{source}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
            return null;
        }
    }

    public static final TelemetryErrorEvent.Source tryFromSource(TelemetryErrorEvent.Source.Companion companion, final String source, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        try {
            return companion.fromJson(source);
        } catch (NoSuchElementException e) {
            InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.telemetry.internal.TelemetryEventExtKt.tryFromSource.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str = String.format(Locale.US, "You are using an unknown source %s for your events", Arrays.copyOf(new Object[]{source}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
            return null;
        }
    }

    public static final TelemetryUsageEvent.Source tryFromSource(TelemetryUsageEvent.Source.Companion companion, final String source, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        try {
            return companion.fromJson(source);
        } catch (NoSuchElementException e) {
            InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.telemetry.internal.TelemetryEventExtKt.tryFromSource.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str = String.format(Locale.US, "You are using an unknown source %s for your events", Arrays.copyOf(new Object[]{source}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
            return null;
        }
    }

    public static final TelemetryConfigurationEvent.Source tryFromSource(TelemetryConfigurationEvent.Source.Companion companion, final String source, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        try {
            return companion.fromJson(source);
        } catch (NoSuchElementException e) {
            InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.telemetry.internal.TelemetryEventExtKt.tryFromSource.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str = String.format(Locale.US, "You are using an unknown source %s for your events", Arrays.copyOf(new Object[]{source}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
            return null;
        }
    }
}
