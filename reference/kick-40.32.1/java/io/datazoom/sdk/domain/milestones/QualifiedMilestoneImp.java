package io.datazoom.sdk.domain.milestones;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.hermes.intl.Constants;
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
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u000eH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lio/datazoom/sdk/domain/milestones/QualifiedMilestoneImp;", "Lio/datazoom/sdk/domain/milestones/Milestone;", "<init>", "()V", "_criteriaState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lio/datazoom/sdk/domain/milestones/QualifiedMilestoneImp$CriteriaState;", "_state", "", "stateUpdate", "Lkotlinx/coroutines/flow/StateFlow;", "getStateUpdate", "()Lkotlinx/coroutines/flow/StateFlow;", "setTarget", "", TypedValues.Attributes.S_TARGET, "", "updateProgress", "progress", "", "duration", "reset", "CriteriaState", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class QualifiedMilestoneImp implements Milestone {
    private final MutableStateFlow<CriteriaState> _criteriaState = StateFlowKt.MutableStateFlow(new CriteriaState(null, 0, 3, null == true ? 1 : 0));
    private final MutableStateFlow<Integer> _state = StateFlowKt.MutableStateFlow(0);

    /* JADX INFO: compiled from: Milestone.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B!\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0004HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0004HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lio/datazoom/sdk/domain/milestones/QualifiedMilestoneImp$CriteriaState;", "", "criteria", "", "", "lastEmitted", "<init>", "(Ljava/util/List;I)V", "getCriteria", "()Ljava/util/List;", "getLastEmitted", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
    private static final /* data */ class CriteriaState {
        private final List<Integer> criteria;
        private final int lastEmitted;

        /* JADX WARN: Multi-variable type inference failed */
        public CriteriaState() {
            this(null, 0, 3, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ CriteriaState copy$default(CriteriaState criteriaState, List list, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                list = criteriaState.criteria;
            }
            if ((i2 & 2) != 0) {
                i = criteriaState.lastEmitted;
            }
            return criteriaState.copy(list, i);
        }

        public final List<Integer> component1() {
            return this.criteria;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getLastEmitted() {
            return this.lastEmitted;
        }

        public final CriteriaState copy(List<Integer> criteria, int lastEmitted) {
            Intrinsics.checkNotNullParameter(criteria, "criteria");
            return new CriteriaState(criteria, lastEmitted);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CriteriaState)) {
                return false;
            }
            CriteriaState criteriaState = (CriteriaState) other;
            return Intrinsics.areEqual(this.criteria, criteriaState.criteria) && this.lastEmitted == criteriaState.lastEmitted;
        }

        public int hashCode() {
            return (this.criteria.hashCode() * 31) + Integer.hashCode(this.lastEmitted);
        }

        public String toString() {
            return "CriteriaState(criteria=" + this.criteria + ", lastEmitted=" + this.lastEmitted + ")";
        }

        public CriteriaState(List<Integer> criteria, int i) {
            Intrinsics.checkNotNullParameter(criteria, "criteria");
            this.criteria = criteria;
            this.lastEmitted = i;
        }

        public /* synthetic */ CriteriaState(List list, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? CollectionsKt.emptyList() : list, (i2 & 2) != 0 ? 0 : i);
        }

        public final List<Integer> getCriteria() {
            return this.criteria;
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
        MutableStateFlow<CriteriaState> mutableStateFlow = this._criteriaState;
        while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), new CriteriaState(target, 0))) {
        }
    }

    @Override // io.datazoom.sdk.domain.milestones.Milestone
    public void updateProgress(long progress, long duration) {
        CriteriaState value;
        CriteriaState criteriaStateCopy$default;
        if (progress == 0) {
            return;
        }
        MutableStateFlow<CriteriaState> mutableStateFlow = this._criteriaState;
        do {
            value = mutableStateFlow.getValue();
            criteriaStateCopy$default = value;
            if (!criteriaStateCopy$default.getCriteria().isEmpty()) {
                List<Integer> criteria = criteriaStateCopy$default.getCriteria();
                ArrayList arrayList = new ArrayList();
                for (Object obj : criteria) {
                    if (((Number) obj).intValue() <= progress) {
                        arrayList.add(obj);
                    }
                }
                ArrayList arrayList2 = arrayList;
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    this._state.tryEmit(Integer.valueOf(((Number) it.next()).intValue()));
                }
                criteriaStateCopy$default = CriteriaState.copy$default(criteriaStateCopy$default, CollectionsKt.minus((Iterable) criteriaStateCopy$default.getCriteria(), (Iterable) CollectionsKt.toSet(arrayList2)), 0, 2, null);
            }
        } while (!mutableStateFlow.compareAndSet(value, criteriaStateCopy$default));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.datazoom.sdk.domain.milestones.Milestone
    public void reset() {
        MutableStateFlow<CriteriaState> mutableStateFlow = this._criteriaState;
        do {
        } while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), new CriteriaState(null, 0, 3, null == true ? 1 : 0)));
        this._state.tryEmit(0);
    }
}
