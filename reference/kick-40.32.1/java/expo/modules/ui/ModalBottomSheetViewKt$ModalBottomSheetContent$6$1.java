package expo.modules.ui;

import androidx.compose.material3.SheetState;
import androidx.media3.muxer.WebmConstants;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: ModalBottomSheetView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.ui.ModalBottomSheetViewKt$ModalBottomSheetContent$6$1", f = "ModalBottomSheetView.kt", i = {}, l = {WebmConstants.MkvEbmlElement.PIXEL_HEIGHT}, m = "invokeSuspend", n = {}, s = {})
final class ModalBottomSheetViewKt$ModalBottomSheetContent$6$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ModalBottomSheetViewProps $props;
    final /* synthetic */ SheetState $sheetState;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ModalBottomSheetViewKt$ModalBottomSheetContent$6$1(ModalBottomSheetViewProps modalBottomSheetViewProps, SheetState sheetState, Continuation<? super ModalBottomSheetViewKt$ModalBottomSheetContent$6$1> continuation) {
        super(2, continuation);
        this.$props = modalBottomSheetViewProps;
        this.$sheetState = sheetState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ModalBottomSheetViewKt$ModalBottomSheetContent$6$1(this.$props, this.$sheetState, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ModalBottomSheetViewKt$ModalBottomSheetContent$6$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (this.$props.getInitialFullyExpanded() && !this.$props.getSkipPartiallyExpanded()) {
                    this.label = 1;
                    if (this.$sheetState.expand(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        } catch (CancellationException | Exception unused) {
        }
        return Unit.INSTANCE;
    }
}
