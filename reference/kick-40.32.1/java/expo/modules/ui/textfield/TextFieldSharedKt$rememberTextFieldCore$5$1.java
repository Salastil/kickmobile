package expo.modules.ui.textfield;

import com.facebook.react.uimanager.ViewProps;
import expo.modules.ui.state.ObservableState;
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

/* JADX INFO: compiled from: TextFieldShared.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "", "it"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.ui.textfield.TextFieldSharedKt$rememberTextFieldCore$5$1", f = "TextFieldShared.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class TextFieldSharedKt$rememberTextFieldCore$5$1 extends SuspendLambda implements Function2<Unit, Continuation<? super Unit>, Object> {
    final /* synthetic */ ObservableState $selection;
    final /* synthetic */ ObservableState $state;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TextFieldSharedKt$rememberTextFieldCore$5$1(ObservableState observableState, ObservableState observableState2, Continuation<? super TextFieldSharedKt$rememberTextFieldCore$5$1> continuation) {
        super(2, continuation);
        this.$state = observableState;
        this.$selection = observableState2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TextFieldSharedKt$rememberTextFieldCore$5$1(this.$state, this.$selection, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Unit unit, Continuation<? super Unit> continuation) {
        return ((TextFieldSharedKt$rememberTextFieldCore$5$1) create(unit, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.$state.setValue("");
        this.$selection.setValue(MapsKt.mapOf(TuplesKt.to(ViewProps.START, Boxing.boxInt(0)), TuplesKt.to(ViewProps.END, Boxing.boxInt(0))));
        return Unit.INSTANCE;
    }
}
