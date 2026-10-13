package io.datazoom.sdk.domain.milestones;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.hermes.intl.Constants;
import io.datazoom.sdk.utils.PrimitiveExtensionsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: Milestone.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u000eH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lio/datazoom/sdk/domain/milestones/MilestoneImp;", "Lio/datazoom/sdk/domain/milestones/Milestone;", "<init>", "()V", "_milestoneState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lio/datazoom/sdk/domain/milestones/MilestoneImp$MilestoneState;", "_state", "", "stateUpdate", "Lkotlinx/coroutines/flow/StateFlow;", "getStateUpdate", "()Lkotlinx/coroutines/flow/StateFlow;", "setTarget", "", TypedValues.Attributes.S_TARGET, "", "updateProgress", "progress", "", "duration", "reset", "MilestoneState", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MilestoneImp implements Milestone {
    private final MutableStateFlow<MilestoneState> _milestoneState = StateFlowKt.MutableStateFlow(new MilestoneState(null, 0, 3, null == true ? 1 : 0));
    private final MutableStateFlow<Integer> _state = StateFlowKt.MutableStateFlow(0);

    /* JADX INFO: compiled from: Milestone.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B!\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0004HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0004HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lio/datazoom/sdk/domain/milestones/MilestoneImp$MilestoneState;", "", "milestones", "", "", "lastEmitted", "<init>", "(Ljava/util/List;I)V", "getMilestones", "()Ljava/util/List;", "getLastEmitted", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
    private static final /* data */ class MilestoneState {
        private final int lastEmitted;
        private final List<Integer> milestones;

        /* JADX WARN: Multi-variable type inference failed */
        public MilestoneState() {
            this(null, 0, 3, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ MilestoneState copy$default(MilestoneState milestoneState, List list, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                list = milestoneState.milestones;
            }
            if ((i2 & 2) != 0) {
                i = milestoneState.lastEmitted;
            }
            return milestoneState.copy(list, i);
        }

        public final List<Integer> component1() {
            return this.milestones;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getLastEmitted() {
            return this.lastEmitted;
        }

        public final MilestoneState copy(List<Integer> milestones, int lastEmitted) {
            Intrinsics.checkNotNullParameter(milestones, "milestones");
            return new MilestoneState(milestones, lastEmitted);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MilestoneState)) {
                return false;
            }
            MilestoneState milestoneState = (MilestoneState) other;
            return Intrinsics.areEqual(this.milestones, milestoneState.milestones) && this.lastEmitted == milestoneState.lastEmitted;
        }

        public int hashCode() {
            return (this.milestones.hashCode() * 31) + Integer.hashCode(this.lastEmitted);
        }

        public String toString() {
            return "MilestoneState(milestones=" + this.milestones + ", lastEmitted=" + this.lastEmitted + ")";
        }

        public MilestoneState(List<Integer> milestones, int i) {
            Intrinsics.checkNotNullParameter(milestones, "milestones");
            this.milestones = milestones;
            this.lastEmitted = i;
        }

        public /* synthetic */ MilestoneState(List list, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? CollectionsKt.emptyList() : list, (i2 & 2) != 0 ? 0 : i);
        }

        public final List<Integer> getMilestones() {
            return this.milestones;
        }

        public final int getLastEmitted() {
            return this.lastEmitted;
        }
    }

    @Override // io.datazoom.sdk.domain.milestones.Milestone
    public StateFlow<Integer> getStateUpdate() {
        return FlowKt.asStateFlow(this._state);
    }

    @Override // io.datazoom.sdk.domain.milestones.Milestone
    public void setTarget(List<Integer> target) {
        Intrinsics.checkNotNullParameter(target, "target");
        MutableStateFlow<MilestoneState> mutableStateFlow = this._milestoneState;
        while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), new MilestoneState(target, 0))) {
        }
    }

    @Override // io.datazoom.sdk.domain.milestones.Milestone
    public void updateProgress(long progress, long duration) {
        MilestoneState value;
        MilestoneState milestoneState;
        ArrayList arrayList;
        if (duration <= 0) {
            return;
        }
        long jDividedBy = PrimitiveExtensionsKt.dividedBy(Long.valueOf(progress * 100), duration);
        MutableStateFlow<MilestoneState> mutableStateFlow = this._milestoneState;
        do {
            value = mutableStateFlow.getValue();
            milestoneState = value;
            List<Integer> milestones = milestoneState.getMilestones();
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : milestones) {
                if (((Number) obj).intValue() <= ((int) jDividedBy)) {
                    arrayList2.add(obj);
                }
            }
            arrayList = arrayList2;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this._state.tryEmit(Integer.valueOf(((Number) it.next()).intValue()));
            }
        } while (!mutableStateFlow.compareAndSet(value, MilestoneState.copy$default(milestoneState, CollectionsKt.minus((Iterable) milestoneState.getMilestones(), (Iterable) CollectionsKt.toSet(arrayList)), 0, 2, null)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.datazoom.sdk.domain.milestones.Milestone
    public void reset() {
        MutableStateFlow<MilestoneState> mutableStateFlow = this._milestoneState;
        do {
        } while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), new MilestoneState(null, 0, 3, null == true ? 1 : 0)));
        this._state.tryEmit(0);
    }
}
