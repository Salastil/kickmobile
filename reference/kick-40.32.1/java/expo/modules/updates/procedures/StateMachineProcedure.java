package expo.modules.updates.procedures;

import expo.modules.updates.statemachine.UpdatesStateEvent;
import expo.modules.updates.statemachine.UpdatesStateValue;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: StateMachineProcedure.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001:\u0002\r\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\bR\u0012\u0010\t\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lexpo/modules/updates/procedures/StateMachineProcedure;", "", "<init>", "()V", "run", "", "procedureContext", "Lexpo/modules/updates/procedures/StateMachineProcedure$ProcedureContext;", "(Lexpo/modules/updates/procedures/StateMachineProcedure$ProcedureContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loggerTimerLabel", "", "getLoggerTimerLabel", "()Ljava/lang/String;", "StateMachineProcedureContext", "ProcedureContext", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class StateMachineProcedure {

    /* JADX INFO: compiled from: StateMachineProcedure.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004À\u0006\u0003"}, d2 = {"Lexpo/modules/updates/procedures/StateMachineProcedure$ProcedureContext;", "Lexpo/modules/updates/procedures/StateMachineProcedure$StateMachineProcedureContext;", "onComplete", "", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public interface ProcedureContext extends StateMachineProcedureContext {
        void onComplete();
    }

    /* JADX INFO: compiled from: StateMachineProcedure.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H'J\b\u0010\b\u001a\u00020\u0003H&¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lexpo/modules/updates/procedures/StateMachineProcedure$StateMachineProcedureContext;", "", "processStateEvent", "", "event", "Lexpo/modules/updates/statemachine/UpdatesStateEvent;", "getCurrentState", "Lexpo/modules/updates/statemachine/UpdatesStateValue;", "resetStateAfterRestart", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public interface StateMachineProcedureContext {
        @Deprecated(message = "Avoid needing to access current state to know how to transition to next state")
        UpdatesStateValue getCurrentState();

        void processStateEvent(UpdatesStateEvent event);

        void resetStateAfterRestart();
    }

    public abstract String getLoggerTimerLabel();

    public abstract Object run(ProcedureContext procedureContext, Continuation<? super Unit> continuation);
}
