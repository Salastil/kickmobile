package io.datazoom.sdk;

import com.facebook.hermes.intl.Constants;
import io.datazoom.sdk.domain.StateTransitionProcessor;
import io.datazoom.sdk.model.Event;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StateEnv.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u0001B'\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0006R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR(\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lio/datazoom/sdk/StateEnv;", "", "processor", "Lio/datazoom/sdk/domain/StateTransitionProcessor;", "sender", "Lkotlin/Function1;", "Lio/datazoom/sdk/model/Event;", "", "<init>", "(Lio/datazoom/sdk/domain/StateTransitionProcessor;Lkotlin/jvm/functions/Function1;)V", "getProcessor", "()Lio/datazoom/sdk/domain/StateTransitionProcessor;", "setProcessor", "(Lio/datazoom/sdk/domain/StateTransitionProcessor;)V", "getSender", "()Lkotlin/jvm/functions/Function1;", "setSender", "(Lkotlin/jvm/functions/Function1;)V", "send", "e", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class StateEnv {
    private StateTransitionProcessor processor;
    private Function1<? super Event, Unit> sender;

    public StateEnv(StateTransitionProcessor stateTransitionProcessor, Function1<? super Event, Unit> function1) {
        this.processor = stateTransitionProcessor;
        this.sender = function1;
    }

    public final StateTransitionProcessor getProcessor() {
        return this.processor;
    }

    public final void setProcessor(StateTransitionProcessor stateTransitionProcessor) {
        this.processor = stateTransitionProcessor;
    }

    public final Function1<Event, Unit> getSender() {
        return this.sender;
    }

    public final void setSender(Function1<? super Event, Unit> function1) {
        this.sender = function1;
    }

    public final void send(Event e) {
        Intrinsics.checkNotNullParameter(e, "e");
        Function1<? super Event, Unit> function1 = this.sender;
        if (function1 != null) {
            function1.invoke(e);
        }
    }
}
