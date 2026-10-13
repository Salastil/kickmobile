package io.datazoom.sdk.stateMachine;

import io.datazoom.sdk.StateEnv;
import io.datazoom.sdk.model.Event;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StateMachineExt.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
final /* synthetic */ class StateMachineExtKt$defineContentStates$6$1 extends FunctionReferenceImpl implements Function1<Event, Unit> {
    StateMachineExtKt$defineContentStates$6$1(Object obj) {
        super(1, obj, StateEnv.class, "send", "send(Lio/datazoom/sdk/model/Event;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Event event) {
        invoke2(event);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Event p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((StateEnv) this.receiver).send(p0);
    }
}
