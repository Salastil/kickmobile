package com.datadog.android.core.internal.metrics;

import com.facebook.hermes.intl.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: RemovalReason.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0005\u0006\u0007\b\t\nB\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\r\u0010\u0003\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u0005\u0082\u0001\u0005\u000b\f\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/datadog/android/core/internal/metrics/RemovalReason;", "", "()V", "includeInMetrics", "", "includeInMetrics$dd_sdk_android_core_release", "Flushed", "IntakeCode", "Invalid", "Obsolete", "Purged", "Lcom/datadog/android/core/internal/metrics/RemovalReason$Flushed;", "Lcom/datadog/android/core/internal/metrics/RemovalReason$IntakeCode;", "Lcom/datadog/android/core/internal/metrics/RemovalReason$Invalid;", "Lcom/datadog/android/core/internal/metrics/RemovalReason$Obsolete;", "Lcom/datadog/android/core/internal/metrics/RemovalReason$Purged;", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class RemovalReason {
    public /* synthetic */ RemovalReason(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private RemovalReason() {
    }

    public final boolean includeInMetrics$dd_sdk_android_core_release() {
        return !(this instanceof Flushed);
    }

    /* JADX INFO: compiled from: RemovalReason.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0005\u001a\u00020\u0003HÂ\u0003J\u0013\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÖ\u0001J\b\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/datadog/android/core/internal/metrics/RemovalReason$IntakeCode;", "Lcom/datadog/android/core/internal/metrics/RemovalReason;", "responseCode", "", "(I)V", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class IntakeCode extends RemovalReason {
        private final int responseCode;

        /* JADX INFO: renamed from: component1, reason: from getter */
        private final int getResponseCode() {
            return this.responseCode;
        }

        public static /* synthetic */ IntakeCode copy$default(IntakeCode intakeCode, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = intakeCode.responseCode;
            }
            return intakeCode.copy(i);
        }

        public final IntakeCode copy(int responseCode) {
            return new IntakeCode(responseCode);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof IntakeCode) && this.responseCode == ((IntakeCode) other).responseCode;
        }

        public int hashCode() {
            return Integer.hashCode(this.responseCode);
        }

        public IntakeCode(int i) {
            super(null);
            this.responseCode = i;
        }

        public String toString() {
            return "intake-code-" + this.responseCode;
        }
    }

    /* JADX INFO: compiled from: RemovalReason.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/datadog/android/core/internal/metrics/RemovalReason$Invalid;", "Lcom/datadog/android/core/internal/metrics/RemovalReason;", "()V", "toString", "", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Invalid extends RemovalReason {
        public static final Invalid INSTANCE = new Invalid();

        private Invalid() {
            super(null);
        }

        public String toString() {
            return Constants.COLLATION_INVALID;
        }
    }

    /* JADX INFO: compiled from: RemovalReason.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/datadog/android/core/internal/metrics/RemovalReason$Purged;", "Lcom/datadog/android/core/internal/metrics/RemovalReason;", "()V", "toString", "", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Purged extends RemovalReason {
        public static final Purged INSTANCE = new Purged();

        private Purged() {
            super(null);
        }

        public String toString() {
            return "purged";
        }
    }

    /* JADX INFO: compiled from: RemovalReason.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/datadog/android/core/internal/metrics/RemovalReason$Obsolete;", "Lcom/datadog/android/core/internal/metrics/RemovalReason;", "()V", "toString", "", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Obsolete extends RemovalReason {
        public static final Obsolete INSTANCE = new Obsolete();

        private Obsolete() {
            super(null);
        }

        public String toString() {
            return "obsolete";
        }
    }

    /* JADX INFO: compiled from: RemovalReason.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/datadog/android/core/internal/metrics/RemovalReason$Flushed;", "Lcom/datadog/android/core/internal/metrics/RemovalReason;", "()V", "toString", "", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Flushed extends RemovalReason {
        public static final Flushed INSTANCE = new Flushed();

        private Flushed() {
            super(null);
        }

        public String toString() {
            return "flushed";
        }
    }
}
