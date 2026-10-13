package io.datazoom.sdk.utils;

import com.facebook.hermes.intl.Constants;
import io.datazoom.sdk.model.Event;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SendEventProxy.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\u0006¢\u0006\u0002\u0010\u000eJ\u0006\u0010\u000f\u001a\u00020\u0007R(\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lio/datazoom/sdk/utils/SendEventProxy;", "", "<init>", "()V", "delegate", "Lkotlin/Function1;", "Lio/datazoom/sdk/model/Event;", "", "getDelegate", "()Lkotlin/jvm/functions/Function1;", "setDelegate", "(Lkotlin/jvm/functions/Function1;)V", "send", "e", "(Lio/datazoom/sdk/model/Event;)Lkotlin/Unit;", "close", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SendEventProxy {
    private Function1<? super Event, Unit> delegate;

    public final Function1<Event, Unit> getDelegate() {
        return this.delegate;
    }

    public final void setDelegate(Function1<? super Event, Unit> function1) {
        this.delegate = function1;
    }

    public final Unit send(Event e) {
        Intrinsics.checkNotNullParameter(e, "e");
        Function1<? super Event, Unit> function1 = this.delegate;
        if (function1 == null) {
            return null;
        }
        function1.invoke(e);
        return Unit.INSTANCE;
    }

    public final void close() {
        this.delegate = null;
    }
}
