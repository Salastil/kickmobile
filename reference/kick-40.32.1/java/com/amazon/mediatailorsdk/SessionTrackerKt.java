package com.amazon.mediatailorsdk;

import androidx.core.view.PointerIconCompat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;

/* JADX INFO: compiled from: SessionTracker.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a*\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0080@¢\u0006\u0002\u0010\f\"\u0016\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0003¨\u0006\r"}, d2 = {"adTrackingQuartileEvents", "", "Lcom/amazon/mediatailorsdk/AdTrackingEvent;", "[Lcom/amazon/mediatailorsdk/AdTrackingEvent;", "createSessionTracker", "Lcom/amazon/mediatailorsdk/SessionTracker;", "trackingUrl", "", "palNonceManager", "Lcom/amazon/mediatailorsdk/PalNonceManagerWrapper;", "config", "Lcom/amazon/mediatailorsdk/SessionConfiguration;", "(Ljava/lang/String;Lcom/amazon/mediatailorsdk/PalNonceManagerWrapper;Lcom/amazon/mediatailorsdk/SessionConfiguration;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "MediaTailor_release"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class SessionTrackerKt {
    private static AdTrackingEvent[] adTrackingQuartileEvents = {AdTrackingEvent.FIRST_QUARTILE, AdTrackingEvent.MID_POINT, AdTrackingEvent.THIRD_QUARTILE, AdTrackingEvent.COMPLETE};

    /* JADX INFO: renamed from: com.amazon.mediatailorsdk.SessionTrackerKt$createSessionTracker$1, reason: invalid class name */
    /* JADX INFO: compiled from: SessionTracker.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.amazon.mediatailorsdk.SessionTrackerKt", f = "SessionTracker.kt", i = {0, 0, 0, 0}, l = {1013}, m = "createSessionTracker", n = {"trackingUrl", "palNonceManager", "config", "tracker"}, nl = {PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW}, s = {"L$0", "L$1", "L$2", "L$3"}, v = 2)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SessionTrackerKt.createSessionTracker(null, null, null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object createSessionTracker(String str, PalNonceManagerWrapper palNonceManagerWrapper, SessionConfiguration sessionConfiguration, Continuation<? super SessionTracker> continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        AnonymousClass1 anonymousClass2 = anonymousClass1;
        Object obj = anonymousClass2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass2.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            SessionTracker sessionTracker = (SessionTracker) anonymousClass2.L$3;
            ResultKt.throwOnFailure(obj);
            return sessionTracker;
        }
        ResultKt.throwOnFailure(obj);
        SessionTracker sessionTracker2 = new SessionTracker(str, palNonceManagerWrapper, sessionConfiguration);
        if (sessionTracker2.getTrackingRequestInterval() >= 0.0d) {
            anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str);
            anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(palNonceManagerWrapper);
            anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(sessionConfiguration);
            anonymousClass2.L$3 = sessionTracker2;
            anonymousClass2.label = 1;
            if (SessionTracker.requestAdTrackingInfo$default(sessionTracker2, 0.0d, null, anonymousClass2, 2, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return sessionTracker2;
    }
}
