package expo.modules.ui;

import androidx.compose.material3.DateRangePickerState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: DateRangePickerView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.ui.DateRangePickerViewKt$rememberDateRangePickerState$1$1", f = "DateRangePickerView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DateRangePickerViewKt$rememberDateRangePickerState$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Long $initialEndDate;
    final /* synthetic */ Long $initialStartDate;
    final /* synthetic */ DateRangePickerState $state;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DateRangePickerViewKt$rememberDateRangePickerState$1$1(DateRangePickerState dateRangePickerState, Long l, Long l2, Continuation<? super DateRangePickerViewKt$rememberDateRangePickerState$1$1> continuation) {
        super(2, continuation);
        this.$state = dateRangePickerState;
        this.$initialStartDate = l;
        this.$initialEndDate = l2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DateRangePickerViewKt$rememberDateRangePickerState$1$1(this.$state, this.$initialStartDate, this.$initialEndDate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DateRangePickerViewKt$rememberDateRangePickerState$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        if (!Intrinsics.areEqual(this.$state.getSelectedStartDateMillis(), this.$initialStartDate) || !Intrinsics.areEqual(this.$state.getSelectedEndDateMillis(), this.$initialEndDate)) {
            try {
                this.$state.setSelection(this.$initialStartDate, this.$initialEndDate);
            } catch (IllegalArgumentException unused) {
            }
        }
        return Unit.INSTANCE;
    }
}
