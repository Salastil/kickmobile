package io.datazoom.sdk.model;

import com.facebook.hermes.intl.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: PendingFlag.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\n\u000b\f\rB\u0013\b\u0004\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\b\u001a\u00020\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0004\u000e\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lio/datazoom/sdk/model/PendingFlag;", "", "softFlagTimeout", "", "<init>", "(J)V", "getSoftFlagTimeout", "()J", "isSoftFlag", "", "GEO", "TIME_SYNC", "CONFIG", "SAMPLING", "Lio/datazoom/sdk/model/PendingFlag$CONFIG;", "Lio/datazoom/sdk/model/PendingFlag$GEO;", "Lio/datazoom/sdk/model/PendingFlag$SAMPLING;", "Lio/datazoom/sdk/model/PendingFlag$TIME_SYNC;", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class PendingFlag {
    private final long softFlagTimeout;

    public /* synthetic */ PendingFlag(long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(j);
    }

    private PendingFlag(long j) {
        this.softFlagTimeout = j;
    }

    public /* synthetic */ PendingFlag(long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, null);
    }

    public final long getSoftFlagTimeout() {
        return this.softFlagTimeout;
    }

    /* JADX INFO: compiled from: PendingFlag.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lio/datazoom/sdk/model/PendingFlag$GEO;", "Lio/datazoom/sdk/model/PendingFlag;", "<init>", "()V", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class GEO extends PendingFlag {
        public static final GEO INSTANCE = new GEO();

        private GEO() {
            super(2000L, null);
        }
    }

    /* JADX INFO: compiled from: PendingFlag.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lio/datazoom/sdk/model/PendingFlag$TIME_SYNC;", "Lio/datazoom/sdk/model/PendingFlag;", "<init>", "()V", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class TIME_SYNC extends PendingFlag {
        public static final TIME_SYNC INSTANCE = new TIME_SYNC();

        private TIME_SYNC() {
            super(2000L, null);
        }
    }

    /* JADX INFO: compiled from: PendingFlag.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lio/datazoom/sdk/model/PendingFlag$CONFIG;", "Lio/datazoom/sdk/model/PendingFlag;", "<init>", "()V", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class CONFIG extends PendingFlag {
        public static final CONFIG INSTANCE = new CONFIG();

        private CONFIG() {
            super(0L, 1, null);
        }
    }

    /* JADX INFO: compiled from: PendingFlag.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lio/datazoom/sdk/model/PendingFlag$SAMPLING;", "Lio/datazoom/sdk/model/PendingFlag;", "<init>", "()V", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class SAMPLING extends PendingFlag {
        public static final SAMPLING INSTANCE = new SAMPLING();

        private SAMPLING() {
            super(0L, 1, null);
        }
    }

    public final boolean isSoftFlag() {
        return this.softFlagTimeout > 0;
    }
}
