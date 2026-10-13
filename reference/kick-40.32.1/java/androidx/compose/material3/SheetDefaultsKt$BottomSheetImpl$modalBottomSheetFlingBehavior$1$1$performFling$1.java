package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: SheetDefaults.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.SheetDefaultsKt$BottomSheetImpl$modalBottomSheetFlingBehavior$1$1", f = "SheetDefaults.kt", i = {}, l = {281}, m = "performFling", n = {}, s = {}, v = 1)
final class SheetDefaultsKt$BottomSheetImpl$modalBottomSheetFlingBehavior$1$1$performFling$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SheetDefaultsKt$BottomSheetImpl$modalBottomSheetFlingBehavior$1$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SheetDefaultsKt$BottomSheetImpl$modalBottomSheetFlingBehavior$1$1$performFling$1(SheetDefaultsKt$BottomSheetImpl$modalBottomSheetFlingBehavior$1$1 sheetDefaultsKt$BottomSheetImpl$modalBottomSheetFlingBehavior$1$1, Continuation<? super SheetDefaultsKt$BottomSheetImpl$modalBottomSheetFlingBehavior$1$1$performFling$1> continuation) {
        super(continuation);
        this.this$0 = sheetDefaultsKt$BottomSheetImpl$modalBottomSheetFlingBehavior$1$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.performFling(null, 0.0f, this);
    }
}
