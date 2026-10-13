package io.datazoom.sdk.stateMachine.timeSync.model;

import com.facebook.hermes.intl.Constants;
import com.google.android.gms.cast.MediaError;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: State.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00132\u00020\u0001:\u0003\u0011\u0012\u0013B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\u0005J\u0006\u0010\b\u001a\u00020\u0005J\u0006\u0010\t\u001a\u00020\u0005J\u0006\u0010\n\u001a\u00020\u0005J\u0006\u0010\u000b\u001a\u00020\u0005J\u0006\u0010\f\u001a\u00020\u0005J\u0006\u0010\r\u001a\u00020\u0005J\n\u0010\u000e\u001a\u00020\u000fH\u0096\u0080\u0004J\u0006\u0010\u0010\u001a\u00020\u000f\u0082\u0001\u0002\u0014\u0015¨\u0006\u0016"}, d2 = {"Lio/datazoom/sdk/stateMachine/timeSync/model/State;", "", "<init>", "()V", "isIdle", "", "isPlaying", "isPaused", "isStopped", "isCompleted", "isError", "isSeeking", "isBuffering", "isAd", "toString", "", "log", "Content", "Ad", "Companion", "Lio/datazoom/sdk/stateMachine/timeSync/model/State$Ad;", "Lio/datazoom/sdk/stateMachine/timeSync/model/State$Content;", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class State {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: State.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\n\u0004\u0005\u0006\u0007\b\t\n\u000b\f\rB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\n\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017¨\u0006\u0018"}, d2 = {"Lio/datazoom/sdk/stateMachine/timeSync/model/State$Content;", "Lio/datazoom/sdk/stateMachine/timeSync/model/State;", "<init>", "()V", "IDLE", "REQUESTED", "BUFFERING", "PLAYING", "STARTED", "PAUSED", "STOPPED", MediaError.ERROR_TYPE_ERROR, "COMPLETED", "SEEKING", "Lio/datazoom/sdk/stateMachine/timeSync/model/State$Content$BUFFERING;", "Lio/datazoom/sdk/stateMachine/timeSync/model/State$Content$COMPLETED;", "Lio/datazoom/sdk/stateMachine/timeSync/model/State$Content$ERROR;", "Lio/datazoom/sdk/stateMachine/timeSync/model/State$Content$IDLE;", "Lio/datazoom/sdk/stateMachine/timeSync/model/State$Content$PAUSED;", "Lio/datazoom/sdk/stateMachine/timeSync/model/State$Content$PLAYING;", "Lio/datazoom/sdk/stateMachine/timeSync/model/State$Content$REQUESTED;", "Lio/datazoom/sdk/stateMachine/timeSync/model/State$Content$SEEKING;", "Lio/datazoom/sdk/stateMachine/timeSync/model/State$Content$STARTED;", "Lio/datazoom/sdk/stateMachine/timeSync/model/State$Content$STOPPED;", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static abstract class Content extends State {
        public /* synthetic */ Content(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: State.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, d2 = {"Lio/datazoom/sdk/stateMachine/timeSync/model/State$Content$IDLE;", "Lio/datazoom/sdk/stateMachine/timeSync/model/State$Content;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final /* data */ class IDLE extends Content {
            public static final IDLE INSTANCE = new IDLE();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof IDLE)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1864525130;
            }

            @Override // io.datazoom.sdk.stateMachine.timeSync.model.State
            public String toString() {
                return "IDLE";
            }

            private IDLE() {
                super(null);
            }
        }

        private Content() {
            super(null);
        }

        /* JADX INFO: compiled from: State.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, d2 = {"Lio/datazoom/sdk/stateMachine/timeSync/model/State$Content$REQUESTED;", "Lio/datazoom/sdk/stateMachine/timeSync/model/State$Content;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final /* data */ class REQUESTED extends Content {
            public static final REQUESTED INSTANCE = new REQUESTED();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof REQUESTED)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 942522796;
            }

            @Override // io.datazoom.sdk.stateMachine.timeSync.model.State
            public String toString() {
                return "REQUESTED";
            }

            private REQUESTED() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: State.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, d2 = {"Lio/datazoom/sdk/stateMachine/timeSync/model/State$Content$BUFFERING;", "Lio/datazoom/sdk/stateMachine/timeSync/model/State$Content;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final /* data */ class BUFFERING extends Content {
            public static final BUFFERING INSTANCE = new BUFFERING();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof BUFFERING)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 310101472;
            }

            @Override // io.datazoom.sdk.stateMachine.timeSync.model.State
            public String toString() {
                return "BUFFERING";
            }

            private BUFFERING() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: State.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, d2 = {"Lio/datazoom/sdk/stateMachine/timeSync/model/State$Content$PLAYING;", "Lio/datazoom/sdk/stateMachine/timeSync/model/State$Content;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final /* data */ class PLAYING extends Content {
            public static final PLAYING INSTANCE = new PLAYING();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof PLAYING)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1413974548;
            }

            @Override // io.datazoom.sdk.stateMachine.timeSync.model.State
            public String toString() {
                return "PLAYING";
            }

            private PLAYING() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: State.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, d2 = {"Lio/datazoom/sdk/stateMachine/timeSync/model/State$Content$STARTED;", "Lio/datazoom/sdk/stateMachine/timeSync/model/State$Content;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final /* data */ class STARTED extends Content {
            public static final STARTED INSTANCE = new STARTED();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof STARTED)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1477371455;
            }

            @Override // io.datazoom.sdk.stateMachine.timeSync.model.State
            public String toString() {
                return "STARTED";
            }

            private STARTED() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: State.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, d2 = {"Lio/datazoom/sdk/stateMachine/timeSync/model/State$Content$PAUSED;", "Lio/datazoom/sdk/stateMachine/timeSync/model/State$Content;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final /* data */ class PAUSED extends Content {
            public static final PAUSED INSTANCE = new PAUSED();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof PAUSED)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -609370224;
            }

            @Override // io.datazoom.sdk.stateMachine.timeSync.model.State
            public String toString() {
                return "PAUSED";
            }

            private PAUSED() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: State.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, d2 = {"Lio/datazoom/sdk/stateMachine/timeSync/model/State$Content$STOPPED;", "Lio/datazoom/sdk/stateMachine/timeSync/model/State$Content;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final /* data */ class STOPPED extends Content {
            public static final STOPPED INSTANCE = new STOPPED();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof STOPPED)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1490237323;
            }

            @Override // io.datazoom.sdk.stateMachine.timeSync.model.State
            public String toString() {
                return "STOPPED";
            }

            private STOPPED() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: State.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, d2 = {"Lio/datazoom/sdk/stateMachine/timeSync/model/State$Content$ERROR;", "Lio/datazoom/sdk/stateMachine/timeSync/model/State$Content;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final /* data */ class ERROR extends Content {
            public static final ERROR INSTANCE = new ERROR();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ERROR)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1968975034;
            }

            @Override // io.datazoom.sdk.stateMachine.timeSync.model.State
            public String toString() {
                return MediaError.ERROR_TYPE_ERROR;
            }

            private ERROR() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: State.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, d2 = {"Lio/datazoom/sdk/stateMachine/timeSync/model/State$Content$COMPLETED;", "Lio/datazoom/sdk/stateMachine/timeSync/model/State$Content;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final /* data */ class COMPLETED extends Content {
            public static final COMPLETED INSTANCE = new COMPLETED();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof COMPLETED)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1154342775;
            }

            @Override // io.datazoom.sdk.stateMachine.timeSync.model.State
            public String toString() {
                return "COMPLETED";
            }

            private COMPLETED() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: State.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, d2 = {"Lio/datazoom/sdk/stateMachine/timeSync/model/State$Content$SEEKING;", "Lio/datazoom/sdk/stateMachine/timeSync/model/State$Content;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final /* data */ class SEEKING extends Content {
            public static final SEEKING INSTANCE = new SEEKING();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SEEKING)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1051409448;
            }

            @Override // io.datazoom.sdk.stateMachine.timeSync.model.State
            public String toString() {
                return "SEEKING";
            }

            private SEEKING() {
                super(null);
            }
        }
    }

    private State() {
    }

    /* JADX INFO: compiled from: State.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\n\u0004\u0005\u0006\u0007\b\t\n\u000b\f\rB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\n\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017¨\u0006\u0018"}, d2 = {"Lio/datazoom/sdk/stateMachine/timeSync/model/State$Ad;", "Lio/datazoom/sdk/stateMachine/timeSync/model/State;", "<init>", "()V", "IDLE", "BUFFERING", "PLAYING", "PAUSED", "STOPPED", MediaError.ERROR_TYPE_ERROR, "COMPLETED", "SKIPPED", "SEEKING", "Break", "Lio/datazoom/sdk/stateMachine/timeSync/model/State$Ad$BUFFERING;", "Lio/datazoom/sdk/stateMachine/timeSync/model/State$Ad$Break;", "Lio/datazoom/sdk/stateMachine/timeSync/model/State$Ad$COMPLETED;", "Lio/datazoom/sdk/stateMachine/timeSync/model/State$Ad$ERROR;", "Lio/datazoom/sdk/stateMachine/timeSync/model/State$Ad$IDLE;", "Lio/datazoom/sdk/stateMachine/timeSync/model/State$Ad$PAUSED;", "Lio/datazoom/sdk/stateMachine/timeSync/model/State$Ad$PLAYING;", "Lio/datazoom/sdk/stateMachine/timeSync/model/State$Ad$SEEKING;", "Lio/datazoom/sdk/stateMachine/timeSync/model/State$Ad$SKIPPED;", "Lio/datazoom/sdk/stateMachine/timeSync/model/State$Ad$STOPPED;", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static abstract class Ad extends State {
        public /* synthetic */ Ad(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: State.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, d2 = {"Lio/datazoom/sdk/stateMachine/timeSync/model/State$Ad$IDLE;", "Lio/datazoom/sdk/stateMachine/timeSync/model/State$Ad;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final /* data */ class IDLE extends Ad {
            public static final IDLE INSTANCE = new IDLE();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof IDLE)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 378725394;
            }

            @Override // io.datazoom.sdk.stateMachine.timeSync.model.State
            public String toString() {
                return "IDLE";
            }

            private IDLE() {
                super(null);
            }
        }

        private Ad() {
            super(null);
        }

        /* JADX INFO: compiled from: State.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, d2 = {"Lio/datazoom/sdk/stateMachine/timeSync/model/State$Ad$BUFFERING;", "Lio/datazoom/sdk/stateMachine/timeSync/model/State$Ad;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final /* data */ class BUFFERING extends Ad {
            public static final BUFFERING INSTANCE = new BUFFERING();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof BUFFERING)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 78247428;
            }

            @Override // io.datazoom.sdk.stateMachine.timeSync.model.State
            public String toString() {
                return "BUFFERING";
            }

            private BUFFERING() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: State.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, d2 = {"Lio/datazoom/sdk/stateMachine/timeSync/model/State$Ad$PLAYING;", "Lio/datazoom/sdk/stateMachine/timeSync/model/State$Ad;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final /* data */ class PLAYING extends Ad {
            public static final PLAYING INSTANCE = new PLAYING();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof PLAYING)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1866227472;
            }

            @Override // io.datazoom.sdk.stateMachine.timeSync.model.State
            public String toString() {
                return "PLAYING";
            }

            private PLAYING() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: State.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, d2 = {"Lio/datazoom/sdk/stateMachine/timeSync/model/State$Ad$PAUSED;", "Lio/datazoom/sdk/stateMachine/timeSync/model/State$Ad;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final /* data */ class PAUSED extends Ad {
            public static final PAUSED INSTANCE = new PAUSED();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof PAUSED)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -919199252;
            }

            @Override // io.datazoom.sdk.stateMachine.timeSync.model.State
            public String toString() {
                return "PAUSED";
            }

            private PAUSED() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: State.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, d2 = {"Lio/datazoom/sdk/stateMachine/timeSync/model/State$Ad$STOPPED;", "Lio/datazoom/sdk/stateMachine/timeSync/model/State$Ad;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final /* data */ class STOPPED extends Ad {
            public static final STOPPED INSTANCE = new STOPPED();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof STOPPED)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 475472047;
            }

            @Override // io.datazoom.sdk.stateMachine.timeSync.model.State
            public String toString() {
                return "STOPPED";
            }

            private STOPPED() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: State.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, d2 = {"Lio/datazoom/sdk/stateMachine/timeSync/model/State$Ad$ERROR;", "Lio/datazoom/sdk/stateMachine/timeSync/model/State$Ad;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final /* data */ class ERROR extends Ad {
            public static final ERROR INSTANCE = new ERROR();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ERROR)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1147685526;
            }

            @Override // io.datazoom.sdk.stateMachine.timeSync.model.State
            public String toString() {
                return MediaError.ERROR_TYPE_ERROR;
            }

            private ERROR() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: State.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, d2 = {"Lio/datazoom/sdk/stateMachine/timeSync/model/State$Ad$COMPLETED;", "Lio/datazoom/sdk/stateMachine/timeSync/model/State$Ad;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final /* data */ class COMPLETED extends Ad {
            public static final COMPLETED INSTANCE = new COMPLETED();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof COMPLETED)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1386196819;
            }

            @Override // io.datazoom.sdk.stateMachine.timeSync.model.State
            public String toString() {
                return "COMPLETED";
            }

            private COMPLETED() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: State.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, d2 = {"Lio/datazoom/sdk/stateMachine/timeSync/model/State$Ad$SKIPPED;", "Lio/datazoom/sdk/stateMachine/timeSync/model/State$Ad;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final /* data */ class SKIPPED extends Ad {
            public static final SKIPPED INSTANCE = new SKIPPED();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SKIPPED)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 212268562;
            }

            @Override // io.datazoom.sdk.stateMachine.timeSync.model.State
            public String toString() {
                return "SKIPPED";
            }

            private SKIPPED() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: State.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, d2 = {"Lio/datazoom/sdk/stateMachine/timeSync/model/State$Ad$SEEKING;", "Lio/datazoom/sdk/stateMachine/timeSync/model/State$Ad;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final /* data */ class SEEKING extends Ad {
            public static final SEEKING INSTANCE = new SEEKING();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SEEKING)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 36644172;
            }

            @Override // io.datazoom.sdk.stateMachine.timeSync.model.State
            public String toString() {
                return "SEEKING";
            }

            private SEEKING() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: State.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lio/datazoom/sdk/stateMachine/timeSync/model/State$Ad$Break;", "Lio/datazoom/sdk/stateMachine/timeSync/model/State$Ad;", "<init>", "()V", "STARTED", "ENDED", "Lio/datazoom/sdk/stateMachine/timeSync/model/State$Ad$Break$ENDED;", "Lio/datazoom/sdk/stateMachine/timeSync/model/State$Ad$Break$STARTED;", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static abstract class Break extends Ad {
            public /* synthetic */ Break(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* JADX INFO: compiled from: State.kt */
            @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, d2 = {"Lio/datazoom/sdk/stateMachine/timeSync/model/State$Ad$Break$STARTED;", "Lio/datazoom/sdk/stateMachine/timeSync/model/State$Ad$Break;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
            public static final /* data */ class STARTED extends Break {
                public static final STARTED INSTANCE = new STARTED();

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof STARTED)) {
                        return false;
                    }
                    return true;
                }

                public int hashCode() {
                    return 1058222036;
                }

                @Override // io.datazoom.sdk.stateMachine.timeSync.model.State
                public String toString() {
                    return "STARTED";
                }

                private STARTED() {
                    super(null);
                }
            }

            private Break() {
                super(null);
            }

            /* JADX INFO: compiled from: State.kt */
            @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, d2 = {"Lio/datazoom/sdk/stateMachine/timeSync/model/State$Ad$Break$ENDED;", "Lio/datazoom/sdk/stateMachine/timeSync/model/State$Ad$Break;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
            public static final /* data */ class ENDED extends Break {
                public static final ENDED INSTANCE = new ENDED();

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof ENDED)) {
                        return false;
                    }
                    return true;
                }

                public int hashCode() {
                    return -1276807475;
                }

                @Override // io.datazoom.sdk.stateMachine.timeSync.model.State
                public String toString() {
                    return "ENDED";
                }

                private ENDED() {
                    super(null);
                }
            }
        }
    }

    /* JADX INFO: compiled from: State.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lio/datazoom/sdk/stateMachine/timeSync/model/State$Companion;", "", "<init>", "()V", "error", "Lio/datazoom/sdk/stateMachine/timeSync/model/State;", "isContent", "", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final State error(boolean isContent) {
            return isContent ? Content.ERROR.INSTANCE : Ad.ERROR.INSTANCE;
        }
    }

    public final boolean isIdle() {
        return (this instanceof Content.IDLE) || (this instanceof Ad.IDLE);
    }

    public final boolean isPlaying() {
        return (this instanceof Content.PLAYING) || (this instanceof Ad.PLAYING);
    }

    public final boolean isPaused() {
        return (this instanceof Content.PAUSED) || (this instanceof Ad.PAUSED);
    }

    public final boolean isStopped() {
        return (this instanceof Content.STOPPED) || (this instanceof Ad.STOPPED);
    }

    public final boolean isCompleted() {
        return (this instanceof Content.COMPLETED) || (this instanceof Ad.COMPLETED);
    }

    public final boolean isError() {
        return (this instanceof Content.ERROR) || (this instanceof Ad.ERROR);
    }

    public final boolean isSeeking() {
        return (this instanceof Content.SEEKING) || (this instanceof Ad.SEEKING);
    }

    public final boolean isBuffering() {
        return (this instanceof Content.BUFFERING) || (this instanceof Ad.BUFFERING);
    }

    public final boolean isAd() {
        return this instanceof Ad;
    }

    public String toString() {
        StringBuilder sb = this instanceof Content ? new StringBuilder("Content.") : new StringBuilder("Ad.");
        sb.append(this);
        return sb.toString();
    }

    public final String log() {
        StringBuilder sb = this instanceof Content ? new StringBuilder("Content.") : new StringBuilder("Ad.");
        sb.append(this);
        return sb.toString();
    }
}
