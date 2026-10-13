package com.datadog.android.internal.telemetry;

import com.datadog.android.internal.utils.ThrowableExtKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InternalTelemetryEvent.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u0003\u0004\u0005\u0006\u0007\bB\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0006\t\n\u000b\f\r\u000e¨\u0006\u000f"}, d2 = {"Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent;", "", "()V", "ApiUsage", "Configuration", "InterceptorInstantiated", "Log", "Metric", "ResourceHeadersTrackingConfigured", "Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent$ApiUsage;", "Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent$Configuration;", "Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent$InterceptorInstantiated;", "Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent$Log;", "Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent$Metric;", "Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent$ResourceHeadersTrackingConfigured;", "dd-sdk-android-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class InternalTelemetryEvent {
    public /* synthetic */ InternalTelemetryEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private InternalTelemetryEvent() {
    }

    /* JADX INFO: compiled from: InternalTelemetryEvent.kt */
    /* JADX INFO: loaded from: classes5.dex */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\f\rB'\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007R!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u0082\u0001\u0002\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent$Log;", "Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent;", "message", "", "additionalProperties", "", "", "(Ljava/lang/String;Ljava/util/Map;)V", "getAdditionalProperties", "()Ljava/util/Map;", "getMessage", "()Ljava/lang/String;", "Debug", "Error", "Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent$Log$Debug;", "Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent$Log$Error;", "dd-sdk-android-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static abstract class Log extends InternalTelemetryEvent {
        private final Map<String, Object> additionalProperties;
        private final String message;

        public /* synthetic */ Log(String str, Map map, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, map);
        }

        public final String getMessage() {
            return this.message;
        }

        public final Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        /* JADX INFO: compiled from: InternalTelemetryEvent.kt */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent$Log$Debug;", "Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent$Log;", "message", "", "additionalProperties", "", "", "(Ljava/lang/String;Ljava/util/Map;)V", "dd-sdk-android-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Debug extends Log {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Debug(String message, Map<String, ? extends Object> map) {
                super(message, map, null);
                Intrinsics.checkNotNullParameter(message, "message");
            }
        }

        private Log(String str, Map<String, ? extends Object> map) {
            super(null);
            this.message = str;
            this.additionalProperties = map;
        }

        /* JADX INFO: compiled from: InternalTelemetryEvent.kt */
        /* JADX INFO: loaded from: classes6.dex */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u000b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bJ\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003J\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent$Log$Error;", "Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent$Log;", "message", "", "additionalProperties", "", "", "error", "", "stacktrace", "kind", "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V", "getError", "()Ljava/lang/Throwable;", "getKind", "()Ljava/lang/String;", "getStacktrace", "resolveKind", "resolveStacktrace", "dd-sdk-android-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Error extends Log {
            private final Throwable error;
            private final String kind;
            private final String stacktrace;

            public /* synthetic */ Error(String str, Map map, Throwable th, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, (i & 2) != 0 ? null : map, (i & 4) != 0 ? null : th, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3);
            }

            public final Throwable getError() {
                return this.error;
            }

            public final String getStacktrace() {
                return this.stacktrace;
            }

            public final String getKind() {
                return this.kind;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Error(String message, Map<String, ? extends Object> map, Throwable th, String str, String str2) {
                super(message, map, null);
                Intrinsics.checkNotNullParameter(message, "message");
                this.error = th;
                this.stacktrace = str;
                this.kind = str2;
            }

            public final String resolveKind() {
                Class<?> cls;
                Class<?> cls2;
                String canonicalName = this.kind;
                if (canonicalName == null) {
                    Throwable th = this.error;
                    canonicalName = (th == null || (cls2 = th.getClass()) == null) ? null : cls2.getCanonicalName();
                    if (canonicalName == null) {
                        Throwable th2 = this.error;
                        if (th2 == null || (cls = th2.getClass()) == null) {
                            return null;
                        }
                        return cls.getSimpleName();
                    }
                }
                return canonicalName;
            }

            public final String resolveStacktrace() {
                String str = this.stacktrace;
                if (str != null) {
                    return str;
                }
                Throwable th = this.error;
                if (th != null) {
                    return ThrowableExtKt.loggableStackTrace(th);
                }
                return null;
            }
        }
    }

    /* JADX INFO: compiled from: InternalTelemetryEvent.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\nHÆ\u0003JE\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\nHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012¨\u0006\""}, d2 = {"Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent$Configuration;", "Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent;", "trackErrors", "", "batchSize", "", "batchUploadFrequency", "useProxy", "useLocalEncryption", "batchProcessingLevel", "", "(ZJJZZI)V", "getBatchProcessingLevel", "()I", "getBatchSize", "()J", "getBatchUploadFrequency", "getTrackErrors", "()Z", "getUseLocalEncryption", "getUseProxy", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "", "hashCode", "toString", "", "dd-sdk-android-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Configuration extends InternalTelemetryEvent {
        private final int batchProcessingLevel;
        private final long batchSize;
        private final long batchUploadFrequency;
        private final boolean trackErrors;
        private final boolean useLocalEncryption;
        private final boolean useProxy;

        public static /* synthetic */ Configuration copy$default(Configuration configuration, boolean z, long j, long j2, boolean z2, boolean z3, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                z = configuration.trackErrors;
            }
            if ((i2 & 2) != 0) {
                j = configuration.batchSize;
            }
            if ((i2 & 4) != 0) {
                j2 = configuration.batchUploadFrequency;
            }
            if ((i2 & 8) != 0) {
                z2 = configuration.useProxy;
            }
            if ((i2 & 16) != 0) {
                z3 = configuration.useLocalEncryption;
            }
            if ((i2 & 32) != 0) {
                i = configuration.batchProcessingLevel;
            }
            int i3 = i;
            boolean z4 = z2;
            long j3 = j2;
            return configuration.copy(z, j, j3, z4, z3, i3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getTrackErrors() {
            return this.trackErrors;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getBatchSize() {
            return this.batchSize;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final long getBatchUploadFrequency() {
            return this.batchUploadFrequency;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getUseProxy() {
            return this.useProxy;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final boolean getUseLocalEncryption() {
            return this.useLocalEncryption;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final int getBatchProcessingLevel() {
            return this.batchProcessingLevel;
        }

        public final Configuration copy(boolean trackErrors, long batchSize, long batchUploadFrequency, boolean useProxy, boolean useLocalEncryption, int batchProcessingLevel) {
            return new Configuration(trackErrors, batchSize, batchUploadFrequency, useProxy, useLocalEncryption, batchProcessingLevel);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Configuration)) {
                return false;
            }
            Configuration configuration = (Configuration) other;
            return this.trackErrors == configuration.trackErrors && this.batchSize == configuration.batchSize && this.batchUploadFrequency == configuration.batchUploadFrequency && this.useProxy == configuration.useProxy && this.useLocalEncryption == configuration.useLocalEncryption && this.batchProcessingLevel == configuration.batchProcessingLevel;
        }

        public int hashCode() {
            return (((((((((Boolean.hashCode(this.trackErrors) * 31) + Long.hashCode(this.batchSize)) * 31) + Long.hashCode(this.batchUploadFrequency)) * 31) + Boolean.hashCode(this.useProxy)) * 31) + Boolean.hashCode(this.useLocalEncryption)) * 31) + Integer.hashCode(this.batchProcessingLevel);
        }

        public String toString() {
            return "Configuration(trackErrors=" + this.trackErrors + ", batchSize=" + this.batchSize + ", batchUploadFrequency=" + this.batchUploadFrequency + ", useProxy=" + this.useProxy + ", useLocalEncryption=" + this.useLocalEncryption + ", batchProcessingLevel=" + this.batchProcessingLevel + ")";
        }

        public final boolean getTrackErrors() {
            return this.trackErrors;
        }

        public final long getBatchSize() {
            return this.batchSize;
        }

        public final long getBatchUploadFrequency() {
            return this.batchUploadFrequency;
        }

        public final boolean getUseProxy() {
            return this.useProxy;
        }

        public final boolean getUseLocalEncryption() {
            return this.useLocalEncryption;
        }

        public final int getBatchProcessingLevel() {
            return this.batchProcessingLevel;
        }

        public Configuration(boolean z, long j, long j2, boolean z2, boolean z3, int i) {
            super(null);
            this.trackErrors = z;
            this.batchSize = j;
            this.batchUploadFrequency = j2;
            this.useProxy = z2;
            this.useLocalEncryption = z3;
            this.batchProcessingLevel = i;
        }
    }

    /* JADX INFO: compiled from: InternalTelemetryEvent.kt */
    /* JADX INFO: loaded from: classes5.dex */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J-\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent$Metric;", "Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent;", "message", "", "additionalProperties", "", "", "(Ljava/lang/String;Ljava/util/Map;)V", "getAdditionalProperties", "()Ljava/util/Map;", "getMessage", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "dd-sdk-android-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Metric extends InternalTelemetryEvent {
        private final Map<String, Object> additionalProperties;
        private final String message;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Metric copy$default(Metric metric, String str, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                str = metric.message;
            }
            if ((i & 2) != 0) {
                map = metric.additionalProperties;
            }
            return metric.copy(str, map);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final Map<String, Object> component2() {
            return this.additionalProperties;
        }

        public final Metric copy(String message, Map<String, ? extends Object> additionalProperties) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new Metric(message, additionalProperties);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Metric)) {
                return false;
            }
            Metric metric = (Metric) other;
            return Intrinsics.areEqual(this.message, metric.message) && Intrinsics.areEqual(this.additionalProperties, metric.additionalProperties);
        }

        public int hashCode() {
            int iHashCode = this.message.hashCode() * 31;
            Map<String, Object> map = this.additionalProperties;
            return iHashCode + (map == null ? 0 : map.hashCode());
        }

        public String toString() {
            return "Metric(message=" + this.message + ", additionalProperties=" + this.additionalProperties + ")";
        }

        public final String getMessage() {
            return this.message;
        }

        public final Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Metric(String message, Map<String, ? extends Object> map) {
            super(null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
            this.additionalProperties = map;
        }
    }

    /* JADX INFO: compiled from: InternalTelemetryEvent.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\t\n\u000b\f\rB\u001f\b\u0004\u0012\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003¢\u0006\u0002\u0010\u0006R\u001f\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u0082\u0001\u0005\u000e\u000f\u0010\u0011\u0012¨\u0006\u0013"}, d2 = {"Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent$ApiUsage;", "Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent;", "additionalProperties", "", "", "", "(Ljava/util/Map;)V", "getAdditionalProperties", "()Ljava/util/Map;", "AddOperationStepVital", "AddViewLoadingTime", "NetworkInstrumentation", "Timeseries", "TrackWebView", "Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent$ApiUsage$AddOperationStepVital;", "Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent$ApiUsage$AddViewLoadingTime;", "Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent$ApiUsage$NetworkInstrumentation;", "Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent$ApiUsage$Timeseries;", "Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent$ApiUsage$TrackWebView;", "dd-sdk-android-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static abstract class ApiUsage extends InternalTelemetryEvent {
        private final Map<String, Object> additionalProperties;

        public /* synthetic */ ApiUsage(Map map, DefaultConstructorMarker defaultConstructorMarker) {
            this(map);
        }

        public /* synthetic */ ApiUsage(LinkedHashMap linkedHashMap, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new LinkedHashMap() : linkedHashMap, null);
        }

        public final Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        private ApiUsage(Map<String, Object> map) {
            super(null);
            this.additionalProperties = map;
        }

        /* JADX INFO: compiled from: InternalTelemetryEvent.kt */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007¢\u0006\u0002\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent$ApiUsage$AddViewLoadingTime;", "Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent$ApiUsage;", "overwrite", "", "noView", "noActiveView", "additionalProperties", "", "", "", "(ZZZLjava/util/Map;)V", "getNoActiveView", "()Z", "getNoView", "getOverwrite", "dd-sdk-android-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class AddViewLoadingTime extends ApiUsage {
            private final boolean noActiveView;
            private final boolean noView;
            private final boolean overwrite;

            public final boolean getOverwrite() {
                return this.overwrite;
            }

            public final boolean getNoView() {
                return this.noView;
            }

            public final boolean getNoActiveView() {
                return this.noActiveView;
            }

            public /* synthetic */ AddViewLoadingTime(boolean z, boolean z2, boolean z3, LinkedHashMap linkedHashMap, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(z, z2, z3, (i & 8) != 0 ? new LinkedHashMap() : linkedHashMap);
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AddViewLoadingTime(boolean z, boolean z2, boolean z3, Map<String, Object> additionalProperties) {
                super(additionalProperties, null);
                Intrinsics.checkNotNullParameter(additionalProperties, "additionalProperties");
                this.overwrite = z;
                this.noView = z2;
                this.noActiveView = z3;
            }
        }

        /* JADX INFO: compiled from: InternalTelemetryEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u000bB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005¢\u0006\u0002\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent$ApiUsage$AddOperationStepVital;", "Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent$ApiUsage;", "actionType", "Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent$ApiUsage$AddOperationStepVital$ActionType;", "additionalProperties", "", "", "", "(Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent$ApiUsage$AddOperationStepVital$ActionType;Ljava/util/Map;)V", "getActionType", "()Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent$ApiUsage$AddOperationStepVital$ActionType;", "ActionType", "dd-sdk-android-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class AddOperationStepVital extends ApiUsage {
            private final ActionType actionType;

            /* JADX INFO: compiled from: InternalTelemetryEvent.kt */
            /* JADX INFO: loaded from: classes5.dex */
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent$ApiUsage$AddOperationStepVital$ActionType;", "", "(Ljava/lang/String;I)V", "START", "SUCCEED", "FAIL", "dd-sdk-android-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public enum ActionType {
                START,
                SUCCEED,
                FAIL
            }

            public final ActionType getActionType() {
                return this.actionType;
            }

            public /* synthetic */ AddOperationStepVital(ActionType actionType, LinkedHashMap linkedHashMap, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(actionType, (i & 2) != 0 ? new LinkedHashMap() : linkedHashMap);
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AddOperationStepVital(ActionType actionType, Map<String, Object> additionalProperties) {
                super(additionalProperties, null);
                Intrinsics.checkNotNullParameter(actionType, "actionType");
                Intrinsics.checkNotNullParameter(additionalProperties, "additionalProperties");
                this.actionType = actionType;
            }
        }

        /* JADX INFO: compiled from: InternalTelemetryEvent.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent$ApiUsage$TrackWebView;", "Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent$ApiUsage;", "additionalProperties", "", "", "", "(Ljava/util/Map;)V", "dd-sdk-android-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class TrackWebView extends ApiUsage {
            /* JADX WARN: Multi-variable type inference failed */
            public TrackWebView() {
                this(null, 1, 0 == true ? 1 : 0);
            }

            public /* synthetic */ TrackWebView(LinkedHashMap linkedHashMap, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? new LinkedHashMap() : linkedHashMap);
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public TrackWebView(Map<String, Object> additionalProperties) {
                super(additionalProperties, null);
                Intrinsics.checkNotNullParameter(additionalProperties, "additionalProperties");
            }
        }

        /* JADX INFO: compiled from: InternalTelemetryEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u000bB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005¢\u0006\u0002\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent$ApiUsage$NetworkInstrumentation;", "Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent$ApiUsage;", "type", "Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent$ApiUsage$NetworkInstrumentation$LibraryType;", "additionalProperties", "", "", "", "(Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent$ApiUsage$NetworkInstrumentation$LibraryType;Ljava/util/Map;)V", "getType", "()Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent$ApiUsage$NetworkInstrumentation$LibraryType;", "LibraryType", "dd-sdk-android-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class NetworkInstrumentation extends ApiUsage {
            private final LibraryType type;

            /* JADX INFO: compiled from: InternalTelemetryEvent.kt */
            /* JADX INFO: loaded from: classes5.dex */
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent$ApiUsage$NetworkInstrumentation$LibraryType;", "", "(Ljava/lang/String;I)V", "CRONET", "OKHTTP", "LEGACY_OKHTTP", "dd-sdk-android-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public enum LibraryType {
                CRONET,
                OKHTTP,
                LEGACY_OKHTTP
            }

            public final LibraryType getType() {
                return this.type;
            }

            public /* synthetic */ NetworkInstrumentation(LibraryType libraryType, LinkedHashMap linkedHashMap, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(libraryType, (i & 2) != 0 ? new LinkedHashMap() : linkedHashMap);
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public NetworkInstrumentation(LibraryType type, Map<String, Object> additionalProperties) {
                super(additionalProperties, null);
                Intrinsics.checkNotNullParameter(type, "type");
                Intrinsics.checkNotNullParameter(additionalProperties, "additionalProperties");
                this.type = type;
            }
        }

        /* JADX INFO: compiled from: InternalTelemetryEvent.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent$ApiUsage$Timeseries;", "Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent$ApiUsage;", "additionalProperties", "", "", "", "(Ljava/util/Map;)V", "dd-sdk-android-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Timeseries extends ApiUsage {
            /* JADX WARN: Multi-variable type inference failed */
            public Timeseries() {
                this(null, 1, 0 == true ? 1 : 0);
            }

            public /* synthetic */ Timeseries(LinkedHashMap linkedHashMap, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? new LinkedHashMap() : linkedHashMap);
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Timeseries(Map<String, Object> additionalProperties) {
                super(additionalProperties, null);
                Intrinsics.checkNotNullParameter(additionalProperties, "additionalProperties");
            }
        }
    }

    /* JADX INFO: compiled from: InternalTelemetryEvent.kt */
    /* JADX INFO: loaded from: classes5.dex */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent$InterceptorInstantiated;", "Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent;", "()V", "dd-sdk-android-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class InterceptorInstantiated extends InternalTelemetryEvent {
        public static final InterceptorInstantiated INSTANCE = new InterceptorInstantiated();

        private InterceptorInstantiated() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: InternalTelemetryEvent.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0007B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent$ResourceHeadersTrackingConfigured;", "Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent;", "mode", "Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent$ResourceHeadersTrackingConfigured$Mode;", "(Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent$ResourceHeadersTrackingConfigured$Mode;)V", "getMode", "()Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent$ResourceHeadersTrackingConfigured$Mode;", "Mode", "dd-sdk-android-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class ResourceHeadersTrackingConfigured extends InternalTelemetryEvent {
        private final Mode mode;

        /* JADX INFO: compiled from: InternalTelemetryEvent.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent$ResourceHeadersTrackingConfigured$Mode;", "", "(Ljava/lang/String;I)V", "DEFAULT_HEADERS", "CUSTOM", "dd-sdk-android-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public enum Mode {
            DEFAULT_HEADERS,
            CUSTOM
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ResourceHeadersTrackingConfigured(Mode mode) {
            super(null);
            Intrinsics.checkNotNullParameter(mode, "mode");
            this.mode = mode;
        }

        public final Mode getMode() {
            return this.mode;
        }
    }
}
