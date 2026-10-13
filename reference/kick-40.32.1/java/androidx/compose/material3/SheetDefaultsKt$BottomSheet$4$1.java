package androidx.compose.material3;

import androidx.activity.BackEventCompat;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.media3.muxer.WebmConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: SheetDefaults.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0010\u0010\u0002\u001a\f\u0012\b\u0012\u00060\u0004j\u0002`\u00050\u0003H\n"}, d2 = {"<anonymous>", "", "progress", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/activity/BackEventCompat;", "Landroidx/compose/material3/internal/BackEventCompat;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.SheetDefaultsKt$BottomSheet$4$1", f = "SheetDefaults.kt", i = {}, l = {WebmConstants.MkvEbmlElement.CUE_POINT, 192}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class SheetDefaultsKt$BottomSheet$4$1 extends SuspendLambda implements Function2<Flow<? extends BackEventCompat>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Animatable<Float, AnimationVector1D> $predictiveBackProgress;
    final /* synthetic */ Function0<Unit> $settleToDismiss;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SheetDefaultsKt$BottomSheet$4$1(Function0<Unit> function0, Animatable<Float, AnimationVector1D> animatable, Continuation<? super SheetDefaultsKt$BottomSheet$4$1> continuation) {
        super(2, continuation);
        this.$settleToDismiss = function0;
        this.$predictiveBackProgress = animatable;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SheetDefaultsKt$BottomSheet$4$1 sheetDefaultsKt$BottomSheet$4$1 = new SheetDefaultsKt$BottomSheet$4$1(this.$settleToDismiss, this.$predictiveBackProgress, continuation);
        sheetDefaultsKt$BottomSheet$4$1.L$0 = obj;
        return sheetDefaultsKt$BottomSheet$4$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Flow<? extends BackEventCompat> flow, Continuation<? super Unit> continuation) {
        return invoke2((Flow<BackEventCompat>) flow, continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Flow<BackEventCompat> flow, Continuation<? super Unit> continuation) {
        return ((SheetDefaultsKt$BottomSheet$4$1) create(flow, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0056, code lost:
    
        if (androidx.compose.animation.core.Animatable.animateTo$default(r11.$predictiveBackProgress, kotlin.coroutines.jvm.internal.Boxing.boxFloat(0.0f), null, null, null, r11, 14, null) == r0) goto L19;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r11.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.throwOnFailure(r12)
            goto L59
        L12:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L1a:
            kotlin.ResultKt.throwOnFailure(r12)     // Catch: java.util.concurrent.CancellationException -> L40
            goto L3a
        L1e:
            kotlin.ResultKt.throwOnFailure(r12)
            java.lang.Object r12 = r11.L$0
            kotlinx.coroutines.flow.Flow r12 = (kotlinx.coroutines.flow.Flow) r12
            androidx.compose.material3.SheetDefaultsKt$BottomSheet$4$1$1 r1 = new androidx.compose.material3.SheetDefaultsKt$BottomSheet$4$1$1     // Catch: java.util.concurrent.CancellationException -> L40
            androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r4 = r11.$predictiveBackProgress     // Catch: java.util.concurrent.CancellationException -> L40
            r1.<init>()     // Catch: java.util.concurrent.CancellationException -> L40
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1     // Catch: java.util.concurrent.CancellationException -> L40
            r4 = r11
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4     // Catch: java.util.concurrent.CancellationException -> L40
            r11.label = r3     // Catch: java.util.concurrent.CancellationException -> L40
            java.lang.Object r12 = r12.collect(r1, r4)     // Catch: java.util.concurrent.CancellationException -> L40
            if (r12 != r0) goto L3a
            goto L58
        L3a:
            kotlin.jvm.functions.Function0<kotlin.Unit> r12 = r11.$settleToDismiss     // Catch: java.util.concurrent.CancellationException -> L40
            r12.invoke()     // Catch: java.util.concurrent.CancellationException -> L40
            goto L59
        L40:
            androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r3 = r11.$predictiveBackProgress
            r12 = 0
            java.lang.Float r4 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r12)
            r8 = r11
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
            r11.label = r2
            r5 = 0
            r6 = 0
            r7 = 0
            r9 = 14
            r10 = 0
            java.lang.Object r11 = androidx.compose.animation.core.Animatable.animateTo$default(r3, r4, r5, r6, r7, r8, r9, r10)
            if (r11 != r0) goto L59
        L58:
            return r0
        L59:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SheetDefaultsKt$BottomSheet$4$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
