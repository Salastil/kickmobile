package io.datazoom.sdk.stateMachine;

import com.facebook.hermes.intl.Constants;
import io.datazoom.sdk.stateMachine.timeSync.model.State;
import kotlin.Metadata;

/* JADX INFO: compiled from: StateTransitionListener.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lio/datazoom/sdk/stateMachine/StateTransitionListener;", "", "onStateTransition", "", "newState", "Lio/datazoom/sdk/stateMachine/timeSync/model/State;", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface StateTransitionListener {
    void onStateTransition(State newState);
}
