package androidx.metrics.performance;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FrameData.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0011"}, d2 = {"Landroidx/metrics/performance/StateInfo;", "", "key", "", "value", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "getValue", "equals", "", "other", "hashCode", "", "toString", "Companion", "metrics-performance_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class StateInfo {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Map<String, Map<String, StateInfo>> pool = new LinkedHashMap();
    private final String key;
    private final String value;

    public StateInfo(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.key = key;
        this.value = value;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getValue() {
        return this.value;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type androidx.metrics.performance.StateInfo");
        StateInfo stateInfo = (StateInfo) other;
        return Intrinsics.areEqual(this.key, stateInfo.key) && Intrinsics.areEqual(this.value, stateInfo.value);
    }

    public int hashCode() {
        return (this.key.hashCode() * 31) + this.value.hashCode();
    }

    public String toString() {
        return this.key + ": " + this.value;
    }

    /* JADX INFO: compiled from: FrameData.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006R)\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Landroidx/metrics/performance/StateInfo$Companion;", "", "<init>", "()V", "pool", "", "", "Landroidx/metrics/performance/StateInfo;", "getPool", "()Ljava/util/Map;", "getStateInfo", "stateName", "state", "metrics-performance_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Map<String, Map<String, StateInfo>> getPool() {
            return StateInfo.pool;
        }

        public final StateInfo getStateInfo(String stateName, String state) {
            Intrinsics.checkNotNullParameter(stateName, "stateName");
            Intrinsics.checkNotNullParameter(state, "state");
            synchronized (getPool()) {
                Map<String, StateInfo> map = StateInfo.INSTANCE.getPool().get(stateName);
                StateInfo stateInfo = map != null ? map.get(state) : null;
                if (stateInfo != null) {
                    return stateInfo;
                }
                StateInfo stateInfo2 = new StateInfo(stateName, state);
                if (map != null) {
                    map.put(state, stateInfo2);
                } else {
                    StateInfo.INSTANCE.getPool().put(stateName, MapsKt.mutableMapOf(TuplesKt.to(state, stateInfo2)));
                }
                return stateInfo2;
            }
        }
    }
}
