package androidx.metrics.performance;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PerformanceMetricsState.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\b\u001a\u0018\u0000 /2\u00020\u0001:\u0003./0B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J4\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00052\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J&\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00172\u0006\u0010\u0018\u001a\u00020\u000fH\u0002J\u0016\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0016J\u0016\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0016J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0015\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u0016H\u0000¢\u0006\u0002\b\u001eJ%\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u0012H\u0000¢\u0006\u0002\b#J\u0015\u0010$\u001a\u00020\r2\u0006\u0010%\u001a\u00020\u0006H\u0000¢\u0006\u0002\b&J\u000e\u0010'\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0016J+\u0010(\u001a\u00020\r2\u0006\u0010)\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0005H\u0000¢\u0006\u0002\b+J\r\u0010,\u001a\u00020\rH\u0000¢\u0006\u0002\b-R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Landroidx/metrics/performance/PerformanceMetricsState;", "", "<init>", "()V", "states", "", "Landroidx/metrics/performance/PerformanceMetricsState$StateData;", "singleFrameStates", "statesHolder", "statesToBeCleared", "", "stateDataPool", "addFrameState", "", "frameStartTime", "", "frameEndTime", "frameStates", "Landroidx/metrics/performance/StateInfo;", "activeStates", "markStateForRemoval", "key", "", "", "removalTime", "putState", "value", "putSingleFrameState", "removeStateNow", "stateName", "removeStateNow$metrics_performance_release", "getStateData", "timeAdded", "timeRemoved", "state", "getStateData$metrics_performance_release", "returnStateDataToPool", "stateData", "returnStateDataToPool$metrics_performance_release", "removeState", "getIntervalStates", "startTime", "endTime", "getIntervalStates$metrics_performance_release", "cleanupSingleFrameStates", "cleanupSingleFrameStates$metrics_performance_release", "StateData", "Companion", "Holder", "metrics-performance_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PerformanceMetricsState {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private List<StateData> singleFrameStates;
    private final List<StateData> stateDataPool;
    private List<StateData> states;
    private final List<StateData> statesHolder;
    private final List<Integer> statesToBeCleared;

    public /* synthetic */ PerformanceMetricsState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    public static final Holder getHolderForHierarchy(View view) {
        return INSTANCE.getHolderForHierarchy(view);
    }

    private PerformanceMetricsState() {
        this.states = new ArrayList();
        this.singleFrameStates = new ArrayList();
        this.statesHolder = new ArrayList();
        this.statesToBeCleared = new ArrayList();
        this.stateDataPool = new ArrayList();
    }

    private final void addFrameState(long frameStartTime, long frameEndTime, List<StateInfo> frameStates, List<StateData> activeStates) {
        List<Integer> list;
        List<StateData> list2;
        int size = activeStates.size() - 1;
        if (size >= 0) {
            while (true) {
                int i = size - 1;
                StateData stateData = activeStates.get(size);
                if (stateData.getTimeRemoved() > 0 && stateData.getTimeRemoved() < frameStartTime) {
                    returnStateDataToPool$metrics_performance_release(activeStates.remove(size));
                } else if (stateData.getTimeAdded() < frameEndTime) {
                    this.statesHolder.add(stateData);
                    if (Intrinsics.areEqual(activeStates, this.singleFrameStates) && stateData.getTimeRemoved() == -1) {
                        stateData.setTimeRemoved(frameStartTime);
                    }
                }
                if (i < 0) {
                    break;
                } else {
                    size = i;
                }
            }
        }
        if (this.statesHolder.size() <= 0) {
            return;
        }
        int size2 = this.statesHolder.size();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            list = this.statesToBeCleared;
            if (i3 >= size2) {
                break;
            }
            if (!list.contains(Integer.valueOf(i3))) {
                StateData stateData2 = this.statesHolder.get(i3);
                int size3 = this.statesHolder.size();
                for (int i4 = i3 + 1; i4 < size3; i4++) {
                    StateData stateData3 = this.statesHolder.get(i4);
                    if (Intrinsics.areEqual(stateData2.getState().getKey(), stateData3.getState().getKey())) {
                        long timeAdded = stateData2.getTimeAdded();
                        long timeAdded2 = stateData3.getTimeAdded();
                        List<Integer> list3 = this.statesToBeCleared;
                        if (timeAdded < timeAdded2) {
                            list3.add(Integer.valueOf(i3));
                        } else {
                            list3.add(Integer.valueOf(i4));
                        }
                    }
                }
            }
            i3++;
        }
        int size4 = list.size();
        while (true) {
            size4--;
            list2 = this.statesHolder;
            if (-1 >= size4) {
                break;
            } else {
                list2.remove(this.statesToBeCleared.get(size4).intValue());
            }
        }
        int size5 = list2.size();
        while (true) {
            List<StateData> list4 = this.statesHolder;
            if (i2 < size5) {
                frameStates.add(list4.get(i2).getState());
                i2++;
            } else {
                list4.clear();
                this.statesToBeCleared.clear();
                return;
            }
        }
    }

    private final void markStateForRemoval(String key, List<StateData> states, long removalTime) {
        synchronized (this.singleFrameStates) {
            int size = states.size();
            for (int i = 0; i < size; i++) {
                StateData stateData = states.get(i);
                if (Intrinsics.areEqual(stateData.getState().getKey(), key) && stateData.getTimeRemoved() < 0) {
                    stateData.setTimeRemoved(removalTime);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void putState(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        synchronized (this.singleFrameStates) {
            long jNanoTime = System.nanoTime();
            markStateForRemoval(key, this.states, jNanoTime);
            this.states.add(getStateData$metrics_performance_release(jNanoTime, -1L, new StateInfo(key, value)));
        }
    }

    public final void putSingleFrameState(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        synchronized (this.singleFrameStates) {
            long jNanoTime = System.nanoTime();
            markStateForRemoval(key, this.singleFrameStates, jNanoTime);
            this.singleFrameStates.add(getStateData$metrics_performance_release(jNanoTime, -1L, new StateInfo(key, value)));
        }
    }

    private final void markStateForRemoval(String key) {
        markStateForRemoval(key, this.states, System.nanoTime());
    }

    public final void removeStateNow$metrics_performance_release(String stateName) {
        Intrinsics.checkNotNullParameter(stateName, "stateName");
        synchronized (this.singleFrameStates) {
            int size = this.states.size();
            for (int i = 0; i < size; i++) {
                StateData stateData = this.states.get(i);
                if (Intrinsics.areEqual(stateData.getState().getKey(), stateName)) {
                    this.states.remove(stateData);
                    returnStateDataToPool$metrics_performance_release(stateData);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: PerformanceMetricsState.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Landroidx/metrics/performance/PerformanceMetricsState$StateData;", "", "timeAdded", "", "timeRemoved", "state", "Landroidx/metrics/performance/StateInfo;", "<init>", "(JJLandroidx/metrics/performance/StateInfo;)V", "getTimeAdded", "()J", "setTimeAdded", "(J)V", "getTimeRemoved", "setTimeRemoved", "getState", "()Landroidx/metrics/performance/StateInfo;", "setState", "(Landroidx/metrics/performance/StateInfo;)V", "metrics-performance_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class StateData {
        private StateInfo state;
        private long timeAdded;
        private long timeRemoved;

        public StateData(long j, long j2, StateInfo state) {
            Intrinsics.checkNotNullParameter(state, "state");
            this.timeAdded = j;
            this.timeRemoved = j2;
            this.state = state;
        }

        public final StateInfo getState() {
            return this.state;
        }

        public final long getTimeAdded() {
            return this.timeAdded;
        }

        public final long getTimeRemoved() {
            return this.timeRemoved;
        }

        public final void setState(StateInfo stateInfo) {
            Intrinsics.checkNotNullParameter(stateInfo, "<set-?>");
            this.state = stateInfo;
        }

        public final void setTimeAdded(long j) {
            this.timeAdded = j;
        }

        public final void setTimeRemoved(long j) {
            this.timeRemoved = j;
        }
    }

    public final StateData getStateData$metrics_performance_release(long timeAdded, long timeRemoved, StateInfo state) {
        Intrinsics.checkNotNullParameter(state, "state");
        synchronized (this.stateDataPool) {
            if (this.stateDataPool.isEmpty()) {
                return new StateData(timeAdded, timeRemoved, state);
            }
            StateData stateDataRemove = this.stateDataPool.remove(0);
            stateDataRemove.setTimeAdded(timeAdded);
            stateDataRemove.setTimeRemoved(timeRemoved);
            stateDataRemove.setState(state);
            return stateDataRemove;
        }
    }

    public final void returnStateDataToPool$metrics_performance_release(StateData stateData) {
        Intrinsics.checkNotNullParameter(stateData, "stateData");
        synchronized (this.stateDataPool) {
            try {
                this.stateDataPool.add(stateData);
            } catch (OutOfMemoryError unused) {
                this.stateDataPool.clear();
                this.stateDataPool.add(stateData);
            }
        }
    }

    public final void removeState(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        markStateForRemoval(key);
    }

    public final void getIntervalStates$metrics_performance_release(long startTime, long endTime, List<StateInfo> frameStates) {
        Intrinsics.checkNotNullParameter(frameStates, "frameStates");
        synchronized (this.singleFrameStates) {
            frameStates.clear();
            addFrameState(startTime, endTime, frameStates, this.states);
            addFrameState(startTime, endTime, frameStates, this.singleFrameStates);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void cleanupSingleFrameStates$metrics_performance_release() {
        synchronized (this.singleFrameStates) {
            for (int size = this.singleFrameStates.size() - 1; -1 < size; size--) {
                if (this.singleFrameStates.get(size).getTimeRemoved() != -1) {
                    returnStateDataToPool$metrics_performance_release(this.singleFrameStates.remove(size));
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: PerformanceMetricsState.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0015\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\b\t¨\u0006\n"}, d2 = {"Landroidx/metrics/performance/PerformanceMetricsState$Companion;", "", "<init>", "()V", "getHolderForHierarchy", "Landroidx/metrics/performance/PerformanceMetricsState$Holder;", "view", "Landroid/view/View;", "create", "create$metrics_performance_release", "metrics-performance_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Holder getHolderForHierarchy(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            View rootView = view.getRootView();
            Object tag = rootView.getTag(R.id.metricsStateHolder);
            if (tag == null) {
                tag = new Holder();
                rootView.setTag(R.id.metricsStateHolder, tag);
            }
            return (Holder) tag;
        }

        @JvmStatic
        public final Holder create$metrics_performance_release(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            Holder holderForHierarchy = getHolderForHierarchy(view);
            if (holderForHierarchy.getState() == null) {
                holderForHierarchy.setState$metrics_performance_release(new PerformanceMetricsState(null));
            }
            return holderForHierarchy;
        }
    }

    /* JADX INFO: compiled from: PerformanceMetricsState.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003R(\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/metrics/performance/PerformanceMetricsState$Holder;", "", "<init>", "()V", "value", "Landroidx/metrics/performance/PerformanceMetricsState;", "state", "getState", "()Landroidx/metrics/performance/PerformanceMetricsState;", "setState$metrics_performance_release", "(Landroidx/metrics/performance/PerformanceMetricsState;)V", "metrics-performance_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Holder {
        private PerformanceMetricsState state;

        public final PerformanceMetricsState getState() {
            return this.state;
        }

        public final void setState$metrics_performance_release(PerformanceMetricsState performanceMetricsState) {
            this.state = performanceMetricsState;
        }
    }
}
