package expo.modules.ui;

import androidx.compose.material3.SnackbarDuration;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.material3.SnackbarResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: SnackbarView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroidx/compose/material3/SnackbarResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.ui.SnackbarViewKt$SnackbarHostContent$1$1$result$1", f = "SnackbarView.kt", i = {}, l = {94}, m = "invokeSuspend", n = {}, s = {})
final class SnackbarViewKt$SnackbarHostContent$1$1$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SnackbarResult>, Object> {
    final /* synthetic */ SnackbarDuration $duration;
    final /* synthetic */ SnackbarHostState $hostState;
    final /* synthetic */ SnackbarShowOptions $options;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SnackbarViewKt$SnackbarHostContent$1$1$result$1(SnackbarHostState snackbarHostState, SnackbarShowOptions snackbarShowOptions, SnackbarDuration snackbarDuration, Continuation<? super SnackbarViewKt$SnackbarHostContent$1$1$result$1> continuation) {
        super(2, continuation);
        this.$hostState = snackbarHostState;
        this.$options = snackbarShowOptions;
        this.$duration = snackbarDuration;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SnackbarViewKt$SnackbarHostContent$1$1$result$1(this.$hostState, this.$options, this.$duration, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super SnackbarResult> continuation) {
        return ((SnackbarViewKt$SnackbarHostContent$1$1$result$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        ResultKt.throwOnFailure(obj);
        this.label = 1;
        Object objShowSnackbar = this.$hostState.showSnackbar(this.$options.getMessage(), this.$options.getActionLabel(), this.$options.getWithDismissAction(), this.$duration, this);
        return objShowSnackbar == coroutine_suspended ? coroutine_suspended : objShowSnackbar;
    }
}
