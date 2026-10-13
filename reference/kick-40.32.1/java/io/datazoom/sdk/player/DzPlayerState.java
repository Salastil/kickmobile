package io.datazoom.sdk.player;

import com.facebook.hermes.intl.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: DzPlayerState.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0006\u0007\b\tB\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0001\u0004\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lio/datazoom/sdk/player/DzPlayerState;", "", "value", "", "<init>", "(I)V", "Idle", "Buffering", "Ready", "Ended", "Lio/datazoom/sdk/player/DzPlayerState$Buffering;", "Lio/datazoom/sdk/player/DzPlayerState$Ended;", "Lio/datazoom/sdk/player/DzPlayerState$Idle;", "Lio/datazoom/sdk/player/DzPlayerState$Ready;", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class DzPlayerState {
    public /* synthetic */ DzPlayerState(int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(i);
    }

    private DzPlayerState(int i) {
    }

    /* JADX INFO: compiled from: DzPlayerState.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, d2 = {"Lio/datazoom/sdk/player/DzPlayerState$Idle;", "Lio/datazoom/sdk/player/DzPlayerState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Idle extends DzPlayerState {
        public static final Idle INSTANCE = new Idle();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Idle)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1673524056;
        }

        public String toString() {
            return "Idle";
        }

        private Idle() {
            super(1, null);
        }
    }

    /* JADX INFO: compiled from: DzPlayerState.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, d2 = {"Lio/datazoom/sdk/player/DzPlayerState$Buffering;", "Lio/datazoom/sdk/player/DzPlayerState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Buffering extends DzPlayerState {
        public static final Buffering INSTANCE = new Buffering();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Buffering)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -40666466;
        }

        public String toString() {
            return "Buffering";
        }

        private Buffering() {
            super(2, null);
        }
    }

    /* JADX INFO: compiled from: DzPlayerState.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, d2 = {"Lio/datazoom/sdk/player/DzPlayerState$Ready;", "Lio/datazoom/sdk/player/DzPlayerState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Ready extends DzPlayerState {
        public static final Ready INSTANCE = new Ready();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Ready)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 347969183;
        }

        public String toString() {
            return "Ready";
        }

        private Ready() {
            super(3, null);
        }
    }

    /* JADX INFO: compiled from: DzPlayerState.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, d2 = {"Lio/datazoom/sdk/player/DzPlayerState$Ended;", "Lio/datazoom/sdk/player/DzPlayerState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Ended extends DzPlayerState {
        public static final Ended INSTANCE = new Ended();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Ended)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 336234422;
        }

        public String toString() {
            return "Ended";
        }

        private Ended() {
            super(4, null);
        }
    }
}
