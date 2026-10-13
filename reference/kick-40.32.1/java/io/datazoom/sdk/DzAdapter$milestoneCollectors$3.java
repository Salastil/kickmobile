package io.datazoom.sdk;

import io.datazoom.sdk.model.Event;
import io.datazoom.sdk.model.EventKt;
import io.datazoom.sdk.model.MetaData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: DzAdapter.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "seconds", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.datazoom.sdk.DzAdapter$milestoneCollectors$3", f = "DzAdapter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
final class DzAdapter$milestoneCollectors$3 extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {
    /* synthetic */ int I$0;
    int label;
    final /* synthetic */ DzAdapter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DzAdapter$milestoneCollectors$3(DzAdapter dzAdapter, Continuation<? super DzAdapter$milestoneCollectors$3> continuation) {
        super(2, continuation);
        this.this$0 = dzAdapter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DzAdapter$milestoneCollectors$3 dzAdapter$milestoneCollectors$3 = new DzAdapter$milestoneCollectors$3(this.this$0, continuation);
        dzAdapter$milestoneCollectors$3.I$0 = ((Number) obj).intValue();
        return dzAdapter$milestoneCollectors$3;
    }

    public final Object invoke(int i, Continuation<? super Unit> continuation) {
        return ((DzAdapter$milestoneCollectors$3) create(Integer.valueOf(i), continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Integer num, Continuation<? super Unit> continuation) {
        return invoke(num.intValue(), continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        int i = this.I$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.this$0.sendEvent(EventKt.toContentEvent$default(Event.Type.QualifiedView, 0L, null, MapsKt.hashMapOf(TuplesKt.to(MetaData.Type.QUALIFIED_VIEW_SEC.getValue(), Boxing.boxInt(i))), null, 11, null));
        return Unit.INSTANCE;
    }
}
