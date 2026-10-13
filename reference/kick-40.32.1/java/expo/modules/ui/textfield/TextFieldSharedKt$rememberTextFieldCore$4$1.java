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
import kotlin.jvm.functions.Function3;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: TextFieldShared.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", ViewProps.START, "", ViewProps.END}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.ui.textfield.TextFieldSharedKt$rememberTextFieldCore$4$1", f = "TextFieldShared.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class TextFieldSharedKt$rememberTextFieldCore$4$1 extends SuspendLambda implements Function3<Integer, Integer, Continuation<? super Unit>, Object> {
    final /* synthetic */ ObservableState $selection;
    final /* synthetic */ ObservableState $state;
    /* synthetic */ int I$0;
    /* synthetic */ int I$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TextFieldSharedKt$rememberTextFieldCore$4$1(ObservableState observableState, ObservableState observableState2, Continuation<? super TextFieldSharedKt$rememberTextFieldCore$4$1> continuation) {
        super(3, continuation);
        this.$state = observableState;
        this.$selection = observableState2;
    }

    public final Object invoke(int i, int i2, Continuation<? super Unit> continuation) {
        TextFieldSharedKt$rememberTextFieldCore$4$1 textFieldSharedKt$rememberTextFieldCore$4$1 = new TextFieldSharedKt$rememberTextFieldCore$4$1(this.$state, this.$selection, continuation);
        textFieldSharedKt$rememberTextFieldCore$4$1.I$0 = i;
        textFieldSharedKt$rememberTextFieldCore$4$1.I$1 = i2;
        return textFieldSharedKt$rememberTextFieldCore$4$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Integer num, Integer num2, Continuation<? super Unit> continuation) {
        return invoke(num.intValue(), num2.intValue(), continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        int i = this.I$0;
        int i2 = this.I$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        Object value = this.$state.getValue();
        String str = value instanceof String ? (String) value : null;
        if (str == null) {
            str = "";
        }
        this.$selection.setValue(MapsKt.mapOf(TuplesKt.to(ViewProps.START, Boxing.boxInt(RangesKt.coerceIn(i, 0, str.length()))), TuplesKt.to(ViewProps.END, Boxing.boxInt(RangesKt.coerceIn(i2, 0, str.length())))));
        return Unit.INSTANCE;
    }
}
