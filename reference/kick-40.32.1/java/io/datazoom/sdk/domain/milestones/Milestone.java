package io.datazoom.sdk.domain.milestones;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.hermes.intl.Constants;
import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: Milestone.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\nH&J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH&J\b\u0010\u000f\u001a\u00020\bH&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010À\u0006\u0003"}, d2 = {"Lio/datazoom/sdk/domain/milestones/Milestone;", "", "stateUpdate", "Lkotlinx/coroutines/flow/StateFlow;", "", "getStateUpdate", "()Lkotlinx/coroutines/flow/StateFlow;", "setTarget", "", TypedValues.Attributes.S_TARGET, "", "updateProgress", "progress", "", "duration", "reset", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface Milestone {
    StateFlow<Integer> getStateUpdate();

    void reset();

    void setTarget(List<Integer> target);

    void updateProgress(long progress, long duration);
}
