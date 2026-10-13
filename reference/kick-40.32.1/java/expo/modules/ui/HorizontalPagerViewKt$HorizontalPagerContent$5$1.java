package expo.modules.ui;

import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.runtime.SnapshotStateKt;
import com.facebook.react.uimanager.ViewProps;
import expo.modules.ui.state.WorkletCallback;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: HorizontalPagerView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.ui.HorizontalPagerViewKt$HorizontalPagerContent$5$1", f = "HorizontalPagerView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class HorizontalPagerViewKt$HorizontalPagerContent$5$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<HorizontalPagerCurrentPageChangeEvent, Unit> $onCurrentPageChange;
    final /* synthetic */ Function1<HorizontalPagerDragInteractionEvent, Unit> $onDragInteraction;
    final /* synthetic */ Function1<HorizontalPagerPageScrollEvent, Unit> $onPageScroll;
    final /* synthetic */ Function1<HorizontalPagerScrollInProgressChangeEvent, Unit> $onScrollInProgressChange;
    final /* synthetic */ Function1<HorizontalPagerSettledPageChangeEvent, Unit> $onSettledPageChange;
    final /* synthetic */ PagerState $pagerState;
    final /* synthetic */ HorizontalPagerProps $props;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    HorizontalPagerViewKt$HorizontalPagerContent$5$1(PagerState pagerState, Function1<? super HorizontalPagerCurrentPageChangeEvent, Unit> function1, Function1<? super HorizontalPagerSettledPageChangeEvent, Unit> function2, HorizontalPagerProps horizontalPagerProps, Function1<? super HorizontalPagerPageScrollEvent, Unit> function3, Function1<? super HorizontalPagerScrollInProgressChangeEvent, Unit> function4, Function1<? super HorizontalPagerDragInteractionEvent, Unit> function5, Continuation<? super HorizontalPagerViewKt$HorizontalPagerContent$5$1> continuation) {
        super(2, continuation);
        this.$pagerState = pagerState;
        this.$onCurrentPageChange = function1;
        this.$onSettledPageChange = function2;
        this.$props = horizontalPagerProps;
        this.$onPageScroll = function3;
        this.$onScrollInProgressChange = function4;
        this.$onDragInteraction = function5;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        HorizontalPagerViewKt$HorizontalPagerContent$5$1 horizontalPagerViewKt$HorizontalPagerContent$5$1 = new HorizontalPagerViewKt$HorizontalPagerContent$5$1(this.$pagerState, this.$onCurrentPageChange, this.$onSettledPageChange, this.$props, this.$onPageScroll, this.$onScrollInProgressChange, this.$onDragInteraction, continuation);
        horizontalPagerViewKt$HorizontalPagerContent$5$1.L$0 = obj;
        return horizontalPagerViewKt$HorizontalPagerContent$5$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HorizontalPagerViewKt$HorizontalPagerContent$5$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: expo.modules.ui.HorizontalPagerViewKt$HorizontalPagerContent$5$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: HorizontalPagerView.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.ui.HorizontalPagerViewKt$HorizontalPagerContent$5$1$1", f = "HorizontalPagerView.kt", i = {}, l = {140}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<HorizontalPagerCurrentPageChangeEvent, Unit> $onCurrentPageChange;
        final /* synthetic */ PagerState $pagerState;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(PagerState pagerState, Function1<? super HorizontalPagerCurrentPageChangeEvent, Unit> function1, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$pagerState = pagerState;
            this.$onCurrentPageChange = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$pagerState, this.$onCurrentPageChange, continuation);
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
                final PagerState pagerState = this.$pagerState;
                Flow flowDrop = FlowKt.drop(SnapshotStateKt.snapshotFlow(new Function0() { // from class: expo.modules.ui.HorizontalPagerViewKt$HorizontalPagerContent$5$1$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Integer.valueOf(pagerState.getCurrentPage());
                    }
                }), 1);
                final Function1<HorizontalPagerCurrentPageChangeEvent, Unit> function1 = this.$onCurrentPageChange;
                this.label = 1;
                if (flowDrop.collect(new FlowCollector() { // from class: expo.modules.ui.HorizontalPagerViewKt.HorizontalPagerContent.5.1.1.2
                    public final Object emit(int i2, Continuation<? super Unit> continuation) {
                        function1.invoke(new HorizontalPagerCurrentPageChangeEvent(i2));
                        return Unit.INSTANCE;
                    }

                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit(((Number) obj2).intValue(), (Continuation<? super Unit>) continuation);
                    }
                }, this) == coroutine_suspended) {
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

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(this.$pagerState, this.$onCurrentPageChange, null), 3, null);
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass2(this.$pagerState, this.$onSettledPageChange, null), 3, null);
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass3(this.$pagerState, this.$props, this.$onPageScroll, null), 3, null);
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass4(this.$pagerState, this.$onScrollInProgressChange, null), 3, null);
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass5(this.$pagerState, this.$onDragInteraction, null), 3, null);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* JADX INFO: renamed from: expo.modules.ui.HorizontalPagerViewKt$HorizontalPagerContent$5$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: HorizontalPagerView.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.ui.HorizontalPagerViewKt$HorizontalPagerContent$5$1$2", f = "HorizontalPagerView.kt", i = {}, l = {145}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<HorizontalPagerSettledPageChangeEvent, Unit> $onSettledPageChange;
        final /* synthetic */ PagerState $pagerState;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(PagerState pagerState, Function1<? super HorizontalPagerSettledPageChangeEvent, Unit> function1, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$pagerState = pagerState;
            this.$onSettledPageChange = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$pagerState, this.$onSettledPageChange, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final PagerState pagerState = this.$pagerState;
                Flow flowDrop = FlowKt.drop(SnapshotStateKt.snapshotFlow(new Function0() { // from class: expo.modules.ui.HorizontalPagerViewKt$HorizontalPagerContent$5$1$2$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Integer.valueOf(pagerState.getSettledPage());
                    }
                }), 1);
                final Function1<HorizontalPagerSettledPageChangeEvent, Unit> function1 = this.$onSettledPageChange;
                this.label = 1;
                if (flowDrop.collect(new FlowCollector() { // from class: expo.modules.ui.HorizontalPagerViewKt.HorizontalPagerContent.5.1.2.2
                    public final Object emit(int i2, Continuation<? super Unit> continuation) {
                        function1.invoke(new HorizontalPagerSettledPageChangeEvent(i2));
                        return Unit.INSTANCE;
                    }

                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit(((Number) obj2).intValue(), (Continuation<? super Unit>) continuation);
                    }
                }, this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: expo.modules.ui.HorizontalPagerViewKt$HorizontalPagerContent$5$1$3, reason: invalid class name */
    /* JADX INFO: compiled from: HorizontalPagerView.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.ui.HorizontalPagerViewKt$HorizontalPagerContent$5$1$3", f = "HorizontalPagerView.kt", i = {}, l = {152}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<HorizontalPagerPageScrollEvent, Unit> $onPageScroll;
        final /* synthetic */ PagerState $pagerState;
        final /* synthetic */ HorizontalPagerProps $props;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass3(PagerState pagerState, HorizontalPagerProps horizontalPagerProps, Function1<? super HorizontalPagerPageScrollEvent, Unit> function1, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$pagerState = pagerState;
            this.$props = horizontalPagerProps;
            this.$onPageScroll = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(this.$pagerState, this.$props, this.$onPageScroll, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final PagerState pagerState = this.$pagerState;
                Flow flowDrop = FlowKt.drop(SnapshotStateKt.snapshotFlow(new Function0() { // from class: expo.modules.ui.HorizontalPagerViewKt$HorizontalPagerContent$5$1$3$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        PagerState pagerState2 = pagerState;
                        return TuplesKt.to(Integer.valueOf(pagerState2.getCurrentPage()), Float.valueOf(pagerState2.getCurrentPageOffsetFraction()));
                    }
                }), 1);
                final HorizontalPagerProps horizontalPagerProps = this.$props;
                final Function1<HorizontalPagerPageScrollEvent, Unit> function1 = this.$onPageScroll;
                this.label = 1;
                if (flowDrop.collect(new FlowCollector() { // from class: expo.modules.ui.HorizontalPagerViewKt.HorizontalPagerContent.5.1.3.2
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((Pair<Integer, Float>) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(Pair<Integer, Float> pair, Continuation<? super Unit> continuation) {
                        int iIntValue = pair.component1().intValue();
                        float fFloatValue = pair.component2().floatValue();
                        WorkletCallback onPageScrollSync = horizontalPagerProps.getOnPageScrollSync();
                        if (onPageScrollSync != null) {
                            onPageScrollSync.invoke(Boxing.boxInt(iIntValue), Boxing.boxFloat(fFloatValue));
                        } else {
                            function1.invoke(new HorizontalPagerPageScrollEvent(iIntValue, fFloatValue));
                        }
                        return Unit.INSTANCE;
                    }
                }, this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: expo.modules.ui.HorizontalPagerViewKt$HorizontalPagerContent$5$1$4, reason: invalid class name */
    /* JADX INFO: compiled from: HorizontalPagerView.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.ui.HorizontalPagerViewKt$HorizontalPagerContent$5$1$4", f = "HorizontalPagerView.kt", i = {}, l = {172}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<HorizontalPagerScrollInProgressChangeEvent, Unit> $onScrollInProgressChange;
        final /* synthetic */ PagerState $pagerState;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass4(PagerState pagerState, Function1<? super HorizontalPagerScrollInProgressChangeEvent, Unit> function1, Continuation<? super AnonymousClass4> continuation) {
            super(2, continuation);
            this.$pagerState = pagerState;
            this.$onScrollInProgressChange = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass4(this.$pagerState, this.$onScrollInProgressChange, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final PagerState pagerState = this.$pagerState;
                Flow flowDrop = FlowKt.drop(SnapshotStateKt.snapshotFlow(new Function0() { // from class: expo.modules.ui.HorizontalPagerViewKt$HorizontalPagerContent$5$1$4$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(pagerState.isScrollInProgress());
                    }
                }), 1);
                final Function1<HorizontalPagerScrollInProgressChangeEvent, Unit> function1 = this.$onScrollInProgressChange;
                this.label = 1;
                if (flowDrop.collect(new FlowCollector() { // from class: expo.modules.ui.HorizontalPagerViewKt.HorizontalPagerContent.5.1.4.2
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit(((Boolean) obj2).booleanValue(), (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(boolean z, Continuation<? super Unit> continuation) {
                        function1.invoke(new HorizontalPagerScrollInProgressChangeEvent(z));
                        return Unit.INSTANCE;
                    }
                }, this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: expo.modules.ui.HorizontalPagerViewKt$HorizontalPagerContent$5$1$5, reason: invalid class name */
    /* JADX INFO: compiled from: HorizontalPagerView.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.ui.HorizontalPagerViewKt$HorizontalPagerContent$5$1$5", f = "HorizontalPagerView.kt", i = {}, l = {177}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<HorizontalPagerDragInteractionEvent, Unit> $onDragInteraction;
        final /* synthetic */ PagerState $pagerState;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass5(PagerState pagerState, Function1<? super HorizontalPagerDragInteractionEvent, Unit> function1, Continuation<? super AnonymousClass5> continuation) {
            super(2, continuation);
            this.$pagerState = pagerState;
            this.$onDragInteraction = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass5(this.$pagerState, this.$onDragInteraction, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow<Interaction> interactions = this.$pagerState.getInteractionSource().getInteractions();
                final Function1<HorizontalPagerDragInteractionEvent, Unit> function1 = this.$onDragInteraction;
                this.label = 1;
                if (interactions.collect(new FlowCollector() { // from class: expo.modules.ui.HorizontalPagerViewKt.HorizontalPagerContent.5.1.5.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((Interaction) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(Interaction interaction, Continuation<? super Unit> continuation) {
                        String str;
                        if (interaction instanceof DragInteraction.Start) {
                            str = ViewProps.START;
                        } else if (interaction instanceof DragInteraction.Stop) {
                            str = "stop";
                        } else {
                            if (!(interaction instanceof DragInteraction.Cancel)) {
                                return Unit.INSTANCE;
                            }
                            str = "cancel";
                        }
                        function1.invoke(new HorizontalPagerDragInteractionEvent(str));
                        return Unit.INSTANCE;
                    }
                }, this) == coroutine_suspended) {
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
