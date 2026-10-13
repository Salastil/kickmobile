package com.datadog.android.flags.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FlagsClientState.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0005\b\t\n\u000b\f¨\u0006\r"}, d2 = {"Lcom/datadog/android/flags/model/FlagsClientState;", "", "()V", "Error", "NotReady", "Ready", "Reconciling", "Stale", "Lcom/datadog/android/flags/model/FlagsClientState$Error;", "Lcom/datadog/android/flags/model/FlagsClientState$NotReady;", "Lcom/datadog/android/flags/model/FlagsClientState$Ready;", "Lcom/datadog/android/flags/model/FlagsClientState$Reconciling;", "Lcom/datadog/android/flags/model/FlagsClientState$Stale;", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class FlagsClientState {
    public /* synthetic */ FlagsClientState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private FlagsClientState() {
    }

    /* JADX INFO: compiled from: FlagsClientState.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/datadog/android/flags/model/FlagsClientState$NotReady;", "Lcom/datadog/android/flags/model/FlagsClientState;", "()V", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class NotReady extends FlagsClientState {
        public static final NotReady INSTANCE = new NotReady();

        private NotReady() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: FlagsClientState.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/datadog/android/flags/model/FlagsClientState$Ready;", "Lcom/datadog/android/flags/model/FlagsClientState;", "()V", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Ready extends FlagsClientState {
        public static final Ready INSTANCE = new Ready();

        private Ready() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: FlagsClientState.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/datadog/android/flags/model/FlagsClientState$Reconciling;", "Lcom/datadog/android/flags/model/FlagsClientState;", "()V", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Reconciling extends FlagsClientState {
        public static final Reconciling INSTANCE = new Reconciling();

        private Reconciling() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: FlagsClientState.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/datadog/android/flags/model/FlagsClientState$Stale;", "Lcom/datadog/android/flags/model/FlagsClientState;", "()V", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Stale extends FlagsClientState {
        public static final Stale INSTANCE = new Stale();

        private Stale() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: FlagsClientState.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/datadog/android/flags/model/FlagsClientState$Error;", "Lcom/datadog/android/flags/model/FlagsClientState;", "error", "", "(Ljava/lang/Throwable;)V", "getError", "()Ljava/lang/Throwable;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Error extends FlagsClientState {
        private final Throwable error;

        /* JADX WARN: Multi-variable type inference failed */
        public Error() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ Error copy$default(Error error, Throwable th, int i, Object obj) {
            if ((i & 1) != 0) {
                th = error.error;
            }
            return error.copy(th);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Throwable getError() {
            return this.error;
        }

        public final Error copy(Throwable error) {
            return new Error(error);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Error) && Intrinsics.areEqual(this.error, ((Error) other).error);
        }

        public int hashCode() {
            Throwable th = this.error;
            if (th == null) {
                return 0;
            }
            return th.hashCode();
        }

        public String toString() {
            return "Error(error=" + this.error + ")";
        }

        public Error(Throwable th) {
            super(null);
            this.error = th;
        }

        public /* synthetic */ Error(Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : th);
        }

        public final Throwable getError() {
            return this.error;
        }
    }
}
