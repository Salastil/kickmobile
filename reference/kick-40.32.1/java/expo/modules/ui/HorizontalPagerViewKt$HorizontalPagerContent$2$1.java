package expo.modules.ui;

import androidx.compose.foundation.pager.PagerState;
import androidx.compose.runtime.MutableIntState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: HorizontalPagerView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "page", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.ui.HorizontalPagerViewKt$HorizontalPagerContent$2$1", f = "HorizontalPagerView.kt", i = {0, 0, 0}, l = {115}, m = "invokeSuspend", n = {"page", "count", "clamped"}, s = {"I$0", "I$1", "I$2"})
final class HorizontalPagerViewKt$HorizontalPagerContent$2$1 extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableIntState $pageCountState;
    final /* synthetic */ PagerState $pagerState;
    final /* synthetic */ CoroutineScope $scope;
    /* synthetic */ int I$0;
    int I$1;
    int I$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HorizontalPagerViewKt$HorizontalPagerContent$2$1(MutableIntState mutableIntState, CoroutineScope coroutineScope, PagerState pagerState, Continuation<? super HorizontalPagerViewKt$HorizontalPagerContent$2$1> continuation) {
        super(2, continuation);
        this.$pageCountState = mutableIntState;
        this.$scope = coroutineScope;
        this.$pagerState = pagerState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        HorizontalPagerViewKt$HorizontalPagerContent$2$1 horizontalPagerViewKt$HorizontalPagerContent$2$1 = new HorizontalPagerViewKt$HorizontalPagerContent$2$1(this.$pageCountState, this.$scope, this.$pagerState, continuation);
        horizontalPagerViewKt$HorizontalPagerContent$2$1.I$0 = ((Number) obj).intValue();
        return horizontalPagerViewKt$HorizontalPagerContent$2$1;
    }

    public final Object invoke(int i, Continuation<? super Unit> continuation) {
        return ((HorizontalPagerViewKt$HorizontalPagerContent$2$1) create(Integer.valueOf(i), continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Integer num, Continuation<? super Unit> continuation) {
        return invoke(num.intValue(), continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        int i = this.I$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            int intValue = this.$pageCountState.getIntValue();
            if (intValue > 0) {
                int iCoerceIn = RangesKt.coerceIn(i, 0, intValue - 1);
                this.I$0 = i;
                this.I$1 = intValue;
                this.I$2 = iCoerceIn;
                this.label = 1;
                if (BuildersKt__Builders_commonKt.launch$default(this.$scope, null, null, new AnonymousClass1(this.$pagerState, iCoerceIn, null), 3, null).join(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: expo.modules.ui.HorizontalPagerViewKt$HorizontalPagerContent$2$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: HorizontalPagerView.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.ui.HorizontalPagerViewKt$HorizontalPagerContent$2$1$1", f = "HorizontalPagerView.kt", i = {}, l = {115}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $clamped;
        final /* synthetic */ PagerState $pagerState;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(PagerState pagerState, int i, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$pagerState = pagerState;
            this.$clamped = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$pagerState, this.$clamped, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (PagerState.animateScrollToPage$default(this.$pagerState, this.$clamped, 0.0f, null, this, 6, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }
}
