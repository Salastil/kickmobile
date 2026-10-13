package expo.modules.ui;

import android.view.View;
import android.view.ViewGroup;
import androidx.compose.foundation.pager.PagerKt;
import androidx.compose.foundation.pager.PagerScope;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.foundation.pager.PagerStateKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.composer.linkbuffer.GroupFlagsKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.unit.Dp;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.views.AsyncFunctionHandle;
import expo.modules.kotlin.views.ComposeFunctionHolder;
import expo.modules.kotlin.views.FunctionalComposableScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: HorizontalPagerView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0099\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\n2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\n2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010\n2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\nH\u0007¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, d2 = {"HorizontalPagerContent", "", "Lexpo/modules/kotlin/views/FunctionalComposableScope;", "props", "Lexpo/modules/ui/HorizontalPagerProps;", "animateScrollToPage", "Lexpo/modules/kotlin/views/AsyncFunctionHandle;", "", "scrollToPage", "onCurrentPageChange", "Lkotlin/Function1;", "Lexpo/modules/ui/HorizontalPagerCurrentPageChangeEvent;", "onSettledPageChange", "Lexpo/modules/ui/HorizontalPagerSettledPageChangeEvent;", "onPageScroll", "Lexpo/modules/ui/HorizontalPagerPageScrollEvent;", "onScrollInProgressChange", "Lexpo/modules/ui/HorizontalPagerScrollInProgressChangeEvent;", "onDragInteraction", "Lexpo/modules/ui/HorizontalPagerDragInteractionEvent;", "(Lexpo/modules/kotlin/views/FunctionalComposableScope;Lexpo/modules/ui/HorizontalPagerProps;Lexpo/modules/kotlin/views/AsyncFunctionHandle;Lexpo/modules/kotlin/views/AsyncFunctionHandle;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "expo-ui_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class HorizontalPagerViewKt {
    static final Unit HorizontalPagerContent$lambda$11(FunctionalComposableScope functionalComposableScope, HorizontalPagerProps horizontalPagerProps, AsyncFunctionHandle asyncFunctionHandle, AsyncFunctionHandle asyncFunctionHandle2, Function1 function1, Function1 function2, Function1 function3, Function1 function4, Function1 function5, int i, Composer composer, int i2) {
        HorizontalPagerContent(functionalComposableScope, horizontalPagerProps, asyncFunctionHandle, asyncFunctionHandle2, function1, function2, function3, function4, function5, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit HorizontalPagerContent$lambda$8(FunctionalComposableScope functionalComposableScope, HorizontalPagerProps horizontalPagerProps, AsyncFunctionHandle asyncFunctionHandle, AsyncFunctionHandle asyncFunctionHandle2, Function1 function1, Function1 function2, Function1 function3, Function1 function4, Function1 function5, int i, Composer composer, int i2) {
        HorizontalPagerContent(functionalComposableScope, horizontalPagerProps, asyncFunctionHandle, asyncFunctionHandle2, function1, function2, function3, function4, function5, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void HorizontalPagerContent(final FunctionalComposableScope functionalComposableScope, final HorizontalPagerProps props, final AsyncFunctionHandle<Integer> animateScrollToPage, final AsyncFunctionHandle<Integer> scrollToPage, final Function1<? super HorizontalPagerCurrentPageChangeEvent, Unit> onCurrentPageChange, final Function1<? super HorizontalPagerSettledPageChangeEvent, Unit> onSettledPageChange, final Function1<? super HorizontalPagerPageScrollEvent, Unit> onPageScroll, final Function1<? super HorizontalPagerScrollInProgressChangeEvent, Unit> onScrollInProgressChange, final Function1<? super HorizontalPagerDragInteractionEvent, Unit> onDragInteraction, Composer composer, final int i) {
        int i2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function2<? super Composer, ? super Integer, Unit> function2;
        boolean z;
        PagerState pagerState;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Intrinsics.checkNotNullParameter(animateScrollToPage, "animateScrollToPage");
        Intrinsics.checkNotNullParameter(scrollToPage, "scrollToPage");
        Intrinsics.checkNotNullParameter(onCurrentPageChange, "onCurrentPageChange");
        Intrinsics.checkNotNullParameter(onSettledPageChange, "onSettledPageChange");
        Intrinsics.checkNotNullParameter(onPageScroll, "onPageScroll");
        Intrinsics.checkNotNullParameter(onScrollInProgressChange, "onScrollInProgressChange");
        Intrinsics.checkNotNullParameter(onDragInteraction, "onDragInteraction");
        Composer composerStartRestartGroup = composer.startRestartGroup(-710130047);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(HorizontalPagerContent)N(props,animateScrollToPage,scrollToPage,onCurrentPageChange,onSettledPageChange,onPageScroll,onScrollInProgressChange,onDragInteraction)82@3141L41,86@3417L435,86@3394L458,104@4211L27,102@4134L104,105@4253L24,110@4538L198,110@4531L205,118@4760L191,118@4753L198,135@5354L1730,135@5327L1757,192@7224L83,198@7540L60,190@7151L449:HorizontalPagerView.kt#v15e7d");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(functionalComposableScope) : composerStartRestartGroup.changedInstance(functionalComposableScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(props) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= (i & 512) == 0 ? composerStartRestartGroup.changed(animateScrollToPage) : composerStartRestartGroup.changedInstance(animateScrollToPage) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= (i & 4096) == 0 ? composerStartRestartGroup.changed(scrollToPage) : composerStartRestartGroup.changedInstance(scrollToPage) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onCurrentPageChange) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onSettledPageChange) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onPageScroll) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onScrollInProgressChange) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onDragInteraction) ? 67108864 : GroupFlagsKt.HasAuxSlotFlag;
        }
        if (composerStartRestartGroup.shouldExecute((38347923 & i2) != 38347922, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-710130047, i2, -1, "expo.modules.ui.HorizontalPagerContent (HorizontalPagerView.kt:76)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 464855338, "CC(remember):HorizontalPagerView.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotIntStateKt.mutableIntStateOf(functionalComposableScope.getView().getChildCount());
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableIntState mutableIntState = (MutableIntState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposeFunctionHolder<?> view = functionalComposableScope.getView();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 464864564, "CC(remember):HorizontalPagerView.kt#9igjgp");
            boolean z2 = (i2 & 14) == 4 || ((i2 & 8) != 0 && composerStartRestartGroup.changedInstance(functionalComposableScope));
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: expo.modules.ui.HorizontalPagerViewKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return HorizontalPagerViewKt.HorizontalPagerContent$lambda$3$lambda$2(functionalComposableScope, mutableIntState, (DisposableEffectScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.DisposableEffect(view, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue2, composerStartRestartGroup, ComposeFunctionHolder.$stable);
            int iCoerceAtLeast = RangesKt.coerceAtLeast(props.getInitialPage(), 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 464889564, "CC(remember):HorizontalPagerView.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function0() { // from class: expo.modules.ui.HorizontalPagerViewKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Integer.valueOf(mutableIntState.getIntValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i3 = i2;
            PagerState pagerStateRememberPagerState = PagerStateKt.rememberPagerState(iCoerceAtLeast, 0.0f, (Function0) objRememberedValue3, composerStartRestartGroup, 384, 2);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)616@28039L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 464900199, "CC(remember):HorizontalPagerView.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(coroutineScope) | composerStartRestartGroup.changed(pagerStateRememberPagerState);
            HorizontalPagerViewKt$HorizontalPagerContent$2$1 horizontalPagerViewKt$HorizontalPagerContent$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || horizontalPagerViewKt$HorizontalPagerContent$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                horizontalPagerViewKt$HorizontalPagerContent$2$1RememberedValue = new HorizontalPagerViewKt$HorizontalPagerContent$2$1(mutableIntState, coroutineScope, pagerStateRememberPagerState, null);
                composerStartRestartGroup.updateRememberedValue(horizontalPagerViewKt$HorizontalPagerContent$2$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i4 = (i3 << 6) & 896;
            int i5 = AsyncFunctionHandle.$stable | ((i3 >> 6) & 14) | (FunctionalComposableScope.$stable << 6) | i4;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2099440920, "CC(handle)384@13416L29,385@13473L279,385@13450L302:ExpoComposeView.kt#sri11g");
            final State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState((Function2) horizontalPagerViewKt$HorizontalPagerContent$2$1RememberedValue, composerStartRestartGroup, (i5 >> 3) & 14);
            String name = animateScrollToPage.getName();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1071897393, "CC(remember):ExpoComposeView.kt#9igjgp");
            boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(functionalComposableScope) | ((((i5 & 14) ^ 6) > 4 && composerStartRestartGroup.changed(animateScrollToPage)) || (i5 & 6) == 4) | composerStartRestartGroup.changed(stateRememberUpdatedState);
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance2 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: expo.modules.ui.HorizontalPagerViewKt$HorizontalPagerContent$$inlined$handle$1

                    /* JADX INFO: renamed from: expo.modules.ui.HorizontalPagerViewKt$HorizontalPagerContent$$inlined$handle$1$1, reason: invalid class name */
                    /* JADX INFO: compiled from: ExpoComposeView.kt */
                    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0010\u0010\u0002\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0003H\n¨\u0006\u0004"}, d2 = {"<anonymous>", "", "args", "", "expo/modules/kotlin/views/FunctionalComposableScope$handle$1$1$1"}, k = 3, mv = {2, 2, 0}, xi = 48)
                    @DebugMetadata(c = "expo.modules.kotlin.views.FunctionalComposableScope$handle$1$1$1", f = "ExpoComposeView.kt", i = {0, 0}, l = {394}, m = "invokeSuspend", n = {"args", "arg"}, s = {"L$0", "L$1"})
                    public static final class AnonymousClass1 extends SuspendLambda implements Function2<Object[], Continuation<? super Object>, Object> {
                        final /* synthetic */ State $currentHandler;
                        /* synthetic */ Object L$0;
                        Object L$1;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        public AnonymousClass1(State state, Continuation continuation) {
                            super(2, continuation);
                            this.$currentHandler = state;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$currentHandler, continuation);
                            anonymousClass1.L$0 = obj;
                            return anonymousClass1;
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Object invoke(Object[] objArr, Continuation<? super Object> continuation) {
                            return invoke2(objArr, (Continuation<Object>) continuation);
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final Object invoke2(Object[] objArr, Continuation<Object> continuation) {
                            return ((AnonymousClass1) create(objArr, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            Object obj2;
                            Object[] objArr = (Object[]) this.L$0;
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
                            if (objArr.length == 0) {
                                obj2 = Unit.INSTANCE;
                            } else {
                                obj2 = objArr[0];
                            }
                            Function2 function2 = (Function2) this.$currentHandler.getValue();
                            this.L$0 = SpillingKt.nullOutSpilledVariable(objArr);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(obj2);
                            this.label = 1;
                            Object objInvoke = function2.invoke(obj2, this);
                            return objInvoke == coroutine_suspended ? coroutine_suspended : objInvoke;
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                        functionalComposableScope.getView().getFunctionHandlers().put(animateScrollToPage.getName(), new AnonymousClass1(stateRememberUpdatedState, null));
                        final FunctionalComposableScope functionalComposableScope2 = functionalComposableScope;
                        final AsyncFunctionHandle asyncFunctionHandle = animateScrollToPage;
                        return new DisposableEffectResult() { // from class: expo.modules.ui.HorizontalPagerViewKt$HorizontalPagerContent$$inlined$handle$1.2
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                                functionalComposableScope2.getView().getFunctionHandlers().remove(asyncFunctionHandle.getName());
                            }
                        };
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.DisposableEffect(name, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue5, composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 464907296, "CC(remember):HorizontalPagerView.kt#9igjgp");
            boolean zChangedInstance3 = composerStartRestartGroup.changedInstance(coroutineScope) | composerStartRestartGroup.changed(pagerStateRememberPagerState);
            HorizontalPagerViewKt$HorizontalPagerContent$3$1 horizontalPagerViewKt$HorizontalPagerContent$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance3 || horizontalPagerViewKt$HorizontalPagerContent$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                horizontalPagerViewKt$HorizontalPagerContent$3$1RememberedValue = new HorizontalPagerViewKt$HorizontalPagerContent$3$1(mutableIntState, coroutineScope, pagerStateRememberPagerState, null);
                composerStartRestartGroup.updateRememberedValue(horizontalPagerViewKt$HorizontalPagerContent$3$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i6 = AsyncFunctionHandle.$stable | ((i3 >> 9) & 14) | (FunctionalComposableScope.$stable << 6) | i4;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2099440920, "CC(handle)384@13416L29,385@13473L279,385@13450L302:ExpoComposeView.kt#sri11g");
            final State stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState((Function2) horizontalPagerViewKt$HorizontalPagerContent$3$1RememberedValue, composerStartRestartGroup, (i6 >> 3) & 14);
            String name2 = scrollToPage.getName();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1071897393, "CC(remember):ExpoComposeView.kt#9igjgp");
            boolean zChangedInstance4 = composerStartRestartGroup.changedInstance(functionalComposableScope) | ((((i6 & 14) ^ 6) > 4 && composerStartRestartGroup.changed(scrollToPage)) || (i6 & 6) == 4) | composerStartRestartGroup.changed(stateRememberUpdatedState2);
            Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance4 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue6 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: expo.modules.ui.HorizontalPagerViewKt$HorizontalPagerContent$$inlined$handle$2

                    /* JADX INFO: renamed from: expo.modules.ui.HorizontalPagerViewKt$HorizontalPagerContent$$inlined$handle$2$1, reason: invalid class name */
                    /* JADX INFO: compiled from: ExpoComposeView.kt */
                    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0010\u0010\u0002\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0003H\n¨\u0006\u0004"}, d2 = {"<anonymous>", "", "args", "", "expo/modules/kotlin/views/FunctionalComposableScope$handle$1$1$1"}, k = 3, mv = {2, 2, 0}, xi = 48)
                    @DebugMetadata(c = "expo.modules.kotlin.views.FunctionalComposableScope$handle$1$1$1", f = "ExpoComposeView.kt", i = {0, 0}, l = {394}, m = "invokeSuspend", n = {"args", "arg"}, s = {"L$0", "L$1"})
                    public static final class AnonymousClass1 extends SuspendLambda implements Function2<Object[], Continuation<? super Object>, Object> {
                        final /* synthetic */ State $currentHandler;
                        /* synthetic */ Object L$0;
                        Object L$1;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        public AnonymousClass1(State state, Continuation continuation) {
                            super(2, continuation);
                            this.$currentHandler = state;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$currentHandler, continuation);
                            anonymousClass1.L$0 = obj;
                            return anonymousClass1;
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Object invoke(Object[] objArr, Continuation<? super Object> continuation) {
                            return invoke2(objArr, (Continuation<Object>) continuation);
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final Object invoke2(Object[] objArr, Continuation<Object> continuation) {
                            return ((AnonymousClass1) create(objArr, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            Object obj2;
                            Object[] objArr = (Object[]) this.L$0;
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
                            if (objArr.length == 0) {
                                obj2 = Unit.INSTANCE;
                            } else {
                                obj2 = objArr[0];
                            }
                            Function2 function2 = (Function2) this.$currentHandler.getValue();
                            this.L$0 = SpillingKt.nullOutSpilledVariable(objArr);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(obj2);
                            this.label = 1;
                            Object objInvoke = function2.invoke(obj2, this);
                            return objInvoke == coroutine_suspended ? coroutine_suspended : objInvoke;
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                        functionalComposableScope.getView().getFunctionHandlers().put(scrollToPage.getName(), new AnonymousClass1(stateRememberUpdatedState2, null));
                        final FunctionalComposableScope functionalComposableScope2 = functionalComposableScope;
                        final AsyncFunctionHandle asyncFunctionHandle = scrollToPage;
                        return new DisposableEffectResult() { // from class: expo.modules.ui.HorizontalPagerViewKt$HorizontalPagerContent$$inlined$handle$2.2
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                                functionalComposableScope2.getView().getFunctionHandlers().remove(asyncFunctionHandle.getName());
                            }
                        };
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.DisposableEffect(name2, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue6, composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (mutableIntState.getIntValue() == 0) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                } else {
                    function2 = new Function2() { // from class: expo.modules.ui.HorizontalPagerViewKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return HorizontalPagerViewKt.HorizontalPagerContent$lambda$8(functionalComposableScope, props, animateScrollToPage, scrollToPage, onCurrentPageChange, onSettledPageChange, onPageScroll, onScrollInProgressChange, onDragInteraction, i, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                }
            } else {
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 464927843, "CC(remember):HorizontalPagerView.kt#9igjgp");
                boolean zChanged = composerStartRestartGroup.changed(pagerStateRememberPagerState) | ((i3 & 57344) == 16384) | ((i3 & 458752) == 131072) | composerStartRestartGroup.changedInstance(props) | ((i3 & 3670016) == 1048576) | ((i3 & 29360128) == 8388608) | ((i3 & 234881024) == 67108864);
                HorizontalPagerViewKt$HorizontalPagerContent$5$1 horizontalPagerViewKt$HorizontalPagerContent$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged || horizontalPagerViewKt$HorizontalPagerContent$5$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    z = true;
                    pagerState = pagerStateRememberPagerState;
                    horizontalPagerViewKt$HorizontalPagerContent$5$1RememberedValue = new HorizontalPagerViewKt$HorizontalPagerContent$5$1(pagerStateRememberPagerState, onCurrentPageChange, onSettledPageChange, props, onPageScroll, onScrollInProgressChange, onDragInteraction, null);
                    composerStartRestartGroup.updateRememberedValue(horizontalPagerViewKt$HorizontalPagerContent$5$1RememberedValue);
                } else {
                    pagerState = pagerStateRememberPagerState;
                    z = true;
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(pagerState, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) horizontalPagerViewKt$HorizontalPagerContent$5$1RememberedValue, composerStartRestartGroup, 0);
                PagerState pagerState2 = pagerState;
                PagerKt.m2626HorizontalPager8jOkeI(pagerState2, ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, AppContext.$stable << 3), PaddingValuesExtensionKt.toPaddingValues(props.getContentPadding()), null, props.getBeyondViewportPageCount(), Dp.m10168constructorimpl(props.getPageSpacing()), null, null, props.getUserScrollEnabled(), props.getReverseLayout(), null, null, null, null, ComposableLambdaKt.rememberComposableLambda(-2130499616, z, new Function4() { // from class: expo.modules.ui.HorizontalPagerViewKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return HorizontalPagerViewKt.HorizontalPagerContent$lambda$10(functionalComposableScope, (PagerScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 0, 24576, 15560);
                composerStartRestartGroup = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            scopeUpdateScopeEndRestartGroup.updateScope(function2);
        }
        composerStartRestartGroup.skipToGroupEnd();
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            function2 = new Function2() { // from class: expo.modules.ui.HorizontalPagerViewKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return HorizontalPagerViewKt.HorizontalPagerContent$lambda$11(functionalComposableScope, props, animateScrollToPage, scrollToPage, onCurrentPageChange, onSettledPageChange, onPageScroll, onScrollInProgressChange, onDragInteraction, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            };
            scopeUpdateScopeEndRestartGroup.updateScope(function2);
        }
    }

    static final DisposableEffectResult HorizontalPagerContent$lambda$3$lambda$2(final FunctionalComposableScope functionalComposableScope, final MutableIntState mutableIntState, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        functionalComposableScope.getView().setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() { // from class: expo.modules.ui.HorizontalPagerViewKt$HorizontalPagerContent$1$1$1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View parent, View child) {
                mutableIntState.setIntValue(functionalComposableScope.getView().getChildCount());
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View parent, View child) {
                mutableIntState.setIntValue(functionalComposableScope.getView().getChildCount());
            }
        });
        mutableIntState.setIntValue(functionalComposableScope.getView().getChildCount());
        return new DisposableEffectResult() { // from class: expo.modules.ui.HorizontalPagerViewKt$HorizontalPagerContent$lambda$3$lambda$2$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                functionalComposableScope.getView().setOnHierarchyChangeListener(null);
            }
        };
    }

    static final Unit HorizontalPagerContent$lambda$10(FunctionalComposableScope functionalComposableScope, PagerScope HorizontalPager, int i, Composer composer, int i2) {
        Intrinsics.checkNotNullParameter(HorizontalPager, "$this$HorizontalPager");
        ComposerKt.sourceInformation(composer, "CN(pageIndex)199@7559L37:HorizontalPagerView.kt#v15e7d");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2130499616, i2, -1, "expo.modules.ui.HorizontalPagerContent.<anonymous> (HorizontalPagerView.kt:199)");
        }
        functionalComposableScope.Child(new UIComposableScope(null, null, null, null, 15, null), i, composer, (i2 & 112) | (FunctionalComposableScope.$stable << 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }
}
