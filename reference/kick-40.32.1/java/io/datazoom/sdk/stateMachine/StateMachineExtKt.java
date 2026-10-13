package io.datazoom.sdk.stateMachine;

import com.facebook.hermes.intl.Constants;
import io.datazoom.sdk.StateEnv;
import io.datazoom.sdk.domain.StateTransitionProcessor;
import io.datazoom.sdk.stateMachine.timeSync.model.State;
import io.datazoom.sdk.time.Time;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StateMachineExt.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u0014\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001a\u0014\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001a\n\u0010\u0007\u001a\u00020\b*\u00020\u0002\u001a\u001e\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\n*\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002¨\u0006\f"}, d2 = {"defineAndProcessStates", "", "Lio/datazoom/sdk/stateMachine/StateMachine;", "env", "Lio/datazoom/sdk/StateEnv;", "defineContentStates", "defineAdStates", "adPlayingStateTime", "", "splitPlayingState", "", "Lio/datazoom/sdk/stateMachine/Transition;", Constants.SENSITIVITY_BASE}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class StateMachineExtKt {
    public static final void defineAndProcessStates(StateMachine stateMachine, StateEnv env) {
        Intrinsics.checkNotNullParameter(stateMachine, "<this>");
        Intrinsics.checkNotNullParameter(env, "env");
        defineContentStates(stateMachine, env);
        defineAdStates(stateMachine, env);
    }

    private static final void defineContentStates(StateMachine stateMachine, final StateEnv stateEnv) {
        stateMachine.defineState(new StateMapping(State.Content.IDLE.INSTANCE, SetsKt.setOf((Object[]) new State.Content[]{State.Content.REQUESTED.INSTANCE, State.Content.ERROR.INSTANCE}), null, null, 12, null));
        stateMachine.defineState(new StateMapping(State.Content.REQUESTED.INSTANCE, SetsKt.setOf((Object[]) new State[]{State.Content.BUFFERING.INSTANCE, State.Content.STOPPED.INSTANCE, State.Content.ERROR.INSTANCE, State.Ad.Break.STARTED.INSTANCE}), null, new Function1() { // from class: io.datazoom.sdk.stateMachine.StateMachineExtKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StateMachineExtKt.defineContentStates$lambda$0(stateEnv, (Transition) obj);
            }
        }, 4, null));
        stateMachine.defineState(new StateMapping(State.Content.BUFFERING.INSTANCE, SetsKt.setOf((Object[]) new State[]{State.Content.PLAYING.INSTANCE, State.Content.PAUSED.INSTANCE, State.Content.SEEKING.INSTANCE, State.Content.STOPPED.INSTANCE, State.Content.ERROR.INSTANCE, State.Content.REQUESTED.INSTANCE, State.Ad.Break.STARTED.INSTANCE}), new Function1() { // from class: io.datazoom.sdk.stateMachine.StateMachineExtKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StateMachineExtKt.defineContentStates$lambda$1(stateEnv, (Transition) obj);
            }
        }, new Function1() { // from class: io.datazoom.sdk.stateMachine.StateMachineExtKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StateMachineExtKt.defineContentStates$lambda$2(stateEnv, (Transition) obj);
            }
        }));
        stateMachine.defineState(new StateMapping(State.Content.PLAYING.INSTANCE, SetsKt.setOf((Object[]) new State[]{State.Content.BUFFERING.INSTANCE, State.Content.PAUSED.INSTANCE, State.Content.SEEKING.INSTANCE, State.Content.COMPLETED.INSTANCE, State.Content.STOPPED.INSTANCE, State.Content.ERROR.INSTANCE, State.Content.REQUESTED.INSTANCE, State.Ad.PLAYING.INSTANCE, State.Ad.Break.STARTED.INSTANCE}), new Function1() { // from class: io.datazoom.sdk.stateMachine.StateMachineExtKt$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StateMachineExtKt.defineContentStates$lambda$3(stateEnv, (Transition) obj);
            }
        }, new Function1() { // from class: io.datazoom.sdk.stateMachine.StateMachineExtKt$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StateMachineExtKt.defineContentStates$lambda$4(stateEnv, (Transition) obj);
            }
        }));
        stateMachine.defineState(new StateMapping(State.Content.PAUSED.INSTANCE, SetsKt.setOf((Object[]) new State[]{State.Content.BUFFERING.INSTANCE, State.Content.PLAYING.INSTANCE, State.Content.SEEKING.INSTANCE, State.Content.COMPLETED.INSTANCE, State.Content.STOPPED.INSTANCE, State.Content.ERROR.INSTANCE, State.Content.REQUESTED.INSTANCE, State.Ad.Break.STARTED.INSTANCE}), null, new Function1() { // from class: io.datazoom.sdk.stateMachine.StateMachineExtKt$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StateMachineExtKt.defineContentStates$lambda$5(stateEnv, (Transition) obj);
            }
        }, 4, null));
        stateMachine.defineState(new StateMapping(State.Content.SEEKING.INSTANCE, SetsKt.setOf((Object[]) new State[]{State.Content.BUFFERING.INSTANCE, State.Content.PLAYING.INSTANCE, State.Content.PAUSED.INSTANCE, State.Content.COMPLETED.INSTANCE, State.Content.STOPPED.INSTANCE, State.Content.ERROR.INSTANCE, State.Content.REQUESTED.INSTANCE, State.Ad.Break.STARTED.INSTANCE}), null, new Function1() { // from class: io.datazoom.sdk.stateMachine.StateMachineExtKt$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StateMachineExtKt.defineContentStates$lambda$6(stateEnv, (Transition) obj);
            }
        }, 4, null));
        stateMachine.defineState(new StateMapping(State.Content.COMPLETED.INSTANCE, SetsKt.setOf((Object[]) new State[]{State.Content.REQUESTED.INSTANCE, State.Ad.Break.STARTED.INSTANCE, State.Content.SEEKING.INSTANCE}), null, new Function1() { // from class: io.datazoom.sdk.stateMachine.StateMachineExtKt$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StateMachineExtKt.defineContentStates$lambda$7(stateEnv, (Transition) obj);
            }
        }, 4, null));
        stateMachine.defineState(new StateMapping(State.Content.STOPPED.INSTANCE, SetsKt.setOf(State.Content.REQUESTED.INSTANCE), null, new Function1() { // from class: io.datazoom.sdk.stateMachine.StateMachineExtKt$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StateMachineExtKt.defineContentStates$lambda$8(stateEnv, (Transition) obj);
            }
        }, 4, null));
        stateMachine.defineState(new StateMapping(State.Content.ERROR.INSTANCE, SetsKt.setOf(State.Content.REQUESTED.INSTANCE), null, new Function1() { // from class: io.datazoom.sdk.stateMachine.StateMachineExtKt$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StateMachineExtKt.defineContentStates$lambda$9(stateEnv, (Transition) obj);
            }
        }, 4, null));
    }

    static final Unit defineContentStates$lambda$0(StateEnv stateEnv, Transition it) {
        Intrinsics.checkNotNullParameter(it, "it");
        StateTransitionProcessor processor = stateEnv.getProcessor();
        if (processor != null) {
            processor.handleRequestedStateOnEntry(new StateMachineExtKt$defineContentStates$1$1(stateEnv));
        }
        return Unit.INSTANCE;
    }

    static final Unit defineContentStates$lambda$2(StateEnv stateEnv, Transition it) {
        Intrinsics.checkNotNullParameter(it, "it");
        StateTransitionProcessor processor = stateEnv.getProcessor();
        if (processor != null) {
            processor.handleBufferingStateOnEntry(it, new StateMachineExtKt$defineContentStates$3$1(stateEnv));
        }
        return Unit.INSTANCE;
    }

    static final Unit defineContentStates$lambda$1(StateEnv stateEnv, Transition it) {
        Intrinsics.checkNotNullParameter(it, "it");
        StateTransitionProcessor processor = stateEnv.getProcessor();
        if (processor != null) {
            processor.handleBufferingStateOnExit(new StateMachineExtKt$defineContentStates$2$1(stateEnv));
        }
        return Unit.INSTANCE;
    }

    static final Unit defineContentStates$lambda$4(StateEnv stateEnv, Transition it) {
        Intrinsics.checkNotNullParameter(it, "it");
        StateTransitionProcessor processor = stateEnv.getProcessor();
        if (processor != null) {
            processor.playingStateOnEntry(new StateMachineExtKt$defineContentStates$5$1(stateEnv));
        }
        return Unit.INSTANCE;
    }

    static final Unit defineContentStates$lambda$3(StateEnv stateEnv, Transition it) {
        Intrinsics.checkNotNullParameter(it, "it");
        StateTransitionProcessor processor = stateEnv.getProcessor();
        if (processor != null) {
            processor.playingStateOnExit();
        }
        return Unit.INSTANCE;
    }

    static final Unit defineContentStates$lambda$5(StateEnv stateEnv, Transition it) {
        Intrinsics.checkNotNullParameter(it, "it");
        StateTransitionProcessor processor = stateEnv.getProcessor();
        if (processor != null) {
            processor.pausedStateOnEntry(new StateMachineExtKt$defineContentStates$6$1(stateEnv));
        }
        return Unit.INSTANCE;
    }

    static final Unit defineContentStates$lambda$6(StateEnv stateEnv, Transition it) {
        Intrinsics.checkNotNullParameter(it, "it");
        StateTransitionProcessor processor = stateEnv.getProcessor();
        if (processor != null) {
            processor.seekingContentStateOnEntry(it.getPayload(), new StateMachineExtKt$defineContentStates$7$1(stateEnv));
        }
        return Unit.INSTANCE;
    }

    static final Unit defineContentStates$lambda$7(StateEnv stateEnv, Transition it) {
        Intrinsics.checkNotNullParameter(it, "it");
        StateTransitionProcessor processor = stateEnv.getProcessor();
        if (processor != null) {
            processor.contentCompletedStateOnEntry(new StateMachineExtKt$defineContentStates$8$1(stateEnv));
        }
        return Unit.INSTANCE;
    }

    static final Unit defineContentStates$lambda$8(StateEnv stateEnv, Transition it) {
        Intrinsics.checkNotNullParameter(it, "it");
        StateTransitionProcessor processor = stateEnv.getProcessor();
        if (processor != null) {
            processor.stoppedStateOnEntry(new StateMachineExtKt$defineContentStates$9$1(stateEnv));
        }
        return Unit.INSTANCE;
    }

    static final Unit defineContentStates$lambda$9(StateEnv stateEnv, Transition it) {
        Intrinsics.checkNotNullParameter(it, "it");
        StateTransitionProcessor processor = stateEnv.getProcessor();
        if (processor != null) {
            processor.handleErrorStateOnEntry(it.getPayload(), new StateMachineExtKt$defineContentStates$10$1(stateEnv));
        }
        return Unit.INSTANCE;
    }

    private static final void defineAdStates(StateMachine stateMachine, final StateEnv stateEnv) {
        stateMachine.defineState(new StateMapping(State.Ad.BUFFERING.INSTANCE, SetsKt.setOf((Object[]) new State[]{State.Ad.PLAYING.INSTANCE, State.Ad.PAUSED.INSTANCE, State.Ad.SEEKING.INSTANCE, State.Ad.SKIPPED.INSTANCE, State.Ad.ERROR.INSTANCE, State.Content.STOPPED.INSTANCE}), new Function1() { // from class: io.datazoom.sdk.stateMachine.StateMachineExtKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StateMachineExtKt.defineAdStates$lambda$0(stateEnv, (Transition) obj);
            }
        }, new Function1() { // from class: io.datazoom.sdk.stateMachine.StateMachineExtKt$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StateMachineExtKt.defineAdStates$lambda$1(stateEnv, (Transition) obj);
            }
        }));
        stateMachine.defineState(new StateMapping(State.Ad.PLAYING.INSTANCE, SetsKt.setOf((Object[]) new State[]{State.Ad.BUFFERING.INSTANCE, State.Ad.PAUSED.INSTANCE, State.Ad.SEEKING.INSTANCE, State.Ad.COMPLETED.INSTANCE, State.Ad.SKIPPED.INSTANCE, State.Ad.ERROR.INSTANCE, State.Content.STOPPED.INSTANCE}), null, new Function1() { // from class: io.datazoom.sdk.stateMachine.StateMachineExtKt$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StateMachineExtKt.defineAdStates$lambda$2(stateEnv, (Transition) obj);
            }
        }, 4, null));
        stateMachine.defineState(new StateMapping(State.Ad.SEEKING.INSTANCE, SetsKt.setOf((Object[]) new State[]{State.Ad.BUFFERING.INSTANCE, State.Ad.PAUSED.INSTANCE, State.Ad.COMPLETED.INSTANCE, State.Ad.ERROR.INSTANCE, State.Ad.PLAYING.INSTANCE, State.Content.PLAYING.INSTANCE, State.Ad.SKIPPED.INSTANCE}), null, new Function1() { // from class: io.datazoom.sdk.stateMachine.StateMachineExtKt$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StateMachineExtKt.defineAdStates$lambda$3(stateEnv, (Transition) obj);
            }
        }, 4, null));
        stateMachine.defineState(new StateMapping(State.Ad.PAUSED.INSTANCE, SetsKt.setOf((Object[]) new State[]{State.Ad.BUFFERING.INSTANCE, State.Ad.PLAYING.INSTANCE, State.Ad.SEEKING.INSTANCE, State.Ad.SKIPPED.INSTANCE, State.Ad.ERROR.INSTANCE, State.Content.STOPPED.INSTANCE}), null, new Function1() { // from class: io.datazoom.sdk.stateMachine.StateMachineExtKt$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StateMachineExtKt.defineAdStates$lambda$4(stateEnv, (Transition) obj);
            }
        }, 4, null));
        stateMachine.defineState(new StateMapping(State.Ad.STOPPED.INSTANCE, SetsKt.setOf((Object[]) new State[]{State.Ad.BUFFERING.INSTANCE, State.Ad.PLAYING.INSTANCE, State.Ad.PAUSED.INSTANCE, State.Ad.COMPLETED.INSTANCE, State.Ad.SKIPPED.INSTANCE, State.Ad.ERROR.INSTANCE, State.Content.STOPPED.INSTANCE}), null, new Function1() { // from class: io.datazoom.sdk.stateMachine.StateMachineExtKt$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StateMachineExtKt.defineAdStates$lambda$5(stateEnv, (Transition) obj);
            }
        }, 4, null));
        stateMachine.defineState(new StateMapping(State.Ad.COMPLETED.INSTANCE, SetsKt.setOf((Object[]) new State[]{State.Ad.BUFFERING.INSTANCE, State.Ad.PLAYING.INSTANCE, State.Ad.Break.ENDED.INSTANCE, State.Content.STOPPED.INSTANCE}), null, new Function1() { // from class: io.datazoom.sdk.stateMachine.StateMachineExtKt$$ExternalSyntheticLambda16
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StateMachineExtKt.defineAdStates$lambda$6(stateEnv, (Transition) obj);
            }
        }, 4, null));
        stateMachine.defineState(new StateMapping(State.Ad.SKIPPED.INSTANCE, SetsKt.setOf((Object[]) new State[]{State.Ad.BUFFERING.INSTANCE, State.Ad.PLAYING.INSTANCE, State.Ad.Break.ENDED.INSTANCE, State.Content.STOPPED.INSTANCE}), null, new Function1() { // from class: io.datazoom.sdk.stateMachine.StateMachineExtKt$$ExternalSyntheticLambda17
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StateMachineExtKt.defineAdStates$lambda$7(stateEnv, (Transition) obj);
            }
        }, 4, null));
        stateMachine.defineState(new StateMapping(State.Ad.ERROR.INSTANCE, SetsKt.setOf((Object[]) new State[]{State.Ad.BUFFERING.INSTANCE, State.Ad.PLAYING.INSTANCE, State.Ad.Break.ENDED.INSTANCE, State.Content.STOPPED.INSTANCE}), null, null, 12, null));
        stateMachine.defineState(new StateMapping(State.Ad.Break.STARTED.INSTANCE, SetsKt.setOf((Object[]) new State[]{State.Ad.BUFFERING.INSTANCE, State.Ad.PLAYING.INSTANCE, State.Ad.ERROR.INSTANCE, State.Ad.Break.ENDED.INSTANCE, State.Content.STOPPED.INSTANCE}), null, new Function1() { // from class: io.datazoom.sdk.stateMachine.StateMachineExtKt$$ExternalSyntheticLambda18
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StateMachineExtKt.defineAdStates$lambda$8(stateEnv, (Transition) obj);
            }
        }, 4, null));
        stateMachine.defineState(new StateMapping(State.Ad.Break.ENDED.INSTANCE, SetsKt.setOf((Object[]) new State.Content[]{State.Content.BUFFERING.INSTANCE, State.Content.PLAYING.INSTANCE, State.Content.PAUSED.INSTANCE, State.Content.SEEKING.INSTANCE, State.Content.COMPLETED.INSTANCE, State.Content.STOPPED.INSTANCE}), null, new Function1() { // from class: io.datazoom.sdk.stateMachine.StateMachineExtKt$$ExternalSyntheticLambda19
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StateMachineExtKt.defineAdStates$lambda$9(stateEnv, (Transition) obj);
            }
        }, 4, null));
    }

    static final Unit defineAdStates$lambda$1(StateEnv stateEnv, Transition it) {
        Intrinsics.checkNotNullParameter(it, "it");
        StateTransitionProcessor processor = stateEnv.getProcessor();
        if (processor != null) {
            processor.adBufferingStateOnEntry(it, new StateMachineExtKt$defineAdStates$2$1(stateEnv));
        }
        return Unit.INSTANCE;
    }

    static final Unit defineAdStates$lambda$0(StateEnv stateEnv, Transition it) {
        Intrinsics.checkNotNullParameter(it, "it");
        StateTransitionProcessor processor = stateEnv.getProcessor();
        if (processor != null) {
            processor.adBufferingStateOnExit(new StateMachineExtKt$defineAdStates$1$1(stateEnv));
        }
        return Unit.INSTANCE;
    }

    static final Unit defineAdStates$lambda$2(StateEnv stateEnv, Transition it) {
        Intrinsics.checkNotNullParameter(it, "it");
        StateTransitionProcessor processor = stateEnv.getProcessor();
        if (processor != null) {
            processor.adPlayingStateOnEntry(new StateMachineExtKt$defineAdStates$3$1(stateEnv));
        }
        return Unit.INSTANCE;
    }

    static final Unit defineAdStates$lambda$3(StateEnv stateEnv, Transition it) {
        Intrinsics.checkNotNullParameter(it, "it");
        StateTransitionProcessor processor = stateEnv.getProcessor();
        if (processor != null) {
            processor.seekingAdStateOnEntry(it.getPayload(), new StateMachineExtKt$defineAdStates$4$1(stateEnv));
        }
        return Unit.INSTANCE;
    }

    static final Unit defineAdStates$lambda$4(StateEnv stateEnv, Transition it) {
        Intrinsics.checkNotNullParameter(it, "it");
        StateTransitionProcessor processor = stateEnv.getProcessor();
        if (processor != null) {
            processor.adPausedStateOnEntry(new StateMachineExtKt$defineAdStates$5$1(stateEnv));
        }
        return Unit.INSTANCE;
    }

    static final Unit defineAdStates$lambda$5(StateEnv stateEnv, Transition it) {
        Intrinsics.checkNotNullParameter(it, "it");
        StateTransitionProcessor processor = stateEnv.getProcessor();
        if (processor != null) {
            processor.handleAdErrorStateOnEntry(it.getPayload(), new StateMachineExtKt$defineAdStates$6$1(stateEnv));
        }
        return Unit.INSTANCE;
    }

    static final Unit defineAdStates$lambda$6(StateEnv stateEnv, Transition it) {
        Intrinsics.checkNotNullParameter(it, "it");
        StateTransitionProcessor processor = stateEnv.getProcessor();
        if (processor != null) {
            processor.adCompletedStateOnEntry(new StateMachineExtKt$defineAdStates$7$1(stateEnv));
        }
        return Unit.INSTANCE;
    }

    static final Unit defineAdStates$lambda$7(StateEnv stateEnv, Transition it) {
        Intrinsics.checkNotNullParameter(it, "it");
        StateTransitionProcessor processor = stateEnv.getProcessor();
        if (processor != null) {
            processor.adSkippedStateOnEntry(new StateMachineExtKt$defineAdStates$8$1(stateEnv));
        }
        return Unit.INSTANCE;
    }

    static final Unit defineAdStates$lambda$8(StateEnv stateEnv, Transition it) {
        Intrinsics.checkNotNullParameter(it, "it");
        StateTransitionProcessor processor = stateEnv.getProcessor();
        if (processor != null) {
            processor.adBreakStartedStateOnEntry(new StateMachineExtKt$defineAdStates$9$1(stateEnv));
        }
        return Unit.INSTANCE;
    }

    static final Unit defineAdStates$lambda$9(StateEnv stateEnv, Transition it) {
        Intrinsics.checkNotNullParameter(it, "it");
        StateTransitionProcessor processor = stateEnv.getProcessor();
        if (processor != null) {
            processor.adBreakEndedStateOnEntry(new StateMachineExtKt$defineAdStates$10$1(stateEnv));
        }
        return Unit.INSTANCE;
    }

    public static final long adPlayingStateTime(StateMachine stateMachine) {
        Intrinsics.checkNotNullParameter(stateMachine, "<this>");
        List<Transition> listStateHistory = stateMachine.stateHistory(State.Ad.PLAYING.INSTANCE);
        if (listStateHistory.isEmpty()) {
            return 0L;
        }
        Iterator<T> it = splitPlayingState(listStateHistory).iterator();
        long timestamp = 0;
        while (it.hasNext()) {
            List list = (List) it.next();
            int i = 0;
            for (Object obj : list) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Transition transition = (Transition) obj;
                if (i != list.size() - 1 || Intrinsics.areEqual(transition.getNewState(), State.Ad.PLAYING.INSTANCE)) {
                    Transition transition2 = (Transition) CollectionsKt.getOrNull(list, i2);
                    timestamp += (transition2 != null ? transition2.getTimestamp() : Time.INSTANCE.now()) - transition.getTimestamp();
                }
                i = i2;
            }
        }
        if (timestamp < 100) {
            return 0L;
        }
        return timestamp;
    }

    private static final List<List<Transition>> splitPlayingState(List<Transition> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Transition transition : list) {
            arrayList2.add(transition);
            if (Intrinsics.areEqual(transition.getNewState(), State.Ad.COMPLETED.INSTANCE)) {
                arrayList.add(arrayList2);
                arrayList2 = new ArrayList();
            }
        }
        if (!arrayList2.isEmpty()) {
            arrayList.add(arrayList2);
        }
        return arrayList;
    }
}
