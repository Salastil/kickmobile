package io.datazoom.sdk.domain;

import com.facebook.hermes.intl.Constants;
import io.datazoom.sdk.RandomUUID_androidKt;
import io.datazoom.sdk.time.Time;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: SessionManager.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0006J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u0011R\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lio/datazoom/sdk/domain/SessionManager;", "", "<init>", "()V", "_session", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lio/datazoom/sdk/domain/SessionManager$Session;", "currentSession", "restartSession", "currentSessionForEvent", "inactivityThresholdMs", "", "eventTimeMs", "", "endSession", "", "isAlive", "", "Session", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SessionManager {
    private final MutableStateFlow<Session> _session = StateFlowKt.MutableStateFlow(null);

    public final Session currentSession() {
        Session value;
        Session session;
        Session value2 = this._session.getValue();
        if (value2 != null) {
            return value2;
        }
        MutableStateFlow<Session> mutableStateFlow = this._session;
        Session session2 = null;
        do {
            value = mutableStateFlow.getValue();
            session = value;
            if (session == null) {
                session2 = new Session(0L, null, null, 7, null);
                session = session2;
            }
        } while (!mutableStateFlow.compareAndSet(value, session));
        Session value3 = this._session.getValue();
        if (value3 != null) {
            return value3;
        }
        Intrinsics.checkNotNull(session2);
        return session2;
    }

    public final Session restartSession() {
        endSession();
        return currentSession();
    }

    public static /* synthetic */ Session currentSessionForEvent$default(SessionManager sessionManager, int i, long j, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j = Time.INSTANCE.now();
        }
        return sessionManager.currentSessionForEvent(i, j);
    }

    public final Session currentSessionForEvent(int inactivityThresholdMs, long eventTimeMs) {
        Session value;
        Session sessionCopy$default;
        MutableStateFlow<Session> mutableStateFlow = this._session;
        do {
            value = mutableStateFlow.getValue();
            Session session = value;
            if (session == null) {
                long j = eventTimeMs;
                sessionCopy$default = new Session(j, null, Long.valueOf(eventTimeMs), 2, null);
            } else {
                long j2 = eventTimeMs;
                if (session.isInactive(j2, inactivityThresholdMs)) {
                    eventTimeMs = j2;
                    sessionCopy$default = new Session(j2, null, Long.valueOf(j2), 2, null);
                } else {
                    eventTimeMs = j2;
                    sessionCopy$default = Session.copy$default(session, 0L, null, Long.valueOf(eventTimeMs), 3, null);
                }
            }
        } while (!mutableStateFlow.compareAndSet(value, sessionCopy$default));
        if (sessionCopy$default != null) {
            return sessionCopy$default;
        }
        Session value2 = this._session.getValue();
        Intrinsics.checkNotNull(value2);
        return value2;
    }

    public final void endSession() {
        MutableStateFlow<Session> mutableStateFlow = this._session;
        while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), null)) {
        }
    }

    public final boolean isAlive() {
        return this._session.getValue() != null;
    }

    /* JADX INFO: compiled from: SessionManager.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ.\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0019J\u0014\u0010\u001a\u001a\u00020\u00112\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001c\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u001d\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u001e"}, d2 = {"Lio/datazoom/sdk/domain/SessionManager$Session;", "", "time", "", "id", "", "lastEventTime", "<init>", "(JLjava/lang/String;Ljava/lang/Long;)V", "getTime", "()J", "getId", "()Ljava/lang/String;", "getLastEventTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "isInactive", "", "nowMs", "thresholdMs", "", "component1", "component2", "component3", "copy", "(JLjava/lang/String;Ljava/lang/Long;)Lio/datazoom/sdk/domain/SessionManager$Session;", "equals", "other", "hashCode", "toString", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Session {
        private final String id;
        private final Long lastEventTime;
        private final long time;

        public Session() {
            this(0L, null, null, 7, null);
        }

        public static /* synthetic */ Session copy$default(Session session, long j, String str, Long l, int i, Object obj) {
            if ((i & 1) != 0) {
                j = session.time;
            }
            if ((i & 2) != 0) {
                str = session.id;
            }
            if ((i & 4) != 0) {
                l = session.lastEventTime;
            }
            return session.copy(j, str, l);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getTime() {
            return this.time;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Long getLastEventTime() {
            return this.lastEventTime;
        }

        public final Session copy(long time, String id, Long lastEventTime) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new Session(time, id, lastEventTime);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Session)) {
                return false;
            }
            Session session = (Session) other;
            return this.time == session.time && Intrinsics.areEqual(this.id, session.id) && Intrinsics.areEqual(this.lastEventTime, session.lastEventTime);
        }

        public int hashCode() {
            int iHashCode = ((Long.hashCode(this.time) * 31) + this.id.hashCode()) * 31;
            Long l = this.lastEventTime;
            return iHashCode + (l == null ? 0 : l.hashCode());
        }

        public String toString() {
            return "Session(time=" + this.time + ", id=" + this.id + ", lastEventTime=" + this.lastEventTime + ")";
        }

        public Session(long j, String id, Long l) {
            Intrinsics.checkNotNullParameter(id, "id");
            this.time = j;
            this.id = id;
            this.lastEventTime = l;
        }

        public /* synthetic */ Session(long j, String str, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? Time.INSTANCE.now() : j, (i & 2) != 0 ? RandomUUID_androidKt.randomUUID() : str, (i & 4) != 0 ? null : l);
        }

        public final long getTime() {
            return this.time;
        }

        public final String getId() {
            return this.id;
        }

        public final Long getLastEventTime() {
            return this.lastEventTime;
        }

        public final boolean isInactive(long nowMs, int thresholdMs) {
            Long l = this.lastEventTime;
            return l != null && nowMs - l.longValue() > ((long) thresholdMs);
        }
    }
}
