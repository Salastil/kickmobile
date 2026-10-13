package com.datadog.android.rum.timeseries;

import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TimeseriesConfiguration.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \t2\u00020\u0001:\u0002\b\tB\u0015\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005R\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/timeseries/TimeseriesConfiguration;", "", "enabledTypes", "", "Lcom/datadog/android/rum/timeseries/TimeseriesType;", "(Ljava/util/Set;)V", "getEnabledTypes$dd_sdk_android_rum_release", "()Ljava/util/Set;", "Builder", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TimeseriesConfiguration {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final TimeseriesConfiguration DEFAULT = new Builder().build();
    public static final int DEFAULT_BUFFER_SIZE = 120;
    public static final long DEFAULT_INTERVAL_MS = 1000;
    private final Set<TimeseriesType> enabledTypes;

    /* JADX WARN: Multi-variable type inference failed */
    public TimeseriesConfiguration(Set<? extends TimeseriesType> enabledTypes) {
        Intrinsics.checkNotNullParameter(enabledTypes, "enabledTypes");
        this.enabledTypes = enabledTypes;
    }

    public final Set<TimeseriesType> getEnabledTypes$dd_sdk_android_rum_release() {
        return this.enabledTypes;
    }

    /* JADX INFO: compiled from: TimeseriesConfiguration.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0007J\u001f\u0010\b\u001a\u00020\u00002\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\n\"\u00020\u0005¢\u0006\u0002\u0010\u000bR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/datadog/android/rum/timeseries/TimeseriesConfiguration$Builder;", "", "()V", "enabledTypes", "", "Lcom/datadog/android/rum/timeseries/TimeseriesType;", "build", "Lcom/datadog/android/rum/timeseries/TimeseriesConfiguration;", "collectOnly", "types", "", "([Lcom/datadog/android/rum/timeseries/TimeseriesType;)Lcom/datadog/android/rum/timeseries/TimeseriesConfiguration$Builder;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Builder {
        private Set<? extends TimeseriesType> enabledTypes = ArraysKt.toSet(TimeseriesType.values());

        public final Builder collectOnly(TimeseriesType... types) {
            Intrinsics.checkNotNullParameter(types, "types");
            this.enabledTypes = ArraysKt.toSet(types);
            return this;
        }

        public final TimeseriesConfiguration build() {
            return new TimeseriesConfiguration(this.enabledTypes);
        }
    }

    /* JADX INFO: compiled from: TimeseriesConfiguration.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0080T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/datadog/android/rum/timeseries/TimeseriesConfiguration$Companion;", "", "()V", "DEFAULT", "Lcom/datadog/android/rum/timeseries/TimeseriesConfiguration;", "getDEFAULT$annotations", "getDEFAULT", "()Lcom/datadog/android/rum/timeseries/TimeseriesConfiguration;", "DEFAULT_BUFFER_SIZE", "", "DEFAULT_INTERVAL_MS", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getDEFAULT$annotations() {
        }

        private Companion() {
        }

        public final TimeseriesConfiguration getDEFAULT() {
            return TimeseriesConfiguration.DEFAULT;
        }
    }
}
